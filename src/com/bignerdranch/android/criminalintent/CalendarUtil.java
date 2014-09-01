package com.bignerdranch.android.criminalintent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CalendarUtil {

	
	/**
	 * 获取日期格式化字符串
	 * @param calendar
	 * @return
	 */
	public static String formatCalendarDate(Calendar calendar) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(calendar.getTime());
	}
	
	/**
	 * 获取时间格式化字符串
	 * @param calendar
	 * @return
	 */
	public static String formatCalendarTime(Calendar calendar) {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(calendar.getTime());
	}
}
