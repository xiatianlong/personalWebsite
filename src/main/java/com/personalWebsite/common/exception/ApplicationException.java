package com.personalWebsite.common.exception;

import com.personalWebsite.common.system.MessageSourceUtil;

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
        super(MessageSourceUtil.getMessage(message));
    }

    /**
     * 附带异常发生提示信息
     *
     * @param msgCode   消息代码
     * @param arguments 消息参数
     */
    public ApplicationException(String msgCode, Object[] arguments) {
        super(MessageSourceUtil.getMessage(msgCode, arguments));
    }

}
