package cn.edu.cqust.controller;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.service.EmployeeService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-16 10:38
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class EmployeeController {

    @Resource
    private EmployeeService employeeServiceImpl;

    @GetMapping(path = "/employee")
    public List<Employee> findByMcAndState0(Employee employee,
                                            @RequestParam(defaultValue = "1") Integer page) {
        return employeeServiceImpl.findByMcAndState0(employee, page);
    }

    @GetMapping(path = "/employeeCount")
    public String countByMcAndState0(Employee employee) {
        return Generator.genJsonObject("count", employeeServiceImpl.countByMcAndState0(employee));
    }

    @PostMapping(path = "/addEmployee")
    public String insert(@RequestBody Employee employee) {
        System.out.println(employee.getDeptName());
        System.out.println(employee.getIdWork());
        System.out.println(employee.getName());
        return Generator.genJsonStatusCode(employeeServiceImpl.insert(employee));
    }

    @PostMapping(path = "/updateEmployee")
    public String update(@RequestBody Employee employee) {
        System.out.println(employee.getDeptName());
        System.out.println(employee.getIdWork());
        System.out.println(employee.getName());
        System.out.println(employee.getIdNumber());
        System.out.println(employee.getGender());
        return Generator.genJsonStatusCode(employeeServiceImpl.update(employee));
    }

    @GetMapping(path = "/group")
    public List<Employee> find() {
        return employeeServiceImpl.findSalesmanAndLeader();
    }

    @GetMapping(path = "/market")
    public List<Employee> findMarkedByState0AndName(String name) {
        return employeeServiceImpl.findMarkedByState0AndName(name);
    }

}
