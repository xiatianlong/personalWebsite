package com.personalWebsite.controller.admin;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.dictionary.DictionaryCache;
import com.personalWebsite.model.request.article.AdminArticlePageForm;
import com.personalWebsite.model.response.article.AdminArticleQueryResult;
import com.personalWebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 后台文章controller.
 * Created by xiatianlong on 2018/2/28.
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章列表
     *
     * @param form  form
     * @param model model
     * @return 列表画面
     */
    @GetMapping("/list")
    public String articleList(AdminArticlePageForm form, Model model) {
        AdminArticleQueryResult result = articleService.getAllArticleList(form);
        model.addAttribute("articleList", result.getArticleInfos());
        model.addAttribute("pageSize", form.getPageSize());
        model.addAttribute("dataCount", result.getDataCount());

        // 文章状态
        model.addAttribute("articleStatusList", DictionaryCache.getChildList(ArticleStatus.CODE.getCode()));
        // 文章分类
        model.addAttribute("articleCategoryList", articleService.getAllArticleCategory());

        return "admin/article/list";
    }

    /**
     * 文章列表
     *
     * @param form form
     * @return 列表画面
     */
    @PostMapping("/query")
    @ResponseBody
    public AdminArticleQueryResult articleListQuery(AdminArticlePageForm form) {
        AdminArticleQueryResult result = articleService.getAllArticleList(form);
        result.setResult(Constant.SUCCESS);
        return result;
    }



}
