package cn.edu.cqust.controller;

import cn.edu.cqust.bean.EnterpriseHeadInfo;
import cn.edu.cqust.dao.EnterpriseHeadInfoDao;
import cn.edu.cqust.service.EnterpriseHeadInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 11:28
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class EnterpriseHeadInfoController {

    @Resource
    private EnterpriseHeadInfoService enterpriseHeadInfoServiceImpl;

    @GetMapping(path = "/enterpriseHead")
    public List<String> findEmployeeNameByEnterpriseName(String enterpriseName) {
        return enterpriseHeadInfoServiceImpl.findEmployeeNameByEnterpriseName(enterpriseName);
    }


    @GetMapping(path = "/headEnterprise")
    public Map<Integer, String> findByEmployeeName(String employeeName) {
        return enterpriseHeadInfoServiceImpl.findByEmployeeName(employeeName);
    }


    @PostMapping(path = "/addEnterpriseHead")
    public String insert(EnterpriseHeadInfo enterpriseHeadInfo) {
        return Generator.genJsonStatusCode(
                enterpriseHeadInfoServiceImpl.insert(enterpriseHeadInfo)
        );
    }


    @PostMapping(path = "/deleteEnterpriseDemandHead")
    public String deleteById(Integer id) {
        return Generator.genJsonStatusCode(
                enterpriseHeadInfoServiceImpl.deleteById(id)
        );
    }
}
