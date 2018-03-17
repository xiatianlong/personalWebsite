<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>我要投稿</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/wangEditor-fullscreen-plugin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/publish.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="${pageContext.request.contextPath}/member/personalCenter">个人中心</a>
      <a><cite>我要投稿</cite></a>
    </span>
</div>


<div class="layui-container">

    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-30 padding-b-30">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label">类型</label>
                        <div class="layui-input-block">
                            <input type="radio" lay-filter="type" name="type" value="article" title="文章" checked>
                            <input type="radio" lay-filter="type" name="type" value="note" title="笔记">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">标题</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verify="title" name="title" autocomplete="off" placeholder="请输入标题..."
                                   class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item" id="uploadImg-content">
                        <label class="layui-form-label">封面图片</label>
                        <div class="layui-input-block">
                            <div class="layui-upload">
                                <button type="button" class="layui-btn layui-btn-sm" id="uploadImgBtn">上传图片</button>
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img" draggable="false"
                                         src="${pageContext.request.contextPath}/resources/images/blank_img.png"
                                         id="uploadImgPreView">
                                    <img src="${pageContext.request.contextPath}/resources/images/error_64px.png"
                                         id="removeUploadImgBtn">
                                    <input type="hidden" id="upload-file-no">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="layui-form-item" id="introduction-content">
                        <label class="layui-form-label">文章摘要</label>
                        <div class="layui-input-block">
                            <textarea placeholder="请输入文章摘要..." name="introduction" class="layui-textarea"></textarea>
                            <span class="float-r" id="introduction-cnt">0/200</span>
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">正文</label>
                        <div class="layui-input-block">
                            <%--富文本区域 begin--%>
                            <div id="xtl-publish-editor"></div>
                            <%--富文本区域 end--%>
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">&nbsp;</label>
                        <div class="layui-input-block">
                            <div class="margin-b-15" id="xtl-publish-tips"><i class="layui-icon">&#xe60b;</i> 发布须知</div><br>
                            <a class="layui-btn" lay-submit lay-filter="saveToDraftForm">保存为草稿</a>
                            <a class="layui-btn layui-btn-normal" lay-submit lay-filter="saveToUnderReviewForm"><i
                                    class="layui-icon">&#xe609;</i> 直接提交审核</a>
                        </div>
                    </div>
                </form>

            </div>

        </div>
    </div>

</div>


<jsp:include page="../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/wangEditor-fullscreen-plugin.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/biz/publish.js"></script>
</body>
</html>