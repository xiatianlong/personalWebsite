package com.personalWebsite.service;

import com.personalWebsite.common.enums.ArticleStatus;
import com.personalWebsite.common.enums.BizType;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.dao.ArticleCategoryRepository;
import com.personalWebsite.dao.ArticleRepository;
import com.personalWebsite.dao.AuditRepository;
import com.personalWebsite.dao.EmailRecordRepository;
import com.personalWebsite.dictionary.DictionaryCache;
import com.personalWebsite.entity.*;
import com.personalWebsite.model.request.AuditForm;
import com.personalWebsite.model.request.article.AdminArticlePageForm;
import com.personalWebsite.model.request.article.ArticlePageForm;
import com.personalWebsite.model.request.article.SaveOrUpdateForm;
import com.personalWebsite.model.response.article.AdminArticleQueryResult;
import com.personalWebsite.model.response.article.ArticleCard;
import com.personalWebsite.model.response.article.ArticleInfo;
import com.personalWebsite.utils.DateUtil;
import com.personalWebsite.utils.IdUtil;
import com.personalWebsite.utils.PropertiesUtil;
import com.personalWebsite.utils.UUIDUtil;
import com.personalWebsite.vo.UserInfo;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * 文章Service 服务类.
 * Created by xiatianlong on 2018/1/22.
 */
