package com.personalWebsite.controller.admin;

import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.model.response.user.UserDetailResult;
import com.personalWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiatianlong on 2018/2/28.
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("userList", userService.getUserList());
        return "admin/user/list";
    }

    /***
     * 获取用户详情
     * @param userId 用户id
     * @return result
     * @throws Exception    e
     */
    @PostMapping("/{userId}")
    @ResponseBody
    public UserDetailResult getUserDetial(@PathVariable("userId") String userId) throws Exception {
        UserDetailResult result = new UserDetailResult();
        result.setUserDetail(userService.getUserDetail(userId));
        result.setResult(Constant.SUCCESS);
        return result;
    }

}
