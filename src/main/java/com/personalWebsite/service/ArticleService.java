package com.personalWebsite.service;

import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.model.request.article.ArticlePageForm;
import com.personalWebsite.model.request.article.SaveOrUpdateForm;
import com.personalWebsite.model.response.article.ArticleCard;
import com.personalWebsite.model.response.article.ArticleInfo;

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

    /**
     * 获取可查看的文章列表
     *
     * @param articlePageForm form
     * @return 文章列表
     */
    List<ArticleCard> getViewArticleList(ArticlePageForm articlePageForm);

    /**
     * 获取最新文章列表
     *
     * @return 文章列表
     */
    List<ArticleCard> getNewArticleList();

    /**
     * 获取最热文章列表
     *
     * @return 文章列表
     */
    List<ArticleCard> getHotArticleList();

    /**
     * 获取文章类别
     *
     * @return 类别集合
     */
    List<String> getArticleCategory();

    /**
     * 获取可见的文章类别
     *
     * @return 类别集合
     */
    List<String> getViewArticleCategory();

    /**
     * 构建文章信息
     *
     * @param articleEntity 文章实体对象
     * @return info
     */
    ArticleInfo buildArticleInfo(ArticleEntity articleEntity);

    /**
     * 增加文章访问量
     *
     * @param articleId 文章id
     */
    void addArticleViewCnt(String articleId) throws Exception;

    /**
     * 获取审核通过文章数量
     *
     * @return int
     */
    int getReviewPassedArticleCnt();

}
