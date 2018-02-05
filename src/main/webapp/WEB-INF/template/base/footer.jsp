<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2017/12/3
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="layui-container">
    <div class="layui-row">
        <hr class="layui-bg-blue margin-t-30">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-b-30 blue font-size-14 text-c">
            design by xiatl, coding by xiatl.
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
    layui.use(['element', 'code', 'layer'], function () {
        //导航的hover效果、二级菜单等功能，需要依赖element模块

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