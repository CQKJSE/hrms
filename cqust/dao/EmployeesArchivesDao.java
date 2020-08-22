package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesArchives;
import cn.edu.cqust.bean.vo.RoEmployeeArchives;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-22 16:03
 * @desc:
 **/
@Mapper
@Component
public interface EmployeesArchivesDao {

    /**
     * @desc 添加
     * @param employeesArchives 待添加数据
     * @return 操作状态
     */
    Integer insert(EmployeesArchives employeesArchives);

    /**
     * @desc 多条件查询1
     * @param employee 4个参数:name deptName State idWork
     * @return 结果列表
     */
    List<RoEmployeeArchives> findByMC1(@Param("employee") Employee employee,
                                       @Param("startIndex") Integer startIndex);

    /**
     * @desc 修改
     * @param employeesArchives 需要更新的数据
     * @return 操作状态
     */
    Integer update(EmployeesArchives employeesArchives);


}
