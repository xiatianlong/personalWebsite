package com.personalWebsite.model.request.article;

import com.personalWebsite.model.request.PageForm;

/**
 * 文章分页表单
 * Created by xiatianlong on 2018/1/31.
 */
public class ArticlePageForm extends PageForm {

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 文章状态
     */
    private String[] articleStatus;

    /**
     * 文章类别
     */
    private String[] articleCategory;

    /**
     * 获取 文章id
     */
    public String getArticleId() {
        return this.articleId;
    }

    /**
     * 设置 文章id
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }


    /**
     * 获取 文章状态
     */
    public String[] getArticleStatus() {
        return this.articleStatus;
    }

    /**
     * 设置 文章状态
     */
    public void setArticleStatus(String[] articleStatus) {
        this.articleStatus = articleStatus;
    }


    /**
     * 获取 文章类别
     */
    public String[] getArticleCategory() {
        return this.articleCategory;
    }

    /**
     * 设置 文章类别
     */
    public void setArticleCategory(String[] articleCategory) {
        this.articleCategory = articleCategory;
    }
}
