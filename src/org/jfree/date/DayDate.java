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
import java.util.Date;
import java.util.Calendar;

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
public abstract class DayDate implements Comparable, Serializable {
	public abstract int getOrdinalDay();

	public abstract int getYear();

	public abstract int getMonth();

	public abstract int getDayOfMonth();

	protected abstract Day getDayOfWeekForOrdinalZero();

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
	 * Creates a new date by adding the specified number of days to the base
	 * date.
	 *
	 * @param days the number of days to add (can be negative).
	 *
	 * @return a new date.
	 */
	public DayDate plusDays(int days) {
		return DayDateFactory.makeDate(getOrdinalDay() + days);
	}

	/**
	 * Creates a new date by adding the specified number of months to the base
	 * date.
	 * <P>
	 * If the base date is close to the end of the month, the day on the result
	 * may be adjusted slightly: 31 May + 1 month = 30 June.
	 *
	 * @param months the number of months to add (can be negative).
	 *
	 * @return a new date.
	 */
	public DayDate plusMonths(int months) {
		int thisMonthAsOrdinal = 12 * getYear() + getMonth() - 1;
		int resultMonthAsOrdinal = thisMonthAsOrdinal + months;
		int resultYear = resultMonthAsOrdinal / 12;
		Month resultMonth = Month.fromInt(resultMonthAsOrdinal % 12 + 1);
		int resultDay = correctLastDayOfMonth(getDayOfMonth(), resultMonth, resultYear);
		return DayDateFactory.makeDate(resultDay, resultMonth, resultYear);
	}

	public DayDate plusYears(int years) {
		int resultYear = getYear() + years;
		int resultDay = correctLastDayOfMonth(getDayOfMonth(), Month.fromInt(getMonth()), resultYear);
		return DayDateFactory.makeDate(resultDay, getMonth(), resultYear);
	}

	private int correctLastDayOfMonth(int day, Month month, int year) {
		int lastDayOfMonth = DateUtil.lastDayOfMonth(month, year);
		if (day > lastDayOfMonth)
			day = lastDayOfMonth;
		return day;
	}

	/**
	 * Returns the latest date that falls on the specified day-of-the-week and
	 * is BEFORE the base date.
	 *
	 * @param targetDayOfWeek a code for the target day-of-the-week.
	 *
	 * @return the latest date that falls on the specified day-of-the-week and
	 *         is BEFORE the base date.
	 */
	public DayDate getPreviousDayOfWeek(Day targetDayOfWeek) {
		int offsetToTarget = targetDayOfWeek.toInt() - getDayOfWeek().toInt();
		if (offsetToTarget >= 0)
			offsetToTarget -= 7;
		return plusDays(offsetToTarget);
	}

	/**
	 * Returns the earliest date that falls on the specified day-of-the-week
	 * and is AFTER the base date.
	 *
	 * @param targetDayOfWeek a code for the target day-of-the-week.
	 *
	 * @return the earliest date that falls on the specified day-of-the-week
	 *         and is AFTER the base date.
	 */
	public DayDate getFollowingDayOfWeek(Day targetDayOfWeek) {
		int offsetToTarget = targetDayOfWeek.toInt() - getDayOfWeek().toInt();
		if (offsetToTarget <= 0)
			offsetToTarget += 7;
		return plusDays(offsetToTarget);
	}

	/**
	 * Returns the date that falls on the specified day-of-the-week and is
	 * CLOSEST to the base date.
	 *
	 * @param targetDay a code for the target day-of-the-week.
	 *
	 * @return the date that falls on the specified day-of-the-week and is
	 *         CLOSEST to the base date.
	 */
	public DayDate getNearestDayOfWeek(final Day targetDay) {
		int offsetToThisWeeksTarget = targetDay.toInt() - getDayOfWeek().toInt();
		int offsetToFutureTarget = (offsetToThisWeeksTarget + 7) % 7;
		int offsetToPreviousTarget = offsetToFutureTarget - 7;

		if (offsetToFutureTarget > 3)
			return plusDays(offsetToPreviousTarget);
		else
			return plusDays(offsetToFutureTarget);
	}

	/**
	 * Rolls the date forward to the last day of the month.
	 *
	 * @return a new serial date.
	 */
	public DayDate getEndOfMonth() {
		Month month = Month.fromInt(getMonth());
		int year = getYear();
		int lastDay = DateUtil.lastDayOfMonth(month, year);
		return DayDateFactory.makeDate(lastDay, month, year);
	}

	/**
	 * Returns a <code>java.util.Date</code> equivalent to this date.
	 *
	 * @return The date.
	 */
	public Date toDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getYear(), getMonth() - 1, getDayOfMonth(), 0, 0, 0);
		return calendar.getTime();
	}

	/**
	 * Converts the date to a string.
	 *
	 * @return a string representation of the date.
	 */
	public String toString() {
		return getDayOfMonth() + "-" + Month.fromInt(getMonth())
				+ "-" + getYear();
	}

	public Day getDayOfWeek() {
		Day startingDay = getDayOfWeekForOrdinalZero();
		int startingOffset = startingDay.toInt() - Day.SUNDAY.toInt();
		return Day.fromInt((getOrdinalDay() + startingOffset) % 7 + 1);
	}

	public int daySince(DayDate date) {
		return getOrdinalDay() - date.getOrdinalDay();
	}

	public boolean isOn(DayDate date) {
		return getOrdinalDay() == date.getOrdinalDay();
	}

	public boolean isBefore(DayDate date) {
		return getOrdinalDay() < date.getOrdinalDay();
	}

	public boolean isOnOrBefore(DayDate date) {
		return getOrdinalDay() <= date.getOrdinalDay();
	}

	public boolean isAfter(DayDate other) {
		return getOrdinalDay() > other.getOrdinalDay();
	}

	public boolean isOnOrAfter(DayDate other) {
		return getOrdinalDay() >= other.getOrdinalDay();
	}

	public boolean isInRange(DayDate d1, DayDate d2) {
		return isInRange(d1, d2, DateInterval.OPEN);
	}

	public boolean isInRange(DayDate d1, DayDate d2, DateInterval interval) {
		int left = Math.min(d1.getOrdinalDay(), d2.getOrdinalDay());
		int right = Math.max(d1.getOrdinalDay(), d2.getOrdinalDay());
		return interval.isIn(getOrdinalDay(), left, right);
	}
}