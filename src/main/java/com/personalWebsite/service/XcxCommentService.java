package com.personalWebsite.service;

import com.personalWebsite.xiaochengxu.model.XcxAddCommentResult;
import com.personalWebsite.xiaochengxu.model.XcxCommentForm;
import com.personalWebsite.xiaochengxu.model.XcxCommentListResult;
import com.personalWebsite.xiaochengxu.model.XcxCommentPageForm;

/**
 * 小程序留言service
 * Created by xiatianlong on 2018/4/16.
 */
public interface XcxCommentService extends BaseService {

    /**
     * 添加评论
     *
     * @param form form
     * @return result
     */
    XcxAddCommentResult saveComment(XcxCommentForm form);

    /**
     * 获取留言列表
     *
     * @param form form
     * @return result
     */
    XcxCommentListResult getCommentList(XcxCommentPageForm form);


}
