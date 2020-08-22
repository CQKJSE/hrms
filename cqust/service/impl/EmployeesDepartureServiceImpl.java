package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesDeparture;
import cn.edu.cqust.bean.vo.RoDeparture;
import cn.edu.cqust.dao.EmployeesDepartureDao;
import cn.edu.cqust.service.EmployeesDepartureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-22 17:26
 * @desc:
 **/
@Service
public class EmployeesDepartureServiceImpl implements EmployeesDepartureService {

    @Resource
    private EmployeesDepartureDao employeesDepartureDao;

    @Override
    public Integer insert(EmployeesDeparture employeesDeparture) {
        return employeesDepartureDao.insert(employeesDeparture);
    }

    @Override
    public List<RoDeparture> findByMC1(Employee employee, Integer pageNumber) {
        return employeesDepartureDao.findByMC1(
                employee, (pageNumber - 1) * 10
        );
    }

    @Override
    public Integer countByMC1(Employee employee) {
        return employeesDepartureDao.findByMC1(
                employee, null
        ).size();
    }

    @Override
    public Integer update(EmployeesDeparture employeesDeparture) {
        return employeesDepartureDao.update(employeesDeparture);
    }
}
