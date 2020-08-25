package cn.edu.cqust.controller;

import cn.edu.cqust.service.AllocationService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-15 11:05
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class AllocationController {

    @Resource
    private AllocationService allocationServiceImpl;
    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";


    /**
     * @desc 为当前登录的业务员自动分配一条
     * @return {"statusCode":状态码} (1表示成功)
     */
    @GetMapping(path = "/takeOutAll")
    public String allocateOne() {
        return Generator.genJsonStatusCode(allocationServiceImpl.allocateOne(phone));
    }


    /**
     * @desc 为当前登录的业务员自动分配一条(分配的customer的addTime在90天内)
     * @return {"statusCode":状态码} (1表示成功)
     */
    @GetMapping(path = "/takeOut")
    public String allocateOneAfterTimeLimit() {
        return Generator.genJsonStatusCode(allocationServiceImpl.allocateOneAfterTimeLimit(phone));
    }


    /**
     * @desc 为当前登录的业务员自动分配一条
     * @return {"statusCode":状态码}
     *          1 ---> 成功
     *         -2 ---> ci中对应的state==0
     *         -3 ---> 两键重复
     */
    @PostMapping(path = "/distribution")
    public String allocateOne2(Integer id, Integer employeeId) {
        return Generator.genJsonStatusCode(
                allocationServiceImpl.allocateOne2(id, employeeId)
        );
    }



}
