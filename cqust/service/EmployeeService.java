package cn.edu.cqust.service;

import cn.edu.cqust.bean.Employee;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-16 10:26
 * @desc:
 **/
public interface EmployeeService {

    /**
     * @desc 多条件查询state = 0的数据 (所有成员变量可选)
     * @param employee 带查询条件的bean
     * @param pageNumber 页码
     * @return 结果列表
     */
    List<Employee> findByMcAndState0(Employee employee, Integer pageNumber);


    /**
     * @desc 多条件state = 0, 计算数据条数(复用48的dao)
     * @param employee 带查询条件的bean
     * @return 结果数量
     */
    Integer countByMcAndState0(Employee employee);

    /**
     * @desc 添加
     * @param employee 待添加数据
     * @return 操作状态
     */
    Integer insert(Employee employee);

    /**
     * @desc 修改
     * @param employee 需要修改的数据
     * @return 操作状态
     */
    Integer update(Employee employee);


}
