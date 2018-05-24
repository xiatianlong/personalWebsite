/**
 * 首页js.
 */

layui.use(['carousel'], function () {
    var carousel = layui.carousel;
    //图片轮播
    carousel.render({
        elem: '#xtl-index-banner'
        , width: '100%'
        , height: '300px'
        , interval: 3000,
        arrow: 'always'
    });
});

$(function () {

    // 条件查询搜索点击处理
    $(".searchBtn").on('click', function () {
        search();
    });

    // 条件查询搜索回车处理
    $(".xtl-search-input-content").keydown(function () {
        if (event.keyCode == "13") {//keyCode=13是回车键
            search();
        }
    });

    // 加载更多
    $("#loadMore").on('click', function () {
        var keyword = $("input[name='keyword']").val();
        var loadMoreId = $("input[name='loadMoreId']").last().val();
        common.ajax({
            url: "/home/query",
            type: "POST",
            data: {
                keyword: keyword,
                orderKey: loadMoreId
            },
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
                    if (EasyCheck.StringUtils.isNotEmpty(res.articleNoteReviewPassedCards) && res.articleNoteReviewPassedCards.length > 0) {
                        // 拼装数据
                        for (var i = 0; i < res.articleNoteReviewPassedCards.length; i++) {
                            $("#listContent").append(buildCard(res.articleNoteReviewPassedCards[i]));
                        }
                    } else {
                        layer.msg("没有更多数据了", {icon: 7, anim: 6});
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    });

    /**
     * 关键字检索
     */
    function search() {
        var keyword = $("input[name='keyword']:visible").eq(0).val();
        common.ajax({
            url: "/home/query",
            type: "POST",
            data: {
                keyword: keyword
            },
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
                    $("#listContent").empty();
                    if (EasyCheck.StringUtils.isNotEmpty(res.articleNoteReviewPassedCards) && res.articleNoteReviewPassedCards.length > 0) {
                        // 拼装数据
                        for (var i = 0; i < res.articleNoteReviewPassedCards.length; i++) {
                            $("#listContent").append(buildCard(res.articleNoteReviewPassedCards[i]));
                        }
                    } else {
                        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 horizontal-vertical-middle xtl-blank-page">';
                        html += '   <div><img src="/resources/images/fish.png" draggable="false"></div>';
                        html += '   <div>没有搜索到结果....</div>';
                        html += '</div>';
                        $("#listContent").append(html);
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });

    }

    // 卡片去详情点击
    $("#listContent").on('click', '.xtl-article-card', function () {
        var type = $(this).data("type");
        if ('article' === type) {
            window.open("/article/" + $(this).data("articleId"));
        } else if ('note' === type) {
            window.open("/note/" + $(this).data("noteId"));
        }
    });

    /**
     * 构建列表卡片
     * @param card  card
     * @returns {string} html
     */
    function buildCard(card) {
        if ('article' === card.type) {
            return buildArticleCard(card);
        } else if ('note' === card.type) {
            return buildNoteCard(card);
        }
    }

    /**
     * 构建文章卡片
     * @param article card
     * @returns {string} html
     */
    function buildArticleCard(article) {
        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card" data-type="' + article.type + '" data-article-id="' + article.id + '">';
        if (EasyCheck.StringUtils.isNotEmpty(article.imgUrl)) {
            html += '<div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">';
            html += '<img src="' + article.imgUrl + '">';
            html += '</div>';
            html += '<div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">';
            html += '<div class="article-title layui-elip">';
            if (article.top) {
                html += '<span class="layui-badge">置顶</span> ';
            }
            html += article.title;
            html += '</div>';
            html += '<div class="article-summary">' + article.introduction + '</div>';
            html += '</div>';
        } else {
            html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">';
            html += '<div class="article-title layui-elip">';
            if (article.top) {
                html += '<span class="layui-badge">置顶</span> ';
            }
            html += article.title;
            html += '</div>';
            html += '<div class="article-summary">' + article.introduction + '</div>';
            html += '</div>';
        }
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">';
        html += '<div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">';
        html += '<span><i class="fa fa-tag" aria-hidden="true"></i> ' + article.fmtCategoryList + '</span>';
        html += '</div>';
        html += '<div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">';
        html += '<span class="article-create-user">';
        html += '<i class="fa fa-user-o" aria-hidden="true"></i> ' + article.userName;
        html += '</span>';
        html += '</div>';
        html += '<div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">';
        html += '<span><i class="fa fa-clock-o" aria-hidden="true"></i> ' + article.fmtCreateTime + '</span>';
        html += '</div>';
        html += '<div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">';
        html += '<span><i class="fa fa-eye" aria-hidden="true"></i> ' + article.viewsCnt + '</span>';
        html += '</div>';
        html += '</div>';
        html += '<input type="hidden" name="loadMoreId" value="' + article.orderKey + '">';
        html += '</div>';

        return html;
    }

    /**
     * 构建笔记卡片
     * @param note card
     * @returns {string} html
     */
    function buildNoteCard(note) {
        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card" data-type="' + note.type + '" data-note-id="' + note.id + '">';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">';
        html += '<div class="article-title">';
        if (note.top) {
            html += '<span class="layui-badge">置顶</span>';
        }
        html += ' ' + note.title;
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
        html += '<span><i class="fa fa-eye" aria-hidden="true"></i> ' + note.viewsCnt + '</span>';
        html += '</div>';
        html += '</div>';
        html += '<input type="hidden" name="loadMoreId" value="' + note.orderKey + '">';
        html += '</div>';
        return html;
    }

});