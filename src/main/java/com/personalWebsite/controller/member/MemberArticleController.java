package com.personalWebsite.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 会员发布的文章
 * Created by xiatianlong on 2017/12/6.
 */
@Controller
@RequestMapping("/member/article")
public class MemberArticleController {

    /**
     * 文章列表
     * @return 文章列表页
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(){

        return "personalCenter/article/myPublishArtivleList";
    }

    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public String articleDetail(@PathVariable("articleId") String articleId){


        return "personalCenter/article/myArticleDetail";
    }

}
