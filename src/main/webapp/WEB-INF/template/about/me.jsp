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
                            <li>想成为全栈的初级java软件工程师</li>
                            <li>怀揣着梦想而又享受平凡生活的年轻人</li>
                        </ul>
                    </div>

                </div>
            </fieldset>

            <fieldset class="margin-b-20">
                <legend>关于网站</legend>
                <div class="layui-field-box layui-text">
                    <ul>
                        <li>建站目的一是为了记录工作、生活中的点滴，更是为了作为学习用途。</li>
                        <li>建站主要是为了学习，所以在功能上暂时没有方向，想到什么就做什么，想做什么就做什么。</li>
                        <li>如果再访问过程中不小心发现了什么“小彩蛋”，不要紧张，很有可能是我正在内测的功能</li>
                        <li>会不定期发布内容或者功能，具体周期视工作繁忙程度决定。</li>
                        <li>限制于水平问题，可能会有不确定性bug出现，欢迎向我留言，不胜感激。（系统出现异常，错误信息的邮件会自动发送到我邮箱）</li>
                        <li>限制于审美，UI有宝贵建议请不吝赐教</li>
                        <li>大家有任何功能上的建议欢迎提出，极有可能会在下个版本中发布上线。</li>
                    </ul>
                </div>
            </fieldset>

        </div>

    </div>


</div>

<jsp:include page="../base/footer.jsp"/>
</body>
</html>