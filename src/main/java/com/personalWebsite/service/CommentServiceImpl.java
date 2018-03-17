package com.personalWebsite.service;

import com.personalWebsite.common.enums.CommentBizType;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.dao.CommentRepository;
import com.personalWebsite.entity.CommentEntity;
import com.personalWebsite.model.request.comment.CommentPageForm;
import com.personalWebsite.model.request.comment.MessageForm;
import com.personalWebsite.utils.DateUtil;
import com.personalWebsite.utils.IdUtil;
import com.personalWebsite.vo.CommentInfo;
import com.personalWebsite.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论服务类.
 * Created by xiatianlong on 2018/1/8.
 */
@Service
@Transactional(readOnly = true)
public class CommentServiceImpl extends BaseServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 保存评论
     *
     * @param form form
     */
    @Transactional
    @Override
    public CommentEntity saveComment(MessageForm form) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentId(IdUtil.createId(getLoinUser().getUserId()));
        // 评论业务ID
        if (form.getCommentBizType().equals(CommentBizType.MESSAGE.getCode())) {
            commentEntity.setCommentBizId(Constant.MESSAGE_BIZ_ID);
        } else {
            commentEntity.setCommentBizId(form.getCommentBizId());
        }
        // 评论人ID
        commentEntity.setCommentUserId(getLoinUser().getUserId());
        // 评论内容
        commentEntity.setCommentContent(form.getCommentContent());
        // 评论业务类型
        commentEntity.setCommonBizType(form.getCommentBizType());

        commentEntity.setCreateUser(getLoinUser().getUserId());
        commentEntity.setUpdateUser(getLoinUser().getUserId());
        Date now = new Date();
        commentEntity.setCreateTime(now);
        commentEntity.setUpdateTime(now);

        return commentRepository.save(commentEntity);
    }

    /**
     * 分页检索留言
     *
     * @param form 请求form
     * @return 分页结果
     */
    @SuppressWarnings("unchecked")
    @Override
    public PageVO<CommentEntity> getCommentListByPage(final CommentPageForm form) {

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "commentId");

        Pageable pageable = new PageRequest(form.getPageNo() - 1, form.getPageSize(), new Sort(order));

        Specification<CommentEntity> specification = new Specification<CommentEntity>() {
            @Override
            public Predicate toPredicate(Root<CommentEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();

                predicateList.add(cb.equal(root.get("commonBizType"), form.getCommentBizType()));

                Predicate[] pre = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(pre));
            }
        };

        return new PageVO(commentRepository.findAll(specification, pageable));
    }

    /**
     * 封装评论信息
     *
     * @return 评论信息
     */
    @Override
    public List<CommentInfo> getCommentInfo(List<CommentEntity> commentEntityList) {
        if (commentEntityList != null && !commentEntityList.isEmpty()) {
            // 一级评论
            List<CommentInfo> commentInfos = new ArrayList<>();
            for (CommentEntity commentEntity : commentEntityList) {
                commentInfos.add(getCommentInfo(commentEntity));
            }
            return commentInfos;
        }
        return null;
    }

    /**
     * 封装评论信息
     *
     * @return 评论信息
     */
    @Override
    public CommentInfo getCommentInfo(CommentEntity commentEntity) {

        if (commentEntity == null) {
            return null;
        }

        CommentInfo commentInfo = new CommentInfo();
        // 评论ID
        commentInfo.setCommentId(commentEntity.getCommentId());
        // 评论用户ID
        commentInfo.setCommentUserId(commentEntity.getCommentUserId());
        // 评论用户名称
        commentInfo.setCommentUserName(commentEntity.getCommentUser().getUserName());
        // 评论用户头像
        commentInfo.setCommentUserHeadImg(commentEntity.getCommentUser().getUserHeadImg());
        // 评论内容
        commentInfo.setCommentContent(commentEntity.getCommentContent());
        // 评论时间
        commentInfo.setCommentFmtTime(DateUtil.getStrDate(commentEntity.getCreateTime()));

        return commentInfo;
    }




}
