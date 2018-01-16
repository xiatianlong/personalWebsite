package com.personalWebsite.model.response.comment;

import com.personalWebsite.model.response.AsynchronousResult;

/**
 * 留言结果返回
 * Created by xiatianlong on 2018/1/8.
 */
public class MessageResult extends AsynchronousResult {

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 评论父ID
     */
    private String commentParentId;

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
     * 父评论的用户ID
     */
    private String commentParentUserId;

    /**
     * 父评论的用户名称
     */
    private String commentParentUserName;


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
     * 获取 评论父ID
     */
    public String getCommentParentId() {
        return this.commentParentId;
    }

    /**
     * 设置 评论父ID
     */
    public void setCommentParentId(String commentParentId) {
        this.commentParentId = commentParentId;
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
     * 获取 父评论的用户ID
     */
    public String getCommentParentUserId() {
        return this.commentParentUserId;
    }

    /**
     * 设置 父评论的用户ID
     */
    public void setCommentParentUserId(String commentParentUserId) {
        this.commentParentUserId = commentParentUserId;
    }

    /**
     * 获取 父评论的用户名称
     */
    public String getCommentParentUserName() {
        return this.commentParentUserName;
    }

    /**
     * 设置 父评论的用户名称
     */
    public void setCommentParentUserName(String commentParentUserName) {
        this.commentParentUserName = commentParentUserName;
    }


    /**
     * 获取 评论用户头像
     */
    public String getCommentUserHeadImg() {
        return this.commentUserHeadImg;
    }

    /**
     * 设置 评论用户头像
     */
    public void setCommentUserHeadImg(String commentUserHeadImg) {
        this.commentUserHeadImg = commentUserHeadImg;
    }
}
