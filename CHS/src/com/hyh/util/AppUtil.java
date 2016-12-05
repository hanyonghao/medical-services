package com.hyh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HAO on 2016/5/11.
 */
public class AppUtil {

    /**
     * 根据日期获取年龄
     * @param birthDate
     * @return
     */
    public static int getAge(Date birthDate) {
        if (birthDate == null){
            return 0;
        }
        int age = 0;
        Date now = new Date();
        SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
        SimpleDateFormat format_M = new SimpleDateFormat("MM");
        String birth_year = format_y.format(birthDate);
        String this_year = format_y.format(now);

        String birth_month = format_M.format(birthDate);
        String this_month = format_M.format(now);

        // 初步，估算
        age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);

        // 如果未到出生月份，则age - 1
        if(this_month.compareTo(birth_month) < 0){
            age -= 1;
        }
        if (age < 0){
            age = 0;
        }
        return age;
    }

    /**
     * 日期对比
     * date1 比 date2 早 返回 1 ;
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(Date date1, Date date2) {
        try {
            if (date1.getTime() > date2.getTime()) {
                return 1;
            } else if (date1.getTime() < date2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
