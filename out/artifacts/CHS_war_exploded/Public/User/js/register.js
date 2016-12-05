/**
 * Created by HAO on 2016/5/10.
 */

$(".form-submit").click(function(){  //注册
    $.ajax({
        cache: true,
        type: "POST",
        url: appRoot + "/User/saveRegister",
        data:$('#register-form').serialize(),// 你的formid
        async: false,
        error: function(data) {
            alert("注册发生异常");
        },
        success: function(data) {
            if(data.status){
                alert(data.msg);
                window.location.href= appRoot + "/User/login";
            }else{
                alert(data.msg);
            }
        }
    });
});
