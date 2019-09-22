<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>关于</title>
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
      <a><cite>关于</cite></a>
    </span>
</div>


<div class="layui-container">


    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-30 padding-b-30">

            <fieldset class="margin-b-20">
                <legend>关于我</legend>
                <div class="layui-field-box layui-row">
                    <div class="layui-col-xs12 layui-col-sm3 layui-col-md2 text-c">
                        <img class="layui-circle"
                             src="${pageContext.request.contextPath}/resources/images/xiatianlong.jpg"
                             style="width: 100%;max-width: 100px;">
                    </div>
                    <div class="layui-col-xs12 layui-col-sm9 layui-col-md10 layui-text">
                        <ul>
                            <li>初级程序员</li>
                            <li>喜做饭</li>
                            <li>减肥ing</li>
                        </ul>
                    </div>

                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>关于网站</legend>
                <div class="layui-field-box layui-text">
                    <ul>
                        <li>偶尔记录收获心得、偶尔啰嗦几句生活感悟。</li>
                        <li>限制于水平问题，可能会有不确定性bug出现。（系统出现异常，错误信息的邮件会自动发送到我邮箱）</li>
                        <li>大家有任何功能上的建议欢迎提出，但是我不一定会改。</li>
                    </ul>
                </div>
            </fieldset>

        </div>

    </div>


</div>

<jsp:include page="../base/footer.jsp"/>
</body>
</html>