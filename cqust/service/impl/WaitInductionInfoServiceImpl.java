package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.InterviewInfo;
import cn.edu.cqust.bean.PhoneCallList;
import cn.edu.cqust.bean.WaitInductionInfo;
import cn.edu.cqust.bean.vo.*;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.InterviewInfoDao;
import cn.edu.cqust.dao.PhoneCallListDao;
import cn.edu.cqust.dao.WaitInductionInfoDao;
import cn.edu.cqust.service.WaitInductionInfoService;
import cn.edu.cqust.util.BeanHelper;
import cn.edu.cqust.util.DateUtil;
import cn.edu.cqust.util.PagingUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-12 10:51
 * @desc:
 **/
@Service
public class WaitInductionInfoServiceImpl implements WaitInductionInfoService {

    @Resource
    private WaitInductionInfoDao waitInductionInfoDao;
    @Resource
    private CustomerInfoDao customerInfoDao;
    @Resource
    private PhoneCallListDao phoneCallListDao;
    @Resource
    private InterviewInfoDao interviewInfoDao;


    @Override
    public List<RoWaitInduction> findByMC1(CustomerInfo customerInfo, Integer pageNumber, String employeePhone) {
        return waitInductionInfoDao.findByMC1(customerInfo, (pageNumber - 1) * 10, employeePhone);
    }

    @Override
    public Integer countByMC1(CustomerInfo customerInfo, String employeePhone) {
        return waitInductionInfoDao.countByMC1(customerInfo, employeePhone);
    }

    @Override
    public Integer updateAndRelated1(QoUpdateWaitInduction qo) {
        WaitInductionInfo waitInductionInfo = waitInductionInfoDao.findById(qo.getId());
        if (waitInductionInfo == null) {
            return -1;
        }
        int ciId = waitInductionInfo.getCustomerId();
        int pclId = waitInductionInfo.getPhoneCallListId();
        CustomerInfo ci = new CustomerInfo();
        PhoneCallList pcl = new PhoneCallList();
        WaitInductionInfo wii = new WaitInductionInfo();

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
        //set wait_induction_info update param
        wii.setId(qo.getId());
        wii.setDelayTime(qo.getDelayTime());
        //declare operationCode
        int s1 = -1;
        int s2 = -1;
        int s3 = -1;
        //check if all bean's field is empty, and get operationCode
        if (!BeanHelper.isEmptyBean(ci, "id"))
            s1 = customerInfoDao.update(ci);
        if (!BeanHelper.isEmptyBean(pcl, "id"))
            s2 = phoneCallListDao.update(pcl);
        if (!BeanHelper.isEmptyBean(wii, "id"))
            s3 = waitInductionInfoDao.update(wii);

        //return true if update at least 1 table
        return (s1 == 1 || s2 == 1 || s3 == 1) ? 1 : -1;
    }

    @Override
    public Integer addWaitInduction(WaitInductionInfo waitInductionInfo) {
        waitInductionInfo.setInterviewQualifiedTime(DateUtil.getYMD());
        waitInductionInfo.setState("待入职");
        waitInductionInfo.setStateOne(0);
        InterviewInfo interviewInfo = interviewInfoDao.findById(waitInductionInfo.getInterviewId());
        interviewInfo.setState(1);
        interviewInfo.setNote("通过");
        int s1 = waitInductionInfoDao.insert(waitInductionInfo);
        int s2 = interviewInfoDao.update(interviewInfo);
        return (s1 == 1 && s2 == 1) ? 1 : -1;
    }

    @Override
    public List<RoWaitInduction> findByMC2(QoWaitInductionAll qo, Integer pageNumber) {
        return waitInductionInfoDao.findByMC2(qo, (pageNumber - 1) * 10);
    }

    @Override
    public Integer countByMC2(QoWaitInductionAll qo) {
        return waitInductionInfoDao.findByMC2(qo, null).size();
    }

