<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../base/adminHead.jsp"/>
    <title>后台管理</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="../../base/adminHeader.jsp"/>
    <jsp:include page="../../base/adminSide.jsp"/>

    <div class="layui-body">

        <div class="layui-row padding-l-15">
            <span class="layui-breadcrumb">
                <a href="${pageContext.request.contextPath}/admin/index"><i class="layui-icon">&#xe68e;</i></a>
                <a><cite>焦点图</cite></a>
            </span>
        </div>

        <div class="layui-row">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-15">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                    <div class="layui-upload-drag" id="uploadDrag">
                        <i class="layui-icon"></i>
                        <p>点击上传，或将文件拖拽到此处</p>
                    </div>
                </div>
                <form id="bannerSubmitForm">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" id="upload-img-content">
                        <c:if test="${not empty bannerList && bannerList.size() gt 0}">
                            <c:forEach items="${bannerList}" var="banner">
                                <div class="layui-col-xs4 layui-col-sm3 layui-col-md3 padding-10 upload-item">
                                    <div class="upload-img-item">
                                        <img src="${banner.articleImgFile.fileUrl}">
                                        <img src="${pageContext.request.contextPath}/resources/images/error_64px.png"
                                             class="removeUploadImgBtn">
                                        <input type="hidden" name="bannerImgs" value="${banner.bannerImg}">
                                    </div>
                                    <div>
                                        <input type="url" class="layui-input" name="bannerUris" placeholder="请输入链接"
                                               value="${banner.bannerUri}">
                                        <input class="layui-input" name="bannerTexts" placeholder="请输入描述"
                                               value="${banner.bannerText}">
                                        <input type="number" min="1" max="10" class="layui-input" name="bannerSequences"
                                               value="${banner.bannerSequence}" placeholder="请输入0-10的排序数字">
                                    </div>
                                    <div class="error-text"></div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </form>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 text-r margin-t-30">
                    <a class="layui-btn layui-btn-normal" id="submitBtn"
                       <c:if test="${empty bannerList || bannerList.size() eq 0}">style="display: none;"</c:if>>提交&nbsp;<i
                            class="fa fa-save" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../../base/adminFooter.jsp"/>
    <script src="${pageContext.request.contextPath}/resources/js/biz/admin/banner/list.js"></script>
</div>
</body>
</html>