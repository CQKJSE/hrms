package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneCallList;
import cn.edu.cqust.bean.SignUpInfo;
import cn.edu.cqust.bean.vo.QoUpdateSignUp;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.bean.vo.RoSignUpListAll;
import cn.edu.cqust.bean.vo.RoSignUpListGroup;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.PhoneCallListDao;
import cn.edu.cqust.dao.SignUpInfoDao;
import cn.edu.cqust.service.SignUpInfoService;
import cn.edu.cqust.util.BeanHelper;
import cn.edu.cqust.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-10 15:39
 * @desc:
 **/
@Service
public class SignUpInfoServiceImpl implements SignUpInfoService {
    @Resource
    private SignUpInfoDao signUpInfoDao;
    @Resource
    private CustomerInfoDao customerInfoDao;
    @Resource
    private PhoneCallListDao phoneCallListDao;

    @Override
    public Integer signUp(SignUpInfo signUpInfo) {
        signUpInfo.setSignUpTime(DateUtil.getYMD());
        signUpInfo.setState(0);
        int s1 = signUpInfoDao.insert(signUpInfo);
        // update ci's state
        CustomerInfo ci = new CustomerInfo();
        ci.setId(signUpInfo.getCustomerId());
        ci.setState("1");
        int s2 = customerInfoDao.update(ci);
        return (s1 == 1 && s2 == 1) ? 1 : -1;
    }

    @Override
    public List<RoSignUpList> findByMC1(CustomerInfo customerInfo,
                                        Integer pageNumber,
                                        String employeePhone) {
        return signUpInfoDao.findByMC1(customerInfo, (pageNumber - 1) * 10, employeePhone);
    }

    @Override
    public Integer countByMC1(CustomerInfo customerInfo, String employeePhone) {
        return signUpInfoDao.countByMC1(customerInfo, employeePhone);
    }

    @Override
    public Integer updateSignUpInfoAndRelated(QoUpdateSignUp qo) {
        SignUpInfo signUpInfo = signUpInfoDao.findById(qo.getSignUpInfoId());
        if (signUpInfo == null) {
            return -1;
        }
        int ciId = signUpInfo.getCustomerId();
        int pclId = signUpInfo.getPhoneCallListId();

        CustomerInfo ci = new CustomerInfo();
        PhoneCallList pcl = new PhoneCallList();
        SignUpInfo sui = new SignUpInfo();

        //set customer_info update param
        ci.setId(ciId);
        ci.setName(qo.getName());
        ci.setIdNumber(qo.getIdNumber());
        ci.setGender(qo.getGender());
        ci.setAge(qo.getAge());
        ci.setPhoneNumber(qo.getPhoneNumber());
        ci.setEducation(qo.getEducation());
        ci.setAddedPerson(qo.getAddress());
        ci.setProfessionalSkills(qo.getProfessionalSkills());
        ci.setHasCertificate(qo.getHasCertificate());
        ci.setIsDisability(qo.getIsDisability());
        //set phone_call_list update param
        pcl.setId(pclId);
        pcl.setRecommendEnterprise(qo.getRecommendEnterprise());
        pcl.setRecommendJob(qo.getRecommendJob());
        //set sign_up_info update param
        sui.setId(qo.getSignUpInfoId());
        sui.setSignUpTime(qo.getSignUpTime());
        sui.setInterviewTime(qo.getInterviewTime());
        //declare operationCode
        int s1 = -1;
        int s2 = -1;
        int s3 = -1;
        //check if all bean's field is empty, and get operationCode
        if (!BeanHelper.isEmptyBean(ci, "id"))
            s1 = customerInfoDao.update(ci);
        if (!BeanHelper.isEmptyBean(pcl, "id"))
            s2 = phoneCallListDao.update(pcl);
        if (!BeanHelper.isEmptyBean(sui, "id"))
            s3 = signUpInfoDao.update(sui);
        //return true if update at least 1 table
        return (s1 == 1 || s2 == 1 || s3 == 1) ? 1 : -1;
    }

    @Override
    public List<RoSignUpListAll> findByMC2(CustomerInfo customerInfo,
                                           String recommendEnterprise,
                                           String signUpTime,
                                           String interviewTime,
                                           String deptName,
                                           String employeeName,
                                           Integer pageNumber) {
        return signUpInfoDao.findByMC2(customerInfo,recommendEnterprise,signUpTime,interviewTime,deptName,employeeName,(pageNumber-1)*10, 0)
                .stream()
                .sorted(Comparator.comparing(RoSignUpListAll::getSignUpTime).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Integer countByMC2(CustomerInfo customerInfo,String recommendEnterprise,
                              String signUpTime,
                              String interviewTime,
                              String deptName,
                              String employeeName) {
        return signUpInfoDao.countByMC2(customerInfo,recommendEnterprise,signUpTime,interviewTime,deptName,employeeName, 0);
    }

    @Override
    public Integer backSignUp(SignUpInfo signUpInfo) {
        CustomerInfo customerInfo = new CustomerInfo();
        SignUpInfo signUpInfoFromDB = signUpInfoDao.findById(signUpInfo.getId());
        customerInfo.setId(signUpInfoFromDB.getCustomerId());
        customerInfo.setState("0");
        signUpInfo.setState(1);
        int s1 = signUpInfoDao.update(signUpInfo);
        int s2 = customerInfoDao.update(customerInfo);
        return (s1 == 1 && s2 == 1) ? 1 : -1;
    }

    @Override
    public List<RoSignUpListGroup> findByMC3(CustomerInfo customerInfo, Integer pageNumber, String deptName, String employeeName) {
        return signUpInfoDao.findByMC3(
                customerInfo, (pageNumber - 1) * 10,
                deptName, employeeName
        );
    }

    @Override
    public Integer countByMC3(CustomerInfo customerInfo, String deptName, String employeeName) {
        return signUpInfoDao.findByMC3(
                customerInfo, null,
                deptName, employeeName
        ).size();
    }
}
