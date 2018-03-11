package com.personalWebsite.dao;

import com.personalWebsite.entity.AuditEntity;
import com.personalWebsite.entity.id.AuditId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 审核 Repository
 * Created by xiatianlong on 2018/01/22.
 */
public interface AuditRepository extends JpaRepository<AuditEntity, AuditId>, JpaSpecificationExecutor<AuditEntity> {


    /**
     * 查询最新一条审核记录
     *
     * @param bizId   id
     * @param bizType type
     * @return audit
     */
    @Query(value = "SELECT *\n" +
            "FROM t_audit audit\n" +
            "WHERE audit.BIZ_ID = ?1 AND audit.BIZ_TYPE = ?2\n" +
            "ORDER BY audit.CREATE_TIME ASC\n" +
            "LIMIT 1;", nativeQuery = true)
    AuditEntity getLastAudit(String bizId, String bizType);
}
