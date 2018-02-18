/**
 * 笔记列表js.
 */

$(function () {

    // 笔记分类查询处理
    $(".query-note-category").on('click', function () {
        var that = $(this);
        var noteCategory = that.text();
        if (that.hasClass("active")) {
            that.removeClass("active");
            if ($("#noteListQuestForm").find("input#noteCategory" + noteCategory).length > 0) {
                $("#noteListQuestForm").find("input#noteCategory" + noteCategory).remove();
            }
        } else {
            that.addClass("active");
            $("#noteListQuestForm").append('<input type="hidden" name="noteCategory" value="' + noteCategory + '" id="noteCategory' + noteCategory + '">')
        }
        common.ajax({
            url: "/note/query",
            type: "POST",
            data: $("#noteListQuestForm").serialize(),
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
                    $("#noteListContent").empty();
                    if (EasyCheck.StringUtils.isNotEmpty(res.noteCardList) && res.noteCardList.length > 0) {
                        // 拼装数据
                        for (var i = 0; i < res.noteCardList.length; i++) {
                            $("#noteListContent").append(buildNoteCard(res.noteCardList[i]));
                        }
                    } else {
                        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 horizontal-vertical-middle xtl-blank-page">';
                        html += '   <div><img src="/resources/images/fish.png" draggable="false"></div>';
                        html += '   <div>没有搜索到结果....</div>';
                        html += '</div>';
                        $("#noteListContent").append(html);
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    });

    // 加载更多查询
    $("#loadMore").on('click', function () {
        $("#noteListQuestForm").append('<input type="hidden" name="noteId" value="' + $("input[name='loadMoreNoteId']").last().val() + '">');
        common.ajax({
            url: "/note/query",
            type: "POST",
            data: $("#noteListQuestForm").serialize(),
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
                            $("#noteListContent").append(buildNoteCard(res.noteCardList[i]));
                        }
                    } else {
                        layer.msg("没有更多数据了", {icon: 7, anim: 6});
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            },
            complete: function () {
                $("#noteListQuestForm").find("input[name='noteId']").remove();
            }
        });
    });


    /**
     * 构建笔记卡片html
     * @param note   笔记
     * @returns {string}    html
     */
    function buildNoteCard(note) {

        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">';
        html += '<div class="article-title">';
        if (note.top) {
            html += '<span class="layui-badge">置顶</span>';
        }
        html += ' ' + note.noteTitle;
        html += '</div>';
        html += '</div>';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">';
        html += '<div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">';
        html += '<span><i class="fa fa-tag" aria-hidden="true"></i> ' + note.fmtCategoryList + '</span>';
        html += '</div>';
        html += '<div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">';
        html += '<span class="article-create-user"><i class="fa fa-user-o" aria-hidden="true"></i> ' + note.userName + '</span>';
        html += '</div>';
        html += '<div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">';
        html += '<span><i class="fa fa-clock-o" aria-hidden="true"></i> ' + note.fmtCreateTime + '</span>';
        html += '</div>';
        html += '<div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">';
        html += '<span><i class="fa fa-eye" aria-hidden="true"></i> ' + note.noteViewsCnt + '</span>';
        html += '</div>';
        html += '</div>';
        html += '<input type="hidden" name="loadMoreNoteId" value="' + note.noteId + '">';
        html += '</div>';
        return html;

    }

})