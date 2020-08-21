package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.vo.RoOnTheJob;
import cn.edu.cqust.bean.vo.RoSettlement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-20 11:37
 * @desc:
 **/
public interface SettlementInfoService {

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeePhone session中业务员的电话
     * @param settlementState 结算状态
     * @param page 查询页码
     * @return 结果列表
     */
    List<RoSettlement> findByMC1(CustomerInfo customerInfo,
                                 String employeePhone,
                                 String settlementState,
                                 Integer page);

    /**
     * @desc 多条件查询1, 统计结果条数
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeePhone session中业务员的电话
     * @param settlementState 结算状态
     * @return 结果数量
     */
    Integer countByMC1(CustomerInfo customerInfo,
                       String employeePhone,
                       String settlementState);


    /**
     * @desc 多条件查询2
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param settlementState 结算状态
     * @param page 查询页码
     * @return 结果列表
     */
    List<RoSettlement> findByMC2(CustomerInfo customerInfo,
                                 String settlementState,
                                 Integer page);

    /**
     * @desc 多条件查询2, 统计结果条数
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param settlementState 结算状态
     * @return 结果数量
     */
    Integer countByMC2(CustomerInfo customerInfo,
                       String settlementState);


}
