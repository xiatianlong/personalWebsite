package com.personalWebsite.vo;

import java.io.Serializable;
import java.util.List;

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
     * 父评论的用户头像
     */
    private String commentParentUserHeadImg;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时间
     */
    private String commentFmtTime;

    /**
     * 子评论集合
     */
    private List<CommentInfo> commentInfoList;


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
     * 获取 子评论集合
     */
    public List<CommentInfo> getCommentInfoList() {
        return this.commentInfoList;
    }

    /**
     * 设置 子评论集合
     */
    public void setCommentInfoList(List<CommentInfo> commentInfoList) {
        this.commentInfoList = commentInfoList;
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
     * 获取 父评论的用户头像
     */
    public String getCommentParentUserHeadImg() {
        return this.commentParentUserHeadImg;
    }

    /**
     * 设置 父评论的用户头像
     */
    public void setCommentParentUserHeadImg(String commentParentUserHeadImg) {
        this.commentParentUserHeadImg = commentParentUserHeadImg;
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
