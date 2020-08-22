package cn.edu.cqust.controller;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesDeparture;
import cn.edu.cqust.bean.vo.RoDeparture;
import cn.edu.cqust.service.EmployeesDepartureService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-22 17:26
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class EmployeesDepartureController {

    @Resource
    private EmployeesDepartureService employeesDepartureServiceImpl;

    @PostMapping(path = "/addDeparture")
    public String addOne(EmployeesDeparture employeesDeparture) {
        return Generator.genJsonStatusCode(
                employeesDepartureServiceImpl.insert(employeesDeparture)
        );
    }

    @GetMapping(path = "/departure")
    public List<RoDeparture> findByMC3(Employee employee,
                                       @RequestParam(defaultValue = "1") Integer page) {
        return employeesDepartureServiceImpl.findByMC1(
                employee, page
        );
    }

    @GetMapping(path = "/departureCount")
    public String countByMC3(Employee employee) {
        return Generator.genJsonObject(
                "count",
                employeesDepartureServiceImpl.countByMC1(employee)
        );
    }

    @PostMapping(path = "/updateDeparture")
    public String update(EmployeesDeparture employeesDeparture) {
        return Generator.genJsonStatusCode(
                employeesDepartureServiceImpl.update(employeesDeparture)
        );
    }

}
