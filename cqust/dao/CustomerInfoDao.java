package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-08 20:35
 * @desc:
 **/
@Mapper
@Component
public interface CustomerInfoDao {

    /**
     * @desc 根据状态查询id(0:可分配, 1:不可分配, 2:黑名单)
     * @param state 目标状态
     * @return 结果列表
     */
    List<Integer> findIdByState(@Param("state") String state);

    /**
     * @desc 查询最大id
     * @return 最大值
     */
    Integer findMaxId();

    /**
     * @desc 修改
     * @param customerInfo 需要更新的数据
     * @return 操作状态
     */
    Integer update(CustomerInfo customerInfo);

    /**
     * @desc 添加一条数据
     * @param customerInfo 待添加数据
     * @return 操作状态
     */
    Integer insert(CustomerInfo customerInfo);

    /**
     * @desc 统计总条数
     * @return ci的数据总条数
     */
    Integer count();

    /**
     * @desc 根据状态及'90'天内两个条件,查询id
     * @param state 目标状态
     * @return 结果列表
     */
    List<Integer> findByStateAndAfterTimeLimit(@Param("state") String state);

    /**
     * @desc 全字段查询
     * @param customerInfo 全字段可选
     * @param startIndex 起始位置
     * @return 结果列表
     */
    List<CustomerInfo> findFuzzily(@Param("customerInfo") CustomerInfo customerInfo,
                                   @Param("startIndex") Integer startIndex);

}
