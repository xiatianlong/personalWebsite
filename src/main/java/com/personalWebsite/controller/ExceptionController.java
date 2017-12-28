package com.personalWebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiatianlong on 2017/12/28.
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping
    public String exception(Model model, HttpServletRequest request){

        model.addAttribute("errorMessage", "1111");

        return "error/exception";
    }

}
