package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.WaitInductionInfo;
import cn.edu.cqust.bean.vo.QoUpdateSignUp;
import cn.edu.cqust.bean.vo.QoUpdateWaitInduction;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.bean.vo.RoWaitInduction;

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
    Integer updateSignUpInfoAndRelated(QoUpdateWaitInduction qoUpdateWaitInduction);


    /**
     * @desc 插入; 同时interview_info.state=1, note=通过;
     *       wait_induction_info.state=0, interviewQualifiedTime = getYMD, state = '入职'
     * @param waitInductionInfo 插入对象(customerId, phoneCallListId, employeeId)
     * @param id interviewInfo的id
     * @return 操作状态
     */
    Integer addWaitInduction(WaitInductionInfo waitInductionInfo, Integer id);

}
