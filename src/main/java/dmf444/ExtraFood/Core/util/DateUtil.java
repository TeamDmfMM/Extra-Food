package dmf444.ExtraFood.Core.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Master801 || Modified by DMF
 */

public class DateUtil {
	
	private static final Calendar CALENDER = Calendar.getInstance();

	public static Calendar getCalender() {
        Date date = new Date();
        if (CALENDER.getTime() != date) {
            CALENDER.setTime(new Date());
        }
        return CALENDER;
	}

	public static boolean isChristmas() {
		if(DateUtil.getCalender().get(Calendar.MONTH) == Calendar.DECEMBER){
			if(DateUtil.getCalender().get(Calendar.DATE) >= 22 && DateUtil.getCalender().get(Calendar.DATE) <=30){
				return true;
			}else{
				return false;
			}
		}
        return  false;
	}

	public static boolean isHalloween() {
        return DateUtil.getCalender().get(Calendar.MONTH) == Calendar.OCTOBER && DateUtil.getCalender().get(Calendar.DATE) == 31;
	}

	public static boolean isNewYear() {
		return DateUtil.getCalender().get(Calendar.MONTH) == Calendar.JANUARY && DateUtil.getCalender().get(Calendar.DATE) == 1;
	}

	public static boolean isNotchsBirthday() {
		return DateUtil.getCalender().get(Calendar.MONTH) == Calendar.JULY && DateUtil.getCalender().get(Calendar.DATE) == 1;
	}

	public static boolean isBirthDay() {
		
		return DateUtil.getCalender().get(Calendar.MONTH) == Calendar.DECEMBER && DateUtil.getCalender().get(Calendar.DATE) == 31;
	}

	//public static boolean isBirthday() {
	//	return DateUtil.getCalender().get(Calendar.MONTH) == Calendar.JUNE && DateUtil.getCalender().get(Calendar.DATE) == 15;
	//}

}

