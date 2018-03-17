<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/adminHead.jsp"/>
    <title>后台管理</title>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="../../base/adminHeader.jsp"/>
    <jsp:include page="../../base/adminSide.jsp"/>

    <div class="layui-body">

        <div class="layui-row padding-l-15">
            <span class="layui-breadcrumb">
                <a href="${pageContext.request.contextPath}/admin/index"><i class="layui-icon">&#xe68e;</i></a>
                <a><cite>文章</cite></a>
            </span>
        </div>

        <div class="layui-row">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-15">
                <c:choose>
                    <c:when test="${not empty noteList && noteList.size() gt 0}">
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <form class="layui-form">
                                <div class="layui-col-xs6 layui-col-sm4 layui-col-md3 padding-r-30">
                                    <input name="keyword" placeholder="ID、标题" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-col-xs6 layui-col-sm4 layui-col-md3 padding-r-30">
                                    <select name="noteStatus" lay-filter="noteStatus">
                                        <option value="">全部状态</option>
                                        <c:if test="${not empty noteStatusList && noteStatusList.size() gt 0}">
                                            <c:forEach items="${noteStatusList}" var="noteStatus">
                                                <option value="${noteStatus.dicCode}">${noteStatus.dicName}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="layui-col-xs6 layui-col-sm4 layui-col-md3 padding-r-30">
                                    <select name="noteCategory" lay-filter="noteCategory" lay-search>
                                        <option value="">全部分类</option>
                                        <c:if test="${not empty noteCategoryList && noteCategoryList.size() gt 0}">
                                            <c:forEach items="${noteCategoryList}" var="noteCategory">
                                                <option value="${noteCategory}">${noteCategory}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="layui-col-xs6 layui-col-sm4 layui-col-md3 padding-r-30">
                                    <select name="deleted" lay-filter="deleted">
                                        <option value="">全部</option>
                                        <option value="1">已删除</option>
                                        <option value="0">未删除</option>
                                    </select>
                                </div>
                            </form>

                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-20">
                                <table class="layui-table">
                                    <colgroup>
                                        <col>
                                        <col width="30%">
                                        <col>
                                        <col>
                                        <col>
                                        <col>
                                        <col>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>标题</th>
                                        <th>状态</th>
                                        <th>分类</th>
                                        <th>用户ID</th>
                                        <th>创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="noteListContent">
                                    <c:forEach items="${noteList}" var="note">
                                        <tr id="note-${note.noteId}">
                                            <td>${note.noteId}</td>
                                            <td>${note.noteTitle}</td>
                                            <td>${note.noteStatusName}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${not empty note.fmtCategoryList}">${note.fmtCategoryList}</c:when>
                                                    <c:otherwise>--</c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td title="${note.userName}">${note.userId}</td>
                                            <td>${note.fmtCreateTime}</td>
                                            <td>
                                                <div class="layui-btn-group">
                                                    <button class="layui-btn layui-btn-sm margin-t-5 auditBtn"
                                                            data-note-id="${note.noteId}" title="审核">
                                                        <i class="layui-icon">&#xe642;</i>
                                                    </button>
                                                    <button class="layui-btn layui-btn-sm margin-t-5 removeBtn"
                                                            data-note-id="${note.noteId}" title="删除">
                                                        <i class="layui-icon">&#xe640;</i>
                                                    </button>
                                                    <button class="layui-btn layui-btn-sm margin-t-5 preViewBtn"
                                                            data-note-id="${note.noteId}" title="预览">
                                                        <i class="layui-icon">&#xe602;</i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                                <div id="notePageContent"></div>
                            </div>
                        </div>
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
        </div>
    </div>
    <input type="hidden" id="pageSize" value="${pageSize}">
    <input type="hidden" id="dataCount" value="${dataCount}">
    <jsp:include page="../../base/adminFooter.jsp"/>
    <script src="${pageContext.request.contextPath}/resources/js/biz/admin/note/list.js"></script>
    <script>


    </script>
</div>
</body>
</html>