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

    @PostMapping(path = "/employee")
    public List<Employee> findByMcAndState0(Employee employee,
                                            @RequestParam(defaultValue = "1") Integer pageNumber) {
        return employeeServiceImpl.findByMcAndState0(employee, pageNumber);
    }

    @GetMapping(path = "/employeeCount")
    public String countByMcAndState0(Employee employee) {
        return Generator.genJsonObject("count", employeeServiceImpl.countByMcAndState0(employee));
    }

    @PostMapping(path = "/addEmployee")
    public String insert(Employee employee) {
        return Generator.genJsonStatusCode(employeeServiceImpl.insert(employee));
    }

    @PostMapping(path = "/updateEmployee")
    public String update(Employee employee) {
        return Generator.genJsonStatusCode(employeeServiceImpl.update(employee));
    }

    @GetMapping(path = "/group")
    public List<Employee> find() {
        return employeeServiceImpl.findSalesmanAndLeader();
    }

}
