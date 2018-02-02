package com.personalWebsite.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 发布controller
 * Created by xiatianlong on 2017/12/10.
 */
@Controller
@RequestMapping("/member/publish")
public class PublishController {

    @GetMapping
    public String init(){

        return "personalCenter/publish";
    }

}
