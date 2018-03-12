package com.personalWebsite.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台菜单拦截器
 * Created by xiatianlong on 2018/03/11.
 */
public class AdminMenuInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 获取请求uri
        String requestUri = request.getRequestURI();

        if (requestUri.startsWith("/admin/index")) {
            // 菜单首页选中
            request.setAttribute("admin_menu_index", true);
        } else if (requestUri.startsWith("/admin/article")) {
            // 菜单文章选中
            request.setAttribute("admin_menu_article", true);
        } else if (requestUri.startsWith("/admin/note")) {
            // 菜单笔记选中
            request.setAttribute("admin_menu_note", true);
        } else if (requestUri.startsWith("/admin/user")) {
            // 菜单用户选中
            request.setAttribute("admin_menu_user", true);
        } else if (requestUri.startsWith("/admin/user")) {
            // 菜单焦点图选中
            request.setAttribute("admin_menu_banner", true);
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
