package com.personalWebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xiatianlong on 2017/12/4.
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(){

        return "note/list";
    }
}
