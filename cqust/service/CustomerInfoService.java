package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.EmployeesDeparture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    Integer addOne(CustomerInfo customerInfo, String employeeName,
                   String employeePhone);

    /**
     * @desc 全字段查询
     * @param customerInfo 全字段可选
     * @param pageNumber 页码
     * @return 结果列表
     */
    List<CustomerInfo> findFuzzily(CustomerInfo customerInfo, Integer pageNumber);

    /**
     * @desc 全字段统计条数
     * @param customerInfo 全字段可选
     * @return 结果列表
     */
    Integer countFuzzily(CustomerInfo customerInfo);

    /**
     * @desc 修改
     * @param customerInfo 需要更新的数据
     * @return 操作状态
     */
    Integer update(CustomerInfo customerInfo);

}
