package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-13 21:47
 * @desc:
 **/
public interface CustomerInfoService {

    /**
     * @desc 添加一条数据
     * @param customerInfo 待添加数据
     * @param employeeName session中职员的名字
     * @param employeePhone session中职员的电话
     * @return 操作状态
     */
    Integer addOne(CustomerInfo customerInfo, String employeeName, String employeePhone);

}
