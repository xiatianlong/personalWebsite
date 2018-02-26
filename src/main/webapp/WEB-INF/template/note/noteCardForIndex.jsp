<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2018/2/7
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block xtl-article-card" data-type="${note.type}"
     data-note-id="${note.id}">
    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-right-content">
        <div class="article-title">
            <c:if test="${note.top}"><span class="layui-badge">置顶</span></c:if>
            ${note.title}
        </div>
    </div>
    <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 article-card-footer padding-t-15">
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 green">
            <span><i class="fa fa-tag" aria-hidden="true"></i> ${note.fmtCategoryList}</span>
        </div>
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-elip green">
                        <span class="article-create-user"><i class="fa fa-user-o"
                                                             aria-hidden="true"></i> ${note.userName}</span>
        </div>
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray">
            <span><i class="fa fa-clock-o" aria-hidden="true"></i> ${note.fmtCreateTime}</span>
        </div>
        <div class="layui-col-xs6 layui-col-sm3 layui-col-md3 layui-hide-xs gray text-r">
            <span><i class="fa fa-eye" aria-hidden="true"></i> ${note.viewsCnt}</span>
        </div>
    </div>
    <input type="hidden" name="loadMoreId" value="${note.orderKey}">
</div>