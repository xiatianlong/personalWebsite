<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp"/>
    <title>设置</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/biz/personalCenter/setting.css">
</head>
<body>

<!--header begin-->
<jsp:include page="../base/header.jsp"/>
<!--header end-->
<div class="layui-container">
    <span class="layui-breadcrumb">
      <a href="${pageContext.request.contextPath}/home"><i class="layui-icon">&#xe68e;</i></a>
        <a href="${pageContext.request.contextPath}/member/personalCenter">个人中心</a>
      <a><cite>设置</cite></a>
    </span>
</div>


<div class="layui-container">


    <!--上部部分begin-->
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 xtl-block padding-t-30 padding-b-30">

            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 text-c">
                <div id="personalCenterHeadImg"><img src="${LOGIN_USER.headImg}"></div>
                <div class="margin-t-10 font-size-22">${LOGIN_USER.userName}</div>
            </div>

            <%--设置部分 begin--%>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                <form class="layui-form">

                    <div class="layui-form-item">
                        <label class="layui-form-label">开放访问<i class="layui-icon" id="openLookIcon">&#xe60b;</i></label>
                        <div class="layui-input-block">
                            <input type="checkbox"
                                   <c:if test="${not empty isOpen && isOpen}">checked="checked"</c:if> name="open"
                                   lay-skin="switch" lay-text="ON|OFF">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">QQ</label>
                        <div class="layui-input-block">
                            <input type="text" name="qq" lay-verify="qq" autocomplete="off" placeholder="留下QQ方便联系哦..."
                                   class="layui-input" value="${userQQ}">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">Email</label>
                        <div class="layui-input-block">
                            <input type="text" name="email" lay-verify="email" autocomplete="off"
                                   placeholder="留下邮箱便于接收提醒哦..." class="layui-input" value="${userEmail}">
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">自我介绍</label>
                        <div class="layui-input-block">
                            <textarea name="introduction" lay-verify="introduction" placeholder="请简单的介绍下自己吧..."
                                      class="layui-textarea">${userIntroduction}</textarea>
                            <span class="float-r" id="introduction-cnt"><c:choose><c:when
                                    test="${not empty userIntroduction}">${userIntroduction.length()}/200</c:when><c:otherwise>0/200</c:otherwise></c:choose></span>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="submitSettingForm"><i class="layui-icon">&#xe609;</i> 立即保存</button>
                        </div>
                    </div>
                </form>

            </div>
            <%--设置部分 end--%>

        </div>
    </div>
    <!--上部部分end-->

</div>

<jsp:include page="../base/footer.jsp"/>
<script>

    //Demo
    layui.use(['form'], function () {
        var form = layui.form;
        var tipsIndex;
        $("#openLookIcon").hover(function(){
            tipsIndex = layer.tips('开放访问即允许别人访问我的个人中心', '#openLookIcon', {
                tips: [2, 'rgba(0,0,0,.6)'] //还可配置颜色
            });
        }, function(){
            layer.close(tipsIndex);
        });

        // 隔热和介绍字数监听
        $("textarea[name='introduction']").on('input', function () {
            var that = $(this);
            $("#introduction-cnt").text(that.val().length + "/200");
        });

        //自定义验证规则
        form.verify({
            qq: function(value){
                if(!EasyCheck.StringUtils.isEmpty(value) && !EasyCheck.StringUtils.isNumeric(value)){
                    return 'QQ只能输数字哦~';
                }
                if (value.length > 10){
                    return 'QQ位数太长了~';
                }
            },
            email: function (value) {
                if (EasyCheck.StringUtils.isNotEmpty(value) && !EasyCheck.EmailUtils.isEmail(value)) {
                    return '请输入正确的邮箱格式哦~';
                }
            },
            introduction: function(value){
                if (value.length > 200) {
                    return '介绍最多200个字哦~';
                }
            }
        });

        //监听提交
        form.on('submit(submitSettingForm)', function(data){
            var requestParamParam = {};
            requestParamParam['userQQ'] = data.field.qq;
            requestParamParam['userEmail'] = data.field.email;
            requestParamParam['userIntroduction'] = data.field.introduction;
            requestParamParam['open'] = data.field.open === "on";
            common.ajax({
                url: "/member/personalCenter/setting",
                type: "POST",
                data: requestParamParam,
                success: function (res) {
                    if (res.result === 'success') {
                        layer.msg('保存成功', {icon: 6});
                    } else {
                        layer.msg(res.message, {icon: 5, anim: 6});
                    }
                }
            });
            return false;
        });
    });

</script>
</body>
</html>