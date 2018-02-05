/**
 * 我的文章列表js.
 */

$(function () {

    // 文章状态查询处理
    $(".query-article-status").on('click', function () {
        var that = $(this);
        var articleStatus = that.data("value");
        if (that.hasClass("active")) {
            that.removeClass("active");
            if ($("#myArticleListQuestForm").find("input#articleStatus" + articleStatus).length > 0) {
                $("#myArticleListQuestForm").find("input#articleStatus" + articleStatus).remove();
            }
        } else {
            that.addClass("active");
            $("#myArticleListQuestForm").append('<input type="hidden" name="articleStatus" value="' + articleStatus + '" id="articleStatus' + articleStatus + '">')
        }
        submitQuery();
    });

    // 文章分类查询处理
    $(".query-article-category").on('click', function () {
        var that = $(this);
        var articleCategory = that.text();
        if (that.hasClass("active")) {
            that.removeClass("active");
            if ($("#myArticleListQuestForm").find("input#articleCategory" + articleCategory).length > 0) {
                $("#myArticleListQuestForm").find("input#articleCategory" + articleCategory).remove();
            }
        } else {
            that.addClass("active");
            $("#myArticleListQuestForm").append('<input type="hidden" name="articleCategory" value="' + articleCategory + '" id="articleCategory' + articleCategory + '">')
        }
        submitQuery();
    });



    // 加载更多查询
    $("#loadMore").on('click', function () {
        $("#myArticleListQuestForm").append('<input type="hidden" name="articleId" value="' + $("input[name='loadMoreArticleId']").last().val() + '">');
        common.ajax({
            url: "/member/article/query",
            type: "POST",
            data: $("#myArticleListQuestForm").serialize(),
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
                            $("#myArticleListContent").append(buildArticleCard(res.articleCardList[i]));
                        }
                    } else {
                        layer.msg("没有更多数据了", {icon: 7, anim: 6});
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            },
            complete: function () {
                $("#myArticleListQuestForm").find("input[name='articleId']").remove();
            }
        });
    });

    /**
     * 提交查询请求
     */
    function submitQuery() {
        common.ajax({
            url: "/member/article/query",
            type: "POST",
            data: $("#myArticleListQuestForm").serialize(),
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
                    $("#myArticleListContent").empty();
                    if (EasyCheck.StringUtils.isNotEmpty(res.articleCardList) && res.articleCardList.length > 0) {
                        // 拼装数据
                        for (var i = 0; i < res.articleCardList.length; i++) {
                            $("#myArticleListContent").append(buildArticleCard(res.articleCardList[i]));
                        }
                    } else {
                        var html = '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 horizontal-vertical-middle xtl-blank-page">';
                        html += '   <div><img src="/resources/images/fish.png" draggable="false"></div>';
                        html += '   <div>没有搜索到结果....</div>';
                        html += '</div>';
                        $("#myArticleListContent").append(html);
                    }
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });

    }


    /**
     * 构建文章卡片html
     * @param article
     * @returns {string}
     */
    function buildArticleCard(article) {
        var html = '';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">';
        if (EasyCheck.StringUtils.isEmpty(article.articleImgUrl)) {
            html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">';
            html += '   <div class="article-title layui-elip" title="' + article.articleTitle + '">';
            if ('002001' === article.articleStatus) {
                html += ' <span class="layui-badge layui-bg-gray">草稿</span>';
            } else if ('002002' === article.articleStatus) {
                html += ' <span class="layui-badge layui-bg-orange">审核中</span>';
            } else if ('002003' === article.articleStatus) {
                html += ' <span class="layui-badge layui-bg-green">已发布</span>';
            } else if ('002004' === article.articleStatus) {
                html += ' <span class="layui-badge layui-bg-red">审核不通过</span>';
            }
            html += '&nbsp;';
            html += article.articleTitle;
            html += '   </div>';
            html += '   <div class="article-summary">';
            if (EasyCheck.StringUtils.isNotEmpty(article.articleIntroduction)) {
                html += article.articleIntroduction;
            } else {
                html += '暂无文章摘要';
            }
            html += '   </div>';
            html += '</div>';
        } else {
            html += '<div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">';
            html += '<img src="' + article.articleImgUrl + '">';
            html += '</div>';
            html += '<div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">';
            html += '<div class="article-title layui-elip" title="' + article.articleTitle + '">';
            if ('002001' === article.articleStatus) {
                html += ' <span class="layui-badge layui-bg-gray">草稿</span>';
            } else if ('002002' === article.articleStatus) {
                html += ' <span class="layui-badge layui-bg-orange">审核中</span>';
            } else if ('002003' === article.articleStatus) {
                html += ' <span class="layui-badge layui-bg-green">已发布</span>';
            } else if ('002004' === article.articleStatus) {
                html += ' <span class="layui-badge layui-bg-red">审核不通过</span>';
            }
            html += '&nbsp;';
            html += article.articleTitle;
            html += '</div>';
            html += '<div class="article-summary">';
            if (EasyCheck.StringUtils.isNotEmpty(article.articleIntroduction)) {
                html += article.articleIntroduction;
            } else {
                html += '暂无文章摘要';
            }
            html += '   </div>';
            html += '</div>';
        }
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15 vertical-middle">';
        html += '<div class="layui-col-xs3 layui-col-sm4 layui-col-md4 layui-elip">';
        if ('002001' === article.articleStatus) {
            html += ' <span class="layui-badge-dot layui-bg-gray"></span>&nbsp;草稿';
        } else if ('002002' === article.articleStatus) {
            html += ' <span class="layui-badge-dot layui-bg-orange"></span>&nbsp;审核中';
        } else if ('002003' === article.articleStatus) {
            html += ' <span class="layui-badge-dot layui-bg-green"></span>&nbsp;已发布';
        } else if ('002004' === article.articleStatus) {
            html += ' <span class="layui-badge-dot layui-bg-red"></span>&nbsp;审核不通过';
        }
        html += '<span class="article-status gray">';
        html += '</span>';
        html += '</div>';
        html += '<div class="layui-col-xs4 layui-col-sm4 layui-col-md4 green">';
        if (EasyCheck.StringUtils.isNotEmpty(article.fmtCategoryList)) {
            html += '<span><i class="fa fa-tag" aria-hidden="true"></i> ' + article.fmtCategoryList + '</span>';
        }
        html += '</div>';
        html += '<div class="layui-col-xs5 layui-col-sm4 layui-col-md4 text-r">';
        html += '<div class="layui-btn-group">';
        html += '<a href="/member/article/' + article.articleId + '" class="layui-btn layui-btn-primary layui-btn-sm" title="详情">';
        html += '<i class="layui-icon">&#xe60b;</i>';
        html += '</a>';
        html += '<button class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">';
        html += '<i class="layui-icon">&#xe642;</i>';
        html += '</button>';
        html += '<button class="layui-btn layui-btn-primary layui-btn-sm" title="预览">';
        html += '<i class="layui-icon">&#xe602;</i>';
        html += '</button>';
        html += '</div>';
        html += '</div>';
        html += '</div>';
        html += '<input type="hidden" name="loadMoreArticleId" value="' + article.articleId + '">';
        html += '</div>';
        return html;
    }

});