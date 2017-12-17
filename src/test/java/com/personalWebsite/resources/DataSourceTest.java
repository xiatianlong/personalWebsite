package com.personalWebsite.resources;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 需设置spring-mvc-data.xml中的hibernate.hbm2ddl.auto为update
 * 再建立一个entity即可自动生成表
 * Created by xiatianlong on 2017/12/17.
 */
public class DataSourceTest {

    ApplicationContext acx = null;

    @Before
    public void getApplicationContext(){
        acx = new ClassPathXmlApplicationContext("spring-mvc-data.xml");
    }

    @Test
    public void testDateSource(){

    }

    @After
    public void destory(){
        acx = null;
    }

}
