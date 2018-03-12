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

    /**
     * 文件上传
     *
     * @param file 文件
     * @return result
     * @throws Exception e
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public FileUploadResult uploadImg(MultipartFile file) throws Exception {

        // 显示上传2MB
        long maxSize = 2097152;
        return commonService.fileUpload(file, maxSize);

    }

    /**
     * 图片压缩上传
     *
     * @param file 图片
     * @return result
     * @throws Exception e
     */
    @PostMapping("/uploadCompressionImg")
    @ResponseBody
    public FileUploadResult uploadCompressionImg(MultipartFile file) throws Exception {

        // 显示上传2MB
        long maxSize = 2097152;
        return commonService.imgCompression(file, maxSize);

    }

}
