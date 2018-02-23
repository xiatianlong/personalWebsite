package com.personalWebsite.dao;

import com.personalWebsite.entity.view.ArticleNoteReviewPassedView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 文章、笔记汇总视图 Repository.
 * Created by xiatianlong on 2018/2/23.
 */
public interface ArticleNoteReviewPassedViewRepository extends JpaRepository<ArticleNoteReviewPassedView, String>, JpaSpecificationExecutor<ArticleNoteReviewPassedView> {


}
