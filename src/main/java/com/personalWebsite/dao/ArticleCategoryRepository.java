package com.personalWebsite.dao;

import com.personalWebsite.entity.ArticleCategoryEntity;
import com.personalWebsite.entity.id.ArticleCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 文章分类 Repository
 * Created by xiatianlong on 2018/01/22.
 */
public interface ArticleCategoryRepository extends JpaRepository<ArticleCategoryEntity, ArticleCategoryId>, JpaSpecificationExecutor<ArticleCategoryEntity> {


}
