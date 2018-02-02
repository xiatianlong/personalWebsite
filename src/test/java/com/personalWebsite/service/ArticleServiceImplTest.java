package com.personalWebsite.service;

import com.personalWebsite.model.request.article.ArticlePageForm;
import com.personalWebsite.model.response.article.ArticleCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
public class ArticleServiceImplTest {

    @Autowired
    private ArticleService articleService;


    @Test
    public void testQuery() {

        List<ArticleCard> cardList = articleService.getMyArticleList(new ArticlePageForm());

        if (cardList != null) {
            System.out.println(cardList.size());
        }


    }


}
