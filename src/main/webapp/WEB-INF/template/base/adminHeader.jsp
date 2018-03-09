<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2017/12/3
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="layui-header">
    <div class="layui-logo horizontal-vertical-middle">
        <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_32px.png">
        &nbsp;&nbsp;&nbsp;后台管理
    </div>

    <ul class="layui-nav layui-layout-right">
        <c:choose>
            <c:when test="${not empty LOGIN_USER}">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="${LOGIN_USER.headImg}" class="layui-nav-img">
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/home">首页</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/login/logout">注销</a></dd>
                    </dl>
                </li>
            </c:when>
            <c:otherwise>
                <li class="layui-nav-item">
                    <a href="javascript:" id="qq-login-btn"><i class="fa fa-qq font-size-18"
                                                               aria-hidden="true"></i></a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
<script>
    <%-- qq登录按钮点击 --%>
    var qqLoginBtn = document.getElementById("qq-login-btn");
    if (qqLoginBtn) {
        qqLoginBtn.addEventListener("click", function () {
            window.location.href = "${pageContext.request.contextPath}/login/qq?qqRequestUrl=" + window.location.href;
        })
    }
</script>