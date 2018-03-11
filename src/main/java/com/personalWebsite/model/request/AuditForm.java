package com.personalWebsite.model.request;

import java.io.Serializable;

/**
 * 审核提交表单
 * Created by xiatianlong on 2018/3/6.
 */
public class AuditForm implements Serializable {
    private static final long serialVersionUID = -5100928489083275123L;

    /**
     * 状态
     */
    private String status;

    /**
     * 类别
     */
    private String[] category;

    /**
     * 审核备注
     */
    private String auditMemo;

    /**
     * 获取 状态
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * 获取 类别
     */
    public String[] getCategory() {
        return this.category;
    }

    /**
     * 设置 类别
     */
    public void setCategory(String[] category) {
        this.category = category;
    }

    /**
     * 获取 审核备注
     */
    public String getAuditMemo() {
        return this.auditMemo;
    }

    /**
     * 设置 审核备注
     */
    public void setAuditMemo(String auditMemo) {
        this.auditMemo = auditMemo;
    }
}
