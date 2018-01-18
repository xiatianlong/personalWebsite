/***
 * 留言相关js
 * create by xiatianlong on 2017/12/06
 */

// 菜单
var messageMenu = ['bold','italic','underline','strikeThrough','foreColor','link','code','emoticon'];

//建立编辑器
var messageE = window.wangEditor;
var messageEditor = new messageE('#xtl-message-editor');
// 自定义菜单配置
messageEditor.customConfig.menus = messageMenu;
// 表情
messageEditor.customConfig.emotions = [{title: '默认',type: 'image',content: weboEmoji}];
messageEditor.create();


// 评论的提交
$("#xtl-message-submit-btn").on('click', function () {
    if ($(this).hasClass("layui-btn-disabled")) {
        return;
    }
    var messageVal = messageEditor.txt.html();
    if (EasyCheck.StringUtils.isEmpty(messageVal) || messageVal == '<p><br></p>') {
        layer.msg('请输入内容！', {icon: 7});
        return;
    }
    // 防止xss攻击
    messageVal = filterXSS(messageVal);
    // 提交请求
    common.ajax({
        url: "/message/add",
        type: "POST",
        data: {
            commentContent: messageVal
        },
        success: function (data) {
            if (data.result == 'success') {
                layer.msg('留言成功', {icon: 6});
                messageEditor.txt.clear();
                var commentInfo = {
                    commentUserName: data.commentUserName,
                    commentUserId: data.commentUserId,
                    commentUserHeadImg: data.commentUserHeadImg,
                    commentParentUserName: data.commentParentUserName,
                    commentParentUserId: data.commentParentUserId,
                    commentId: data.commentId
                };
                var appendHtml = buildCommentHTML(messageVal, 1, commentInfo);
                $("#xtl-comment-content").append(appendHtml);
            } else {
                layer.msg(data.message, {icon: 7});
            }
        }
    });

});

// 创建回复富文本
var commentEditor = null;
$("#xtl-comment-content").off('click', '.xtl-comment-reply');
$("#xtl-comment-content").on('click', '.xtl-comment-reply', function () {
    var toUserName = $(this).data("userName");
    var toUserId = $(this).data("userId");
    var commentId = $(this).data("commentId");
    // 校验单登录
    if (!xtlUserIsLogin){
        layer.msg('请先登录！', {icon: 7});
        return;
    }
    // 先清除全部的富文本
    $(this).parents("#xtl-comment-content").find("div.xtl-comment-reply-content").empty();
    // 设置样式
    $(this).parents(".level1").find("div.xtl-comment-reply-content").addClass("margin-t-15");
    // 插入回复对象
    $(this).parents(".level1").find("div.xtl-comment-reply-content").append('<div class="comment-reply-to">回复&nbsp;<span class="xtl-comment-user-name">' + toUserName + '</span>：</div>');
    // 插入富文本容器
    $(this).parents(".level1").find("div.xtl-comment-reply-content").append('<div id="xtl-comment-editor"></div>');
    // 插入按钮
    $(this).parents(".level1").find("div.xtl-comment-reply-content").append('<a class="layui-btn layui-btn-normal layui-btn-sm margin-t-5 float-r" data-parent-user-id="' + toUserId + '" data-parent-comment-id="' + commentId + '" id="xtl-comment-editor-submit-btn"><i class="layui-icon">&#xe609;</i>  回复评论</a>');
    $(this).parents(".level1").find("div.xtl-comment-reply-content").append('<a class="layui-btn layui-btn-warm layui-btn-sm margin-t-5 margin-r-15 float-r" id="xtl-comment-editor-cancel-btn">取消</a>');
    // 初始富文本容器
    var commentE = window.wangEditor;
    commentEditor = new commentE('#xtl-comment-editor');
    // 自定义菜单配置
    commentEditor.customConfig.menus = messageMenu;
    // 表情
    commentEditor.customConfig.emotions = [{title: '默认',type: 'image',content: weboEmoji}];
    commentEditor.create();
    commentEditor.txt.clear()

    // 滚动到富文本的位置
    $("body,html").animate({scrollTop:$("#xtl-comment-editor").offset().top-($(window).height()/2)},100);

});

