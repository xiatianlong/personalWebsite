package com.personalWebsite.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

/**
 * 审核ID
 * Created by xiatianlong on 2018/3/7.
 */
public class AuditId implements Serializable {
    private static final long serialVersionUID = 5655453368234769488L;

    /**
     * 业务id
     */
    private String bizId;

    /**
     * 业务类型
     */
    private String bizType;


    /**
     * 获取 业务id
     */
    @Column(name = "BIZ_ID", nullable = false, length = 50)
    public String getBizId() {
        return this.bizId;
    }

    /**
     * 设置 业务id
     */
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取 业务类型
     */
    @Column(name = "BIZ_TYPE", nullable = false, length = 50)
    public String getBizType() {
        return this.bizType;
    }

    /**
     * 设置 业务类型
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditId auditId = (AuditId) o;
        return Objects.equals(bizId, auditId.bizId) &&
                Objects.equals(bizType, auditId.bizType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizId, bizType);
    }
}
