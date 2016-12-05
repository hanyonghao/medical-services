/**
 * Created by HAO on 2016/5/5.
 */

$(".u-head").click(function () {
    $("#head-file").click();
});

$(".history-title").click(function () {
    var parent = $(this).parent();
    if(parent.hasClass("history-active")){
        parent.removeClass("history-active");
        parent.find(".history-ico").removeClass("icon-chevron-down").addClass("icon-chevron-right");
        parent.find(".history-option").hide();
    }else{
        parent.addClass("history-active");
        parent.find(".history-ico").removeClass("icon-chevron-right").addClass("icon-chevron-down");
        parent.find(".history-option").show();
    }
});

$(".btn-submit").click(function() {  //保存
    alert("保存成功");
});
