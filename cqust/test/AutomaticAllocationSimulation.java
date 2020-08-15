package cn.edu.cqust.test;

import org.junit.jupiter.api.*;
import java.util.*;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-06 20:42
 * @desc: 自动分配模拟
 **/
public class AutomaticAllocationSimulation {
    //每个业务员分配的数量
    private static final int numPerPerson = 20;
    //符合条件的customer数量(state = 0)
    private static final int numCustomer = 1000;
    //employee中业务员数量
    private static final int numSalesman = 15;
    //employee中组长数量
    private static final int numSalesmanLeader = 0;
    //需分配的总数
    private static final int numAllocation = (numSalesman + numSalesmanLeader) * numPerPerson;
    //旧数据量
    private static final int numOldPhoneCallList = 100;
    //测试次数
    private static final int testRound = 10;


    @RepeatedTest(testRound)
    @DisplayName("结果按employeeId排序")
    public void test1() {
        Map<Integer, Integer> result = simulationAllocation(false);
        Assertions.assertEquals(numAllocation, result.size());
    }

    @RepeatedTest(testRound)
    @DisplayName("结果按customerId排序")
    public void test2() {
        Map<Integer, Integer> result = simulationAllocation(true);
        Assertions.assertEquals(numAllocation, result.size());
    }

    /**
     * @desc 模拟分配算法
     * @return void
     */
    private Map<Integer, Integer> simulationAllocation(boolean orderByCustomerId) {
        //最终插入数据库的数据(K:customerId, V:employeeId)
        Map<Integer, Integer> additionalPhoneCallList;
        if (orderByCustomerId)
            additionalPhoneCallList = new TreeMap<>();
        else
            additionalPhoneCallList = new LinkedHashMap<>();

        //所有符合条件的customer_info
        Set<Integer> customers = simulateCustomer();
        //所有业务员+组长
        Set<Integer> employees = simulateEmployee();
        //查询phone_call_list的所有旧数据(用于放入结果映射时比对)
        Map<Integer, Integer> oldPhoneCallList = simulateOldPhoneCallList();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("模拟的旧数据:");
        System.out.println(oldPhoneCallList);

        int numOfRuns = 0;
        int notExistCustomer = 0;
        int repetitionInResult = 0;
        int repetitionInOld = 0;

        //开始执行分配
        for (Integer employee : employees) {
            int tempEmployeeId = employee;
            int count = 0;
            while (count != numPerPerson) {
                //此处如果randomCustomerId = 0 或 = numCustomer, 即为不存在的用户
                int randomCustomerId = getRandomNumber(getCustomerInfoMaxId());
                Integer oldEmployeeId = oldPhoneCallList.get(randomCustomerId);
                oldEmployeeId = (oldEmployeeId == null ? -1 : oldEmployeeId);

                /* 三个添加条件 */
                //存在该客户
                boolean isExistCustomer = customers.contains(randomCustomerId);
                //分配结果不重复
                boolean noRepetitionInAdditional = !additionalPhoneCallList.containsKey(randomCustomerId);
                //在旧名单内两键唯一
                boolean noRepetitionInOld = !(oldPhoneCallList.containsKey(randomCustomerId) && oldEmployeeId == tempEmployeeId);

                if (!isExistCustomer) {
                    notExistCustomer++;
                }
                if (!noRepetitionInAdditional) {
                    repetitionInResult++;
                }
                if (!noRepetitionInOld) {
                    repetitionInOld++;
                }

                if (isExistCustomer && noRepetitionInAdditional && noRepetitionInOld) {
                    additionalPhoneCallList.put(randomCustomerId, tempEmployeeId);
                    count++;
                }
                numOfRuns++;
            }
        }
        System.out.println("分配结果:");
        System.out.println(additionalPhoneCallList);
        System.out.println("总运行次数: " + numOfRuns);
        System.out.println("公海不存在的客户: " + notExistCustomer);
        System.out.println("在分配结果中重复: " + repetitionInResult);
        System.out.println("旧数据中两键重复: " + repetitionInOld);
        System.out.println("--------------------------------------------------------------------------------------------");
        return additionalPhoneCallList;
    }


    /**
     * @desc 模拟从customer_info中查询的数据(state = 0)
     * @return List
     */
    private static Set<Integer> simulateCustomer() {
        Set<Integer> res = new HashSet<>();
        for (int i = 1; i < numCustomer; i++) {
            res.add(i);
        }
        return res;
    }

    /**
     * @desc 模拟从employee表中查询所有 业务员+组长
     * @return List
     */
    private static Set<Integer> simulateEmployee() {
        Set<Integer> res = new HashSet<>();
        for (int i = 1; i <= numSalesman; i++) {
            res.add(i);
        }
        for (int i = numSalesman + 1; i <= numSalesman + numSalesmanLeader; i++) {
            res.add(i);
        }
        return res;
    }


    /**
     * @desc 模拟从phone_call_list中查询以前的数据(addedTime < currentTime)
     * @return List
     */
    private static Map<Integer, Integer> simulateOldPhoneCallList() {
        Map<Integer, Integer> oldPhoneCallList = new LinkedHashMap<>();
        for (int i = 1; i <= numOldPhoneCallList; i++) {
            oldPhoneCallList.put(getRandomNumber(numCustomer),
                    getRandomNumber(numSalesmanLeader + numSalesman));
        }
        return oldPhoneCallList;
    }


    /**
     * @desc 模拟从customer_info获取最大id
     * @return int
     */
    private static int getCustomerInfoMaxId() {
        return numCustomer;
    }


    /**
     * @desc 生成随机数
     * @param upperLimit 随机数上限
     * @return 范围[0, upperLimit]
     */
    private static int getRandomNumber(int upperLimit) {
        return new Random().nextInt(upperLimit + 1);
    }


    /*************************************************************
     *                  运行时间/初始化、销毁(junit5)
     *************************************************************/
    private static long sTime;

    @BeforeAll
    @DisplayName("开始时间/")
    public static void start() {
        sTime = System.currentTimeMillis();
    }

    @AfterAll
    @DisplayName("结束时间/")
    public static void end() {
        long eTime = System.currentTimeMillis();
        System.out.println("耗时: " + (eTime - sTime) + "ms");
    }
}
