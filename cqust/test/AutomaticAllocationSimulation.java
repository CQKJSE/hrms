package cn.edu.cqust.test;

import org.junit.jupiter.api.*;

import java.util.*;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-06 20:42
 * @desc: 自动分配模拟
 *
 * 一.分配对象概述:
 *      (1) customer_info中, 所有state = 0的数据 (记为a)
 *      (2) employee中, 业务员 + 组长 (记为b)
 *
 * 二.分配条件概述:
 *      (1) phone_call_list, 5天内customerId不重复
 *      (2) phone_call_list, 所有数据中两键不重复
 *
 * 三.分配算法约束:
 *      (1) 分配过程中, 随机生成的cid在a中存在
 *      (2) 在算法生成的分配结果中, cid唯一
 *      (3) 在phone_call_list5天内的旧数据中, cid唯一
 *      (4) 在phone_call_list所有数据中, 两键唯一
 *
 *
 **/
public class AutomaticAllocationSimulation {
    //每个业务员分配的数量
    static final int numPerPerson = 20;
    //符合条件的customer数量(state = 0)
    static final int numCustomer = 1000;
    //employee中业务员数量
    static final int numSalesman = 15;
    //employee中组长数量
    static final int numSalesmanLeader = 5;
    //需分配的总数
    public static final int numAllocation = (numSalesman + numSalesmanLeader) * numPerPerson;
    //旧数据量
    static final int numOldPhoneCallList = 100;

    //所有客户 <customerId>
    static Set<Integer> customers;
    //所有业务员+组长 <employeeId>
    static Set<Integer> employees;
    //查询phone_call_list的所有5天内的数据 <customerId, employeeId>
    static Map<Integer, Integer> pclAfterTimeLimit;
    //查询phone_call_list的所有数据 <data index, (customerId+employeeId).String>
    static Map<Integer, String> pclAll;


    /**
     * @desc 模拟分配算法
     * @return void
     */
    public Map<Integer, Integer> simulationAllocation(boolean orderByCustomerId) {
        //最终插入数据库的数据(K:customerId, V:employeeId)
        Map<Integer, Integer> additionalPhoneCallList;
        if (orderByCustomerId)
            additionalPhoneCallList = new TreeMap<>();
        else
            additionalPhoneCallList = new LinkedHashMap<>();
        customers = simulateCustomer();
        employees = simulateEmployee();
        pclAfterTimeLimit = simulatePclAfterTimeLimit();
        pclAll = simulatePclAll();

        printSimulatedData();

        int numOfRuns = 0;
        int notExistCustomer = 0;
        int repetitionInAdditionalOfCid = 0;
        int repetitionAfterTimeLimitOfCid = 0;
        int repetitionOfTwoKeys = 0;

        //开始执行分配
        for (Integer employee : employees) {
            int tempEid = employee;
            int count = 0;
            while (count != numPerPerson) {
                numOfRuns++;
                int randomCid = getRandomNumber(getCustomerInfoMaxId()) + numCustomer / 20;

                //存在该客户
                boolean isExistCustomer = customers.contains(randomCid);
                //分配结果中不重复
                boolean noRepetitionInAdditionalOfCid = !additionalPhoneCallList.containsKey(randomCid);
                //在5天内cid唯一
                boolean noRepetitionAfterTimeLimitOfCid = !pclAfterTimeLimit.containsKey(randomCid);
                //在所有数据内两键唯一
                boolean noRepetitionOfTwoKeys = !pclAll.containsValue(randomCid + "=" + tempEid);

                if (!isExistCustomer) {
                    notExistCustomer++;
                }
                if (!noRepetitionInAdditionalOfCid) {
                    repetitionInAdditionalOfCid++;
                }
                if (!noRepetitionAfterTimeLimitOfCid) {
                    repetitionAfterTimeLimitOfCid++;
                }
                if (!noRepetitionOfTwoKeys) {
                    repetitionOfTwoKeys++;
                }

                if (isExistCustomer && noRepetitionInAdditionalOfCid
                        && noRepetitionAfterTimeLimitOfCid && noRepetitionOfTwoKeys) {
                    additionalPhoneCallList.put(randomCid, tempEid);
                    count++;
                }
            }
        }
        System.out.println("\n分配结果________________________________________________________________________________");
        System.out.println(additionalPhoneCallList);
        System.out.println("公海不存在的客户: " + notExistCustomer);
        System.out.println("在分配结果中重复: " + repetitionInAdditionalOfCid);
        System.out.println("5天内数据cid重复: " + repetitionAfterTimeLimitOfCid);
        System.out.println("所有数据两键重复: " + repetitionOfTwoKeys);
        System.out.println("运行次数: " + numOfRuns);
        System.out.println("无效分配: " + (notExistCustomer+ repetitionInAdditionalOfCid + repetitionAfterTimeLimitOfCid + repetitionOfTwoKeys));
        System.out.println("结果大小: " + additionalPhoneCallList.size());
        return additionalPhoneCallList;
    }

    /**
     * @desc 打印模拟的4组数据
     * @return void
     */
    private void printSimulatedData() {
        System.out.println("--------------------------------------------------------------------------------------------");
        /*System.out.println("模拟customer____________________________________________________________________________");
        System.out.println(customers);
        System.out.println("模拟employee____________________________________________________________________________");
        System.out.println(employees);*/
        System.out.println("模拟5天内数据___________________________________________________________________________");
        System.out.println(pclAfterTimeLimit);
        System.out.println("模拟所有的两键__________________________________________________________________________");
        pclAll.forEach((o1, o2) -> System.out.print(o1 + ":" + o2 + ", "));
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
     * @desc 模拟从phone_call_list中查询5天前的数据(addedTime > currentTime - 5)
     *       (判断条件1: 5天内customerId不重复)
     * @return List
     */
    private static Map<Integer, Integer> simulatePclAfterTimeLimit() {
        Map<Integer, Integer> oldPhoneCallList = new LinkedHashMap<>();
        for (int i = 1; i <= numOldPhoneCallList; i++) {
            oldPhoneCallList.put(getRandomNumber(numCustomer),
                    getRandomNumber(numSalesmanLeader + numSalesman));
        }
        return oldPhoneCallList;
    }


    /**
     * @desc 模拟从phone_call_list中查询所有的数据
     *       (判断条件2: 所有数据中两键不重复)
     * @return List
     */
    private static Map<Integer, String> simulatePclAll() {
        Map<Integer, String> pclAll = new LinkedHashMap<>();
        for (int i = 1; i <= numOldPhoneCallList; i++) {
            int ranCID = getRandomNumber(numCustomer);
            int ranEID = getRandomNumber(numSalesman + numSalesmanLeader);
            String Cid_Eid = ranCID + "=" + ranEID;
            pclAll.put(i, Cid_Eid);
        }
        return pclAll;
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
     * @return 范围[1, upperLimit]
     */
    private static int getRandomNumber(int upperLimit) {
        return new Random().nextInt(upperLimit) + 1;
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
