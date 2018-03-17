package com.personalWebsite.model.response.comment;

import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.vo.CommentInfo;

import java.util.List;

/**
 * 留言结果返回
 * Created by xiatianlong on 2018/1/8.
 */
public class MessagePageResult extends AsynchronousResult {

    /**
     * 留言信息列表
     */
    private List<CommentInfo> commentInfos;

    /**
     * 数据总数
     */
    private long dataCount;

    /**
     * 获取 留言信息列表
     */
    public List<CommentInfo> getCommentInfos() {
        return this.commentInfos;
    }

    /**
     * 设置 留言信息列表
     */
    public void setCommentInfos(List<CommentInfo> commentInfos) {
        this.commentInfos = commentInfos;
    }

    /**
     * 获取 数据总数
     */
    public long getDataCount() {
        return this.dataCount;
    }

    /**
     * 设置 数据总数
     */
    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }
}
