package com.personalWebsite.common.enums;

/**
 * 评论类型
 * Created by xiatianlong on 2017/1/8.
 */
public enum CommentBizType {

    /**
     * 评论
     */
    CODE("004"),

    /**
     * 文章
     */
    ARTICLE("004001"),

    /**
     * 笔记
     */
    NOTE("004002"),

    /**
     * 留言
     */
    MESSAGE("004003"),

    /**
     * 回复
     */
    REPLY("004004");

    private String code;

    CommentBizType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean equals(String typeCode) {
        return this.code.equals(typeCode);
    }


}
