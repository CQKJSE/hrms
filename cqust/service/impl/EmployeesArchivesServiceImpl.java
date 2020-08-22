package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesArchives;
import cn.edu.cqust.bean.vo.RoEmployeeArchives;
import cn.edu.cqust.dao.EmployeesArchivesDao;
import cn.edu.cqust.service.EmployeesArchivesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-22 16:04
 * @desc:
 **/
@Service
public class EmployeesArchivesServiceImpl implements EmployeesArchivesService {

    @Resource
    private EmployeesArchivesDao employeesArchivesDao;

    @Override
    public Integer insert(EmployeesArchives employeesArchives) {
        return employeesArchivesDao.insert(employeesArchives);
    }

    @Override
    public List<RoEmployeeArchives> findByMC1(Employee employee, Integer pageNumber) {
        return employeesArchivesDao.findByMC1(
                employee, (pageNumber - 1) * 10
        );
    }

    @Override
    public Integer countByMC1(Employee employee) {
        return employeesArchivesDao.findByMC1(
                employee, null
        ).size();
    }

    @Override
    public Integer update(EmployeesArchives employeesArchives) {
        return employeesArchivesDao.update(employeesArchives);
    }
}
