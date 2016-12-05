/**
 * Created by HAO on 2016/5/3.
 */
var clockObject;

//时钟：年月日时分秒
function clock() {
    //格式化补零
    function format(object) {
        if (parseInt(object) < 10) {
            object = "0" + object;
        }
        return object;
    }

    var object = $(".m-datetime");
    var weeks = ['日', '一', '二', '三', '四', '五', '六'];
    var mydate = new Date();
    var date = mydate.getFullYear() + "年" + (mydate.getMonth() + 1) + "月" + mydate.getDate() + "日"; //获取当前日期
    var time = mydate.getHours() + ":" + format(mydate.getMinutes()) + ":" + format(mydate.getSeconds()); //获取当前时间
    var week = "星期" + weeks[mydate.getDay()];
    object.find(".m-time").text(time);
    object.find(".m-date").text(date + " " + week);
    return {date: date, time: time, week: week};
}

(function ($, document, window) {
    clockObject = clock(); //刷新日期
    setInterval(clock, 1000); //启用计时器
    $("msg").ready(function () {
        var tips = $(this).find(".m-read-tips");
        var count = parseInt(tips.text());
        if (count <= 0) {
            tips.hide();
        }
    });
})(jQuery, document, window);

$('.searchPage').change(function () {
    var subjectUrl = appRoot + "/Backstage/doctor?page=";
    if ($(this).val() != '') {
        var url = subjectUrl + $(this).val();
        window.location.href = url;
    }
});