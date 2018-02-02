package com.personalWebsite.service;

import com.personalWebsite.common.enums.NoteStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.dao.NoteRepository;
import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.request.note.SaveOrUpdateForm;
import com.personalWebsite.utils.IdUtil;
import com.personalWebsite.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 笔记服务类.
 * Created by xiatianlong on 2018/1/29.
 */
@Service
@Transactional(readOnly = true)
public class NoteServiceImpl extends BaseServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    /**
     * 根据笔记id获取笔记
     *
     * @param noteId 笔记id
     * @return 笔记
     */
    @Override
    public NoteEntity getNoteById(String noteId) {
        if (StringUtils.isEmpty(noteId)) {
            return null;
        }
        return noteRepository.findByNoteId(noteId);
    }

    /**
     * 创建笔记
     *
     * @param form form
     */
    @Override
    public void saveNote(SaveOrUpdateForm form) {
        NoteEntity noteEntity = new NoteEntity();

        UserInfo userInfo = getLoinUser();
        Date now = new Date();
        // 笔记id
        noteEntity.setNoteId(IdUtil.createId(userInfo.getUserId()));
        // 笔记标题
        noteEntity.setNoteTitle(form.getNoteTitle());
        // 笔记状态
        noteEntity.setNoteStatus(form.getNoteStatus());
        // 笔记内容
        noteEntity.setNoteContent(form.getNoteContent());
        // 访问量
        noteEntity.setNoteViewCnt(0);
        // 是否删除
        noteEntity.setDeleted(false);
        // 作者id
        noteEntity.setUserId(userInfo.getUserId());

        noteEntity.setCreateTime(now);
        noteEntity.setUpdateTime(now);
        noteEntity.setCreateUser(userInfo.getUserId());
        noteEntity.setUpdateUser(userInfo.getUserId());

        noteRepository.save(noteEntity);
    }

    /**
     * 更新笔记
     *
     * @param form       form
     * @param noteEntity 笔记对象
     */
    @Transactional
    @Override
    public void updateNote(SaveOrUpdateForm form, NoteEntity noteEntity) {

        // 笔记标题
        noteEntity.setNoteTitle(form.getNoteTitle());
        // 笔记状态
        noteEntity.setNoteStatus(form.getNoteStatus());
        // 笔记内容
        noteEntity.setNoteContent(form.getNoteContent());

        noteEntity.setUpdateTime(new Date());
        noteEntity.setUpdateUser(getLoinUser().getUserId());

        noteRepository.saveAndFlush(noteEntity);
    }

    /**
     * 删除笔记对象
     *
     * @param noteEntity 笔记对象
     */
    @Override
    public void removeNote(NoteEntity noteEntity) throws Exception {
        if (noteEntity != null) {
            noteEntity.setNoteStatus(NoteStatus.DELETE.getCode());
            noteEntity.setUpdateTime(new Date());
            noteEntity.setUpdateUser(getLoinUser().getUserId());
            noteRepository.saveAndFlush(noteEntity);
        } else {
            throw new ApplicationException(getMessage("note.null"));
        }
    }
}
