package cn.edu.cqust.util;

import cn.edu.cqust.bean.PhoneCallList;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.EmployeeDao;
import cn.edu.cqust.dao.PhoneCallListDao;
import cn.edu.cqust.dao.SystemSettingsDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-08 10:50
 * @desc: 自动分配
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
 * 四.数据库插入:
 *      (1) 将生产的结果封装到bean
 *      (2) 插入数据库
 *
 **/
@Component
public class Allocator {
    //每个业务员分配的数量
    private static int numPerPerson;
    //需分配的employee总数
    private static int numTargetEmployee;
    //运行次数上限
    private static int allocateRoundLimit;
    //customer最大id
    private static int customerMaxId;
    //customer总数
    //private static int numOfCustomer;
    //最终需要分配的数据量
    private static int totalOfAllocation;


    private int numOfRuns;
    private int notExistCustomer;
    private int repetitionInAdditionalOfCid;
    private int repetitionAfterTimeLimitOfCid;
    private int repetitionOfTwoKeys;

    //所有客户 <customerId>
    private Set<Integer> customers;
    //所有业务员+组长 <employeeId>
    private Set<Integer> employees;
    //算法生成的结果 <customerId, employeeId>
    private Map<Integer, Integer> additionalPcl;
    //查询phone_call_list的所有5天内的数据 <customerId, employeeId>
    private Map<Integer, Integer> pclAfterTimeLimit;
    //查询phone_call_list的所有数据 <data index, (customerId+employeeId).String>
    private Map<Integer, String> pclAll;

    //分配成功与否
    private boolean allocationSuccess;

    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private PhoneCallListDao phoneCallListDao;
    @Resource
    private CustomerInfoDao customerInfoDao;
    @Resource
    private SystemSettingsDao systemSettingsDao;


    /**
     * @desc 从数据库中查询分配所需的数据, 并初始化变量
     * @return void
     */
    public void initData() {
        //所有符合条件的customer_info的id
        customers = new HashSet<>(customerInfoDao.findIdByState("0"));
        //所有业务员+组长的id
        employees = new HashSet<>(employeeDao.findIdByPositions(new String[]{"组长", "业务员"}));
        //phone_call_list的5天内数据(用于判断cid在5天内重复与否)
        pclAfterTimeLimit = phoneCallListDao.findAfterSystemTimeLimit()
                .stream()
                .collect(Collectors.toMap(
                        PhoneCallList::getCustomerId,
                        PhoneCallList::getEmployeeId,
                        (Integer k1, Integer k2) -> k2)
                );
        pclAll = PclToCompareMap(phoneCallListDao.findAll());
        additionalPcl = new LinkedHashMap<>();

        numPerPerson = systemSettingsDao.findAllocationCount();
        numTargetEmployee = employees.size();
        //numOfCustomer = customerInfoDao.count();
        totalOfAllocation = numPerPerson * numTargetEmployee;
        allocateRoundLimit = totalOfAllocation * 20;
        customerMaxId = customerInfoDao.findMaxId();

        numOfRuns = 0;
        notExistCustomer = 0;
        repetitionInAdditionalOfCid = 0;
        repetitionAfterTimeLimitOfCid = 0;
        repetitionOfTwoKeys = 0;
        allocationSuccess = false;
    }


    /**
     * @desc 分配算法: 为所有人分配
     * @return void
     */
    public void allocateAll() {
        if (doAllocation(numPerPerson)) {
            allocationSuccess = true;
        }
    }

    /**
     * @desc 分配算法: 为当前登录的业务员分配
     * @param phone 当前登录的人的电话(用于查找对应的id)
     * @return void
     */
    public void allocateOne(String phone) {
        employees = tempEmployeeToSet(phone);
        if (doAllocation(1)) {
            allocationSuccess = true;
        }
    }

    /**
     * @desc 分配算法: 为当前登录的业务员分配, 且分配的customer的addTime在90天内
     * @param phone 当前登录的人的电话(用于查找对应的id)
     * @return void
     */
    public void allocateOneAfterTimeLimit(String phone) {
        employees = tempEmployeeToSet(phone);
        customers = customerAfterTimeLimitToSet();
        if (doAllocation(1)) {
            allocationSuccess = true;
        }
    }

