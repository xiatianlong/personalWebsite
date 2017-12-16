package com.personalWebsite.common.mail;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 邮件参数
 * Created by xiatianlong on 2017/12/16.
 */
public class MailInfo {

    /**
     * 单一收件人地址
     */
    private String to;
    /**
     * 复数收件人地址
     */
    private Set<String> toList;
    /**
     * 邮件人标题
     */
    private String subject;
    /**
     * 邮件正文
     */
    private String content;
    /**
     * 邮件模板名称
     */
    private String templateName;

    /**
     * 邮件参数
     */
    private Map<String, Object> arguments;

    /**
     * 邮件附件集合
     */
    private List<MailAttachment> attachments;


    /**
     * 获取 单一收件人地址
     */
    public String getTo() {
        return this.to;
    }

    /**
     * 设置 单一收件人地址
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * 获取 复数收件人地址
     */
    public Set<String> getToList() {
        return this.toList;
    }

    /**
     * 设置 复数收件人地址
     */
    public void setToList(Set<String> toList) {
        this.toList = toList;
    }

    /**
     * 获取 邮件人标题
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * 设置 邮件人标题
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 获取 邮件正文
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 设置 邮件正文
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取 邮件附件集合
     */
    public List<MailAttachment> getAttachments() {
        return this.attachments;
    }

    /**
     * 设置 邮件附件集合
     */
    public void setAttachments(List<MailAttachment> attachments) {
        this.attachments = attachments;
    }


    /**
     * 获取 邮件模板名称
     */
    public String getTemplateName() {
        return this.templateName;
    }

    /**
     * 设置 邮件模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }


    /**
     * 获取 邮件参数
     */
    public Map<String, Object> getArguments() {
        return this.arguments;
    }

    /**
     * 设置 邮件参数
     */
    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }
}
