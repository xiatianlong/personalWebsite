package com.personalWebsite.service;

import com.personalWebsite.dao.ArticleNoteReviewPassedViewRepository;
import com.personalWebsite.entity.ArticleCategoryEntity;
import com.personalWebsite.entity.FileRelationEntity;
import com.personalWebsite.entity.NoteCategoryEntity;
import com.personalWebsite.entity.view.ArticleNoteReviewPassedView;
import com.personalWebsite.model.request.home.HomePageForm;
import com.personalWebsite.model.response.home.ArticleNoteReviewPassedCard;
import com.personalWebsite.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页Service.
 * Created by xiatianlong on 2018/2/23.
 */
@Service
@Transactional(readOnly = true)
public class HomeServiceImpl extends BaseServiceImpl implements HomeService {

    @Autowired
    private ArticleNoteReviewPassedViewRepository articleNoteReviewPassedViewRepository;

    /**
     * 获取首页列表
     *
     * @param homePageForm form
     * @return list
     */
    @Override
    public List<ArticleNoteReviewPassedCard> getViewList(final HomePageForm homePageForm) {
        // orderKey倒序(id)
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "orderKey");
        Pageable pageable = new PageRequest(homePageForm.getPageNo() - 1, homePageForm.getPageSize(), new Sort(order));
        Specification<ArticleNoteReviewPassedView> specification = new Specification<ArticleNoteReviewPassedView>() {
            @Override
            public Predicate toPredicate(Root<ArticleNoteReviewPassedView> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                // 排序条件
                if (!StringUtils.isEmpty(homePageForm.getOrderKey())) {
                    predicateList.add(cb.lessThan(root.<String>get("orderKey"), homePageForm.getOrderKey()));
                }

                // 关键字搜索
                if (!StringUtils.isEmpty(homePageForm.getKeyword())) {
                    predicateList.add(cb.like(root.<String>get("title"), "%" + homePageForm.getKeyword() + "%"));
                }

                // 去重处理
                query.distinct(true);
                Predicate[] pre = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(pre));
            }
        };
        return buildCard(articleNoteReviewPassedViewRepository.findAll(specification, pageable).getContent());
    }

    /**
     * 获取最新列表
     *
     * @return 列表
     */
    @Override
    public List<ArticleNoteReviewPassedCard> getNewList() {
        // 创建时间倒序(id)
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(0, 5, new Sort(order));
        return buildCard(articleNoteReviewPassedViewRepository.findAll(pageable).getContent());
    }

    /**
     * 获取最热列表
     *
     * @return 列表
     */
    @Override
    public List<ArticleNoteReviewPassedCard> getHotList() {
        // 访问量倒序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "viewsCnt");
        Pageable pageable = new PageRequest(0, 5, new Sort(order));
        return buildCard(articleNoteReviewPassedViewRepository.findAll(pageable).getContent());
    }

    /**
     * 封装卡片信息
     *
     * @param articleNoteReviewPassedViews 视图对象集合
     * @return card
     */
    private List<ArticleNoteReviewPassedCard> buildCard(List<ArticleNoteReviewPassedView> articleNoteReviewPassedViews) {
        if (articleNoteReviewPassedViews != null && !articleNoteReviewPassedViews.isEmpty()) {
            List<ArticleNoteReviewPassedCard> cards = new ArrayList<>();
            for (ArticleNoteReviewPassedView view : articleNoteReviewPassedViews) {
                ArticleNoteReviewPassedCard card = new ArticleNoteReviewPassedCard();
                // 类型
                card.setType(view.getType());
                // id
                card.setId(view.getId());
                // 标题
                card.setTitle(view.getTitle());
                // 摘要
                card.setIntroduction(view.getIntroduction());
                // 封面图片
                FileRelationEntity fileRelationEntity = view.getArticleImgFile();
                if (fileRelationEntity != null) {
                    card.setImgUrl(fileRelationEntity.getFileUrl());
                }
                // 访问数量
                card.setViewsCnt(view.getViewsCnt());
                // 分类
                if ("article".equals(view.getType())) {
                    List<ArticleCategoryEntity> categoryEntities = view.getArticleCategoryEntities();
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
                        card.setCategoryList(strArr);
                        card.setFmtCategoryList(fmtStr.toString());
                    }
                } else if ("note".equals(view.getType())) {
                    List<NoteCategoryEntity> categoryEntities = view.getNoteCategoryEntities();
                    if (categoryEntities != null && !categoryEntities.isEmpty()) {
                        List<String> strArr = new ArrayList<>();
                        StringBuilder fmtStr = new StringBuilder();
                        for (int i = 0; i < categoryEntities.size(); i++) {
                            strArr.add(categoryEntities.get(i).getNoteCategory());
                            fmtStr.append(categoryEntities.get(i).getNoteCategory());
                            if (categoryEntities.size() != (i + 1)) {
                                fmtStr.append(",");
                            }
                        }
                        card.setCategoryList(strArr);
                        card.setFmtCategoryList(fmtStr.toString());
                    }
                }
                if (StringUtils.isEmpty(card.getFmtCategoryList())) {
                    card.setFmtCategoryList("--");
                }
                // 是否置顶
                card.setTop(view.isTop());
                // 作者信息
                card.setUserId(view.getUserId());
                card.setUserName(view.getUser().getUserName());
                card.setUserHeadImg(view.getUser().getUserHeadImg());
                // 时间
                // 创建时间
                card.setCreateTime(view.getCreateTime());
                // 创建时间(格式化)
                card.setFmtCreateTime(DateUtil.defaultFormat(view.getCreateTime()));
                // 创建时间(中文格式化)
                card.setFmtCreateTimeCn(DateUtil.getStrDate(view.getCreateTime()));
                // 排序
                card.setOrderKey(view.getOrderKey());
                cards.add(card);
            }
            return cards;
        }
        return null;

    }

    ;

}
