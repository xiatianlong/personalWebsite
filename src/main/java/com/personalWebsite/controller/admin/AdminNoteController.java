package com.personalWebsite.controller.admin;

import com.personalWebsite.common.enums.BizType;
import com.personalWebsite.common.enums.NoteStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.dictionary.DictionaryCache;
import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.request.AuditForm;
import com.personalWebsite.model.request.note.AdminNotePageForm;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.model.response.AuditInitResult;
import com.personalWebsite.model.response.note.AdminNoteQueryResult;
import com.personalWebsite.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiatianlong on 2018/2/28.
 */
@Controller
@RequestMapping("/admin/note")
public class AdminNoteController extends BaseController {

    @Autowired
    private NoteService noteService;

    /**
     * 笔记列表
     *
     * @param form  form
     * @param model model
     * @return 列表画面
     */
    @GetMapping("/list")
    public String noteList(AdminNotePageForm form, Model model) {
        AdminNoteQueryResult result = noteService.getAllNoteList(form);
        model.addAttribute("noteList", result.getNoteInfos());
        model.addAttribute("pageSize", form.getPageSize());
        model.addAttribute("dataCount", result.getDataCount());

        // 笔记状态
        model.addAttribute("noteStatusList", DictionaryCache.getChildList(NoteStatus.CODE.getCode()));
        // 笔记分类
        model.addAttribute("noteCategoryList", noteService.getAllNoteCategory());

        return "admin/note/list";
    }

    /**
     * 笔记列表
     *
     * @param form form
     * @return 列表画面
     */
    @PostMapping("/query")
    @ResponseBody
    public AdminNoteQueryResult noteListQuery(AdminNotePageForm form) {
        AdminNoteQueryResult result = noteService.getAllNoteList(form);
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 笔记预览
     *
     * @param noteId 笔记id
     * @param model  model
     * @return preView
     * @throws Exception e
     */
    @GetMapping("/preview/{noteId}")
    public String preView(@PathVariable("noteId") String noteId, Model model) throws Exception {
        NoteEntity noteEntity = noteService.getNoteById(noteId);
        model.addAttribute("note", noteService.buildNoteInfo(noteEntity));
        return "admin/note/preView";
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
    public AsynchronousResult removeNote(@PathVariable("noteId") String noteId) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        NoteEntity noteEntity = noteService.getNoteById(noteId);
        if (noteEntity == null) {
            result.setMessage(getMessage("note.null"));
            return result;
        }
        // 删除笔记操作
        noteService.removeNote(noteEntity);
        result.setResult(Constant.SUCCESS);
        return result;
    }


    /**
     * 审核笔记初始化接口
     *
     * @param noteId 笔记id
     * @return result
     * @throws Exception e
     */
    @GetMapping("/audit/{noteId}")
    @ResponseBody
    public AuditInitResult getAuditNoteInfo(@PathVariable("noteId") String noteId) throws Exception {
        AuditInitResult result = new AuditInitResult();
        NoteEntity noteEntity = noteService.getNoteById(noteId);
        if (noteEntity == null) {
            throw new ApplicationException(getMessage("note.null"));
        }
        // 校验状态
        if (!NoteStatus.UNDER_REVIEW.getCode().equals(noteEntity.getNoteStatus())
                && !NoteStatus.REVIEW_PASSED.getCode().equals(noteEntity.getNoteStatus())
                && !NoteStatus.REVIEW_NOT_PASSED.getCode().equals(noteEntity.getNoteStatus())) {
            throw new ApplicationException(getMessage("audit.status.error"));
        }
        result.setBizId(noteEntity.getNoteId());
        result.setBizType(BizType.NOTE.getCode());
        result.setStatus(noteEntity.getNoteStatus());
        result.setStatusName(DictionaryCache.getName(noteEntity.getNoteStatus()));
        result.setCategory(noteService.getAllNoteCategory());
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 审核笔记
     *
     * @param noteId 笔记id
     * @param form   form
     * @return result
     */
    @PostMapping("/audit/{noteId}")
    @ResponseBody
    public AsynchronousResult auditArticle(@PathVariable("noteId") String noteId, AuditForm form) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        noteService.auditNote(noteId, form);
        result.setResult(Constant.SUCCESS);
        return result;
    }


}
