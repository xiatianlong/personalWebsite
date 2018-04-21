package com.personalWebsite.xiaochengxu.model;

import com.personalWebsite.model.response.AsynchronousResult;

/**
 * 评论返回结果
 * Created by xiatianlong on 2018/4/16.
 */
public class XcxAddCommentResult extends AsynchronousResult {
    private static final long serialVersionUID = -6304780759248738468L;

    /**
     * 留言卡片信息
     */
    private XcxCommentInfo info;


    /**
     * 获取 留言卡片信息
     */
    public XcxCommentInfo getInfo() {
        return this.info;
    }

    /**
     * 设置 留言卡片信息
     */
    public void setInfo(XcxCommentInfo info) {
        this.info = info;
    }
}
