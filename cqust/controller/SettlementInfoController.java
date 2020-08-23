package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.SettlementInfo;
import cn.edu.cqust.bean.vo.RoSettlement;
import cn.edu.cqust.service.SettlementInfoService;
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
public class SettlementInfoController {

    @Resource
    private SettlementInfoService settlementInfoServiceImpl;
    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";


    @GetMapping(path = "/settlement")
    public List<RoSettlement> findByMC1(CustomerInfo customerInfo,
                                        String settlementState,
                                        @RequestParam(defaultValue = "1") Integer page) {
        return settlementInfoServiceImpl.findByMC1(customerInfo, phone, settlementState, page);
    }

    @GetMapping(path = "/settlementCount")
    public String countByMC1(CustomerInfo customerInfo,
                             String settlementState) {
        return Generator.genJsonObject(
                "count",
                settlementInfoServiceImpl.countByMC1(customerInfo, phone, settlementState)
        );
    }

    @GetMapping(path = "/settlementAll")
    public List<RoSettlement> findByMC2(CustomerInfo customerInfo,
                                        String settlementState,
                                        @RequestParam(defaultValue = "1") Integer page) {
        System.out.println(customerInfo.getIdNumber());
        return settlementInfoServiceImpl.findByMC2(customerInfo,  settlementState, page);
    }

    @GetMapping(path = "/settlementAllCount")
    public String countByMC2(CustomerInfo customerInfo,
                             String settlementState) {
        return Generator.genJsonObject(
                "count",
                settlementInfoServiceImpl.countByMC2(customerInfo, settlementState)
        );
    }

    @PostMapping(path = "/updateSettlement")
    public String update(SettlementInfo settlementInfo) {
        return Generator.genJsonStatusCode(
                settlementInfoServiceImpl.update(settlementInfo)
        );
    }

}
