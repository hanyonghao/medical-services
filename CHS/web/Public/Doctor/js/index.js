$(function () {
    var items = dateList.split(",");
    var dateArray = eval(dateJSON);
    console.log(dateArray);
    CreateCalendar('.container',items,function (e) {
        for(var i = 0;i < dateArray.length;i++){
            var jsonObj = dateArray[i];
            if(jsonObj.orderDate == e.data){
                alert(jsonObj.orderDate + "的预约人数共"+ jsonObj.count + "人");
            }
        }
    });
});
function CreateCalendar(obj, items, funItem) {
    //变量初始化
    var vDate = new Date();
    //标签生成
    var calendar = $('<div class="calendar"></div>');
    var calendarHead = $('<div class="calendar-head"></div>');
    //年月
    var calendarDate = $('<div class="calendar-date"></div>');
    //星期
    var calendarWeek7 = $('<div class="calendar-week">日</div>');
    var calendarWeek1 = $('<div class="calendar-week">一</div>');
    var calendarWeek2 = $('<div class="calendar-week">二</div>');
    var calendarWeek3 = $('<div class="calendar-week">三</div>');
    var calendarWeek4 = $('<div class="calendar-week">四</div>');
    var calendarWeek5 = $('<div class="calendar-week">五</div>');
    var calendarWeek6 = $('<div class="calendar-week">六</div>');
    //日
    var calendarBody = $('<div class="calendar-body"></div>');
    UpdateItem(vDate);
    calendarHead.append(calendarDate);
    calendarHead.append(calendarWeek7);
    calendarHead.append(calendarWeek1);
    calendarHead.append(calendarWeek2);
    calendarHead.append(calendarWeek3);
    calendarHead.append(calendarWeek4);
    calendarHead.append(calendarWeek5);
    calendarHead.append(calendarWeek6);
    calendar.append(calendarHead);
    calendar.append(calendarBody);
    $(obj).append(calendar);
    //事件绑定
    function UpdateItem(tmpDate) {
        calendarBody.html('');
        calendarDate.html('');
        var vYear = tmpDate.getFullYear();
        var vMon = tmpDate.getMonth();
        var vDay = tmpDate.getDate();
        var vWeek = new Date(vYear, vMon, 1).getDay();
        var vMaxDay = new Date(vYear, vMon + 1, 0).getDate();
        var cellNum = vMaxDay + vWeek + (7 - (vMaxDay + vWeek) % 7);

        var calendarLeft = $('<div class="calendar-left icon-chevron-left"></div>');
        var calendarName = $('<div class="calendar-name"><span class="calendar-year">' + vYear + '</span>年 <span class="calendar-month">' + (vMon + 1) + '</span>月</div>');
        var calendarRight = $('<div class="calendar-right icon-chevron-right"></div>');
        calendarDate.append(calendarLeft);
        calendarDate.append(calendarName);
        calendarDate.append(calendarRight);

        for (var i = 0, nowDay = 0; i < cellNum; i++) {
            var calendarItem = null;
            if (i == vWeek && nowDay == 0)//开始第一天
                nowDay = 1;
            if (nowDay > 0 && nowDay <= vMaxDay) {
                if (nowDay == vDay && vYear == new Date().getFullYear() && vMon == new Date().getMonth()) {
                    calendarItem = $('<div class="calendar-item calendar-active">' + nowDay + '</div>');
                } else {
                    calendarItem = $('<div class="calendar-item">' + nowDay + '</div>');
                }
                var tempDate = "";
                if((vMon+1) < 10 && nowDay >= 10){
                    tempDate = vYear+"-0"+(vMon+1)+"-"+nowDay;
                }else if(nowDay < 10 && (vMon+1) >= 10) {
                    tempDate = vYear+"-"+(vMon+1)+"-0"+nowDay;
                }else if(vMon < 10 && nowDay < 10){
                    tempDate = vYear+"-0"+(vMon+1)+"-0"+nowDay;
                }else{
                    tempDate = vYear+"-"+vMon+"-"+nowDay;
                }
                if (jQuery.inArray(tempDate, items) >= 0) {
                    calendarItem.addClass('calendar-triangle');//预约标识
                    calendarItem.click(tempDate, funItem);//日期点击
                }
                nowDay++;
            } else {
                calendarItem = $('<div class="calendar-item"></div>');
            }
            calendarBody.append(calendarItem);
        }
        //上一月
        calendarLeft.click(function () {
            var tmpYear = tmpDate.getFullYear();
            var tmpMon = tmpDate.getMonth();
            var tmpDay = tmpDate.getDate();
            if (tmpMon == 0) {
                tmpYear--;
                tmpMon = 11;
            } else {
                tmpMon--;
            }
            UpdateItem(new Date(tmpYear, tmpMon, tmpDay));
        });
        //下一月
        calendarRight.click(function () {
            var tmpYear = tmpDate.getFullYear();
            var tmpMon = tmpDate.getMonth();
            var tmpDay = tmpDate.getDate();
            if (tmpMon == 11) {
                tmpYear++;
                tmpMon = 0;
            } else {
                tmpMon++;
            }
            UpdateItem(new Date(tmpYear, tmpMon, tmpDay));
        });
    }
}