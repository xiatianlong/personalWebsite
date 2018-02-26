package com.personalWebsite.controller;


import com.personalWebsite.common.system.Constant;
import com.personalWebsite.entity.UserEntity;
import com.personalWebsite.model.request.home.HomePageForm;
import com.personalWebsite.model.response.home.ArticleNoteReviewPassedCard;
import com.personalWebsite.model.response.home.HomeQueryResult;
import com.personalWebsite.service.ArticleService;
import com.personalWebsite.service.HomeService;
import com.personalWebsite.service.NoteService;
import com.personalWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 首页
 * Created by xiatianlong on 2017/12/3.
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

    @Autowired
    private ArticleService articleService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @Autowired
    private HomeService homeService;

    /**
     * 首页
     *
     * @param form  form
     * @param model model
     * @return index
     */
    @GetMapping
    public String home(HomePageForm form, Model model) {

        // 文章数
        model.addAttribute("articleCnt", articleService.getReviewPassedArticleCnt());
        // 笔记数
        model.addAttribute("noteCnt", noteService.getReviewPassedNoteCnt());
        // 留言数

        // 用户列表
        List<UserEntity> userEntityList = userService.getUserList();
        if (userEntityList != null && userEntityList.size() > 12) {
            model.addAttribute("userEntityList", userEntityList.subList(0, 12));
        } else {
            model.addAttribute("userEntityList", userEntityList);
        }
        // 用户数
        model.addAttribute("userCnt", userEntityList == null ? 0 : userEntityList.size());
        // 热门文章
        model.addAttribute("hotList", homeService.getHotList());
        // 最新文章
        model.addAttribute("newList", homeService.getNewList());
        // 文章&笔记列表
        List<ArticleNoteReviewPassedCard> articleNoteReviewPassedCards = homeService.getViewList(form);
        model.addAttribute("viewList", articleNoteReviewPassedCards);
        // 是否显示加载更多
        model.addAttribute("hasMore", articleNoteReviewPassedCards != null && articleNoteReviewPassedCards.size() >= form.getPageSize());
        return "index";
    }

    /**
     * 首页加载更多
     *
     * @param form form
     * @return 列表
     */
    @PostMapping("/query")
    @ResponseBody
    public HomeQueryResult query(HomePageForm form) {
        HomeQueryResult result = new HomeQueryResult();
        List<ArticleNoteReviewPassedCard> articleNoteReviewPassedCards = homeService.getViewList(form);
        result.setArticleNoteReviewPassedCards(articleNoteReviewPassedCards);
        result.setHasMore(articleNoteReviewPassedCards != null && articleNoteReviewPassedCards.size() >= form.getPageSize());
        result.setResult(Constant.SUCCESS);
        return result;
    }

}
