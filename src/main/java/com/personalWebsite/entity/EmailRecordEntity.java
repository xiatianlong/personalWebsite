package com.personalWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 邮件记录表.
 * Created by xiatianlong on 2018/1/5.
 */
@Entity(name = "t_email_record")
public class EmailRecordEntity extends BaseEntity {

    /**
     * 发送对象
     */
    private String emailTo;

    /**
     * 邮件标题
     */
    private String emailSubject;

    /**
     * 发送文本
     */
    private String emailContent;

    /**
     * 邮件唯一标识
     */
    private String emailCode;

    /**
     * 是否发送成功
     */
    private boolean success;

    /**
     * 成功发送时间
     */
    private Date sendSuccessTime;


    /**
     * 获取 发送对象
     */
    @Column(name = "EMAIL_TO", nullable = false, length = 50)
    public String getEmailTo() {
        return this.emailTo;
    }

    /**
     * 设置 发送对象
     */
    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    /**
     * 获取 邮件标题
     */
    @Column(name = "EMAIL_SUBJECT")
    public String getEmailSubject() {
        return this.emailSubject;
    }

    /**
     * 设置 邮件标题
     */
    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    /**
     * 获取 发送文本
     */
    @Column(name = "EMAIL_CONTENT", nullable = false)
    public String getEmailContent() {
        return this.emailContent;
    }

    /**
     * 设置 发送文本
     */
    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    /**
     * 获取 邮件唯一标识
     */
    @Id
    @Column(name = "EMAIL_CODE", nullable = false, length = 50)
    public String getEmailCode() {
        return this.emailCode;
    }

    /**
     * 设置 邮件唯一标识
     */
    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    /**
     * 获取 是否发送成功
     */
    @Column(name = "IS_SUCCESS", nullable = false)
    public boolean isSuccess() {
        return this.success;
    }

    /**
     * 设置 是否发送成功
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 获取 成功发送时间
     */
    @Column(name = "SEND_SUCCESS_TIME")
    public Date getSendSuccessTime() {
        return this.sendSuccessTime;
    }

    /**
     * 设置 成功发送时间
     */
    public void setSendSuccessTime(Date sendSuccessTime) {
        this.sendSuccessTime = sendSuccessTime;
    }
}
