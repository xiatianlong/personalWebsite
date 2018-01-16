package com.personalWebsite.service;

import com.personalWebsite.entity.CommentEntity;
import com.personalWebsite.model.request.PageForm;
import com.personalWebsite.model.request.comment.MessageForm;
import com.personalWebsite.vo.CommentInfo;
import com.personalWebsite.vo.PageVO;

import java.util.List;

/**
 * comment service.
 * Created by xiatianlong on 2018/1/8.
 */
public interface CommentService extends BaseService {

    /**
     * 保存评论
     *
     * @param form form
     */
    CommentEntity saveComment(MessageForm form);

    /**
     * 分页检索留言
     *
     * @param form 表单
     * @return 分页结果
     */
    PageVO<CommentEntity> getCommentListByPage(PageForm form);

    /**
     * 封装评论信息
     *
     * @return 评论信息
     */
    List<CommentInfo> getCommentInfo(List<CommentEntity> commentEntityList);

}
