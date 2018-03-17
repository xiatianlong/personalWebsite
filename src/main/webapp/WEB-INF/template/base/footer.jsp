<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2017/12/3
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="layui-container">
    <div class="layui-row">
        <hr class="layui-bg-blue margin-t-30">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-b-30 xtl-footer-content">
            <a href="${pageContext.request.contextPath}/about/history">网站历史</a>
            <a href="mailto:xiatianlong@hotmail.com">联系我</a>
            <a href="${pageContext.request.contextPath}/admin/index">后台管理</a><br>
            <a>Design by xiatianlong</a>
            <a href="http://www.miitbeian.gov.cn">鄂ICP备17012255号</a>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/canvas-particle.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/wangEditor.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/emoji.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/xss.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/easy-check.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script>

    var layer;
    layui.use(['element', 'util', 'code', 'layer'], function () {
        var util = layui.util;

        //执行去顶部
        util.fixbar();

        //引用code方法, 对code标签的内容做代码格式化
        layui.code({
            elem: 'code',
            height: '100px',
            encode: true,
            about: false
        });
        // message
        layer = layui.layer;
    });
</script>