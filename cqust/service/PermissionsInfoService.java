package cn.edu.cqust.service;

import cn.edu.cqust.bean.PermissionsInfo;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-24 09:46
 * @desc:
 **/
public interface PermissionsInfoService {

    /**
     * @desc 根据电话查询
     * @param phone 电话
     * @return 结果列表
     */
    PermissionsInfo findByPhone(String phone);


    /**
     * @desc 不存在则添加, 存在则修改
     * @param permissionsInfo 待插入对象
     * @return 操作状态
     */
    Integer insertOrUpdateIfExist(PermissionsInfo permissionsInfo);
}
