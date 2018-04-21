package com.personalWebsite.xiaochengxu.model;

import com.personalWebsite.model.response.AsynchronousResult;

import java.util.List;

/**
 * 评论返回结果
 * Created by xiatianlong on 2018/4/16.
 */
public class XcxCommentListResult extends AsynchronousResult {
    private static final long serialVersionUID = -6304780759248738468L;

    /**
     * 留言卡片集合信息
     */
    private List<XcxCommentInfo> infos;

    /***
     * 是否还有更多
     */
    private boolean hasMore;


    /**
     * 获取 留言卡片集合信息
     */
    public List<XcxCommentInfo> getInfos() {
        return this.infos;
    }

    /**
     * 设置 留言卡片集合信息
     */
    public void setInfos(List<XcxCommentInfo> infos) {
        this.infos = infos;
    }

    /***
     * 是否还有更多
     */
    public boolean isHasMore() {
        return this.hasMore;
    }

    /***
     * 是否还有更多
     */
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
