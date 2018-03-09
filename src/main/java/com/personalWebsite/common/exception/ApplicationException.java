package com.personalWebsite.common.exception;

/**
 * Created by xiatianlong on 2017/12/28.
 */
public class ApplicationException extends Exception {

    private static final long serialVersionUID = -5903544830579084104L;

    /**
     * 附带异常发生提示信息
     *
     * @param message 消息代码
     */
    public ApplicationException(String message) {
        super(message);
    }
}
