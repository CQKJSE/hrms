package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.IndustrialInjuryInfo;
import cn.edu.cqust.bean.vo.RoInjury;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-22 09:30
 * @desc:
 **/
public interface IndustrialInjuryInfoService {

    /**
     * @desc 添加
     * @param industrialInjuryInfo 待添加对象

     * @return 操作状态
     */
    Integer insert(IndustrialInjuryInfo industrialInjuryInfo);

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param pageNumber 查询的起始位置
     * @return 结果列表
     */
    List<RoInjury> findByMC1(CustomerInfo customerInfo, Integer pageNumber);

    /**
     * @desc 多条件查询1, 统计结果条数
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @return 结果数量
     */
    Integer countByMC1(CustomerInfo customerInfo);

    /**
     * @desc 修改
     * @param industrialInjuryInfo 需要修改的对象
     * @return 操作状态
     */
    Integer update(IndustrialInjuryInfo industrialInjuryInfo);


}
