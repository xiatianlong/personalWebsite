package com.personalWebsite.controller;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.model.request.article.ArticlePageForm;
import com.personalWebsite.model.response.article.ArticleCard;
import com.personalWebsite.model.response.article.ArticleInfo;
import com.personalWebsite.model.response.article.ArticleQueryResult;
import com.personalWebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章Controller.
 * Created by xiatianlong on 2017/12/4.
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章列表画面
     *
     * @return str
     */
    @GetMapping
    public String list(ArticlePageForm form, Model model) {

        List<ArticleCard> articleCards = articleService.getViewArticleList(form);
        // 文章集合
        model.addAttribute("articleList", articleCards);
        // 热门文章列表
        model.addAttribute("hotArticleList", articleService.getHotArticleList());
        // 最新文章列表
        model.addAttribute("newArticleList", articleService.getNewArticleList());
        // 是否显示加载更多
        model.addAttribute("hasMore", articleCards != null && articleCards.size() >= form.getPageSize());
        // 分类集合
        model.addAttribute("articleCategoryList", articleService.getViewArticleCategory());

        return "article/list";
    }

    /**
     * 文章列表条件搜索
     *
     * @return 文章列表页
     */
    @PostMapping("/query")
    @ResponseBody
    public ArticleQueryResult query(ArticlePageForm form) {
        ArticleQueryResult result = new ArticleQueryResult();
        List<ArticleCard> articleCards = articleService.getViewArticleList(form);
        result.setArticleCardList(articleCards);
        result.setHasMore(articleCards != null && articleCards.size() >= form.getPageSize());
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 文章详情
     *
     * @param articleId 文章id
     * @param model     model
     * @return 文章页
     */
    @GetMapping("/{articleId}")
    public String articleDetail(@PathVariable("articleId") String articleId, Model model) throws Exception {
        // 获取文章详细信息
        model.addAttribute("article", settingArticleDetail(articleId));
        // 设置文章访问量 + 1
        articleService.addArticleViewCnt(articleId);
        return "article/articleDetail";
    }

    /**
     * 设置文章详细信息
     *
     * @param articleId 文章id
     * @return ArticleInfo
     * @throws Exception e
     */
    private ArticleInfo settingArticleDetail(String articleId) throws Exception {
        ArticleEntity articleEntity = articleService.getArticleById(articleId);
        if (articleEntity == null) {
            throw new ApplicationException(getMessage("article.null"));
        }
        if (!ArticleStatus.REVIEW_PASSED.getCode().equals(articleEntity.getArticleStatus())) {
            throw new ApplicationException(getMessage("permissions.error"));
        }
        return articleService.buildArticleInfo(articleEntity);
    }

}
