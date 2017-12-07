<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>Title</title>
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
      <a><cite>留言</cite></a>
    </span>
</div>


<div class="layui-container">


    <div class="layui-row">

        <!--评论部分begin-->
        <jsp:include page="../base/message.jsp" />
        <!--评论部分end-->

    </div>


</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!-- 你的HTML代码 -->

<jsp:include page="../base/footer.jsp"/>
<%--评论js--%>
<script src="${pageContext.request.contextPath}/resources/js/biz/message.js"></script>
</body>
</html>