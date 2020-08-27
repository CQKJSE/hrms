package cn.edu.cqust.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;
import java.util.UUID;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-04-30 10:24
 * @desc: 工具类:用于生成对象/数据
 **/
@SuppressWarnings("unused")
public class Generator {

    /**
     * @desc 根据状态码, 生成一个json对象
     * @param statusCode 状态码
     * @return {"statusCode":状态码}
     */
    public static String genJsonStatusCode(int statusCode) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("statusCode", statusCode);
        return jsonObject.toString();
    }

    /**
     * @desc 将基本类型、String生成json对象
     * @param objects 以k/v形式为一对的待生成对象
     * @warn objects数量必须为2的倍数(json对象k / v形式为偶数), 且为基本类型或String
     * @return 生成后的json对象
     */
    public static String genJsonObject(Object... objects) {
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < objects.length; i += 2) {
            jsonObject.put(String.valueOf(objects[i]), objects[i + 1]);
        }
        return jsonObject.toString();
    }

    /**
     * @desc 生成带UUID的文件名
     * @param fileName 原文件名
     * @return 格式: "uuid_fileName.suffix"
     */
    public static String genUuidWithFileName(String fileName) {
        return UUID.randomUUID().toString().replace("-", "") + "_" + fileName;
    }

    /**
     * @desc 生成随机数
     * @param upperLimit 随机数上限
     * @return 范围[1, upperLimit]
     */
    public static int genRandomNumber(int upperLimit) {
        return new Random().nextInt(upperLimit) + 1;
    }

}
