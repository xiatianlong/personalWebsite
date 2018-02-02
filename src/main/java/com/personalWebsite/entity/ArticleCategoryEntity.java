package com.personalWebsite.entity;

import com.personalWebsite.entity.id.ArticleCategoryId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * 文章分类表实体
 * Created by xiatianlong on 2018/1/31.
 */
@Entity(name = "t_article_category")
@IdClass(ArticleCategoryId.class)
public class ArticleCategoryEntity extends BaseEntity {
    private static final long serialVersionUID = -827080340719607742L;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 文章分类
     */
    private String articleCategory;


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
     * 获取 文章分类
     */
    @Id
    @Column(name = "ARTICLE_CATEGORY", nullable = false, length = 30)
    public String getArticleCategory() {
        return this.articleCategory;
    }

    /**
     * 设置 文章分类
     */
    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }
}
