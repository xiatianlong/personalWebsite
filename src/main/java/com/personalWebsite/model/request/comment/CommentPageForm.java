package com.personalWebsite.model.request.comment;

import com.personalWebsite.model.request.PageForm;

/**
 * 留言分页表单
 * Created by xiatianlong on 2018/3/17.
 */
public class CommentPageForm extends PageForm {

    /**
     * 留言业务类型
     */
    private String commentBizType;


    /**
     * 获取 留言业务类型
     */
    public String getCommentBizType() {
        return this.commentBizType;
    }

    /**
     * 设置 留言业务类型
     */
    public void setCommentBizType(String commentBizType) {
        this.commentBizType = commentBizType;
    }
}
