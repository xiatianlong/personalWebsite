package com.personalWebsite.service;

import com.personalWebsite.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by xiatianlong on 2017/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:spring-mvc-web.xml",
        "classpath:spring-mvc-data.xml",
        "classpath:spring-mvc-biz.xml"})
public class UserServiceImplTest{

    @Autowired
    private UserService userService;



    @Test
    @Transactional
    @Rollback(false)
    public void testSaveUser() {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("33333");
        userEntity.setOpenId("3333");
        userEntity.setAccessToken("10312313131");
        userEntity.setUserName("hi");
        userEntity.setUserGender("男");
        userEntity.setCreateTime(new Date());
        userEntity.setUpdateTime(new Date());
        userEntity.setCreateUser("admin");
        userEntity.setUpdateUser("admin");

        userService.saveAndFlush(userEntity);
    }

    @Test
    public void testFindUserByOpenId(){

        UserEntity userEntity = userService.findUserByOpenId("asxasxas");
        if (userEntity == null) {
            System.out.println("没有找到数据");
        } else {
            System.out.println(userEntity.getUserId());
        }


    }

    @Test
    public void testFindLastUser() {
        userService.findLastUser();
    }

    @Test
    public void testGetUserList() {

        List<UserEntity> userEntityList = userService.getUserList();

        if (userEntityList != null && userEntityList.size() > 0) {
            for (UserEntity userEntity : userEntityList) {
                System.out.println(userEntity.getUserName());
            }
        }

    }

    @Test
    public void testFindUserById() {
        UserEntity userEntity = userService.findUserByUserId("100000");
        Assert.assertNotNull(userEntity);
    }

}
