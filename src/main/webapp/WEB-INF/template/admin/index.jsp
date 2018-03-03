<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/adminHead.jsp"/>
    <title>layout 后台大布局 - Layui</title>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="../base/adminHeader.jsp"/>
    <jsp:include page="../base/adminSide.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>
    </div>

    <jsp:include page="../base/adminFooter.jsp"/>
</div>
</body>
</html>