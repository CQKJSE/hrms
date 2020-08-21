package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.SettlementInfo;
import cn.edu.cqust.bean.vo.RoOnTheJob;
import cn.edu.cqust.bean.vo.RoSettlement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-20 11:32
 * @desc:
 **/
@Mapper
@Component
public interface SettlementInfoDao {

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeePhone session中业务员的电话
     * @param settlementState 结算状态
     * @param startIndex 查询的起始位置
     * @return 结果列表
     */
    List<RoSettlement> findByMC1(@Param("customerInfo") CustomerInfo customerInfo,
                                 @Param("employeePhone") String employeePhone,
                                 @Param("settlementState") String settlementState,
                                 @Param("startIndex") Integer startIndex);


    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param settlementState 结算状态
     * @param startIndex 查询的起始位置
     * @return 结果列表
     */
    List<RoSettlement> findByMC2(@Param("customerInfo") CustomerInfo customerInfo,
                                 @Param("settlementState") String settlementState,
                                 @Param("startIndex") Integer startIndex);


    /**
     * @desc 添加
     * @param settlementInfo 待添加对象
     * @return 操作状态
     */
    Integer insert(SettlementInfo settlementInfo);

}
