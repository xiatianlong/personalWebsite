package com.personalWebsite.controller.member;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.model.request.article.ArticlePageForm;
import com.personalWebsite.model.request.article.SaveOrUpdateForm;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.model.response.article.ArticleCard;
import com.personalWebsite.model.response.article.ArticleInfo;
import com.personalWebsite.model.response.article.ArticleQueryResult;
import com.personalWebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 会员发布的文章
 * Created by xiatianlong on 2017/12/6.
 */
@Controller
@RequestMapping("/member/article")
public class MemberArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章列表
     * @return 文章列表页
     */
    @GetMapping("/list")
    public String list(ArticlePageForm form, Model model) {

        List<ArticleCard> articleCards = articleService.getMyArticleList(form);
        // 文章集合
        model.addAttribute("myArticleList", articleCards);
        // 是否显示加载更多
        model.addAttribute("hasMore", articleCards != null && articleCards.size() >= form.getPageSize());
        // 分类集合
        model.addAttribute("articleCategoryList", articleService.getMyArticleCategory());
        return "personalCenter/article/myPublishArticleList";
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
        List<ArticleCard> articleCards = articleService.getMyArticleList(form);
        result.setArticleCardList(articleCards);
        result.setHasMore(articleCards != null && articleCards.size() >= form.getPageSize());
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 我的文章详情
     *
     * @param articleId 文章id
     * @param model     model
     * @return 文章页
     */
    @GetMapping("/{articleId}")
    public String articleDetail(@PathVariable("articleId") String articleId, Model model) throws Exception {
        model.addAttribute("article", settingArticleDetail(articleId));
        return "personalCenter/article/myArticleDetail";
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
        if (!articleEntity.getUserId().equals(getLoinUser().getUserId())) {
            throw new ApplicationException(getMessage("permissions.error"));
        }
        return articleService.buildArticleInfo(articleEntity);
    }

    /**
     * 我的文章预览
     *
     * @param articleId 文章id
     * @param model     model
     * @return 文章页
     */
    @GetMapping("/preview/{articleId}")
    public String articlePreview(@PathVariable("articleId") String articleId, Model model) throws Exception {
        model.addAttribute("article", settingArticleDetail(articleId));
        return "personalCenter/article/myArticlePreview";
    }

    /**
     * 创建文章
     *
     * @param form          from
     * @param bindingResult bindingResult
     * @return result
     */
    @PostMapping("/create")
    @ResponseBody
    public AsynchronousResult createArticle(@Valid SaveOrUpdateForm form, BindingResult bindingResult) {
        AsynchronousResult result = new AsynchronousResult();
        // 基本校验
        if (bindingResult.hasErrors()) {
            result.setMessage(getMessage(bindingResult.getAllErrors().get(0).getDefaultMessage()));
            return result;
        }
        // 二级校验
        String errorStr = validSaveOrUpdateArticle(form);
        if (!StringUtils.isEmpty(errorStr)) {
            result.setMessage(errorStr);
            return result;
        }
        // 保存文章操作
        articleService.saveArticle(form);

        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 更新文章初始化画面
     *
     * @param articleId 文章id
     * @param model     model
     * @return 更新文章初始化画面
     * @throws Exception e
     */
    @GetMapping("/update/{articleId}")
    public String updateInit(@PathVariable("articleId") String articleId, Model model) throws Exception {
        model.addAttribute("article", settingArticleDetail(articleId));
        return "personalCenter/article/updateArticle";
    }

    /**
     * 更新文章
     *
     * @param form          form
     * @param articleId     articleId
     * @param bindingResult bindingResult
     * @return result
     * @throws Exception e
     */
    @PostMapping("/update/{articleId}")
    @ResponseBody
    public AsynchronousResult updateArticle(@Valid SaveOrUpdateForm form, @PathVariable("articleId") String articleId, BindingResult bindingResult) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        ArticleEntity articleEntity = articleService.getArticleById(articleId);
        if (articleEntity == null) {
            result.setMessage(getMessage("article.null"));
            return result;
        }
        if (!articleEntity.getUserId().equals(getLoinUser().getUserId())) {
            result.setMessage(getMessage("permissions.error"));
            return result;
        }
        // 基本校验
        if (bindingResult.hasErrors()) {
            result.setMessage(getMessage(bindingResult.getAllErrors().get(0).getDefaultMessage()));
            return result;
        }
        // 二级校验
        String errorStr = validSaveOrUpdateArticle(form);
        if (!StringUtils.isEmpty(errorStr)) {
            result.setMessage(errorStr);
            return result;
        }
        // 保存文章操作
        articleService.updateArticle(form, articleEntity);

        result.setResult(Constant.SUCCESS);
        return result;
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
    public AsynchronousResult updateArticle(@PathVariable("articleId") String articleId) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        ArticleEntity articleEntity = articleService.getArticleById(articleId);
        if (articleEntity == null) {
            result.setMessage(getMessage("article.null"));
            return result;
        }
        if (!articleEntity.getUserId().equals(getLoinUser().getUserId())) {
            result.setMessage(getMessage("permissions.error"));
            return result;
        }
        // 删除文章操作
        articleService.removeArticle(articleEntity);
        result.setResult(Constant.SUCCESS);
        return result;
    }


    /**
     * 文章保存更新校验
     *
     * @param form form
     * @return 错误信息
     */
    private String validSaveOrUpdateArticle(SaveOrUpdateForm form) {
        // 装填校验
        if (!form.getArticleStatus().equals(ArticleStatus.DRAFT.getCode())
                && !form.getArticleStatus().equals(ArticleStatus.UNDER_REVIEW.getCode())) {
            return getMessage("article.status.error");
        }
        // 草稿（校验标题，）
        // bindingResult已做过基本校验

        // 提交审核（标题，摘要，内容）
        if (form.getArticleStatus().equals(ArticleStatus.UNDER_REVIEW.getCode())) {
            // bindingResult已做过标题校验
            // bindingResult已做摘要长度校验
            if (StringUtils.isEmpty(form.getArticleIntroduction())) {
                return getMessage("article.introduction.notnull");
            }
            if (StringUtils.isEmpty(form.getArticleContent())) {
                return getMessage("article.content.notnull");
            }
        }
        return null;
    }

}
