package com.bignerdranch.android.criminalintent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CalendarUtil {

	
	/**
	 * ��ȡ���ڸ�ʽ���ַ���
	 * @param calendar
	 * @return
	 */
	public static String formatCalendarDate(Calendar calendar) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(calendar.getTime());
	}
	
	/**
	 * ��ȡʱ���ʽ���ַ���
	 * @param calendar
	 * @return
	 */
	public static String formatCalendarTime(Calendar calendar) {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(calendar.getTime());
	}
}
