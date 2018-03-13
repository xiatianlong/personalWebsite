package com.personalWebsite.model.request.banner;

import java.io.Serializable;

/**
 * banner请求表单
 * Created by xiatianlong on 2018/3/13.
 */
public class SaveBannerForm implements Serializable {
    private static final long serialVersionUID = -4786456372147604893L;

    /**
     * banner 图片
     */
    private String[] bannerImgs;

    /**
     * banner 链接
     */
    private String[] bannerUris;

    /**
     * banner文本描述
     */
    private String[] bannerTexts;

    /**
     * banner排序
     */
    private Integer[] bannerSequences;


    /**
     * 获取 banner 图片
     */
    public String[] getBannerImgs() {
        return this.bannerImgs;
    }

    /**
     * 设置 banner 图片
     */
    public void setBannerImgs(String[] bannerImgs) {
        this.bannerImgs = bannerImgs;
    }

    /**
     * 获取 banner 链接
     */
    public String[] getBannerUris() {
        return this.bannerUris;
    }

    /**
     * 设置 banner 链接
     */
    public void setBannerUris(String[] bannerUris) {
        this.bannerUris = bannerUris;
    }

    /**
     * 获取 banner文本描述
     */
    public String[] getBannerTexts() {
        return this.bannerTexts;
    }

    /**
     * 设置 banner文本描述
     */
    public void setBannerTexts(String[] bannerTexts) {
        this.bannerTexts = bannerTexts;
    }

    /**
     * 获取 banner排序
     */
    public Integer[] getBannerSequences() {
        return this.bannerSequences;
    }

    /**
     * 设置 banner排序
     */
    public void setBannerSequences(Integer[] bannerSequences) {
        this.bannerSequences = bannerSequences;
    }
}
