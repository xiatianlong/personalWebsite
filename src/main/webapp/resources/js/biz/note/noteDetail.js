/**
 * 文章详情js
 */
$(function () {

    $("#collectionBtn").on('click', function () {
        common.ajax({
            url: "/member/collection/001002/" + $("#noteId").val(),
            type: "POST",
            success: function (res) {
                if (res.result === 'success') {
                    layer.msg('收藏成功！', {icon: 6, shade: 0.01}, function () {
                        $("#collectionBtn").removeClass("fa-star-o");
                        $("#collectionBtn").addClass("fa-star");
                        $("#collectionBtn").removeAttr("id");
                    });
                } else {
                    layer.msg(res.message, {icon: 6, anim: 6});
                }
            }
        });
    });


});