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
    }

};
