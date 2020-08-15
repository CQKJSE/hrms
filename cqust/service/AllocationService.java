package cn.edu.cqust.service;

/**
 * @project: HRMS_SpringbootDemo
 * @author: Tang.F.C
 * @date: 2020-08-15 10:55
 * @desc:
 **/
public interface AllocationService {

    /**
     * @desc 分配算法: 为当前登录的业务员分配
     * @param phone 当前登录的人的电话(用于查找对应的id)
     * @return void
     */
    Integer allocateOne(String phone);

    /**
     * @desc 分配算法: 为当前登录的业务员分配, 且分配的customer的addTime在90天内
     * @param phone 当前登录的人的电话(用于查找对应的id)
     * @return void
     */
    Integer allocateOneAfterTimeLimit(String phone);

}
