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
        <a><cite>文章详情</cite></a>
    </span>
</div>


<div class="layui-container">


    <!--上部部分begin-->
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-30 padding-b-30">
            <fieldset class="margin-b-20">
                <legend>文章标题</legend>
                <div class="layui-field-box">
                    ${article.articleTitle}
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>文章状态</legend>
                <div class="layui-field-box">
                    <c:choose>
                        <c:when test="${DRAFT eq article.articleStatusCode}"> <span
                                class="layui-badge layui-bg-gray">草稿</span></c:when>
                        <c:when test="${UNDER_REVIEW eq article.articleStatusCode}"> <span
                                class="layui-badge layui-bg-orange">审核中</span></c:when>
                        <c:when test="${REVIEW_PASSED eq article.articleStatusCode}"> <span
                                class="layui-badge layui-bg-green">已发布</span></c:when>
                        <c:when test="${REVIEW_NOT_PASSED eq article.articleStatusCode}"> <span
                                class="layui-badge layui-bg-red">审核不通过</span></c:when>
                    </c:choose>
                    <c:if test="${not empty auditMemo}">
                        <span class="red">&nbsp;（${auditMemo}）</span>
                    </c:if>
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>文章发布时间</legend>
                <div class="layui-field-box">
                    <div>创建时间：${article.fmtCreateTime}</div>
                    <div class="margin-t-10">最后更新时间：${article.fmtUpdateTime}</div>
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>文章访问数</legend>
                <div class="layui-field-box">
                    <span class="layui-badge-rim red">${article.articleViewsCnt}</span>
                </div>
            </fieldset>

            <c:if test="${not empty article.categoryList && article.categoryList.size() gt 0}">
                <fieldset class="margin-b-20">
                    <legend>文章所属分类</legend>
                    <div class="layui-field-box">
                        <c:forEach items="${article.categoryList}" var="category">
                            <span class="layui-badge-rim red margin-r-10">${category}</span>
                        </c:forEach>
                    </div>
                </fieldset>
            </c:if>


            <a href="${pageContext.request.contextPath}/member/article/preview/${article.articleId}"
               class="layui-btn layui-btn-sm layui-btn-radius layui-btn-normal">去查看</a>
            <a href="${pageContext.request.contextPath}/member/article/update/${article.articleId}"
               class="layui-btn layui-btn-sm layui-btn-radius">去编辑</a>
            <a class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger" data-article-id="${article.articleId}"
               id="removeArticle">删除文章</a>

        </div>
    </div>
    <!--上部部分end-->


</div>
<!-- 你的HTML代码 -->

<jsp:include page="../../base/footer.jsp"/>
<script>

    // 删除文章
    $("#removeArticle").on('click', function () {
        var articleId = $(this).data("articleId");
        layer.confirm('确定要删除这篇文章?', {icon: 3, title: '提示', btn: ['取消', '确认']}, function (index) {
            layer.close(index);
        }, function () {
            common.ajax({
                url: "/member/article/delete/" + articleId,
                type: "POST",
                success: function (res) {
                    if (res.result === 'success') {
                        layer.msg('删除成功！', {icon: 6, shade: 0.01}, function () {
                            window.location.href = "/member/article/list";
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