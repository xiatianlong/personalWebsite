package com.personalWebsite.controller;

import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.model.response.user.UserDetail;
import com.personalWebsite.service.ArticleService;
import com.personalWebsite.service.NoteService;
import com.personalWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户Controllre（不涉及用户权限）
 * Created by xiatianlong on 2018/3/20.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private ArticleService articleService;

    /**
     * 查看用户信息
     *
     * @param userId userId
     * @param model  model
     * @return page
     * @throws Exception e
     */
    @GetMapping("/{userId}")
    public String info(@PathVariable("userId") String userId, Model model) throws Exception {
        UserDetail userDetail = userService.getUserDetail(userId);
        if (userDetail == null) {
            throw new ApplicationException(getMessage("user.null"));
        }
        model.addAttribute("user", userDetail);
        if (userDetail.isOpen()) {
            model.addAttribute("noteList", noteService.getOnlineNoteByUser(userId));
            model.addAttribute("articleList", articleService.getOnlineArticleByUser(userId));
        }

        return "user/userInfo";
    }


}
