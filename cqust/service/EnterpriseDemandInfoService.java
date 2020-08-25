package cn.edu.cqust.service;

import cn.edu.cqust.bean.EnterpriseDemandInfo;

import java.util.List;
import java.util.Map;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 10:05
 * @desc:
 **/
public interface EnterpriseDemandInfoService {

    /**
     * @desc 根据企业名查询
     * @param enterpriseId enterprise_info的id
     * @return 结果列表
     */
    List<EnterpriseDemandInfo> findByEiId(Integer enterpriseId);


    /**
     * @desc 添加
     * @param enterpriseDemandInfo 待添加对象
     * @return 操作状态
     */
    Integer insert(EnterpriseDemandInfo enterpriseDemandInfo);

    /**
     * @desc 修改
     * @param enterpriseDemandInfo 待添修改据
     * @return 操作状态
     */

    Integer update(EnterpriseDemandInfo enterpriseDemandInfo);

    /**
     * @desc 删除
     * @param id 待删除数据的id
     * @return 操作状态
     */
    Integer deleteById(Integer id);


    /**
     * @desc 根据企业名,查询该企业所有的岗位信息
     * @param  enterpriseName 企业名
     * @return < 标识id, 岗位 >
     */
    Map<Integer, String> findJobByEnterpriseName(String enterpriseName);

}
