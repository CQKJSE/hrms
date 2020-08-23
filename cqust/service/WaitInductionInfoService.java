package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.WaitInductionInfo;
import cn.edu.cqust.bean.vo.*;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-12 10:44
 * @desc:
 **/
public interface WaitInductionInfoService {

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param pageNumber 查询的起始位置
     * @param employeePhone session中业务员的电话
     * @return 结果列表
     */
    List<RoWaitInduction> findByMC1(CustomerInfo customerInfo,
                                    Integer pageNumber,
                                    String employeePhone);

    /**
     * @desc 多条件查询1, 统计结果条数
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeePhone session中业务员的电话
     * @return 结果数量
     */
    Integer countByMC1(CustomerInfo customerInfo,
                       String employeePhone);

    /**
     * @desc 根据wait_induction_info的标识id, 修改该表以及两个外键关联表
     * @param qoUpdateWaitInduction 封装的查询对象
     * @return 操作状态
     */
    Integer updateAndRelated1(QoUpdateWaitInduction qoUpdateWaitInduction);


    /**
     * @desc 插入; 同时interview_info.state=1, note=通过;
     *       wait_induction_info.state=0, interviewQualifiedTime = getYMD, state = '入职'
     * @param waitInductionInfo 插入对象(customerId, phoneCallListId, employeeId)
     * @param id interviewInfo的id
     * @return 操作状态
     */
    Integer addWaitInduction(WaitInductionInfo waitInductionInfo, Integer id);

    /**
     * @desc 多条件查询2
     * @param qo 混合查询参数
     * @param pageNumber 查询的起始位置
     * @return 结果列表
     */
    List<RoWaitInduction> findByMC2(QoWaitInductionAll qo, Integer pageNumber);

    /**
     * @desc 多条件查询2, 统计结果条数
     * @param qo 混合查询参数
     * @return 结果数量
     */
    Integer countByMC2(QoWaitInductionAll qo);

    /**
     * @desc customerId（客户信息id）,phoneCallListId(电话名单id),employeeId(招聘部id),delayTime（延期入职时间）
     * 	     添加到wait_induction_info表，同时后端将interview_info表中state（状态）
     * 	     改为1，note（备注）改为通过，将wait_induction_info表中的stateOne（状态）
     * 	     置为0，获取 通过时间存入interviewQualifiedTime	（面试合格时间），
     * 	     将state（入职状态）置为待入职
     * @param waitInductionInfo 插入对象(customerId, phoneCallListId, employeeId)
     * @return 操作状态
     */
    Integer addDelay(WaitInductionInfo waitInductionInfo);


    /**
     * @desc 将wait_induction_info表中的这条id（待入职名单标识id）数据的state（状态）
     *       改为1，将前端请求数据note（备注）填入这条id（待入职名单标识id）数据中的note（备注），
     *       同时将customer_info表中的state（状态）改为0
     * @param waitInductionInfo 待操作对象
     * @return 操作状态
     */
    Integer backWaitInduction(WaitInductionInfo waitInductionInfo);

    /**
     * @desc 修改, 及外键关联对象(组长)
     * @param qo 混合字段对象
     * @return 操作状态
     */
    Integer updateAndRelated2(QoUpdateWaitInductionGroup qo);

    /**
     * @desc 多条件查询3
     * @param customerInfo 3个字段:name, idNumber, phoneNumber
     * @param pageNumber 查询的起始页码
     * @param employeeName 查询参数
     * @param deptName session中的部门名
     * @return 结果列表
     */
    List<RoWaitInductionGroup> findByMC3(CustomerInfo customerInfo,
                                         Integer pageNumber,
                                         String deptName,
                                         String employeeName);

    /**
     * @desc 多条件查询3, 统计结果条数
     * @param customerInfo 3个字段:name, idNumber, phoneNumber
     * @param employeeName 查询参数
     * @param deptName session中的部门名
     * @return 结果数量
     */
    Integer countByMC3(CustomerInfo customerInfo,
                       String deptName,
                       String employeeName);

}
