package com.personalWebsite.service;

import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.request.note.NotePageForm;
import com.personalWebsite.model.request.note.SaveOrUpdateForm;
import com.personalWebsite.model.response.note.NoteCard;
import com.personalWebsite.model.response.note.NoteInfo;

import java.util.List;

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
     * 获取我的笔记列表
     *
     * @param notePageForm form
     * @return 笔记列表
     */
    List<NoteCard> getMyNoteList(NotePageForm notePageForm);

    /**
     * 获取笔记类别
     *
     * @return 类别集合
     */
    List<String> getNoteCategory();

    /**
     * 获取可见的笔记类别
     *
     * @return 类别集合
     */
    List<String> getViewNoteCategory();

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

    /**
     * 构建笔记信息
     *
     * @param noteEntity 笔记实体对象
     * @return info
     */
    NoteInfo buildNoteInfo(NoteEntity noteEntity);

    /**
     * 获取可查看的笔记列表
     *
     * @param notePageForm form
     * @return 笔记列表
     */
    List<NoteCard> getViewNoteList(NotePageForm notePageForm);

    /**
     * 增加笔记访问量
     *
     * @param noteId 笔记id
     */
    void addNoteViewCnt(String noteId) throws Exception;
}
