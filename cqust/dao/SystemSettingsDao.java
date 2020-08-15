package cn.edu.cqust.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-08 15:12
 * @desc:
 **/
@Mapper
@Component
public interface SystemSettingsDao {

    /**
     * @desc 查询系统自动分配给每人的数据量
     * @return 查询结果
     */
    Integer findAllocationCount();


    /**
     * @desc 查询员工电话总名单自动入库的期限
     * @return 查询结果
     */
    Integer findTimeLimit();


}
