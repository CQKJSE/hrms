package cn.edu.cqust.dao;

import cn.edu.cqust.bean.EnterpriseDemandInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-25 10:05
 * @desc:
 **/
@Mapper
@Component
public interface EnterpriseDemandInfoDao {

    /**
     * @desc 全字段查询
     * @param enterpriseDemandInfo 全字段可选
     * @param startIndex 起始位置
     * @return 结果列表
     */
    List<EnterpriseDemandInfo> find(@Param("enterpriseDemandInfo") EnterpriseDemandInfo enterpriseDemandInfo,
                                    @Param("startIndex") Integer startIndex);

    /**
     * @desc 全字段查询(模糊)
     * @param enterpriseDemandInfo 全字段可选
     * @param startIndex 起始位置
     * @return 结果列表
     */
    List<EnterpriseDemandInfo> findFuzzily(@Param("enterpriseDemandInfo") EnterpriseDemandInfo enterpriseDemandInfo,
                                           @Param("startIndex") Integer startIndex);


    /**
     * @desc 根据id删除
     * @param id 目标id
     * @return 操作状态
     */
    Integer deleteById(Integer id);


    /**
     * @desc 添加一条数据
     * @param enterpriseDemandInfo 待添加数据
     * @return 操作状态
     */
    Integer insert(EnterpriseDemandInfo enterpriseDemandInfo);


    /**
     * @desc 修改
     * @param enterpriseDemandInfo 需要更新的数据
     * @return 操作状态
     */
    Integer update(EnterpriseDemandInfo enterpriseDemandInfo);
}
