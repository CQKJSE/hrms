package cn.edu.cqust.dao;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneCallList;
import cn.edu.cqust.bean.vo.RoCallList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-05 17:09
 * @desc:
 **/
@Mapper
@Component
public interface PhoneCallListDao {


    /**
     * @desc 根据系统时限,查询满足条件的customerId和employeeId
     *       (例: 系统时限为7, 则查询今天~7天前的数据)
     * @return 结果列表
     */
    List<PhoneCallList> findAfterSystemTimeLimit();


    /**
     * @desc 根据系统时限,查询之前的customerId和employeeId
     *       (例: 系统时限为7, 则查询'最早的~7天前'的数据)
     * @return 结果列表
     */
    List<PhoneCallList> findIdBeforeSystemTimeLimit();


    /**
     * @desc 多条件查询1(当日业务员的个人名单)
     * @param startIndex 查询的起始位置
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @param employeePhone 当前登录的业务员电话
     * @return 结果列表
     */
    List<RoCallList> findByMC1(@Param("customerInfo") CustomerInfo customerInfo,
                               @Param("startIndex") Integer startIndex,
                               @Param("employeePhone") String employeePhone);

    /**
     * @desc 多条件查询1, 查询满足条件的数据量(当日业务员的个人名单)
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @param employeePhone 当前登录的业务员电话
     * @return 结果的数量
     */
    Integer findCountByMC1(@Param("customerInfo") CustomerInfo customerInfo,
                           @Param("employeePhone") String employeePhone);

    /**
     * @desc 多条件查询2(总名单)
     * @param startIndex 查询的起始位置
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @param employeePhone 当前登录的业务员电话(查询条件)
     * @return 结果列表
     */
    List<RoCallList> findByMC2(@Param("customerInfo") CustomerInfo customerInfo,
                               @Param("startIndex") Integer startIndex,
                               @Param("employeePhone") String employeePhone);

    /**
     * @desc 多条件查询2, 查询满足条件的数据量(总名单)
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @param employeePhone 当前登录的业务员电话
     * @return 结果的数量
     */
    Integer findCountByMC2(@Param("customerInfo") CustomerInfo customerInfo,
                           @Param("employeePhone") String employeePhone);

    /**
     * @desc 修改
     * @param phoneCallList 需要更新的数据
     * @return 操作状态
     */
    Integer update(PhoneCallList phoneCallList);

    /**
     * @desc 添加
     * @param phoneCallList 待插入对象
     * @return 操作状态
     */
    Integer insert(PhoneCallList phoneCallList);

    /**
     * @desc 查询所有
     * @return 结果列表
     */
    List<PhoneCallList> findAll();

    /**
     * @desc 根据id删除
     * @param id 目标id
     * @return 操作状态
     */
    Integer deleteById(Integer id);

}
