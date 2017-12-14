package com.personalWebsite.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 发布controller
 * Created by xiatianlong on 2017/12/10.
 */
@Controller
@RequestMapping("/member/publish")
public class PublishController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String init(){

        return "personalCenter/init";
    }

}
