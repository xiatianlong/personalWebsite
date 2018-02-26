package com.personalWebsite.common.enums;

/**
 * 业务类型
 * Created by xiatianlong on 2018/2/26.
 */
public enum BizType {

    /**
     * 文章
     */
    ARTICLE("001001"),

    /**
     * 笔记
     */
    NOTE("001002");

    private String code;

    BizType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean equals(String typeCode) {
        return this.code.equals(typeCode);
    }


}
