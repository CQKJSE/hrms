package cn.edu.cqust.controller;

import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesDeparture;
import cn.edu.cqust.bean.EnterpriseContractInfo;
import cn.edu.cqust.bean.EnterpriseDemandInfo;
import cn.edu.cqust.bean.vo.RoDeparture;
import cn.edu.cqust.service.EnterpriseContractInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 16:21
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class EnterpriseContractInfoController {

    @Resource
    private EnterpriseContractInfoService enterpriseContractInfoServiceImpl;


    @GetMapping(path = "/enterpriseContract")
    public List<EnterpriseContractInfo> findByName(String enterpriseName,
                                                   @RequestParam(defaultValue = "1") Integer page) {
        return enterpriseContractInfoServiceImpl.findByName(enterpriseName, page);
    }

    @GetMapping(path = "/enterpriseContractCount")
    public String countByName(String enterpriseName) {
        return Generator.genJsonObject(
                "count",
                enterpriseContractInfoServiceImpl.countByName(enterpriseName)
        );
    }

    @PostMapping(path = "/deleteEnterpriseContract")
    public String delete(Integer id) {
        return Generator.genJsonStatusCode(
                enterpriseContractInfoServiceImpl.deleteById(id)
        );
    }

    @PostMapping(path = "/addEnterpriseContract")
    public String insert(EnterpriseContractInfo enterpriseContractInfo) {
        return Generator.genJsonStatusCode(
                enterpriseContractInfoServiceImpl.insert(enterpriseContractInfo)
        );
    }

    @PostMapping(path = "/updateEnterpriseContract")
    public String update(EnterpriseContractInfo enterpriseContractInfo) {
        return Generator.genJsonStatusCode(
                enterpriseContractInfoServiceImpl.update(enterpriseContractInfo)
        );
    }


}
