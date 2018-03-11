package com.personalWebsite.dao;

import com.personalWebsite.entity.NoteCategoryEntity;
import com.personalWebsite.entity.id.NoteCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 笔记分类 Repository
 * Created by xiatianlong on 2018/01/22.
 */
public interface NoteCategoryRepository extends JpaRepository<NoteCategoryEntity, NoteCategoryId>, JpaSpecificationExecutor<NoteCategoryEntity> {


}
