package cn.edu.cqust.task;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.SignUpInfo;
import cn.edu.cqust.dao.CustomerInfoDao;
import cn.edu.cqust.dao.SignUpInfoDao;
import cn.edu.cqust.util.DateUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-15 11:19
 * @desc: 报名名单定时任务 (40)
 **/
@Component
@EnableScheduling
public class SuiAutoTask {

    @Resource
    private SignUpInfoDao signUpInfoDao;
    @Resource
    private CustomerInfoDao customerInfoDao;

    /**
     * @desc 将sign_up_info（报名名单）中state（状态）为0的提取出来. 获取当前时间,
     *       如果当前时间大于提取出来的数据interviewTime（面试时间）, 则将sign_up_info
     *       （报名名单）中这条数据的state（状态）改为1, note（备注）置为退回, 同时将
     *       customer_info（公海）这条数据中的state（状态）改为0.
     *       # 每日凌晨1点触发 (01 : 00)
     * @return void
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void SuiTask1() {
        // TODO: 2020/8/15  解除注释即可装载定时任务
        /*List<SignUpInfo> suiList = signUpInfoDao.findByState(0);
        String currentTime = DateUtil.getYMD();
        for (SignUpInfo tempSui : suiList) {
            if (currentTime.compareTo(tempSui.getInterviewTime()) >= 1) {
                tempSui.setState(1);
                tempSui.setNote("退回");
                CustomerInfo tempCi = new CustomerInfo();
                tempCi.setId(tempSui.getCustomerId());
                tempCi.setState("0");
                signUpInfoDao.update(tempSui);
                customerInfoDao.update(tempCi);
            }
        }*/
    }

}
