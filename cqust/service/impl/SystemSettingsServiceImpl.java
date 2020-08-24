package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.SystemSettings;
import cn.edu.cqust.dao.SystemSettingsDao;
import cn.edu.cqust.service.SystemSettingsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-24 10:45
 * @desc:
 **/
@Service
public class SystemSettingsServiceImpl implements SystemSettingsService {

    @Resource
    private SystemSettingsDao systemSettingsDao;

    @Override
    public List<SystemSettings> findAll() {
        return systemSettingsDao.findFuzzily(new SystemSettings(), null);
    }

    @Override
    public Integer update(SystemSettings systemSettings) {
        return systemSettingsDao.update(systemSettings);
    }
}
