<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>关于</title>
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
        <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="${pageContext.request.contextPath}/about/me">关于</a>
        <a><cite>网站历史</cite></a>
    </span>
</div>


<div class="layui-container">


    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 margin-t-30 xtl-block padding-t-20">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">18年04月06日</h3>
                        <p>
                            修复了富文本左右对齐无效的问题<br>
                            修复了笔记创建偶尔失败的bug<br>
                            修复因防止xss攻击而导致富文本部分标签无效的问题<br>
                        </p>
                        <p>
                            添加了可查看用户信息的功能<br>
                            添加文章、笔记置顶功能<br>
                            扩展了富文本菜单<br>
                            升级JKD到1.8，使用了lambda等新特性<br>
                            代码托管迁移到github<br>
                            其他细节优化<br>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">18年03月18日</h3>
                        <p>
                            个人网站第二版上线<br>
                            （代码几乎全部重写，写新代码总觉得旧代码烂）<br>
                            以记录、学习为目的<br>
                            一整套完整的前后端博客系统<br>
                            添加了个人中心、支持多用户<br>
                            QQ登录支持<br>
                            样式改版（不知道丑不丑）<br>
                        <ul>
                            <li>spring/spring mvc、spring data jpa</li>
                            <li>layui</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">17年11月17日</h3>
                        <p>
                            下架DQ模块功能<br>
                            （下架原因：该模块图片、视频等资源过多，成本太大）<br>
                            引入畅言，支持文章、笔记评论<br>
                            记录了部分文章、开发笔记<br>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">17年11月11日</h3>
                        <p>
                            完成DQ模块<br>
                            之前部分BUG修复<br>
                            更换为阿里云国内服务器<br>
                            域名备案通过<br>
                            记录了部分文章、开发笔记<br>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">17年10月8日</h3>
                        个人网站样式改版<br>
                        添加响应式支持、支持PC/ipad/手机<br>
                        花了很长时间进行样式改变<br>
                        改完了依然很丑<br>
                        记录了部分文章、开发笔记<br>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">17年6月13日</h3>
                        <p>
                            个人网站第一版上线<br>
                            以记录、学习为目的<br>
                            一整套完整的前后端博客系统<br>
                        <ul>
                            <li>spring/spring mvc、Hibernate</li>
                            <li>Bootstrap</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <div class="layui-timeline-title">过去</div>
                    </div>
                </li>
            </ul>
        </div>


    </div>


</div>

<jsp:include page="../base/footer.jsp"/>
</body>
</html>