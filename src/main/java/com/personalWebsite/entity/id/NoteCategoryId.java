package com.personalWebsite.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

/**
 * 笔记分类表联合主键
 * Created by xiatianlong on 2018/1/31.
 */
public class NoteCategoryId implements Serializable {


    private static final long serialVersionUID = 7009212637920288697L;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteCategoryId that = (NoteCategoryId) o;
        return Objects.equals(noteId, that.noteId) &&
                Objects.equals(noteCategory, that.noteCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, noteCategory);
    }
}
