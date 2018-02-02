package com.personalWebsite.model.response.article;

import com.personalWebsite.model.response.AsynchronousResult;

import java.util.List;

/**
 * 文章查询结果
 * Created by xiatianlong on 2018/1/31.
 */
public class ArticleQueryResult extends AsynchronousResult {
    private static final long serialVersionUID = -6773848177058011703L;

    /**
     * 文章卡片集合
     */
    private List<ArticleCard> articleCardList;

    /**
     * 是否显示加载更多
     */
    private boolean hasMore;

    /**
     * 获取 文章卡片集合
     */
    public List<ArticleCard> getArticleCardList() {
        return this.articleCardList;
    }

    /**
     * 设置 文章卡片集合
     */
    public void setArticleCardList(List<ArticleCard> articleCardList) {
        this.articleCardList = articleCardList;
    }

    /**
     * 获取 是否显示加载更多
     */
    public boolean isHasMore() {
        return this.hasMore;
    }

    /**
     * 设置 是否显示加载更多
     */
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
