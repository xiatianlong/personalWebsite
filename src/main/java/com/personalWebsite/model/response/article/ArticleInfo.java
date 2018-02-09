package com.personalWebsite.model.response.article;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文章详细信息
 * Created by xiatianlong on 2018/2/5.
 */
public class ArticleInfo implements Serializable {
    private static final long serialVersionUID = 7388590913483731209L;

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
     * 文章封面图片文件编号
     */
    private String articleImgFileNo;

    /**
     * 文章封面图片url
     */
    private String articleImgUrl;

    /**
     * 文章状态代码
     */
    private String articleStatusCode;

    /**
     * 文章状态名称
     */
    private String articleStatusName;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章访问量
     */
    private int articleViewsCnt;

    /**
     * 文章作者id
     */
    private String userId;

    /**
     * 文章作者名称
     */
    private String userName;

    /**
     * 分类集合
     */
    private List<String> categoryList;

    /**
     * 分类集合(格式化)
     */
    private String fmtCategoryList;

    /**
     * 文章创建时间
     */
    private Date createTime;

    /**
     * 文章创建时间(格式化)
     */
    private String fmtCreateTime;

    /**
     * 文章更新时间
     */
    private Date updateTime;

    /**
     * 文章更新时间(格式化)
     */
    private String fmtUpdateTime;

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
     * 获取 文章封面图片url
     */
    public String getArticleImgUrl() {
        return this.articleImgUrl;
    }

    /**
     * 设置 文章封面图片url
     */
    public void setArticleImgUrl(String articleImgUrl) {
        this.articleImgUrl = articleImgUrl;
    }

    /**
     * 获取 文章状态代码
     */
    public String getArticleStatusCode() {
        return this.articleStatusCode;
    }

    /**
     * 设置 文章状态代码
     */
    public void setArticleStatusCode(String articleStatusCode) {
        this.articleStatusCode = articleStatusCode;
    }

    /**
     * 获取 文章状态名称
     */
    public String getArticleStatusName() {
        return this.articleStatusName;
    }

    /**
     * 设置 文章状态名称
     */
    public void setArticleStatusName(String articleStatusName) {
        this.articleStatusName = articleStatusName;
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

    /**
     * 获取 文章访问量
     */
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
     * 获取 文章作者id
     */
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
     * 获取 文章作者名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 文章作者名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 分类集合
     */
    public List<String> getCategoryList() {
        return this.categoryList;
    }

    /**
     * 设置 分类集合
     */
    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * 获取 分类集合(格式化)
     */
    public String getFmtCategoryList() {
        return this.fmtCategoryList;
    }

    /**
     * 设置 分类集合(格式化)
     */
    public void setFmtCategoryList(String fmtCategoryList) {
        this.fmtCategoryList = fmtCategoryList;
    }

    /**
     * 获取 文章创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 文章创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 文章创建时间(格式化)
     */
    public String getFmtCreateTime() {
        return this.fmtCreateTime;
    }

    /**
     * 设置 文章创建时间(格式化)
     */
    public void setFmtCreateTime(String fmtCreateTime) {
        this.fmtCreateTime = fmtCreateTime;
    }

    /**
     * 获取 文章更新时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置 文章更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 文章更新时间(格式化)
     */
    public String getFmtUpdateTime() {
        return this.fmtUpdateTime;
    }

    /**
     * 设置 文章更新时间(格式化)
     */
    public void setFmtUpdateTime(String fmtUpdateTime) {
        this.fmtUpdateTime = fmtUpdateTime;
    }


    /**
     * 获取 文章封面图片文件编号
     */
    public String getArticleImgFileNo() {
        return this.articleImgFileNo;
    }

    /**
     * 设置 文章封面图片文件编号
     */
    public void setArticleImgFileNo(String articleImgFileNo) {
        this.articleImgFileNo = articleImgFileNo;
    }

}
