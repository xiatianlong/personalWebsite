package com.personalWebsite.vo;

import java.io.Serializable;

/**
 * 评论信息封装结果
 * Created by xiatianlong on 2018/1/10.
 */
public class CommentInfo implements Serializable {
    private static final long serialVersionUID = 5020691353688489630L;

    /**
     * 评论ID
     */
    private String commentId;


    /**
     * 评论用户ID
     */
    private String commentUserId;

    /**
     * 评论用户名称
     */
    private String commentUserName;

    /**
     * 评论用户头像
     */
    private String commentUserHeadImg;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时间
     */
    private String commentFmtTime;


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
     * 获取 评论用户ID
     */
    public String getCommentUserId() {
        return this.commentUserId;
    }

    /**
     * 设置 评论用户ID
     */
    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    /**
     * 获取 评论用户名称
     */
    public String getCommentUserName() {
        return this.commentUserName;
    }

    /**
     * 设置 评论用户名称
     */
    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    /**
     * 获取 评论时间
     */
    public String getCommentFmtTime() {
        return this.commentFmtTime;
    }

    /**
     * 设置 评论时间
     */
    public void setCommentFmtTime(String commentFmtTime) {
        this.commentFmtTime = commentFmtTime;
    }


    /**
     * 获取  评论用户头像
     */
    public String getCommentUserHeadImg() {
        return this.commentUserHeadImg;
    }

    /**
     * 设置  评论用户头像
     */
    public void setCommentUserHeadImg(String commentUserHeadImg) {
        this.commentUserHeadImg = commentUserHeadImg;
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
}
