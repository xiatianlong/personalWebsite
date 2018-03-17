package com.personalWebsite.controller;

import com.personalWebsite.common.enums.CommentBizType;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.entity.CommentEntity;
import com.personalWebsite.entity.UserEntity;
import com.personalWebsite.model.request.comment.CommentPageForm;
import com.personalWebsite.model.request.comment.MessageForm;
import com.personalWebsite.model.response.comment.MessagePageResult;
import com.personalWebsite.model.response.comment.MessageResult;
import com.personalWebsite.service.CommentService;
import com.personalWebsite.service.UserService;
import com.personalWebsite.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 评论、留言Controller.
 * Created by xiatianlong on 2017/12/4.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    /**
     * 留言、评论列表
     *
     * @param model model
     * @param form  form
     * @return 列表画面
     */
    @GetMapping
    public String list(Model model, CommentPageForm form) {

        form.setCommentBizType(CommentBizType.MESSAGE.getCode());
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
     * 留言分页加载更多
     *
     * @param form form
     * @return result
     */
    @PostMapping("/query")
    @ResponseBody
    public MessagePageResult query(CommentPageForm form) {
        MessagePageResult result = new MessagePageResult();
        PageVO<CommentEntity> pageVO = commentService.getCommentListByPage(form);
        result.setDataCount(pageVO.getTotalCnt());
        result.setCommentInfos(commentService.getCommentInfo(pageVO.getDataList()));
        result.setResult(Constant.SUCCESS);
        return result;
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

        CommentEntity commentEntity = commentService.saveComment(form);

        // 留言人信息
        UserEntity userEntity = userService.findUserByUserId(commentEntity.getCommentUserId());
        commentEntity.setCommentUser(userEntity);
        result.setCommentInfo(commentService.getCommentInfo(commentEntity));
        result.setResult(Constant.SUCCESS);
        return result;
    }


}
