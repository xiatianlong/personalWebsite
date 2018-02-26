<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2018/2/7
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card"
     data-article-id="${article.articleId}">
    <c:choose>
        <c:when test="${not empty article.articleImgUrl}">
            <div class="layui-col-xs12 layui-col-sm4 layui-col-md4 article-card-left-img">
                <img src="${article.articleImgUrl}">
            </div>
            <div class="layui-col-xs12 layui-col-sm8 layui-col-md8 article-card-right-content">
                <div class="article-title layui-elip">${article.articleTitle}</div>
                <div class="article-summary">${article.articleIntroduction}</div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">
                <div class="article-title layui-elip">${article.articleTitle}</div>
                <div class="article-summary">${article.articleIntroduction}</div>
            </div>
        </c:otherwise>
    </c:choose>
    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">
            <span><i class="fa fa-tag" aria-hidden="true"></i> ${article.fmtCategoryList}</span>
        </div>
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">
                        <span class="article-create-user"><i class="fa fa-user-o"
                                                             aria-hidden="true"></i> ${article.userName}</span>
        </div>
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">
            <span><i class="fa fa-clock-o" aria-hidden="true"></i> ${article.fmtCreateTime}</span>
        </div>
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">
            <span><i class="fa fa-eye" aria-hidden="true"></i> ${article.articleViewsCnt}</span>
            <%--<span class="padding-l-10"><i class="fa fa-commenting-o" aria-hidden="true"></i> 100</span>--%>
        </div>
    </div>
    <input type="hidden" name="loadMoreArticleId" value="${article.articleId}">
</div>