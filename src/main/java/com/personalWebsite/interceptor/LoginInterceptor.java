package com.personalWebsite.interceptor;

import com.personalWebsite.common.exception.ApplicationException;
import com.personalWebsite.utils.AsynchronousRequestUtil;
import com.personalWebsite.vo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求是否登录拦截器
 * Created by xiatianlong on 2018/1/8.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("LOGIN_USER");
        if (userInfo == null) {
            if (AsynchronousRequestUtil.isAsynchronousRequest(request)) {
                throw new ApplicationException("请登录");
            } else {
                // 同步从定向去登录
                response.sendRedirect("/login/qq?qqRequestUrl=" + request.getRequestURL());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
