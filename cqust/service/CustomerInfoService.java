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
     * @desc 添加一条数据,将其状态置位0. 同时将这条数据分配给当前业务员
     * @param customerInfo 12个字段
     * @param employeeName session中职员的名字
     * @param employeePhone session中职员的电话
     * @return 操作状态
     */
    Integer addOneAndAllocate(CustomerInfo customerInfo, String employeeName, String employeePhone);

}
