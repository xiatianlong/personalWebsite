<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/head.jsp"/>
    <title>我的收藏列表</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/plugins/dataTables/css/jquery.dataTables.min.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
        <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="${pageContext.request.contextPath}/member/personalCenter">个人中心</a>
        <a><cite>我的收藏</cite></a>
    </span>
</div>


<div class="layui-container">


    <!--上部部分begin-->
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-10 padding-b-10">

            <c:choose>
                <c:when test="${not empty collectionMap}">
                    <c:forEach items="${collectionMap}" var="map">
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-b-20">
                            <blockquote class="layui-elem-quote">${map.key}</blockquote>
                            <table class="collectionTable display">
                                <thead>
                                <tr>
                                    <th>创建时间</th>
                                    <th>标题</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${map.value}" var="collection">
                                    <tr>
                                        <td class="text-c">${collection.createTime}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${collection.visible}">
                                                    <c:choose>
                                                        <c:when test="${collection.bizType eq '001001'}">
                                                            <a href="${pageContext.request.contextPath}/article/${collection.bizId}"
                                                               target="_blank">${collection.title}</a>
                                                        </c:when>
                                                        <c:when test="${collection.bizType eq '001002'}">
                                                            <a href="${pageContext.request.contextPath}/note/${collection.bizId}"
                                                               target="_blank">${collection.title}</a>
                                                        </c:when>
                                                    </c:choose>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:choose>
                                                        <c:when test="${collection.bizType eq '001001'}">
                                                            <a>${collection.title}</a>&nbsp;<span class="layui-badge">已失效</span>
                                                        </c:when>
                                                        <c:when test="${collection.bizType eq '001002'}">
                                                            <a>${collection.title}</a>&nbsp;<span class="layui-badge">已失效</span>
                                                        </c:when>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="text-c">
                                            <div class="layui-btn-group">
                                                <button class="layui-btn layui-btn-sm collectionRemoveBtn" title="删除"
                                                        data-biz-type="${collection.bizType}"
                                                        data-biz-id="${collection.bizId}">
                                                    <i class="layui-icon">&#xe640;</i>
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:forEach>
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
    <!--上部部分end-->


</div>
<!-- 你的HTML代码 -->

<jsp:include page="../../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/plugins/dataTables/js/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/biz/collection/myCollectionList.js"></script>
</body>
</html>