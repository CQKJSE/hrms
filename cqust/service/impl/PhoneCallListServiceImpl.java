package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.vo.RoCallList;
import cn.edu.cqust.dao.PhoneCallListDao;
import cn.edu.cqust.service.PhoneCallListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @project: HRMS
 * @author: F.C.Tang
 * @date: 2020-08-05 17:33
 * @desc:
 **/
@Service
@Transactional
public class PhoneCallListServiceImpl implements PhoneCallListService {

    @Resource
    private PhoneCallListDao phoneCallListDao;

    @Override
    public List<RoCallList> findByMC1(CustomerInfo customerInfo,
                                      Integer pageNumber,
                                      String phone) {
        return phoneCallListDao.findByMC1(customerInfo, (pageNumber - 1) * 10, phone);
    }

    @Override
    public Integer findCountByMC1(CustomerInfo customerInfo, String phone) {
        return phoneCallListDao.findCountByMC1(customerInfo, phone);
    }

    @Override
    public List<RoCallList> findByMC2(CustomerInfo customerInfo,
                                      Integer pageNumber,
                                      String phone) {
        return phoneCallListDao.findByMC2(customerInfo, (pageNumber - 1) * 10, phone);
    }

    @Override
    public Integer findCountByMC2(CustomerInfo customerInfo, String phone) {
        return phoneCallListDao.findCountByMC2(customerInfo, phone);
    }

    @Override
    public Integer deleteById(Integer id) {
        return phoneCallListDao.deleteById(id);
    }
}
