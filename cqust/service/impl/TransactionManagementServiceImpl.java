package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.TransactionManagement;
import cn.edu.cqust.dao.TransactionManagementDao;
import cn.edu.cqust.service.TransactionManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-06 20:15
 * @desc:
 **/
@Service
public class TransactionManagementServiceImpl implements TransactionManagementService {

    @Resource
    private TransactionManagementDao transactionManagementDao;

    @Override
    public List<TransactionManagement> findByEmployeePhone(String employeePhone) {
        return transactionManagementDao.findByEmployeePhone(employeePhone);
    }

    @Override
    public Integer deleteById(Integer id) {
        return transactionManagementDao.deleteById(id);
    }

    @Override
    public Integer insert(TransactionManagement transactionManagement) {
        return transactionManagementDao.insert(transactionManagement);
    }
}
