package com.ruubypay.mail.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/10/30 下午7:59
 */
public class DateUtil {
    /**
     * 获取标准格式当前日期和时间
     * @return String
     */
    public static String getNowDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

    /**
     * 获取标准格式当前日期和时间,精确到毫秒
     * @return String
     */
    public static String getNowDateTimeSSS() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return formatter.format(new Date());
    }
}
