<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.personalWebsite.common.enums.NoteStatus" %>
<c:set var="DRAFT" value="<%=NoteStatus.DRAFT.getCode()%>" scope="request"/>
<c:set var="UNDER_REVIEW" value="<%=NoteStatus.UNDER_REVIEW.getCode()%>" scope="request"/>
<c:set var="REVIEW_PASSED" value="<%=NoteStatus.REVIEW_PASSED.getCode()%>" scope="request"/>
<c:set var="REVIEW_NOT_PASSED" value="<%=NoteStatus.REVIEW_NOT_PASSED.getCode()%>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/head.jsp"/>
    <title>Title</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/note/myPublishNoteList.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
        <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="${pageContext.request.contextPath}/member/personalCenter">个人中心</a>
        <a><cite>我的笔记</cite></a>
    </span>
</div>

<div class="layui-container">

    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" id="myNoteListContent">
                <c:choose>
                    <c:when test="${not empty myNoteList && myNoteList.size() gt 0}">
                        <c:forEach var="note" items="${myNoteList}">
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
                <jsp:include page="../../base/publish&Message.jsp"/>
            </div>
            <%--异步查询条件表单 begin--%>
            <form id="myNoteListQuestForm" class="hide"></form>
            <%--异步查询条件表单 end--%>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">笔记状态</div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10" id="article-status-content">
                    <a class="layui-btn layui-btn-primary layui-btn-sm query-note-status"
                       data-value="${DRAFT}">草稿</a>
                    <a class="layui-btn layui-btn-warm layui-btn-sm query-note-status"
                       data-value="${UNDER_REVIEW}">审核中</a>
                    <a class="layui-btn layui-btn-sm query-note-status" data-value="${REVIEW_PASSED}">已发布</a>
                    <a class="layui-btn layui-btn-danger layui-btn-sm query-note-status"
                       data-value="${REVIEW_NOT_PASSED}">审核未通过</a>
                </div>
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
    </div>

</div>

<jsp:include page="../../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/js/biz/member/note/myPublishNoteList.js"></script>
</body>
</html>