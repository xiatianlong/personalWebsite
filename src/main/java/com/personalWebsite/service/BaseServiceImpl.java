package com.personalWebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by xiatianlong on 2017/12/27.
 */
public class BaseServiceImpl implements BaseService {

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

}
