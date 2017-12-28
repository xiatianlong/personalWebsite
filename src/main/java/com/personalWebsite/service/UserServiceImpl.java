package com.personalWebsite.service;

import com.personalWebsite.dao.UserRepository;
import com.personalWebsite.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiatianlong on 2017/12/27.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void saveAndFlush(UserEntity userEntity) {
        userRepository.saveAndFlush(userEntity);
    }

    @Override
    public UserEntity findUserByOpenId(String openId) {

        return userRepository.findByOpenId(openId);
    }
}
