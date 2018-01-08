package com.personalWebsite.common.exception;

import com.personalWebsite.common.system.Constant;
import com.personalWebsite.entity.EmailRecordEntity;
import com.personalWebsite.model.response.AsynchronousResult;
import com.personalWebsite.service.EmailRecordService;
import com.personalWebsite.utils.AsynchronousRequestUtil;
import com.personalWebsite.utils.DateUtil;
import com.personalWebsite.utils.SerializeUtil;
import com.personalWebsite.utils.UUIDUtil;
import com.personalWebsite.vo.UserInfo;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
        try {
            ApplicationException applicationException;

            // 如果是系统手动抛出的异常直接转换
            if (ex instanceof ApplicationException) {
                applicationException = (ApplicationException) ex;
            } else {
                // 其他未知异常
                applicationException = new ApplicationException(getMessage("error.unknown.exception"));
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
                map.put("requestUrl", request.getRequestURL());
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
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintStream pout = new PrintStream(out);
                ex.printStackTrace(pout);
                String ret = new String(out.toByteArray());
                pout.close();
                try {
                    out.close();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
                map.put("errorLogText", ret);
                String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
                emailRecordEntity.setEmailContent(content);
                emailRecordService.saveEmailRecord(emailRecordEntity);
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
}
