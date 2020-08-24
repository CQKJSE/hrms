package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.SystemSettings;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-24 10:45
 * @desc:
 **/
public interface SystemSettingsService {

    /**
     * @desc 查询所有设置项
     * @return 结果列表
     */
    List<SystemSettings> findAll();

    /**
     * @desc 修改
     * @param systemSettings 需要更新的数据
     * @return 操作状态
     */
    Integer update(SystemSettings systemSettings);

}
