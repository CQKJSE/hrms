package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.EnterpriseHeadInfo;
import cn.edu.cqust.dao.EnterpriseHeadInfoDao;
import cn.edu.cqust.service.EnterpriseHeadInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 11:28
 * @desc:
 **/
@Service
public class EnterpriseHeadInfoServiceImpl implements EnterpriseHeadInfoService {

    @Resource
    private EnterpriseHeadInfoDao enterpriseHeadInfoDao;


    @Override
    public List<String> findEmployeeNameByEnterpriseName(String enterpriseName) {
        EnterpriseHeadInfo ehi = new EnterpriseHeadInfo();
        ehi.setEnterpriseName(enterpriseName);
        List<EnterpriseHeadInfo> ehiList = enterpriseHeadInfoDao.find(ehi, null);
        return ehiList.stream()
                .map(EnterpriseHeadInfo::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, String> findByEmployeeName(String employeeName) {
        EnterpriseHeadInfo ehi = new EnterpriseHeadInfo();
        ehi.setName(employeeName);
        List<EnterpriseHeadInfo> ehiList = enterpriseHeadInfoDao.find(ehi, null);

        return ehiList.stream()
                .collect(Collectors.toMap(
                        EnterpriseHeadInfo::getId,
                        EnterpriseHeadInfo::getEnterpriseName
                ));
    }

    @Override
    public Integer insert(EnterpriseHeadInfo enterpriseHeadInfo) {
        return enterpriseHeadInfoDao.insert(enterpriseHeadInfo);
    }


    @Override
    public Integer deleteById(Integer id) {
        return enterpriseHeadInfoDao.deleteById(id);
    }
}
