package cn.edu.cqust.task;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.InterviewInfo;
import cn.edu.cqust.bean.SignUpInfo;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.InterviewInfoDao;
import cn.edu.cqust.dao.SignUpInfoDao;
import cn.edu.cqust.util.DateUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-15 11:20
 * @desc: 面试名单定时任务 (41)
 **/
@Component
@EnableScheduling
public class IiAutoTask {

    @Resource
    private InterviewInfoDao interviewInfoDao;
    @Resource
    private CustomerInfoDao customerInfoDao;
    @Resource
    private SignUpInfoDao signUpInfoDao;

    /**
     * @desc 将interview_info（面试名单）中state（状态）为0的提取出来, 获取当前时间,
     *       如果当前时间大于提取出来的数据interviewTime（面试时间）, 则将interview_info
     *      （面试名单）中这条数据的state（状态）改为1, note（备注）置为退回, 同时将customer_info
     *      （公海）这条数据中的state（状态）改为0
     *       # 每日凌晨1点触发 (01 : 00)
     * @return void
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void iiTask1() {
        // TODO: 2020/8/15  解除注释即可装载定时任务
        /*List<InterviewInfo> iiList = interviewInfoDao.findByState(0);
        Set<Integer> suiIdSet = iiList.stream()
                .map(InterviewInfo::getSignUpId)
                .collect(Collectors.toSet());
        //克隆, 防止并发修改异常
        Set<Integer> suiIdSet2 = new HashSet<>(suiIdSet);

        String currentTime = DateUtil.getYMD();
        //移除'当前时间<=interviewTime'的数据 (不做更新)
        for (Integer tempId : suiIdSet) {
            SignUpInfo signUpInfo = signUpInfoDao.findById(tempId);
            if (currentTime.compareTo(signUpInfo.getInterviewTime()) <= 0) {
                suiIdSet2.remove(tempId);
            }
        }

        for (InterviewInfo tempIi : iiList) {
            if (suiIdSet2.contains(tempIi.getSignUpId())) {
                tempIi.setState(1);
                tempIi.setNote("退回");
                CustomerInfo tempCi = new CustomerInfo();
                tempCi.setId(tempIi.getCustomerId());
                tempCi.setState("0");
                interviewInfoDao.update(tempIi);
                customerInfoDao.update(tempCi);
            }
        }*/
    }

}
