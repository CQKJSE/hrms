package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.OnTheJobInfo;
import cn.edu.cqust.bean.vo.QoOnTheJobAll;
import cn.edu.cqust.bean.vo.RoOnTheJob;
import cn.edu.cqust.bean.vo.RoOnTheJobAll;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-20 10:33
 * @desc:
 **/
@Mapper
@Component
public interface OnTheJobInfoDao {

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeePhone session中业务员的电话
     * @param startIndex 查询的起始位置
     * @return 结果列表
     */
    List<RoOnTheJob> findByMC1(@Param("customerInfo") CustomerInfo customerInfo,
                               @Param("employeePhone") String employeePhone,
                               @Param("startIndex") Integer startIndex);

    /**
     * @desc 多条件查询2
     * @param qo 混合查询对象
     * @param startIndex 查询的起始位置
     * @return 结果列表
     */
    List<RoOnTheJobAll> findByMC2(@Param("qo") QoOnTheJobAll qo,
                                  @Param("startIndex") Integer startIndex);

    /**
     * @desc 添加
     * @param onTheJobInfo 待添加对象
     * @return 操作状态
     */
    Integer insert(OnTheJobInfo onTheJobInfo);


    /**
     * @desc 查询最大id
     * @return 最大值
     */
    Integer findMaxId();

}
