package com.dmfmm.extrafood.utilities;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Master801 || Modified by DMF
 */

public class DateUtils {

    private static final Calendar CALENDER = Calendar.getInstance();

    public static Calendar getCalender() {
        Date date = new Date();
        if (CALENDER.getTime() != date) {
            CALENDER.setTime(new Date());
        }
        return CALENDER;
    }

    public static boolean isChristmas() {
        if(DateUtils.getCalender().get(Calendar.MONTH) == Calendar.DECEMBER){
            if(DateUtils.getCalender().get(Calendar.DATE) >= 22 && DateUtils.getCalender().get(Calendar.DATE) <=30){
                return true;
            }else{
                return false;
            }
        }
        return  false;
    }

    public static boolean isHalloween() {
        return DateUtils.getCalender().get(Calendar.MONTH) == Calendar.OCTOBER && DateUtils.getCalender().get(Calendar.DATE) == 31;
    }

    public static boolean isNewYear() {
        return DateUtils.getCalender().get(Calendar.MONTH) == Calendar.JANUARY && DateUtils.getCalender().get(Calendar.DATE) == 1;
    }

    public static boolean isNotchsBirthday() {
        return DateUtils.getCalender().get(Calendar.MONTH) == Calendar.JULY && DateUtils.getCalender().get(Calendar.DATE) == 1;
    }

    public static boolean isBirthDay() {

        return DateUtils.getCalender().get(Calendar.MONTH) == Calendar.DECEMBER && DateUtils.getCalender().get(Calendar.DATE) == 31;
    }

    //public static boolean isBirthday() {
    //	return DateUtils.getCalender().get(Calendar.MONTH) == Calendar.JUNE && DateUtils.getCalender().get(Calendar.DATE) == 15;
    //}

}