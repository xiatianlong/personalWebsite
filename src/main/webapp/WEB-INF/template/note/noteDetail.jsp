<%@ page import="com.personalWebsite.common.enums.NoteStatus" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="DRAFT" value="<%=NoteStatus.DRAFT.getCode()%>" scope="request"/>
<c:set var="UNDER_REVIEW" value="<%=NoteStatus.UNDER_REVIEW.getCode()%>" scope="request"/>
<c:set var="REVIEW_PASSED" value="<%=NoteStatus.REVIEW_PASSED.getCode()%>" scope="request"/>
<c:set var="REVIEW_NOT_PASSED" value="<%=NoteStatus.REVIEW_NOT_PASSED.getCode()%>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>${note.noteTitle}</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.1.0/wangEditor.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/xtl-content.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
        <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="${pageContext.request.contextPath}/note">笔记</a>
        <a><cite>笔记详情</cite></a>
    </span>
</div>


<div class="layui-container">


    <!--上部部分begin-->
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-20 padding-b-20 xtl-content">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 title">
                ${note.noteTitle}
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 category">
                <c:forEach items="${note.categoryList}" var="category">
                    <span class="layui-badge-rim red margin-r-10">${category}</span>
                </c:forEach>
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 content w-e-text">
                ${note.noteContent}
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 footer">
                <a class="create-user" href="${pageContext.request.contextPath}/user/${note.userId}"
                   target="_blank">${note.userName}</a><br>
                ${note.fmtCreateTime}
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 text-c font-size-14" id="collectionContent">
                <c:choose>
                    <c:when test="${not empty isCollection && isCollection}">
                        <i class="fa fa-star collectionBtn" aria-hidden="true"></i>
                    </c:when>
                    <c:otherwise>
                        <i class="fa fa-star-o collectionBtn" aria-hidden="true" id="collectionBtn"></i>
                    </c:otherwise>
                </c:choose>
                <div>收藏</div>
            </div>
            <input type="hidden" id="noteId" value="${note.noteId}">
        </div>
    </div>
    <!--上部部分end-->

    <!--评论部分begin-->
    <div class="layui-row">
        <c:set value="${note.noteId}" var="commentBizId" scope="request"/>
        <c:set value="004002" var="commentBizType" scope="request"/>
        <c:set value="${dataList}" var="messageDataList" scope="request"/>
        <c:set value="${totalCnt}" var="messageTotalCnt" scope="request"/>
        <c:set value="${pageNo}" var="messagePageNo" scope="request"/>
        <c:set value="${pageSize}" var="messagePageSize" scope="request"/>
        <jsp:include page="../base/message.jsp"/>
    </div>
    <!--评论部分end-->


</div>

<jsp:include page="../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/js/biz/note/noteDetail.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/biz/message.js"></script>
</body>
</html>