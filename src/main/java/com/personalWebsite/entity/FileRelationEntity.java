package com.personalWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 文件关系表实体
 * Created by xiatianlong on 2018/1/20.
 */
@Entity(name = "t_file_relation")
public class FileRelationEntity extends BaseEntity {

    private static final long serialVersionUID = 2562120724703360639L;
    /**
     * 文件编号
     */
    private String fileNo;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件url
     */
    private String fileUrl;

    /**
     * 文件大小
     */
    private int fileSize;

    /**
     * 文件备注
     */
    private String comment;


    /**
     * 获取 文件编号
     */
    @Id
    @Column(name = "FILE_NO", nullable = false, length = 50)
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
     * 获取 文件名称
     */
    @Column(name = "FILE_NAME", nullable = false, length = 200)
    public String getFileName() {
        return this.fileName;
    }

    /**
     * 设置 文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取 文件url
     */
    @Column(name = "FILE_URL", nullable = false, length = 200)
    public String getFileUrl() {
        return this.fileUrl;
    }

    /**
     * 设置 文件url
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取 文件大小
     */
    @Column(name = "FILE_SIZE", nullable = false)
    public int getFileSize() {
        return this.fileSize;
    }

    /**
     * 设置 文件大小
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取 文件备注
     */
    @Column(name = "FILE_REMARKS", length = 50)
    public String getComment() {
        return this.comment;
    }

    /**
     * 设置 文件备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
