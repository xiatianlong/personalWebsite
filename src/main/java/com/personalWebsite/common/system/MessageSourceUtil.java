package com.personalWebsite.common.system;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * 全局消息
 * Created by xiatianlong on 2017/12/28.
 */
public class MessageSourceUtil {

    /**
     * 消息对象
     */
    private static MessageSource messageSource;

    /**
     * 消息构造
     * @param messageSource     messageSource
     */
    public MessageSourceUtil(MessageSource messageSource) {
        MessageSourceUtil.messageSource = messageSource;
    }

    /**
     * 不带参数的消息
     * @param key   消息key
     * @return 消息
     */
    public static String getMessage(String key) {
        return messageSource.getMessage(key, null, Locale.CHINA);
    }

    /**
     * 带参数的消息
     * @param key 消息key
     * @param args 参数数组
     * @return 消息
     */
    public static String getMessage(String key, Object[] args) {
        return messageSource.getMessage(key, args, Locale.CHINA);
    }

}
