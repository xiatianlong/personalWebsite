package com.personalWebsite.controller.admin;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.enums.BizType;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.dictionary.DictionaryCache;
import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.model.request.AuditForm;
import com.personalWebsite.model.request.article.AdminArticlePageForm;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.model.response.AuditInitResult;
import com.personalWebsite.model.response.article.AdminArticleQueryResult;
import com.personalWebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 文章预览
     *
     * @param articleId 文章id
     * @param model     model
     * @return preView
     * @throws Exception e
     */
    @GetMapping("/preview/{articleId}")
    public String preView(@PathVariable("articleId") String articleId, Model model) throws Exception {
        ArticleEntity articleEntity = articleService.getArticleById(articleId);
        model.addAttribute("article", articleService.buildArticleInfo(articleEntity));
        return "admin/article/preView";
    }

    /**
     * 删除文章
     *
     * @param articleId articleId
     * @return result
     * @throws Exception e
     */
    @PostMapping("/delete/{articleId}")
    @ResponseBody
    public AsynchronousResult removeArticle(@PathVariable("articleId") String articleId) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        ArticleEntity articleEntity = articleService.getArticleById(articleId);
        if (articleEntity == null) {
            result.setMessage(getMessage("article.null"));
            return result;
        }
        // 删除文章操作
        articleService.removeArticle(articleEntity);
        result.setResult(Constant.SUCCESS);
        return result;
    }


    /**
     * 审核文章初始化接口
     *
     * @param articleId 文章id
     * @return result
     * @throws Exception e
     */
    @GetMapping("/audit/{articleId}")
    @ResponseBody
    public AuditInitResult getAuditArticleInfo(@PathVariable("articleId") String articleId) throws Exception {
        AuditInitResult result = new AuditInitResult();
        ArticleEntity articleEntity = articleService.getArticleById(articleId);
        if (articleEntity == null) {
            throw new ApplicationException(getMessage("article.null"));
        }
        // 校验状态
        if (!ArticleStatus.UNDER_REVIEW.getCode().equals(articleEntity.getArticleStatus())
                && !ArticleStatus.REVIEW_PASSED.getCode().equals(articleEntity.getArticleStatus())
                && !ArticleStatus.REVIEW_NOT_PASSED.getCode().equals(articleEntity.getArticleStatus())) {
            throw new ApplicationException(getMessage("audit.status.error"));
        }
        result.setBizId(articleEntity.getArticleId());
        result.setBizType(BizType.ARTICLE.getCode());
        result.setStatus(articleEntity.getArticleStatus());
        result.setStatusName(DictionaryCache.getName(articleEntity.getArticleStatus()));
        result.setCategory(articleService.getAllArticleCategory());
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 审核文章
     *
     * @param articleId 文章id
     * @param form      form
     * @return result
     */
    @PostMapping("/audit/{articleId}")
    @ResponseBody
    public AsynchronousResult auditArticle(@PathVariable("articleId") String articleId, AuditForm form) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        articleService.auditArticle(articleId, form);
        result.setResult(Constant.SUCCESS);
        return result;
    }

}
