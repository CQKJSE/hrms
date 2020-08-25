package cn.edu.cqust.controller;

import cn.edu.cqust.bean.EnterpriseInfo;
import cn.edu.cqust.service.EnterpriseInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 08:48
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class EnterpriseInfoController {

    @Resource
    private EnterpriseInfoService enterpriseInfoServiceImpl;

    @GetMapping(path = "/enterprise")
    public List<EnterpriseInfo> findByName(String enterpriseName,
                                           @RequestParam(defaultValue = "1") Integer page) {
        return enterpriseInfoServiceImpl.findByName(enterpriseName, page);
    }

    @GetMapping(path = "/enterpriseCount")
    public String countByName(String enterpriseName) {
        return Generator.genJsonObject(
                "count",
                enterpriseInfoServiceImpl.countByName(enterpriseName)
        );
    }

    @PostMapping(path = "/deleteEnterprise")
    public String delete(Integer id) {
        return Generator.genJsonStatusCode(
                enterpriseInfoServiceImpl.deleteById(id)
        );
    }

    @PostMapping(path = "/addEnterprise")
    public String insert(EnterpriseInfo enterpriseInfo) {
        return Generator.genJsonStatusCode(
                enterpriseInfoServiceImpl.insert(enterpriseInfo)
        );
    }

    @PostMapping(path = "/updateEnterprise")
    public String update(EnterpriseInfo enterpriseInfo) {
        return Generator.genJsonStatusCode(
                enterpriseInfoServiceImpl.update(enterpriseInfo)
        );
    }

    @GetMapping(path = "/enterpriseName")
    public Map<Integer, String> findAllEnterpriseName() {
        return enterpriseInfoServiceImpl.findAllEnterpriseName();
    }


}
