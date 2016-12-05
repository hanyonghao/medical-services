/**
 * Created by HAO on 2016/5/7.
 */

/** 模态框 **/
function MyConfirm(modal,options) {
    var content = this;
    options = $.extend({
        showFun : function(){},
        afterShowFun : function(){},
        hideFun : function(){},
        afterHideFun : function(){}
    }, options);
    this.showConfirm = function () {
        options.showFun();
        $(modal).fadeIn();
        options.afterShowFun();
    };
    this.hideConfirm = function () {
        options.hideFun();
        $(modal).fadeOut();
        options.afterHideFun();
    };
    $(modal).bind("click",function () {
        content.hideConfirm();
    });
    $(modal).find(".confirm-close").bind("click",function () {
        content.hideConfirm();
    });
    //阻止内容框点击事件
    $(modal).find(".confirm-content").bind("click",function (e) {
        e.stopPropagation();
    });
    return content;
}

(function () {
    $(".order-status").each(function () {
        if($(this).text() == "预约中"){
            $(this).css("color","#aaa");
            $(this).siblings(".order-ico").show();
        }else if($(this).text() == "预约确认"){
            $(this).css("color","#02c545");
        }else if($(this).text() == "正在进行"){
            $(this).siblings(".order-ico").show();
            $(this).css("color","#f3a002");
        }else if($(this).text() == "已完成"){
            $(this).css("color","#c5c218");
        }else if($(this).text() == "已终止"){
            $(this).css("color","#c52619");
        }else{
            $(this).css("color","#777777");
        }
    });
    var myConfirm = new MyConfirm(".confirm-order"); //预约审批
    var myConfirm2 = new MyConfirm(".confirm-finish"); //治疗确认
    $(".order-item").click(function () {
        if($(this).find(".order-status").text() == "预约中"){
            $(".order-id").val($(this).data("value"));
            $(".confirm-title").find("span").text($(this).find(".order-name").text());
            myConfirm.showConfirm();
        }else if($(this).find(".order-status").text() == "正在进行"){
            $(".order-id").val($(this).data("value"));
            $(".confirm-title").find("span").text($(this).find(".order-name").text());
            myConfirm2.showConfirm();
        }
    });
    $(".btn-submit").bind("click",function () {
        var url = "";
        var formId = "";
        if($(this).hasClass("btn-agree")){
            url = appRoot + "/Doctor/agreeOrder";
            formId = "order-deal";
        }else if($(this).hasClass("btn-disagree")){
            url = appRoot + "/Doctor/disagreeOrder";
            formId = "order-deal";
        }else if($(this).hasClass("btn-finish")){
            url = appRoot + "/Doctor/finishOrder";
            formId = "order-confirm";
        }else if($(this).hasClass("btn-cancel")){
            url = appRoot + "/Doctor/cancelOrder";
            formId = "order-confirm";
        }
        $.ajax({
            cache: true,
            type: "POST",
            url: url,
            data:$("#"+formId).serialize(),// 你的formid
            async: false,
            error: function(data) {
                alert("操作发生异常");
            },
            success: function(data) {
                if(data.status){
                    alert(data.msg);
                    location.reload(true);
                }else{
                    alert(data.msg);
                }
            }
        });
    });
})();




