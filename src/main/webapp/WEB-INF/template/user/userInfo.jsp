<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>用户信息 - ${user.userName}</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/biz/user/userInfo.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/dataTables/css/jquery.dataTables.min.css">
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
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block text-c padding-t-30 padding-b-30">
            <div id="personalCenterHeadImg"><img src="${user.userHeadImg}"></div>
            <div class="margin-t-10 font-size-22">${user.userName}</div>
            <div class="margin-t-5 gray font-size-14">${user.fmtCreateTime} 加入</div>
            <div class="margin-t-5 gray font-size-14">${user.userIntroduction}</div>
        </div>
    </div>

    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block text-c padding-t-30 padding-b-30">
            <c:choose>
                <c:when test="${user.open}">
                    <c:if test="${not empty articleList && articleList.size() gt 0}">
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-b-20">
                            <blockquote class="layui-elem-quote text-l">TA发布的文章</blockquote>
                            <table class="userPublishTable display">
                                <thead>
                                <tr>
                                    <th>创建时间</th>
                                    <th>标题</th>
                                    <th>访问量</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${articleList}" var="article">
                                    <tr>
                                        <td class="text-c">${article.fmtCreateTimeCN}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/article/${article.articleId}"
                                               target="_blank">${article.articleTitle}</a>
                                        </td>
                                        <td class="text-c">${article.articleViewsCnt}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>

                    <c:if test="${not empty noteList && noteList.size() gt 0}">
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <blockquote class="layui-elem-quote text-l">TA发布的笔记</blockquote>
                            <table class="userPublishTable display">
                                <thead>
                                <tr>
                                    <th>创建时间</th>
                                    <th>标题</th>
                                    <th>访问量</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${noteList}" var="note">
                                    <tr>
                                        <td class="text-c">${note.fmtCreateTimeCN}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/note/${note.noteId}"
                                               target="_blank">${note.noteTitle}</a>
                                        </td>
                                        <td class="text-c">${note.noteViewsCnt}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 gray">暂未开放个人中心</div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

</div>

<jsp:include page="../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/plugins/dataTables/js/jquery.dataTables.js"></script>
<script>
    var userPublishTable = $('.userPublishTable').DataTable({
        "lengthMenu": [5, 15, 30, 20],
        "columns": [
            null,
            null,
            {"orderable": false}
        ],
        "order": [[0, 'desc']],
        language: common.dataTableLanguage(),
        "deferRender": true
    });
</script>
</body>
</html>