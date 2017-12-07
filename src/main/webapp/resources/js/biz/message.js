/***
 * 留言相关js
 * create by xiatianlong on 2017/12/06
 */

// 菜单
var messageMenu = ['bold','italic','underline','strikeThrough','foreColor','link','emoticon'];

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
    var messageVal = messageEditor.txt.html();
    // 防止xss攻击
    messageVal = filterXSS(messageVal);
    var appentHtml = buildCommonHTML(messageVal, 1);
    $("#xtl-comment-content").append(appentHtml);
});

// 创建回复富文本
var commentEditor = null;
$("#xtl-comment-content").off('click', '.xtl-comment-reply');
$("#xtl-comment-content").on('click', '.xtl-comment-reply', function () {
    // 先清除全部的富文本
    $(this).parents("#xtl-comment-content").find("div.xtl-comment-reply-content").empty();
    // 设置样式
    $(this).parents(".level1").find("div.xtl-comment-reply-content").addClass("margin-t-15");
    // 插入回复对象
    $(this).parents(".level1").find("div.xtl-comment-reply-content").append('<div class="comment-reply-to">回复&nbsp;<span class="xtl-comment-user-name">张三</span>：</div>');
    // 插入富文本容器
    $(this).parents(".level1").find("div.xtl-comment-reply-content").append('<div id="xtl-comment-editor"></div>');
    // 插入按钮
    $(this).parents(".level1").find("div.xtl-comment-reply-content").append('<a class="layui-btn layui-btn-normal layui-btn-sm margin-t-5 float-r" id="xtl-comment-editor-submit-btn"><i class="layui-icon">&#xe609;</i>  回复评论</a>');
    $(this).parents(".level1").find("div.xtl-comment-reply-content").append('<a class="layui-btn layui-btn-warm layui-btn-sm margin-t-5 margin-r-15 float-r" id="xtl-comment-editor-cancel-btn">取消</a>');
    // 初始富文本容器
    var commentE = window.wangEditor;
    commentEditor = new commentE('#xtl-comment-editor');
    // 自定义菜单配置
    commentEditor.customConfig.menus = messageMenu;
    // 表情
    commentEditor.customConfig.emotions = [{title: '默认',type: 'image',content: weboEmoji}];
    commentEditor.create();

    // 滚动到富文本的位置
    $("body,html").animate({scrollTop:$("#xtl-comment-editor").offset().top-($(window).height()/2)},100);

});

// 回复富文本的点击提交
$("#xtl-comment-content").off('click', '#xtl-comment-editor-submit-btn');
$("#xtl-comment-content").on('click', '#xtl-comment-editor-submit-btn', function () {
    var commentVal = commentEditor.txt.html();
    // 防止xss攻击
    commentVal = filterXSS(commentVal);
    var appendHtml = buildCommonHTML(commentVal, 2);

    // 插入新评论内容
    $(this).parents(".xtl-comment-user-info").find(".level2-common-content").append(appendHtml);

    // 清除全部的回复富文本相关
    $(this).parents("#xtl-comment-content").find("div.xtl-comment-reply-content").empty();
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
 * @returns {string}    拼接的内容
 */
function buildCommonHTML(commentVal, level) {
    var commonHTML = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-comment level' + level + '">';
    commonHTML += '     <div class="xtl-comment-user-img"><img src="'+contextPath+'/resources/images/icon/website_logo_64px.png"></div>';
    commonHTML += '     <div class="xtl-comment-user-info">';
    commonHTML += '         <div class="xtl-comment-user-name">李三</div> 回复 <div class="xtl-comment-user-name">夏天龙</div>';
    commonHTML += '         <div class="xtl-comment-content">' + commentVal + '</div>';
    commonHTML += '         <div class="xtl-comment-time">';
    commonHTML += '             <span class="gray"><i class="fa fa-clock-o" aria-hidden="true"></i> 1小时前</span>';
    commonHTML += '             <span class="blue xtl-comment-reply"><i class="fa fa-commenting" aria-hidden="true"></i> 回复</span>';
    commonHTML += '         </div>';
    if (level == 1){
        commonHTML += '     <div class="level2-common-content"></div>';
        commonHTML += '     <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-comment-reply-content"></div>';
    }
    commonHTML += '     </div>';
    commonHTML += '</div>';
    return commonHTML;
}