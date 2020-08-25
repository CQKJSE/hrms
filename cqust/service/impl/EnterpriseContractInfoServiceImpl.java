package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.EnterpriseContractInfo;
import cn.edu.cqust.dao.EnterpriseContractInfoDao;
import cn.edu.cqust.service.EnterpriseContractInfoService;
import cn.edu.cqust.util.DateUtil;
import cn.edu.cqust.util.PagingUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 16:22
 * @desc:
 **/
@Service
public class EnterpriseContractInfoServiceImpl implements EnterpriseContractInfoService {

    @Resource
    private EnterpriseContractInfoDao enterpriseContractInfoDao;


    @Override
    public List<EnterpriseContractInfo> findByName(String enterpriseName, Integer pageNumber) {
        EnterpriseContractInfo eci = new EnterpriseContractInfo();
        eci.setEnterpriseName(enterpriseName);
        return enterpriseContractInfoDao.findFuzzily(eci, PagingUtil.paging(pageNumber));
    }

    @Override
    public Integer countByName(String enterpriseName) {
        EnterpriseContractInfo eci = new EnterpriseContractInfo();
        eci.setEnterpriseName(enterpriseName);
        return enterpriseContractInfoDao.findFuzzily(eci, null).size();
    }

    @Override
    public Integer insert(EnterpriseContractInfo enterpriseContractInfo) {
        return enterpriseContractInfoDao.insert(enterpriseContractInfo);
    }

    @Override
    public Integer update(EnterpriseContractInfo enterpriseContractInfo) {
        return enterpriseContractInfoDao.update(enterpriseContractInfo);
    }

    @Override
    public Integer deleteById(Integer id) {
        return enterpriseContractInfoDao.deleteById(id);
    }
}
