package com.personalWebsite.entity;



import javax.persistence.*;

/**
 * 首页焦点图
 * Created by xiatianlong on 2018/3/12.
 */
@Entity(name = "t_banner")
public class BannerEntity extends BaseEntity {

    /**
     * 物理主键ID
     */
    private int id;

    /**
     * banner图片
     */
    private String bannerImg;

    /**
     * banner链接
     */
    private String bannerUri;

    /**
     * banner文本描述
     */
    private String bannerText;

    /**
     * banner排序
     */
    private int bannerSequence = 0;

    /**
     * banner图片文件
     */
    private FileRelationEntity articleImgFile;


    /**
     * 获取 物理主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 11)
    public int getId() {
        return this.id;
    }

    /**
     * 设置 物理主键ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取 banner图片
     */
    @Column(name = "BANNER_IMG", nullable = false, length = 11)
    public String getBannerImg() {
        return this.bannerImg;
    }

    /**
     * 设置 banner图片
     */
    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    /**
     * 获取 banner链接
     */
    @Column(name = "BANNER_URI", length = 200)
    public String getBannerUri() {
        return this.bannerUri;
    }

    /**
     * 设置 banner链接
     */
    public void setBannerUri(String bannerUri) {
        this.bannerUri = bannerUri;
    }

    /**
     * 获取 banner文本描述
     */
    @Column(name = "BANNER_TEXT", length = 50)
    public String getBannerText() {
        return this.bannerText;
    }

    /**
     * 设置 banner文本描述
     */
    public void setBannerText(String bannerText) {
        this.bannerText = bannerText;
    }

    /**
     * 获取 banner排序
     */
    @Column(name = "BANNER_SEQUENCE", length = 11)
    public int getBannerSequence() {
        return this.bannerSequence;
    }

    /**
     * 设置 banner排序
     */
    public void setBannerSequence(int bannerSequence) {
        this.bannerSequence = bannerSequence;
    }


    /**
     * 获取 banner图片文件
     */
    @ManyToOne
    @JoinColumn(name = "BANNER_IMG", referencedColumnName = "FILE_NO", updatable = false, insertable = false)
    public FileRelationEntity getArticleImgFile() {
        return this.articleImgFile;
    }

    /**
     * 设置 banner图片文件
     */
    public void setArticleImgFile(FileRelationEntity articleImgFile) {
        this.articleImgFile = articleImgFile;
    }
}
