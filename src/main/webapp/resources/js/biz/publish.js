layui.use(['form', 'upload'], function () {
    var form = layui.form, upload = layui.upload;

    $("#xtl-publish-tips").on('click', function () {
        var tipsContent = "为了网站内容的质量，所有发布的内容需由管理员进行审核才可上线，管理员将在6小时内完成审核。<br>审核结果可在\"个人中心\"的文章、笔记详情页面进行查看。如果您的个人信息中完善了邮箱信息，那么管理员也会将审核结果通过邮件的方式通知您！";
        layer.alert(tipsContent, {
            icon: 6,
            skin: 'layer-ext-moon'
        })
    });

    // 菜单
    var messageMenu = ['bold', 'fontSize', 'italic', 'underline', 'strikeThrough', 'justify', 'quote', 'foreColor', 'list', 'link', 'image', 'video', 'table', 'code', 'emoticon'];

    //建立编辑器
    var messageE = window.wangEditor;
    var messageEditor = new messageE('#xtl-publish-editor');
    // 自定义菜单配置
    messageEditor.customConfig.menus = messageMenu;
    // 配置服务器端地址
    messageEditor.customConfig.uploadImgServer = '/common/uploadCompressionImg';
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
    messageEditor.customConfig.emotions = [{title: '默认', type: 'image', content: weboEmoji}];
    messageEditor.create();
    // 添加全屏编辑
    messageE.fullscreen.init('#xtl-publish-editor');

    // 隔热和介绍字数监听
    $("textarea[name='introduction']").on('input', function () {
        var that = $(this);
        $("#introduction-cnt").text(that.val().length + "/200");
    });

    /**
     * 普通图片上传
     */
    var uploadInst = upload.render({
        elem: '#uploadImgBtn',
        url: '/common/uploadCompressionImg',
        field: 'file',
        accept: 'images',
        exts: 'jpg|png|gif|bmp|jpeg',
        choose: function (obj) {
            if (EasyCheck.StringUtils.isNotEmpty($("#upload-file-no").val())) {
                layer.msg('只允许上传一张图片哦~', {icon: 7, anim: 6});
                return false;
            }
        },
        before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#uploadImgPreView').attr('src', result); //图片链接（base64）
            });

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
    /**
     * 删除上传的图片
     */
    $("#removeUploadImgBtn").on('click', function () {
        $('#uploadImgPreView').attr('src', '/resources/images/blank_img.png');
        $("#upload-file-no").val('');
        $("#removeUploadImgBtn").hide();
    });

    /**
     * 自定义验证规则
     */
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

    /**
     * 文章笔记单选按钮监听
     */
    form.on('radio(type)', function (data) {
        if (data.value === 'article') {
            $("#uploadImg-content").show();
            $("#introduction-content").show();
        } else if (data.value === 'note') {
            $("#uploadImg-content").hide();
            $("#introduction-content").hide();
        }
    });

    /**
     * 保存为草稿
     */
    form.on('submit(saveToDraftForm)', function (data) {

        var messageVal = messageEditor.txt.html();
        // 防止xss攻击
        messageVal = filterXSS(messageVal);
        var formData = data.field;
        var requestDate = {};
        var url = "";
        if (formData.type === 'article') {
            requestDate['articleTitle'] = formData.title;
            requestDate['articleImgNo'] = $("#upload-file-no").val();
            requestDate['articleIntroduction'] = formData.introduction;
            requestDate['articleContent'] = messageVal;
            requestDate['articleStatus'] = '002001';
            url = "/member/article/create";

        } else if (formData.type === 'note') {
            requestDate['noteTitle'] = formData.title;
            requestDate['noteContent'] = messageVal;
            requestDate['noteStatus'] = '003001';
            url = "/member/note/create";
        }
        if (!EasyCheck.StringUtils.isEmpty(url)) {
            common.ajax({
                url: url,
                type: "POST",
                data: requestDate,
                success: function (res) {
                    if (res.result === 'success') {
                        layer.msg('操作成功', {icon: 6});
                    } else {
                        layer.msg(res.message, {icon: 5, anim: 6});
                    }
                }
            });

        }

        return false;
    });

    /**
     * 提交审核
     */
    form.on('submit(saveToUnderReviewForm)', function (data) {

        var formData = data.field;

        var messageVal = messageEditor.txt.html();
        // 防止xss攻击
        messageVal = filterXSS(messageVal);
        if (EasyCheck.StringUtils.isEmpty(messageVal) || messageVal === '<p><br></p>') {
            layer.msg('请输入内容！', {icon: 7, anim: 6});
            return;
        }

        var requestDate = {};
        var url = "";
        if (formData.type === 'article') {
            if (EasyCheck.StringUtils.isEmpty(formData.introduction)) {
                layer.msg('请输入封面摘要！', {icon: 7, anim: 6});
                return;
            }
            requestDate['articleTitle'] = formData.title;
            requestDate['articleImgNo'] = $("#upload-file-no").val();
            requestDate['articleIntroduction'] = formData.introduction;
            requestDate['articleContent'] = messageVal;
            requestDate['articleStatus'] = '002002';
            url = "/member/article/create";

        } else if (formData.type === 'note') {
            requestDate['noteTitle'] = formData.title;
            requestDate['noteContent'] = messageVal;
            requestDate['noteStatus'] = '003002';
            url = "/member/note/create";
        }
        if (!EasyCheck.StringUtils.isEmpty(url)) {
            common.ajax({
                url: url,
                type: "POST",
                data: requestDate,
                success: function (res) {
                    if (res.result === 'success') {
                        layer.msg('操作成功', {icon: 6});
                    } else {
                        layer.msg(res.message, {icon: 5, anim: 6});
                    }
                }
            });
        }
        return false;
    });

});