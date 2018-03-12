package com.personalWebsite.controller.admin;

import com.personalWebsite.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Banner controller
 * Created by xiatianlong on 2018/2/28.
 */
@Controller
@RequestMapping("/admin/banner")
public class AdminBannerController extends BaseController {

    @GetMapping("/list")
    public String userList(Model model) {

        return null;
    }


}
