package com.personalWebsite.service;

import com.personalWebsite.model.request.home.HomePageForm;
import com.personalWebsite.model.response.home.ArticleNoteReviewPassedCard;

import java.util.List;

/**
 * 首页Service接口.
 * Created by xiatianlong on 2018/2/23.
 */
public interface HomeService extends BaseService {

    /**
     * 获取首页列表
     *
     * @param homePageForm form
     * @return list
     */
    List<ArticleNoteReviewPassedCard> getViewList(HomePageForm homePageForm);

    /**
     * 获取最新列表
     *
     * @return 列表
     */
    List<ArticleNoteReviewPassedCard> getNewList();

    /**
     * 获取最热列表
     *
     * @return 列表
     */
    List<ArticleNoteReviewPassedCard> getHotList();
}
