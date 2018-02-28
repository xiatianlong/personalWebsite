package com.personalWebsite.model.response.collection;

import java.io.Serializable;

/**
 * 收藏信息
 * Created by xiatianlong on 2018/2/28.
 */
public class CollectionInfo implements Serializable {
    private static final long serialVersionUID = 426062997452939513L;

    /**
     * 业务id
     */
    private String bizId;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 收藏内容标题
     */
    private String title;

    /**
     * 收藏内容是否删除
     */
    private boolean deleted;

    /**
     * 收藏内容在前端是否可显示
     */
    private boolean visible;

    /**
     * 收藏时间
     */
    private String createTime;


    /**
     * 获取 业务id
     */
    public String getBizId() {
        return this.bizId;
    }

    /**
     * 设置 业务id
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
     * 获取 用户id
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 收藏内容标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 收藏内容标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 收藏内容是否删除
     */
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * 设置 收藏内容是否删除
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取 收藏内容在前端是否可显示
     */
    public boolean isVisible() {
        return this.visible;
    }

    /**
     * 设置 收藏内容在前端是否可显示
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }


    /**
     * 获取 收藏时间
     */
    public String getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 收藏时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
