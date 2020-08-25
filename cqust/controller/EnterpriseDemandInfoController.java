package cn.edu.cqust.controller;

import cn.edu.cqust.bean.EnterpriseDemandInfo;
import cn.edu.cqust.bean.EnterpriseInfo;
import cn.edu.cqust.service.EnterpriseDemandInfoService;
import cn.edu.cqust.service.EnterpriseInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 10:04
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class EnterpriseDemandInfoController {

    @Resource
    private EnterpriseDemandInfoService enterpriseDemandInfoServiceImpl;


    @GetMapping(path = "/enterpriseDemand")
    public List<EnterpriseDemandInfo> findByEiId(Integer enterpriseId) {
        return enterpriseDemandInfoServiceImpl.findByEiId(enterpriseId);
    }


    @PostMapping(path = "/deleteEnterpriseDemand")
    public String delete(Integer id) {
        return Generator.genJsonStatusCode(
                enterpriseDemandInfoServiceImpl.deleteById(id)
        );
    }

    @PostMapping(path = "/addEnterpriseDemand")
    public String insert(EnterpriseDemandInfo enterpriseDemandInfo) {
        return Generator.genJsonStatusCode(
                enterpriseDemandInfoServiceImpl.insert(enterpriseDemandInfo)
        );
    }

    @PostMapping(path = "/updateEnterpriseDemand")
    public String update(EnterpriseDemandInfo enterpriseDemandInfo) {
        return Generator.genJsonStatusCode(
                enterpriseDemandInfoServiceImpl.update(enterpriseDemandInfo)
        );
    }

    @GetMapping(path = "/enterpriseJob")
    public Map<Integer, String> findJobByEnterpriseName(String enterpriseName) {
        return enterpriseDemandInfoServiceImpl.findJobByEnterpriseName(enterpriseName);
    }


}
