package com.personalWebsite.controller.admin;

import com.personalWebsite.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiatianlong on 2018/2/28.
 */
@Controller
@RequestMapping("/admin/index")
public class AdminIndexController extends BaseController {


    @GetMapping
    public String index() {

        return "admin/index";
    }


}
