package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.InterviewInfo;
import cn.edu.cqust.bean.SignUpInfo;
import cn.edu.cqust.bean.vo.RoInterviewListAll;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.bean.vo.RoSignUpListAll;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.InterviewInfoDao;
import cn.edu.cqust.dao.SignUpInfoDao;
import cn.edu.cqust.service.InterviewInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-11 15:32
 * @desc:
 **/
@Service
public class InterviewInfoServiceImpl implements InterviewInfoService {

    @Resource
    private InterviewInfoDao interviewInfoDao;
    @Resource
    private SignUpInfoDao signUpInfoDao;
    @Resource
    private CustomerInfoDao customerInfoDao;

    @Override
    public List<RoSignUpList> findByMC1(CustomerInfo customerInfo, Integer pageNumber, String employeePhone) {
        return interviewInfoDao.findByMC1(customerInfo, (pageNumber - 1) * 10, employeePhone);
    }

    @Override
    public Integer countByMC1(CustomerInfo customerInfo, String employeePhone) {
        return interviewInfoDao.countByMC1(customerInfo, employeePhone);
    }

    @Override
    public Integer addInterview(InterviewInfo interviewInfo) {
        interviewInfo.setState(0);
        SignUpInfo signUpInfo = new SignUpInfo();
        signUpInfo.setId(interviewInfo.getSignUpId());
        signUpInfo.setState(1);
        signUpInfo.setNote("通过");
        int s1 = interviewInfoDao.insert(interviewInfo);
        int s2 = signUpInfoDao.update(signUpInfo);
        return (s1 == 1 && s2 == 1) ? 1 : -1;
    }

    @Override
    public List<RoInterviewListAll> findByMC2(CustomerInfo customerInfo, String recommendEnterprise,
                                              String interviewTime, String deptName,
                                              String employeeName, Integer pageNumber) {
        return interviewInfoDao.findByMC2(
                customerInfo, recommendEnterprise,
                interviewTime, deptName,
                employeeName, (pageNumber - 1) * 10,
                0)
                .stream()
                .sorted(Comparator.comparing(RoInterviewListAll::getInterviewTime).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Integer countByMC2(CustomerInfo customerInfo, String recommendEnterprise,
                              String interviewTime, String deptName, String employeeName) {
        return interviewInfoDao.countByMC2(
                customerInfo, recommendEnterprise,
                interviewTime, deptName, employeeName, 0
        );
    }

    @Override
    public Integer backInterview(InterviewInfo interviewInfo) {
        String preNote = interviewInfo.getNote();
        interviewInfo = interviewInfoDao.findById(interviewInfo.getId());
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(interviewInfo.getCustomerId());
        customerInfo.setState("0");
        interviewInfo.setState(1);
        interviewInfo.setNote(preNote);
        int s1 = interviewInfoDao.update(interviewInfo);
        int s2 = customerInfoDao.update(customerInfo);
        return (s1 == 1 && s2 == 1) ? 1 : -1;
    }
}
