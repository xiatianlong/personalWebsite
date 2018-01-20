package com.personalWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 文章表实体
 * Created by xiatianlong on 2018/1/20.
 */
@Entity(name = "t_article")
public class ArticleEntity extends BaseEntity {
    private static final long serialVersionUID = -5225705056545847771L;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章摘要
     */
    private String articleIntroduction;

    /**
     * 文章封面图片
     */
    private String articleImg;

    /**
     * 文章状态
     */
    private String articleStatus;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章访问量
     */
    private int articleViewsCnt;

    /**
     * 是否删除
     */
    private boolean delete;

    /**
     * 文章作者id
     */
    private String userId;


    /**
     * 获取 文章id
     */
    @Id
    @Column(name = "ARTICLE_ID", nullable = false, length = 50)
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
     * 获取 文章标题
     */
    @Column(name = "ARTICLE_TITLE", nullable = false, length = 100)
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
     * 获取 文章摘要
     */
    @Column(name = "ARTICLE_INTRODUCTION", length = 300)
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
     * 获取 文章封面图片
     */
    @Column(name = "ARTICLE_IMG", length = 50)
    public String getArticleImg() {
        return this.articleImg;
    }

    /**
     * 设置 文章封面图片
     */
    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }

    /**
     * 获取 文章状态
     */
    @Column(name = "ARTICLE_STATUS", nullable = false, length = 10)
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
     * 获取 文章内容
     */
    @Column(name = "ARTICLE_CONTENT")
    public String getArticleContent() {
        return this.articleContent;
    }

    /**
     * 设置 文章内容
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    /**
     * 获取 文章访问量
     */
    @Column(name = "ARTICLE_VIEWS_CNT", nullable = false)
    public int getArticleViewsCnt() {
        return this.articleViewsCnt;
    }

    /**
     * 设置 文章访问量
     */
    public void setArticleViewsCnt(int articleViewsCnt) {
        this.articleViewsCnt = articleViewsCnt;
    }

    /**
     * 获取 是否删除
     */
    @Column(name = "IS_DELETE", nullable = false)
    public boolean isDelete() {
        return this.delete;
    }

    /**
     * 设置 是否删除
     */
    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    /**
     * 获取 文章作者id
     */
    @Column(name = "USER_ID", nullable = false)
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 文章作者id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
