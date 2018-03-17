package com.personalWebsite.controller;

import com.personalWebsite.common.enums.BizType;
import com.personalWebsite.common.enums.CommentBizType;
import com.personalWebsite.common.enums.NoteStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.entity.CollectionEntity;
import com.personalWebsite.entity.CommentEntity;
import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.request.comment.CommentPageForm;
import com.personalWebsite.model.request.note.NotePageForm;
import com.personalWebsite.model.response.note.NoteCard;
import com.personalWebsite.model.response.note.NoteInfo;
import com.personalWebsite.model.response.note.NoteQueryResult;
import com.personalWebsite.service.CollectionService;
import com.personalWebsite.service.CommentService;
import com.personalWebsite.service.NoteService;
import com.personalWebsite.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页笔记controller.
 * Created by xiatianlong on 2017/12/4.
 */
@Controller
@RequestMapping("/note")
public class NoteController extends BaseController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private CommentService commentService;

    /**
     * 笔记列表
     *
     * @param form  form
     * @param model model
     * @return list
     */
    @GetMapping
    public String list(NotePageForm form, Model model) {
        List<NoteCard> noteCards = noteService.getViewNoteList(form);
        // 笔记集合
        model.addAttribute("noteList", noteCards);
        // 是否显示加载更多
        model.addAttribute("hasMore", noteCards != null && noteCards.size() >= form.getPageSize());
        // 分类集合
        model.addAttribute("noteCategoryList", noteService.getViewNoteCategory());
        return "note/list";
    }

    /**
     * 笔记列表条件搜索
     *
     * @return 笔记列表页
     */
    @PostMapping("/query")
    @ResponseBody
    public NoteQueryResult query(NotePageForm form) {
        NoteQueryResult result = new NoteQueryResult();
        List<NoteCard> noteCards = noteService.getViewNoteList(form);
        result.setNoteCardList(noteCards);
        result.setHasMore(noteCards != null && noteCards.size() >= form.getPageSize());
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 笔记详情
     *
     * @param noteId 笔记id
     * @param model  model
     * @return 笔记页
     */
    @GetMapping("/{noteId}")
    public String articleDetail(@PathVariable("noteId") String noteId, Model model) throws Exception {
        // 获取笔记详细信息
        model.addAttribute("note", settingArticleDetail(noteId));
        // 设置笔记访问量 + 1
        noteService.addNoteViewCnt(noteId);
        // 是否收藏过笔记
        CollectionEntity collectionEntity = collectionService.getCollection(BizType.NOTE.getCode(), noteId, getLoinUser().getUserId());
        model.addAttribute("isCollection", collectionEntity != null);

        // 留言相关
        CommentPageForm form = new CommentPageForm();
        form.setCommentBizType(CommentBizType.NOTE.getCode());
        PageVO<CommentEntity> pageVO = commentService.getCommentListByPage(form);

        model.addAttribute("dataList", commentService.getCommentInfo(pageVO.getDataList()));
        //数据总数
        model.addAttribute("totalCnt", pageVO.getTotalCnt());
        // 页码
        model.addAttribute("pageNo", form.getPageNo());
        // 每页显示数量
        model.addAttribute("pageSize", form.getPageSize());

        return "note/noteDetail";
    }

    /**
     * 设置笔记详细信息
     *
     * @param noteId 笔记id
     * @return NoteInfo
     * @throws Exception e
     */
    private NoteInfo settingArticleDetail(String noteId) throws Exception {
        NoteEntity noteEntity = noteService.getNoteById(noteId);
        if (noteEntity == null) {
            throw new ApplicationException(getMessage("note.null"));
        }
        if (!NoteStatus.REVIEW_PASSED.getCode().equals(noteEntity.getNoteStatus())) {
            throw new ApplicationException(getMessage("permissions.error"));
        }
        return noteService.buildNoteInfo(noteEntity);
    }
}
