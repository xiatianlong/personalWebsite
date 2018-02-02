package com.personalWebsite.service;

import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.model.request.article.ArticlePageForm;
import com.personalWebsite.model.request.article.SaveOrUpdateForm;
import com.personalWebsite.model.response.article.ArticleCard;

import java.util.List;

/**
 * Article Service
 * Created by xiatianlong on 2018/1/22.
 */
public interface ArticleService extends BaseService {

    /**
     * 创建文章
     *
     * @param form form
     */
    void saveArticle(SaveOrUpdateForm form);

    /**
     * 更新文章
     *
     * @param form          form
     * @param articleEntity 文章对象
     */
    void updateArticle(SaveOrUpdateForm form, ArticleEntity articleEntity);

    /**
     * 删除文章对象
     *
     * @param articleEntity 文章对象
     */
    void removeArticle(ArticleEntity articleEntity) throws Exception;

    /**
     * 根据id获取文章
     *
     * @param articleId 文章id
     * @return 文章
     */
    ArticleEntity getArticleById(String articleId) throws Exception;

    /**
     * 获取我的文章列表
     *
     * @param articlePageForm form
     * @return 文章列表
     */
    List<ArticleCard> getMyArticleList(ArticlePageForm articlePageForm);

}
