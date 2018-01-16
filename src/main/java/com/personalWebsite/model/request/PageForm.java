package com.personalWebsite.model.request;

import java.io.Serializable;

/**
 * 分页表单请求
 * Created by xiatianlong on 2018/1/10.
 */
public class PageForm implements Serializable {

    private static final long serialVersionUID = 1246745755027196309L;

    /**
     * 页码
     */
    private int pageNo = 1;

    /**
     * 每页数量
     */
    private int pageSize = 15;


    /**
     * 获取 页码
     */
    public int getPageNo() {
        return this.pageNo;
    }

    /**
     * 设置 页码
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取 每页数量
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置 每页数量
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
