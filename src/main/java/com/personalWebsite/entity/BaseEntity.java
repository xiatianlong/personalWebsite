package com.personalWebsite.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiatianlong on 2017/12/27.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -1377491114161881872L;

//    /**
//     * 物理主键
//     */
//    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;


//    /**
//     * 获取 物理主键
//     */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID", nullable = false, length = 11)
//    public Integer getId() {
//        return this.id;
//    }
//
//    /**
//     * 设置 物理主键
//     */
//    public void setId(Integer id) {
//        this.id = id;
//    }

    /**
     * 获取 创建时间
     */
    @Column(name = "CREATE_TIME", nullable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间
     */
    @Column(name = "UPDATE_TIME", nullable = false)
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 创建人
     */
    @Column(name = "CREATE_USER", nullable = false)
    public String getCreateUser() {
        return this.createUser;
    }

    /**
     * 设置 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取 更新人
     */
    @Column(name = "UPDATE_USER", nullable = false)
    public String getUpdateUser() {
        return this.updateUser;
    }

    /**
     * 设置 更新人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
