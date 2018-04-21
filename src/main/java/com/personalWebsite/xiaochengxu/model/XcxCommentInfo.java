package com.personalWebsite.xiaochengxu.model;

import java.io.Serializable;

/**
 * 留言卡片信息
 * Created by xiatianlong on 2018/4/17.
 */
public class XcxCommentInfo implements Serializable {

    private static final long serialVersionUID = 7353673105565916342L;

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论人
     */
    private String commentName;

    /**
     * 地区
     */
    private String commentArea;

    /**
     * 头像
     */
    private String commentHeadImg;

    /**
     * 评论时间
     */
    private String fmtCreateTime;

    /**
     * 评论时间（中文）
     */
    private String fmtCreateTimeCn;


    /**
     * 获取 评论ID
     */
    public String getCommentId() {
        return this.commentId;
    }

    /**
     * 设置 评论ID
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取 评论内容
     */
    public String getCommentContent() {
        return this.commentContent;
    }

    /**
     * 设置 评论内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * 获取 地区
     */
    public String getCommentArea() {
        return this.commentArea;
    }

    /**
     * 设置 地区
     */
    public void setCommentArea(String commentArea) {
        this.commentArea = commentArea;
    }

    /**
     * 获取 头像
     */
    public String getCommentHeadImg() {
        return this.commentHeadImg;
    }

    /**
     * 设置 头像
     */
    public void setCommentHeadImg(String commentHeadImg) {
        this.commentHeadImg = commentHeadImg;
    }

    /**
     * 获取 评论时间
     */
    public String getFmtCreateTime() {
        return this.fmtCreateTime;
    }

    /**
     * 设置 评论时间
     */
    public void setFmtCreateTime(String fmtCreateTime) {
        this.fmtCreateTime = fmtCreateTime;
    }

    /**
     * 获取 评论时间（中文）
     */
    public String getFmtCreateTimeCn() {
        return this.fmtCreateTimeCn;
    }

    /**
     * 设置 评论时间（中文）
     */
    public void setFmtCreateTimeCn(String fmtCreateTimeCn) {
        this.fmtCreateTimeCn = fmtCreateTimeCn;
    }


    /**
     * 获取 评论人
     */
    public String getCommentName() {
        return this.commentName;
    }

    /**
     * 设置 评论人
     */
    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }
}
