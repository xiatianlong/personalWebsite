/**
 * 我的笔记列表js.
 */

$(function () {

// 文章状态查询处理
    $(".query-note-status").on('click', function () {
        var that = $(this);
        var noteStatus = that.data("value");
        if (that.hasClass("active")) {
            that.removeClass("active");
            if ($("#myNoteListQuestForm").find("input#noteStatus" + noteStatus).length > 0) {
                $("#myNoteListQuestForm").find("input#noteStatus" + noteStatus).remove();
            }
        } else {
            that.addClass("active");
            $("#myNoteListQuestForm").append('<input type="hidden" name="noteStatus" value="' + noteStatus + '" id="noteStatus' + noteStatus + '">')
        }
        submitQuery();
    });

    // 文章分类查询处理
    $(".query-note-category").on('click', function () {
        var that = $(this);
        var noteCategory = that.text();
        if (that.hasClass("active")) {
            that.removeClass("active");
            if ($("#myNoteListQuestForm").find("input#noteCategory" + noteCategory).length > 0) {
                $("#myNoteListQuestForm").find("input#noteCategory" + noteCategory).remove();
            }
        } else {
            that.addClass("active");
            $("#myNoteListQuestForm").append('<input type="hidden" name="noteCategory" value="' + noteCategory + '" id="noteCategory' + noteCategory + '">')
        }
        submitQuery();
    });

    // 加载更多查询
    $("#loadMore").on('click', function () {
        $("#myNoteListQuestForm").append('<input type="hidden" name="noteId" value="' + $("input[name='loadMoreNoteId']").last().val() + '">');
        common.ajax({
            url: "/member/note/query",
            type: "POST",
            data: $("#myNoteListQuestForm").serialize(),
            success: function (res) {
                if (res.result === 'success') {
                    // 是否显示加载更多
                    if (res.hasMore) {
                        $("#hasMoreContent").removeClass("hide");
                        $("#hasMoreContent").addClass("show");
                    } else {
                        $("#hasMoreContent").removeClass("show");
                        $("#hasMoreContent").addClass("hide");
                    }
                    if (EasyCheck.StringUtils.isNotEmpty(res.noteCardList) && res.noteCardList.length > 0) {
                        // 拼装数据
                        for (var i = 0; i < res.noteCardList.length; i++) {
                            $("#myNoteListContent").append(buildNoteCard(res.noteCardList[i]));
                        }
                    } else {
                        layer.msg("没有更多数据了", {icon: 7, anim: 6});
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            },
            complete: function () {
                $("#myNoteListQuestForm").find("input[name='noteId']").remove();
            }
        });
    });


    /**
     * 提交查询请求
     */
    function submitQuery() {
        common.ajax({
            url: "/member/note/query",
            type: "POST",
            data: $("#myNoteListQuestForm").serialize(),
            success: function (res) {
                if (res.result === 'success') {
                    // 是否显示加载更多
                    if (res.hasMore) {
                        $("#hasMoreContent").removeClass("hide");
                        $("#hasMoreContent").addClass("show");
                    } else {
                        $("#hasMoreContent").removeClass("show");
                        $("#hasMoreContent").addClass("hide");
                    }
                    $("#myNoteListContent").empty();
                    if (EasyCheck.StringUtils.isNotEmpty(res.noteCardList) && res.noteCardList.length > 0) {
                        // 拼装数据
                        for (var i = 0; i < res.noteCardList.length; i++) {
                            $("#myNoteListContent").append(buildNoteCard(res.noteCardList[i]));
                        }
                    } else {
                        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 horizontal-vertical-middle xtl-blank-page">';
                        html += '   <div><img src="/resources/images/fish.png" draggable="false"></div>';
                        html += '   <div>没有搜索到结果....</div>';
                        html += '</div>';
                        $("#myNoteListContent").append(html);
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    }

    /**
     * 构建笔记卡片html
     * @param note
     * @returns {string}
     */
    function buildNoteCard(note) {
        var html = '';

        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">';
        html += '<div class="article-title">';
        if ('003001' === note.noteStatus) {
            html += ' <span class="layui-badge layui-bg-gray">草稿</span>';
        } else if ('003002' === note.noteStatus) {
            html += ' <span class="layui-badge layui-bg-orange">审核中</span>';
        } else if ('003003' === note.noteStatus) {
            html += ' <span class="layui-badge layui-bg-green">已发布</span>';
        } else if ('003004' === note.noteStatus) {
            html += ' <span class="layui-badge layui-bg-red">审核不通过</span>';
        }
        html += '&nbsp;' + note.noteTitle;
        html += '</div>';
        html += '</div>';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15 vertical-middle">';
        html += '<div class="layui-col-xs3 layui-col-sm4 layui-col-md4 layui-elip">';
        html += '<span class="article-status gray">';
        if ('003001' === note.noteStatus) {
            html += '<span class="layui-badge-dot layui-bg-gray"></span>&nbsp;草稿';
        } else if ('003002' === note.noteStatus) {
            html += ' <span class="layui-badge-dot layui-bg-orange"></span>&nbsp;审核中';
        } else if ('003003' === note.noteStatus) {
            html += ' <span class="layui-badge-dot layui-bg-green"></span>&nbsp;已发布';
        } else if ('003004' === note.noteStatus) {
            html += ' <span class="layui-badge-dot layui-bg-red"></span>&nbsp;审核不通过';
        }
        html += '</span>';
        html += '</div>';
        html += '<div class="layui-col-xs4 layui-col-sm4 layui-col-md4 green">';
        if (EasyCheck.StringUtils.isNotEmpty(note.fmtCategoryList)) {
            html += '<span><i class="fa fa-tag" aria-hidden="true"></i> ' + note.fmtCategoryList + '</span>';
        }
        html += '</div>';
        html += '<div class="layui-col-xs5 layui-col-sm4 layui-col-md4 text-r">';
        html += '<div class="layui-btn-group">';
        html += '<a href="/member/note/' + note.noteId + '" class="layui-btn layui-btn-primary layui-btn-sm" title="详情">';
        html += '<i class="layui-icon">&#xe60b;</i>';
        html += '</a>';
        html += '<a href="/member/note/update/' + note.noteId + '" class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">';
        html += '<i class="layui-icon">&#xe642;</i>';
        html += '</a>';
        html += '<a href="/member/note/preview/' + note.noteId + '" class="layui-btn layui-btn-primary layui-btn-sm" title="预览">';
        html += '<i class="layui-icon">&#xe602;</i>';
        html += '</a>';
        html += '</div>';
        html += '</div>';
        html += '</div>';
        html += '<input type="hidden" name="loadMoreNoteId" value="' + note.noteId + '">';
        html += '</div>';
        return html;
    }

});