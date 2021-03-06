package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.IndustrialInjuryInfo;
import cn.edu.cqust.bean.vo.RoInjury;
import cn.edu.cqust.service.IndustrialInjuryInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-22 09:30
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class IndustrialInjuryInfoController {
    @Resource
    private IndustrialInjuryInfoService industrialInjuryInfoServiceImpl;

    @PostMapping(path = "/applyInjury")
    public String addOne(@RequestBody IndustrialInjuryInfo industrialInjuryInfo) {
        return Generator.genJsonStatusCode(industrialInjuryInfoServiceImpl.insert(industrialInjuryInfo));
    }

    @GetMapping(path = "/injury")
    public List<RoInjury> findByMC1(CustomerInfo customerInfo,
                                    @RequestParam(defaultValue = "1") Integer page) {
        return industrialInjuryInfoServiceImpl.findByMC1(
                customerInfo, page
        );
    }

    @GetMapping(path = "/injuryCount")
    public String countByMC1(CustomerInfo customerInfo) {
        return Generator.genJsonObject(
                "count",
                industrialInjuryInfoServiceImpl.countByMC1(customerInfo)
        );
    }

    @PostMapping(path = "/updateInjury")
    public String update(@RequestBody IndustrialInjuryInfo industrialInjuryInfo) {
        return Generator.genJsonStatusCode(industrialInjuryInfoServiceImpl.update(industrialInjuryInfo));
    }

}
