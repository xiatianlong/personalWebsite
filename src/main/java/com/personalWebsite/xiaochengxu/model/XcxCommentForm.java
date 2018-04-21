package com.personalWebsite.xiaochengxu.model;

import java.io.Serializable;

/**
 * Created by xiatianlong on 2018/4/16.
 */
public class XcxCommentForm implements Serializable {
    private static final long serialVersionUID = -8184992609258865538L;

    /**
     * 评论用户id
     */
    private String commentUserId;

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
     * 性别
     */
    private String commentSex;


    /**
     * 获取 评论用户id
     */
    public String getCommentUserId() {
        return this.commentUserId;
    }

    /**
     * 设置 评论用户id
     */
    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
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
     * 获取 性别
     */
    public String getCommentSex() {
        return this.commentSex;
    }

    /**
     * 设置 性别
     */
    public void setCommentSex(String commentSex) {
        this.commentSex = commentSex;
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
