package cn.edu.cqust.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @project: HRMS
 * @author: F.C.Tang
 * @date: 2020-08-05 19:33
 * @desc: 日期工具
 **/
@SuppressWarnings("unused")
public class DateUtil {

    /**
     * @desc 获取当前年月日
     * @return 格式: 年-月-日
     */
    public static String getYMD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * @desc 获取当前时分秒
     * @return 格式: 时-分-秒
     */
    public static String getHMS() {
        return new SimpleDateFormat("HH-mm-ss").format(new Date());
    }

    /**
     * @desc 比较时间字符串大小
     * @param d1 时间1
     * @param d2 时间2
     * @return -1 --> d2大
     *          0 --> 相等
     *          1 --> d1大
     */
    public static int compareDate(String d1, String d2){
        return d1.compareTo(d2);
    }

}
