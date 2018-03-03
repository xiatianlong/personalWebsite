<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/adminHead.jsp"/>
    <title>layout 后台大布局 - Layui</title>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="../../base/adminHeader.jsp"/>
    <jsp:include page="../../base/adminSide.jsp"/>

    <div class="layui-body">

        <div class="layui-row padding-l-15">
            <span class="layui-breadcrumb">
                <a href="${pageContext.request.contextPath}/admin/index"><i class="layui-icon">&#xe68e;</i></a>
                <a><cite>文章</cite></a>
            </span>
        </div>

        <div class="layui-row">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-15">
                <c:choose>
                    <c:when test="${not empty articleList && articleList.size() gt 0}">
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <form class="layui-form">
                                <div class="layui-col-xs6 layui-col-sm4 layui-col-md3 padding-r-30">
                                    <input name="keyword" placeholder="ID、标题" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-col-xs6 layui-col-sm4 layui-col-md3 padding-r-30">
                                    <select name="articleStatus" lay-filter="articleStatus">
                                        <option value="">全部状态</option>
                                        <c:if test="${not empty articleStatusList && articleStatusList.size() gt 0}">
                                            <c:forEach items="${articleStatusList}" var="articleStatus">
                                                <option value="${articleStatus.dicCode}">${articleStatus.dicName}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="layui-col-xs6 layui-col-sm4 layui-col-md3 padding-r-30">
                                    <select name="articleCategory" lay-filter="articleCategory" lay-search>
                                        <option value="">全部分类</option>
                                        <c:if test="${not empty articleCategoryList && articleCategoryList.size() gt 0}">
                                            <c:forEach items="${articleCategoryList}" var="articleCategory">
                                                <option value="${articleCategory}">${articleCategory}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="layui-col-xs6 layui-col-sm4 layui-col-md3 padding-r-30">
                                    <select name="deleted" lay-filter="deleted">
                                        <option value="">全部</option>
                                        <option value="1">已删除</option>
                                        <option value="0">未删除</option>
                                    </select>
                                </div>
                            </form>
                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-20">
                                <table class="layui-table">
                                    <colgroup>
                                        <col>
                                        <col width="30%">
                                        <col>
                                        <col>
                                        <col>
                                        <col>
                                        <col>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>标题</th>
                                        <th>状态</th>
                                        <th>分类</th>
                                        <th>用户ID</th>
                                        <th>创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="articleListContent">
                                    <c:forEach items="${articleList}" var="article">
                                        <tr>
                                            <td>${article.articleId}</td>
                                            <td>${article.articleTitle}</td>
                                            <td>${article.articleStatusName}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${not empty article.fmtCategoryList}">${article.fmtCategoryList}</c:when>
                                                    <c:otherwise>--</c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td title="${article.userName}">${article.userId}</td>
                                            <td>${article.fmtCreateTime}</td>
                                            <td>
                                                <div class="layui-btn-group">
                                                    <button class="layui-btn layui-btn-sm margin-t-5" title="审核">
                                                        <i class="layui-icon">&#xe642;</i>
                                                    </button>
                                                    <button class="layui-btn layui-btn-sm margin-t-5" title="删除">
                                                        <i class="layui-icon">&#xe640;</i>
                                                    </button>
                                                    <button class="layui-btn layui-btn-sm margin-t-5" title="预览">
                                                        <i class="layui-icon">&#xe602;</i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                                <div id="articlePageContent"></div>
                            </div>
                        </div>
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
    </div>
    <jsp:include page="../../base/adminFooter.jsp"/>
    <script>
        layui.use(['laypage', 'form'], function () {
            var laypage = layui.laypage;
            var form = layui.form

            var pageNo, pageSize;
            var limits = [${pageSize}, ${pageSize*2}, ${pageSize*3}];
            laypage.render({
                elem: 'articlePageContent',
                count: ${dataCount},
                limit: ${pageSize},
                limits: limits,
                groups: 3,
                layout: ['prev', 'page', 'next', 'limit', 'count'],
                jump: function (obj, first) {
                    console.log(obj);
                    pageNo = obj.curr;
                    pageSize = obj.limit;
                    //首次不执行
                    if (!first) {
                        submitQuery();
                    }
                }
            });

            $("input[name='keyword']").keydown(function () {
                if (event.keyCode == "13") {//keyCode=13是回车键
                    submitQuery();
                }
            });
            form.on('select(articleCategory)', function (data) {
                submitQuery();
            });
            form.on('select(articleStatus)', function (data) {
                submitQuery();
            });
            form.on('select(deleted)', function (data) {
                submitQuery();
            });

            /**
             * 异步分页、搜索提交
             */
            function submitQuery() {
                var requestData = {
                    pageNo: pageNo,
                    pageSize: pageSize,
                    keyword: $("input[name='keyword']").val(),
                    deleted: $("select[name='deleted']").val(),
                    articleStatus: $("select[name='articleStatus']").val(),
                    articleCategory: $("select[name='articleCategory']").val()
                };
                common.ajax({
                    url: "${pageContext.request.contextPath}/admin/article/query",
                    type: "POST",
                    data: requestData,
                    success: function (res) {
                        if (res.result === 'success') {
                            $("#articleListContent").empty();
                            if (EasyCheck.StringUtils.isNotEmpty(res.articleInfos) && res.articleInfos.length > 0) {
                                for (var articleInfosIndex = 0; articleInfosIndex < res.articleInfos.length; articleInfosIndex++) {
                                    $("#articleListContent").append(buildHtml(res.articleInfos[articleInfosIndex]));
                                }
                            }
                            // 重绘分页栏
                            laypage.render({
                                elem: 'articlePageContent',
                                count: res.dataCount,
                                limit: pageSize,
                                limits: limits,
                                curr: pageNo,
                                groups: 3,
                                layout: ['prev', 'page', 'next', 'limit', 'count'],
                                jump: function (obj, first) {
                                    console.log(obj);
                                    pageNo = obj.curr;
                                    pageSize = obj.limit;
                                    //首次不执行
                                    if (!first) {
                                        submitQuery();
                                    }
                                }
                            });

                        } else {
                            layer.msg(res.message, {icon: 5, anim: 6});
                        }
                    }
                });
            }

            /**
             * 封装异步分页数据
             * @param article
             * @returns {string}
             */
            function buildHtml(article) {
                var html = '';
                html += '<tr>';
                html += '   <td>' + article.articleId + '</td>';
                html += '   <td>' + article.articleTitle + '</td>';
                html += '   <td>' + article.articleStatusName + '</td>';
                if (EasyCheck.StringUtils.isNotEmpty(article.fmtCategoryList)) {
                    html += '<td>' + article.fmtCategoryList + '</td>';
                } else {
                    html += '<td>--</td>';
                }
                html += '   <td title="' + article.userName + '">' + article.userId + '</td>';
                html += '   <td>' + article.fmtCreateTime + '</td>';
                html += '   <td>';
                html += '       <div class="layui-btn-group">';
                html += '           <button class="layui-btn layui-btn-sm margin-t-5" title="审核">';
                html += '               <i class="layui-icon">&#xe642;</i>';
                html += '           </button>';
                html += '           <button class="layui-btn layui-btn-sm margin-t-5" title="删除">';
                html += '               <i class="layui-icon">&#xe640;</i>';
                html += '           </button>';
                html += '           <button class="layui-btn layui-btn-sm margin-t-5" title="预览">';
                html += '               <i class="layui-icon">&#xe602;</i>';
                html += '           </button>';
                html += '       </div>';
                html += '   </td>';
                html += '</tr>';

                return html;
            }

        });

    </script>
</div>
</body>
</html>