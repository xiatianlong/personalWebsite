<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/head.jsp"/>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/article/myPublishArticleList.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="personalCenter.html">个人中心</a>
      <a><cite>我的文章</cite></a>
    </span>
</div>


<div class="layui-container">

    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">

            <jsp:include page="articleCard.jsp" />

        </div>
        <div class="layui-col-xs-12 layui-col-sm12 layui-col-md4">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">
                <jsp:include page="../../base/publish&Message.jsp" />
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">文章状态</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10" id="article-status-content">
                    <a class="layui-btn layui-btn-primary layui-btn-sm active">草稿</a>
                    <a class="layui-btn layui-btn-warm layui-btn-sm active">审核中</a>
                    <a class="layui-btn layui-btn-sm">已发布</a>
                    <a class="layui-btn layui-btn-danger layui-btn-sm">审核未通过</a>
                </div>

            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">文章分类</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10 article-classification">
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1分类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm active">分类</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类21</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1分类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类21</a>
                </div>

            </div>

        </div>
    </div>

</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!-- 你的HTML代码 -->

<jsp:include page="../../base/footer.jsp"/>
</body>
</html>