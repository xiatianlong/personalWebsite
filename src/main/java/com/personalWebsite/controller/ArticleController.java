package com.personalWebsite.controller;

import com.personalWebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiatianlong on 2017/12/4.
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章列表画面
     *
     * @return str
     */
    @GetMapping
    public String list(){

        return "article/list";
    }

}
