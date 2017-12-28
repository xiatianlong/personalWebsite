package com.personalWebsite.controller;

import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.common.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiatianlong on 2017/12/16.
 */
@RestController
public class TestController extends BaseController{

    @Autowired
    private MailSender mailSender;

    @RequestMapping(value = "/testEmail", method = RequestMethod.GET)
    public String testEmail() throws Exception{


         throw new ApplicationException(getMessage("do.fail"));

//        MailInfo mailInfo = new MailInfo();
//        mailInfo.setTo("xiatianlong@hotmail.com");
//        mailInfo.setTemplateName("testTemplate.ftl");
//        Map<String, Object> map = new HashMap<>();
//        map.put("value", "这是测试的内容");
//        mailInfo.setArguments(map);
//        mailSender.sendMail(mailInfo);

//        return "success";
    }

}
