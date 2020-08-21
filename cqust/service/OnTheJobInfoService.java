package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.OnTheJobInfo;
import cn.edu.cqust.bean.vo.QoOnTheJobAll;
import cn.edu.cqust.bean.vo.RoOnTheJob;
import cn.edu.cqust.bean.vo.RoOnTheJobAll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-20 11:40
 * @desc:
 **/
public interface OnTheJobInfoService {

    /**
     * @desc 多条件查询1
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeePhone session中业务员的电话
     * @param page 查询的页码
     * @return 结果列表
     */
    List<RoOnTheJob> findByMC1(CustomerInfo customerInfo,
                               String employeePhone,
                               Integer page);

    /**
     * @desc 多条件查询1, 统计结果条数
     * @param customerInfo 三个字段:name, idNumber, phoneNumber
     * @param employeePhone session中业务员的电话
     * @return 结果数量
     */
    Integer countByMC1(CustomerInfo customerInfo,
                       String employeePhone);

    /**
     * @desc 多条件查询2
     * @param qo 混合查询对象
     * @param page 查询的页码
     * @return 结果列表
     */
    List<RoOnTheJobAll> findByMC2(QoOnTheJobAll qo, Integer page);

    /**
     * @desc 多条件查询2, 统计结果条数
     * @param qo 混合查询对象
     * @return 结果数量
     */
    Integer countByMC2(QoOnTheJobAll qo);

    /**
     * @desc 添加到on_the_job_info表，同时后端将wait_induction_info表中
     * 	     stateOne（状态）改为1，note（备注）改为通过，将on_the_job_info
     * 	     表中的state（状态）置为在职，获取通过时间存inductionTime（入职时间）,
     * 	     数据在on_the_job_info添加成功过后获取onTheJobId（在职名单id）,
     * 	     然后同以上数据一起存入settlement_info（结算名单）表中，同时将state
     * 	     （结算状态）置为待结算
     * @param onTheJobInfo 三个参数: cId, pclId, eId
     * @return 操作状态
     */
    Integer addOnTheJob(OnTheJobInfo onTheJobInfo);




}
