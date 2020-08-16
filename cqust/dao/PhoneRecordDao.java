package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneRecord;
import cn.edu.cqust.bean.vo.RoGetPhoneRecord;
import cn.edu.cqust.bean.vo.RoGetPhoneRecordAll;
import cn.edu.cqust.bean.vo.RoGetPhoneRecordDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-16 17:00
 * @desc:
 **/
@Mapper
@Component
public interface PhoneRecordDao {

    /**
     * @desc 多条件查询1
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param pageIndex 起始位置
     * @param employeePhone session中的电话
     * @return 结果列表
     */
    List<RoGetPhoneRecord> findByMC1(@Param("customerInfo") CustomerInfo customerInfo,
                                     @Param("pageIndex")Integer pageIndex,
                                     @Param("employeePhone")String employeePhone);


    /**
     * @desc 多条件查询2
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param pageIndex 起始位置
     * @param employeeName 员工姓名
     * @param deptName session中的部门名
     * @return 结果列表
     */
    List<RoGetPhoneRecordDept> findByMC2(@Param("customerInfo") CustomerInfo customerInfo,
                                         @Param("pageIndex")Integer pageIndex,
                                         @Param("employeeName")String employeeName,
                                         @Param("deptName") String deptName);

    /**
     * @desc 多条件查询2
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param pageIndex 起始位置
     * @param employeeName 员工姓名
     * @param deptName 部门名
     * @return 结果列表
     */
    List<RoGetPhoneRecordAll> findByMC3(@Param("customerInfo") CustomerInfo customerInfo,
                                        @Param("pageIndex")Integer pageIndex,
                                        @Param("employeeName")String employeeName,
                                        @Param("deptName") String deptName);

    /**
     * @desc 添加
     * @param phoneRecord 待添加数据
     * @return 操作状态
     */
    Integer insert(PhoneRecord phoneRecord);


    /**
     * @desc 统计电话记录的条数
     * @param employeePhone session中的电话
     * @param status 接通状态
     * @return 数量
     */
    Integer countTodayByStatus(@Param("employeePhone")String employeePhone,
                               @Param("status")String status);
}
