package com.zongheanli.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:DateUtil
 * @Description TODO  日期转换工具类
 * @author:RanMoAnRan
 * @Date:2019/5/8 19:00
 * @Version 1.0
 */
public class DateUtil {
    // 传入一个格式化的日期字符串(yyyy-MM-dd)，返回一个Date
    public static Date transStringToDate(String str) {
        Date parse = null;
        try {
            parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    // 传入一个Date对象，返回一个格式化后的字符串
    public static String transDateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    // 传入一个1970-01-01毫秒数，返回一个格式化后的字符串
    public static String transDateToString(long date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

}
