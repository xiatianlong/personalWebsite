package com.personalWebsite.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * HttpClientUtil Test
 * Created by xiatianlong on 2017/12/14.
 */
public class HttpClientUtilTest {

    @Test
    public void testGet(){
        String  url = "https://kyfw.12306.cn/otn/leftTicket/query";
        String param = "leftTicketDTO.train_date=2018-01-02&leftTicketDTO.from_station=WHN&leftTicketDTO.to_station=SHH&purpose_codes=ADULT";
        JSONObject jsonObject = HttpClientUtil.get(url, param);
        System.out.println(jsonObject);
    }

    @Test
    public void testPost(){
        String url = "https://www.xiatianlong.com/note/tagSearch";
        String param = "lastNoteCreateTime=2017-06-28 13:31:47&tags=java";
        JSONObject jsonObject = HttpClientUtil.post(url, param);
        System.out.println(jsonObject);
    }

}
