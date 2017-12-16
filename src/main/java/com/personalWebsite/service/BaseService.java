package com.personalWebsite.service;

import java.util.Map;

/**
 * Created by xiatianlong on 2017/12/16.
 */
public interface BaseService {

    /**
     * 获取FreeMarker模板文本
     * @param tempName 模板文件名称
     * @param param 参数
     * @return 内容
     * @throws Exception notfundException
     */
    String getFreeMarkerTemplateContent(String tempName, Map<String, Object> param) throws Exception;


}
