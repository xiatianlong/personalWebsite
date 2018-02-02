package com.personalWebsite.dao;

import com.personalWebsite.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 文章 Repository
 * Created by xiatianlong on 2018/01/22.
 */
public interface ArticleRepository extends JpaRepository<ArticleEntity, String>, JpaSpecificationExecutor<ArticleEntity> {

    /**
     * 根据id查询文章
     *
     * @param articleId 文章id
     * @return 文章
     */
    @Query(value = "SELECT * FROM t_article article WHERE article.ARTICLE_ID = ?1 AND article.IS_DELETE = 0", nativeQuery = true)
    ArticleEntity findByArticleId(String articleId);

}
