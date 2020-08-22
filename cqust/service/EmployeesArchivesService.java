package cn.edu.cqust.service;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesArchives;
import cn.edu.cqust.bean.vo.RoEmployeeArchives;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-22 16:04
 * @desc:
 **/
public interface EmployeesArchivesService {

    /**
     * @desc 添加
     * @param employeesArchives 待添加对象
     * @return 操作状态
     */
    Integer insert(EmployeesArchives employeesArchives);

    /**
     * @desc 多条件查询1
     * @param employee 4个参数:name deptName State idWork
     * @param pageNumber 查询的起始页码
     * @return 结果列表
     */
    List<RoEmployeeArchives> findByMC1(Employee employee, Integer pageNumber);

    /**
     * @desc 多条件查询1, 统计结果条数
     * @param employee 4个参数:name deptName State idWork
     * @return 结果数量
     */
    Integer countByMC1(Employee employee);

    /**
     * @desc 修改
     * @param employeesArchives 需要修改的数据
     * @return 操作状态
     */
    Integer update(EmployeesArchives employeesArchives);

}
