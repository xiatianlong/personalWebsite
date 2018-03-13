package com.personalWebsite.controller.admin;

import com.personalWebsite.common.system.Constant;
import com.personalWebsite.controller.BaseController;
import com.personalWebsite.model.request.banner.SaveBannerForm;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Banner controller
 * Created by xiatianlong on 2018/2/28.
 */
@Controller
@RequestMapping("/admin/banner")
public class AdminBannerController extends BaseController {

    @Autowired
    private BannerService bannerService;

    /**
     * Banner列表
     *
     * @param model model
     * @return 列表画面
     */
    @GetMapping("/list")
    public String userList(Model model) {

        model.addAttribute("bannerList", bannerService.getAllBnner());
        return "admin/banner/list";
    }

    /**
     * banner更新提交
     *
     * @param form form
     * @return result
     */
    @PostMapping("/update")
    @ResponseBody
    public AsynchronousResult update(SaveBannerForm form) throws Exception {
        AsynchronousResult result = new AsynchronousResult();
        bannerService.saveOrUpdateBanner(form);
        result.setResult(Constant.SUCCESS);
        return result;
    }



}
