package com.personalWebsite.controller;

import com.personalWebsite.model.response.FileUploadResult;
import com.personalWebsite.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xiatianlong on 2018/1/20.
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/uploadImg")
    @ResponseBody
    public FileUploadResult uploadImg(MultipartFile file) throws Exception {

        // 显示上传1MB
        long imgMaxSize = 1048576;
        return commonService.fileUpload(file, imgMaxSize);

    }

}
