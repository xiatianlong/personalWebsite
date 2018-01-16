<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
        <c:set value="${dataList}" var="messageDataList" scope="request"/>
        <c:set value="${totalCnt}" var="messageTotalCnt" scope="request"/>
        <c:set value="${pageNo}" var="messagePageNo" scope="request"/>
        <c:set value="${pageSize}" var="messagePageSize" scope="request"/>
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