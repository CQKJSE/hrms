package cn.edu.cqust.dao;

import cn.edu.cqust.bean.PermissionsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-24 09:47
 * @desc:
 **/
@Mapper
@Component
public interface PermissionsInfoDao {


    /**
     * @desc 全字段查询
     * @param permissionsInfo 全字段可选
     * @param startIndex 起始位置
     * @return 结果列表
     */
    List<PermissionsInfo> findFuzzily(@Param("permissionsInfo") PermissionsInfo permissionsInfo,
                                      @Param("startIndex") Integer startIndex);

    /**
     * @desc 修改
     * @param permissionsInfo 需要更新的数据
     * @return 操作状态
     */
    Integer update(PermissionsInfo permissionsInfo);

    /**
     * @desc 添加
     * @param permissionsInfo 待插入对象
     * @return 操作状态
     */
    Integer insert(PermissionsInfo permissionsInfo);

}
