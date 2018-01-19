package com.personalWebsite.controller;

import com.personalWebsite.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Base Controller
 * Created by xiatianlong on 2016/12/30.
 */
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    /**
     * 数据绑定
     *
     * @param binder
     *            WebDataBinder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @Autowired
    protected MessageSource messageSource;

    /**
     * single message
     * @param messageKey
     * 			message key
     * @return  message
     */
    protected String getMessage(String messageKey) {
        return messageSource.getMessage(messageKey, null, Locale.CHINA);
    }

    /**
     * has param message
     * @param messageKey
     * 			message key
     * @param args
     * 			message param array
     * @return  message
     */
    protected String getMessage(String messageKey, Object[] args) {
        return messageSource.getMessage(messageKey, args, Locale.CHINA);
    }

    /**
     * 获取登录用户信息
     *
     * @return userInfo
     */
    protected UserInfo getLoinUser() {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("LOGIN_USER");
        if (userInfo == null) {
            // 创建空的UserInfo对象，防止空指针
            userInfo = new UserInfo();
        }
        return userInfo;
    }

}
