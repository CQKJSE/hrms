package cn.edu.cqust.controller;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesArchives;
import cn.edu.cqust.bean.vo.RoEmployeeArchives;
import cn.edu.cqust.service.EmployeesArchivesService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-22 16:04
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class EmployeesArchivesController {

    @Resource
    private EmployeesArchivesService employeesArchivesServiceImpl;

    @PostMapping(path = "/addArchives")
    public String addOne(EmployeesArchives employeesArchives) {
        return Generator.genJsonStatusCode(
                employeesArchivesServiceImpl.insert(employeesArchives)
        );
    }

    @GetMapping(path = "/employeesArchives")
    public List<RoEmployeeArchives> findByMC3(Employee employee,
                                              @RequestParam(defaultValue = "1") Integer page) {
        return employeesArchivesServiceImpl.findByMC1(
                employee, page
        );
    }

    @GetMapping(path = "/employeesArchivesCount")
    public String countByMC3(Employee employee) {
        return Generator.genJsonObject(
                "count",
                employeesArchivesServiceImpl.countByMC1(employee)
        );
    }

    @PostMapping(path = "/updateEmployeesArchives")
    public String update(EmployeesArchives employeesArchives) {
        return Generator.genJsonStatusCode(
                employeesArchivesServiceImpl.update(employeesArchives)
        );
    }
}
