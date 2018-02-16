package com.personalWebsite.common.enums;

/**
 * 笔记状态
 * Created by xiatianlong on 2017/1/8.
 */
public enum NoteStatus {

    /**
     * 草稿
     */
    DRAFT("003001"),

    /**
     * 审核中
     */
    UNDER_REVIEW("003002"),

    /**
     * 审核通过
     */
    REVIEW_PASSED("003003"),

    /**
     * 审核不通过
     */
    REVIEW_NOT_PASSED("003004");

    private String code;

    NoteStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean equals(String typeCode) {
        return this.code.equals(typeCode);
    }


}
