/**
 * Created by HAO on 2016/5/4.
 */

$(".dietary-group").each(function () {
    var heightType = $(".dietary-type").height();
    var countItem = Math.ceil($(this).find(".dietary-item").length/2);
    var heightItem = $(".dietary-item").height() * countItem;
    $(this).css("height",heightItem + heightType + 50 + "px");
});