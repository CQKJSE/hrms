package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.InterviewInfo;
import cn.edu.cqust.bean.SignUpInfo;
import cn.edu.cqust.bean.WaitInductionInfo;
import cn.edu.cqust.bean.vo.*;
import cn.edu.cqust.service.SignUpInfoService;
import cn.edu.cqust.service.WaitInductionInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-12 11:07
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class WaitInductionInfoController {

    @Resource
    private WaitInductionInfoService waitInductionInfoServiceImpl;
    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";

    @ResponseBody
    @GetMapping(path = "/waitInduction")
    public List<RoWaitInduction> findByMC1(CustomerInfo customerInfo,
                                           @RequestParam(defaultValue = "1") Integer page) {
        return waitInductionInfoServiceImpl.findByMC1(customerInfo, page, phone);
    }

    @ResponseBody
    @GetMapping(path = "/waitInductionCount")
    public String countByMC1(CustomerInfo customerInfo) {
        return Generator.genJsonObject("count", waitInductionInfoServiceImpl.countByMC1(customerInfo, phone));
    }

    @ResponseBody
    @RequestMapping(path = "updateWaitInduction", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String updateSignUpInfoAndRelated(QoUpdateWaitInduction qo) {
        return Generator.genJsonStatusCode(waitInductionInfoServiceImpl.updateSignUpInfoAndRelated(qo));
    }

    @PostMapping(path = "/addWaitInduction")
    public String addWaitInduction(@RequestBody WaitInductionInfo waitInductionInfo, Integer id) {
        return Generator.genJsonStatusCode(
                waitInductionInfoServiceImpl.addWaitInduction(waitInductionInfo, id)
        );
    }


    @GetMapping(path = "/waitInductionAll")
    public List<RoWaitInduction> findByMC2(QoWaitInductionAll qo,
                                           @RequestParam(defaultValue = "1") Integer page) {
        return waitInductionInfoServiceImpl.findByMC2(qo, page);
    }

    @GetMapping(path = "/waitInductionAllCount")
    public String countByMC2(QoWaitInductionAll qo) {
        return Generator.genJsonObject("count", waitInductionInfoServiceImpl.countByMC2(qo));
    }

    @GetMapping(path = "/addDelay")
    public String addDelay(WaitInductionInfo waitInductionInfo) {
        return Generator.genJsonStatusCode(waitInductionInfoServiceImpl.addDelay(waitInductionInfo));
    }

    @PostMapping(path = "/backWaitInduction")
    public String backWaitInduction(WaitInductionInfo waitInductionInfo) {
        return Generator.genJsonStatusCode(
                waitInductionInfoServiceImpl.backWaitInduction(waitInductionInfo)
        );
    }

}
