package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.IndustrialInjuryInfo;
import cn.edu.cqust.bean.vo.RoInjury;
import cn.edu.cqust.dao.IndustrialInjuryInfoDao;
import cn.edu.cqust.service.IndustrialInjuryInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-22 09:30
 * @desc:
 **/
@Service
public class IndustrialInjuryInfoServiceImpl implements IndustrialInjuryInfoService {

    @Resource
    private IndustrialInjuryInfoDao industrialInjuryInfoDao;

    @Override
    public Integer insert(IndustrialInjuryInfo industrialInjuryInfo) {
        return industrialInjuryInfoDao.insert(industrialInjuryInfo);
    }

    @Override
    public List<RoInjury> findByMC1(CustomerInfo customerInfo, Integer pageNumber) {
        return industrialInjuryInfoDao.findByMC1(
                customerInfo, (pageNumber - 1) * 10
        );
    }

    @Override
    public Integer countByMC1(CustomerInfo customerInfo) {
        return industrialInjuryInfoDao.findByMC1(
                customerInfo,
                null
        ).size();
    }

    @Override
    public Integer update(IndustrialInjuryInfo industrialInjuryInfo) {
        return industrialInjuryInfoDao.update(industrialInjuryInfo);
    }
}
