/***
 * 留言相关js
 * create by xiatianlong on 2017/12/06
 */
layui.use(['laypage', 'form'], function () {
    var laypage = layui.laypage;

    // 分页
    var pageNo;
    var dataCount = Number($("#dataCount").val());
    var pageSize = Number($("#pageSize").val());
    var commentBizType = $("#commentBizType").val();
    var commentBizId = $("#commentBizId").val();
    var limits = [pageSize, pageSize * 2, pageSize * 3];
    laypage.render({
        elem: 'messagePageContent',
        count: dataCount,
        limit: pageSize,
        limits: limits,
        groups: 3,
        layout: ['prev', 'page', 'next', 'limit', 'count'],
        jump: function (obj, first) {
            pageNo = obj.curr;
            pageSize = obj.limit;
            //首次不执行
            if (!first) {
                getMessagePageData();
            }
        }
    });

    // 菜单
    var messageMenu = ['bold', 'italic', 'underline', 'quote', 'strikeThrough', 'foreColor', 'link', 'code', 'emoticon'];

    //建立编辑器
    var messageE = window.wangEditor;
    var messageEditor = new messageE('#xtl-message-editor');
    // 自定义菜单配置
    messageEditor.customConfig.menus = messageMenu;
    // 表情
    messageEditor.customConfig.emotions = [{title: '默认', type: 'image', content: weboEmoji}];
    messageEditor.create();


    // 评论的提交
    $("#xtl-message-submit-btn").on('click', function () {
        if ($(this).hasClass("layui-btn-disabled")) {
            return;
        }
        var messageVal = messageEditor.txt.html();
        if (EasyCheck.StringUtils.isEmpty(messageVal) || messageVal == '<p><br></p>') {
            layer.msg('请输入内容！', {icon: 7, anim: 6});
            return;
        }
        // 防止xss攻击
        messageVal = filterXSS(messageVal);
        // 提交请求
        common.ajax({
            url: "/message/add",
            type: "POST",
            data: {
                commentContent: messageVal,
                commentBizId: commentBizId,
                commentBizType: commentBizType
            },
            success: function (data) {
                if (data.result == 'success') {
                    layer.msg('留言成功', {icon: 6});
                    messageEditor.txt.clear();
                    var html = buildMessageHtml(data.commentInfo);
                    $("#xtl-comment-content").prepend(html);
                    $("#xtl-comment-blank-content").remove();
                } else {
                    layer.msg(data.message, {icon: 7, anim: 6});
                }
            }
        });

    });

    /**
     * 获取分页数据
     */
    function getMessagePageData() {
        var requestData = {
            pageNo: pageNo,
            pageSize: pageSize,
            commentBizType: commentBizType,
            commentBizId: commentBizId
        };
        common.ajax({
            url: "/message/query",
            type: "POST",
            data: requestData,
            success: function (res) {
                if (res.result === 'success') {
                    $("#xtl-comment-content").empty();
                    if (EasyCheck.StringUtils.isNotEmpty(res.commentInfos) && res.commentInfos.length > 0) {
                        for (var commentInfosIndex = 0; commentInfosIndex < res.commentInfos.length; commentInfosIndex++) {
                            $("#xtl-comment-content").append(buildMessageHtml(res.commentInfos[commentInfosIndex]));
                        }
                    }
                    dataCount = res.dataCount;
                    // 重绘分页栏
                    laypage.render({
                        elem: 'messagePageContent',
                        count: dataCount,
                        limit: pageSize,
                        limits: limits,
                        curr: pageNo,
                        groups: 3,
                        layout: ['prev', 'page', 'next', 'limit', 'count'],
                        jump: function (obj, first) {
                            pageNo = obj.curr;
                            pageSize = obj.limit;
                            //首次不执行
                            if (!first) {
                                getMessagePageData();
                            }
                        }
                    });

                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });

    }

    // 构建message分页html
    function buildMessageHtml(message) {
        var html = '';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-comment">';
        html += '   <div class="xtl-comment-user-img"><img src="' + message.commentUserHeadImg + '"></div>';
        html += '   <div class="xtl-comment-user-info">';
        html += '       <div class="xtl-comment-user-name">' + message.commentUserName + '</div>';
        html += '       <div class="xtl-comment-content">' + message.commentContent + '</div>';
        html += '       <div class="xtl-comment-time">';
        html += '           <span class="gray">';
        html += '               <i class="fa fa-clock-o" aria-hidden="true"></i> ' + message.commentFmtTime;
        html += '           </span>';
        html += '       </div>';
        html += '   </div>';
        html += '</div>';
        return html;
    }

});



