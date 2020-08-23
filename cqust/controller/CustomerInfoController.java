package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.service.CustomerInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-13 22:21
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class CustomerInfoController {

    @Resource
    private CustomerInfoService customerInfoServiceImpl;
    // TODO: 2020/8/13 session中employee的名字和电话
    private String name = "唐封成";
    private String phone = "15998984122";

    @PostMapping(path = "/addPhone")
    public String addOne(@RequestBody CustomerInfo customerInfo) {
        System.out.println(customerInfo.getName());
        return Generator.genJsonStatusCode(
                customerInfoServiceImpl.addOne(customerInfo, name, phone)
        );
    }
}
