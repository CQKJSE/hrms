package cn.edu.cqust.service;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.PhoneCallList;
import cn.edu.cqust.bean.vo.QoPclAndCi;
import cn.edu.cqust.bean.vo.RoCallList;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-05 17:33
 * @desc:
 **/
public interface PhoneCallListService {

    /**
     * @desc 多条件查询1(当日业务员的个人名单)
     * @param pageNumber 开始页码
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @param phone 当前登录的业务员电话(查询条件)
     * @return 结果列表
     */
    List<RoCallList> findByMC1(CustomerInfo customerInfo,
                               Integer pageNumber,
                               String phone);

    /**
     * @desc 多条件查询1, 查询满足条件的数据量(当日业务员的个人名单)
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @param phone 当前登录的业务员电话(查询条件)
     * @return 结果的数量
     */
    Integer findCountByMC1(CustomerInfo customerInfo,
                           String phone);

    /**
     * @desc 多条件查询2(总名单)
     * @param pageNumber 开始页码
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @param phone 当前登录的业务员电话(查询条件)
     * @return 结果列表
     */
    List<RoCallList> findByMC2(CustomerInfo customerInfo,
                               Integer pageNumber,
                               String phone);

    /**
     * @desc 多条件查询2, 查询满足条件的数据量(总名单)
     * @param customerInfo 查询条件(9个成员变量,详见sql语句)
     * @param phone 当前登录的业务员电话(查询条件)
     * @return 结果的数量
     */
    Integer findCountByMC2(CustomerInfo customerInfo,
                           String phone);

    /**
     * @desc 根据id删除
     * @param id 目标id
     * @return 操作状态
     */
    Integer deleteById(Integer id);

    /**
     * @desc 更新pcl以及ci
     * @param qo pcl+ci请求字段的混合对象
     * @return 操作状态
     */
    Integer updateWithCi(QoPclAndCi qo);

}
