package com.personalWebsite.common.enums;

/**
 * 评论类型
 * Created by xiatianlong on 2017/1/8.
 */
public enum CommentType {

    /**
     * 草稿
     */
    ARTICLE("004001"),

    /**
     * 审核中
     */
    NOTE("004002"),

    /**
     * 下线
     */
    MESSAGE("004003");

    private String code;

    CommentType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean equals(String typeCode) {
        return this.code.equals(typeCode);
    }


}
