/**
 * Created by HAO on 2016/5/3.
 */

/**幻灯片*/
var mySwiper = new Swiper('.swiper-container',{
    pagination : '.swiper-pagination',
    autoplayDisableOnInteraction : false,
    loop: true,
    autoplay: 2000,
    speed: 800,
    grabCursor: true,
});

/**适应屏幕 */
review(function(){
    var width = $(window).width();
    $(".row-small").height(width * 0.28);
    $(".row-normal").height(width * 0.35);
    $(".row-large").height(width * 0.41);
});