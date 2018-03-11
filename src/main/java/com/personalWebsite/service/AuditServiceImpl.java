package com.personalWebsite.service;

import com.personalWebsite.dao.AuditRepository;
import com.personalWebsite.entity.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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

        Specification<AuditEntity> specification = new Specification<AuditEntity>() {
            @Override
            public Predicate toPredicate(Root<AuditEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicateList = new ArrayList<>();
                // 审核通过的
                predicateList.add(cb.equal(root.get("bizId"), bizId));
                predicateList.add(cb.equal(root.get("bizType"), bizType));

                // 根据创建时间倒序
                query.orderBy(cb.asc(root.get("createTime")));

                // limit 1
                query.distinct(true);

                Predicate[] pre = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(pre));
            }
        };

        return auditRepository.findOne(specification);
    }
}
