package com.personalWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评论表
 * Created by xiatianlong on 2018/1/8.
 */
@Table(name = "t_comment")
public class CommentEntity extends BaseEntity {

    /**
     * 评论ID
     */
    private String commentId;

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
    private String commonBizType;


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
     * 获取 评论父ID
     */
    @Column(name = "COMMENT_PARENT_ID", length = 50)
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
    @Column(name = "COMMENT_ROOT_ID", nullable = false, length = 50)
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
    @Column(name = "COMMENT_USER_ID", nullable = false, length = 50)
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
    @Column(name = "COMMENT_PARENT_USER_ID", nullable = false, length = 50)
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
     * 获取 评论业务ID
     */
    @Column(name = "COMMENT_BIZ_ID", length = 50)
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
    @Column(name = "COMMENT_BIZ_TYPE", nullable = false, length = 10)
    public String getCommonBizType() {
        return this.commonBizType;
    }

    /**
     * 设置 评论业务类型（004）
     */
    public void setCommonBizType(String commonBizType) {
        this.commonBizType = commonBizType;
    }
}
