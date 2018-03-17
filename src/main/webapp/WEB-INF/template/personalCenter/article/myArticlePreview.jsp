<%@ page import="com.personalWebsite.common.enums.ArticleStatus" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="DRAFT" value="<%=ArticleStatus.DRAFT.getCode()%>" scope="request"/>
<c:set var="UNDER_REVIEW" value="<%=ArticleStatus.UNDER_REVIEW.getCode()%>" scope="request"/>
<c:set var="REVIEW_PASSED" value="<%=ArticleStatus.REVIEW_PASSED.getCode()%>" scope="request"/>
<c:set var="REVIEW_NOT_PASSED" value="<%=ArticleStatus.REVIEW_NOT_PASSED.getCode()%>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/head.jsp"/>
    <title>${article.articleTitle}</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/wangEditor.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/xtl-content.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
        <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="${pageContext.request.contextPath}/member/personalCenter">个人中心</a>
         <a href="${pageContext.request.contextPath}/member/article/list">我的文章</a>
        <a><cite>文章预览</cite></a>
    </span>
</div>


<div class="layui-container">


    <!--上部部分begin-->
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-20 padding-b-20 xtl-content">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 title">
                ${article.articleTitle}
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 category">
                <c:forEach items="${article.categoryList}" var="category">
                    <span class="layui-badge-rim red margin-r-10">${category}</span>
                </c:forEach>
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 content w-e-text">
                ${article.articleContent}
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 footer">
                ${article.userName}<br>
                ${article.fmtCreateTime}
            </div>
        </div>
    </div>
    <!--上部部分end-->


</div>
<!-- 你的HTML代码 -->

<jsp:include page="../../base/footer.jsp"/>
<script>


</script>
</body>
</html>