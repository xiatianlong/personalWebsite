<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/head.jsp"/>
    <title>Title</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/personalCenter.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
        <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="${pageContext.request.contextPath}/member/personalCenter">个人中心</a>
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
                    我是一偏文章的标题我是一偏文章的标题我是一偏文章的标题
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>文章状态</legend>
                <div class="layui-field-box">
                    <span class="layui-badge">审核中</span>
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>文章发布时间</legend>
                <div class="layui-field-box">
                    <div>创建时间：2012/12/12 15:15:15</div>
                    <div class="margin-t-10">最后更新时间：2012/12/12 15:15:15</div>
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>文章访问数</legend>
                <div class="layui-field-box">
                    <span class="layui-badge-rim red">1000</span>
                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>评论次数</legend>
                <div class="layui-field-box">
                    <span class="layui-badge-rim red">50</span>
                </div>
            </fieldset>


            <a class="layui-btn layui-btn-sm layui-btn-radius layui-btn-normal">去查看</a>
            <a class="layui-btn layui-btn-sm layui-btn-radius">去编辑</a>
            <a class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger" id="removeArticle">删除文章</a>

        </div>
    </div>
    <!--上部部分end-->




</div>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!-- 你的HTML代码 -->

<jsp:include page="../../base/footer.jsp"/>
<script>
    layui.use(['layer'], function() {
        var layer = layui.layer;
        $("#removeArticle").on('click', function(){

            layer.confirm('确定要删除这篇文章?', {icon: 3, title:'提示', btn: ['取消','确认']}, function(index){
                layer.close(index);
            }, function(){
                layer.msg('删除成功！', {icon: 6, shade: 0.01}, function(){
                    // do something
                    console.log("关闭了");
                });
            });
        });

    });
</script>
</body>
</html>