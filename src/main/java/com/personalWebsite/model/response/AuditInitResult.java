package com.personalWebsite.model.response;

import java.util.List;

/**
 * 审核初始化请求返回结果
 * Created by xiatianlong on 2018/3/8.
 */
public class AuditInitResult extends AsynchronousResult {
    private static final long serialVersionUID = -7578731187729836726L;

    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 状态
     */
    private String status;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 类别列表
     */
    private List<String> category;


    /**
     * 获取 业务ID
     */
    public String getBizId() {
        return this.bizId;
    }

    /**
     * 设置 业务ID
     */
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取 业务类型
     */
    public String getBizType() {
        return this.bizType;
    }

    /**
     * 设置 业务类型
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * 获取 类别列表
     */
    public List<String> getCategory() {
        return this.category;
    }

    /**
     * 设置 类别列表
     */
    public void setCategory(List<String> category) {
        this.category = category;
    }

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
     * 获取 状态名称
     */
    public String getStatusName() {
        return this.statusName;
    }

    /**
     * 设置 状态名称
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
