<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.personalWebsite.common.enums.ArticleStatus" %>
<c:set var="DRAFT" value="<%=ArticleStatus.DRAFT.getCode()%>" scope="request"/>
<c:set var="UNDER_REVIEW" value="<%=ArticleStatus.UNDER_REVIEW.getCode()%>" scope="request"/>
<c:set var="REVIEW_PASSED" value="<%=ArticleStatus.REVIEW_PASSED.getCode()%>" scope="request"/>
<c:set var="REVIEW_NOT_PASSED" value="<%=ArticleStatus.REVIEW_NOT_PASSED.getCode()%>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/head.jsp"/>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/article/myPublishArticleList.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="personalCenter.html">个人中心</a>
      <a><cite>我的文章</cite></a>
    </span>
</div>


<div class="layui-container">

    <div class="layui-row layui-col-space15">
        <%--文章列表begin--%>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" id="myArticleListContent">
                <c:choose>
                    <c:when test="${not empty myArticleList && myArticleList.size() gt 0}">
                        <c:forEach var="article" items="${myArticleList}">
                            <c:set var="article" value="${article}" scope="request"/>
                            <jsp:include page="articleCard.jsp"/>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        暂无文章
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-5 text-c bg-white <c:if test="${empty hasMore || !hasMore}">hide</c:if> "
                 id="hasMoreContent">
                <span id="loadMore">加载更多 <i class="fa fa-chevron-down" aria-hidden="true"></i></span>
            </div>
        </div>
        <%--文章列表end--%>
        <div class="layui-col-xs-12 layui-col-sm12 layui-col-md4">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">
                <jsp:include page="../../base/publish&Message.jsp" />
            </div>
            <%--异步查询条件表单 begin--%>
            <form id="myArticleListQuestForm" class="hide"></form>
            <%--异步查询条件表单 end--%>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">文章状态</div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10" id="article-status-content">
                    <a class="layui-btn layui-btn-primary layui-btn-sm query-article-status"
                       data-value="${DRAFT}">草稿</a>
                    <a class="layui-btn layui-btn-warm layui-btn-sm query-article-status" data-value="${UNDER_REVIEW}">审核中</a>
                    <a class="layui-btn layui-btn-sm query-article-status" data-value="${REVIEW_PASSED}">已发布</a>
                    <a class="layui-btn layui-btn-danger layui-btn-sm query-article-status"
                       data-value="${REVIEW_NOT_PASSED}">审核未通过</a>
                </div>
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">文章分类</div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10 article-classification">
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1分类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm active">分类</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类21</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1分类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类21</a>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- 你的HTML代码 -->

<jsp:include page="../../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/js/biz/member/article/myPublishArticleList.js"></script>
</body>
</html>