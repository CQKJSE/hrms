package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.OnTheJobInfo;
import cn.edu.cqust.bean.vo.*;
import cn.edu.cqust.service.OnTheJobInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-20 11:43
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class OnTheJobInfoController {

    @Resource
    private OnTheJobInfoService onTheJobInfoServiceImpl;
    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";


    @GetMapping(path = "/onTheJob")
    public List<RoOnTheJob> findByMC1(CustomerInfo customerInfo,
                                      @RequestParam(defaultValue = "1") Integer page) {
        return onTheJobInfoServiceImpl.findByMC1(customerInfo, phone, page);
    }

    @GetMapping(path = "/onTheJobCount")
    public String countByMC1(CustomerInfo customerInfo) {
        return Generator.genJsonObject(
                "count",
                onTheJobInfoServiceImpl.countByMC1(customerInfo, phone)
        );
    }

    @GetMapping(path = "/onTheJobAll")
    public List<RoOnTheJobAll> findByMC2(QoOnTheJobAll qo,
                                         @RequestParam(defaultValue = "1") Integer page) {
        return onTheJobInfoServiceImpl.findByMC2(qo, page);
    }

    @GetMapping(path = "/onTheJobAllCount")
    public String countByMC2(QoOnTheJobAll qo) {
        return Generator.genJsonObject(
                "count",
                onTheJobInfoServiceImpl.countByMC2(qo)
        );
    }

    @PostMapping(path = "/addOnTheJob")
    public String addOnTheJob(@RequestBody OnTheJobInfo onTheJobInfo) {
        System.out.println(onTheJobInfo.getCustomerId());
        return Generator.genJsonStatusCode(onTheJobInfoServiceImpl.addOnTheJob(onTheJobInfo));
    }

    @PostMapping(path = "/updateOnTheJob")
    public String addOnTheJob(QoUpdateOnTheJob qo) {
        return Generator.genJsonStatusCode(onTheJobInfoServiceImpl.updateAndRelated1(qo));
    }

}
