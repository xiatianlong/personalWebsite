package com.personalWebsite.model.request.note;

import com.personalWebsite.model.request.PageForm;

/**
 * 笔记分页表单
 * Created by xiatianlong on 2018/2/9.
 */
public class NotePageForm extends PageForm {

    private static final long serialVersionUID = 6211380264982690395L;
    /**
     * 笔记id
     */
    private String noteId;

    /**
     * 笔记状态
     */
    private String[] noteStatus;

    /**
     * 笔记类别
     */
    private String[] noteCategory;


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
     * 获取 笔记状态
     */
    public String[] getNoteStatus() {
        return this.noteStatus;
    }

    /**
     * 设置 笔记状态
     */
    public void setNoteStatus(String[] noteStatus) {
        this.noteStatus = noteStatus;
    }

    /**
     * 获取 笔记类别
     */
    public String[] getNoteCategory() {
        return this.noteCategory;
    }

    /**
     * 设置 笔记类别
     */
    public void setNoteCategory(String[] noteCategory) {
        this.noteCategory = noteCategory;
    }
}
