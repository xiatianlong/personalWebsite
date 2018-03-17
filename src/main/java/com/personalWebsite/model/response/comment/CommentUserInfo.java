package com.personalWebsite.model.response.comment;

import java.io.Serializable;

/**
 * Created by xiatianlong on 2018/3/17.
 */
public class CommentUserInfo implements Serializable {

    private static final long serialVersionUID = -7794324332642202509L;

    /**
     * 评论用户ID
     */
    private String commentUserId;

    /**
     * 评论数
     */
    private long commentCount;

    /**
     * 评论用户名称
     */
    private String userName;

    /**
     * 评论用户头像
     */
    private String userHeadImg;


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
     * 获取 评论数
     */
    public long getCommentCount() {
        return this.commentCount;
    }

    /**
     * 设置 评论数
     */
    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取 评论用户名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 评论用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 评论用户头像
     */
    public String getUserHeadImg() {
        return this.userHeadImg;
    }

    /**
     * 设置 评论用户头像
     */
    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }
}
