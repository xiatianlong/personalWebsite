package com.personalWebsite.service;

import com.personalWebsite.entity.CollectionEntity;
import com.personalWebsite.model.response.collection.CollectionInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

/**
 * Created by xiatianlong on 2017/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:spring-mvc-web.xml",
        "classpath:spring-mvc-data.xml",
        "classpath:spring-mvc-biz.xml"})
public class CollectionServiceImplTest {

    @Autowired
    private CollectionService collectionService;


    @Test
    public void testCollectionList() {

        List<CollectionEntity> collectionEntities = collectionService.getCollectionsByUser("100000");

        Assert.assertNotNull(collectionEntities);

        Map<String, List<CollectionInfo>> map = collectionService.getCollectionGroupByBizType(collectionEntities);


    }

}