    /**
     * @desc 执行分配算法
     * @return true ---> 成功(执行数据库插入)
     *         false --> 失败(不执行数据库插入)
     */
    private boolean doAllocation(int numPerPerson) {
        for (Integer employeeId : employees) {
            int tempEid = employeeId;
            int count = 0;
            while (count != numPerPerson) {
                int randomCid = Generator.genRandomNumber(customerMaxId);

                //存在该客户
                boolean isExistCustomer = customers.contains(randomCid);
                //分配结果中不重复
                boolean noRepetitionInAdditionalOfCid = !additionalPcl.containsKey(randomCid);
                //在5天内cid唯一
                boolean noRepetitionAfterTimeLimitOfCid = !pclAfterTimeLimit.containsKey(randomCid);
                //在所有数据内两键唯一
                boolean noRepetitionOfTwoKeys = !pclAll.containsValue(randomCid + "_" + tempEid);

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
                    additionalPcl.put(randomCid, tempEid);
                    count++;
                }
                if (numOfRuns++ > allocateRoundLimit) {
                    allocationSuccess = false;
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @desc 插入分配结果, 并更新customer_info的state为1
     * @return void
     */
    public void insertResult() {
        if (allocationSuccess) {
            String ymd = DateUtil.getYMD();
            for (Map.Entry<Integer, Integer> entry : additionalPcl.entrySet()) {
                Integer cid = entry.getKey();
                Integer eid = entry.getValue();
                PhoneCallList newPcl = new PhoneCallList();
                newPcl.setAddedTime(ymd);
                newPcl.setCustomerId(cid);
                newPcl.setEmployeeId(eid);
                phoneCallListDao.insert(newPcl);
            }
        }
    }


    /**
     * @desc 执行分配, 打印查询的数据
     * @return void
     */
    public void printData() {
        System.out.println("--------------------------------------------数据打印----------------------------------------------");
        System.out.println("<cid> 满足条件的customer");
        System.out.println(customers);
        System.out.println("\n<eid> 业务员+组长");
        System.out.println(employees);
        System.out.println("\n<cid, eid> pcl中5天内的数据");
        System.out.println(pclAfterTimeLimit);
        System.out.println("\n<index, cid+eid> pcl中所有的数据");
        pclAll.forEach((k, v) -> System.out.print(k + ":" + v.replace("_", "=") + " "));
        System.out.println("\n\n<cid, eid> 最终分配结果");
        System.out.println(additionalPcl);
        System.out.println("\n-------------------------------------------分配结果统计-------------------------------------------");
        System.out.println("公海不存在的客户: " + notExistCustomer);
        System.out.println("分配结果中重复  : " + repetitionInAdditionalOfCid);
        System.out.println("5天内cid重复    : " + repetitionAfterTimeLimitOfCid);
        System.out.println("所有数据两键重复: " + repetitionOfTwoKeys);
        System.out.println("次数限制: " + allocateRoundLimit);
        System.out.println("运行次数: " + numOfRuns);
        System.out.println("无效分配: " + (notExistCustomer + repetitionInAdditionalOfCid + repetitionAfterTimeLimitOfCid + repetitionOfTwoKeys));
        System.out.println("结果大小: " + additionalPcl.size());
        System.out.println("分配成功: " + allocationSuccess);
    }


    /**
     * @desc 获取分配成功与否
     * @return 成功--->true
     *         失败--->false
     */
    public boolean getAllocationState() {
        return this.allocationSuccess;
    }


    /**
     * @desc 获取当前employee (单个分配)
     * @param phone 当前登录的人的电话(用于查找对应的id)
     * @return 仅包含一个当前的eid的集合
     */
    private Set<Integer> tempEmployeeToSet(String phone) {
        Set<Integer> currentEmp = new HashSet<>();
        currentEmp.add(employeeDao.findByPhone(phone).getId());
        return currentEmp;
    }

    /**
     * @desc 查询addTime>90的customer
     * @return 满足条件的cid的集合
     */
    private Set<Integer> customerAfterTimeLimitToSet() {
        return new HashSet<>(customerInfoDao.findByStateAndAfterTimeLimit("0"));
    }


    /**
     * @desc 将pcl转为<索引, cid_eid>形式, 在分配时做两键重复的判断条件
     * @param list 待转换列表
     * @return 转换后的结果
     */
    public static Map<Integer, String> PclToCompareMap(List<PhoneCallList> list) {
        Map<Integer, String> res = new HashMap<>();
        int index = 1;
        for (PhoneCallList pcl : list) {
            Integer cid = pcl.getCustomerId();
            Integer eid = pcl.getEmployeeId();
            res.put(index++, cid + "_" + eid);
        }
        return res;
    }

}
