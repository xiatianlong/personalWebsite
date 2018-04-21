package com.personalWebsite.xiaochengxu.model;

import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.model.response.article.ArticleInfo;
import com.personalWebsite.model.response.note.NoteInfo;

/**
 * 小程序详情 result
 * Created by xiatianlong on 2018/4/21.
 */
public class XcxDetailResult extends AsynchronousResult {
    private static final long serialVersionUID = -7381733269489868849L;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 文章详情
     */
    private ArticleInfo articleInfo;

    /**
     * 笔记详情
     */
    private NoteInfo noteInfo;


    /**
     * 获取 业务类型
     */
    public String getBizType() {
        return this.bizType;
    }

    /**
     * 设置 业务类型
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * 获取 文章详情
     */
    public ArticleInfo getArticleInfo() {
        return this.articleInfo;
    }

    /**
     * 设置 文章详情
     */
    public void setArticleInfo(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }

    /**
     * 获取 笔记详情
     */
    public NoteInfo getNoteInfo() {
        return this.noteInfo;
    }

    /**
     * 设置 笔记详情
     */
    public void setNoteInfo(NoteInfo noteInfo) {
        this.noteInfo = noteInfo;
    }
}
