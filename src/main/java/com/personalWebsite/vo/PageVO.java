package com.personalWebsite.vo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by xiatianlong on 2018/1/10.
 */
public class PageVO<T> {

    /**
     * 数据总数
     */
    private List<T> dataList;

    /**
     * 每页显示数量
     */
    private int pageSize;

    /**
     * 当前页数
     */
    private int pageNo;

    /**
     * 数据总数
     */
    private long totalCnt;

    /**
     * 总页数
     */
    private int totalPages;


    /**
     * page对象
     *
     * @param page page
     */
    public PageVO(Page<T> page) {
        this.dataList = page.getContent();
        this.pageSize = page.getSize();
        this.pageNo = page.getNumber() + 1;
        this.totalCnt = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }


    /**
     * 获取  数据总数
     */
    public List<T> getDataList() {
        return this.dataList;
    }

    /**
     * 设置  数据总数
     */
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    /**
     * 获取 每页显示数量
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置 每页显示数量
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 当前页数
     */
    public int getPageNo() {
        return this.pageNo;
    }

    /**
     * 设置 当前页数
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取 数据总数
     */
    public long getTotalCnt() {
        return this.totalCnt;
    }

    /**
     * 设置 数据总数
     */
    public void setTotalCnt(long totalCnt) {
        this.totalCnt = totalCnt;
    }


    /**
     * 获取 总页数
     */
    public int getTotalPages() {
        return this.totalPages;
    }

    /**
     * 设置 总页数
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
