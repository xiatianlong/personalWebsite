package com.personalWebsite.model.request.member;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * 用户设置请求表单
 * Created by xiatianlong on 2018/1/16.
 */
public class SettingForm implements Serializable {
    private static final long serialVersionUID = 2923716896794426349L;

    /**
     * 是否开放个人中心
     */
    private boolean open;

    /**
     * QQ
     */
    @Length(max = 10, message = "valid.setting.qq.length")
    private String userQQ;

    /**
     * Email
     */
    private String userEmail;

    /**
     * 个人简介
     */
    @Length(max = 200, message = "valid.setting.userIntroduction.length")
    private String userIntroduction;


    /**
     * 获取 是否开放个人中心
     */
    public boolean isOpen() {
        return this.open;
    }

    /**
     * 设置 是否开放个人中心
     */
    public void setOpen(boolean open) {
        this.open = open;
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
     * 获取 Email
     */
    public String getUserEmail() {
        return this.userEmail;
    }

    /**
     * 设置 Email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
}
