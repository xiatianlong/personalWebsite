package com.personalWebsite.common.exception;

import com.personalWebsite.model.AsynchronousResult;
import com.personalWebsite.utils.AsynchronousRequestUtil;
import com.personalWebsite.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 全局异常处理
 * Created by xiatianlong on 2017/12/28.
 */
public class ApplicationExceptionResolver implements HandlerExceptionResolver {

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

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // 打印异常信息
        System.out.println("进入异常处理--------------");
        ex.printStackTrace();

        ApplicationException applicationException;

        // 如果是系统手动抛出的异常直接转换
        if (ex instanceof ApplicationException) {
            applicationException = (ApplicationException) ex;
        } else {
            // 其他未知异常
            applicationException = new ApplicationException(getMessage("error.unknown exception"));
        }

        try {
            // 向前端返回异常信息
            if (AsynchronousRequestUtil.isAsynchronousRequest(request)) {
                // 异步
                AsynchronousResult result = new AsynchronousResult();
                result.setMessage(applicationException.getMessage());
                response.setContentType("application/json; charset=UTF-8");
                response.getWriter().print(SerializeUtil.serialize(result));
                return new ModelAndView();

            } else {
                // 同步
                ModelAndView modelAndView = new ModelAndView("error/exception");
                modelAndView.addObject("errorMessage", applicationException.getMessage());
                return modelAndView;
            }
        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }

        return new ModelAndView();
    }
}
