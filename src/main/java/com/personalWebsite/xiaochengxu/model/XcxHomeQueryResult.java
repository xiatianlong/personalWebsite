package com.personalWebsite.xiaochengxu.model;

import com.personalWebsite.entity.BannerEntity;
import com.personalWebsite.model.response.home.HomeQueryResult;

import java.util.List;

/**
 * Created by xiatianlong on 2018/4/15.
 */
public class XcxHomeQueryResult extends HomeQueryResult {
    private static final long serialVersionUID = 4805359695732197725L;

    /**
     * bannerList
     */
    private List<BannerEntity> bannerList;


    /**
     * 获取 bannerList
     */
    public List<BannerEntity> getBannerList() {
        return this.bannerList;
    }

    /**
     * 设置 bannerList
     */
    public void setBannerList(List<BannerEntity> bannerList) {
        this.bannerList = bannerList;
    }
}
