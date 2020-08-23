package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.SignUpInfo;
import cn.edu.cqust.bean.vo.QoUpdateSignUp;
import cn.edu.cqust.bean.vo.RoSignUpList;
import cn.edu.cqust.bean.vo.RoSignUpListAll;
import cn.edu.cqust.bean.vo.RoSignUpListGroup;
import cn.edu.cqust.service.SignUpInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-10 16:23
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class SignUpInfoController {

    @Resource
    private SignUpInfoService signUpInfoServiceImpl;
    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";
    // TODO: 2020/8/6 session域中获取的部门
    private String deptName = "网招2部";

    @PostMapping(path = "/signUp")
    public String signUp(@RequestBody SignUpInfo signUpInfo) {
        return Generator.genJsonStatusCode(signUpInfoServiceImpl.insertAndUpdateCiSui(signUpInfo));
    }

    @ResponseBody
    @GetMapping(path = "/signUpList")
    public List<RoSignUpList> findByMC1(CustomerInfo customerInfo,
                                        @RequestParam(defaultValue = "1") Integer page) {
        return signUpInfoServiceImpl.findByMC1(customerInfo, page, phone);
    }

    @ResponseBody
    @GetMapping(path = "/signUpListCount")
    public String countByMC1(CustomerInfo customerInfo) {
        return Generator.genJsonObject("count", signUpInfoServiceImpl.countByMC1(customerInfo, phone));
    }

    @ResponseBody
    @RequestMapping(path = "updateSignUp", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String updateSignUpInfoAndRelated(@RequestBody QoUpdateSignUp qo) {
        return Generator.genJsonStatusCode(signUpInfoServiceImpl.updateAndRelated(qo));
    }

    @GetMapping(path = "/signUpListAll")
    public List<RoSignUpListAll> findByMC2(CustomerInfo customerInfo,
                                           @RequestParam(defaultValue = "1") Integer page) {
        return signUpInfoServiceImpl.findByMC2(customerInfo, page);
    }

    @GetMapping(path = "/signUpListAllCount")
    public String countByMC2(CustomerInfo customerInfo) {
        return Generator.genJsonObject("count", signUpInfoServiceImpl.countByMC2(customerInfo));
    }

    @PostMapping(path = "/backSignUp")
    public String backSignUp(@RequestBody SignUpInfo signUpInfo) {
        return Generator.genJsonStatusCode(signUpInfoServiceImpl.backSignUp(signUpInfo));
    }


    @GetMapping(path = "/signUpListGroup")
    public List<RoSignUpListGroup> findByMC3(CustomerInfo customerInfo,
                                             @RequestParam(defaultValue = "1") Integer page,
                                             String employeeName) {
        return signUpInfoServiceImpl.findByMC3(
                customerInfo, page, deptName, employeeName
        );
    }

    @GetMapping(path = "/signUpListGroupCount")
    public String countByMC3(CustomerInfo customerInfo, String employeeName) {
        return Generator.genJsonObject(
                "count",
                signUpInfoServiceImpl.countByMC3(customerInfo, deptName, employeeName)
        );
    }

}
