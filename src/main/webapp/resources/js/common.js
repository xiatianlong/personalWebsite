/**
 * 系统通用js
 * @type {{ajax: common.ajax}}
 */

var common = {

    ajax: function (options) {
        // 显示遮罩
        if (EasyCheck.StringUtils.isEmpty(options["beforeSend"])) {
            options["beforeSend"] = function () {
                layer.load(2);
            };
        } else {
            var beforeSendFunction = options["beforeSend"];
            options["beforeSend"] = function (XMLHttpRequest) {
                layer.load(2);
                beforeSendFunction(XMLHttpRequest);
            };
        }
        // 隐藏遮罩
        if (EasyCheck.StringUtils.isEmpty(options["complete"])) {
            options["complete"] = function () {
                layer.closeAll('loading');
            };
        } else {
            var completeFunction = options["complete"];
            options["complete"] = function (XMLHttpRequest, textStatus) {
                layer.closeAll('loading');
                completeFunction(XMLHttpRequest, textStatus);
            };
        }
        // 异步请求
        $.ajax(options);
    },

    dataTableLanguage: function () {
        return {
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
        }
    }

};
