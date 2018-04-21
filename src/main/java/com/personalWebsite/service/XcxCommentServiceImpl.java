package com.personalWebsite.service;

import com.personalWebsite.common.system.Constant;
import com.personalWebsite.dao.XcxCommentRepository;
import com.personalWebsite.entity.XcxCommentEntity;
import com.personalWebsite.utils.DateUtil;
import com.personalWebsite.utils.IdUtil;
import com.personalWebsite.xiaochengxu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 小程序serviceImpl
 * Created by xiatianlong on 2018/4/16.
 */
@Service
@Transactional(readOnly = true)
public class XcxCommentServiceImpl extends BaseServiceImpl implements XcxCommentService {

    @Autowired
    private XcxCommentRepository xcxCommentRepository;

    /**
     * 添加评论
     *
     * @param form form
     * @return result
     */
    @Transactional
    @Override
    public XcxAddCommentResult saveComment(XcxCommentForm form) {
        XcxAddCommentResult result = new XcxAddCommentResult();
        // 基础校验
        if (StringUtils.isEmpty(form.getCommentContent())) {
            result.setMessage(getMessage("xcx.message.require"));
            return result;
        }
        if (form.getCommentContent().length() > 200) {
            result.setMessage(getMessage("xcx.message.maxlength", new Object[]{200}));
            return result;
        }

        Date now = new Date();
        // 持久化评论
        XcxCommentEntity comment = new XcxCommentEntity();
        comment.setCommentId(IdUtil.createId());
        comment.setCommentUserId(form.getCommentUserId());
        comment.setCommentContent(form.getCommentContent());
        comment.setCommentArea(form.getCommentArea());
        comment.setCommentHeadImg(form.getCommentHeadImg());
        comment.setCommentSex(form.getCommentSex());
        comment.setCommentName(form.getCommentName());
        comment.setCreateTime(now);
        comment.setUpdateTime(now);
        comment.setCreateUser(Constant.ADMIN);
        comment.setUpdateUser(Constant.ADMIN);
        xcxCommentRepository.save(comment);
        // 封装评论返回事件

        XcxCommentInfo info = new XcxCommentInfo();
        info.setCommentId(comment.getCommentId());
        info.setCommentContent(comment.getCommentContent());
        info.setCommentArea(comment.getCommentArea());
        info.setCommentHeadImg(comment.getCommentHeadImg());
        info.setFmtCreateTime(DateUtil.defaultFormat(now));
        info.setFmtCreateTimeCn(DateUtil.getStrDate(now));
        info.setCommentName(comment.getCommentName());
        result.setInfo(info);
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 获取留言列表
     *
     * @param form form
     * @return result
     */
    @Override
    public XcxCommentListResult getCommentList(final XcxCommentPageForm form) {

        // 创建时间倒序（id）
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "commentId");
        Pageable pageable = new PageRequest(form.getPageNo() - 1, form.getPageSize(), new Sort(order));

        Specification<XcxCommentEntity> specification = (root, query, cb) -> {

            List<Predicate> predicateList = new ArrayList<>();

            // 分页条件
            if (!StringUtils.isEmpty(form.getCommentId())) {
                predicateList.add(cb.lessThan(root.get("commentId"), form.getCommentId()));
            }

            Predicate[] pre = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(pre));
        };

        List<XcxCommentInfo> infos = buildCommentList(xcxCommentRepository.findAll(specification, pageable).getContent());

        XcxCommentListResult result = new XcxCommentListResult();
        result.setInfos(infos);
        result.setHasMore(infos != null && infos.size() >= form.getPageSize());
        result.setResult(Constant.SUCCESS);
        return result;
    }

    /**
     * 封装留言卡片数据
     *
     * @param commentEntities entitys
     * @return list
     */
    private List<XcxCommentInfo> buildCommentList(List<XcxCommentEntity> commentEntities) {
        if (commentEntities == null || commentEntities.isEmpty()) {
            return null;
        }
        List<XcxCommentInfo> commentInfos = new ArrayList<>();
        for (XcxCommentEntity commentEntity : commentEntities) {
            XcxCommentInfo info = new XcxCommentInfo();
            info.setCommentId(commentEntity.getCommentId());
            info.setCommentContent(commentEntity.getCommentContent());
            info.setCommentArea(commentEntity.getCommentArea());
            info.setCommentHeadImg(commentEntity.getCommentHeadImg());
            info.setCommentName(commentEntity.getCommentName());
            info.setFmtCreateTime(DateUtil.defaultFormat(commentEntity.getCreateTime()));
            info.setFmtCreateTimeCn(DateUtil.getStrDate(commentEntity.getCreateTime()));
            commentInfos.add(info);
        }
        return commentInfos;
    }

}
