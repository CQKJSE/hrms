package cn.edu.cqust.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.springframework.util.ObjectUtils;
import java.lang.reflect.Field;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-10 16:50
 * @desc: javaBean检查类
 **/
public class BeanHelper {

    /**
     * @desc 判断对象的成员变量是否全为空
     * @param bean 待判断对象
     * @param exceptedFields 除外的成员变量
     * @return true--->对象所有成员变量为空
     *         false-->存在成员变量不为空
     */
    public static boolean isEmptyBean(Object bean, String... exceptedFields) {
        boolean conditionalOnExceptedFields = exceptedFields.length > 0;
        try {
            continuePoint:
            for (Field field : bean.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String tempFieldName = field.getName();
                //check exceptedFields
                if (conditionalOnExceptedFields) {
                    for (String exceptField : exceptedFields) {
                        if (tempFieldName.equals(exceptField)) {
                            continue continuePoint;
                        }
                    }
                }
                Object value = field.get(bean);
                if (value instanceof CharSequence) {
                    if (!ObjectUtils.isEmpty(value)) {
                        System.out.println(tempFieldName + "***");
                        return false;
                    }
                } else {
                    if (null != value) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("BeanHelper.isEmptyBean()判断异常");
        }
        return true;
    }


    /*************************************************************
     *                  运行时间/初始化、销毁(junit5)
     *************************************************************/
    private static long sTime;
    @BeforeAll
    @DisplayName("开始时间/")
    public static void start() {
        sTime = System.currentTimeMillis();
    }

    @AfterAll
    @DisplayName("结束时间/")
    public static void end() {
        long eTime = System.currentTimeMillis();
        System.out.println("耗时: " + (eTime - sTime) + "ms");
    }
}
