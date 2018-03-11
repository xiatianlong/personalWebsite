package com.personalWebsite.service;

import com.personalWebsite.entity.AuditEntity;

/**
 * 审核Service.
 * Created by xiatianlong on 2018/3/11.
 */
public interface AuditService extends BaseService {

    /**
     * 获取最新的一条审核记录
     *
     * @param bizId   业务ID
     * @param bizType 业务类型
     * @return 审核记录
     */
    AuditEntity getLastAudit(String bizId, String bizType);

}
