package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.dao.EmployeeDao;
import cn.edu.cqust.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-16 10:28
 * @desc:
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findByMcAndState0(Employee employee, Integer pageNumber) {
        employee.setState("0");
        System.out.println(employeeDao == null);
        return employeeDao.findByMC(employee, (pageNumber - 1) * 10);
    }

    @Override
    public Integer countByMcAndState0(Employee employee) {
        employee.setState("0");
        return employeeDao.findByMC(employee, null).size();
    }

    @Override
    public Integer insert(Employee employee) {
        employee.setState("0");
        return employeeDao.insert(employee);
    }

    @Override
    public Integer update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public List<Employee> findSalesmanAndLeader() {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        e1.setPosition("组长");
        e2.setPosition("业务员");
        List<Employee> listAll = new ArrayList<>();
        listAll.addAll(employeeDao.find(e1, null));
        listAll.addAll(employeeDao.find(e2, null));
        return listAll;
    }

    @Override
    public List<Employee> findMarkedByState0AndName(String name) {
        Employee employee = new Employee();
        employee.setState("0");
        employee.setDeptName("市场部");
        employee.setName(name);
        return employeeDao.find(employee, null);
    }


}
