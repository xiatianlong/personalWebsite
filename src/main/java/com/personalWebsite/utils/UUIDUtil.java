package com.personalWebsite.utils;

import java.util.UUID;

/**
 * UUID 工具类
 * Created by xiatianlong on 2018/1/5.
 */
public class UUIDUtil {

    /**
     * 获取一个UUID字符串（去横线）
     * @return UUID
     */
    public static String getUUID(){

        return UUID.randomUUID().toString().replace("-", "");
    }

}
