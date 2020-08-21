package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.vo.RoSettlement;
import cn.edu.cqust.service.SettlementInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class SettlementInfoController {

    @Resource
    private SettlementInfoService settlementInfoServiceImpl;
    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";


    @GetMapping(path = "/settlement")
    public List<RoSettlement> findByMC1(CustomerInfo customerInfo,
                                        @RequestParam(defaultValue = "0") String state,
                                        @RequestParam(defaultValue = "1") Integer page) {
        return settlementInfoServiceImpl.findByMC1(customerInfo, phone, state, page);
    }

    @GetMapping(path = "/settlementCount")
    public String countByMC1(CustomerInfo customerInfo,
                             @RequestParam(defaultValue = "0") String state) {
        return Generator.genJsonObject(
                "count",
                settlementInfoServiceImpl.countByMC1(customerInfo, phone, state)
        );
    }

    @GetMapping(path = "/settlementAll")
    public List<RoSettlement> findByMC2(CustomerInfo customerInfo,
                                        @RequestParam(defaultValue = "0") String state,
                                        @RequestParam(defaultValue = "1") Integer page) {
        return settlementInfoServiceImpl.findByMC2(customerInfo,  state, page);
    }

    @GetMapping(path = "/settlementAllCount")
    public String countByMC2(CustomerInfo customerInfo,
                             @RequestParam(defaultValue = "0") String state) {
        return Generator.genJsonObject(
                "count",
                settlementInfoServiceImpl.countByMC2(customerInfo, state)
        );
    }

}
