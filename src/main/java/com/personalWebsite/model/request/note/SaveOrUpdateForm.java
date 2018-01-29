package com.personalWebsite.model.request.note;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 笔记保存、更新form
 * Created by xiatianlong on 2018/1/29.
 */
public class SaveOrUpdateForm implements Serializable {
    private static final long serialVersionUID = -1860657531592491462L;

    /**
     * 笔记id
     */
    private String noteId;

    /**
     * 笔记标题
     */
    @NotNull(message = "note.title.notnull")
    @Length(max = 100, message = "note.title.length")
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
}
