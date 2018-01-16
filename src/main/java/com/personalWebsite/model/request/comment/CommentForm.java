package com.personalWebsite.model.request.comment;

import java.io.Serializable;

/**
 * 评论请求form
 * Created by xiatianlong on 2018/1/8.
 */
public class CommentForm implements Serializable {
    private static final long serialVersionUID = -4046141558482841576L;


    /**
     * 评论父ID
     */
    private String commentParentId;

    /**
     * 评论根ID
     */
    private String commentRootId;

    /**
     * 评论用户ID
     */
    private String commentUserId;

    /**
     * 父评论的用户ID
     */
    private String commentParentUserId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论业务ID
     */
    private String commentBizId;

    /**
     * 评论业务类型（004）
     */
    private String commentBizType;


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
     * 获取 评论根ID
     */
    public String getCommentRootId() {
        return this.commentRootId;
    }

    /**
     * 设置 评论根ID
     */
    public void setCommentRootId(String commentRootId) {
        this.commentRootId = commentRootId;
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
     * 获取 评论业务ID
     */
    public String getCommentBizId() {
        return this.commentBizId;
    }

    /**
     * 设置 评论业务ID
     */
    public void setCommentBizId(String commentBizId) {
        this.commentBizId = commentBizId;
    }


    /**
     * 获取 评论业务类型（004）
     */
    public String getCommentBizType() {
        return this.commentBizType;
    }

    /**
     * 设置 评论业务类型（004）
     */
    public void setCommentBizType(String commentBizType) {
        this.commentBizType = commentBizType;
    }
}
