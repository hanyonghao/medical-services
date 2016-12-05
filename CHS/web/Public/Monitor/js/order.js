/**
 * Created by HAO on 2016/5/11.
 */
$(".order-item").each(function () {
    if($(this).find(".order-status").text().indexOf("预约中") > 0){
        $(this).append("<div class=\"order-close icon-remove\"></div>");
    }
});

$(".order-close").click(function () {
    var parent = $(this).parent();
    var id = parent.data("value");
    if(confirm("确定删除该条预约？")){
        $.ajax({
            cache: true,
            type: "POST",
            url: appRoot + "/Monitor/deleteOrder",
            data: {ordId : id},// 你的formid
            async: false,
            error: function(data) {
                alert("删除发生异常");
            },
            success: function(data) {
                if(data.status){
                    parent.remove();
                    alert(data.msg);
                }else{
                    alert(data.msg);
                    if(data.msg.indexOf("登录") > 0){
                        window.location.href = appRoot + "/User/login";
                    }
                }
            }
        });
    }
});
