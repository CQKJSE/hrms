package cn.edu.cqust.controller;

import cn.edu.cqust.bean.PermissionsInfo;
import cn.edu.cqust.service.PermissionsInfoService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-24 09:46
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class PermissionsInfoController {

    @Resource
    private PermissionsInfoService permissionsInfoServiceImpl;

    @GetMapping(path = "/permissions")
    public PermissionsInfo findByPhone(String phone) {
        return permissionsInfoServiceImpl.findByPhone(phone);
    }

    @GetMapping(path = "/addPermissions")
    public String addPermissions(PermissionsInfo permissionsInfo) {
        return Generator.genJsonStatusCode(
                permissionsInfoServiceImpl.insertOrUpdateIfExist(permissionsInfo)
        );
    }

}
