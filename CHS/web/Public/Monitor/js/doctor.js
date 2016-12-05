/**
 * Created by HAO on 2016/5/6.
 */

/** 模态框 **/
//点击隐藏
$(".confirm").bind("click",function () {
    $(this).fadeOut();
});

$(".confirm-close").bind("click",function () {
    $(".confirm").fadeOut();
});

//阻止内容框点击事件
$(".confirm-content").bind("click",function (e) {
    e.stopPropagation();
});

$(".doctor-item").click(function () {
    var id = $(this).data("value");
    var name = $(this).data("name");
    $(".doctor-choose").find("span").text(name);
    $(".doctor-id").val(id);
    $(".confirm").fadeIn();
});


$(".btn-submit").click(function(){  //保存
    $.ajax({
        cache: true,
        type: "POST",
        url: appRoot + "/Monitor/saveOrder",
        data:$('#order-form').serialize(),// 你的formid
        async: false,
        error: function(data) {
            alert("保存发生异常");
        },
        success: function(data) {
            if(data.status){
                alert(data.msg);
            }else{
                alert(data.msg);
                if(data.msg.indexOf("登录") > 0){
                    window.location.href = appRoot + "/User/login";
                }
            }
        }
    });
    $(".confirm").fadeOut();
});