package cn.edu.cqust.service.impl;

import cn.edu.cqust.service.AllocationService;
import cn.edu.cqust.util.PclAllocator;
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
    private PclAllocator pclAllocator;

    @Override
    public Integer allocateOne(String phone) {
        pclAllocator.initData();
        pclAllocator.allocateOne(phone);
        pclAllocator.printData();
        pclAllocator.insertResult();
        return pclAllocator.getAllocationState() ? 1 : -1;
    }

    @Override
    public Integer allocateOneAfterTimeLimit(String phone) {
        pclAllocator.initData();
        pclAllocator.allocateOneAfterTimeLimit(phone);
        pclAllocator.printData();
        pclAllocator.insertResult();
        return pclAllocator.getAllocationState() ? 1 : -1;
    }
}
