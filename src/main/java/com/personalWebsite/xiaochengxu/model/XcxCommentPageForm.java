package com.personalWebsite.xiaochengxu.model;

import com.personalWebsite.model.request.PageForm;

/**
 * 小程序留言分页form
 * Created by xiatianlong on 2018/4/17.
 */
public class XcxCommentPageForm extends PageForm {
    private static final long serialVersionUID = 4702893221138705064L;

    /**
     * 留言id
     */
    private String commentId;

    /**
     * 获取 留言id
     */
    public String getCommentId() {
        return this.commentId;
    }

    /**
     * 设置 留言id
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
