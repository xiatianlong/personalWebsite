package com.personalWebsite.service;

import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.dao.UserRepository;
import com.personalWebsite.entity.UserEntity;
import com.personalWebsite.model.request.member.SettingForm;
import com.personalWebsite.model.response.user.UserDetail;
import com.personalWebsite.utils.DateUtil;
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
        return userRepository.findByUserIdAndDeleted(userId, false);
    }

    /**
     * 获取用户详情
     *
     * @param userId 用户id
     * @return 用户详情
     * @throws Exception e
     */
    @Override
    public UserDetail getUserDetail(String userId) throws Exception {

        UserEntity userEntity = findUserByUserId(userId);
        if (userEntity == null) {
            throw new ApplicationException(getMessage("user.null"));
        }
        UserDetail user = new UserDetail();
        // 用户ID
        user.setUserId(userEntity.getUserId());
        // 用户昵称
        user.setUserName(userEntity.getUserName());
        // 用户性别
        user.setUserGender(userEntity.getUserGender());
        // 用户头像
        user.setUserHeadImg(userEntity.getUserHeadImg());
        // 用户邮箱
        user.setUserEmail(userEntity.getUserEmail());
        // QQ
        user.setUserQQ(userEntity.getUserQQ());
        // 个人简介
        user.setUserIntroduction(userEntity.getUserIntroduction());
        // 是否开放个人中心访问
        user.setOpen(userEntity.isOpen());
        // 最后登录时间
        if (userEntity.getLastLoginTime() != null) {
            user.setFmtLastLoginTime(DateUtil.defaultFormat(userEntity.getLastLoginTime()));
        }
        // 用户创建时间
        user.setFmtCreateTime(DateUtil.defaultFormat(userEntity.getCreateTime()));
        return user;
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
