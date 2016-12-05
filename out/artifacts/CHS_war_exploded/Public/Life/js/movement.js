/**
 * Created by HAO on 2016/5/4.
 */

$(".sport-item").click(function () {
    $(".sport-item").removeClass("sport-active");
    $(this).addClass("sport-active");
    $(".sport-tips").hide();
    $("#" + $(this).data("type")).show()
});