<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>${user.userName}</title>
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
      <a><cite>${user.userName}</cite></a>
    </span>
</div>
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">
            用户信息
        </div>
    </div>
</div>

<jsp:include page="../base/footer.jsp"/>
</body>
</html>