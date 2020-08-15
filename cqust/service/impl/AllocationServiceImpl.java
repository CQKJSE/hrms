package cn.edu.cqust.service.impl;

import cn.edu.cqust.service.AllocationService;
import cn.edu.cqust.util.Allocator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-15 11:00
 * @desc:
 **/
@Service
public class AllocationServiceImpl implements AllocationService {

    @Resource
    private Allocator allocator;

    @Override
    public Integer allocateOne(String phone) {
        allocator.initData();
        allocator.allocateOne(phone);
        allocator.printData();
        allocator.insertResult();
        return allocator.getAllocationState() ? 1 : -1;
    }

    @Override
    public Integer allocateOneAfterTimeLimit(String phone) {
        allocator.initData();
        allocator.allocateOneAfterTimeLimit(phone);
        allocator.printData();
        allocator.insertResult();
        return allocator.getAllocationState() ? 1 : -1;
    }
}
