package com.personalWebsite.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 个人中心
 * Created by xiatianlong on 2017/12/6.
 */
@Controller
@RequestMapping("/member/personalCenter")
public class PersonalCenterController {

    /**
     * 个人中心首页
     * @return  个人中心画面
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String personalCenter(){

        return "personalCenter/personalCenter";
    }

    /**
     * 个人设置
     * @return  个人中心画面
     */
    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String setting(){

        return "personalCenter/setting";
    }

}
