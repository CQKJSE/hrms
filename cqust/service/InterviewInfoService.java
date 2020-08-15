package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.InterviewInfo;
import cn.edu.cqust.bean.vo.RoInterviewListAll;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.bean.vo.RoSignUpListAll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-11 15:32
 * @desc:
 **/
public interface InterviewInfoService {

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param pageNumber 查询的起始位置
     * @param employeePhone session中业务员的电话
     * @return 结果列表
     */
    List<RoSignUpList> findByMC1(CustomerInfo customerInfo,
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
     * @desc 插入数据state=0, 并将关联sign_up_info的state=1、note=0,
     * @param interviewInfo 待插入对象
     * @return 操作状态
     */
    Integer addInterview(InterviewInfo interviewInfo);



    /**
     * @desc 多条件查询2
     * @param customerInfo 5个字段:name, idNumber, phoneNumber, gender, address
     * @param recommendEnterprise~employeeName 其它查询条件
     * @param pageNumber 查询的起始位置
     * @return 结果列表
     */
    List<RoInterviewListAll> findByMC2(CustomerInfo customerInfo,
                                       String recommendEnterprise,
                                       String interviewTime,
                                       String deptName,
                                       String employeeName,
                                       Integer pageNumber);

    /**
     * @desc 多条件查询2, 统计结果条数
     * @param customerInfo 5个字段:name, idNumber, phoneNumber, gender, address
     * @param recommendEnterprise~employeeName 其它查询条件
     * @return 结果数量
     */
    Integer countByMC2(CustomerInfo customerInfo,
                       String recommendEnterprise,
                       String interviewTime,
                       String deptName,
                       String employeeName);

    /**
     * @desc
     * @param
     * @return
     */
    Integer backInterview(InterviewInfo interviewInfo);


}
