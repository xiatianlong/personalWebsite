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
    <jsp:include page="../../base/head.jsp"/>
    <title>${note.noteTitle}</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.1.0/wangEditor.min.css">
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
         <a href="${pageContext.request.contextPath}/member/note/list">我的笔记</a>
        <a><cite>笔记预览</cite></a>
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
                ${note.userName}<br>
                ${note.fmtCreateTime}
            </div>
        </div>
    </div>
    <!--上部部分end-->


</div>

<jsp:include page="../../base/footer.jsp"/>
<script>


</script>
</body>
</html>