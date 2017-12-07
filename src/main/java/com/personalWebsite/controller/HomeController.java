package com.personalWebsite.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页
 * Created by xiatianlong on 2017/12/3.
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(){


        return "/index";
    }



}
