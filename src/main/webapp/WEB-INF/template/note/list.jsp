<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>笔记列表</title>

</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
      <a><cite>笔记</cite></a>
    </span>
</div>
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" id="noteListContent">
                <c:choose>
                    <c:when test="${not empty noteList && noteList.size() gt 0}">
                        <c:forEach items="${noteList}" var="note">
                            <c:set var="note" value="${note}" scope="request"/>
                            <jsp:include page="noteCard.jsp"/>
                        </c:forEach>
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
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-5 text-c bg-white <c:if test="${empty hasMore || !hasMore}">hide</c:if> "
                 id="hasMoreContent">
                <span id="loadMore">加载更多 <i class="fa fa-chevron-down" aria-hidden="true"></i></span>
            </div>
        </div>

        <div class="layui-col-xs-12 layui-col-sm12 layui-col-md4">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">
                <jsp:include page="../base/publish&Message.jsp" />
            </div>

            <c:if test="${not empty noteCategoryList && noteCategoryList.size() gt 0}">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">笔记分类</div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10 article-classification">
                        <c:forEach items="${noteCategoryList}" var="category">
                            <a class="layui-btn layui-btn-primary layui-btn-sm query-note-category">${category}</a>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
        </div>

        <%--异步查询条件表单 begin--%>
        <form id="noteListQuestForm" class="hide"></form>
        <%--异步查询条件表单 end--%>
        
    </div>
</div>

<jsp:include page="../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/js/biz/note/noteList.js"></script>
</body>
</html>