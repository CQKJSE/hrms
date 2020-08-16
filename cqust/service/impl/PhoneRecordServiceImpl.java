package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneRecord;
import cn.edu.cqust.bean.vo.RoGetPhoneRecord;
import cn.edu.cqust.bean.vo.RoGetPhoneRecordAll;
import cn.edu.cqust.bean.vo.RoGetPhoneRecordDept;
import cn.edu.cqust.dao.PhoneRecordDao;
import cn.edu.cqust.service.PhoneRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-16 17:08
 * @desc:
 **/
@Service
public class PhoneRecordServiceImpl implements PhoneRecordService {

    @Resource
    private PhoneRecordDao phoneRecordDao;

    @Override
    public List<RoGetPhoneRecord> findByMC1(CustomerInfo customerInfo, Integer pageNumber, String employeePhone) {
        return phoneRecordDao.findByMC1(
                customerInfo,
                (pageNumber - 1) * 10,
                employeePhone
        );
    }

    @Override
    public Integer countByMC1(CustomerInfo customerInfo, String employeePhone) {
        return phoneRecordDao.findByMC1(
                customerInfo,
                null,
                employeePhone
        ).size();
    }

    @Override
    public List<RoGetPhoneRecordDept> findByMC2(CustomerInfo customerInfo, Integer pageNumber, String employeeName, String deptName) {
        return phoneRecordDao.findByMC2(
                customerInfo,
                (pageNumber - 1) * 10,
                employeeName,
                deptName
        );
    }

    @Override
    public Integer countByMC2(CustomerInfo customerInfo, String employeeName, String deptName) {
        return phoneRecordDao.findByMC2(
                customerInfo,
                null,
                employeeName,
                deptName
        ).size();
    }

    @Override
    public List<RoGetPhoneRecordAll> findByMC3(CustomerInfo customerInfo, Integer pageNumber, String employeeName, String deptName) {
        return phoneRecordDao.findByMC3(
                customerInfo,
                (pageNumber - 1) * 10,
                employeeName,
                deptName
        );
    }

    @Override
    public Integer countByMC3(CustomerInfo customerInfo, String employeeName, String deptName) {
        return phoneRecordDao.findByMC3(
                customerInfo,
                null,
                employeeName,
                deptName
        ).size();
    }

    @Override
    public Integer insert(PhoneRecord phoneRecord) {
        return phoneRecordDao.insert(phoneRecord);
    }

    @Override
    public Integer[] countTodayByStatus(String employeePhone) {
        Integer all = phoneRecordDao.countTodayByStatus(employeePhone, null);
        Integer though = phoneRecordDao.countTodayByStatus(employeePhone, "接通");
        return new Integer[]{all, though};
    }
}
