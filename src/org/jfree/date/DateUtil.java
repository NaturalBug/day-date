package org.jfree.date;

import java.text.DateFormatSymbols;

public class DateUtil {
	public static DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();

	public static String[] getMonthNames() {
		return dateFormatSymbols.getMonths();
	}

	public static boolean isLeapYear(int year) {
		boolean fourth = year % 4 == 0;
		boolean hundredth = year % 100 == 0;
		boolean fourHundredth = year % 400 == 0;
		return fourth && (!hundredth || fourHundredth);
	}

	public static int lastDayOfMonth(Month month, int year) {
		if (month == Month.FEBRUARY && isLeapYear(year))
			return month.lastDay() + 1;
		else
			return month.lastDay();
	}

	public static int leapYearCount(int yyyy) {

		int leap4 = (yyyy - 1896) / 4;
		int leap100 = (yyyy - 1800) / 100;
		int leap400 = (yyyy - 1600) / 400;
		return leap4 - leap100 + leap400;

	}
}
