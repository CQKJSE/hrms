package cn.edu.cqust.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-21 17:17
 * @desc: 数据库表格基本信息查询
 **/
@Mapper
@Component
public interface TableInfoDao {

    /**
     * @desc 查询表格目前的自增长键值
     * @param tableName 目标表格对象
     * @return 自增长键值
     */
    Integer findAutoIncrement(String tableName);

}
