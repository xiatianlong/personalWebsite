package com.personalWebsite.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.Constant;
import com.personalWebsite.dao.FileRelationRepository;
import com.personalWebsite.entity.FileRelationEntity;
import com.personalWebsite.model.response.FileUploadResult;
import com.personalWebsite.utils.FileUtil;
import com.personalWebsite.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 公共service服务类.
 * Created by xiatianlong on 2018/1/20.
 */
@Service
@Transactional(readOnly = true)
public class CommonServiceImpl extends BaseServiceImpl implements CommonService {

    @Autowired
    private FileRelationRepository fileRelationRepository;

    /**
     * 文件上传
     *
     * @param file     file对象
     * @param fileSize 文件大小
     * @return result
     * @throws Exception e
     */
    @Override
    @Transactional
    public FileUploadResult fileUpload(MultipartFile file, long fileSize) throws Exception {

        if (file != null) {
            FileUploadResult result = new FileUploadResult();

            // 限制文件上传大小
            if (file.getSize() > fileSize) {
                throw new ApplicationException(getMessage("file.upload.max.size", new Object[]{FileUtil.getSize(fileSize)}));
            }
            // 创建ossClient实例
            OSSClient ossClient = new OSSClient(Constant.ENDPOINT, Constant.ACCESS_KEY_ID, Constant.ACCESS_KEY_SECRET);
            // 创建Bucket
            if (!ossClient.doesBucketExist(Constant.BACKET)) {
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(Constant.BACKET);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            String uuid = UUIDUtil.getUUID();
            // 文件上传
            ossClient.putObject(Constant.BACKET, uuid + FileUtil.getFileSuffix(file.getOriginalFilename()), file.getInputStream());
            // 拼装文件物理url
            String fileUrl = Constant.ALIYUN_UPLOAD_URL +
                    "/" + uuid + FileUtil.getFileSuffix(file.getOriginalFilename());
            System.out.println("upload file success! url : " + fileUrl);
            // 文件编号
            result.setFileNo(uuid);
            // 文件物理路径
            result.setFileUrl(fileUrl);
            // 文件大小
            result.setFileSize(file.getSize());
            // 文件名
            result.setFileName(file.getOriginalFilename());

            // 持久化到文件关系表
            FileRelationEntity fileRelationEntity = new FileRelationEntity();
            fileRelationEntity.setFileNo(uuid);
            fileRelationEntity.setFileName(file.getOriginalFilename());
            fileRelationEntity.setFileUrl(fileUrl);
            fileRelationEntity.setFileSize(file.getSize());
            Date now = new Date();
            fileRelationEntity.setCreateTime(now);
            fileRelationEntity.setUpdateTime(now);
            fileRelationEntity.setCreateUser(getLoinUser().getUserId());
            fileRelationEntity.setUpdateUser(getLoinUser().getUserId());
            fileRelationRepository.save(fileRelationEntity);
            // 关闭连接
            ossClient.shutdown();
            result.setResult(Constant.SUCCESS);
            return result;
        } else {
            throw new ApplicationException(getMessage("file.upload.null"));
        }
    }
}
