package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.Employee;
import cn.edu.cqust.bean.EmployeesArchives;
import cn.edu.cqust.bean.EnterpriseInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-25 08:48
 * @desc:
 **/
public interface EnterpriseInfoService {

    /**
     * @desc 根据企业名查询
     * @param enterpriseName 企业名
     * @param pageNumber 页码
     * @return 结果列表
     */
    List<EnterpriseInfo> findByName(String enterpriseName, Integer pageNumber);

    /**
     * @desc 根据企业名统计数量
     * @param enterpriseName 企业名
     * @return 结果数量
     */
    Integer countByName(String enterpriseName);

    /**
     * @desc 添加
     * @param enterpriseInfo 待添加对象
     * @return 操作状态
     */
    Integer insert(EnterpriseInfo enterpriseInfo);

    /**
     * @desc 修改
     * @param enterpriseInfo 待添修改据
     * @return 操作状态
     */

    Integer update(EnterpriseInfo enterpriseInfo);

    /**
     * @desc 删除
     * @param id 待删除数据的id
     * @return 操作状态
     */
    Integer deleteById(Integer id);


    /**
     * @desc 查询所有企业名
     * @return < 标识id, 企业名 >
     */
    Map<Integer, String> findAllEnterpriseName();

}
