package com.personalWebsite.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

/**
 * 文章分类表联合主键
 * Created by xiatianlong on 2018/1/31.
 */
public class ArticleCategoryId implements Serializable {
    private static final long serialVersionUID = 1840301695479156875L;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCategoryId that = (ArticleCategoryId) o;
        return Objects.equals(articleId, that.articleId) &&
                Objects.equals(articleCategory, that.articleCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, articleCategory);
    }
}
