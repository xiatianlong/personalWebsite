package com.personalWebsite.entity;

import com.personalWebsite.entity.id.NoteCategoryId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * 笔记分类表实体
 * Created by xiatianlong on 2018/1/31.
 */
@Entity(name = "t_note_category")
@IdClass(NoteCategoryId.class)
public class NoteCategoryEntity extends BaseEntity {


    private static final long serialVersionUID = 7520960932134881021L;
    /**
     * 笔记id
     */
    private String noteId;

    /**
     * 笔记分类
     */
    private String noteCategory;


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
     * 获取 笔记分类
     */
    @Id
    @Column(name = "NOTE_CATEGORY", nullable = false, length = 30)
    public String getNoteCategory() {
        return this.noteCategory;
    }

    /**
     * 设置 笔记分类
     */
    public void setNoteCategory(String noteCategory) {
        this.noteCategory = noteCategory;
    }
}
