package com.personalWebsite.common.mail;

/**
 * 邮件附件信息
 * Created by xiatianlong on 2017/12/16.
 */
public class MailAttachment {

    /**
     * 附件名称
     */
    private String name;
    /**
     * 附件地址
     */
    private String url;


    /**
     * 获取 附件名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 附件名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 附件地址
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * 设置 附件地址
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
