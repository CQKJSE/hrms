package cn.edu.cqust.dao;

import cn.edu.cqust.bean.PermissionsInfo;
import cn.edu.cqust.bean.SystemSettings;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-08 15:12
 * @desc:
 **/
@Mapper
@Component
public interface SystemSettingsDao {

    /**
     * @desc 查询系统自动分配给每人的数据量
     * @return 查询结果
     */
    Integer findAllocationCount();


    /**
     * @desc 查询员工电话总名单自动入库的期限
     * @return 查询结果
     */
    Integer findTimeLimit();


    /**
     * @desc 全字段查询
     * @param SystemSettings 全字段可选
     * @param startIndex 起始位置
     * @return 结果列表
     */
    List<SystemSettings> findFuzzily(@Param("SystemSettings") SystemSettings SystemSettings,
                                      @Param("startIndex") Integer startIndex);

    /**
     * @desc 修改
     * @param SystemSettings 需要更新的数据
     * @return 操作状态
     */
    Integer update(SystemSettings SystemSettings);


}
