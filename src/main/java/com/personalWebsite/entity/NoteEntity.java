package com.personalWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 笔记表实体
 * Created by xiatianlong on 2018/1/20.
 */
@Entity(name = "t_note")
public class NoteEntity extends BaseEntity {
    private static final long serialVersionUID = -7400882894196573033L;

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
     * 笔记内容
     */
    private String noteContent;

    /**
     * 笔记访问量
     */
    private int noteViewCnt;

    /**
     * 是否删除
     */
    private boolean deleted;

    /**
     * 笔记作者id
     */
    private String userId;


    /**
     * 获取 笔记id
     */
    @Id
    @Column(name = "NOTE_ID", nullable = false, length = 50)
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
    @Column(name = "NOTE_TITLE", nullable = false, length = 100)
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
    @Column(name = "NOTE_STATUS", nullable = false, length = 10)
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
     * 获取 笔记内容
     */
    @Column(name = "NOTE_CONTENT")
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
    @Column(name = "NOTE_VIEWS_CNT", nullable = false)
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
     * 获取 是否删除
     */
    @Column(name = "IS_DELETE", nullable = false)
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * 设置 是否删除
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取 笔记作者id
     */
    @Column(name = "USER_ID", nullable = false, length = 100)
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 笔记作者id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
