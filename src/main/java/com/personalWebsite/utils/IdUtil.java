package com.personalWebsite.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * ID 工具类
 * 成为唯一ID(年月日时分秒+用户id+一位随机数)
 * Created by xiatianlong on 2018/1/9.
 */
public class IdUtil {

    public static String createId(String userId) {
        SimpleDateFormat sd = new SimpleDateFormat("yyMMddHHmmss");
        return sd.format(new Date()) + userId + new Random().nextInt(10);
    }

    public static String createId() {
        SimpleDateFormat sd = new SimpleDateFormat("yyMMddHHmmssSSS");
        return sd.format(new Date()) + new Random().nextInt(10);
    }
}
