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
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">类型</label>
                        <div class="layui-input-block">
                            <input type="radio" name="type" value="0" title="文章" checked>
                            <input type="radio" name="type" value="1" title="笔记">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">标题</label>
                        <div class="layui-input-block">
                            <input type="text" name="title" autocomplete="off" placeholder="请输入标题..." class="layui-input">
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
                            <a class="layui-btn">保存为草稿</a>
                            <a class="layui-btn layui-btn-normal"><i class="layui-icon">&#xe609;</i> 直接提交审核</a>
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

    layui.use(['layer', 'form'], function(){
        var form = layui.form,layer = layui.layer;

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
        // 表情
        messageEditor.customConfig.emotions = [{title: '默认',type: 'image',content: weboEmoji}];
        messageEditor.create();
        // 添加全屏编辑
        messageE.fullscreen.init('#xtl-publish-editor');
        var messageVal = messageEditor.txt.html();
        // 防止xss攻击
        messageVal = filterXSS(messageVal);

    });

</script>
</body>
</html>