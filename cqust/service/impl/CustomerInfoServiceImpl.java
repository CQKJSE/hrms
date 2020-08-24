package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.PhoneCallList;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.EmployeeDao;
import cn.edu.cqust.dao.PhoneCallListDao;
import cn.edu.cqust.service.CustomerInfoService;
import cn.edu.cqust.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-13 21:56
 * @desc:
 **/
@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Resource
    private CustomerInfoDao customerInfoDao;
    @Resource
    private PhoneCallListDao phoneCallListDao;
    @Resource
    private EmployeeDao employeeDao;

    @Override
    public Integer addOne(CustomerInfo customerInfo, String employeeName, String employeePhone) {
        String addedTime = DateUtil.getYMD();
        customerInfo.setAddedPerson(employeeName);
        customerInfo.setAddedTime(addedTime);
        customerInfo.setState("0");
        PhoneCallList phoneCallList = new PhoneCallList();
        Employee employee = employeeDao.findByPhone(employeePhone);
        int s1 = customerInfoDao.insert(customerInfo);
        Integer lastInsertId = customerInfoDao.findMaxId();
        phoneCallList.setAddedTime(addedTime);
        phoneCallList.setCustomerId(lastInsertId);
        phoneCallList.setEmployeeId(employee.getId());
        int s2 = phoneCallListDao.insert(phoneCallList);
        return (s1 == 1 && s2 == 1) ? 1 : -1;
    }

    @Override
    public List<CustomerInfo> findFuzzily(CustomerInfo customerInfo, Integer pageNumber) {
        return customerInfoDao.findFuzzily(
                customerInfo, (pageNumber - 1) * 10
        );
    }

    @Override
    public Integer countFuzzily(CustomerInfo customerInfo) {
        return customerInfoDao.findFuzzily(
                customerInfo, null
        ).size();
    }

    @Override
    public Integer update(CustomerInfo customerInfo) {
        return customerInfoDao.update(customerInfo);
    }
}
