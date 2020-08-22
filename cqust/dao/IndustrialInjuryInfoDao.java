package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.IndustrialInjuryInfo;
import cn.edu.cqust.bean.vo.RoInjury;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-22 09:30
 * @desc:
 **/
@Mapper
@Component
public interface IndustrialInjuryInfoDao {

    /**
     * @desc 添加
     * @param industrialInjuryInfo 待添加对象
     * @return 操作状态
     */
    Integer insert(IndustrialInjuryInfo industrialInjuryInfo);

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param startIndex 起始位置
     * @return 结果列表
     */
    List<RoInjury> findByMC1(@Param("customerInfo") CustomerInfo customerInfo,
                             @Param("startIndex") Integer startIndex);

    /**
     * @desc 修改
     * @param industrialInjuryInfo 需要修改的对象
     * @return 操作状态
     */
    Integer update(IndustrialInjuryInfo industrialInjuryInfo);

}
