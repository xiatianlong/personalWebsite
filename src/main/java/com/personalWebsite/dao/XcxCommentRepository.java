package com.personalWebsite.dao;

import com.personalWebsite.entity.XcxCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 小程序 Repository
 * Created by xiatianlong on 2018/04/16.
 */
public interface XcxCommentRepository extends JpaRepository<XcxCommentEntity, String>, JpaSpecificationExecutor<XcxCommentEntity> {


}
