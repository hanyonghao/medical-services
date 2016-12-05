/**
 * Created by HAO on 2016/5/4.
 */
//获取随机颜色
var getRandomColor = function(){
    return (function(m,s,c){
        return (c ? arguments.callee(m,s,c-1) : '#') +
            s[m.floor(m.random() * 16)]
    })(Math,'0123456789abcdef',5)
};

//时钟：年月日时分秒
function clock(){
    //格式化补零
    function format(object){
        if(parseInt(object) < 10){
            object = "0" + object;
        }
        return object;
    }
    var object = $(".schedule-datetime");
    var weeks = ['日','一','二','三','四','五','六'];
    var mydate = new Date();
    var date = mydate.getFullYear() + "年" + (mydate.getMonth()+1) + "月" + mydate.getDate() + "日"; //获取当前日期
    var time = mydate.getHours() + ":" + format(mydate.getMinutes()) + ":" + format(mydate.getSeconds()); //获取当前时间
    var week = "星期" + weeks[mydate.getDay()];
    object.text(date + " " + time + " " + week);
    return {date:date,time:time,week:week};
}

(function($,document,window){
    var clockObject = clock(); //刷新日期
    setInterval(clock, 1000); //启用计时器
})(jQuery,document,window);

$(".schedule-item-delete").click(function () {
    if(confirm("确认删除吗？")){
        $(this).parent().parent().remove();
    }
});

/** 模态框 **/
//点击隐藏
$(".confirm").bind("click",function () {
    $(this).fadeOut();
});

$(".confirm-close").bind("click",function () {
    $(".confirm").fadeOut();
});

$(".btn-submit").bind("click",function () {
    var time = $(".schedule-time").val();
    var event = $(".schedule-event").val();
    $(".schedule-extend").append("<div class=\"schedule-item\"> <div class=\"schedule-item-left\">"+time+"<div class=\"schedule-middle\" style=\"background: "+ getRandomColor() +";\"></div></div> <div class=\"schedule-item-right\">"+event+"<div class=\"schedule-item-delete icon-remove\"></div></div> </div>");
    $(".confirm").fadeOut();
});

//阻止内容框点击事件
$(".confirm-content").bind("click",function (e) {
    e.stopPropagation();
});

$(".btn-add").click(function () {
    $(".confirm").fadeIn();
});

