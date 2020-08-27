package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.InterviewInfo;
import cn.edu.cqust.bean.vo.QoInterviewListAllMarket;
import cn.edu.cqust.bean.vo.RoInterviewList;
import cn.edu.cqust.bean.vo.RoInterviewListAll;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.service.InterviewInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-11 15:32
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class InterviewInfoController {

    @Resource
    private InterviewInfoService interviewInfoServiceImpl;
    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";
    // TODO: 2020/8/6 session域中获取的部门
    private String deptName = "网招2部";
    // TODO: 2020/8/25 session域中获取的企业负责人名
    private String headName = "唐";


    @ResponseBody
    @GetMapping(path = "/interviewList")
    public List<RoSignUpList> findByMC1(CustomerInfo customerInfo,
                                        @RequestParam(defaultValue = "1") Integer page) {
        return interviewInfoServiceImpl.findByMC1(customerInfo, page, phone);
    }

    @ResponseBody
    @GetMapping(path = "/interviewListCount")
    public String countByMC1(CustomerInfo customerInfo) {
        System.out.println(customerInfo.getName());
        return Generator.genJsonObject("count", interviewInfoServiceImpl.countByMC1(customerInfo, phone));
    }

    @PostMapping(path = "/addInterview")
    public String addInterview(@RequestBody InterviewInfo interviewInfo) {
        System.out.println(interviewInfo);
        return Generator.genJsonStatusCode(interviewInfoServiceImpl.addInterview(interviewInfo));
    }

    @GetMapping(path = "/interviewListAll")
    public List<RoInterviewListAll> findByMC2(CustomerInfo customerInfo,
                                              @RequestParam(defaultValue = "") String recommendEnterprise,
                                              @RequestParam(defaultValue = "") String interviewTime,
                                              @RequestParam(defaultValue = "") String deptName,
                                              @RequestParam(defaultValue = "") String employeeName,
                                              @RequestParam(defaultValue = "1") Integer page) {
        System.out.println(employeeName);
        return interviewInfoServiceImpl.findByMC2(
                customerInfo, recommendEnterprise,
                interviewTime, deptName,
                employeeName, page
        );
    }

    @GetMapping(path = "/interviewListAllCount")
    public String countByMC2(CustomerInfo customerInfo, String recommendEnterprise,
                             String interviewTime, String deptName, String employeeName) {

        return Generator.genJsonObject("count", interviewInfoServiceImpl.countByMC2(
                customerInfo, recommendEnterprise,
                interviewTime, deptName, employeeName)
        );
    }

    @PostMapping(path = "/backInterview")
    public String backInterview(@RequestBody InterviewInfo interviewInfo) {
        System.out.println(interviewInfo.getId());
        System.out.println(interviewInfo.getNote());
        return Generator.genJsonStatusCode(
                interviewInfoServiceImpl.backInterview(interviewInfo)
        );
    }

    @GetMapping(path = "/interviewListGroup")
    public List<RoInterviewList> findByMC3(CustomerInfo customerInfo,
                                           @RequestParam(defaultValue = "1") Integer page,
                                           String employeeName) {
        return interviewInfoServiceImpl.findByMC3(
                customerInfo, page, deptName, employeeName
        );
    }

    @GetMapping(path = "/interviewListGroupCount")
    public String countByMC3(CustomerInfo customerInfo, String employeeName) {
        return Generator.genJsonObject(
                "count",
                interviewInfoServiceImpl.countByMC3(
                        customerInfo, deptName, employeeName
                )
        );
    }

    @GetMapping(path = "/interviewListAllMarket")
    public List<RoInterviewListAll> findByMC4(QoInterviewListAllMarket qo,
                                              @RequestParam(defaultValue = "1") Integer page) {
        return interviewInfoServiceImpl.findByMC4(qo, headName, page);
    }

    @GetMapping(path = "/interviewListAllMarketCount")
    public String countByMC4(QoInterviewListAllMarket qo) {
        return Generator.genJsonObject(
                "count",
                interviewInfoServiceImpl.countByMC4(qo, headName)
        );
    }

}
