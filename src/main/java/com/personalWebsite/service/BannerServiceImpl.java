package com.personalWebsite.service;

import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.system.RedisCacheKeys;
import com.personalWebsite.dao.BannerRepository;
import com.personalWebsite.dao.redis.RedisCache;
import com.personalWebsite.entity.BannerEntity;
import com.personalWebsite.model.request.banner.SaveBannerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Banner Service.
 * Created by xiatianlong on 2018/3/11.
 */
@Service
@Transactional(readOnly = true)
public class BannerServiceImpl extends BaseServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private RedisCache redisCache;


    /**
     * 获取全部banner
     *
     * @return list
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<BannerEntity> getAllBanner() {

        List<BannerEntity> bannerEntities;
        // 从redis缓存取  没取到则查数据库（缓存30分钟,单位s）
        Object obj = redisCache.getChche(RedisCacheKeys.BANNER_KEY);
        if (obj == null) {
            List<BannerEntity> temp = bannerRepository.getAllBanner();
            redisCache.setCache(RedisCacheKeys.BANNER_KEY, temp, 60 * 30);
            bannerEntities = temp;
        } else {
            bannerEntities = (List<BannerEntity>) obj;
        }

        return bannerEntities;
    }

    /**
     * 更新或保存banner
     *
     * @param form form
     * @throws Exception e
     */
    @Transactional
    @Override
    public void saveOrUpdateBanner(SaveBannerForm form) throws Exception {

        if (form == null || form.getBannerImgs() == null || form.getBannerImgs().length == 0) {
            throw new ApplicationException(getMessage("banner.length.zero"));
        }
        if (form.getBannerImgs().length != form.getBannerUris().length
                || form.getBannerImgs().length != form.getBannerSequences().length
                || form.getBannerImgs().length != form.getBannerTexts().length) {
            throw new ApplicationException(getMessage("banner.request.data.error"));
        }
        // 全删
        List<BannerEntity> bannerEntities = getAllBanner();
        if (bannerEntities != null && !bannerEntities.isEmpty()) {
            bannerRepository.delete(bannerEntities);
        }
        // 全增
        Date now = new Date();
        for (int i = 0; i < form.getBannerImgs().length; i++) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.setBannerImg(form.getBannerImgs()[i]);
            bannerEntity.setBannerUri(form.getBannerUris()[i]);
            bannerEntity.setBannerText(form.getBannerTexts()[i]);
            bannerEntity.setBannerSequence(form.getBannerSequences()[i]);
            bannerEntity.setCreateTime(now);
            bannerEntity.setUpdateTime(now);
            bannerEntity.setCreateUser(getLoinUser().getUserId());
            bannerEntity.setUpdateUser(getLoinUser().getUserId());
            bannerRepository.save(bannerEntity);
        }
    }
}
