package com.personalWebsite.service;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.dao.ArticleRepository;
import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.model.request.article.SaveOrUpdateForm;
import com.personalWebsite.utils.IdUtil;
import com.personalWebsite.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 文章Service 服务类.
 * Created by xiatianlong on 2018/1/22.
 */
@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 创建文章
     *
     * @param form form
     */
    @Transactional
    @Override
    public void saveArticle(SaveOrUpdateForm form) {
        ArticleEntity articleEntity = new ArticleEntity();

        UserInfo userInfo = getLoinUser();
        Date now = new Date();
        // 文章id
        articleEntity.setArticleId(IdUtil.createId(userInfo.getUserId()));
        // 文章标题
        articleEntity.setArticleTitle(form.getArticleTitle());
        // 文章摘要
        articleEntity.setArticleIntroduction(form.getArticleIntroduction());
        // 文章封面图片编号
        if (!StringUtils.isEmpty(form.getArticleImgNo())) {
            articleEntity.setArticleImg(form.getArticleImgNo());
        }
        // 文章状态
        articleEntity.setArticleStatus(form.getArticleStatus());
        // 文章内容
        articleEntity.setArticleContent(form.getArticleContent());
        // 访问量
        articleEntity.setArticleViewsCnt(0);
        // 是否删除
        articleEntity.setDelete(false);
        // 作者id
        articleEntity.setUserId(userInfo.getUserId());

        articleEntity.setCreateTime(now);
        articleEntity.setUpdateTime(now);
        articleEntity.setCreateUser(userInfo.getUserId());
        articleEntity.setUpdateUser(userInfo.getUserId());

        articleRepository.save(articleEntity);
    }

    /**
     * 更新文章
     *
     * @param form          form
     * @param articleEntity 文章对象
     */
    @Transactional
    @Override
    public void updateArticle(SaveOrUpdateForm form, ArticleEntity articleEntity) {

        // 文章标题
        articleEntity.setArticleTitle(form.getArticleTitle());
        // 文章摘要
        articleEntity.setArticleIntroduction(form.getArticleIntroduction());
        // 文章封面图片
        articleEntity.setArticleImg(form.getArticleImgNo());
        // 文章状态
        articleEntity.setArticleStatus(form.getArticleStatus());
        // 文章内容
        articleEntity.setArticleContent(form.getArticleContent());

        articleEntity.setUpdateTime(new Date());
        articleEntity.setUpdateUser(getLoinUser().getUserId());

        articleRepository.saveAndFlush(articleEntity);
    }

    /**
     * 删除文章对象
     *
     * @param articleEntity 文章对象
     */
    @Override
    public void removeArticle(ArticleEntity articleEntity) throws Exception {
        if (articleEntity != null) {
            articleEntity.setArticleStatus(ArticleStatus.DELETE.getCode());
            articleEntity.setUpdateTime(new Date());
            articleEntity.setUpdateUser(getLoinUser().getUserId());
            articleRepository.saveAndFlush(articleEntity);
        } else {
            throw new ApplicationException(getMessage("article.null"));
        }
    }


    /**
     * 根据id获取文章
     *
     * @param articleId 文章id
     * @return 文章
     */
    @Override
    public ArticleEntity getArticleById(String articleId) throws Exception {
        if (StringUtils.isEmpty(articleId)) {
            return null;
        }
        return articleRepository.findByArticleId(articleId);
    }
}
