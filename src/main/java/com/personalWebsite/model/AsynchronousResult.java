package com.personalWebsite.model;

import com.personalWebsite.common.system.Constant;

import java.io.Serializable;

/**
 * 异步返回结果
 * Created by xiatianlong on 2017/12/28.
 */
public class AsynchronousResult implements Serializable{

    private static final long serialVersionUID = -1072103465426536854L;

    /**
     * 结果
     */
    private String result = Constant.FAIL;

    /**
     * 消息
     */
    private String message;


    /**
     * 获取 结果
     */
    public String getResult() {
        return this.result;
    }

    /**
     * 设置 结果
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取 消息
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 设置 消息
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
