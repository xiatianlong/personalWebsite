<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp"/>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/biz/index.css">
</head>
<body>

<!--header begin-->
<jsp:include page="base/header.jsp"/>
<!--header end-->


<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block green margin-b-15">
            <i class="layui-icon">&#xe645;</i> 夏天龙的个人网站2.0版本上线啦！
        </div>
    </div>

    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm8 layui-col-md8">
            <div class="layui-carousel" id="xtl-index-banner">
                <div carousel-item>
                    <div><img src="${pageContext.request.contextPath}/resources/images/banner/banner1.jpg"></div>
                    <div><img src="${pageContext.request.contextPath}/resources/images/banner/banner2.jpg"></div>
                    <div><img src="${pageContext.request.contextPath}/resources/images/banner/banner3.jpg"></div>
                    <div><img src="${pageContext.request.contextPath}/resources/images/banner/banner4.jpg"></div>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm4 layui-col-md4" id="xtl-index-banner-right">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 text-c" id="xtl-index-data-statistics">
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">100</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">150</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">2000</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">20</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">文章数</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">笔记数</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">用户数</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">评论数</div>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 text-c horizontal-vertical-middle submission-and-leaveMessage">
                    <div>
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue sal-text">欢迎投稿、留言</div>
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <a href="${pageContext.request.contextPath}/member/publish" class="layui-btn layui-btn-normal">我要投稿</a>
                            <a href="${pageContext.request.contextPath}/message" class="layui-btn layui-btn-primary">我要留言</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">最新用户</div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" id="xtl-index-new-user-list">
                <div class="layui-col-xs3 layui-col-sm2 layui-col-md1 xtl-index-new-user-item" title="夏天龙夏天龙">
                    <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">
                    <span class="layui-elip">夏天龙夏天龙</span>
                </div>
                <div class="layui-col-xs3 layui-col-sm2 layui-col-md1 xtl-index-new-user-item" title="夏天龙夏天龙">
                    <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">
                    <span class="layui-elip">夏天龙夏天龙</span>
                </div>
                <div class="layui-col-xs3 layui-col-sm2 layui-col-md1 xtl-index-new-user-item" title="夏天龙夏天龙">
                    <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">
                    <span class="layui-elip">夏天龙夏天龙</span>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">
                <div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">
                    <img src="${pageContext.request.contextPath}/resources/images/banner/banner1.jpg">
                </div>
                <div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">
                    <div class="article-title layui-elip"><span class="layui-badge">置顶</span>
                        这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
                    </div>
                    <div class="article-summary">
                        文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要
                    </div>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">
                        <span><i class="fa fa-tag" aria-hidden="true"></i>文章分类</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">
                        <span class="article-create-user"><i class="fa fa-user-o"
                                                             aria-hidden="true"></i> 夏天龙夏天龙夏天龙夏天龙</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">
                        <span><i class="fa fa-clock-o" aria-hidden="true"></i>2017-01-01 12:12:12</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">
                        <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        <span class="padding-l-10"><i class="fa fa-commenting-o" aria-hidden="true"></i> 100</span>
                    </div>
                </div>
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">
                    <div class="article-title layui-elip"><span class="layui-badge">置顶</span>
                        这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
                    </div>
                    <div class="article-summary">
                        文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要
                    </div>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">
                        <span><i class="fa fa-tag" aria-hidden="true"></i>文章分类</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">
                        <span class="article-create-user"><i class="fa fa-user-o"
                                                             aria-hidden="true"></i> 夏天龙夏天龙夏天龙夏天龙</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">
                        <span><i class="fa fa-clock-o" aria-hidden="true"></i>2017-01-01 12:12:12</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">
                        <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        <span class="padding-l-10"><i class="fa fa-commenting-o" aria-hidden="true"></i> 100</span>
                    </div>
                </div>
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">
                <div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">
                    <img src="${pageContext.request.contextPath}/resources/images/banner/banner1.jpg">
                </div>
                <div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">
                    <div class="article-title layui-elip"><span class="layui-badge">置顶</span>
                        这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
                    </div>
                    <div class="article-summary">
                        文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要
                    </div>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">
                        <span><i class="fa fa-tag" aria-hidden="true"></i>文章分类</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">
                        <span class="article-create-user"><i class="fa fa-user-o"
                                                             aria-hidden="true"></i> 夏天龙夏天龙夏天龙夏天龙</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">
                        <span><i class="fa fa-clock-o" aria-hidden="true"></i>2017-01-01 12:12:12</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">
                        <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        <span class="padding-l-10"><i class="fa fa-commenting-o" aria-hidden="true"></i> 100</span>
                    </div>
                </div>
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">
                    <div class="article-title layui-elip"><span class="layui-badge">置顶</span>
                        这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
                    </div>
                    <div class="article-summary">
                        文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要
                    </div>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">
                        <span><i class="fa fa-tag" aria-hidden="true"></i>文章分类</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">
                        <span class="article-create-user"><i class="fa fa-user-o"
                                                             aria-hidden="true"></i> 夏天龙夏天龙夏天龙夏天龙</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">
                        <span><i class="fa fa-clock-o" aria-hidden="true"></i>2017-01-01 12:12:12</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">
                        <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        <span class="padding-l-10"><i class="fa fa-commenting-o" aria-hidden="true"></i> 100</span>
                    </div>
                </div>
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">
                <div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">
                    <img src="${pageContext.request.contextPath}/resources/images/banner/banner1.jpg">
                </div>
                <div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">
                    <div class="article-title layui-elip"><span class="layui-badge">置顶</span>
                        这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
                    </div>
                    <div class="article-summary">
                        文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要
                    </div>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">
                        <span><i class="fa fa-tag" aria-hidden="true"></i>文章分类</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">
                        <span class="article-create-user"><i class="fa fa-user-o"
                                                             aria-hidden="true"></i> 夏天龙夏天龙夏天龙夏天龙</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">
                        <span><i class="fa fa-clock-o" aria-hidden="true"></i>2017-01-01 12:12:12</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">
                        <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        <span class="padding-l-10"><i class="fa fa-commenting-o" aria-hidden="true"></i> 100</span>
                    </div>
                </div>
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">
                    <div class="article-title layui-elip"><span class="layui-badge">置顶</span>
                        这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
                    </div>
                    <div class="article-summary">
                        文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要文章摘要
                    </div>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">
                        <span><i class="fa fa-tag" aria-hidden="true"></i>文章分类</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">
                        <span class="article-create-user"><i class="fa fa-user-o"
                                                             aria-hidden="true"></i> 夏天龙夏天龙夏天龙夏天龙</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">
                        <span><i class="fa fa-clock-o" aria-hidden="true"></i>2017-01-01 12:12:12</span>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">
                        <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        <span class="padding-l-10"><i class="fa fa-commenting-o" aria-hidden="true"></i> 100</span>
                    </div>
                </div>
            </div>


        </div>

        <div class="layui-col-xs-12 layui-col-sm12 layui-col-md4 index-right-content">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">文章分类</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10 article-classification">
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1分类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类21</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1分类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类21</a>
                </div>

            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">热门文章</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-hot-item padding-t-0">
                        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                            <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                            <span class="article-hot-title">这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题</span>
                        </div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                            <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        </div>
                    </div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-hot-item">
                        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                            <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                            <span class="article-hot-title">这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题</span>
                        </div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                            <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        </div>
                    </div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-hot-item">
                        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                            <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                            <span class="article-hot-title">这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题</span>
                        </div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                            <span><i class="fa fa-eye" aria-hidden="true"></i> 123580</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">最新文章</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-new-item padding-t-0">
                        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                            <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                            <span class="article-new-title">这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题</span>
                        </div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                            <span><i class="fa fa-clock-o" aria-hidden="true"></i> 今天</span>
                        </div>
                    </div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-new-item">
                        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                            <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                            <span class="article-new-title">这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题</span>
                        </div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                            <span><i class="fa fa-clock-o" aria-hidden="true"></i> 昨天</span>
                        </div>
                    </div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-new-item">
                        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                            <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                            <span class="article-new-title">这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题</span>
                        </div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                            <span><i class="fa fa-clock-o" aria-hidden="true"></i> 2天前</span>
                        </div>
                    </div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-new-item">
                        <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip">
                            <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                            <span class="article-new-title">这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题这是文章标题</span>
                        </div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                            <span><i class="fa fa-clock-o" aria-hidden="true"></i> 12个月前</span>
                        </div>
                    </div>
                </div>

            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">热评用户</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 hot-comment-user vertical-middle">
                        <div class="layui-col-xs1 layui-col-sm1 layui-col-md1"><span class="layui-badge">01</span></div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 text-c">
                            <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-elip">
                            <span class="hot-comment-user-name">夏天龙夏天龙夏天龙</span>
                        </div>
                        <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                            <i class="fa fa-commenting-o" aria-hidden="true"></i> 100
                        </div>
                    </div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 hot-comment-user vertical-middle">
                        <div class="layui-col-xs1 layui-col-sm1 layui-col-md1"><span class="layui-badge">02</span></div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 text-c">
                            <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-elip">
                            <span class="hot-comment-user-name">夏天龙夏天龙夏天龙</span>
                        </div>
                        <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                            <i class="fa fa-commenting-o" aria-hidden="true"></i> 100
                        </div>
                    </div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 hot-comment-user vertical-middle">
                        <div class="layui-col-xs1 layui-col-sm1 layui-col-md1"><span class="layui-badge">03</span></div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 text-c">
                            <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-elip">
                            <span class="hot-comment-user-name">夏天龙夏天龙夏天龙</span>
                        </div>
                        <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                            <i class="fa fa-commenting-o" aria-hidden="true"></i> 100
                        </div>
                    </div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 hot-comment-user vertical-middle">
                        <div class="layui-col-xs1 layui-col-sm1 layui-col-md1"><span class="layui-badge">04</span></div>
                        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 text-c">
                            <img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png">
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-elip">
                            <span class="hot-comment-user-name">夏天龙夏天龙夏天龙</span>
                        </div>
                        <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                            <i class="fa fa-commenting-o" aria-hidden="true"></i> 100
                        </div>
                    </div>
                </div>
            </div>


        </div>


    </div>


</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!-- 你的HTML代码 -->

<jsp:include page="base/footer.jsp"/>
<script>

    layui.use(['carousel', 'form'], function () {
        var carousel = layui.carousel, form = layui.form;

        //图片轮播
        carousel.render({
            elem: '#xtl-index-banner'
            , width: '100%'
            , height: '300px'
            , interval: 3000,
            arrow: 'always'
        });

    });

</script>
</body>
</html>