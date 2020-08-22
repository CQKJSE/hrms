package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.InterviewInfo;
import cn.edu.cqust.bean.vo.RoInterviewList;
import cn.edu.cqust.bean.vo.RoInterviewListAll;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.bean.vo.RoSignUpListGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-11 15:26
 * @desc:
 **/
@Mapper
@Component
public interface InterviewInfoDao {

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param startIndex 查询的起始位置
     * @param employeePhone session中业务员的电话
     * @return 结果列表
     */
    List<RoSignUpList> findByMC1(@Param("customerInfo") CustomerInfo customerInfo,
                                 @Param("startIndex") Integer startIndex,
                                 @Param("employeePhone") String employeePhone);

    /**
     * @desc 多条件查询1, 统计结果条数
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeePhone session中业务员的电话
     * @return 结果数量
     */
    Integer countByMC1(@Param("customerInfo") CustomerInfo customerInfo,
                       @Param("employeePhone") String employeePhone);


    /**
     * @desc 插入
     * @param interviewInfo 待插入对象
     * @return 操作状态
     */
    Integer insert(InterviewInfo interviewInfo);


    /**
     * @desc 多条件查询2
     * @param customerInfo 5个字段:name, idNumber, phoneNumber, gender, address
     * @param recommendEnterprise~employeeName 其它查询条件
     * @param startIndex 查询的起始位置
     * @return 结果列表
     */
    List<RoInterviewListAll> findByMC2(@Param("customerInfo") CustomerInfo customerInfo,
                                       @Param("recommendEnterprise") String recommendEnterprise,
                                       @Param("interviewTime") String interviewTime,
                                       @Param("deptName") String deptName,
                                       @Param("employeeName") String employeeName,
                                       @Param("startIndex") Integer startIndex,
                                       @Param("state") Integer state);

    /**
     * @desc 多条件查询2, 统计结果条数
     * @param customerInfo 5个字段:name, idNumber, phoneNumber, gender, address
     * @param recommendEnterprise~employeeName 其它查询条件
     * @return 结果数量
     */
    Integer countByMC2(@Param("customerInfo") CustomerInfo customerInfo,
                       @Param("recommendEnterprise") String recommendEnterprise,
                       @Param("interviewTime") String interviewTime,
                       @Param("deptName") String deptName,
                       @Param("employeeName") String employeeName,
                       @Param("state") Integer state);

    /**
     * @desc 更新
     * @param interviewInfo 待更新对象
     * @return 操作状态
     */
    Integer update(InterviewInfo interviewInfo);


    /**
     * @desc 根据id查询
     * @param id 目标id
     * @return 目标对象
     */
    InterviewInfo findById(Integer id);


    /**
     * @desc 根据状态查找
     * @param state 目标状态值
     * @return 结果列表
     */
    List<InterviewInfo> findByState(Integer state);

    /**
     * @desc 全字段查询
     * @param interviewInfo 全字段可选
     * @return 结果列表
     */
    List<InterviewInfo> find(InterviewInfo interviewInfo);

    /**
     * @desc 多条件查询3
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeeName 查询参数
     * @param startIndex 查询的起始位置
     * @param deptName session中的部门名
     * @return 结果列表
     */
    List<RoInterviewList> findByMC3(@Param("customerInfo") CustomerInfo customerInfo,
                                    @Param("startIndex") Integer startIndex,
                                    @Param("deptName") String deptName,
                                    @Param("employeeName") String employeeName);


}
