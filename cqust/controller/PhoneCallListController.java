package cn.edu.cqust.controller;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.vo.RoCallList;
import cn.edu.cqust.service.PhoneCallListService;
import cn.edu.cqust.util.Generator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS
 * @author: F.C.Tang
 * @date: 2020-08-05 17:38
 * @desc:
 **/
@Controller
@RequestMapping(produces = "application/json; charset=utf-8")
public class PhoneCallListController {

    @Resource(name = "phoneCallListServiceImpl")
    private PhoneCallListService phoneCallListService;

    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";

    /**
     * @desc 多条件查询1(当日业务员的个人名单)
     * @param pageNumber 开始页码(为空默认1)
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @return 结果列表
     */
    @ResponseBody
    @GetMapping(path = "/callList")
    public List<RoCallList> findByMC1(CustomerInfo customerInfo,
                               @RequestParam(defaultValue = "1") Integer pageNumber) {
        return phoneCallListService.findByMC1(customerInfo, pageNumber, phone);
    }


    /**
     * @desc 多条件查询1, 查询满足条件的数据量(当日业务员的个人名单)
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @return {"numberOfResults":数量}
     */
    @ResponseBody
    @GetMapping(path = "/callListCount")
    public String findCountByMC1(CustomerInfo customerInfo) {
        int numberOfResults = phoneCallListService.findCountByMC1(customerInfo, phone);
        return Generator.genJsonObject("count", numberOfResults);
    }


    /**
     * @desc 多条件查询2(总名单)
     * @param pageNumber 开始页码(为空默认1)
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @return 结果列表
     */
    @ResponseBody
    @GetMapping(path = "/callAllList")
    public List<RoCallList> findByMC2(CustomerInfo customerInfo,
                               @RequestParam(defaultValue = "1") Integer pageNumber) {
        return phoneCallListService.findByMC2(customerInfo, pageNumber, phone);
    }


    /**
     * @desc 多条件查询2, 查询满足条件的数据量(总名单)
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @return {"numberOfResults":数量}
     */
    @ResponseBody
    @GetMapping(path = "/callAllListCount")
    public String findCountByMC2(CustomerInfo customerInfo) {
        int numberOfResults = phoneCallListService.findCountByMC2(customerInfo, phone);
        return Generator.genJsonObject("count", numberOfResults);
    }


    /**
     * @desc 删除标识id对应的数据
     * @param id 标识id
     * @return {"statusCode":状态码} (1表示成功)
     */
    @ResponseBody
    @GetMapping(path = "/backData")
    public String deleteById(Integer id) {
        return Generator.genJsonStatusCode(phoneCallListService.deleteById(id));
    }

}
