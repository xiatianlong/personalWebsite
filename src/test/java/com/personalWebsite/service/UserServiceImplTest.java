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

        UserEntity userEntity = userService.findUserByOpenId("2222");
        Assert.assertNotNull(userEntity);
        System.out.println(userEntity.getUserId());

    }

    @Test
    public void testFindLastUser() {
        userService.findLastUser();
    }


}
