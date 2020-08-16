package cn.edu.cqust.dao;

import cn.edu.cqust.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-08 15:34
 * @desc:
 **/
@Mapper
@Component
public interface EmployeeDao {

    /**
     * @desc 根据职位(数组)查询
     * @param positions 职位数组
     * @return 结果列表
     */
    Integer countByPositions(@Param("positions") String[] positions);

    /**
     * @desc 根据职位(数组)查询所有id
     * @param positions 职位数组
     * @return 结果列表
     */
    List<Integer> findIdByPositions(@Param("positions") String[] positions);

    /**
     * @desc 根据电话号码查询
     * @param phone 目标的电话号码
     * @return 目标对象
     */
    Employee findByPhone(String phone);

    /**
     * @desc 多条件查询 (所有成员变量可选)
     * @param employee 带查询条件的bean
     * @return 结果列表
     */
    List<Employee> findByMC(@Param("employee") Employee employee,
                            @Param("pageIndex") Integer pageIndex);

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
