/**
 * Created by HAO on 2016/5/13.
 */
$(".report-item").click(function () {
    var id = $(this).data("id");
    if($(this).find(".report-status").text() == "待填写"){
        window.location.href = appRoot + "/Doctor/reportInput?recordId="+id;
    }else{
        window.location.href = appRoot + "/Doctor/reportContent?recordId="+id;
    }
});