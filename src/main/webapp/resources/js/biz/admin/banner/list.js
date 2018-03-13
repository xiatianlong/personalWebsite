/**
 * 后台文章列表js
 */
layui.use(['upload'], function () {

    var upload = layui.upload;
    //拖拽上传
    upload.render({
        elem: '#uploadDrag',
        url: '/common/uploadCompressionImg',
        field: 'file',
        accept: 'images',
        exts: 'jpg|png|gif|bmp|jpeg',
        choose: function (obj) {
            console.log("choose: " + obj);
            if ($("#input[name='bannerImgs']").length >= 5) {
                layer.msg('最多只允许上传五张图片哦~', {icon: 7, anim: 6});
                return false;
            }
        },
        before: function (obj) {
            console.log("before: " + obj);
        },
        error: function () {
            layer.msg('上传失败', {icon: 7, anim: 6});
        },
        done: function (res) {
            if (res.result === 'success') {
                layer.msg('上传成功', {icon: 6});
                $("#upload-img-content").append(buildImgItem(res));
                $("#submitBtn").show();
            } else {
                layer.msg(res.message, {icon: 7, anim: 6});
            }
        }
    });

    /**
     * 删除图片
     */
    $("#upload-img-content").on('click', '.removeUploadImgBtn', function () {
        $(this).parents(".upload-img-item").parent().remove();
        if ($("input[name='bannerImgs']").length === 0) {
            $("#submitBtn").hide();
        }
    });

    /**
     * 监听输入事件
     */
    $("#upload-img-content").on('input', 'input[name="bannerUris"], input[name="bannerTexts"], input[name="bannerSequences"]', function () {
        $(this).parents(".upload-item").find("div.error-text").text("");
    });

    /**
     * 侯建上传的html文本
     * @param res
     * @returns {string}
     */
    function buildImgItem(res) {
        var html = '';
        html += '<div class="layui-col-xs4 layui-col-sm3 layui-col-md3 padding-10 upload-item">';
        html += '   <div class="upload-img-item">';
        html += '       <img src="' + res.fileUrl + '">';
        html += '       <img src="/resources/images/error_64px.png" class="removeUploadImgBtn">';
        html += '       <input type="hidden" name="bannerImgs" value="' + res.fileNo + '">';
        html += '   </div>';
        html += '   <div>';
        html += '       <input type="url" class="layui-input" name="bannerUris" placeholder="请输入链接">';
        html += '       <input class="layui-input" name="bannerTexts" placeholder="请输入描述">';
        html += '       <input type="number"  min="1" max="10" class="layui-input" name="bannerSequences" placeholder="请输入0-10的排序数字">';
        html += '   </div>';
        html += '   <div class="error-text"></div>';
        html += '</div>';
        return html;
    }

    /**
     * 保存点击提交
     */
    $("#submitBtn").on('click', function () {

        var flag = true;
        $("input[name='bannerImgs']").each(function () {
            var $that = $(this);
            if (EasyCheck.StringUtils.isEmpty($that.val())) {
                $that.parents(".upload-item").find("div.error-text").text("没有图片ID！");
                flag = false;
            }
        });
        $("input[name='bannerUris']").each(function () {
            var $that = $(this);
            if (EasyCheck.StringUtils.isNotEmpty($that.val()) && $that.val().length > 200) {
                $that.parents(".upload-item").find("div.error-text").text("链接超过200个字符！");
                flag = false;
            }
        });
        $("input[name='bannerTexts']").each(function () {
            var $that = $(this);
            if (EasyCheck.StringUtils.isNotEmpty($that.val()) && $that.val().length > 50) {
                $that.parents(".upload-item").find("div.error-text").text("描述超过50个字符！");
                flag = false;
            }
        });
        $("input[name='bannerSequences']").each(function () {
            var $that = $(this);
            if (!EasyCheck.StringUtils.isPositiveInteger($that.val()) || $that.val() - 0 > 10) {
                $that.parents(".upload-item").find("div.error-text").text("请输入0-10的排序数字！");
                flag = false;
            }
        });

        if (!flag) {
            return false;
        }
        // 请求
        common.ajax({
            url: "/admin/banner/update",
            type: "POST",
            data: $("#bannerSubmitForm").serialize(),
            success: function (res) {
                if (res.result === 'success') {
                    layer.msg('操作成功', {icon: 6});
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    });

});