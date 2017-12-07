<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>Title</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/myPublishArticleList.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="personalCenter.html">个人中心</a>
      <a><cite>我的文章</cite></a>
    </span>
</div>


<div class="layui-container">

    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">
                <div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">
                    <img src="${pageContext.request.contextPath}/resources/images/banner/banner1.jpg">
                </div>
                <div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">
                    <div class="article-title layui-elip"><span class="layui-badge layui-bg-gray">草稿</span>&nbsp;这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
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
                        <span class="article-status gray">
                             <span class="layui-badge-dot layui-bg-gray"></span>&nbsp;草稿
                        </span>
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
                    <div class="article-title layui-elip"><span class="layui-badge layui-bg-orange">审核中</span>&nbsp;这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
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
                        <span class="article-status orange">
                              <span class="layui-badge-dot layui-bg-orange"></span>&nbsp;审核中
                        </span>
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
                    <div class="article-title layui-elip"><span class="layui-badge layui-bg-green">已发布</span>&nbsp;这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
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
                        <span class="article-status green">
                              <span class="layui-badge-dot layui-bg-green"></span>&nbsp;已发布
                        </span>
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
                    <div class="article-title layui-elip"><span class="layui-badge layui-bg-red">审核不通过</span>&nbsp;这是一篇文章的标题这是一篇文章的标题这是一篇文章的标题
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
                        <span class="article-status red">
                              <span class="layui-badge-dot"></span>&nbsp;审核不通过
                        </span>
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
        <div class="layui-col-xs-12 layui-col-sm12 layui-col-md4 padding-l-15">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 text-c horizontal-vertical-middle submission-and-leaveMessage">
                    <div>
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue sal-text">欢迎投稿、留言</div>
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <a class="layui-btn layui-btn-normal">我要投稿</a>
                            <a href="${pageContext.request.contextPath}/message" class="layui-btn layui-btn-primary">我要留言</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">文章状态</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10" id="article-status-content">
                    <a class="layui-btn layui-btn-primary layui-btn-sm active">草稿</a>
                    <a class="layui-btn layui-btn-warm layui-btn-sm active">审核中</a>
                    <a class="layui-btn layui-btn-sm">已发布</a>
                    <a class="layui-btn layui-btn-danger layui-btn-sm">审核未通过</a>
                </div>

            </div>

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">文章分类</div>

                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10 article-classification">
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1分类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm active">分类</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类21</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1分类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类1类1</a>
                    <a class="layui-btn layui-btn-primary layui-btn-sm">分类21</a>
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