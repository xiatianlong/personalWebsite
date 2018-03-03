package com.personalWebsite.model.response.user;

import java.io.Serializable;

/**
 * 用户详情
 * Created by xiatianlong on 2018/3/1.
 */
public class UserDetail implements Serializable {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 用户性别
     */
    private String userGender;
    /**
     * 用户头像
     */
    private String userHeadImg;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * QQ
     */
    private String userQQ;

    /**
     * 个人简介
     */
    private String userIntroduction;
    /**
     * 是否开放个人中心访问
     */
    private boolean open;
    /**
     * 最后登录时间
     */
    private String fmtLastLoginTime;
    /**
     * 用户创建时间
     */
    private String fmtCreateTime;


    /**
     * 获取 用户ID
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户昵称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 用户昵称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 用户性别
     */
    public String getUserGender() {
        return this.userGender;
    }

    /**
     * 设置 用户性别
     */
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    /**
     * 获取 用户头像
     */
    public String getUserHeadImg() {
        return this.userHeadImg;
    }

    /**
     * 设置 用户头像
     */
    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    /**
     * 获取 用户邮箱
     */
    public String getUserEmail() {
        return this.userEmail;
    }

    /**
     * 设置 用户邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取 QQ
     */
    public String getUserQQ() {
        return this.userQQ;
    }

    /**
     * 设置 QQ
     */
    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }

    /**
     * 获取 个人简介
     */
    public String getUserIntroduction() {
        return this.userIntroduction;
    }

    /**
     * 设置 个人简介
     */
    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    /**
     * 获取 是否开放个人中心访问
     */
    public boolean isOpen() {
        return this.open;
    }

    /**
     * 设置 是否开放个人中心访问
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * 获取 最后登录时间
     */
    public String getFmtLastLoginTime() {
        return this.fmtLastLoginTime;
    }

    /**
     * 设置 最后登录时间
     */
    public void setFmtLastLoginTime(String fmtLastLoginTime) {
        this.fmtLastLoginTime = fmtLastLoginTime;
    }

    /**
     * 获取 用户创建时间
     */
    public String getFmtCreateTime() {
        return this.fmtCreateTime;
    }

    /**
     * 设置 用户创建时间
     */
    public void setFmtCreateTime(String fmtCreateTime) {
        this.fmtCreateTime = fmtCreateTime;
    }
}
