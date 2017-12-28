package com.personalWebsite.service;

import com.personalWebsite.entity.UserEntity;

/**
 * User Service.
 * Created by xiatianlong on 2017/12/27.
 */
public interface UserService extends BaseService {


    /**
     * 保存用户对象
     * @param userEntity user
     */
    void saveAndFlush(UserEntity userEntity);

    /**
     * 根据OpenId获取用户
     * @param openId openId
     * @return  user
     */
    UserEntity findUserByOpenId(String openId);
}
