package com.personalWebsite.common.enums;

/**
 * 文章状态
 * Created by xiatianlong on 2017/1/8.
 */
public enum ArticleStatus {

    /**
     * 草稿
     */
    DRAFT("002001"),

    /**
     * 审核中
     */
    UNDER_REVIEW("002002"),

    /**
     * 审核通过
     */
    REVIEW_PASSED("002003"),

    /**
     * 审核不通过
     */
    REVIEW_NOT_PASSED("002004"),

    /**
     * 删除
     */
    DELETE("002005");

    private String code;

    ArticleStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean equals(String typeCode) {
        return this.code.equals(typeCode);
    }


}
