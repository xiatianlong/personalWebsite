package com.personalWebsite.controller.member;

import com.personalWebsite.common.enums.NoteStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.request.note.SaveOrUpdateForm;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 会员笔记controller
 * Created by xiatianlong on 2018/1/29.
 */
@Controller
@RequestMapping("/member/note")
public class MemberNoteController extends BaseController {

    @Autowired
    private NoteService noteService;

    /**
     * 笔记列表
     *
     * @return 笔记列表页
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {

        return "personalCenter/note/myPublishNoteList";
    }

    /**
     * 我的笔记详情
     *
     * @param noteId 笔记id
     * @param model  model
     * @return 笔记页
     */
    @RequestMapping(value = "/{noteId}", method = RequestMethod.GET)
    public String noteDetail(@PathVariable("noteId") String noteId, Model model) throws Exception {

        NoteEntity noteEntity = noteService.getNoteById(noteId);
        if (noteEntity == null) {
            throw new ApplicationException(getMessage("note.null"));
        }
        if (!noteEntity.getUserId().equals(getLoinUser().getUserId())) {
            throw new ApplicationException(getMessage("permissions.error"));
        }
        model.addAttribute("note", noteEntity);
        return "personalCenter/note/myNoteDetail";
    }


    /**
     * 创建笔记
     *
     * @param form          from
     * @param bindingResult bindingResult
     * @return result
     */
    @PostMapping("/create")
    @ResponseBody
    public AsynchronousResult createNote(@Valid SaveOrUpdateForm form, BindingResult bindingResult) {
        AsynchronousResult result = new AsynchronousResult();
        // 基本校验
        if (bindingResult.hasErrors()) {
            result.setMessage(getMessage(bindingResult.getAllErrors().get(0).getDefaultMessage()));
            return result;
        }
        // 二级校验
        String errorStr = validSaveOrUpdateNote(form);
        if (!StringUtils.isEmpty(errorStr)) {
            result.setMessage(errorStr);
            return result;
        }
        // 保存笔记操作
        noteService.saveNote(form);

        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 更新笔记
     *
     * @param form          form
     * @param noteId        noteId
     * @param bindingResult bindingResult
     * @return result
     * @throws Exception e
     */
    @PostMapping("/update/{noteId}")
    @ResponseBody
    public AsynchronousResult updateNote(@Valid SaveOrUpdateForm form, @PathVariable("noteId") String noteId, BindingResult bindingResult) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        NoteEntity noteEntity = noteService.getNoteById(noteId);
        if (noteEntity == null) {
            result.setMessage(getMessage("note.null"));
            return result;
        }
        if (!noteEntity.getUserId().equals(getLoinUser().getUserId())) {
            result.setMessage(getMessage("permissions.error"));
            return result;
        }
        // 基本校验
        if (bindingResult.hasErrors()) {
            result.setMessage(getMessage(bindingResult.getAllErrors().get(0).getDefaultMessage()));
            return result;
        }
        // 二级校验
        String errorStr = validSaveOrUpdateNote(form);
        if (!StringUtils.isEmpty(errorStr)) {
            result.setMessage(errorStr);
            return result;
        }
        // 保存笔记操作
        noteService.updateNote(form, noteEntity);

        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 删除笔记
     *
     * @param noteId noteId
     * @return result
     * @throws Exception e
     */
    @PostMapping("/delete/{noteId}")
    @ResponseBody
    public AsynchronousResult updateNote(@PathVariable("noteId") String noteId) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        NoteEntity noteEntity = noteService.getNoteById(noteId);
        if (noteEntity == null) {
            result.setMessage(getMessage("note.null"));
            return result;
        }
        if (!noteEntity.getUserId().equals(getLoinUser().getUserId())) {
            result.setMessage(getMessage("permissions.error"));
            return result;
        }
        // 保存笔记操作
        noteService.removeNote(noteEntity);

        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 笔记保存更新校验
     *
     * @param form form
     * @return 错误信息
     */
    private String validSaveOrUpdateNote(SaveOrUpdateForm form) {
        // 装填校验
        if (!form.getNoteStatus().equals(NoteStatus.DRAFT.getCode())
                && !form.getNoteStatus().equals(NoteStatus.UNDER_REVIEW.getCode())) {
            return getMessage("note.status.error");
        }
        // 草稿（校验标题，）
        // bindingResult已做过基本校验

        // 提交审核（标题，摘要，内容）
        if (form.getNoteStatus().equals(NoteStatus.UNDER_REVIEW.getCode())) {
            // bindingResult已做过标题校验
            if (StringUtils.isEmpty(form.getNoteContent())) {
                return getMessage("note.content.notnull");
            }
        }
        return null;
    }

}
