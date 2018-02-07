<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2017/12/10
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.personalWebsite.common.enums.ArticleStatus" %>
<c:set var="DRAFT" value="<%=ArticleStatus.DRAFT.getCode()%>" scope="request"/>
<c:set var="UNDER_REVIEW" value="<%=ArticleStatus.UNDER_REVIEW.getCode()%>" scope="request"/>
<c:set var="REVIEW_PASSED" value="<%=ArticleStatus.REVIEW_PASSED.getCode()%>" scope="request"/>
<c:set var="REVIEW_NOT_PASSED" value="<%=ArticleStatus.REVIEW_NOT_PASSED.getCode()%>" scope="request"/>
<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card">
    <c:choose>
        <c:when test="${empty article.articleImgUrl}">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">
                <div class="article-title layui-elip" title="${article.articleTitle}">
                    <c:choose>
                        <c:when test="${DRAFT eq article.articleStatus}"> <span
                                class="layui-badge layui-bg-gray">草稿</span></c:when>
                        <c:when test="${UNDER_REVIEW eq article.articleStatus}"> <span
                                class="layui-badge layui-bg-orange">审核中</span></c:when>
                        <c:when test="${REVIEW_PASSED eq article.articleStatus}"> <span
                                class="layui-badge layui-bg-green">已发布</span></c:when>
                        <c:when test="${REVIEW_NOT_PASSED eq article.articleStatus}"> <span
                                class="layui-badge layui-bg-red">审核不通过</span></c:when>
                    </c:choose>
                    &nbsp;
                        ${article.articleTitle}
                </div>
                <div class="article-summary">
                    <c:choose>
                        <c:when test="${not empty article.articleIntroduction}">
                            ${article.articleIntroduction}
                        </c:when>
                        <c:otherwise>
                            暂无文章摘要
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">
                <img src="${article.articleImgUrl}">
            </div>
            <div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">
                <div class="article-title layui-elip" title="${article.articleTitle}">
                    <c:choose>
                        <c:when test="${DRAFT eq article.articleStatus}"><span
                                class="layui-badge layui-bg-gray">草稿</span></c:when>
                        <c:when test="${UNDER_REVIEW eq article.articleStatus}"><span
                                class="layui-badge layui-bg-orange">审核中</span></c:when>
                        <c:when test="${REVIEW_PASSED eq article.articleStatus}"><span
                                class="layui-badge layui-bg-green">已发布</span></c:when>
                        <c:when test="${REVIEW_NOT_PASSED eq article.articleStatus}"><span
                                class="layui-badge layui-bg-red">审核不通过</span></c:when>
                    </c:choose>
                    &nbsp;
                        ${article.articleTitle}
                </div>
                <div class="article-summary">
                    <c:choose>
                        <c:when test="${not empty article.articleIntroduction}">
                            ${article.articleIntroduction}
                        </c:when>
                        <c:otherwise>
                            暂无文章摘要
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15 vertical-middle">
        <div class="layui-col-xs3 layui-col-sm4 layui-col-md4 layui-elip">
            <span class="article-status gray">
                 <c:choose>
                     <c:when test="${DRAFT eq article.articleStatus}"><span
                             class="layui-badge-dot layui-bg-gray"></span>&nbsp;草稿</c:when>
                     <c:when test="${UNDER_REVIEW eq article.articleStatus}"><span
                             class="layui-badge-dot layui-bg-orange"></span>&nbsp;审核中</c:when>
                     <c:when test="${REVIEW_PASSED eq article.articleStatus}"><span
                             class="layui-badge-dot layui-bg-green"></span>&nbsp;已发布</c:when>
                     <c:when test="${REVIEW_NOT_PASSED eq article.articleStatus}"><span
                             class="layui-badge-dot layui-bg-red"></span>&nbsp;审核不通过</c:when>
                 </c:choose>
            </span>
        </div>
        <div class="layui-col-xs4 layui-col-sm4 layui-col-md4 green">
            <c:if test="${not empty article.fmtCategoryList}">
                <span><i class="fa fa-tag" aria-hidden="true"></i> ${article.fmtCategoryList}</span>
            </c:if>
        </div>
        <div class="layui-col-xs5 layui-col-sm4 layui-col-md4 text-r">
            <div class="layui-btn-group">
                <a href="${pageContext.request.contextPath}/member/article/${article.articleId}"
                   class="layui-btn layui-btn-primary layui-btn-sm" title="详情">
                    <i class="layui-icon">&#xe60b;</i>
                </a>
                <a href="${pageContext.request.contextPath}/member/article/update/${article.articleId}"
                   class="layui-btn layui-btn-primary layui-btn-sm" title="编辑">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a href="${pageContext.request.contextPath}/member/article/preview/${article.articleId}"
                   class="layui-btn layui-btn-primary layui-btn-sm" title="预览">
                    <i class="layui-icon">&#xe602;</i>
                </a>
            </div>
        </div>
    </div>
    <input type="hidden" name="loadMoreArticleId" value="${article.articleId}">
</div>