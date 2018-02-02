package com.personalWebsite.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * Created by xiatianlong on 2017/12/3.
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

    @GetMapping
    public String home(){


        return "index";
    }



}
