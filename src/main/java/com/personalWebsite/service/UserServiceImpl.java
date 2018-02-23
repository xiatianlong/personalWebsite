package com.personalWebsite.service;

import com.personalWebsite.dao.UserRepository;
import com.personalWebsite.entity.UserEntity;
import com.personalWebsite.model.request.member.SettingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiatianlong on 2017/12/27.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 保存用户对象
     *
     * @param userEntity user
     */
    @Transactional
    @Override
    public void saveAndFlush(UserEntity userEntity) {
        userRepository.saveAndFlush(userEntity);
    }

    /**
     * 根据OpenId获取用户
     * @param openId openId
     * @return user
     */
    @Override
    public UserEntity findUserByOpenId(String openId) {

        return userRepository.findByOpenId(openId);
    }

    /**
     * 根据userId获取用户
     *
     * @param userId userId
     * @return user
     */
    @Override
    public UserEntity findUserByUserId(String userId) {
        return userRepository.findOne(userId);
    }

    /**
     * 获取最后一个用户
     *
     * @return user
     */
    @Override
    public UserEntity findLastUser() {
        return userRepository.findLastUser();
    }

    /**
     * 个人中心信息设置
     *
     * @param form 设置表单
     */
    @Transactional
    @Override
    public void settingUserInfo(SettingForm form) {

        String userId = getLoinUser().getUserId();
        UserEntity userEntity = findUserByUserId(userId);
        if (userEntity != null) {
            userEntity.setOpen(form.isOpen());
            userEntity.setUserQQ(form.getUserQQ());
            userEntity.setUserEmail(form.getUserEmail());
            userEntity.setUserIntroduction(form.getUserIntroduction());
            userRepository.saveAndFlush(userEntity);
        }
    }

    /**
     * 获取用户列表
     *
     * @return list
     */
    @Override
    public List<UserEntity> getUserList() {
        return userRepository.getUserList();
    }
}
