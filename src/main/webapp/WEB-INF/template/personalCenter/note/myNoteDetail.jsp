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
        <a><cite>笔记详情</cite></a>
    </span>
</div>


<div class="layui-container">


    <!--上部部分begin-->
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-30 padding-b-30">
            <fieldset class="margin-b-20">
                <legend>笔记标题</legend>
                <div class="layui-field-box">
                    ${note.noteTitle}
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>笔记状态</legend>
                <div class="layui-field-box">
                    <c:choose>
                        <c:when test="${DRAFT eq note.noteStatus}"> <span
                                class="layui-badge layui-bg-gray">草稿</span></c:when>
                        <c:when test="${UNDER_REVIEW eq note.noteStatus}"> <span
                                class="layui-badge layui-bg-orange">审核中</span></c:when>
                        <c:when test="${REVIEW_PASSED eq note.noteStatus}"> <span
                                class="layui-badge layui-bg-green">已发布</span></c:when>
                        <c:when test="${REVIEW_NOT_PASSED eq note.noteStatus}"> <span
                                class="layui-badge layui-bg-red">审核不通过</span></c:when>
                    </c:choose>
                    <c:if test="${not empty auditMemo}">
                        <span class="red">&nbsp;（${auditMemo}）</span>
                    </c:if>
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>笔记发布时间</legend>
                <div class="layui-field-box">
                    <div>创建时间：${note.fmtCreateTime}</div>
                    <div class="margin-t-10">最后更新时间：${note.fmtUpdateTime}</div>
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>笔记访问数</legend>
                <div class="layui-field-box">
                    <span class="layui-badge-rim red">${note.noteViewCnt}</span>
                </div>
            </fieldset>

            <c:if test="${not empty note.categoryList && note.categoryList.size() gt 0}">
                <fieldset class="margin-b-20">
                    <legend>笔记所属分类</legend>
                    <div class="layui-field-box">
                        <c:forEach items="${note.categoryList}" var="category">
                            <span class="layui-badge-rim red margin-r-10">${category}</span>
                        </c:forEach>
                    </div>
                </fieldset>
            </c:if>


            <a href="${pageContext.request.contextPath}/member/note/preview/${note.noteId}"
               class="layui-btn layui-btn-sm layui-btn-radius layui-btn-normal">去查看</a>
            <a href="${pageContext.request.contextPath}/member/note/update/${note.noteId}"
               class="layui-btn layui-btn-sm layui-btn-radius">去编辑</a>
            <a class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger" data-note-id="${note.noteId}"
               id="removeNote">删除笔记</a>

        </div>
    </div>
    <!--上部部分end-->


</div>

<jsp:include page="../../base/footer.jsp"/>
<script>

    // 删除笔记
    $("#removeNote").on('click', function () {
        var noteId = $(this).data("noteId");
        layer.confirm('确定要删除这篇笔记?', {icon: 3, title: '提示', btn: ['取消', '确认']}, function (index) {
            layer.close(index);
        }, function () {
            common.ajax({
                url: "/member/note/delete/" + noteId,
                type: "POST",
                success: function (res) {
                    if (res.result === 'success') {
                        layer.msg('删除成功！', {icon: 6, shade: 0.01}, function () {
                            window.location.href = "/member/note/list";
                        });
                    } else {
                        layer.msg(res.message, {icon: 5, anim: 6});
                    }
                }
            });
        });
    });

</script>
</body>
</html>