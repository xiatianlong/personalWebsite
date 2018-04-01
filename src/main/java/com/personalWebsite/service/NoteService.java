package com.personalWebsite.service;

import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.request.AuditForm;
import com.personalWebsite.model.request.note.AdminNotePageForm;
import com.personalWebsite.model.request.note.NotePageForm;
import com.personalWebsite.model.request.note.SaveOrUpdateForm;
import com.personalWebsite.model.response.note.AdminNoteQueryResult;
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
     * 获取全部笔记类别
     *
     * @return 类别集合
     */
    List<String> getAllNoteCategory();

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
     * 获取全部笔记列表
     *
     * @param adminNotePageForm form
     * @return 笔记列表
     */
    AdminNoteQueryResult getAllNoteList(AdminNotePageForm adminNotePageForm);

    /**
     * 增加笔记访问量
     *
     * @param noteId 笔记id
     */
    void addNoteViewCnt(String noteId) throws Exception;

    /**
     * 笔记审核
     *
     * @param noteId 笔记id
     * @param form   请求表单
     * @throws Exception e
     */
    void auditNote(String noteId, AuditForm form) throws Exception;

    /**
     * 获取笔记总数
     *
     * @return 笔记总数
     */
    int getNoteCnt();

    /**
     * 获取某个状态下的笔记数量
     *
     * @param status 状态
     * @return 笔记数
     */
    int getNoteCntByStatus(String status);

    /**
     * 获取用户下上线的笔记
     *
     * @param userId userid
     * @return list
     */
    List<NoteCard> getOnlineNoteByUser(String userId);
}
