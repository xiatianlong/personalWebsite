<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>Title</title>
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
        <a href="${pageContext.request.contextPath}/member/personalCenter/">个人中心</a>
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
                                    <img class="layui-upload-img"
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
                            <span class="float-r" id="introduction-cnt">0/100</span>
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

<!-- 你的HTML代码 -->

<jsp:include page="../base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/wangEditor-fullscreen-plugin.js"></script>
<script>

    layui.use(['form', 'layer', 'upload'], function () {
        var form = layui.form, layer = layui.layer, upload = layui.upload;

        $("#xtl-publish-tips").on('click', function(){
            var tipsContent = "为了网站内容的质量，所有发布的内容需由管理员进行审核才可上线，管理员将在6小时内完成审核。<br>审核结果可在\"个人中心\"的文章、笔记详情页面进行查看。如果您的个人信息中完善了邮箱信息，那么管理员也会将审核结果通过邮件的方式通知您！";
            layer.alert(tipsContent, {
                icon: 6,
                skin: 'layer-ext-moon'
            })
        });

        // 菜单
        var messageMenu = ['bold','italic','underline','strikeThrough','justify','foreColor','list','link','image','video','table','code','emoticon'];

        //建立编辑器
        var messageE = window.wangEditor;
        var messageEditor = new messageE('#xtl-publish-editor');
        // 自定义菜单配置
        messageEditor.customConfig.menus = messageMenu;
        // 配置服务器端地址
        messageEditor.customConfig.uploadImgServer = '/common/uploadImg';
        // 将图片大小限制为 1M
        messageEditor.customConfig.uploadImgMaxSize = 1024 * 1024;
        // 限制一次最多上传 1 张图片
        messageEditor.customConfig.uploadImgMaxLength = 1;
        // 自定义 fileName
        messageEditor.customConfig.uploadFileName = 'file';
        messageEditor.customConfig.uploadImgHooks = {
            customInsert: function (insertImg, result, editor) {
                if (result.result === 'success') {
                    insertImg(result.fileUrl);
                } else {
                    layer.msg(result.message, {icon: 7, anim: 6});
                }
            }
        };
        // 表情
        messageEditor.customConfig.emotions = [{title: '默认',type: 'image',content: weboEmoji}];
        messageEditor.create();
        // 添加全屏编辑
        messageE.fullscreen.init('#xtl-publish-editor');

        // 隔热和介绍字数监听
        $("textarea[name='introduction']").on('input', function () {
            var that = $(this);
            $("#introduction-cnt").text(that.val().length + "/100");
        });

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#uploadImgBtn',
            url: '/common/uploadImg',
            field: 'file',
            accept: 'images',
            exts: 'jpg|png|gif|bmp|jpeg',
            before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#uploadImgPreView').attr('src', result); //图片链接（base64）
                });
                if (EasyCheck.StringUtils.isNotEmpty($("#upload-file-no").val())) {
                    layer.msg('只允许上传一张图片哦~', {icon: 7, anim: 6});
                    return false;
                }
            },
            done: function (res) {
                if (res.result === 'success') {
                    layer.msg('上传成功', {icon: 6});
                    $("#removeUploadImgBtn").show();
                    $("#upload-file-no").val(res.fileNo);
                } else {
                    layer.msg(res.message, {icon: 7, anim: 6});
                }
            },
            error: function () {
                layer.msg('上传失败', {icon: 7, anim: 6});
            }
        });
        // 删除上传的图片
        $("#removeUploadImgBtn").on('click', function () {
            $('#uploadImgPreView').attr('src', '${pageContext.request.contextPath}/resources/images/blank_img.png');
            $("#upload-file-no").val('');
            $("#removeUploadImgBtn").hide();
        });

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (EasyCheck.StringUtils.isEmpty(value)) {
                    return '请输入标题~';
                }
                if (value.length > 200) {
                    return '标题不超过100个字~';
                }
            }
        });

        // 文章笔记单选按钮监听
        form.on('radio(type)', function (data) {
            if (data.value === 'article') {
                $("#uploadImg-content").show();
                $("#introduction-content").show();
            } else if (data.value === 'note') {
                $("#uploadImg-content").hide();
                $("#introduction-content").hide();
            }
        });

        //监听提交
        form.on('submit(saveToDraftForm)', function (data) {
            console.log("saveToDraftForm");
            console.log(data.field);

            return false;
        });

        form.on('submit(saveToUnderReviewForm)', function (data) {
            console.log("saveToUnderReviewForm");
            console.log(data.field);

            var messageVal = messageEditor.txt.html();
            // 防止xss攻击
            messageVal = filterXSS(messageVal);
            if (EasyCheck.StringUtils.isEmpty(messageVal) || messageVal === '<p><br></p>') {
                layer.msg('请输入内容！', {icon: 7, anim: 6});
                return;
            }


            return false;
        });

    });

</script>
</body>
</html>