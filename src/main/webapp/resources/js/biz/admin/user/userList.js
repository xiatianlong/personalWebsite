/**
 * 用户列表js
 */
$(function () {

    var collectionTable = $('#userListTable').DataTable({
        "lengthMenu": [5, 15, 30, 20],
        "columns": [
            null,
            null,
            null,
            null,
            null,
            null,
            {"orderable": false}
        ],
        "order": [[0, 'desc']],
        language: common.dataTableLanguage(),
        "deferRender": true
    });

    /**
     * 用户详情页点击事件
     */
    $(".userDetailBtn").on('click', function () {
        var userId = $(this).data("userId");
        common.ajax({
            url: "/admin/user/" + userId,
            type: "POST",
            success: function (res) {
                if (res.result === 'success') {
                    layer.open({
                        type: 1,
                        skin: 'layui-layer-rim', //加上边框
                        // area: ['420px', '240px'], //宽高
                        content: buildUserDetailHtml(res.userDetail)
                    });
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    });

    function buildUserDetailHtml(user) {
        var html = '';
        html += '<div class="layui-row">';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12 padding-15">';
        html += '<div class="layui-col-xs12 layui-col-sm12 layui-col-md12">';
        html += '   <table class="layui-table">';
        html += '       <colgroup>';
        html += '           <col width="40%">';
        html += '           <col width="60%">';
        html += '       </colgroup>';
        html += '       <tbody>';
        html += '           <tr>';
        html += '                <td>ID</td>';
        html += '                <td>' + user.userId + '</td>';
        html += '           </tr>';
        html += '           <tr>';
        html += '                <td>昵称</td>';
        html += '                <td>' + user.userName + '</td>';
        html += '           </tr>';
        html += '           <tr>';
        html += '                <td>性别</td>';
        html += '                <td>' + user.userGender + '</td>';
        html += '           </tr>';
        html += '           <tr>';
        html += '                <td>邮箱</td>';
        if (EasyCheck.StringUtils.isNotEmpty(user.userEmail)) {
            html += '                <td>' + user.userEmail + '</td>';
        } else {
            html += '                <td>--</td>';
        }
        html += '           </tr>';
        html += '           <tr>';
        html += '                <td>QQ</td>';
        if (EasyCheck.StringUtils.isNotEmpty(user.userQQ)) {
            html += '                <td>' + user.userQQ + '</td>';
        } else {
            html += '                <td>--</td>';
        }
        html += '           </tr>';
        html += '           <tr>';
        html += '                <td>个人简介</td>';
        if (EasyCheck.StringUtils.isNotEmpty(user.userIntroduction)) {
            html += '                <td>' + user.userIntroduction + '</td>';
        } else {
            html += '                <td>--</td>';
        }
        html += '           </tr>';
        html += '           <tr>';
        html += '                <td>是否开放个人中心访问</td>';
        if (user.open) {
            html += '                <td>开放</td>';
        } else {
            html += '                <td>不开放</td>';
        }
        html += '           </tr>';
        html += '           <tr>';
        html += '                <td>最后登录时间</td>';
        html += '                <td>' + user.fmtLastLoginTime + '</td>';
        html += '           </tr>';
        html += '           <tr>';
        html += '                <td>创建时间</td>';
        html += '                <td>' + user.fmtCreateTime + '</td>';
        html += '           </tr>';
        html += '       </tbody>';
        html += '   </table>';
        html += '</div>';
        html += '</div>';
        html += '</div>';
        return html;
    }

});