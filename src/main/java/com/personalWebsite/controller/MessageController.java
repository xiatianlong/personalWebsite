package com.personalWebsite.controller;

import com.personalWebsite.common.enums.CommentBizType;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.entity.CommentEntity;
import com.personalWebsite.entity.UserEntity;
import com.personalWebsite.model.request.PageForm;
import com.personalWebsite.model.request.comment.MessageForm;
import com.personalWebsite.model.response.comment.MessageResult;
import com.personalWebsite.service.CommentService;
import com.personalWebsite.service.UserService;
import com.personalWebsite.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiatianlong on 2017/12/4.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public String list(Model model, PageForm form) {

        PageVO<CommentEntity> pageVO = commentService.getCommentListByPage(form);

        model.addAttribute("dataList", commentService.getCommentInfo(pageVO.getDataList()));
        //数据总数
        model.addAttribute("totalCnt", pageVO.getTotalCnt());
        // 页码
        model.addAttribute("pageNo", form.getPageNo());
        // 每页显示数量
        model.addAttribute("pageSize", form.getPageSize());

        return "message/init";
    }


    /**
     * 添加留言
     *
     * @param form 留言form
     * @return result
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public MessageResult addMessage(MessageForm form) {

        MessageResult result = new MessageResult();

        form.setCommentBizType(CommentBizType.MESSAGE.getCode());
        CommentEntity commentEntity = commentService.saveComment(form);

        result.setCommentId(commentEntity.getCommentId());
        result.setCommentParentId(commentEntity.getCommentParentId());
        // 留言人信息
        UserEntity userEntity = userService.findUserByUserId(commentEntity.getCommentUserId());
        if (userEntity != null) {
            result.setCommentUserId(userEntity.getUserId());
            result.setCommentUserName(userEntity.getUserName());
            result.setCommentUserHeadImg(userEntity.getUserHeadImg());
        }
        // 父留言人信息
        if (!StringUtils.isEmpty(commentEntity.getCommentParentUserId())) {
            UserEntity parentUserEntity = userService.findUserByUserId(commentEntity.getCommentParentUserId());
            if (parentUserEntity != null) {
                result.setCommentParentUserId(parentUserEntity.getUserId());
                result.setCommentParentUserName(parentUserEntity.getUserName());
            }
        }
        result.setResult(Constant.SUCCESS);
        return result;
    }

    @PostMapping(value = "/reply")
    @ResponseBody
    public MessageResult replyComment(MessageForm form) {
        MessageResult result = new MessageResult();

        form.setCommentBizType(CommentBizType.REPLY.getCode());
        CommentEntity commentEntity = commentService.saveComment(form);

        result.setCommentId(commentEntity.getCommentId());
        result.setCommentParentId(commentEntity.getCommentParentId());
        // 留言人信息
        UserEntity userEntity = userService.findUserByUserId(commentEntity.getCommentUserId());
        if (userEntity != null) {
            result.setCommentUserId(userEntity.getUserId());
            result.setCommentUserName(userEntity.getUserName());
            result.setCommentUserHeadImg(userEntity.getUserHeadImg());
        }
        // 父留言人信息
        if (!StringUtils.isEmpty(commentEntity.getCommentParentUserId())) {
            UserEntity parentUserEntity = userService.findUserByUserId(commentEntity.getCommentParentUserId());
            if (parentUserEntity != null) {
                result.setCommentParentUserId(parentUserEntity.getUserId());
                result.setCommentParentUserName(parentUserEntity.getUserName());
            }
        }
        result.setResult(Constant.SUCCESS);
        return result;
    }

}
