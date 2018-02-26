package com.personalWebsite.model.request.home;

import com.personalWebsite.model.request.PageForm;

/**
 * 分页表单
 * Created by xiatianlong on 2018/1/31.
 */
public class HomePageForm extends PageForm {

    /**
     * orderKey
     */
    private String orderKey;

    /**
     * 关键字搜索
     */
    private String keyword;

    /**
     * 获取 关键字搜索
     */
    public String getKeyword() {
        return this.keyword;
    }

    /**
     * 设置 关键字搜索
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 获取 orderKey
     */
    public String getOrderKey() {
        return this.orderKey;
    }

    /**
     * 设置 orderKey
     */
    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }
}
