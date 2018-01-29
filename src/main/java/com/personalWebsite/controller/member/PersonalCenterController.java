package com.personalWebsite.controller.member;

import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.entity.UserEntity;
import com.personalWebsite.model.request.member.SettingForm;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 个人中心
 * Created by xiatianlong on 2017/12/6.
 */
@Controller
@RequestMapping("/member/personalCenter")
public class PersonalCenterController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 个人中心首页
     * @return  个人中心画面
     */
    @GetMapping(value = "")
    public String personalCenter(){

        return "personalCenter/personalCenter";
    }

    /**
     * 个人设置
     * @return  个人中心画面
     */
    @GetMapping(value = "/setting")
    public String setting(Model model) throws Exception {
        UserEntity userEntity = userService.findUserByUserId(getLoinUser().getUserId());
        if (userEntity == null) {
            throw new ApplicationException(getMessage("login.null"));
        }
        model.addAttribute("isOpen", userEntity.isOpen());
        model.addAttribute("userEmail", userEntity.getUserEmail());
        model.addAttribute("userQQ", userEntity.getUserQQ());
        model.addAttribute("userIntroduction", userEntity.getUserIntroduction());

        return "personalCenter/setting";
    }

    /**
     * 个人设置提交
     *
     * @param form 表单
     * @return result
     */
    @PostMapping(value = "/setting")
    @ResponseBody
    public AsynchronousResult saveSettings(@Valid SettingForm form, BindingResult bindingResult) {
        AsynchronousResult result = new AsynchronousResult();
        // 校验
        if (bindingResult.hasErrors()) {
            result.setMessage(getMessage(bindingResult.getAllErrors().get(0).getDefaultMessage()));
            return result;
        }
        // 更新设置信息
        userService.settingUserInfo(form);
        result.setResult(Constant.SUCCESS);
        return result;
    }

}
