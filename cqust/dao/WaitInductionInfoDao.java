package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.WaitInductionInfo;
import cn.edu.cqust.bean.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-12 10:08
 * @desc:
 **/
@Mapper
@Component
public interface WaitInductionInfoDao {

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param startIndex 查询的起始位置
     * @param employeePhone session中业务员的电话
     * @return 结果列表
     */
    List<RoWaitInduction> findByMC1(@Param("customerInfo") CustomerInfo customerInfo,
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
     * @return id对应的数据
     */
    WaitInductionInfo findById(Integer id);

    /**
     * @desc 添加
     * @param waitInductionInfo 待插入数据
     * @return 操作状态
     */
    Integer insert(WaitInductionInfo waitInductionInfo);


    /**
     * @desc 修改
     * @param waitInductionInfo 需要更新的数据
     * @return 操作状态
     */
    Integer update(WaitInductionInfo waitInductionInfo);

    /**
     * @desc 多条件查询2
     * @param qo 混合查询对象
     * @param startIndex 查询的起始位置
     * @return 结果列表
     */
    List<RoWaitInduction> findByMC2(@Param("qo") QoWaitInductionAll qo,
                                    @Param("startIndex") Integer startIndex);


    /**
     * @desc 全字段查询
     * @param interviewInfo 全字段可选
     * @return 结果列表
     */
    List<WaitInductionInfo> find(WaitInductionInfo interviewInfo);


    /**
     * @desc 多条件查询3
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeeName 查询参数
     * @param startIndex 查询的起始位置
     * @param deptName session中的部门名
     * @return 结果列表
     */
    List<RoWaitInductionGroup> findByMC3(@Param("customerInfo") CustomerInfo customerInfo,
                                         @Param("startIndex") Integer startIndex,
                                         @Param("deptName") String deptName,
                                         @Param("employeeName") String employeeName);

    /**
     * @desc 多条件查询4
     * @param qo 混合查询对象
     * @return 结果列表
     */
    List<RoWaitInductionAllMarket> findByMC4(@Param("qo") QoWaitInductionAllMarket qo,
                                       @Param("startIndex") Integer startIndex);
}