// 回复富文本的点击提交
$("#xtl-comment-content").off('click', '#xtl-comment-editor-submit-btn');
$("#xtl-comment-content").on('click', '#xtl-comment-editor-submit-btn', function () {
    var that = $(this);
    var commentVal = commentEditor.txt.html();
    var commentParentUserId = $(this).data("parentUserId");
    var commentRootId = $(this).parents(".level1").data("commentId");
    var commentParentId = $(this).data("parentCommentId");
    if (EasyCheck.StringUtils.isEmpty(commentVal) || commentVal == '<p><br></p>') {
        layer.msg('请输入内容！', {icon: 7});
        return;
    }
    // 防止xss攻击
    commentVal = filterXSS(commentVal);
    // 提交请求
    common.ajax({
        url: "/message/reply",
        type: "POST",
        data: {
            commentContent: commentVal,
            commentParentUserId: commentParentUserId,
            commentRootId: commentRootId,
            commentParentId: commentParentId
        },
        success: function (data) {
            if (data.result == 'success') {
                layer.msg('评论成功', {icon: 6});
                commentEditor.txt.clear()
                var commentInfo = {
                    commentUserName: data.commentUserName,
                    commentUserId: data.commentUserId,
                    commentUserHeadImg: data.commentUserHeadImg,
                    commentParentUserName: data.commentParentUserName,
                    commentParentUserId: data.commentParentUserId,
                    commentId: data.commentId
                };
                var appendHtml = buildCommentHTML(commentVal, 2, commentInfo);
                // 插入新评论内容
                that.parents(".xtl-comment-user-info").find(".level2-common-content").append(appendHtml);
                // 清除全部的回复富文本相关
                that.parents("#xtl-comment-content").find("div.xtl-comment-reply-content").empty();
            } else {
                layer.msg(data.message, {icon: 7});
            }
        }
    });

});

// 回复富文本的点击取消
$("#xtl-comment-content").off('click', '#xtl-comment-editor-cancel-btn');
$("#xtl-comment-content").on('click', '#xtl-comment-editor-cancel-btn', function(){
    // 清除全部的回复富文本相关
    $(this).parents("#xtl-comment-content").find("div.xtl-comment-reply-content").removeClass("margin-t-15");
    $(this).parents("#xtl-comment-content").find("div.xtl-comment-reply-content").empty();
});

/**
 * 建构回复html
 * @param commentVal    回复的内容
 * @param level 层级
 * @param commentInfo {commentUserName, commentUserId, commentUserHeadImg, commentParentUserName, commentParentUserId, commentId}
 * @returns {string}    拼接的内容
 */
function buildCommentHTML(commentVal, level, commentInfo) {
    var commonHTML = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-comment level' + level + '" data-user-id="' + commentInfo.commentUserId + '" data-comment-id="' + commentInfo.commentId + '">';
    commonHTML += '     <div class="xtl-comment-user-img"><img src="' + commentInfo.commentUserHeadImg + '"></div>';
    commonHTML += '     <div class="xtl-comment-user-info">';
    if (level === 1) {
        commonHTML += '         <div class="xtl-comment-user-name">' + commentInfo.commentUserName + '</div>';
    } else {
        commonHTML += '         <div class="xtl-comment-user-name">' + commentInfo.commentUserName + '</div> 回复 <div class="xtl-comment-user-name">' + commentInfo.commentParentUserName + '</div>';
    }
    commonHTML += '         <div class="xtl-comment-content">' + commentVal + '</div>';
    commonHTML += '         <div class="xtl-comment-time">';
    commonHTML += '             <span class="gray"><i class="fa fa-clock-o" aria-hidden="true"></i> 刚刚</span>';
    commonHTML += '             <span class="blue xtl-comment-reply" data-user-name="' + commentInfo.commentUserName + '" data-user-id="' + commentInfo.commentUserId + '" data-comment-id="' + commentInfo.commentId + '"><i class="fa fa-commenting" aria-hidden="true"></i> 回复</span>';
    commonHTML += '         </div>';
    if (level === 1) {
        commonHTML += '     <div class="level2-common-content"></div>';
        commonHTML += '     <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-comment-reply-content"></div>';
    }
    commonHTML += '     </div>';
    commonHTML += '</div>';
    return commonHTML;
}