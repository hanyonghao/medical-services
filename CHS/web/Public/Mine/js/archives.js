/**
 * Created by HAO on 2016/5/5.
 */

function uploadChange(){  //文件上传
    new uploadFiles({
        initialize : function(){

        },
        fileElementId : "head-file",
        callback : function(file,status){
            if(status){
                if(file.status){
                    //console.log(file);
                    $(".u-img").find("img").attr("src",appRoot + file.src);
                }else{
                    alert(file.msg); //弹出错误报告
                }
            }else{
                alert("上传出错！！");
            }
            //解决change单次使用
            $("#head-file").replaceWith("<input id='head-file' class='register-file' name='head-file' type='file' accept='.jpg,.jpeg,.png,.gif'"); //覆盖原来的上传控件
            $("#head-file").change(uploadChange); //绑定上传控件改变时的上传方法
        }
    }).startUpload();
}


$(".u-head").click(function(){  //头像映射文件上传
    return $("#head-file").click();
});

$("#head-file").change(uploadChange);  //绑定文件上传

$(".archives-select").each(function () {
    var value = $(this).data("value");
    $(this).find("option[value='"+value+"']").attr("selected","selected");
});//下拉框设置默认值

$(".archives-radio").each(function () {
    var values = $(this).parent().data("value");
    if($(this).val() == values){
        $(this).attr("checked","checked");
    }
});//单选框设置默认值

$(".btn-submit").click(function(){  //保存
    $.ajax({
        cache: true,
        type: "POST",
        url: appRoot + "/Mine/saveArchives",
        data:$('#archives-form').serialize(),// 你的formid
        async: false,
        error: function(data) {
            alert("保存发生异常");
        },
        success: function(data) {
            if(data.status){
                alert("保存成功");
            }else{
                alert(data.msg);
            }
        }
    });
});