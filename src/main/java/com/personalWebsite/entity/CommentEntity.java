package com.personalWebsite.entity;

import javax.persistence.*;

/**
 * 评论表
 * Created by xiatianlong on 2018/1/8.
 */
@Entity(name = "t_comment")
public class CommentEntity extends BaseEntity {

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 评论用户ID
     */
    private String commentUserId;

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
     * 评论人对象
     */
    private UserEntity commentUser;


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


    /**
     * 获取 评论人对象
     */
    @ManyToOne()
    @JoinColumn(name = "COMMENT_USER_ID", referencedColumnName = "USER_ID", updatable = false, insertable = false)
    public UserEntity getCommentUser() {
        return this.commentUser;
    }

    /**
     * 设置 评论人对象
     */
    public void setCommentUser(UserEntity commentUser) {
        this.commentUser = commentUser;
    }


}
