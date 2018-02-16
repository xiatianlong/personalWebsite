<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/head.jsp"/>
    <title>${note.noteId}</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/wangEditor-fullscreen-plugin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/publish.css">
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
        <a><cite>笔记编辑</cite></a>
    </span>
</div>


<div class="layui-container">

    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-30 padding-b-30">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label">类型</label>
                        <div class="layui-input-block">
                            <input type="radio" lay-filter="type" name="type" value="note" title="笔记" checked>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">标题</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verify="title" name="title" autocomplete="off" placeholder="请输入标题..."
                                   class="layui-input" value="${note.noteTitle}">
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">正文</label>
                        <div class="layui-input-block">
                            <%--富文本区域 begin--%>
                            <div id="xtl-publish-editor"></div>
                            <%--富文本区域 end--%>
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">&nbsp;</label>
                        <div class="layui-input-block">
                            <div class="margin-b-15" id="xtl-publish-tips"><i class="layui-icon">&#xe60b;</i> 发布须知</div>
                            <br>
                            <a class="layui-btn" lay-submit lay-filter="saveToDraftForm">保存为草稿</a>
                            <a class="layui-btn layui-btn-normal" lay-submit lay-filter="saveToUnderReviewForm"><i
                                    class="layui-icon">&#xe609;</i> 直接提交审核</a>
                        </div>
                    </div>

                    <input type="hidden" id="noteId" value="${note.noteId}">
                    <textarea class="hide" id="noteContent">${note.noteContent}</textarea>
                </form>

            </div>

        </div>
    </div>

</div>

<!-- 你的HTML代码 -->

<jsp:include page="../../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/wangEditor-fullscreen-plugin.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/biz/member/note/updateNote.js"></script>
</body>
</html>