package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.SignUpInfo;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.bean.vo.RoSignUpListAll;
import cn.edu.cqust.bean.vo.RoSignUpListGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-10 09:48
 * @desc:
 **/
@Mapper
@Component
public interface SignUpInfoDao {

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
     * @desc 根据id查询
     * @param id 目标id
     * @return 相对应的结果
     */
    SignUpInfo findById(Integer id);


    /**
     * @desc 修改
     * @param signUpInfo 需要更新的数据
     * @return 操作状态
     */
    Integer update(SignUpInfo signUpInfo);

    /**
     * @desc 插入
     * @param signUpInfo 需要插入的数据
     * @return 操作状态
     */
    Integer insert(SignUpInfo signUpInfo);

    /**
     * @desc 多条件查询2
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param startIndex 查询的起始位置
     * @param state signUpInfo的state
     * @return 结果列表
     */
    List<RoSignUpListAll> findByMC2(@Param("customerInfo") CustomerInfo customerInfo,
                                    @Param("startIndex") Integer startIndex,
                                    @Param("state") Integer state);

    /**
     * @desc 多条件查询2, 统计结果条数
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @return 结果数量
     */
    Integer countByMC2(@Param("customerInfo") CustomerInfo customerInfo,
                       @Param("state") Integer state);

    /**
     * @desc 根据状态查找
     * @param state 目标状态值
     * @return 结果列表
     */
    List<SignUpInfo> findByState(Integer state);


    /**
     * @desc 多条件查询3
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeeName 查询参数
     * @param startIndex 查询的起始位置
     * @param deptName session中的部门名
     * @return 结果列表
     */
    List<RoSignUpListGroup> findByMC3(@Param("customerInfo") CustomerInfo customerInfo,
                                      @Param("startIndex") Integer startIndex,
                                      @Param("deptName") String deptName,
                                      @Param("employeeName") String employeeName);

}
