package com.personalWebsite.dao;

import com.personalWebsite.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户 Repository
 * Created by xiatianlong on 2017/12/27.
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    /**
     * 根据openId查询User对象
     * @param openId    openId
     * @return User
     */
    UserEntity findByOpenId(String openId);

    /**
     * 查询最后一个用户
     *
     * @return User
     */
    @Query(value = "SELECT * FROM t_user u ORDER BY u.USER_ID DESC LIMIT 1", nativeQuery = true)
    UserEntity findLastUser();

}
