package com.personalWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by xiatianlong on 2018/4/16.
 */
@Entity(name = "xcx_comment")
public class XcxCommentEntity extends BaseEntity {
    private static final long serialVersionUID = 3500555896683625091L;

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 评论用户id
     */
    private String commentUserId;

    /**
     * 评论人
     */
    private String commentName;

    /**
     * 评论内容
     */
    private String commentContent;

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
     * 获取 评论ID
     */
    @Id
    @Column(name = "COMMENT_ID", nullable = false, length = 50)
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
     * 获取 评论用户id
     */
    @Column(name = "COMMENT_USER_ID", length = 50)
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
    @Column(name = "COMMENT_CONTENT", nullable = false)
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
    @Column(name = "COMMENT_AREA", length = 100)
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
    @Column(name = "COMMENT_HEAD_IMG", length = 200)
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
    @Column(name = "COMMENT_SEX", length = 10)
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
    @Column(name = "COMMENT_NAME", length = 50)
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
