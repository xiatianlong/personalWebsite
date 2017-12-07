<%--
  Created by IntelliJ IDEA.
  User: xiati
  Date: 2017/12/3
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/canvas-particle.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/wangEditor.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/wangEditor_v3.0.15/emoji.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/xss.js"></script>
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    });
</script>