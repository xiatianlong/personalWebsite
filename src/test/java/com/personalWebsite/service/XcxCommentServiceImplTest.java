package com.personalWebsite.service;

import com.personalWebsite.xiaochengxu.model.XcxCommentListResult;
import com.personalWebsite.xiaochengxu.model.XcxCommentPageForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by xiatianlong on 2017/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:spring-mvc-web.xml",
        "classpath:spring-mvc-data.xml",
        "classpath:spring-mvc-biz.xml"})
public class XcxCommentServiceImplTest {

    @Autowired
    private XcxCommentService xcxCommentService;

    @Test
    public void testGetUserList() {

        XcxCommentListResult result = xcxCommentService.getCommentList(new XcxCommentPageForm());


    }


}
