package cn.edu.cqust.util;

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

}
