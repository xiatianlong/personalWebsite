<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp"/>
    <title>夏天龙的个人网站</title>
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
                    <c:choose>
                        <c:when test="${not empty bannerList && bannerList.size() gt 0}">
                            <c:forEach items="${bannerList}" var="banner">
                                <c:choose>
                                    <c:when test="${not empty banner.bannerUri}">
                                        <div><a href="${banner.bannerUri}" target="_blank"><img
                                                src="${banner.bannerImgFile.fileUrl}" alt="${banner.bannerText}"></a>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div><img src="${banner.bannerImgFile.fileUrl}" alt="${banner.bannerText}">
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div><img
                                    src="${pageContext.request.contextPath}/resources/images/banner/defaultBanner.jpg">
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm4 layui-col-md4" id="xtl-index-banner-right">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 text-c" id="xtl-index-data-statistics">
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">${articleCnt}</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">${noteCnt}</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">${userCnt}</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">${commentCnt}</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">文章数</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">笔记数</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">用户数</div>
                    <div class="layui-col-xs3 layui-col-sm3 layui-col-md3">评论数</div>
                </div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 text-c horizontal-vertical-middle submission-and-leaveMessage">
                    <div>
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue sal-text">欢迎投稿、留言</div>
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <a href="${pageContext.request.contextPath}/member/publish"
                               class="layui-btn layui-btn-normal">我要投稿</a>
                            <a href="${pageContext.request.contextPath}/message" class="layui-btn layui-btn-primary">我要留言</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${not empty userEntityList && userEntityList.size() gt 0}">
        <div class="layui-row">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">最新用户</div>
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" id="xtl-index-new-user-list">
                    <c:forEach items="${userEntityList}" var="user">
                        <div class="layui-col-xs3 layui-col-sm2 layui-col-md1 xtl-index-new-user-item"
                             title="${user.userName}">
                            <img src="${user.userHeadImg}">
                            <a href="${pageContext.request.contextPath}/user/${user.userId}" target="_blank"
                               class="layui-elip">${user.userName}</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:if>

    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12" id="listContent">
                <c:choose>
                    <c:when test="${not empty viewList && viewList.size() gt 0}">
                        <c:forEach items="${viewList}" var="viewItem">
                            <c:choose>
                                <c:when test="${'article' eq viewItem.type}">
                                    <c:set var="article" value="${viewItem}" scope="request"/>
                                    <jsp:include page="article/articleCardForIndex.jsp"/>
                                </c:when>
                                <c:when test="${'note' eq viewItem.type}">
                                    <c:set var="note" value="${viewItem}" scope="request"/>
                                    <jsp:include page="note/noteCardForIndex.jsp"/>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 horizontal-vertical-middle xtl-blank-page">
                            <div><img src="${pageContext.request.contextPath}/resources/images/fish.png"
                                      draggable="false"></div>
                            <div>没有搜索到结果....</div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-5 text-c bg-white <c:if test="${empty hasMore || !hasMore}">hide</c:if> "
                 id="hasMoreContent">
                <span id="loadMore">加载更多 <i class="fa fa-chevron-down" aria-hidden="true"></i></span>
            </div>
        </div>

        <div class="layui-col-xs-12 layui-col-sm12 layui-col-md4 index-right-content">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block">
                <div class="xtl-search-input-content">
                    <input type="text" name="keyword" placeholder="请输入标题关键字" autocomplete="off" class="layui-input">
                    <i class="layui-icon" id="searchBtn">&#xe615;</i>
                </div>
            </div>

            <c:if test="${not empty hotList && hotList.size() gt 0}">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">热门发布</div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                        <c:forEach items="${hotList}" var="hotItem" varStatus="varStatus">
                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-hot-item <c:if test="${varStatus.index == 0}">padding-t-0</c:if> ">
                                <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip"
                                     title="${hotItem.title}">
                                    <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                                    <c:choose>
                                        <c:when test="${'article' eq hotItem.type}">
                                            <a href="${pageContext.request.contextPath}/article/${hotItem.id}"
                                               target="_blank" class="article-hot-title">${hotItem.title}</a>
                                        </c:when>
                                        <c:when test="${'note' eq hotItem.type}">
                                            <a href="${pageContext.request.contextPath}/note/${hotItem.id}"
                                               target="_blank" class="article-hot-title">${hotItem.title}</a>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                                    <span><i class="fa fa-eye" aria-hidden="true"></i> ${hotItem.viewsCnt}</span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <c:if test="${not empty newList && newList.size() gt 0}">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">最新发布</div>
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                        <c:forEach items="${newList}" var="newItem" varStatus="varStatus">
                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-new-item <c:if test="${varStatus.index == 0}">padding-t-0</c:if> ">
                                <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-elip"
                                     title="${newItem.title}">
                                    <i class="fa fa-hand-o-right blue" aria-hidden="true"></i>
                                    <c:choose>
                                        <c:when test="${'article' eq newItem.type}">
                                            <a href="${pageContext.request.contextPath}/article/${newItem.id}"
                                               target="_blank" class="article-new-title">${newItem.title}</a>
                                        </c:when>
                                        <c:when test="${'note' eq newItem.type}">
                                            <a href="${pageContext.request.contextPath}/note/${newItem.id}"
                                               target="_blank" class="article-new-title">${newItem.title}</a>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 gray">
                                    <span><i class="fa fa-clock-o"
                                             aria-hidden="true"></i> ${newItem.fmtCreateTimeCn}</span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                </div>
            </c:if>

            <c:if test="${not empty hotCommentUser && hotCommentUser.size() gt 0}">
                <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block margin-t-15">
                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 blue xtl-block-title">热评用户</div>

                    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-10">
                        <c:forEach items="${hotCommentUser}" var="user" varStatus="index">
                            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 hot-comment-user vertical-middle">
                                <div class="layui-col-xs1 layui-col-sm1 layui-col-md1"><span
                                        class="layui-badge">0${index.index+1}</span></div>
                                <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 text-c">
                                    <img src="${user.userHeadImg}">
                                </div>
                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-elip">
                                    <a href="${pageContext.request.contextPath}/user/${user.commentUserId}"
                                       target="_blank" class="hot-comment-user-name">${user.userName}</a>
                                </div>
                                <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                                    <i class="fa fa-commenting-o" aria-hidden="true"></i> ${user.commentCount}
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

        </div>

    </div>

</div>

<jsp:include page="base/footer.jsp"/>
<script src="${pageContext.request.contextPath}/resources/js/biz/home/index.js"></script>
</body>
</html>