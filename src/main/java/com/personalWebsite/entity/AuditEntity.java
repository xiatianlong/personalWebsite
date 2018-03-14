package com.personalWebsite.entity;

import javax.persistence.*;

/**
 * 审核表
 * Created by xiatianlong on 2018/3/7.
 */
@Entity(name = "t_audit")
public class AuditEntity extends BaseEntity {

    /**
     * 物理主键
     */
    private int id;
    /**
     * 业务id
     */
    private String bizId;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 审核内容
     */
    private String auditContent;

    /**
     * 审核备注
     */
    private String auditMemo;

    /**
     * 获取 物理主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 11)
    public int getId() {
        return this.id;
    }

    /**
     * 设置 物理主键
     */
    public void setId(int id) {
        this.id = id;
    }

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

    /**
     * 获取 审核内容
     */
    @Column(name = "AUDIT_CONTENT", length = 100)
    public String getAuditContent() {
        return this.auditContent;
    }

    /**
     * 设置 审核内容
     */
    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    /**
     * 获取 审核备注
     */
    @Column(name = "AUDIT_MEMO", nullable = false, length = 200)
    public String getAuditMemo() {
        return this.auditMemo;
    }

    /**
     * 设置 审核备注
     */
    public void setAuditMemo(String auditMemo) {
        this.auditMemo = auditMemo;
    }

}
