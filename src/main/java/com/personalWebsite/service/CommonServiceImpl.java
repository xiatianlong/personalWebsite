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
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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

        return uploadFile(file, fileSize, 0);
    }


    /**
     * 图片上传压缩
     *
     * @param file     图片
     * @param fileSize 文件最大限制
     * @return result
     * @throws Exception e
     */
    @Override
    @Transactional
    public FileUploadResult imgCompression(MultipartFile file, long fileSize) throws Exception {

        return uploadFile(file, fileSize, 1);
    }


    /**
     * 文件上传
     *
     * @param file     文件
     * @param fileSize 文件最大限制
     * @param type     类型{0:普通上传；1：图片压缩上传}
     * @return result
     * @throws Exception e
     */
    private FileUploadResult uploadFile(MultipartFile file, long fileSize, int type) throws Exception {

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
            InputStream fileInputStream = file.getInputStream();
            // type = 1; 图片上传压缩 begin--
            if (type == 1) {
                Thumbnails.Builder<? extends InputStream> builder = Thumbnails.of(fileInputStream);
                if (file.getSize() > 1.5 * 1024 * 1024) {
                    // 1.5mb - ~
                    builder.scale(0.4);
                    builder.outputQuality(0.65f);
                } else if (file.getSize() > 1024 * 1024) {
                    // 1mb - 1.5mg
                    builder.scale(0.45);
                    builder.outputQuality(0.65f);
                } else if (file.getSize() > 0.512 * 1024 * 1024) {
                    // 512kb - 1mb
                    builder.scale(0.55);
                    builder.outputQuality(0.7f);
                } else if (file.getSize() > 0.256 * 1024 * 1024) {
                    // 256kb - 512kb
                    builder.scale(0.7);
                    builder.outputQuality(0.65f);
                } else {
                    // ~ - 256kb
                    builder.scale(0.9);
                    builder.outputQuality(0.9f);
                }
                builder.outputFormat(FileUtil.getFileSuffix(file.getOriginalFilename()).replace(".", ""));
                BufferedImage bufferedImage = builder.asBufferedImage();
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, FileUtil.getFileSuffix(file.getOriginalFilename()).replace(".", ""), os);
                fileInputStream = new ByteArrayInputStream(os.toByteArray());
            }
            // type = 1; 图片上传压缩 end--

            // 文件上传
            ossClient.putObject(Constant.BACKET, uuid + FileUtil.getFileSuffix(file.getOriginalFilename()), fileInputStream);
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
