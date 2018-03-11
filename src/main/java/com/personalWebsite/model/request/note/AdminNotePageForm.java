package com.personalWebsite.model.request.note;

/**
 * 笔记后台分页表单
 * Created by xiatianlong on 2018/1/31.
 */
public class AdminNotePageForm extends NotePageForm {

    /**
     * 是否删除的
     */
    private Integer deleted;

    /**
     * 关键字
     */
    private String keyword;


    /**
     * 获取 是否删除的
     */
    public Integer getDeleted() {
        return this.deleted;
    }

    /**
     * 设置 是否删除的
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }


    /**
     * 获取 关键字
     */
    public String getKeyword() {
        return this.keyword;
    }

    /**
     * 设置 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
