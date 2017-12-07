<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>Title</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/personalCenter.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
      <a><cite>个人中心</cite></a>
    </span>
</div>


<div class="layui-container">


    <!--上部部分begin-->
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block text-c padding-t-30 padding-b-30">
            <div id="personalCenterHeadImg"><img src="${pageContext.request.contextPath}/resources/images/icon/website_logo_64px.png"></div>
            <div class="margin-t-10 font-size-22">夏天龙</div>
            <div class="margin-t-5 gray font-size-14">2017-01-01 15:15:15 加入</div>
            <div class="margin-t-10">
                <a href="${pageContext.request.contextPath}/member/personalCenter/setting" class="layui-btn layui-btn-sm layui-btn-primary">
                    <i class="layui-icon">&#xe614;</i> 设置
                </a>
                <a class="layui-btn layui-btn-sm layui-btn-danger">
                    <i class="fa fa-sign-out" aria-hidden="true"></i> 注销
                </a>
            </div>
        </div>
    </div>
    <!--上部部分end-->

    <!--状态图例begin-->
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
            <span class="layui-badge-dot layui-bg-gray"></span>&nbsp;草稿&nbsp;&nbsp;
            <span class="layui-badge-dot layui-bg-orange"></span>&nbsp;审核中&nbsp;&nbsp;
            <span class="layui-badge-dot layui-bg-green"></span>&nbsp;已发布&nbsp;&nbsp;
            <span class="layui-badge-dot"></span>&nbsp;审核不通过
        </div>
    </div>
    <!--状态图例end-->

    <div class="layui-row layui-col-space20">
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md6" id="publishArticleContent">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title font-bold">我发布的文章</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 vertical-middle pc-article-item">
                    <span class="layui-badge-dot layui-bg-orange"></span>
                    <span class="layui-elip pc-article-item-title">我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题</span>
                    <div class="layui-btn-group">
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="详情">
                            <i class="layui-icon">&#xe60b;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">
                            <i class="layui-icon">&#xe642;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="预览">
                            <i class="layui-icon">&#xe602;</i>
                        </button>
                    </div>
                </div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 vertical-middle pc-article-item">
                    <span class="layui-badge-dot layui-bg-green"></span>
                    <span class="layui-elip pc-article-item-title">我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题</span>
                    <div class="layui-btn-group">
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="详情">
                            <i class="layui-icon">&#xe60b;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">
                            <i class="layui-icon">&#xe642;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="预览">
                            <i class="layui-icon">&#xe602;</i>
                        </button>
                    </div>
                </div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 vertical-middle pc-article-item">
                    <span class="layui-badge-dot layui-bg-blue"></span>
                    <span class="layui-elip pc-article-item-title">我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题</span>
                    <div class="layui-btn-group">
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="详情">
                            <i class="layui-icon">&#xe60b;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">
                            <i class="layui-icon">&#xe642;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="预览">
                            <i class="layui-icon">&#xe602;</i>
                        </button>
                    </div>
                </div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                    <a href="${pageContext.request.contextPath}/member/article/list" class="layui-btn layui-btn-xs layui-btn-normal">查看全部</a>
                </div>
            </div>
        </div>

        <div class="layui-col-xs12 layui-col-sm6 layui-col-md6" id="publishNoteContent">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title font-bold">我发布的笔记</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 vertical-middle pc-note-item">
                    <span class="layui-badge-dot layui-bg-orange"></span>
                    <span class="layui-elip pc-note-item-title">我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题</span>
                    <div class="layui-btn-group">
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="详情">
                            <i class="layui-icon">&#xe60b;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">
                            <i class="layui-icon">&#xe642;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="预览">
                            <i class="layui-icon">&#xe602;</i>
                        </button>
                    </div>
                </div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 vertical-middle pc-note-item">
                    <span class="layui-badge-dot layui-bg-green"></span>
                    <span class="layui-elip pc-note-item-title">我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题</span>
                    <div class="layui-btn-group">
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="详情">
                            <i class="layui-icon">&#xe60b;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">
                            <i class="layui-icon">&#xe642;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="预览">
                            <i class="layui-icon">&#xe602;</i>
                        </button>
                    </div>
                </div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 vertical-middle pc-note-item">
                    <span class="layui-badge-dot layui-bg-blue"></span>
                    <span class="layui-elip pc-note-item-title">我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题</span>
                    <div class="layui-btn-group">
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="详情">
                            <i class="layui-icon">&#xe60b;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">
                            <i class="layui-icon">&#xe642;</i>
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" title="预览">
                            <i class="layui-icon">&#xe602;</i>
                        </button>
                    </div>
                </div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                    <a href="" class="layui-btn layui-btn-xs layui-btn-normal">查看全部</a>
                </div>

            </div>
        </div>

        <div class="layui-col-xs12 layui-col-sm6 layui-col-md6" id="myCollectionContent">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title font-bold">我的收藏</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 vertical-middle pc-collection-item">
                    <span class="layui-badge layui-bg-green">文章</span>
                    <a href="#"
                       class="layui-elip pc-collection-item-title">我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题</a>
                </div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 vertical-middle pc-collection-item">
                    <span class="layui-badge layui-bg-blue">笔记</span>
                    <a href="#"
                       class="layui-elip pc-collection-item-title">我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题我是文章标题</a>
                </div>


                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                    <a href="" class="layui-btn layui-btn-xs layui-btn-normal">查看全部</a>
                </div>

            </div>
        </div>
    </div>


</div>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!-- 你的HTML代码 -->

<jsp:include page="../base/footer.jsp"/>

</body>
</html>