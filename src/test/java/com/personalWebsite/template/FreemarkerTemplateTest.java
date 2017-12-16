package com.personalWebsite.template;

import freemarker.template.Template;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * 模板配置测试
 * Created by xiatianlong on 2017/12/16.
 */
public class FreemarkerTemplateTest {

    ApplicationContext context = null;

    @Before
    public void getContent(){

        context = new ClassPathXmlApplicationContext("spring-mvc-biz.xml");

    }


    @Test
    public void testTemplate() throws Exception{

        FreeMarkerConfigurer configurer = (FreeMarkerConfigurer)context.getBean("template");

        Template temp = configurer.getConfiguration().getTemplate("testTemplate.ftl");
        // 通过模版和参数获取内容
        Map<String, Object> map = new HashMap<>();
        map.put("value", "测试的值");
        String fileContent = FreeMarkerTemplateUtils.processTemplateIntoString(temp, map);

        System.out.println(fileContent);

    }

    @After
    public void destory(){
        context = null;
    }

}
