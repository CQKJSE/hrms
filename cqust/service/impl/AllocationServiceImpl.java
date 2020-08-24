package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneCallList;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.PhoneCallListDao;
import cn.edu.cqust.service.AllocationService;
import cn.edu.cqust.util.Allocator;
import cn.edu.cqust.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @Resource
    private PhoneCallListDao phoneCallListDao;
    @Resource
    private CustomerInfoDao customerInfoDao;

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

    @Override
    public Integer allocateOne2(Integer cid, Integer eid) {
        //check customer_info state
        CustomerInfo ci = new CustomerInfo();
        ci.setId(cid);
        boolean state0 = customerInfoDao
                .findFuzzily(ci, null)
                .get(0)
                .getState()
                .equals("0");
        if (state0)
            return -2;

        //check two keys
        List<PhoneCallList> pclAll = phoneCallListDao.findAll();
        Map<Integer, String> compareMap = Allocator.PclToCompareMap(pclAll);
        String cid_eid = cid + "_" + eid;
        boolean existOfTwoKey = compareMap.containsValue(cid_eid);
        if (existOfTwoKey)
            return -3;

        PhoneCallList newPcl = new PhoneCallList();
        newPcl.setAddedTime(DateUtil.getYMD());
        newPcl.setCustomerId(cid);
        newPcl.setEmployeeId(eid);
        return phoneCallListDao.insert(newPcl);
    }
}
