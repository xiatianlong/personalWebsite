package com.personalWebsite.model.response.article;

import com.personalWebsite.model.response.AsynchronousResult;

import java.util.List;

/**
 * 后台文章查询结果
 * Created by xiatianlong on 2018/1/31.
 */
public class AdminArticleQueryResult extends AsynchronousResult {
    private static final long serialVersionUID = -6773848177058011703L;

    /**
     * 文章卡片集合
     */
    private List<ArticleInfo> articleInfos;

    /**
     * 数据数量
     */
    private long dataCount;

    /**
     * 获取 文章卡片集合
     */
    public List<ArticleInfo> getArticleInfos() {
        return this.articleInfos;
    }

    /**
     * 设置 文章卡片集合
     */
    public void setArticleInfos(List<ArticleInfo> articleInfos) {
        this.articleInfos = articleInfos;
    }

    /**
     * 获取 数据数量
     */
    public long getDataCount() {
        return this.dataCount;
    }

    /**
     * 设置 数据数量
     */
    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }
}
