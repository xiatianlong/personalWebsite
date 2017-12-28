package com.personalWebsite.common.exception;

import com.personalWebsite.model.AsynchronousResult;
import com.personalWebsite.utils.AsynchronousRequestUtil;
import com.personalWebsite.utils.SerializeUtil;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiatianlong on 2017/12/28.
 */
public class ApplicationExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // 打印异常信息
        System.out.println("进入异常处理--------------");
        ex.printStackTrace();

        ApplicationException applicationException = null;

        // 如果是系统手动抛出的异常直接转换
        if (ex instanceof ApplicationException) {
            applicationException = (ApplicationException) ex;
        } else {
            // 其他位置异常
            applicationException = new ApplicationException("系统出现未知异常");
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
                request.getRequestDispatcher("/exception").forward(request, response);
                return new ModelAndView();

            }
        } catch (Exception e) {

        }

        return new ModelAndView();
    }
}
