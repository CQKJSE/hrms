package cn.edu.cqust.controller;

import cn.edu.cqust.bean.TransactionManagement;
import cn.edu.cqust.service.TransactionManagementService;
import cn.edu.cqust.util.Generator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-06 20:19
 * @desc:
 **/
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class TransactionManagementController {

    @Resource(name = "transactionManagementServiceImpl")
    private TransactionManagementService transactionManagementService;

    // TODO: 2020/8/6 session域中获取号码
    private String phone = "15998984122";

    /**
     * @desc 根据业务员姓名查询
     * @return 结果列表
     */
    @GetMapping(path = "/getTransaction")
    public List<TransactionManagement> findByEmployeePhone() {
        return transactionManagementService.findByEmployeePhone(phone);
    }

    /**
     * @desc 删除标识id对应的数据
     * @param id 标识id
     * @return {"statusCode":状态码} (1表示成功)
     */
    @GetMapping(path = "/deleteTransaction")
    public String deleteById(Integer id) {
        return Generator.genJsonStatusCode(transactionManagementService.deleteById(id));
    }

    /**
     * @desc 添加一条数据
     * @param transactionManagement 实体对象
     * @return {"statusCode":状态码} (1表示成功)
     */
    @ResponseBody
    @RequestMapping(path = "addTransaction", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String insert(@RequestBody TransactionManagement transactionManagement) {
        transactionManagement.setEmployeePhone(phone);
        return Generator.genJsonStatusCode(transactionManagementService.insert(transactionManagement));
    }


}
