package cn.edu.cqust.task;

import cn.edu.cqust.util.PclAllocator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-07 09:12
 * @desc: phone_call_list定时任务 (13:定时分配名单)
 **/
@Component
@EnableScheduling
public class PclAutoTask {

    @Resource
    private PclAllocator pclAllocator;

    /**
     * @desc 给每一个业务员+组长分配,
     *       # 每日凌晨1点触发 (01 : 00)
     * @return void
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void autoAllocationForAll() {
        // TODO: 2020/8/15  解除注释即可装载定时任务
        /*allocator.initData();
        allocator.allocateAll();
        allocator.insertResult();*/
    }


}
