<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2017/12/3
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="xtl-header layui-bg-black">
    <nav class="layui-container">
        <a href="" class="xtl-logo"><img
                src="${pageContext.request.contextPath}/resources/images/icon/website_logo_32px.png"></a>
        <ul class="layui-nav">
            <li class="layui-nav-item <c:if test="${not empty menu_home && menu_home}">layui-this</c:if>">
                <a href="${pageContext.request.contextPath}/home">首页</a>
            </li>
            <li class="layui-nav-item <c:if test="${not empty menu_article && menu_article}">layui-this</c:if>">
                <a href="${pageContext.request.contextPath}/article">文章</a>
            </li>
            <li class="layui-nav-item <c:if test="${not empty menu_note && menu_note}">layui-this</c:if>">
                <a href="${pageContext.request.contextPath}/note">笔记</a>
            </li>
            <li class="layui-nav-item <c:if test="${not empty menu_message && menu_message}">layui-this</c:if>">
                <a href="${pageContext.request.contextPath}/message">留言</a>
            </li>
            <li class="layui-nav-item <c:if test="${not empty menu_about && menu_about}">layui-this</c:if>">
                <a href="${pageContext.request.contextPath}/about">关于</a>
            </li>
            <c:choose>
                <c:when test="${not empty LOGIN_USER}">
                    <li class="layui-nav-item float-r <c:if test="${not empty menu_member && menu_member}">layui-this</c:if>">
                        <a href="javascript:;"><img src="${LOGIN_USER.headImg}" id="xtl-header-user-img"></a>
                        <dl class="layui-nav-child">
                            <dd><a href="${pageContext.request.contextPath}/member/personalCenter">个人中心</a></dd>
                            <dd><a href="">我的文章</a></dd>
                            <dd><a href="">我的笔记</a></dd>
                        </dl>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="layui-nav-item float-r <c:if test="${not empty menu_member && menu_member}">layui-this</c:if>">
                        <a href="javascript:;" id="qq-login-btn"><i class="fa fa-qq font-size-18"
                                                                    aria-hidden="true"></i></a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>
<script>
    <%-- qq登录按钮点击 --%>
    var qqLoginBtn = document.getElementById("qq-login-btn");
    if (qqLoginBtn) {
        qqLoginBtn.addEventListener("click", function () {
            window.location.href = "${pageContext.request.contextPath}/login/qq?qqRequestUrl=" + window.location.href;
        })
    }
    <%-- 当前用户是否登录，全局js变量，将登录的用户信息放入js全局对象中 --%>
    var xtlUserIsLogin = ${not empty LOGIN_USER}, xtlCurrentUser = '';
    <c:if test="${not empty LOGIN_USER_JSON}">
        if (xtlUserIsLogin){
            xtlCurrentUser = ${LOGIN_USER_JSON};
        }
    </c:if>

</script>
