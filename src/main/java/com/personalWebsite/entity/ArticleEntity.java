package com.personalWebsite.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

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
     * 是否置顶
     */
    private boolean top;

    /**
     * 是否删除
     */
    private boolean deleted;

    /**
     * 文章作者id
     */
    private String userId;

    /**
     * 文章封面图片文件
     */
    private FileRelationEntity articleImgFile;

    /**
     * 文章所属类别
     */
    private List<ArticleCategoryEntity> categoryEntityList;

    /**
     * 文章作者信息
     */
    private UserEntity user;

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
     * 获取 是否置顶
     */
    @Column(name = "IS_TOP", nullable = false)
    public boolean isTop() {
        return this.top;
    }

    /**
     * 设置 是否置顶
     */
    public void setTop(boolean top) {
        this.top = top;
    }

    /**
     * 获取 是否删除
     */
    @Column(name = "IS_DELETE", nullable = false)
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * 设置 是否删除
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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


    /**
     * 获取 文章封面图片文件
     */
    @ManyToOne
    @JoinColumn(name = "ARTICLE_IMG", referencedColumnName = "FILE_NO", updatable = false, insertable = false)
    public FileRelationEntity getArticleImgFile() {
        return this.articleImgFile;
    }

    /**
     * 设置 文章封面图片文件
     */
    public void setArticleImgFile(FileRelationEntity articleImgFile) {
        this.articleImgFile = articleImgFile;
    }


    /**
     * 获取 文章所属类别
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ARTICLE_ID", updatable = false, insertable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    public List<ArticleCategoryEntity> getCategoryEntityList() {
        return this.categoryEntityList;
    }

    /**
     * 设置 文章所属类别
     */
    public void setCategoryEntityList(List<ArticleCategoryEntity> categoryEntityList) {
        this.categoryEntityList = categoryEntityList;
    }


    /**
     * 获取 文章作者信息
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", updatable = false, insertable = false)
    public UserEntity getUser() {
        return this.user;
    }

    /**
     * 设置 文章作者信息
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

}
