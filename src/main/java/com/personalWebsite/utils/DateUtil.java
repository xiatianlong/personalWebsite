package com.personalWebsite.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * Created by xiatianlong on 2017/12/14.
 */
public class DateUtil {

    public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static String DATEFORMATTER_YYYY_MM_DD = "yyyy-MM-dd";
    public final static String DATEFORMATTER_YYMM = "yyyyMM";
    public final static String DATEFORMATTER_HHMM = "yyyy-MM-dd HH:mm";
    public final static String DEFAULT_DATE_PATTERN_CN = "yyyy年MM月dd日 HH:mm:ss";
    public final static String DATEFORMATTER_YYMM_CN = "yyyy年MM月";
    public final static String DATEFORMATTER_MMDD_CN = "MM月dd日";
    public final static String DATEFORMATTER_YYYY_MM_DD_CN = "yyyy年MM月dd日";

    /**
     * 默认的日期格式化
     * @param date  日期
     * @return  字符串
     */
    public static String defaultFormat(Date date) {
        return format(date, DEFAULT_DATE_PATTERN);
    }

    /**
     * 将日期对象转换成制定格式字符串
     *
     * @param date        日期对象
     * @param datePattern 日期格式
     * @return String
     */
    public static String format(Date date, String datePattern) {
        if (date != null) {
            SimpleDateFormat sd = new SimpleDateFormat(datePattern);
            return sd.format(date);
        } else {
            return null;
        }
    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date parse(String strDate, String pattern) {
        try {
            return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(pattern).parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}