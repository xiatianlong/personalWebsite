package com.personalWebsite.service;

import com.personalWebsite.common.system.Constant;
import com.personalWebsite.entity.EmailRecordEntity;
import com.personalWebsite.utils.UUIDUtil;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiatianlong on 2018/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:spring-mvc-web.xml",
        "classpath:spring-mvc-data.xml",
        "classpath:spring-mvc-biz.xml"})
public class EmailServiceImplTest {

    @Autowired
    private EmailRecordService emailRecordService;

    @Autowired
    protected FreeMarkerConfigurer mailTemplate;

    @Test
    @Transactional
    @Rollback(false)
    public void testSaveEmailRecord() throws Exception {

        EmailRecordEntity emailRecordEntity = new EmailRecordEntity();
        emailRecordEntity.setEmailCode(UUIDUtil.getUUID());
        emailRecordEntity.setEmailTo(Constant.DEFAULT_EMAIL);
        emailRecordEntity.setCreateTime(new Date());
        emailRecordEntity.setUpdateTime(new Date());
        emailRecordEntity.setCreateUser(Constant.ADMIN);
        emailRecordEntity.setUpdateUser(Constant.ADMIN);

        Template temp = mailTemplate.getConfiguration().getTemplate("exceptionTemplate.ftl");
        // 通过模版和参数获取内容
        Map<String, Object> map = new HashMap<>();
        map.put("requestUrl", "xiatianlong.com");
        map.put("requestTime", "2017-01-01");
        map.put("userName", "测试");
        map.put("userId", "12345648456165");
        map.put("errorLogText", "error log text");
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(temp, map);

        emailRecordEntity.setEmailContent(content);


        emailRecordService.saveEmailRecord(emailRecordEntity);

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testBatchSendEmail() {

        emailRecordService.getUnsendEmailList();


    }

}
