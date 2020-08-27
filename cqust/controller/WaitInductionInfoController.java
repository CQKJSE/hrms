package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.WaitInductionInfo;
import cn.edu.cqust.bean.vo.*;
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
    // TODO: 2020/8/6 session域中获取的部门
    private String deptName = "网招2部";
    // TODO: 2020/8/25 session域中获取的企业负责人名
    private String headName = "张";

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
    @RequestMapping(path = "/updateWaitInduction", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String updateSignUpInfoAndRelated(QoUpdateWaitInduction qo) {
        return Generator.genJsonStatusCode(waitInductionInfoServiceImpl.updateAndRelated1(qo));
    }

    @PostMapping(path = "/addWaitInduction")
    public String addWaitInduction(@RequestBody WaitInductionInfo waitInductionInfo) {
        System.out.println(waitInductionInfo.getInterviewId());
        System.out.println(waitInductionInfo.getCustomerId());
        System.out.println(waitInductionInfo.getPhoneCallListId());
        System.out.println(waitInductionInfo.getEmployeeId());
        return Generator.genJsonStatusCode(
                waitInductionInfoServiceImpl.addWaitInduction(waitInductionInfo)
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
    public String backWaitInduction(@RequestBody WaitInductionInfo waitInductionInfo) {
        System.out.println(waitInductionInfo.getId());
        return Generator.genJsonStatusCode(
                waitInductionInfoServiceImpl.backWaitInduction(waitInductionInfo)
        );
    }

    @PostMapping(path = "/updateWaitInductionGroup")
    public String updateSignUpInfoAndRelated(QoUpdateWaitInductionGroup qo) {
        return Generator.genJsonStatusCode(waitInductionInfoServiceImpl.updateAndRelated2(qo));
    }

    @GetMapping(path = "/waitInductionGroup")
    public List<RoWaitInductionGroup> findByMC3(CustomerInfo customerInfo,
                                             @RequestParam(defaultValue = "1") Integer page,
                                             String employeeName) {
        return waitInductionInfoServiceImpl.findByMC3(
                customerInfo, page, deptName, employeeName
        );
    }

    @GetMapping(path = "/waitInductionGroupCount")
    public String countByMC3(CustomerInfo customerInfo, String employeeName) {
        return Generator.genJsonObject(
                "count",
                waitInductionInfoServiceImpl.countByMC3(
                        customerInfo, deptName, employeeName
                )
        );
    }

    @GetMapping(path = "/waitInductionAllMarket")
    public List<RoWaitInductionAllMarket> findByMC4(QoWaitInductionAllMarket qo,
                                                    @RequestParam(defaultValue = "1") Integer page) {
        return waitInductionInfoServiceImpl.findByMC4(qo, headName, page);
    }

    @GetMapping(path = "/waitInductionAllMarketCount")
    public String countByMC4(QoWaitInductionAllMarket qo) {
        return Generator.genJsonObject(
                "count",
                waitInductionInfoServiceImpl.countByMC4(qo, headName)
        );
    }

}
