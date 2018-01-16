package com.personalWebsite.service;

import com.personalWebsite.common.enums.CommentBizType;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.dao.CommentRepository;
import com.personalWebsite.entity.CommentEntity;
import com.personalWebsite.model.request.PageForm;
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
        if (form.getCommentBizType().equals(CommentBizType.MESSAGE.getCode())) {
            commentEntity.setCommentRootId(commentEntity.getCommentId());
            commentEntity.setCommentBizId(Constant.MESSAGE_BIZ_ID);
        } else {
            commentEntity.setCommentRootId(form.getCommentRootId());
            commentEntity.setCommentBizId(form.getCommentBizId());
        }
        commentEntity.setCommentParentId(form.getCommentParentId());
        commentEntity.setCommentUserId(getLoinUser().getUserId());
        commentEntity.setCommentParentUserId(form.getCommentParentUserId());
        commentEntity.setCommentContent(form.getCommentContent());
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
    public PageVO<CommentEntity> getCommentListByPage(PageForm form) {

        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "commentId");

        Pageable pageable = new PageRequest(form.getPageNo() - 1, form.getPageSize(), new Sort(order));

        Specification<CommentEntity> specification = new Specification<CommentEntity>() {
            @Override
            public Predicate toPredicate(Root<CommentEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();

                predicateList.add(cb.equal(root.get("commonBizType"), CommentBizType.MESSAGE.getCode()));
                predicateList.add(cb.isNull(root.get("commentParentId")));

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
                CommentInfo commentInfo = new CommentInfo();
                commentInfo.setCommentId(commentEntity.getCommentId());
                commentInfo.setCommentParentId(commentEntity.getCommentParentId());
                commentInfo.setCommentUserId(commentEntity.getCommentUserId());
                commentInfo.setCommentUserName(commentEntity.getCommentUser().getUserName());
                commentInfo.setCommentUserHeadImg(commentEntity.getCommentUser().getUserHeadImg());
                commentInfo.setCommentParentUserId(commentEntity.getCommentParentUserId());
                if (commentEntity.getCommentParentUser() != null) {
                    commentInfo.setCommentParentUserName(commentEntity.getCommentParentUser().getUserName());
                    commentInfo.setCommentParentUserHeadImg(commentEntity.getCommentParentUser().getUserHeadImg());
                }
                commentInfo.setCommentContent(commentEntity.getCommentContent());
                commentInfo.setCommentFmtTime(DateUtil.getStrDate(commentEntity.getCreateTime()));

                // 二级评论
                if (commentEntity.getChildCommentList() != null && !commentEntity.getChildCommentList().isEmpty()) {
                    List<CommentInfo> tempCommentInfos = new ArrayList<>();
                    for (CommentEntity commentEntity1 : commentEntity.getChildCommentList()) {
                        CommentInfo commentInfo2 = new CommentInfo();
                        commentInfo2.setCommentId(commentEntity1.getCommentId());
                        commentInfo2.setCommentParentId(commentEntity1.getCommentParentId());
                        commentInfo2.setCommentUserId(commentEntity1.getCommentUserId());
                        commentInfo2.setCommentUserName(commentEntity1.getCommentUser().getUserName());
                        commentInfo2.setCommentUserHeadImg(commentEntity1.getCommentUser().getUserHeadImg());
                        commentInfo2.setCommentParentUserId(commentEntity1.getCommentParentUserId());
                        if (commentEntity1.getCommentParentUser() != null) {
                            commentInfo2.setCommentParentUserName(commentEntity1.getCommentParentUser().getUserName());
                            commentInfo2.setCommentParentUserHeadImg(commentEntity1.getCommentParentUser().getUserHeadImg());
                        }
                        commentInfo2.setCommentContent(commentEntity1.getCommentContent());
                        commentInfo2.setCommentFmtTime(DateUtil.getStrDate(commentEntity1.getCreateTime()));
                        tempCommentInfos.add(commentInfo2);
                    }
                    commentInfo.setCommentInfoList(tempCommentInfos);
                }

                commentInfos.add(commentInfo);
            }
            return commentInfos;
        }
        return null;
    }

}
