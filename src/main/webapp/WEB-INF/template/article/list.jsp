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
      <a><cite>文章</cite></a>
    </span>
</div>


<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" id="articleListContent">
                <c:choose>
                    <c:when test="${not empty articleList && articleList.size() gt 0}">
                        <c:forEach items="${articleList}" var="article">
                            <c:set var="article" value="${article}" scope="request"/>
                            <jsp:include page="articleCard.jsp"/>
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

            <c:if test="${not empty articleCategoryList && articleCategoryList.size() gt 0}">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">文章分类</div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10 article-classification">
                        <c:forEach items="${articleCategoryList}" var="category">
                            <a class="layui-btn layui-btn-primary layui-btn-sm query-article-category">${category}</a>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <c:if test="${not empty hotArticleList && hotArticleList.size() gt 0}">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">热门文章</div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                        <c:forEach items="${hotArticleList}" var="hotArticle" varStatus="status">
                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-hot-item <c:if test="${status.index == 0}">padding-t-0</c:if> ">
                                <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                                    <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                                    <a href="${pageContext.request.contextPath}/article/${hotArticle.articleId}"
                                       class="article-hot-title" target="_blank"
                                       title="${hotArticle.articleTitle}">${hotArticle.articleTitle}</a>
                                </div>
                                <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                                    <span><i class="fa fa-eye"
                                             aria-hidden="true"></i> ${hotArticle.articleViewsCnt}</span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <c:if test="${not empty newArticleList && newArticleList.size() gt 0}">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">最新文章</div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                        <c:forEach items="${newArticleList}" var="newArticle" varStatus="status">
                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-new-item <c:if test="${status.index == 0}">padding-t-0</c:if> ">
                                <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                                    <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                                    <a href="${pageContext.request.contextPath}/article/${newArticle.articleId}"
                                       class="article-new-title" target="_blank"
                                       title="${newArticle.articleTitle}">${newArticle.articleTitle}</a>
                                </div>
                                <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                                    <span><i class="fa fa-clock-o" aria-hidden="true"></i> ${newArticle.fmtCreateTimeCN}</span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <%--异步查询条件表单 begin--%>
            <form id="articleListQuestForm" class="hide"></form>
            <%--异步查询条件表单 end--%>

            <%--<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">--%>
            <%--<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">热评用户</div>--%>
            <%--<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">--%>
            <%--<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 hot-comment-user vertical-middle">--%>
            <%--<div class="layui-col-xs1 layui-col-sm1 layui-col-md1"><span class="layui-badge">01</span></div>--%>
            <%--<div class="layui-col-xs3 layui-col-sm3 layui-col-md3 text-c">--%>
            <%--<img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">--%>
            <%--</div>--%>
            <%--<div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-elip">--%>
            <%--<span class="hot-comment-user-name">夏天龙夏天龙夏天龙</span>--%>
            <%--</div>--%>
            <%--<div class="layui-col-xs2 layui-col-sm2 layui-col-md2">--%>
            <%--<i class="fa fa-commenting-o" aria-hidden="true"></i> 100--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 hot-comment-user vertical-middle">--%>
            <%--<div class="layui-col-xs1 layui-col-sm1 layui-col-md1"><span class="layui-badge">02</span></div>--%>
            <%--<div class="layui-col-xs3 layui-col-sm3 layui-col-md3 text-c">--%>
            <%--<img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">--%>
            <%--</div>--%>
            <%--<div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-elip">--%>
            <%--<span class="hot-comment-user-name">夏天龙夏天龙夏天龙</span>--%>
            <%--</div>--%>
            <%--<div class="layui-col-xs2 layui-col-sm2 layui-col-md2">--%>
            <%--<i class="fa fa-commenting-o" aria-hidden="true"></i> 100--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>

        </div>
    </div>
</div>
<!-- 你的HTML代码 -->

<jsp:include page="../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/js/biz/article/articleList.js"></script>
</body>
</html>