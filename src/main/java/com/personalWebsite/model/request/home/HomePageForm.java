package com.personalWebsite.model.request.home;

import com.personalWebsite.model.request.PageForm;

/**
 * 分页表单
 * Created by xiatianlong on 2018/1/31.
 */
public class HomePageForm extends PageForm {

    /**
     * id
     */
    private String id;

    /**
     * 获取 id
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 id
     */
    public void setId(String id) {
        this.id = id;
    }
}
