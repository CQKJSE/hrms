package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneRecord;
import cn.edu.cqust.bean.vo.RoGetPhoneRecord;
import cn.edu.cqust.bean.vo.RoGetPhoneRecordAll;
import cn.edu.cqust.bean.vo.RoGetPhoneRecordDept;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-16 17:07
 * @desc:
 **/
public interface PhoneRecordService {

    /**
     * @desc 多条件查询1
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param pageNumber 页码
     * @param employeePhone session中的电话
     * @return 结果列表
     */
    List<RoGetPhoneRecord> findByMC1(CustomerInfo customerInfo,
                                     Integer pageNumber,
                                     String employeePhone);

    /**
     * @desc 多条件查询条数1(复用dao.findByMC1())
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param employeePhone session中的电话
     * @return 结果列表
     */
    Integer countByMC1(CustomerInfo customerInfo,
                       String employeePhone);


    /**
     * @desc 多条件查询2
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param pageNumber 起始位置
     * @param employeeName 员工姓名
     * @param deptName session中的部门名
     * @return 结果列表
     */
    List<RoGetPhoneRecordDept> findByMC2(CustomerInfo customerInfo,
                                         Integer pageNumber,
                                         String employeeName,
                                         String deptName);

    /**
     * @desc 多条件查询条数2(复用dao.findByMC2())
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param employeeName 员工姓名
     * @param deptName session中的部门名
     * @return 结果列表
     */
    Integer countByMC2(CustomerInfo customerInfo,
                       String employeeName,
                       String deptName);

    /**
     * @desc 多条件查询2
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param pageNumber 起始位置
     * @param employeeName 员工姓名
     * @param deptName 部门名
     * @return 结果列表
     */
    List<RoGetPhoneRecordAll> findByMC3(CustomerInfo customerInfo,
                                        Integer pageNumber,
                                        String employeeName,
                                        String deptName);

    /**
     * @desc 多条件查询条数2(复用dao.findByMC2())
     * @param customerInfo name, idNumber, phoneNumber三参数
     * @param employeeName 员工姓名
     * @param deptName 部门名
     * @return 结果列表
     */
    Integer countByMC3(CustomerInfo customerInfo,
                       String employeeName,
                       String deptName);

    /**
     * @desc 添加一条数据
     * @param phoneRecord 待添加数据
     * @return 操作状态
     */
    Integer insert(PhoneRecord phoneRecord);

    /**
     * @desc 统计电话记录的条数
     * @param employeePhone session中的电话
     * @return 数量
     */
    Integer[] countTodayByStatus(String employeePhone);

}