    @Override
    public Integer addDelay(WaitInductionInfo waitInductionInfo) {
        InterviewInfo ii1 = new InterviewInfo();
        ii1.setCustomerId(waitInductionInfo.getCustomerId());
        ii1.setPhoneCallListId(waitInductionInfo.getPhoneCallListId());
        ii1.setEmployeeId(waitInductionInfo.getEmployeeId());
        List<InterviewInfo> iiList = interviewInfoDao.find(ii1);
        if (iiList.size() != 1)
            //存在多个待更新对象
            return -1;
        InterviewInfo ii2 = iiList.get(0);
        waitInductionInfo.setInterviewQualifiedTime(DateUtil.getYMD());
        waitInductionInfo.setState("待入职");
        waitInductionInfo.setStateOne(0);
        ii2.setState(1);
        ii2.setNote("通过");

        if (interviewInfoDao.update(ii2) != 1)
            return -1;
        return waitInductionInfoDao.insert(waitInductionInfo) == 1 ? 1 : -1;
    }


    @Override
    public Integer backWaitInduction(WaitInductionInfo waitInductionInfo) {
        String preNote = waitInductionInfo.getNote();
        waitInductionInfo = waitInductionInfoDao.findById(waitInductionInfo.getId());

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(waitInductionInfo.getCustomerId());
        customerInfo.setState("0");
        waitInductionInfo.setStateOne(1);
        waitInductionInfo.setNote(preNote);

        if (waitInductionInfoDao.update(waitInductionInfo) != 1)
            return -1;
        return customerInfoDao.update(customerInfo) == 1 ? 1 : -1;
    }

    @Override
    public Integer updateAndRelated2(QoUpdateWaitInductionGroup qo) {
        WaitInductionInfo wii = waitInductionInfoDao.findById(qo.getId());
        wii.setState(qo.getState());
        wii.setMedicalQualifiedTime(qo.getMedicalQualifiedTime());
        wii.setDelayTime(qo.getDelayTime());
        CustomerInfo ci = new CustomerInfo();
        ci.setId(wii.getCustomerId());
        ci.setName(qo.getName());
        ci.setIdNumber(qo.getIdNumber());
        ci.setGender(qo.getGender());
        ci.setAge(qo.getAge());
        ci.setPhoneNumber(qo.getPhoneNumber());
        ci.setEducation(qo.getEducation());
        ci.setAddress(qo.getAddress());
        ci.setProfessionalSkills(qo.getProfessionalSkills());
        ci.setHasCertificate(qo.getHasCertificate());
        ci.setIsDisability(qo.getIsDisability());
        PhoneCallList pcl = new PhoneCallList();
        pcl.setId(wii.getPhoneCallListId());
        pcl.setRecommendEnterprise(qo.getRecommendEnterprise());
        pcl.setRecommendJob(qo.getRecommendJob());

        int s1 = -1;
        int s2 = -1;
        int s3 = -1;
        if (!BeanHelper.isEmptyBean(ci, "id"))
            s1 = customerInfoDao.update(ci);
        if (!BeanHelper.isEmptyBean(pcl, "id"))
            s2 = phoneCallListDao.update(pcl);
        if (!BeanHelper.isEmptyBean(wii, "id"))
            s3 = waitInductionInfoDao.update(wii);
        return (s1 == 1 || s2 == 1 || s3 == 1) ? 1 : -1;
    }

    @Override
    public List<RoWaitInductionGroup> findByMC3(CustomerInfo customerInfo, Integer pageNumber, String deptName, String employeeName) {
        return waitInductionInfoDao.findByMC3(
                customerInfo, (pageNumber - 1) * 10,
                deptName, employeeName
        );
    }

    @Override
    public Integer countByMC3(CustomerInfo customerInfo, String deptName, String employeeName) {
        return waitInductionInfoDao.findByMC3(
                customerInfo, null,
                deptName, employeeName
        ).size();
    }

    @Override
    public List<RoWaitInductionAllMarket> findByMC4(QoWaitInductionAllMarket qo, String headName, Integer pageNumber) {
        qo.setStateOne("0");
        qo.setHeadName(headName);
        return waitInductionInfoDao.findByMC4(qo, PagingUtil.paging(pageNumber));
    }

    @Override
    public Integer countByMC4(QoWaitInductionAllMarket qo, String headName) {
        qo.setStateOne("0");
        qo.setHeadName(headName);
        return waitInductionInfoDao.findByMC4(qo, null).size();
    }


}
