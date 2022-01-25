/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 *
 * Project Info: http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ---------------
 * SerialDate.java
 * ---------------
 * (C) Copyright 2001-2005, by Object Refinery Limited.
 *
 * Original Author: David Gilbert (for Object Refinery Limited);
 * Contributor(s): -;
 *
 * $Id: SerialDate.java,v 1.7 2005/11/03 09:25:17 mungady Exp $
 *
 */

package org.jfree.date;

import java.io.Serializable;
import java.text.*;
import java.util.*;

/**
 * An abstract class that defines our requirements for manipulating dates,
 * without tying down a particular implementation.
 *
 * Requirement 1 : match at least what Excel does for dates;
 * Requirement 2 : class is immutable;
 *
 * Why not just use java.util.Date? We will, when it makes sense. At times,
 * java.util.Date can be *too* precise - it represents an instant in time,
 * accurate to 1/1000th of a second (with the date itself depending on the
 * time-zone). Sometimes we just want to represent a particular day (e.g. 21
 * January 2015) without concerning ourselves about the time of day, or the
 * time-zone, or anything else. That's what we've defined SerialDate for.
 *
 * You can call getInstance() to get a concrete subclass of SerialDate,
 * without worrying about the exact implementation.
 *
 * @author David Gilbert
 */
public abstract class DayDate implements Comparable,
		Serializable {

	public static enum Month {
		JANUARY(1),
		FEBRUARY(2),
		MARCH(3),
		APRIL(4),
		MAY(5),
		JUNE(6),
		JULY(7),
		AUGUST(8),
		SEPTEMBER(9),
		OCTOBER(10),
		NOVEMBER(11),
		DECEMBER(12);

		Month(int index) {
			this.index = index;
		}

		public static Month make(int monthIndex) {
			for (Month m : Month.values()) {
				if (m.index == monthIndex)
					return m;
			}
			throw new IllegalArgumentException("Invalid month index " + monthIndex);
		}

		public int index;
	}

	public static DateFormatSymbols DATE_FORMAT_SYMBOLS = new SimpleDateFormat().getDateFormatSymbols();

	public static enum Day {
		MONDAY(Calendar.MONDAY),
		TUESDAY(Calendar.TUESDAY),
		WEDNESDAY(Calendar.WEDNESDAY),
		THURSDAY(Calendar.THURSDAY),
		FRIDAY(Calendar.FRIDAY),
		SATURDAY(Calendar.SATURDAY),
		SUNDAY(Calendar.SUNDAY);

		public int index;

		Day(int day) {
			index = day;
		}

		public static Day fromInt(int index) throws IllegalArgumentException {
			for (Day d : Day.values()) {
				if (d.index == index) {
					return d;
				}
			}
			throw new IllegalArgumentException(String.format("Illegal day index: %d.", index));
		}
	}

	private static int[] LAST_DAY_OF_MONTH = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public enum WeekInMonth {
		FIRST(1), SECOND(2), THIRD(3), FOURTH(4), LAST(0);

		public int index;

		WeekInMonth(int index) {
			this.index = index;
		}
	}

	public enum DateInterval {
		CLOSED(0), CLOSED_LEFT(1), CLOSED_RIGHT(2), OPEN(3);

		public int index;

		DateInterval(int index) {
			this.index = index;
		}
	}

	public enum WeekdayRange {
		LAST(-1), NEXT(0), NEAREST(1);

		public int index;

		WeekdayRange(int index) {
			this.index = index;
		}
	}

	public static int stringToWeekdayCode(String s) {

		String[] shortWeekdayNames = DATE_FORMAT_SYMBOLS.getShortWeekdays();
		String[] weekDayNames = DATE_FORMAT_SYMBOLS.getWeekdays();

		int result = -1;
		s = s.trim();
		for (int i = 0; i < weekDayNames.length; i++) {
			if (s.equalsIgnoreCase(shortWeekdayNames[i])) {
				result = i;
				break;
			}
			if (s.equalsIgnoreCase(weekDayNames[i])) {
				result = i;
				break;
			}
		}
		return result;

	}

	/**
	 * Returns a string representing the supplied day-of-the-week.
	 * <P>
	 * Need to find a better approach.
	 *
	 * @param weekday the day of the week.
	 *
	 * @return a string representing the supplied day-of-the-week.
	 */
	public static String weekdayCodeToString(int weekday) {

		String[] weekdays = DATE_FORMAT_SYMBOLS.getWeekdays();
		return weekdays[weekday];

	}

	/**
	 * Returns an array of month names.
	 *
	 * @return an array of month names.
	 */
	public static String[] getMonths() {

		return getMonths(false);

	}

	/**
	 * Returns an array of month names.
	 *
	 * @param shortened a flag indicating that shortened month names should
	 *                  be returned.
	 *
	 * @return an array of month names.
	 */
	public static String[] getMonths(boolean shortened) {

		if (shortened) {
			return DATE_FORMAT_SYMBOLS.getShortMonths();
		} else {
			return DATE_FORMAT_SYMBOLS.getMonths();
		}

	}

	/**
	 * Returns a string representing the supplied month.
	 * <P>
	 * The string returned is the long form of the month name taken from the
	 * default locale.
	 *
	 * @param month the month.
	 *
	 * @return a string representing the supplied month.
	 */
	public static String monthCodeToString(int month) {

		return monthCodeToString(month, false);

	}

	/**
	 * Returns a string representing the supplied month.
	 * <P>
	 * The string returned is the long or short form of the month name taken
	 * from the default locale.
	 *
	 * @param month     the month.
	 * @param shortened if <code>true</code> return the abbreviation of the
	 *                  month.
	 *
	 * @return a string representing the supplied month.
	 * @throws java.lang.IllegalArgumentException
	 */
	public static String monthCodeToString(int month,
			boolean shortened) {

		String[] months;

		if (shortened) {
			months = DATE_FORMAT_SYMBOLS.getShortMonths();
		} else {
			months = DATE_FORMAT_SYMBOLS.getMonths();
		}

		return months[month - 1];

	}

	/**
	 * Converts a string to a month code.
	 * <P>
	 * This method will return one of the constants JANUARY, FEBRUARY, ...,
	 * DECEMBER that corresponds to the string. If the string is not
	 * recognised, this method returns -1.
	 *
	 * @param s the string to parse.
	 *
	 * @return <code>-1</code> if the string is not parseable, the month of the
	 *         year otherwise.
	 */
	public static int stringToMonthCode(String s) {

		String[] shortMonthNames = DATE_FORMAT_SYMBOLS.getShortMonths();
		String[] monthNames = DATE_FORMAT_SYMBOLS.getMonths();

		int result = -1;
		s = s.trim();

		// first try parsing the string as an integer (1-12)...
		try {
			result = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			// suppress
		}

		// now search through the month names...
		if ((result < 1) || (result > 12)) {
			result = -1;
			for (int i = 0; i < monthNames.length; i++) {
				if (s.equalsIgnoreCase(shortMonthNames[i])) {
					result = i + 1;
					break;
				}
				if (s.equalsIgnoreCase(monthNames[i])) {
					result = i + 1;
					break;
				}
			}
		}

		return result;

	}

	/**
	 * Determines whether or not the specified year is a leap year.
	 *
	 * @param yyyy the year (in the range 1900 to 9999).
	 *
	 * @return <code>true</code> if the specified year is a leap year.
	 */
	public static boolean isLeapYear(int yyyy) {

		if ((yyyy % 4) != 0) {
			return false;
		} else if ((yyyy % 400) == 0) {
			return true;
		} else if ((yyyy % 100) == 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Returns the number of leap years from 1900 to the specified year
	 * INCLUSIVE.
	 * <P>
	 * Note that 1900 is not a leap year.
	 *
	 * @param yyyy the year (in the range 1900 to 9999).
	 *
	 * @return the number of leap years from 1900 to the specified year.
	 */
	public static int leapYearCount(int yyyy) {

		int leap4 = (yyyy - 1896) / 4;
		int leap100 = (yyyy - 1800) / 100;
		int leap400 = (yyyy - 1600) / 400;
		return leap4 - leap100 + leap400;

	}

	/**
	 * Returns the number of the last day of the month, taking into account
	 * leap years.
	 *
	 * @param month the month.
	 * @param yyyy  the year (in the range 1900 to 9999).
	 *
	 * @return the number of the last day of the month.
	 */
	public static int lastDayOfMonth(int month, int yyyy) {

		int result = LAST_DAY_OF_MONTH[month];
		if (month != Month.FEBRUARY.index) {
			return result;
		} else if (isLeapYear(yyyy)) {
			return result + 1;
		} else {
			return result;
		}

	}

	/**
	 * Creates a new date by adding the specified number of days to the base
	 * date.
	 *
	 * @param days the number of days to add (can be negative).
	 * @param base the base date.
	 *
	 * @return a new date.
	 */
	public static DayDate addDays(int days, DayDate base) {

		int serialDayNumber = base.toSerial() + days;
		return DayDateFactory.makeDate(serialDayNumber);

	}

	/**
	 * Creates a new date by adding the specified number of months to the base
	 * date.
	 * <P>
	 * If the base date is close to the end of the month, the day on the result
	 * may be adjusted slightly: 31 May + 1 month = 30 June.
	 *
	 * @param months the number of months to add (can be negative).
	 * @param base   the base date.
	 *
	 * @return a new date.
	 */
	public static DayDate addMonths(int months,
			DayDate base) {

		int yy = (12 * base.getYYYY() + base.getMonth() + months - 1)
				/ 12;
		int mm = (12 * base.getYYYY() + base.getMonth() + months - 1)
				% 12 + 1;
		int dd = Math.min(
				base.getDayOfMonth(), DayDate.lastDayOfMonth(mm, yy));
		return DayDateFactory.makeDate(dd, mm, yy);

	}

	/**
	 * Creates a new date by adding the specified number of years to the base
	 * date.
	 *
	 * @param years the number of years to add (can be negative).
	 * @param base  the base date.
	 *
	 * @return A new date.
	 */
	public static DayDate addYears(int years, DayDate base) {

		int baseY = base.getYYYY();
		int baseM = base.getMonth();
		int baseD = base.getDayOfMonth();

		int targetY = baseY + years;
		int targetD = Math.min(
				baseD, DayDate.lastDayOfMonth(baseM, targetY));

		return DayDateFactory.makeDate(targetD, baseM, targetY);

	}

	/**
	 * Returns the latest date that falls on the specified day-of-the-week and
	 * is BEFORE the base date.
	 *
	 * @param targetWeekday a code for the target day-of-the-week.
	 * @param base          the base date.
	 *
	 * @return the latest date that falls on the specified day-of-the-week and
	 *         is BEFORE the base date.
	 */
	public static DayDate getPreviousDayOfWeek(int targetWeekday,
			DayDate base) {

		// check arguments...
		Day.fromInt(targetWeekday);

		// find the date...
		int adjust;
		int baseDOW = base.getDayOfWeek();
		if (baseDOW > targetWeekday) {
			adjust = Math.min(0, targetWeekday - baseDOW);
		} else {
			adjust = -7 + Math.max(0, targetWeekday - baseDOW);
		}

		return DayDate.addDays(adjust, base);

	}

	/**
	 * Returns the earliest date that falls on the specified day-of-the-week
	 * and is AFTER the base date.
	 *
	 * @param targetWeekday a code for the target day-of-the-week.
	 * @param base          the base date.
	 *
	 * @return the earliest date that falls on the specified day-of-the-week
	 *         and is AFTER the base date.
	 */
	public static DayDate getFollowingDayOfWeek(int targetWeekday,
			DayDate base) {

		// check arguments...
		Day.fromInt(targetWeekday);

		// find the date...
		int adjust;
		int baseDOW = base.getDayOfWeek();
		if (baseDOW >= targetWeekday) {
			adjust = 7 + Math.min(0, targetWeekday - baseDOW);
		} else {
			adjust = Math.max(0, targetWeekday - baseDOW);
		}

		return DayDate.addDays(adjust, base);
	}

	/**
	 * Returns the date that falls on the specified day-of-the-week and is
	 * CLOSEST to the base date.
	 *
	 * @param targetDOW a code for the target day-of-the-week.
	 * @param base      the base date.
	 *
	 * @return the date that falls on the specified day-of-the-week and is
	 *         CLOSEST to the base date.
	 */
	public static DayDate getNearestDayOfWeek(int targetDOW,
			DayDate base) {

		// check arguments...
		Day.fromInt(targetDOW);

		// find the date...
		int delta = targetDOW - base.getDayOfWeek();
		int positiveDelta = delta + 7;
		int adjust = positiveDelta % 7;
		if (adjust > 3)
			adjust -= 7;

		return DayDate.addDays(adjust, base);

	}

	/**
	 * Rolls the date forward to the last day of the month.
	 *
	 * @param base the base date.
	 *
	 * @return a new serial date.
	 */
	public DayDate getEndOfCurrentMonth(DayDate base) {
		int last = DayDate.lastDayOfMonth(
				base.getMonth(), base.getYYYY());
		return DayDateFactory.makeDate(last, base.getMonth(), base.getYYYY());
	}

	/**
	 * Returns a string corresponding to the week-in-the-month code.
	 * <P>
	 * Need to find a better approach.
	 *
	 * @param count an integer code representing the week-in-the-month.
	 *
	 * @return a string corresponding to the week-in-the-month code.
	 */
	public static String weekInMonthToString(int count) {

		if (count == WeekInMonth.FIRST.index) {
			return "First";
		} else if (count == WeekInMonth.SECOND.index) {
			return "Second";
		} else if (count == WeekInMonth.THIRD.index) {
			return "Third";
		} else if (count == WeekInMonth.FOURTH.index) {
			return "Fourth";
		} else if (count == WeekInMonth.LAST.index) {
			return "Last";
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Returns a string representing the supplied 'relative'.
	 * <P>
	 * Need to find a better approach.
	 *
	 * @param relative a constant representing the 'relative'.
	 *
	 * @return a string representing the supplied 'relative'.
	 */
	public static String relativeToString(int relative) {

		if (relative == WeekdayRange.LAST.index) {
			return "Last";
		} else if (relative == WeekdayRange.NEAREST.index) {
			return "Nearest";
		} else if (relative == WeekdayRange.NEXT.index) {
			return "Next";
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Returns the serial number for the date, where 1 January 1900 = 2 (this
	 * corresponds, almost, to the numbering system used in Microsoft Excel for
	 * Windows and Lotus 1-2-3).
	 *
	 * @return the serial number for the date.
	 */
	public abstract int toSerial();

	/**
	 * Returns a java.util.Date. Since java.util.Date has more precision than
	 * SerialDate, we need to define a convention for the 'time of day'.
	 *
	 * @return this as <code>java.util.Date</code>.
	 */
	public abstract java.util.Date toDate();

	/**
	 * Converts the date to a string.
	 *
	 * @return a string representation of the date.
	 */
	public String toString() {
		return getDayOfMonth() + "-" + DayDate.monthCodeToString(getMonth())
				+ "-" + getYYYY();
	}

	/**
	 * Returns the year (assume a valid range of 1 to 9999).
	 *
	 * @return the year.
	 */
	public abstract int getYYYY();

	/**
	 * Returns the month (January = 1, February = 2, March = 3).
	 *
	 * @return the month of the year.
	 */
	public abstract int getMonth();

	/**
	 * Returns the day of the month.
	 *
	 * @return the day of the month.
	 */
	public abstract int getDayOfMonth();

	/**
	 * Returns the day of the week.
	 *
	 * @return the day of the week.
	 */
	public abstract int getDayOfWeek();

	/**
	 * Returns the difference (in days) between this date and the specified
	 * 'other' date.
	 * <P>
	 * The result is positive if this date is after the 'other' date and
	 * negative if it is before the 'other' date.
	 *
	 * @param other the date being compared to.
	 *
	 * @return the difference between this and the other date.
	 */
	public abstract int compare(DayDate other);

	/**
	 * Returns true if this SerialDate represents the same date as the
	 * specified SerialDate.
	 *
	 * @param other the date being compared to.
	 *
	 * @return <code>true</code> if this SerialDate represents the same date as
	 *         the specified SerialDate.
	 */
	public abstract boolean isOn(DayDate other);

	/**
	 * Returns true if this SerialDate represents an earlier date compared to
	 * the specified SerialDate.
	 *
	 * @param other The date being compared to.
	 *
	 * @return <code>true</code> if this SerialDate represents an earlier date
	 *         compared to the specified SerialDate.
	 */
	public abstract boolean isBefore(DayDate other);

	/**
	 * Returns true if this SerialDate represents the same date as the
	 * specified SerialDate.
	 *
	 * @param other the date being compared to.
	 *
	 * @return <code>true<code> if this SerialDate represents the same date
	 *         as the specified SerialDate.
	 */
	public abstract boolean isOnOrBefore(DayDate other);

	/**
	 * Returns true if this SerialDate represents the same date as the
	 * specified SerialDate.
	 *
	 * @param other the date being compared to.
	 *
	 * @return <code>true</code> if this SerialDate represents the same date
	 *         as the specified SerialDate.
	 */
	public abstract boolean isAfter(DayDate other);

	/**
	 * Returns true if this SerialDate represents the same date as the
	 * specified SerialDate.
	 *
	 * @param other the date being compared to.
	 *
	 * @return <code>true</code> if this SerialDate represents the same date
	 *         as the specified SerialDate.
	 */
	public abstract boolean isOnOrAfter(DayDate other);

	/**
	 * Returns <code>true</code> if this {@link DayDate} is within the
	 * specified range (INCLUSIVE). The date order of d1 and d2 is not
	 * important.
	 *
	 * @param d1 a boundary date for the range.
	 * @param d2 the other boundary date for the range.
	 *
	 * @return A boolean.
	 */
	public abstract boolean isInRange(DayDate d1, DayDate d2);

	/**
	 * Returns <code>true</code> if this {@link DayDate} is within the
	 * specified range (caller specifies whether or not the end-points are
	 * included). The date order of d1 and d2 is not important.
	 *
	 * @param d1      a boundary date for the range.
	 * @param d2      the other boundary date for the range.
	 * @param include a code that controls whether or not the start and end
	 *                dates are included in the range.
	 *
	 * @return A boolean.
	 */
	public abstract boolean isInRange(DayDate d1, DayDate d2,
			int include);

	/**
	 * Returns the latest date that falls on the specified day-of-the-week and
	 * is BEFORE this date.
	 *
	 * @param targetDOW a code for the target day-of-the-week.
	 *
	 * @return the latest date that falls on the specified day-of-the-week and
	 *         is BEFORE this date.
	 */
	public DayDate getPreviousDayOfWeek(int targetDOW) {
		return getPreviousDayOfWeek(targetDOW, this);
	}

	/**
	 * Returns the earliest date that falls on the specified day-of-the-week
	 * and is AFTER this date.
	 *
	 * @param targetDOW a code for the target day-of-the-week.
	 *
	 * @return the earliest date that falls on the specified day-of-the-week
	 *         and is AFTER this date.
	 */
	public DayDate getFollowingDayOfWeek(int targetDOW) {
		return getFollowingDayOfWeek(targetDOW, this);
	}

	/**
	 * Returns the nearest date that falls on the specified day-of-the-week.
	 *
	 * @param targetDOW a code for the target day-of-the-week.
	 *
	 * @return the nearest date that falls on the specified day-of-the-week.
	 */
	public DayDate getNearestDayOfWeek(int targetDOW) {
		return getNearestDayOfWeek(targetDOW, this);
	}

}