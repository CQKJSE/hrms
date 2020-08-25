package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.EnterpriseDemandInfo;
import cn.edu.cqust.bean.EnterpriseInfo;
import cn.edu.cqust.dao.EnterpriseDemandInfoDao;
import cn.edu.cqust.dao.EnterpriseInfoDao;
import cn.edu.cqust.service.EnterpriseDemandInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 10:05
 * @desc:
 **/
@Service
public class EnterpriseDemandInfoServiceImpl implements EnterpriseDemandInfoService {

    @Resource
    private EnterpriseDemandInfoDao enterpriseDemandInfoDao;
    @Resource
    private EnterpriseInfoDao enterpriseInfoDao;


    @Override
    public List<EnterpriseDemandInfo> findByEiId(Integer enterpriseId) {
        EnterpriseDemandInfo edi = new EnterpriseDemandInfo();
        edi.setEnterpriseId(enterpriseId);
        return enterpriseDemandInfoDao.findFuzzily(edi, null);
    }

    @Override
    public Integer insert(EnterpriseDemandInfo enterpriseDemandInfo) {
        return enterpriseDemandInfoDao.insert(enterpriseDemandInfo);
    }

    @Override
    public Integer update(EnterpriseDemandInfo enterpriseDemandInfo) {
        return enterpriseDemandInfoDao.update(enterpriseDemandInfo);
    }

    @Override
    public Integer deleteById(Integer id) {
        return enterpriseDemandInfoDao.deleteById(id);
    }

    @Override
    public Map<Integer, String> findJobByEnterpriseName(String enterpriseName) {
        EnterpriseInfo ei = new EnterpriseInfo();
        ei.setEnterpriseName(enterpriseName);
        List<EnterpriseInfo> eiList = enterpriseInfoDao.find(ei, null);
        if (eiList.size() != 1) {
            Map<Integer, String> errorMap = new HashMap<>();
            errorMap.put(-1, "企业名不存在,或数据库有重复的企业名");
            return errorMap;
        }
        Integer enterpriseId = eiList.get(0).getId();
        EnterpriseDemandInfo edi = new EnterpriseDemandInfo();
        edi.setEnterpriseId(enterpriseId);
        List<EnterpriseDemandInfo> ediList = enterpriseDemandInfoDao.find(edi, null);
        return ediList.stream()
                .collect(Collectors.toMap(
                        EnterpriseDemandInfo::getId,
                        EnterpriseDemandInfo::getJob)
                );
    }


}
