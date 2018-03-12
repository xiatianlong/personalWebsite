package com.personalWebsite.dao;

import com.personalWebsite.entity.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Banner Repository
 * Created by xiatianlong on 2018/01/22.
 */
public interface BannerRepository extends JpaRepository<BannerEntity, Integer>, JpaSpecificationExecutor<BannerEntity> {


}
