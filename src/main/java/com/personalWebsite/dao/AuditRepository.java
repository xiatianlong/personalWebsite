package com.personalWebsite.dao;

import com.personalWebsite.entity.AuditEntity;
import com.personalWebsite.entity.id.AuditId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 审核 Repository
 * Created by xiatianlong on 2018/01/22.
 */
public interface AuditRepository extends JpaRepository<AuditEntity, AuditId>, JpaSpecificationExecutor<AuditEntity> {


}
