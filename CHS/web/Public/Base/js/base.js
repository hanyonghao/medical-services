
/**
 * Created by PPHT-HAO on 2016/3/13.
 */

/**
 * 响应式方法，加载或改变屏幕大小都运行该方法
 * @param fn
 */
function review(fn){
    $(window).ready(fn);
    $(window).resize(fn);
};

/** 捆绑滚动事件 **/
$(window).scroll(function(){
    var t = $(document).scrollTop();
    if(t > 50){//显示或隐藏数字按钮
        $('.btn-top').show();
    }else{
        $('.btn-top').hide();
    }
})

/** 捆绑点击事件 **/
$('.btn-top').click(function(){
    $('body,html').animate({
            scrollTop: 0
        },
        800);//点击回到顶部按钮，缓懂回到顶部,数字越小越
})