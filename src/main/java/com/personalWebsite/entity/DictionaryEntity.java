package com.personalWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 字典表
 * Created by xiatianlong on 2018/1/6.
 */
@Entity(name = "t_dictionary")
public class DictionaryEntity {

    /**
     * 物理主键
     */
    private int id;

    /**
     * 字典代码
     */
    private String dicCode;

    /**
     * 字典名称
     */
    private String dicName;

    /**
     * 父字典代码
     */
    private String dicParentCode;

    /**
     * 获取 物理主键
     */
    @Id
    @Column(name = "ID")
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
     * 获取 字典代码
     */
    @Column(name = "DIC_CODE", nullable = false, length = 15)
    public String getDicCode() {
        return this.dicCode;
    }

    /**
     * 设置 字典代码
     */
    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    /**
     * 获取 字典名称
     */
    @Column(name = "DIC_NAME", nullable = false, length = 20)
    public String getDicName() {
        return this.dicName;
    }

    /**
     * 设置 字典名称
     */
    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    /**
     * 获取 父字典代码
     */
    @Column(name = "DIC_PARENT_CODE", length = 15)
    public String getDicParentCode() {
        return this.dicParentCode;
    }

    /**
     * 设置 父字典代码
     */
    public void setDicParentCode(String dicParentCode) {
        this.dicParentCode = dicParentCode;
    }

}
