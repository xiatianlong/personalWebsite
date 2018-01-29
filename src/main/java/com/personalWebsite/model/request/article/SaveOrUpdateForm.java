package com.personalWebsite.model.request.article;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 创建或更新文章表单
 * Created by xiatianlong on 2018/1/22.
 */
public class SaveOrUpdateForm implements Serializable {
    private static final long serialVersionUID = 7126528506860332982L;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 文章状态
     */
    private String articleStatus;

    /**
     * 文章标题
     */
    @NotNull(message = "article.title.notnull")
    @Length(max = 100, message = "article.title.length")
    private String articleTitle;

    /**
     * 文章封面图片编号
     */
    private String articleImgNo;

    /**
     * 文章摘要
     */
    @Length(max = 200, message = "article.introduction.length")
    private String articleIntroduction;

    /**
     * 文章内容
     */
    private String articleContent;


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
    public String getArticleStatus() {
        return this.articleStatus;
    }

    /**
     * 设置 文章状态
     */
    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    /**
     * 获取 文章标题
     */
    public String getArticleTitle() {
        return this.articleTitle;
    }

    /**
     * 设置 文章标题
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * 获取 文章封面图片编号
     */
    public String getArticleImgNo() {
        return this.articleImgNo;
    }

    /**
     * 设置 文章封面图片编号
     */
    public void setArticleImgNo(String articleImgNo) {
        this.articleImgNo = articleImgNo;
    }

    /**
     * 获取 文章摘要
     */
    public String getArticleIntroduction() {
        return this.articleIntroduction;
    }

    /**
     * 设置 文章摘要
     */
    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction;
    }

    /**
     * 获取 文章内容
     */
    public String getArticleContent() {
        return this.articleContent;
    }

    /**
     * 设置 文章内容
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}
