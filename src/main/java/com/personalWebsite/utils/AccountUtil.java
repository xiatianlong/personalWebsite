package com.personalWebsite.utils;


import org.apache.commons.lang.StringUtils;

/**
 * 账户ID生成工具类
 * Created by xiatianlong on 2017/12/28.
 */
public class AccountUtil {

    /**
     * 账号长度
     */
    private final static int ACCOUNT_ID_LENGTH = 6;

    /**
     * 用于补全长度的空位字符
     */
    private final static String VACANCY = "0";

    /**
     * 账号初始位
     */
    private final static int START_IDX = 1;

    /**
     * 账号增值
     */
    private final static int INCREMENT = 1;

    /**
     * 获取第一个账号
     *
     * @return 第一个账号
     */
    public static String getTheFirstAccountId() {
        return StringUtils.rightPad(String.valueOf(START_IDX), ACCOUNT_ID_LENGTH, VACANCY);
    }

    /**
     * 获取下一个账号
     *
     * @param lastAccountId 下一个账号
     * @return 下一个账号
     */
    public static String getTheNextAccountId(String lastAccountId) {
        return StringUtils.rightPad(String.valueOf(Integer.parseInt(lastAccountId) + INCREMENT), ACCOUNT_ID_LENGTH, VACANCY);
    }

}
