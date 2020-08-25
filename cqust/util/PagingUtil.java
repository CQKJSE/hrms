package cn.edu.cqust.util;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-25 16:32
 * @desc:
 **/
public class PagingUtil {

    /**
     * @desc 根据页码, 按每页10个, 计算查询的起始位置
     * @param page 当前页码
     * @return 计算后的起始位置(用于sql语句)
     */
    public static int paging(int page) {
        return (page - 1) * 10;
    }

}
