package cn.edu.cqust.dao;

import cn.edu.cqust.bean.EmployeesDeparture;
import cn.edu.cqust.bean.EnterpriseContractInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-25 16:21
 * @desc:
 **/
@Mapper
@Component
public interface EnterpriseContractInfoDao {

    /**
     * @desc 全字段查询
     * @param enterpriseContractInfo 全字段可选
     * @param startIndex 起始位置
     * @return 结果列表
     */
    List<EnterpriseContractInfo> find(@Param("enterpriseContractInfo") EnterpriseContractInfo enterpriseContractInfo,
                                      @Param("startIndex") Integer startIndex);

    /**
     * @desc 全字段查询(模糊)
     * @param enterpriseContractInfo 全字段可选
     * @param startIndex 起始位置
     * @return 结果列表
     */
    List<EnterpriseContractInfo> findFuzzily(@Param("enterpriseContractInfo") EnterpriseContractInfo enterpriseContractInfo,
                                             @Param("startIndex") Integer startIndex);

    /**
     * @desc 根据id删除
     * @param id 目标id
     * @return 操作状态
     */
    Integer deleteById(Integer id);


    /**
     * @desc 添加一条数据
     * @param enterpriseContractInfo 待添加数据
     * @return 操作状态
     */
    Integer insert(EnterpriseContractInfo enterpriseContractInfo);


    /**
     * @desc 修改
     * @param enterpriseContractInfo 需要更新的数据
     * @return 操作状态
     */
    Integer update(EnterpriseContractInfo enterpriseContractInfo);
}
