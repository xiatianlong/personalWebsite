package com.personalWebsite.model.request.comment;

import java.io.Serializable;

/**
 * 评论请求form
 * Created by xiatianlong on 2018/1/8.
 */
public class CommentForm implements Serializable {
    private static final long serialVersionUID = -4046141558482841576L;


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
