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
        <a href="${pageContext.request.contextPath}/about/me">关于</a>
        <a><cite>网站历史</cite></a>
    </span>
</div>


<div class="layui-container">


    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-30 xtl-block padding-t-20">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">19年9月23日</h3>
                        <p>
                            服务器到期忘记了，然后装在服务器上的数据库数据没备份<br>
                            然后啥都没了<br>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">17年6月13日</h3>
                        <p>
                            个人网站第一版上线<br>
                            以记录、学习为目的<br>
                            一整套完整的前后端博客系统<br>
                        <ul>
                            <li>spring/spring mvc、spring data jpa</li>
                            <li>layui</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <div class="layui-timeline-title">过去</div>
                    </div>
                </li>
            </ul>
        </div>


    </div>


</div>

<jsp:include page="../base/footer.jsp"/>
</body>
</html>