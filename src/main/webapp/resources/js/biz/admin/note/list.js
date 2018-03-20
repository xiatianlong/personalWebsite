/**
 * 后台文章列表js
 */
layui.use(['laypage', 'form'], function () {
    var laypage = layui.laypage;
    var form = layui.form;
    var layerOpen;
    var pageNo;
    var dataCount = Number($("#dataCount").val());
    var pageSize = Number($("#pageSize").val());
    var limits = [pageSize, pageSize * 2, pageSize * 3];
    laypage.render({
        elem: 'notePageContent',
        count: dataCount,
        limit: pageSize,
        limits: limits,
        groups: 3,
        layout: ['prev', 'page', 'next', 'limit', 'count'],
        jump: function (obj, first) {
            pageNo = obj.curr;
            pageSize = obj.limit;
            //首次不执行
            if (!first) {
                submitQuery();
            }
        }
    });

    $("input[name='keyword']").keydown(function () {
        if (event.keyCode == "13") {
            //keyCode=13是回车键
            submitQuery();
        }
    });
    form.on('select(noteCategory)', function (data) {
        submitQuery();
    });
    form.on('select(noteStatus)', function (data) {
        submitQuery();
    });
    form.on('select(deleted)', function (data) {
        submitQuery();
    });

    /**
     * 异步分页、搜索提交
     */
    function submitQuery() {
        var requestData = {
            pageNo: pageNo,
            pageSize: pageSize,
            keyword: $("input[name='keyword']").val(),
            deleted: $("select[name='deleted']").val(),
            noteStatus: $("select[name='noteStatus']").val(),
            noteCategory: $("select[name='noteCategory']").val()
        };
        common.ajax({
            url: "/admin/note/query",
            type: "POST",
            data: requestData,
            success: function (res) {
                if (res.result === 'success') {
                    $("#noteListContent").empty();
                    if (EasyCheck.StringUtils.isNotEmpty(res.noteInfos) && res.noteInfos.length > 0) {
                        for (var noteInfosIndex = 0; noteInfosIndex < res.noteInfos.length; noteInfosIndex++) {
                            $("#noteListContent").append(buildHtml(res.noteInfos[noteInfosIndex]));
                        }
                    }
                    dataCount = res.dataCount;
                    // 重绘分页栏
                    laypage.render({
                        elem: 'notePageContent',
                        count: dataCount,
                        limit: pageSize,
                        limits: limits,
                        curr: pageNo,
                        groups: 3,
                        layout: ['prev', 'page', 'next', 'limit', 'count'],
                        jump: function (obj, first) {
                            pageNo = obj.curr;
                            pageSize = obj.limit;
                            //首次不执行
                            if (!first) {
                                submitQuery();
                            }
                        }
                    });

                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    }

    /**
     * 预览点击
     */
    $("#noteListContent").on('click', 'button.preViewBtn', function () {
        var noteId = $(this).data("noteId");
        window.open("/admin/note/preview/" + noteId);
    });

    /**
     * 删除点击
     */
    $("#noteListContent").on('click', 'button.removeBtn', function () {
        var noteId = $(this).data("noteId");
        var $that = $(this);
        common.ajax({
            url: "/admin/note/delete/" + noteId,
            type: "POST",
            success: function (res) {
                if (res.result === 'success') {
                    $that.parents("tr").remove();
                    layer.msg('删除成功', {icon: 6});
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    });

    /**
     * 审核点击
     */
    $("#noteListContent").on('click', 'button.auditBtn', function () {
        var noteId = $(this).data("noteId");
        common.ajax({
            url: "/admin/note/audit/" + noteId,
            type: "GET",
            success: function (res) {
                if (res.result === 'success') {
                    layerOpen = layer.open({
                        type: 1,
                        skin: 'layui-layer-rim', //加上边框
                        // area: ['420px', '240px'], //宽高
                        content: buildAuditHtml(res)
                    });
                    form.render(); //更新全部
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });
    });

    // 审核提交点击处理
    $("body").on('click', 'form.audit-form a.submitForm', function () {
        var $thatForm = $(this).parents(".audit-form");
        // 状态
        var status = $thatForm.find("input:radio[name='status']:checked").val();
        if (EasyCheck.StringUtils.isEmpty(status)) {
            layer.msg("请选择审核状态~", {icon: 0, anim: 6});
            return false;
        }
        // 分类
        var category = $thatForm.find("textarea[name='category']").val();
        if (EasyCheck.StringUtils.isEmpty(category)) {
            layer.msg("至少有一个分类~", {icon: 0, anim: 6});
            return false;
        }
        var tempCategoryArr = category.split(",");
        var categoryArr = [];
        for (var i = 0; i < tempCategoryArr.length; i++) {
            if (!EasyCheck.StringUtils.isEmpty(tempCategoryArr[i])) {
                categoryArr[categoryArr.length] = tempCategoryArr[i];
            }
        }
        if (categoryArr.length > 4) {
            layer.msg("限制最多五个分类~", {icon: 0, anim: 6});
            return false;
        }
        // 备注
        var auditMemo = $thatForm.find("textarea[name='auditMemo']").val();
        if (EasyCheck.StringUtils.isEmpty(auditMemo) || auditMemo.length > 150) {
            layer.msg("备注限制1-150个字符~", {icon: 0, anim: 6});
            return false;
        }
        // 封装请求数据
        var requestData = {};
        requestData['status'] = status;
        requestData['category'] = categoryArr;
        requestData['auditMemo'] = auditMemo;
        common.ajax({
            url: "/admin/note/audit/" + $thatForm.data("bizId"),
            type: "POST",
            data: requestData,
            traditional: true,
            success: function (res) {
                if (res.result === 'success') {
                    $("#noteListContent").find("tr#note-" + $thatForm.data("bizId")).remove();
                    layer.close(layerOpen);
                    layer.msg('审核成功', {icon: 6});
                } else {
                    layer.msg(res.message, {icon: 5, anim: 6});
                }
            }
        });

    });

    // 分类处理
    $("body").on('click', 'form.audit-form a.add-category-btn', function () {
        var $auditForm = $(this).parents(".audit-form");
        var $inputCategory = $auditForm.find("input[name='category-input']");
        if (EasyCheck.StringUtils.isEmpty($inputCategory.val())) {
            layer.msg("请输入分类~", {icon: 0, anim: 6});
            return false;
        }
        var $category = $auditForm.find("textarea[name='category']");
        if (EasyCheck.StringUtils.isEmpty($category.val())) {
            // 插入
            $auditForm.find("textarea[name='category']").val($inputCategory.val());
        } else {
            // 校验是否重复
            var tempCategoryArr = $category.val().split(",");
            var categoryArr = [];
            var hasCategory = false;
            for (var i = 0; i < tempCategoryArr.length; i++) {
                if (!EasyCheck.StringUtils.isEmpty(tempCategoryArr[i])) {
                    categoryArr[categoryArr.length] = tempCategoryArr[i];
                    if (tempCategoryArr[i] === $inputCategory.val()) {
                        hasCategory = true;
                    }
                }
            }
            if (hasCategory) {
                return false;
            }
            // 校验数量
            if (categoryArr.length > 4) {
                layer.msg("限制最多五个分类~", {icon: 0, anim: 6});
                return false;
            }
            // 插入
            $auditForm.find("textarea[name='category']").val($category.val() + "," + $inputCategory.val());
        }
        $inputCategory.val("");
    });

    // 取消所有分类
    $("body").on('click', 'form.audit-form a.cancel-category-btn', function () {
        $(this).parents(".audit-form").find("textarea[name='category']").val("");
    });

    // 审核分类选择事件触发
    form.on('select(audit-category-select)', function (data) {
        var $auditForm = $(this).parents(".audit-form");
        var selectCategory = data.value;
        var $category = $auditForm.find("textarea[name='category']");
        if (EasyCheck.StringUtils.isEmpty($category.val())) {
            // 插入
            $auditForm.find("textarea[name='category']").val(selectCategory);
        } else {
            // 校验是否重复
            var tempCategoryArr = $category.val().split(",");
            var categoryArr = [];
            var hasCategory = false;
            for (var i = 0; i < tempCategoryArr.length; i++) {
                if (!EasyCheck.StringUtils.isEmpty(tempCategoryArr[i])) {
                    categoryArr[categoryArr.length] = tempCategoryArr[i];
                    if (tempCategoryArr[i] === selectCategory) {
                        hasCategory = true;
                    }
                }
            }
            if (hasCategory) {
                return false;
            }
            // 校验数量
            if (categoryArr.length > 5) {
                layer.msg("限制最多五个分类~", {icon: 0, anim: 6});
                return false;
            }
            // 插入
            $auditForm.find("textarea[name='category']").val($category.val() + "," + selectCategory);
        }
    });


    function buildAuditHtml(res) {
        var html = '';
        html += '<div class="layui-row">';
        html += '   <div class="layui-col-xs12 layui-col-sm12 layui-col-md12  padding-15">';
        html += '       <form class="layui-form layui-form-pane audit-form" data-biz-id="' + res.bizId + '" action="">';
        html += '           <div class="layui-form-item">';
        html += '               <label class="layui-form-label">ID</label>';
        html += '               <div class="layui-form-mid layui-word-aux"><div class="padding-l-10">' + res.bizId + '</div></div>';
        html += '           </div>';
        html += '           <div class="layui-form-item">';
        html += '               <label class="layui-form-label">当前状态</label>';
        html += '               <div class="layui-form-mid layui-word-aux"><div class="padding-l-10">' + res.statusName + '</div></div>';
        html += '           </div>';
        html += '           <div class="layui-form-item">';
        html += '               <label class="layui-form-label">选择审核状态</label>';
        html += '               <div class="layui-input-block">';
        html += '                   <input type="radio" name="status" value="003003" title="审核通过">';
        html += '                   <input type="radio" name="status" value="003004" title="审核不通过">';
        html += '               </div>';
        html += '           </div>';
        html += '           <div class="layui-form-item">';
        html += '               <label class="layui-form-label">分类</label>';
        html += '               <div class="layui-input-block">';
        html += '                   <select class="audit-category-select" lay-filter="audit-category-select" lay-search>';
        html += '                       <option value="">直接选择或搜索选择</option>';
        if (res.category != null && res.category.length > 0) {
            for (var index = 0; index < res.category.length; index++) {
                html += '               <option value="' + res.category[index] + '">' + res.category[index] + '</option>';
            }
        }
        html += '                    </select>';
        html += '               </div>';
        html += '               <div>';
        html += '                   <input placeholder="输入分类" class="layui-input" name="category-input" style="width: 50%;display: inline-block;">';
        html += '                   <a class="layui-btn layui-btn-normal layui-btn-sm add-category-btn">添加</a>';
        html += '                   <a class="layui-btn layui-btn-danger layui-btn-sm cancel-category-btn">取消全部</a>';
        html += '                   </div>';
        html += '               <div><textarea readonly placeholder="暂无分类" name="category" class="layui-textarea"></textarea></div>';
        html += '           </div>';
        html += '           <div class="layui-form-item layui-form-text">';
        html += '               <label class="layui-form-label">审核备注</label>';
        html += '               <div class="layui-input-block">';
        html += '                   <textarea placeholder="请输入内容" class="layui-textarea" name="auditMemo"></textarea>';
        html += '               </div>';
        html += '           </div>';
        html += '           <div class="layui-form-item text-r">';
        html += '               <a class="layui-btn layui-btn-primary">取消</a>';
        html += '               <a class="layui-btn layui-btn-warm submitForm">确认</a>';
        html += '           </div>';
        html += '       </div>';
        html += '   </form>';
        html += '</div>';
        return html;
    }

    /**
     * 封装异步分页数据
     * @param note
     * @returns {string}
     */
    function buildHtml(note) {
        var html = '';
        html += '<tr id="note-' + note.noteId + '">';
        html += '   <td>' + note.noteId + '</td>';
        html += '   <td>' + note.noteTitle + '</td>';
        html += '   <td>' + note.noteStatusName + '</td>';
        if (EasyCheck.StringUtils.isNotEmpty(note.fmtCategoryList)) {
            html += '<td>' + note.fmtCategoryList + '</td>';
        } else {
            html += '<td>--</td>';
        }
        html += '   <td title="' + note.userName + '">' + note.userId + '</td>';
        html += '   <td>' + note.fmtCreateTime + '</td>';
        html += '   <td>';
        html += '       <div class="layui-btn-group">';
        html += '           <button class="layui-btn layui-btn-sm margin-t-5 auditBtn" data-note-id="' + note.noteId + '" title="审核">';
        html += '               <i class="layui-icon">&#xe642;</i>';
        html += '           </button>';
        html += '           <button class="layui-btn layui-btn-sm margin-t-5 removeBtn" data-note-id="' + note.noteId + '" title="删除">';
        html += '               <i class="layui-icon">&#xe640;</i>';
        html += '           </button>';
        html += '           <button class="layui-btn layui-btn-sm margin-t-5 preViewBtn" data-note-id="' + note.noteId + '" title="预览">';
        html += '               <i class="layui-icon">&#xe602;</i>';
        html += '           </button>';
        html += '       </div>';
        html += '   </td>';
        html += '</tr>';

        return html;
    }

});