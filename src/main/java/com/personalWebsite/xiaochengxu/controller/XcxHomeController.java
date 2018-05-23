package com.personalWebsite.xiaochengxu.controller;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.enums.BizType;
import com.personalWebsite.common.enums.NoteStatus;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.entity.NoteEntity;
import com.personalWebsite.model.request.home.HomePageForm;
import com.personalWebsite.model.response.article.ArticleInfo;
import com.personalWebsite.model.response.home.ArticleNoteReviewPassedCard;
import com.personalWebsite.model.response.note.NoteInfo;
import com.personalWebsite.service.*;
import com.personalWebsite.xiaochengxu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiatianlong on 2018/4/15.
 */
@RestController
@RequestMapping("/xiaochengxu")
public class XcxHomeController extends BaseController {

    @Autowired
    private HomeService homeService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private XcxCommentService commentService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private NoteService noteService;

    @GetMapping("/home")
    public XcxHomeQueryResult home(HomePageForm form) {
        XcxHomeQueryResult result = new XcxHomeQueryResult();

        // 数据卡片列表
        List<ArticleNoteReviewPassedCard> articleNoteReviewPassedCards = homeService.getViewList(form);
        result.setArticleNoteReviewPassedCards(articleNoteReviewPassedCards);
        result.setHasMore(articleNoteReviewPassedCards != null && articleNoteReviewPassedCards.size() >= form.getPageSize());
        // banner图片
        result.setBannerList(bannerService.getAllBanner());

        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 首页加载更多
     *
     * @param form form
     * @return 列表
     */
    @PostMapping("/home/query")
    public XcxHomeQueryResult query(HomePageForm form) {
        XcxHomeQueryResult result = new XcxHomeQueryResult();
        // 数据卡片列表
        List<ArticleNoteReviewPassedCard> articleNoteReviewPassedCards = homeService.getViewList(form);
        result.setArticleNoteReviewPassedCards(articleNoteReviewPassedCards);
        result.setHasMore(articleNoteReviewPassedCards != null && articleNoteReviewPassedCards.size() >= form.getPageSize());
        result.setResult(Constant.SUCCESS);
        return result;
    }


    /**
     * 添加留言
     *
     * @param form form
     * @return result
     */
    @PostMapping("/addComment")
    public XcxAddCommentResult addComment(XcxCommentForm form) {
        return commentService.saveComment(form);
    }

    /**
     * 小程序留言画面初始化和加载更多接口
     *
     * @param form 表单
     * @return result
     */
    @PostMapping("/initAndMore")
    public XcxCommentListResult initAndGetMore(XcxCommentPageForm form) {
        return commentService.getCommentList(form);
    }

    /**
     * 获取文章详情
     *
     * @param articleId 文章id
     * @return result
     * @throws Exception e
     */
    @GetMapping("/article/{articleId}")
    public XcxDetailResult articleDetail(@PathVariable("articleId") String articleId) throws Exception {
        XcxDetailResult result = new XcxDetailResult();
        ArticleEntity articleEntity = articleService.getArticleById(articleId);
        if (articleEntity == null) {
            result.setMessage(getMessage("article.null"));
            return result;
        }
        if (!ArticleStatus.REVIEW_PASSED.getCode().equals(articleEntity.getArticleStatus())) {
            result.setMessage(getMessage("permissions.error"));
            return result;
        }
        ArticleInfo articleInfo = articleService.buildArticleInfo(articleEntity);
        result.setArticleInfo(articleInfo);
        result.setBizType(BizType.ARTICLE.getCode());
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 获取笔记详情
     *
     * @param noteId 笔记id
     * @return result
     * @throws Exception e
     */
    @GetMapping("/note/{noteId}")
    public XcxDetailResult noteDetail(@PathVariable("noteId") String noteId) throws Exception {
        XcxDetailResult result = new XcxDetailResult();
        NoteEntity noteEntity = noteService.getNoteById(noteId);
        if (noteEntity == null) {
            result.setMessage(getMessage("note.null"));
            return result;
        }
        if (!NoteStatus.REVIEW_PASSED.getCode().equals(noteEntity.getNoteStatus())) {
            result.setMessage(getMessage("permissions.error"));
            return result;
        }
        NoteInfo noteInfo = noteService.buildNoteInfo(noteEntity);
        result.setNoteInfo(noteInfo);
        result.setBizType(BizType.NOTE.getCode());
        result.setResult(Constant.SUCCESS);
        return result;
    }

}
