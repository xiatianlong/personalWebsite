package com.personalWebsite.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

/**
 * 收藏表联合主键
 * Created by xiatianlong on 2018/1/31.
 */
public class CollectionId implements Serializable {

    private static final long serialVersionUID = -7543870693564117506L;

    /**
     * 业务id
     */
    private String bizId;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 用户Id
     */
    private String userId;


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
     * 获取 用户Id
     */
    @Column(name = "USER_ID", nullable = false, length = 50)
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionId that = (CollectionId) o;
        return Objects.equals(bizId, that.bizId) &&
                Objects.equals(bizType, that.bizType) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizId, bizType, userId);
    }
}
