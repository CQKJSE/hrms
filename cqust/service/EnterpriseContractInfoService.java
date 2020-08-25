package cn.edu.cqust.service;

import cn.edu.cqust.bean.EnterpriseContractInfo;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-25 16:21
 * @desc:
 **/
public interface EnterpriseContractInfoService {

    /**
     * @desc 根据企业名查询
     * @param enterpriseName 企业名
     * @param pageNumber 页码
     * @return 结果列表
     */
    List<EnterpriseContractInfo> findByName(String enterpriseName, Integer pageNumber);

    /**
     * @desc 根据企业名统计数量
     * @param enterpriseName 企业名
     * @return 结果数量
     */
    Integer countByName(String enterpriseName);

    /**
     * @desc 添加
     * @param enterpriseContractInfo 待添加对象
     * @return 操作状态
     */
    Integer insert(EnterpriseContractInfo enterpriseContractInfo);

    /**
     * @desc 修改
     * @param enterpriseContractInfo 待添修改据
     * @return 操作状态
     */

    Integer update(EnterpriseContractInfo enterpriseContractInfo);

    /**
     * @desc 删除
     * @param id 待删除数据的id
     * @return 操作状态
     */
    Integer deleteById(Integer id);

}
