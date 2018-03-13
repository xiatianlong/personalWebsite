package com.personalWebsite.dao;

import com.personalWebsite.entity.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Banner Repository
 * Created by xiatianlong on 2018/01/22.
 */
public interface BannerRepository extends JpaRepository<BannerEntity, Integer>, JpaSpecificationExecutor<BannerEntity> {

    /**
     * 获取全部banner
     *
     * @return list
     */
    @Query(value = "SELECT * FROM t_banner banner ORDER BY banner.BANNER_SEQUENCE ASC ", nativeQuery = true)
    List<BannerEntity> getAllBanner();
}
