package com.personalWebsite.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 菜单拦截器
 * Created by xiatianlong on 2017/12/6.
 */
public class MenuInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 获取请求uri
        String requestUri = request.getRequestURI();

        if (requestUri.startsWith("/home")) {
            // 菜单首页选中
            request.setAttribute("menu_home", true);
        } else if (requestUri.startsWith("/article")) {
            // 菜单文章选中
            request.setAttribute("menu_article", true);
        } else if (requestUri.startsWith("/note")) {
            // 菜单笔记选中
            request.setAttribute("menu_note", true);
        } else if (requestUri.startsWith("/message")) {
            // 菜单留言选中
            request.setAttribute("menu_message", true);
        } else if (requestUri.startsWith("/about")) {
            // 菜单关于选中
            request.setAttribute("menu_about", true);
        } else if (requestUri.startsWith("/member")) {
            // 菜单头像选中
            request.setAttribute("menu_member", true);
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
