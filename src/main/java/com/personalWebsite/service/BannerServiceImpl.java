package com.personalWebsite.service;

import com.personalWebsite.dao.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Banner Service.
 * Created by xiatianlong on 2018/3/11.
 */
@Service
@Transactional(readOnly = true)
public class BannerServiceImpl extends BaseServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;


}
