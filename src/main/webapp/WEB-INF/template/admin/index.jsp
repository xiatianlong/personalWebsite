<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/adminHead.jsp"/>
    <title>后台管理</title>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="../base/adminHeader.jsp"/>
    <jsp:include page="../base/adminSide.jsp"/>

    <div class="layui-body">
        <div class="layui-row">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-15 layui-col-space15 text-c margin-t-20 margin-b-20">
                <span class="black font-size-26 font-bold">个人网站后台管理</span>
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-15 layui-col-space15">
                <div class="layui-col-xs12 layui-col-sm6 layui-col-md4">
                    <table class="layui-table">
                        <thead>
                        <tr>
                            <th>文章总数</th>
                            <th>待审核数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${articleCnt}</td>
                            <td>${articleUnderReviewCnt}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-col-xs12 layui-col-sm6 layui-col-md4">
                    <table class="layui-table">
                        <thead>
                        <tr>
                            <th>笔记总数</th>
                            <th>待审核数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${noteCnt}</td>
                            <td>${noteUnderReviewCnt}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="layui-col-xs12 layui-col-sm6 layui-col-md4">
                    <table class="layui-table">
                        <thead>
                        <tr>
                            <th>用户总数</th>
                            <th>留言总数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${userCnt}</td>
                            <td>${commentByMessageCnt}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../base/adminFooter.jsp"/>
</div>
</body>
</html>