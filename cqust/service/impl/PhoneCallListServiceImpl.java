package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneCallList;
import cn.edu.cqust.bean.vo.QoPclAndCi;
import cn.edu.cqust.bean.vo.RoCallList;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.PhoneCallListDao;
import cn.edu.cqust.service.PhoneCallListService;
import cn.edu.cqust.util.BeanHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Resource
    private CustomerInfoDao customerInfoDao;


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

    @Override
    public Integer updateWithCi(QoPclAndCi qo) {
        PhoneCallList pcl = new PhoneCallList();
        CustomerInfo ci = new CustomerInfo();
        ci.setId(qo.getCiId());
        ci.setName(qo.getName());
        ci.setGender(qo.getGender());
        ci.setAge(qo.getAge());
        ci.setPhoneNumber(qo.getPhoneNumber());
        ci.setEducation(qo.getEducation());
        ci.setAddedTime(qo.getAddress());
        ci.setProfessionalSkills(qo.getProfessionalSkills());
        ci.setHasCertificate(qo.getHasCertificate());
        ci.setSourceOfData(qo.getSourceOfData());
        ci.setNote(qo.getNote());
        pcl.setId(qo.getPclId());
        pcl.setIsWechatAdded(qo.getIsWechatAdded());
        pcl.setRecommendEnterprise(qo.getRecommendEnterprise());
        pcl.setRecommendJob(qo.getRecommendJob());

        int s1 = -1;
        int s2 = -1;
        if (!BeanHelper.isEmptyBean(ci, "id"))
            s1 = customerInfoDao.update(ci);
        if (!BeanHelper.isEmptyBean(pcl, "id"))
            s2 = phoneCallListDao.update(pcl);
        return (s1 == 1 || s2 == 1) ? 1 : -1;
    }
}
