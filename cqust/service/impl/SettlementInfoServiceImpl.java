package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.vo.RoOnTheJob;
import cn.edu.cqust.bean.vo.RoSettlement;
import cn.edu.cqust.dao.SettlementInfoDao;
import cn.edu.cqust.service.SettlementInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-20 11:38
 * @desc:
 **/
@Service
public class SettlementInfoServiceImpl implements SettlementInfoService {

    @Resource
    private SettlementInfoDao settlementInfoDao;

    @Override
    public List<RoSettlement> findByMC1(CustomerInfo customerInfo, String employeePhone, String settlementState, Integer page) {
        return settlementInfoDao.findByMC1(
                customerInfo,
                employeePhone,
                settlementState,
                (page - 1) * 10
        );
    }

    @Override
    public Integer countByMC1(CustomerInfo customerInfo, String employeePhone, String settlementState) {
        List<RoSettlement> res = settlementInfoDao.findByMC1(
                customerInfo,
                employeePhone,
                settlementState,
                null
        );

        return res.size();
    }

    @Override
    public List<RoSettlement> findByMC2(CustomerInfo customerInfo, String settlementState, Integer page) {
        return settlementInfoDao.findByMC2(
                customerInfo,
                settlementState,
                (page - 1) * 10
        );
    }

    @Override
    public Integer countByMC2(CustomerInfo customerInfo, String settlementState) {
        return settlementInfoDao.findByMC2(
                customerInfo,
                settlementState,
                null
        ).size();
    }
}
