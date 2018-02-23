package com.personalWebsite.model.response.home;

import com.personalWebsite.model.response.AsynchronousResult;

import java.util.List;

/**
 * 首页查询结果
 * Created by xiatianlong on 2018/1/31.
 */
public class HomeQueryResult extends AsynchronousResult {

    private static final long serialVersionUID = -2304348370936358793L;
    /**
     * 首页卡片集合
     */
    private List<ArticleNoteReviewPassedCard> articleNoteReviewPassedCards;

    /**
     * 是否显示加载更多
     */
    private boolean hasMore;

    /**
     * 获取 首页卡片集合
     */
    public List<ArticleNoteReviewPassedCard> getArticleNoteReviewPassedCards() {
        return this.articleNoteReviewPassedCards;
    }

    /**
     * 设置 首页卡片集合
     */
    public void setArticleNoteReviewPassedCards(List<ArticleNoteReviewPassedCard> articleNoteReviewPassedCards) {
        this.articleNoteReviewPassedCards = articleNoteReviewPassedCards;
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