@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;
    @Autowired
    private AuditRepository auditRepository;
    @Autowired
    private EmailRecordRepository emailRecordRepository;

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
    @Transactional
    public void removeArticle(ArticleEntity articleEntity) throws Exception {
        if (articleEntity != null) {
            articleEntity.setDeleted(true);
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
        Specification<ArticleEntity> specification = (root, query, cb) -> {

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
                predicateList.add(cb.lessThan(root.get("articleId"), articlePageForm.getArticleId()));
            }

            // 去重处理
            query.distinct(true);

            Predicate[] pre = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(pre));
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
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "articleId");
        Pageable pageable = new PageRequest(articlePageForm.getPageNo() - 1, articlePageForm.getPageSize(), new Sort(order));
        Specification<ArticleEntity> specification = (root, query, cb) -> {

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
                predicateList.add(cb.lessThan(root.get("articleId"), articlePageForm.getArticleId()));
            }

            // 去重处理
            query.distinct(true);

            Predicate[] pre = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(pre));
        };

        return buildArticleCard(articleRepository.findAll(specification, pageable).getContent());
    }

    /**
     * 获取全部文章列表
     *
     * @param adminArticlePageForm form
     * @return 文章列表
     */
    @Override
    public AdminArticleQueryResult getAllArticleList(final AdminArticlePageForm adminArticlePageForm) {

        AdminArticleQueryResult result = new AdminArticleQueryResult();

        // 创建时间倒序(id)
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "articleId");
        Pageable pageable = new PageRequest(adminArticlePageForm.getPageNo() - 1, adminArticlePageForm.getPageSize(), new Sort(order));
        Specification<ArticleEntity> specification = (root, query, cb) -> {

            List<Predicate> predicateList = new ArrayList<>();
            // 是否删除的
            if (adminArticlePageForm.getDeleted() != null) {
                predicateList.add(cb.equal(root.get("deleted"), adminArticlePageForm.getDeleted() == 1));
            }

            // 文章id
            if (adminArticlePageForm.getArticleId() != null) {
                predicateList.add(cb.like(root.get("articleId"), "%" + adminArticlePageForm.getArticleId() + "%"));
            }

            // 关键字（ID、title）
            if (adminArticlePageForm.getKeyword() != null) {
                predicateList.add(
                        cb.or(
                                cb.like(root.get("articleId"), "%" + adminArticlePageForm.getKeyword() + "%"),
                                cb.like(root.get("articleTitle"), "%" + adminArticlePageForm.getKeyword() + "%")
                        )
                );
            }

            // 查询条件-类别
            if (adminArticlePageForm.getArticleCategory() != null && adminArticlePageForm.getArticleCategory().length > 0) {
                Join<ArticleEntity, ArticleCategoryEntity> categoryJoin = root.join("categoryEntityList", JoinType.LEFT);
                CriteriaBuilder.In<String> in = cb.in(categoryJoin.<String>get("articleCategory"));
                for (String str : adminArticlePageForm.getArticleCategory()) {
                    in.value(str);
                }
                predicateList.add(in);
            }

            // 查询条件-状态
            if (adminArticlePageForm.getArticleStatus() != null && adminArticlePageForm.getArticleStatus().length > 0) {
                CriteriaBuilder.In<String> in = cb.in(root.<String>get("articleStatus"));
                for (String str : adminArticlePageForm.getArticleStatus()) {
                    in.value(str);
                }
                predicateList.add(in);
            }

            // 去重处理
            query.distinct(true);

            Predicate[] pre = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(pre));
        };
        Page<ArticleEntity> page = articleRepository.findAll(specification, pageable);
        List<ArticleEntity> articleEntities = page.getContent();
        if (articleEntities != null && !articleEntities.isEmpty()) {
            List<ArticleInfo> articleInfos = new ArrayList<>();
            for (ArticleEntity articleEntity : articleEntities) {
                articleInfos.add(buildArticleInfo(articleEntity));
            }
            result.setArticleInfos(articleInfos);
            result.setDataCount(page.getTotalElements());
        }
        return result;
    }

    /**
     * 获取最新文章列表
     *
     * @return 文章列表
     */
    @Override
    public List<ArticleCard> getNewArticleList() {
        // 创建时间倒序(id)
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "createTime");
        return getArticleListBase(order);
    }

    /**
     * 获取文章列表基础条件
     *
     * @param order 排序
     * @return 列表
     */
    private List<ArticleCard> getArticleListBase(Sort.Order order) {
        Pageable pageable = new PageRequest(0, 5, new Sort(order));
        Specification<ArticleEntity> specification = (root, query, cb) -> {

            List<Predicate> predicateList = new ArrayList<>();
            // 审核通过的
            predicateList.add(cb.equal(root.get("articleStatus"), ArticleStatus.REVIEW_PASSED.getCode()));
            predicateList.add(cb.equal(root.get("deleted"), false));

            Predicate[] pre = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(pre));
        };

        return buildArticleCard(articleRepository.findAll(specification, pageable).getContent());
    }

    /**
     * 获取最热文章列表
     *
     * @return 文章列表
     */
    @Override
    public List<ArticleCard> getHotArticleList() {
        // 访问量倒序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "articleViewsCnt");
        return getArticleListBase(order);
    }

    /**
     * 获取文章类别
     *
     * @return 类别集合
     */
    @Override
    public List<String> getMyArticleCategory() {
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
     * 获取全部的文章类别
     *
     * @return 类别集合
     */
    @Override
    public List<String> getAllArticleCategory() {
        return articleRepository.getAllArticleCategory();
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
        if (StringUtils.isEmpty(articleInfo.getFmtCategoryList())) {
            articleInfo.setFmtCategoryList("--");
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
     * 增加文章访问量
     *
     * @param articleId 文章id
     */
    @Transactional
    @Override
    public void addArticleViewCnt(String articleId) throws Exception {
        ArticleEntity articleEntity = getArticleById(articleId);
        if (articleEntity != null) {
            articleEntity.setArticleViewsCnt(articleEntity.getArticleViewsCnt() + 1);
            articleRepository.saveAndFlush(articleEntity);
        }
    }

    /**
     * 文章审核
     *
     * @param articleId 文章id
     * @param form      请求表单
     * @throws Exception e
     */
    @Transactional
    @Override
    public void auditArticle(String articleId, AuditForm form) throws Exception {

        // 校验状态
        if (!ArticleStatus.UNDER_REVIEW.getCode().equals(form.getStatus())
                && !ArticleStatus.REVIEW_PASSED.getCode().equals(form.getStatus())
                && !ArticleStatus.REVIEW_NOT_PASSED.getCode().equals(form.getStatus())) {
            throw new ApplicationException(getMessage("audit.status.error"));
        }
        // 检验备注
        if (StringUtils.isEmpty(form.getAuditMemo()) || form.getAuditMemo().length() > 150) {
            throw new ApplicationException(getMessage("audit.memo.length"));
        }

        ArticleEntity articleEntity = getArticleById(articleId);
        if (articleEntity == null) {
            throw new ApplicationException(getMessage("article.not.exist"));
        }
        // 检验分类
        if (form.getCategory() == null || form.getCategory().length <= 0 || form.getCategory().length > 5) {
            throw new ApplicationException(getMessage("audit.category.null"));
        }

        List<ArticleCategoryEntity> categoryEntities = articleEntity.getCategoryEntityList();
        // 删除原分类
        if (categoryEntities != null && !categoryEntities.isEmpty()) {
            articleCategoryRepository.delete(categoryEntities);
        }

        Date now = new Date();

        // 如果文章原状态是审核中，则向作者发送已提醒审核
        if (ArticleStatus.UNDER_REVIEW.getCode().equals(articleEntity.getArticleStatus())
                && !StringUtils.isEmpty(articleEntity.getUser().getUserEmail())) {
            // 给管理员发送错误邮件
            EmailRecordEntity emailRecordEntity = new EmailRecordEntity();
            emailRecordEntity.setEmailCode(UUIDUtil.getUUID());
            emailRecordEntity.setEmailTo(articleEntity.getUser().getUserEmail());
            emailRecordEntity.setCreateTime(now);
            emailRecordEntity.setUpdateTime(now);
            emailRecordEntity.setCreateUser(getLoinUser().getUserId());
            emailRecordEntity.setUpdateUser(getLoinUser().getUserId());
            Template template = mailTemplate.getConfiguration().getTemplate("auditTemplate.ftl");
            Map<String, Object> map = new HashMap<>();
            map.put("userName", articleEntity.getUser().getUserName());
            map.put("bizType", DictionaryCache.getName(BizType.ARTICLE.getCode()));
            map.put("title", articleEntity.getArticleTitle());
            map.put("status", DictionaryCache.getName(form.getStatus()));
            map.put("url", PropertiesUtil.getProperty("domain") + "/member/article/" + articleEntity.getArticleId());
            map.put("time", DateUtil.defaultFormat(now));


            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
            emailRecordEntity.setEmailContent(content);
            emailRecordRepository.save(emailRecordEntity);
        }

        // 添加审核记录
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setBizId(articleId);
        auditEntity.setBizType(BizType.ARTICLE.getCode());
        auditEntity.setAuditMemo(form.getAuditMemo());
        auditEntity.setAuditContent(getMessage("audit.status.change",
                new Object[]{DictionaryCache.getName(articleEntity.getArticleStatus()),
                        DictionaryCache.getName(form.getStatus())}));
        auditEntity.setCreateTime(now);
        auditEntity.setUpdateTime(now);
        auditEntity.setCreateUser(getLoinUser().getUserId());
        auditEntity.setUpdateUser(getLoinUser().getUserId());
        auditRepository.save(auditEntity);

        // 更新文章状态
        articleEntity.setArticleStatus(form.getStatus());
        articleEntity.setUpdateTime(now);
        articleEntity.setUpdateUser(getLoinUser().getUserId());
        articleRepository.saveAndFlush(articleEntity);

        // 添加新分类
        Set<String> categorys = new HashSet<>(Arrays.asList(form.getCategory()));
        for (String str : categorys) {
            ArticleCategoryEntity articleCategoryEntity = new ArticleCategoryEntity();
            articleCategoryEntity.setArticleId(articleId);
            articleCategoryEntity.setArticleCategory(str);
            articleCategoryEntity.setCreateTime(now);
            articleCategoryEntity.setUpdateTime(now);
            articleCategoryEntity.setCreateUser(getLoinUser().getUserId());
            articleCategoryEntity.setUpdateUser(getLoinUser().getUserId());
            articleCategoryRepository.save(articleCategoryEntity);
        }
    }

    /**
     * 获取文章总数
     *
     * @return 文章总数
     */
    @Override
    public int getArticleCnt() {
        return articleRepository.getAllArticleCnt();
    }

    /**
     * 获取某个状态下的文章数量
     *
     * @param status 状态
     * @return 文章数
     */
    @Override
    public int getArticleCntByStatus(String status) {
        return articleRepository.getArticleCntByStatus(status);
    }

    /**
     * 获取用户下上线的文章
     *
     * @param userId userid
     * @return list
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ArticleCard> getOnlineArticleByUser(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        Specification<ArticleEntity> specification = (root, query, cb) -> {

            List<Predicate> predicateList = new ArrayList<>();
            // 审核通过的
            predicateList.add(cb.equal(root.get("articleStatus"), ArticleStatus.REVIEW_PASSED.getCode()));
            predicateList.add(cb.equal(root.get("deleted"), false));
            predicateList.add(cb.equal(root.get("userId"), userId));

            Predicate[] pre = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(pre));
        };

        return buildArticleCard(articleRepository.findAll(specification, new Sort(new Sort.Order(Sort.Direction.DESC, "createTime"))));
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
                // 创建者id
                articleCard.setUserId(articleEntity.getUser().getUserId());
                // 创建者名称
                articleCard.setUserName(articleEntity.getUser().getUserName());
                // 访问量
                articleCard.setArticleViewsCnt(articleEntity.getArticleViewsCnt());
                // 是否置顶
                articleCard.setTop(articleEntity.isTop());
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
                if (StringUtils.isEmpty(articleCard.getFmtCategoryList())) {
                    articleCard.setFmtCategoryList("--");
                }
                // 文章状态
                articleCard.setArticleStatus(articleEntity.getArticleStatus());
                // 文章创建时间
                articleCard.setCreateTime(articleEntity.getCreateTime());
                // 文章创建时间(格式化)
                articleCard.setFmtCreateTime(DateUtil.defaultFormat(articleEntity.getCreateTime()));
                // 文章创建时间(中文格式化)
                articleCard.setFmtCreateTimeCN(DateUtil.getStrDate(articleEntity.getCreateTime()));

                articleCards.add(articleCard);
            }
            return articleCards;
        } else {
            return null;
        }
    }

}
