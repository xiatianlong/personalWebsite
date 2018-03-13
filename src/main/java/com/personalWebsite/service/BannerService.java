package com.personalWebsite.service;

import com.personalWebsite.entity.BannerEntity;
import com.personalWebsite.model.request.banner.SaveBannerForm;

import java.util.List;

/**
 * Banner Service.
 * Created by xiatianlong on 2018/3/11.
 */
public interface BannerService extends BaseService {

    /**
     * 获取全部banner
     *
     * @return list
     */
    List<BannerEntity> getAllBnner();

    /**
     * 更新或保存banner
     *
     * @param form form
     * @throws Exception e
     */
    void saveOrUpdateBanner(SaveBannerForm form) throws Exception;
}
