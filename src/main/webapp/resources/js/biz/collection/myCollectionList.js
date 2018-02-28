/**
 * 我的收藏js
 */
$(function () {

    var collectionTable = $('.collectionTable').DataTable({
        "lengthMenu": [5, 15, 30, 20],
        "columns": [
            null,
            null,
            {"orderable": false}
        ],
        "order": [[0, 'desc']],
        language: {
            "sLengthMenu": "每页 _MENU_ 条",
            "sZeroRecords": "没有搜索到结果",
            "sInfo": "当前显示第 _START_ 至 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoEmpty": "共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sSearch": "",
            "sSearchPlaceholder": "输入关键字检索",
            "sEmptyTable": "表中数据为空",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "尾页"
            }
        },
        "deferRender": true
    });

    /**
     * 删除按钮点击事件
     */
    $(".collectionRemoveBtn").on('click', function () {
        var bizType = $(this).data("bizType");
        var bizId = $(this).data("bizId");
        var that = $(this);
        layer.confirm('确定要删除?', {icon: 3, title: '提示', btn: ['取消', '确认']}, function (index) {
            layer.close(index);
        }, function () {
            common.ajax({
                url: "/member/collection/remove/" + bizType + "/" + bizId,
                type: "POST",
                success: function (res) {
                    if (res.result === 'success') {
                        layer.msg('删除成功！', {icon: 6, shade: 0.01}, function () {
                            // 删除行
                            collectionTable.row(that.parents("tr")).remove().draw();
                        });
                    } else {
                        layer.msg(res.message, {icon: 5, anim: 6});
                    }
                }
            });
        });

    });

});