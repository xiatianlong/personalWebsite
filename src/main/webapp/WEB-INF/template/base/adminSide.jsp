<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2017/12/3
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item <c:if test="${not empty admin_menu_index && admin_menu_index}">layui-this</c:if> ">
                <a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
            <li class="layui-nav-item <c:if test="${not empty admin_menu_article && admin_menu_article}">layui-this</c:if> ">
                <a href="${pageContext.request.contextPath}/admin/article/list">文章</a></li>
            <li class="layui-nav-item <c:if test="${not empty admin_menu_note && admin_menu_note}">layui-this</c:if> ">
                <a href="${pageContext.request.contextPath}/admin/note/list">笔记</a></li>
            <li class="layui-nav-item <c:if test="${not empty admin_menu_user && admin_menu_user}">layui-this</c:if> ">
                <a href="${pageContext.request.contextPath}/admin/user/list">用户</a></li>
            <li class="layui-nav-item"><a>焦点图</a></li>
            <li class="layui-nav-item"><a>公告</a></li>
        </ul>
    </div>
</div>
