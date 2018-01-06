package com.personalWebsite.controller;

import com.personalWebsite.common.mail.MailSender;
import com.personalWebsite.dictionary.DictionaryCache;
import com.personalWebsite.entity.DictionaryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiatianlong on 2017/12/16.
 */
@RestController
public class TestController extends BaseController{

    @Autowired
    private MailSender mailSender;

    @RequestMapping(value = "/testEmail", method = RequestMethod.GET)
    public String testEmail() throws Exception{

        List<DictionaryEntity> dictionaryEntityList = DictionaryCache.getChildList("002");

        if (dictionaryEntityList != null && !dictionaryEntityList.isEmpty()) {
            for (DictionaryEntity dic : dictionaryEntityList) {
                System.out.println(dic);
            }
        }


//        System.out.println(MessageSourceUtil.getMessage("error.unknown exception"));


//         throw new ApplicationException(getMessage("do.fail"));


//        System.out.println(5 / 0);

//        MailInfo mailInfo = new MailInfo();
//        mailInfo.setTo("xiatianlong@hotmail.com");
//        mailInfo.setTemplateName("testTemplate.ftl");
//        Map<String, Object> map = new HashMap<>();
//        map.put("value", "这是测试的内容");
//        mailInfo.setArguments(map);
//        mailSender.sendMail(mailInfo);

        return "success";
    }

}
