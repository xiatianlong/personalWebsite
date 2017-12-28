package com.personalWebsite.dao;

import com.personalWebsite.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 * Created by xiatianlong on 2017/12/27.
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    /**
     * 根据openId查询User对象
     * @param openId    openId
     * @return User
     */
    UserEntity findByOpenId(String openId);
}
