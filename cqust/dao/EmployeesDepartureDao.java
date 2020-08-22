package cn.edu.cqust.dao;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesArchives;
import cn.edu.cqust.bean.EmployeesDeparture;
import cn.edu.cqust.bean.vo.RoDeparture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-22 17:26
 * @desc:
 **/
@Mapper
@Component
public interface EmployeesDepartureDao {

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
    List<RoDeparture> findByMC1(@Param("employee") Employee employee,
                                @Param("startIndex") Integer startIndex);

    /**
     * @desc 修改
     * @param employeesDeparture 需要更新的数据
     * @return 操作状态
     */
    Integer update(EmployeesDeparture employeesDeparture);
}
