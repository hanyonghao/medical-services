/**
 * Created by HAO on 2016/5/10.
 */

$(".form-submit").click(function(){  //登录
    $.ajax({
        cache: true,
        type: "POST",
        url: appRoot + "/Backstage/checkLogin",
        data:$('#login-form').serialize(),// 你的formid
        async: false,
        error: function(data) {
            alert("登录发生异常");
        },
        success: function(data) {
            if(data.status){
                alert(data.msg);
                window.location.href= appRoot + "/Backstage/user";
            }else{
                alert(data.msg);
            }
        }
    });
});
