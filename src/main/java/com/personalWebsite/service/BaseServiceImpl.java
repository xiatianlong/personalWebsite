package com.personalWebsite.service;

import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Map;

/**
 * Created by xiatianlong on 2017/12/16.
 */
public class BaseServiceImpl implements BaseService {

    @Autowired
    protected FreeMarkerConfigurer template;


    /**
     * 获取FreeMarker模板文本
     * @param tempName 模板文件名称
     * @param param 参数
     * @return 内容
     * @throws Exception notfundException
     */
    @Override
    public String getFreeMarkerTemplateContent(String tempName, Map<String, Object> param) throws Exception {
        // 获取模板
        Template temp = template.getConfiguration().getTemplate(tempName);
        // 通过模版和参数获取内容
        return FreeMarkerTemplateUtils.processTemplateIntoString(temp, param);
    }

}
