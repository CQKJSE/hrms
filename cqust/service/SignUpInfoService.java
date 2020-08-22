package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.SignUpInfo;
import cn.edu.cqust.bean.vo.QoUpdateSignUp;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.bean.vo.RoSignUpListAll;
import cn.edu.cqust.bean.vo.RoSignUpListGroup;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-10 15:27
 * @desc:
 **/
public interface SignUpInfoService {

    /**
     * @desc 插入数据并修改customer_info(to 1)和sign_up_info(to 0)的state字段
     * @param signUpInfo 需要插入的数据
     * @return 操作状态
     */
    Integer signUp(SignUpInfo signUpInfo);

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param pageNumber 查询的起始页码
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
     * @desc 根据sign_up_info的标识id, 修改该表以及两个外键关联表
     * @param qoUpdateSignUp 封装的查询对象
     * @return 操作状态
     */
    Integer updateSignUpInfoAndRelated(QoUpdateSignUp qoUpdateSignUp);


    /**
     * @desc 多条件查询2
     * @param customerInfo 5个字段:name, idNumber, phoneNumber, gender, address
     * @param pageNumber 查询的起始页码
     * @return 结果列表
     */
    List<RoSignUpListAll> findByMC2(CustomerInfo customerInfo,
                                    Integer pageNumber);

    /**
     * @desc 多条件查询2, 统计结果条数
     * @param customerInfo 5个字段:name, idNumber, phoneNumber, gender, address
     * @return 结果数量
     */
    Integer countByMC2(CustomerInfo customerInfo);


    /**
     * @desc 将sign_up_info中state=1,note=?; 关联的customer_info的state=0
     * @param signUpInfo 待修改对象
     * @return 操作状态
     */
    Integer backSignUp(SignUpInfo signUpInfo);

    /**
     * @desc 多条件查询3
     * @param customerInfo 3个字段:name, idNumber, phoneNumber
     * @param pageNumber 查询的起始页码
     * @param employeeName 查询参数
     * @param deptName session中的部门名
     * @return 结果列表
     */
    List<RoSignUpListGroup> findByMC3(CustomerInfo customerInfo,
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
