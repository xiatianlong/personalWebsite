package com.personalWebsite.dao;

import com.personalWebsite.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 评论 Repository
 * Created by xiatianlong on 2018/1/5.
 */
public interface CommentRepository extends JpaRepository<CommentEntity, String>, JpaSpecificationExecutor<CommentEntity> {


}
