package com.personalWebsite.service;

import com.personalWebsite.model.response.FileUploadResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公共service
 * Created by xiatianlong on 2018/1/20.
 */
public interface CommonService extends BaseService {

    /**
     * 文件上传
     *
     * @param file     file对象
     * @param fileSize 文件大小
     * @return result
     * @throws Exception e
     */
    FileUploadResult fileUpload(MultipartFile file, long fileSize) throws Exception;

}
