package cn.edu.cqust.service;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesDeparture;
import cn.edu.cqust.bean.vo.RoDeparture;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-22 17:26
 * @desc:
 **/
public interface EmployeesDepartureService {

    /**
     * @desc 添加
     * @param employeesDeparture 待添加数据
     * @return 操作状态
     */
    Integer insert(EmployeesDeparture employeesDeparture);

    /**
     * @desc 多条件查询1
     * @param employee 4个参数:name deptName State idWork
     * @return 结果列表
     */
    List<RoDeparture> findByMC1(Employee employee,
                                Integer pageNumber);

    /**
     * @desc 多条件查询1, 统计结果条数
     * @param employee 4个参数:name deptName State idWork
     * @return 结果数量
     */
    Integer countByMC1(Employee employee);

    /**
     * @desc 修改
     * @param employeesDeparture 需要更新的数据
     * @return 操作状态
     */
    Integer update(EmployeesDeparture employeesDeparture);

}
