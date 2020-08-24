package cn.edu.cqust.controller;

import cn.edu.cqust.bean.SystemSettings;
import cn.edu.cqust.service.SystemSettingsService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-24 10:45
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class SystemSettingsController {

    @Resource
    private SystemSettingsService systemSettingsServiceImpl;

    @GetMapping(path = "/systemSettings")
    public List<SystemSettings> findAll() {
        return systemSettingsServiceImpl.findAll();
    }

    @PostMapping(path = "/updateSystemSettings")
    public String update(SystemSettings systemSettings) {
        return Generator.genJsonStatusCode(
                systemSettingsServiceImpl.update(systemSettings)
        );
    }

}
