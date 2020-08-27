package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneRecord;
import cn.edu.cqust.bean.vo.RoGetPhoneRecord;
import cn.edu.cqust.bean.vo.RoGetPhoneRecordAll;
import cn.edu.cqust.bean.vo.RoGetPhoneRecordDept;
import cn.edu.cqust.service.PhoneRecordService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-16 17:11
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class PhoneRecordController {

    @Resource
    private PhoneRecordService phoneRecordServiceImpl;
    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";
    // TODO: 2020/8/6 session域中获取号码
    private String deptName = "网招1部";


    @GetMapping(path = "/getPhoneRecord")
    public List<RoGetPhoneRecord> findByMC1(CustomerInfo customerInfo,
                                            @RequestParam(defaultValue = "1") Integer pageNumber) {
        return phoneRecordServiceImpl.findByMC1(customerInfo, pageNumber, phone);
    }


    @GetMapping(path = "/getPhoneRecordCount")
    public String countByMC1(CustomerInfo customerInfo) {
        return Generator.genJsonObject(
                "count",
                phoneRecordServiceImpl.countByMC1(customerInfo, phone)
        );
    }


    @GetMapping(path = "/getPhoneRecordDept")
    public List<RoGetPhoneRecordDept> findByMC2(CustomerInfo customerInfo,
                                                @RequestParam(defaultValue = "1") Integer page,
                                                String employeeName) {
        return phoneRecordServiceImpl.findByMC2(
                customerInfo, page, employeeName, deptName
        );
    }


    @GetMapping(path = "/getPhoneRecordDeptCount")
    public String countByMC2(CustomerInfo customerInfo, String employeeName) {
        return Generator.genJsonObject(
                "count",
                phoneRecordServiceImpl.countByMC2(
                        customerInfo,
                        employeeName,
                        deptName
                )
        );
    }

    @GetMapping(path = "/getPhoneRecordAll")
    public List<RoGetPhoneRecordAll> findByMC3(CustomerInfo customerInfo,
                                               @RequestParam(defaultValue = "1") Integer page,
                                               String employeeName,
                                               String deptName) {
        return phoneRecordServiceImpl.findByMC3(
                customerInfo,
                page,
                employeeName,
                deptName
        );
    }

    @GetMapping(path = "/getPhoneRecordAllCount")
    public String countByMC3(CustomerInfo customerInfo, String employeeName, String deptName) {
        return Generator.genJsonObject(
                "count",
                phoneRecordServiceImpl.countByMC3(
                        customerInfo,
                        employeeName,
                        deptName
                )
        );
    }

    @PostMapping(path = "/addPhoneRecord")
    public String addOne(@RequestBody PhoneRecord phoneRecord) {
        System.out.println(phoneRecord.getCreatetime());
        return Generator.genJsonStatusCode(phoneRecordServiceImpl.insert(phoneRecord));
    }

    @GetMapping(path = "/throughRecord")
    public String throughRecord() {
        Integer[] resArr = phoneRecordServiceImpl.countTodayByStatus(phone);
        return Generator.genJsonObject(
                "throughAll", resArr[0],
                "throughTo", resArr[1]
        );
    }

}
