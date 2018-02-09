/**
 * 文章列表js.
 */

$(function () {

    // 文章分类查询处理
    $(".query-article-category").on('click', function () {
        var that = $(this);
        var articleCategory = that.text();
        if (that.hasClass("active")) {
            that.removeClass("active");
            if ($("#articleListQuestForm").find("input#articleCategory" + articleCategory).length > 0) {
                $("#articleListQuestForm").find("input#articleCategory" + articleCategory).remove();
            }
        } else {
            that.addClass("active");
            $("#articleListQuestForm").append('<input type="hidden" name="articleCategory" value="' + articleCategory + '" id="articleCategory' + articleCategory + '">')
        }
        common.ajax({
            url: "/article/query",
            type: "POST",
            data: $("#articleListQuestForm").serialize(),
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
                    $("#articleListContent").empty();
                    if (EasyCheck.StringUtils.isNotEmpty(res.articleCardList) && res.articleCardList.length > 0) {
                        // 拼装数据
                        for (var i = 0; i < res.articleCardList.length; i++) {
                            $("#articleListContent").append(buildArticleCard(res.articleCardList[i]));
                        }
                    } else {
                        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 horizontal-vertical-middle xtl-blank-page">';
                        html += '   <div><img src="/resources/images/fish.png" draggable="false"></div>';
                        html += '   <div>没有搜索到结果....</div>';
                        html += '</div>';
                        $("#articleListContent").append(html);
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    });

    // 加载更多查询
    $("#loadMore").on('click', function () {
        $("#articleListQuestForm").append('<input type="hidden" name="articleId" value="' + $("input[name='loadMoreArticleId']").last().val() + '">');
        common.ajax({
            url: "/article/query",
            type: "POST",
            data: $("#articleListQuestForm").serialize(),
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
                    if (EasyCheck.StringUtils.isNotEmpty(res.articleCardList) && res.articleCardList.length > 0) {
                        // 拼装数据
                        for (var i = 0; i < res.articleCardList.length; i++) {
                            $("#articleListContent").append(buildArticleCard(res.articleCardList[i]));
                        }
                    } else {
                        layer.msg("没有更多数据了", {icon: 7, anim: 6});
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            },
            complete: function () {
                $("#articleListQuestForm").find("input[name='articleId']").remove();
            }
        });
    });


    /**
     * 构建文章卡片html
     * @param article   文章
     * @returns {string}    html
     */
    function buildArticleCard(article) {
        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">';
        if (EasyCheck.StringUtils.isNotEmpty(article.articleImgUrl)) {
            html += '<div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">';
            html += '<img src="' + article.articleImgUrl + '">';
            html += '</div>';
            html += '<div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">';
            html += '<div class="article-title layui-elip">';
            if (article.top) {
                html += '<span class="layui-badge">置顶</span>';
            }
            html += article.articleTitle;
            html += '</div>';
            html += '<div class="article-summary">' + article.articleIntroduction + '</div>';
            html += '</div>';
        } else {
            html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">';
            html += '<div class="article-title layui-elip">';
            if (article.top) {
                html += '<span class="layui-badge">置顶</span>';
            }
            html += article.articleTitle;
            html += '</div>';
            html += '<div class="article-summary">' + article.articleIntroduction + '</div>';
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
        html += '<span><i class="fa fa-eye" aria-hidden="true"></i> ' + article.articleViewsCnt + '</span>';
        html += '</div>';
        html += '</div>';
        html += '<input type="hidden" name="loadMoreArticleId" value="' + article.articleId + '">';
        html += '</div>';

        return html;
    }

})