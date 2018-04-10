package com.personalWebsite.common.exception;

import com.personalWebsite.common.system.Constant;
import com.personalWebsite.entity.EmailRecordEntity;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.service.EmailRecordService;
import com.personalWebsite.utils.*;
import com.personalWebsite.vo.UserInfo;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 全局异常处理
 * Created by xiatianlong on 2017/12/28.
 */
public class ApplicationExceptionResolver implements HandlerExceptionResolver {

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    private EmailRecordService emailRecordService;

    @Autowired
    protected FreeMarkerConfigurer mailTemplate;

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
        try {
            ApplicationException applicationException;

            // 如果是系统手动抛出的异常直接转换
            if (ex instanceof ApplicationException) {
                applicationException = (ApplicationException) ex;
            } else {
                // 其他未知异常
                applicationException = new ApplicationException(getMessage("error.unknown.exception"));
                // 请求接口
                String requestURL = request.getRequestURL().toString();
                // 静态静秋不发错误邮件
                if (checkRequestUrI(requestURL)) {
                    // 给管理员发送错误邮件
                    EmailRecordEntity emailRecordEntity = new EmailRecordEntity();
                    emailRecordEntity.setEmailCode(UUIDUtil.getUUID());
                    emailRecordEntity.setEmailTo(Constant.DEFAULT_EMAIL);
                    emailRecordEntity.setCreateTime(new Date());
                    emailRecordEntity.setUpdateTime(new Date());
                    emailRecordEntity.setCreateUser(Constant.ADMIN);
                    emailRecordEntity.setUpdateUser(Constant.ADMIN);
                    Template template = mailTemplate.getConfiguration().getTemplate("exceptionTemplate.ftl");
                    Map<String, Object> map = new HashMap<>();
                    map.put("requestUrl", requestURL);
                    map.put("requestTime", DateUtil.format(new Date(), DateUtil.DEFAULT_DATE_PATTERN));
                    UserInfo userInfo = (UserInfo) request.getSession().getAttribute("LOGIN_USER");
                    if (userInfo != null) {
                        map.put("userName", userInfo.getUserName());
                        map.put("userId", userInfo.getUserId());
                    } else {
                        map.put("userName", "--");
                        map.put("userId", "--");
                    }
                    // 获取整个错误栈
                    StringBuilder exceptionStack = new StringBuilder();
                    for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
                        exceptionStack.append(stackTraceElement.toString()).append("<br>");
                    }
                    map.put("errorLogText", exceptionStack.toString());
                    String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
                    emailRecordEntity.setEmailContent(content);
                    emailRecordService.saveEmailRecord(emailRecordEntity);
                }
            }

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


    /**
     * 校验URI
     *
     * @param uri uri
     * @return boolean
     */
    private boolean checkRequestUrI(String uri) {
        // 获取配置的排除文件后缀
        String errorEmailExcludeSuffix = PropertiesUtil.getProperty("error.email.exclude.suffix");
        if (StringUtils.isEmpty(uri) || StringUtils.isEmpty(errorEmailExcludeSuffix)) {
            return true;
        }
        List<String> endWith = Arrays.asList(errorEmailExcludeSuffix.split(","));
        for (String str : endWith) {
            if (uri.endsWith(str)) {
                return false;
            }
        }
        return true;
    }

}
