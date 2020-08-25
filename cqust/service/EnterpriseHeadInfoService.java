package cn.edu.cqust.service;

import cn.edu.cqust.bean.EnterpriseHeadInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 11:28
 * @desc:
 **/
public interface EnterpriseHeadInfoService {


    /**
     * @desc 根据企业名查询负责人
     * @param enterpriseName 全字段可选
     * @return 结果列表
     */
    List<String> findEmployeeNameByEnterpriseName(String enterpriseName);


    /**
     * @desc 根据负责人查询企业名
     * @param employeeName 全字段可选
     * @return < 企业驻场管理表id, 企业名 >
     */
    Map<Integer, String> findByEmployeeName(String employeeName);


    /**
     * @desc 添加一条数据
     * @param enterpriseHeadInfo 待添加数据
     * @return 操作状态
     */
    Integer insert(EnterpriseHeadInfo enterpriseHeadInfo);

    /**
     * @desc 根据id删除
     * @param id 目标id
     * @return 操作状态
     */
    Integer deleteById(Integer id);

}
