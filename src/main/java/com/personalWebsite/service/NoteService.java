package com.personalWebsite.service;

import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.request.note.SaveOrUpdateForm;

/**
 * 笔记Service
 * Created by xiatianlong on 2018/1/29.
 */
public interface NoteService extends BaseService {

    /**
     * 根据笔记id获取笔记
     *
     * @param noteId 笔记id
     * @return 笔记
     */
    NoteEntity getNoteById(String noteId);

    /**
     * 创建笔记
     *
     * @param form form
     */
    void saveNote(SaveOrUpdateForm form);

    /**
     * 更新笔记
     *
     * @param form       form
     * @param noteEntity 笔记对象
     */
    void updateNote(SaveOrUpdateForm form, NoteEntity noteEntity);

    /**
     * 删除笔记对象
     *
     * @param noteEntity 笔记对象
     */
    void removeNote(NoteEntity noteEntity) throws Exception;
}
