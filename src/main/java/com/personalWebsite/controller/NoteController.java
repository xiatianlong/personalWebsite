package com.personalWebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiatianlong on 2017/12/4.
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    @GetMapping
    public String list(){

        return "note/list";
    }
}
