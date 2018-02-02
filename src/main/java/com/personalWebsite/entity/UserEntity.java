package com.personalWebsite.entity;

import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 用户表实体
 * Created by xiatianlong on 2017/12/27.
 */
@Entity(name = "t_user")
public class UserEntity extends BaseEntity {
    private static final long serialVersionUID = 644210781795341678L;

    /**
     * 用户ID(md5加密的openid)
     */
    private String userId;

    /**
     * openID
     */
    private String openId;

    /**
     * accessToken
     */
    private String accessToken;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户性别
     */
    private String userGender;

    /**
     * 用户头像（小）
     */
    private String userHeadImgSmall;

    /**
     * 用户头像（大）
     */
    private String userHeadImgLarge;

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
     * 是否删除
     */
    private boolean deleted;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;


    /**
     * 获取 用户ID(md5加密的openid)
     */
    @Id
    @Column(name = "USER_ID", nullable = false, length = 50)
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 用户ID(md5加密的openid)
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 openID （qq）
     */
    @Column(name = "OPEN_ID", nullable = false, length = 100)
    public String getOpenId() {
        return this.openId;
    }

    /**
     * 设置 openID （qq）
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取 accessToken （qq）
     */
    @Column(name = "ACCESS_TOKEN", nullable = false, length = 100)
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * 设置 accessToken （qq）
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取 用户昵称
     */
    @Column(name = "USER_NAME", nullable = false, length = 50)
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
    @Column(name = "USER_GENDER", nullable = false, length = 2)
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
     * 获取 用户头像（小）
     */
    @Column(name = "USER_HEAD_IMG_SMALL", length = 255)
    public String getUserHeadImgSmall() {
        return this.userHeadImgSmall;
    }

    /**
     * 设置 用户头像（小）
     */
    public void setUserHeadImgSmall(String userHeadImgSmall) {
        this.userHeadImgSmall = userHeadImgSmall;
    }

    /**
     * 获取 用户头像（大）
     */
    @Column(name = "USER_HEAD_IMG_LARGE", length = 255)
    public String getUserHeadImgLarge() {
        return this.userHeadImgLarge;
    }

    /**
     * 设置 用户头像（大）
     */
    public void setUserHeadImgLarge(String userHeadImgLarge) {
        this.userHeadImgLarge = userHeadImgLarge;
    }

    /**
     * 获取 用户邮箱
     */
    @Column(name = "USER_EMAIL", length = 100)
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
     * 获取 qq
     */
    @Column(name = "USER_QQ", length = 15)
    public String getUserQQ() {
        return userQQ;
    }

    /**
     * 获取 qq
     */
    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }

    /**
     * 获取 个人简介
     */
    @Column(name = "USER_INTRODUCTION", length = 255)
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
    @Column(name = "IS_OPEN", nullable = false)
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
     * 获取 是否删除
     */
    @Column(name = "IS_DELETE", nullable = false)
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * 设置 是否删除
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取 最后登录时间
     */
    @Column(name = "LAST_LOGIN_TIME")
    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }

    /**
     * 设置 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取用户头像
     *
     * @return str
     */
    @Transient
    public String getUserHeadImg() {
        return StringUtils.isEmpty(getUserHeadImgLarge()) ? getUserHeadImgSmall() : getUserHeadImgLarge();
    }
}
