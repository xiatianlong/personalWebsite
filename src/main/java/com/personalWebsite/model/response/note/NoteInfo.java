package com.personalWebsite.model.response.note;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 笔记详细信息
 * Created by xiatianlong on 2018/2/16.
 */
public class NoteInfo implements Serializable {
    private static final long serialVersionUID = 6900705144199673323L;

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
     * 笔记状态（名称）
     */
    private String noteStatusName;

    /**
     * 笔记内容
     */
    private String noteContent;

    /**
     * 笔记访问量
     */
    private int noteViewCnt;

    /**
     * 是否置顶
     */
    private boolean top;

    /**
     * 笔记作者id
     */
    private String userId;

    /**
     * 笔记作者名称
     */
    private String userName;

    /**
     * 分类集合
     */
    private List<String> categoryList;

    /**
     * 分类集合(格式化)
     */
    private String fmtCategoryList;

    /**
     * 笔记创建时间
     */
    private Date createTime;

    /**
     * 笔记创建时间(格式化)
     */
    private String fmtCreateTime;

    /**
     * 笔记更新时间
     */
    private Date updateTime;

    /**
     * 笔记更新时间(格式化)
     */
    private String fmtUpdateTime;

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
     * 获取 笔记状态（名称）
     */
    public String getNoteStatusName() {
        return this.noteStatusName;
    }

    /**
     * 设置 笔记状态（名称）
     */
    public void setNoteStatusName(String noteStatusName) {
        this.noteStatusName = noteStatusName;
    }

    /**
     * 获取 笔记内容
     */
    public String getNoteContent() {
        return this.noteContent;
    }

    /**
     * 设置 笔记内容
     */
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    /**
     * 获取 笔记访问量
     */
    public int getNoteViewCnt() {
        return this.noteViewCnt;
    }

    /**
     * 设置 笔记访问量
     */
    public void setNoteViewCnt(int noteViewCnt) {
        this.noteViewCnt = noteViewCnt;
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
     * 获取 笔记更新时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置 笔记更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 笔记更新时间(格式化)
     */
    public String getFmtUpdateTime() {
        return this.fmtUpdateTime;
    }

    /**
     * 设置 笔记更新时间(格式化)
     */
    public void setFmtUpdateTime(String fmtUpdateTime) {
        this.fmtUpdateTime = fmtUpdateTime;
    }
}
