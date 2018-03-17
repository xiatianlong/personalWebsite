package com.personalWebsite.controller.admin;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.enums.CommentBizType;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.entity.UserEntity;
import com.personalWebsite.service.ArticleService;
import com.personalWebsite.service.CommentService;
import com.personalWebsite.service.NoteService;
import com.personalWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 首页 controller.
 * Created by xiatianlong on 2018/2/28.
 */
@Controller
@RequestMapping("/admin/index")
public class AdminIndexController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private CommentService commentService;
    /**
     * 后台首页列表服务类
     *
     * @param model model
     * @return 首页
     */
    @GetMapping
    public String index(Model model) {
        model.addAttribute("articleCnt", articleService.getArticleCnt());
        model.addAttribute("articleUnderReviewCnt", articleService.getArticleCntByStatus(ArticleStatus.UNDER_REVIEW.getCode()));
        model.addAttribute("noteCnt", noteService.getNoteCnt());
        model.addAttribute("noteUnderReviewCnt", noteService.getNoteCntByStatus(ArticleStatus.UNDER_REVIEW.getCode()));
        model.addAttribute("commentByMessageCnt", commentService.getCommentCount(CommentBizType.MESSAGE.getCode()));
        List<UserEntity> userEntityList = userService.getUserList();
        model.addAttribute("userCnt", userEntityList != null ? userEntityList.size() : 0);
        return "admin/index";
    }


}
