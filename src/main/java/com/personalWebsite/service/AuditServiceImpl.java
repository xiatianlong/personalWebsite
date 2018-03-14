package com.personalWebsite.service;

import com.personalWebsite.dao.AuditRepository;
import com.personalWebsite.entity.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 审核Service.
 * Created by xiatianlong on 2018/3/11.
 */
@Service
@Transactional(readOnly = true)
public class AuditServiceImpl extends BaseServiceImpl implements AuditService {

    @Autowired
    private AuditRepository auditRepository;

    /**
     * 审核
     *
     * @param bizId   业务ID
     * @param bizType 业务类型
     * @return 审核
     */
    @Override
    public AuditEntity getLastAudit(final String bizId, final String bizType) {

        if (StringUtils.isEmpty(bizId) || StringUtils.isEmpty(bizType)) {
            return null;
        }

        return auditRepository.getLastAudit(bizId, bizType);
    }
}
