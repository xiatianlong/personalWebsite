package com.personalWebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 关于
 * Created by xiatianlong on 2017/12/6.
 */
@Controller
@RequestMapping("/about")
public class AboutController extends BaseController {

    /**
     * 关于我
     *
     * @return me
     */
    @GetMapping("/me")
    public String aboutMe() {

        return "about/me";
    }

    /**
     * 网站历史
     *
     * @return history
     */
    @GetMapping("/siteHistory")
    public String siteHistory() {

        return "about/siteHistory";
    }

}
