package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.EnterpriseInfo;
import cn.edu.cqust.dao.EnterpriseInfoDao;
import cn.edu.cqust.service.EnterpriseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 08:48
 * @desc:
 **/
@Service
public class EnterpriseInfoServiceImpl implements EnterpriseInfoService {

    @Resource
    private EnterpriseInfoDao enterpriseInfoDao;

    @Override
    public List<EnterpriseInfo> findByName(String enterpriseName, Integer pageNumber) {
        EnterpriseInfo ei = new EnterpriseInfo();
        ei.setEnterpriseName(enterpriseName);
        return enterpriseInfoDao.findFuzzily(ei, (pageNumber - 1) * 10);
    }

    @Override
    public Integer countByName(String enterpriseName) {
        EnterpriseInfo ei = new EnterpriseInfo();
        ei.setEnterpriseName(enterpriseName);
        return enterpriseInfoDao.findFuzzily(ei, null).size();
    }

    @Override
    public Integer insert(EnterpriseInfo enterpriseInfo) {
        return enterpriseInfoDao.insert(enterpriseInfo);
    }

    @Override
    public Integer update(EnterpriseInfo enterpriseInfo) {
        return enterpriseInfoDao.update(enterpriseInfo);
    }

    @Override
    public Integer deleteById(Integer id) {
        return enterpriseInfoDao.deleteById(id);
    }

    @Override
    public Map<Integer, String> findAllEnterpriseName() {
        List<EnterpriseInfo> qrList = enterpriseInfoDao.find(new EnterpriseInfo(), null);
        return qrList
                .stream()
                .collect(Collectors.toMap(
                        EnterpriseInfo::getId,
                        EnterpriseInfo::getEnterpriseName));
    }
}
