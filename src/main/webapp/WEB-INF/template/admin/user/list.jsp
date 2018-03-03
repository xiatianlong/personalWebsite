<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/adminHead.jsp"/>
    <title>layout 后台大布局 - Layui</title>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="../../base/adminHeader.jsp"/>
    <jsp:include page="../../base/adminSide.jsp"/>

    <div class="layui-body">

        <div class="layui-row padding-l-15">
            <span class="layui-breadcrumb">
                <a href="${pageContext.request.contextPath}/admin/index"><i class="layui-icon">&#xe68e;</i></a>
                <a><cite>用户</cite></a>
            </span>
        </div>

        <div class="layui-row">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-15">
                <c:choose>
                    <c:when test="${not empty userList && userList.size() gt 0}">
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" style="overflow: auto;">
                            <table class="display" id="userListTable">
                                <thead>
                                <tr>
                                    <th>用户ID</th>
                                    <th>用户昵称</th>
                                    <th>性别</th>
                                    <th>邮箱</th>
                                    <th>QQ</th>
                                    <th>open</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="user">
                                    <tr class="text-c">
                                        <td>${user.userId}</td>
                                        <td>${user.userName}</td>
                                        <td>${user.userGender}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${not empty user.userEmail}">${user.userEmail}</c:when>
                                                <c:otherwise>--</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${not empty user.userQQ}">${user.userQQ}</c:when>
                                                <c:otherwise>--</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${not empty user.open && user.open}">开放</c:when>
                                                <c:otherwise>不开放</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <div class="layui-btn-group">
                                                <button class="layui-btn layui-btn-sm userDetailBtn"
                                                        data-user-id="${user.userId}" title="查看详情">
                                                    <i class="layui-icon">&#xe60b;</i>
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 horizontal-vertical-middle xtl-blank-page">
                            <div><img src="${pageContext.request.contextPath}/resources/images/fish.png"
                                      draggable="false"></div>
                            <div>没有搜索到结果....</div>
                        </div>
                    </c:otherwise>
                </c:choose>


            </div>
        </div>
    </div>
    <jsp:include page="../../base/adminFooter.jsp"/>
    <script src="${pageContext.request.contextPath}/resources/js/biz/admin/user/userList.js"></script>
</div>
</body>
</html>