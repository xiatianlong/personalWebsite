package com.personalWebsite.model.response;

/**
 * 文件上传返回结果
 * Created by xiatianlong on 2018/1/20.
 */
public class FileUploadResult extends AsynchronousResult {

    /**
     * 文件编号
     */
    private String fileNo;

    /**
     * 文件物理路径
     */
    private String fileUrl;

    /**
     * 文件大小
     */
    private long fileSize;

    /**
     * 文件名
     */
    private String fileName;


    /**
     * 获取 文件编号
     */
    public String getFileNo() {
        return this.fileNo;
    }

    /**
     * 设置 文件编号
     */
    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    /**
     * 获取 文件物理路径
     */
    public String getFileUrl() {
        return this.fileUrl;
    }

    /**
     * 设置 文件物理路径
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取 文件大小
     */
    public long getFileSize() {
        return this.fileSize;
    }

    /**
     * 设置 文件大小
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取 文件名
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * 设置 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
