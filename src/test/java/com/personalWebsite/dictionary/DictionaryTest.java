package com.personalWebsite.dictionary;

import com.personalWebsite.entity.DictionaryEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by xiatianlong on 2018/1/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:spring-mvc-web.xml",
        "classpath:spring-mvc-data.xml",
        "classpath:spring-mvc-biz.xml"})
public class DictionaryTest {

    @Test
    public void testDic() {

        List<DictionaryEntity> dictionaryEntityList = DictionaryCache.getChildList("002");

        if (dictionaryEntityList != null && !dictionaryEntityList.isEmpty()) {
            for (DictionaryEntity dic : dictionaryEntityList) {
                System.out.println(dic);
            }
        }

    }

}
