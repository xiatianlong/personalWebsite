<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>哎呀、页面找不到了</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/biz/exception/exception.css">
</head>
<body>

<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
            <div id="exceptionContent">
                <div class="vertical-middle">
                    <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_128px.png" alt=""
                         draggable="false">
                    <span>哎呀、出状况了&nbsp;<span style="margin-left: 0">(｡◕ˇ∀ˇ◕)</span></span>
                </div>
                <div>
                    「页面找不到了」
                </div>
                <div>
                    <a href="javascript:history.back(-1)" class="layui-btn layui-btn-normal">
                        <i class="layui-icon">&#xe65c;</i> 返回
                    </a>
                    <a href="${pageContext.request.contextPath}/home" class="layui-btn layui-btn-normal">
                        <i class="layui-icon">&#xe68e;</i> 去首页
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../base/footer.jsp"/>
</body>
</html>