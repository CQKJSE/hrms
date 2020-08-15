package cn.edu.cqust.dao;

import cn.edu.cqust.bean.TransactionManagement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-06 20:04
 * @desc:
 **/
@Mapper
@Component
public interface TransactionManagementDao {

    /**
     * @desc 根据业务员姓名查询
     * @param employeePhone 业务员的电话
     * @return 结果列表
     */

    List<TransactionManagement> findByEmployeePhone(String employeePhone);

    /**
     * @desc 根据表的标识id删除数据
     * @param id 标识id
     * @return 执行状态
     */
    Integer deleteById(Integer id);

    /**
     * @desc 添加一条数据
     * @param transactionManagement 实体对象
     * @return 执行状态
     */
    Integer insert(TransactionManagement transactionManagement);

}
