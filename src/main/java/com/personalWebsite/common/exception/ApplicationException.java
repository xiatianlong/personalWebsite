package com.personalWebsite.common.exception;

/**
 * Created by xiatianlong on 2017/12/28.
 */
public class ApplicationException extends Exception {

    /**
     * 附带异常发生提示信息
     *
     * @param message 消息代码
     */
    public ApplicationException(String message) {
        super(message);
    }
}
