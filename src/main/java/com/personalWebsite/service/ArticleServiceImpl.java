package com.personalWebsite.service;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.dao.ArticleRepository;
import com.personalWebsite.dictionary.DictionaryCache;
import com.personalWebsite.entity.ArticleCategoryEntity;
import com.personalWebsite.entity.ArticleEntity;
import com.personalWebsite.entity.FileRelationEntity;
import com.personalWebsite.model.request.article.ArticlePageForm;
import com.personalWebsite.model.request.article.SaveOrUpdateForm;
import com.personalWebsite.model.response.article.ArticleCard;
import com.personalWebsite.model.response.article.ArticleInfo;
import com.personalWebsite.utils.DateUtil;
import com.personalWebsite.utils.IdUtil;
import com.personalWebsite.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        articleEntity.setDeleted(false);
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

    /**
     * 获取我的文章列表
     *
     * @param articlePageForm form
     * @return 文章列表
     */
    @Override
    public List<ArticleCard> getMyArticleList(final ArticlePageForm articlePageForm) {

        // 创建时间倒序（id）
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "articleId");
        Pageable pageable = new PageRequest(articlePageForm.getPageNo() - 1, articlePageForm.getPageSize(), new Sort(order));
        Specification<ArticleEntity> specification = new Specification<ArticleEntity>() {
            @Override
            public Predicate toPredicate(Root<ArticleEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicateList = new ArrayList<>();

                predicateList.add(cb.equal(root.get("userId"), getLoinUser().getUserId()));
                predicateList.add(cb.equal(root.get("deleted"), false));

                // 查询条件-状态
                if (articlePageForm.getArticleStatus() != null && articlePageForm.getArticleStatus().length > 0) {
                    CriteriaBuilder.In<String> in = cb.in(root.<String>get("articleStatus"));
                    for (String str : articlePageForm.getArticleStatus()) {
                        in.value(str);
                    }
                    predicateList.add(in);
                }

                // 查询条件-类别
                if (articlePageForm.getArticleCategory() != null && articlePageForm.getArticleCategory().length > 0) {
                    Join<ArticleEntity, ArticleCategoryEntity> categoryJoin = root.join("categoryEntityList", JoinType.LEFT);
                    CriteriaBuilder.In<String> in = cb.in(categoryJoin.<String>get("articleCategory"));
                    for (String str : articlePageForm.getArticleCategory()) {
                        in.value(str);
                    }
                    predicateList.add(in);
                }

                // 排序条件
                if (!StringUtils.isEmpty(articlePageForm.getArticleId())) {
                    predicateList.add(cb.lessThan(root.<String>get("articleId"), articlePageForm.getArticleId()));
                }

                // 去重处理
                query.distinct(true);

                Predicate[] pre = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(pre));
            }
        };

        return buildArticleCard(articleRepository.findAll(specification, pageable).getContent());
    }

    /**
     * 获取可查看的文章列表
     *
     * @param articlePageForm form
     * @return 文章列表
     */
    @Override
    public List<ArticleCard> getViewArticleList(final ArticlePageForm articlePageForm) {
        // 创建时间倒序(id)
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "top");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC, "articleId");
        Pageable pageable = new PageRequest(articlePageForm.getPageNo() - 1, articlePageForm.getPageSize(), new Sort(order1, order2));
        Specification<ArticleEntity> specification = new Specification<ArticleEntity>() {
            @Override
            public Predicate toPredicate(Root<ArticleEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicateList = new ArrayList<>();
                // 审核通过的
                predicateList.add(cb.equal(root.get("articleStatus"), ArticleStatus.REVIEW_PASSED.getCode()));
                predicateList.add(cb.equal(root.get("deleted"), false));

                // 查询条件-类别
                if (articlePageForm.getArticleCategory() != null && articlePageForm.getArticleCategory().length > 0) {
                    Join<ArticleEntity, ArticleCategoryEntity> categoryJoin = root.join("categoryEntityList", JoinType.LEFT);
                    CriteriaBuilder.In<String> in = cb.in(categoryJoin.<String>get("articleCategory"));
                    for (String str : articlePageForm.getArticleCategory()) {
                        in.value(str);
                    }
                    predicateList.add(in);
                }

                // 排序条件
                if (!StringUtils.isEmpty(articlePageForm.getArticleId())) {
                    predicateList.add(cb.lessThan(root.<String>get("articleId"), articlePageForm.getArticleId()));
                }

                // 去重处理
                query.distinct(true);

                Predicate[] pre = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(pre));
            }
        };

        return buildArticleCard(articleRepository.findAll(specification, pageable).getContent());
    }

    /**
     * 获取文章类别
     *
     * @return 类别集合
     */
    @Override
    public List<String> getArticleCategory() {
        return articleRepository.getMyArticleCategory(getLoinUser().getUserId());
    }

    /**
     * 获取可见的文章类别
     *
     * @return 类别集合
     */
    @Override
    public List<String> getViewArticleCategory() {
        return articleRepository.getViewArticleCategory();
    }

    /**
     * 构建文章信息
     *
     * @param articleEntity 文章实体对象
     * @return info
     */
    @Override
    public ArticleInfo buildArticleInfo(ArticleEntity articleEntity) {
        if (articleEntity == null) {
            return null;
        }
        ArticleInfo articleInfo = new ArticleInfo();
        // 文章id
        articleInfo.setArticleId(articleEntity.getArticleId());
        // 文章标题
        articleInfo.setArticleTitle(articleEntity.getArticleTitle());
        // 文章摘要
        articleInfo.setArticleIntroduction(articleEntity.getArticleIntroduction());
        // 封面图文件编号
        articleInfo.setArticleImgFileNo(articleEntity.getArticleImg());
        // 封面图url
        FileRelationEntity fileRelationEntity = articleEntity.getArticleImgFile();
        if (fileRelationEntity != null) {
            articleInfo.setArticleImgUrl(fileRelationEntity.getFileUrl());
        }
        // 文章状态代码
        articleInfo.setArticleStatusCode(articleEntity.getArticleStatus());
        // 文章状态名称
        articleInfo.setArticleStatusName(DictionaryCache.getName(articleEntity.getArticleStatus()));
        // 文章内容
        articleInfo.setArticleContent(articleEntity.getArticleContent());
        // 是否置顶
        articleInfo.setTop(articleEntity.isTop());
        // 文章访问量
        articleInfo.setArticleViewsCnt(articleEntity.getArticleViewsCnt());
        // 文章作者id
        articleInfo.setUserId(articleEntity.getUser().getUserId());
        // 文章作者名称
        articleInfo.setUserName(articleEntity.getUser().getUserName());
        // 文章分类集合
        List<ArticleCategoryEntity> categoryEntities = articleEntity.getCategoryEntityList();
        if (categoryEntities != null && !categoryEntities.isEmpty()) {
            List<String> strArr = new ArrayList<>();
            StringBuilder fmtStr = new StringBuilder();
            for (int i = 0; i < categoryEntities.size(); i++) {
                strArr.add(categoryEntities.get(i).getArticleCategory());
                fmtStr.append(categoryEntities.get(i).getArticleCategory());
                if (categoryEntities.size() != (i + 1)) {
                    fmtStr.append(",");
                }
            }
            articleInfo.setCategoryList(strArr);
            articleInfo.setFmtCategoryList(fmtStr.toString());
        }
        // 文章创建时间
        articleInfo.setCreateTime(articleEntity.getCreateTime());
        articleInfo.setFmtCreateTime(DateUtil.defaultFormat(articleEntity.getCreateTime()));
        // 文章更新时间
        articleInfo.setUpdateTime(articleEntity.getUpdateTime());
        articleInfo.setFmtUpdateTime(DateUtil.defaultFormat(articleEntity.getUpdateTime()));

        return articleInfo;
    }

    /**
     * 构建文章卡片信息
     *
     * @param articleEntities 文章实体对象集合
     * @return 卡片集合
     */
    private List<ArticleCard> buildArticleCard(List<ArticleEntity> articleEntities) {

        if (articleEntities != null && !articleEntities.isEmpty()) {
            List<ArticleCard> articleCards = new ArrayList<>();
            for (ArticleEntity articleEntity : articleEntities) {
                ArticleCard articleCard = new ArticleCard();
                // 文章id
                articleCard.setArticleId(articleEntity.getArticleId());
                // 文章标题
                articleCard.setArticleTitle(articleEntity.getArticleTitle());
                // 文章摘要
                articleCard.setArticleIntroduction(articleEntity.getArticleIntroduction());
                // 文章封面图片
                FileRelationEntity fileRelationEntity = articleEntity.getArticleImgFile();
                if (fileRelationEntity != null) {
                    articleCard.setArticleImgUrl(fileRelationEntity.getFileUrl());
                }
                // 文章分类
                List<ArticleCategoryEntity> categoryEntities = articleEntity.getCategoryEntityList();
                if (categoryEntities != null && !categoryEntities.isEmpty()) {
                    List<String> strArr = new ArrayList<>();
                    StringBuilder fmtStr = new StringBuilder();
                    for (int i = 0; i < categoryEntities.size(); i++) {
                        strArr.add(categoryEntities.get(i).getArticleCategory());
                        fmtStr.append(categoryEntities.get(i).getArticleCategory());
                        if (categoryEntities.size() != (i + 1)) {
                            fmtStr.append(",");
                        }
                    }
                    articleCard.setCategoryList(strArr);
                    articleCard.setFmtCategoryList(fmtStr.toString());
                }
                // 文章状态
                articleCard.setArticleStatus(articleEntity.getArticleStatus());
                // 文章创建时间
                articleCard.setCreateTime(articleEntity.getCreateTime());
                // 文章创建时间(格式化)
                articleCard.setFmtCreateTime(DateUtil.defaultFormat(articleEntity.getCreateTime()));

                articleCards.add(articleCard);
            }
            return articleCards;
        } else {
            return null;
        }
    }

}
