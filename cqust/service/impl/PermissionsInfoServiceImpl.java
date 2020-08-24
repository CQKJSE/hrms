package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.PermissionsInfo;
import cn.edu.cqust.dao.PermissionsInfoDao;
import cn.edu.cqust.service.PermissionsInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-24 09:46
 * @desc:
 **/
@Service
public class PermissionsInfoServiceImpl implements PermissionsInfoService {

    @Resource
    private PermissionsInfoDao permissionsInfoDao;

    @Override
    public PermissionsInfo findByPhone(String phone) {
        PermissionsInfo pi = new PermissionsInfo();
        pi.setPhone(phone);
        List<PermissionsInfo> rList = permissionsInfoDao.findFuzzily(pi, null);
        if (rList.size() != 1) {
            return null;
        }
        return rList.get(0);
    }

    @Override
    public Integer insertOrUpdateIfExist(PermissionsInfo permissionsInfo) {
        PermissionsInfo pi1 = new PermissionsInfo();
        pi1.setPhone(permissionsInfo.getPhone());
        List<PermissionsInfo> checkList = permissionsInfoDao.findFuzzily(pi1, null);
        int checkListSize = checkList.size();
        if (checkListSize > 1) {
            return -2;
        }
        if (checkListSize == 1) {
            permissionsInfo.setId(checkList.get(0).getId());
            return permissionsInfoDao.update(permissionsInfo);
        }
        return permissionsInfoDao.insert(permissionsInfo);
    }
}
