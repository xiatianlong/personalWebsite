package com.personalWebsite.model.response.comment;

import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.vo.CommentInfo;

/**
 * 留言结果返回
 * Created by xiatianlong on 2018/1/8.
 */
public class MessageResult extends AsynchronousResult {

    /**
     * 留言信息
     */
    private CommentInfo commentInfo;


    /**
     * 获取 留言信息
     */
    public CommentInfo getCommentInfo() {
        return this.commentInfo;
    }

    /**
     * 设置 留言信息
     */
    public void setCommentInfo(CommentInfo commentInfo) {
        this.commentInfo = commentInfo;
    }
}
