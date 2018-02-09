package com.personalWebsite.model.response.note;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 笔记卡片
 * Created by xiatianlong on 2018/1/31.
 */
public class NoteCard implements Serializable {

    private static final long serialVersionUID = 733686331005360175L;
    /**
     * 笔记id
     */
    private String noteId;

    /**
     * 笔记标题
     */
    private String noteTitle;

    /**
     * 笔记状态
     */
    private String noteStatus;

    /**
     * 笔记创建时间
     */
    private Date createTime;

    /**
     * 笔记创建时间(格式化)
     */
    private String fmtCreateTime;

    /**
     * 笔记创建时间(中文格式化)
     */
    private String fmtCreateTimeCN;

    /**
     * 分类集合
     */
    private List<String> categoryList;

    /**
     * 分类集合(格式化)
     */
    private String fmtCategoryList;

    /**
     * 笔记作者id
     */
    private String userId;

    /**
     * 笔记作者名称
     */
    private String userName;

    /**
     * 笔记访问量
     */
    private int noteViewsCnt;

    /**
     * 是否置顶
     */
    private boolean top;


    /**
     * 获取 笔记id
     */
    public String getNoteId() {
        return this.noteId;
    }

    /**
     * 设置 笔记id
     */
    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    /**
     * 获取 笔记标题
     */
    public String getNoteTitle() {
        return this.noteTitle;
    }

    /**
     * 设置 笔记标题
     */
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    /**
     * 获取 笔记状态
     */
    public String getNoteStatus() {
        return this.noteStatus;
    }

    /**
     * 设置 笔记状态
     */
    public void setNoteStatus(String noteStatus) {
        this.noteStatus = noteStatus;
    }

    /**
     * 获取 笔记创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 笔记创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 笔记创建时间(格式化)
     */
    public String getFmtCreateTime() {
        return this.fmtCreateTime;
    }

    /**
     * 设置 笔记创建时间(格式化)
     */
    public void setFmtCreateTime(String fmtCreateTime) {
        this.fmtCreateTime = fmtCreateTime;
    }

    /**
     * 获取 笔记创建时间(中文格式化)
     */
    public String getFmtCreateTimeCN() {
        return this.fmtCreateTimeCN;
    }

    /**
     * 设置 笔记创建时间(中文格式化)
     */
    public void setFmtCreateTimeCN(String fmtCreateTimeCN) {
        this.fmtCreateTimeCN = fmtCreateTimeCN;
    }

    /**
     * 获取 分类集合
     */
    public List<String> getCategoryList() {
        return this.categoryList;
    }

    /**
     * 设置 分类集合
     */
    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * 获取 分类集合(格式化)
     */
    public String getFmtCategoryList() {
        return this.fmtCategoryList;
    }

    /**
     * 设置 分类集合(格式化)
     */
    public void setFmtCategoryList(String fmtCategoryList) {
        this.fmtCategoryList = fmtCategoryList;
    }

    /**
     * 获取 笔记作者id
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 笔记作者id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 笔记作者名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 笔记作者名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 是否置顶
     */
    public boolean isTop() {
        return this.top;
    }

    /**
     * 设置 是否置顶
     */
    public void setTop(boolean top) {
        this.top = top;
    }

    /**
     * 获取 笔记访问量
     */
    public int getNoteViewsCnt() {
        return this.noteViewsCnt;
    }

    /**
     * 设置 笔记访问量
     */
    public void setNoteViewsCnt(int noteViewsCnt) {
        this.noteViewsCnt = noteViewsCnt;
    }
}
