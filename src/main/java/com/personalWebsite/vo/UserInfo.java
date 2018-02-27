package com.personalWebsite.vo;

/**
 * 用户基本信息
 * Created by xiatianlong on 2017/12/24.
 */
public class UserInfo {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户性别
     */
    private String gender;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 获取 用户名
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * 获取 用户性别
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * 设置 用户性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取 用户邮箱
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取 头像
     */
    public String getHeadImg() {
        return this.headImg;
    }

    /**
     * 设置 头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    /**
     * 获取 创建时间
     */
    public String getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
