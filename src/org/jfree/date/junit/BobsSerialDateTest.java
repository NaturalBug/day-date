package org.jfree.date.junit;

import junit.framework.TestCase;
import org.jfree.date.*;
import static org.jfree.date.DayDate.*;

import java.util.*;

public class BobsSerialDateTest extends TestCase {

	public void testStringToWeekdayCode() throws Exception {

		try {
			Day.parse("Hello");
			fail("Invalid day of day string should throw exception");
		} catch (IllegalArgumentException e) {
		}
		assertEquals(Day.MONDAY.index, Day.parse("Monday").index);
		assertEquals(Day.MONDAY.index, Day.parse("Mon").index);
		assertEquals(Day.MONDAY.index, Day.parse("monday").index);
		assertEquals(Day.MONDAY.index, Day.parse("MONDAY").index);
		assertEquals(Day.MONDAY.index, Day.parse("mon").index);

		assertEquals(Day.TUESDAY.index, Day.parse("Tuesday").index);
		assertEquals(Day.TUESDAY.index, Day.parse("Tue").index);
		assertEquals(Day.TUESDAY.index, Day.parse("tuesday").index);
		assertEquals(Day.TUESDAY.index, Day.parse("TUESDAY").index);
		assertEquals(Day.TUESDAY.index, Day.parse("tue").index);
		// assertEquals(TUESDAY, stringToWeekdayCode("tues"));

		assertEquals(Day.WEDNESDAY.index, Day.parse("Wednesday").index);
		assertEquals(Day.WEDNESDAY.index, Day.parse("Wed").index);
		assertEquals(Day.WEDNESDAY.index, Day.parse("wednesday").index);
		assertEquals(Day.WEDNESDAY.index, Day.parse("WEDNESDAY").index);
		assertEquals(Day.WEDNESDAY.index, Day.parse("wed").index);

		assertEquals(Day.THURSDAY.index, Day.parse("Thursday").index);
		assertEquals(Day.THURSDAY.index, Day.parse("Thu").index);
		assertEquals(Day.THURSDAY.index, Day.parse("thursday").index);
		assertEquals(Day.THURSDAY.index, Day.parse("THURSDAY").index);
		assertEquals(Day.THURSDAY.index, Day.parse("thu").index);
		// assertEquals(THURSDAY, stringToWeekdayCode("thurs"));

		assertEquals(Day.FRIDAY.index, Day.parse("Friday").index);
		assertEquals(Day.FRIDAY.index, Day.parse("Fri").index);
		assertEquals(Day.FRIDAY.index, Day.parse("friday").index);
		assertEquals(Day.FRIDAY.index, Day.parse("FRIDAY").index);
		assertEquals(Day.FRIDAY.index, Day.parse("fri").index);

		assertEquals(Day.SATURDAY.index, Day.parse("Saturday").index);
		assertEquals(Day.SATURDAY.index, Day.parse("Sat").index);
		assertEquals(Day.SATURDAY.index, Day.parse("saturday").index);
		assertEquals(Day.SATURDAY.index, Day.parse("SATURDAY").index);
		assertEquals(Day.SATURDAY.index, Day.parse("sat").index);

		assertEquals(Day.SUNDAY.index, Day.parse("Sunday").index);
		assertEquals(Day.SUNDAY.index, Day.parse("Sun").index);
		assertEquals(Day.SUNDAY.index, Day.parse("sunday").index);
		assertEquals(Day.SUNDAY.index, Day.parse("SUNDAY").index);
		assertEquals(Day.SUNDAY.index, Day.parse("sun").index);
	}

	public void testWeekdayCodeToString() throws Exception {
		assertEquals("Sunday", Day.SUNDAY.toString());
		assertEquals("Monday", Day.MONDAY.toString());
		assertEquals("Tuesday", Day.TUESDAY.toString());
		assertEquals("Wednesday", Day.WEDNESDAY.toString());
		assertEquals("Thursday", Day.THURSDAY.toString());
		assertEquals("Friday", Day.FRIDAY.toString());
		assertEquals("Saturday", Day.SATURDAY.toString());
	}

	public void testMonthCodeToString() throws Exception {
		assertEquals("January", monthCodeToString(Month.JANUARY.index));
		assertEquals("February", monthCodeToString(Month.FEBRUARY.index));
		assertEquals("March", monthCodeToString(Month.MARCH.index));
		assertEquals("April", monthCodeToString(Month.APRIL.index));
		assertEquals("May", monthCodeToString(Month.MAY.index));
		assertEquals("June", monthCodeToString(Month.JUNE.index));
		assertEquals("July", monthCodeToString(Month.JULY.index));
		assertEquals("August", monthCodeToString(Month.AUGUST.index));
		assertEquals("September", monthCodeToString(Month.SEPTEMBER.index));
		assertEquals("October", monthCodeToString(Month.OCTOBER.index));
		assertEquals("November", monthCodeToString(Month.NOVEMBER.index));
		assertEquals("December", monthCodeToString(Month.DECEMBER.index));

		assertEquals("Jan", monthCodeToString(Month.JANUARY.index, true));
		assertEquals("Feb", monthCodeToString(Month.FEBRUARY.index, true));
		assertEquals("Mar", monthCodeToString(Month.MARCH.index, true));
		assertEquals("Apr", monthCodeToString(Month.APRIL.index, true));
		assertEquals("May", monthCodeToString(Month.MAY.index, true));
		assertEquals("Jun", monthCodeToString(Month.JUNE.index, true));
		assertEquals("Jul", monthCodeToString(Month.JULY.index, true));
		assertEquals("Aug", monthCodeToString(Month.AUGUST.index, true));
		assertEquals("Sep", monthCodeToString(Month.SEPTEMBER.index, true));
		assertEquals("Oct", monthCodeToString(Month.OCTOBER.index, true));
		assertEquals("Nov", monthCodeToString(Month.NOVEMBER.index, true));
		assertEquals("Dec", monthCodeToString(Month.DECEMBER.index, true));
	}

	public void testStringToMonthCode() throws Exception {
		assertEquals(Month.JANUARY.index, stringToMonthCode("1"));
		assertEquals(Month.FEBRUARY.index, stringToMonthCode("2"));
		assertEquals(Month.MARCH.index, stringToMonthCode("3"));
		assertEquals(Month.APRIL.index, stringToMonthCode("4"));
		assertEquals(Month.MAY.index, stringToMonthCode("5"));
		assertEquals(Month.JUNE.index, stringToMonthCode("6"));
		assertEquals(Month.JULY.index, stringToMonthCode("7"));
		assertEquals(Month.AUGUST.index, stringToMonthCode("8"));
		assertEquals(Month.SEPTEMBER.index, stringToMonthCode("9"));
		assertEquals(Month.OCTOBER.index, stringToMonthCode("10"));
		assertEquals(Month.NOVEMBER.index, stringToMonthCode("11"));
		assertEquals(Month.DECEMBER.index, stringToMonthCode("12"));

		assertEquals(-1, stringToMonthCode("0"));
		assertEquals(-1, stringToMonthCode("13"));

		assertEquals(-1, stringToMonthCode("Hello"));

		for (int m = 1; m <= 12; m++) {
			assertEquals(m, stringToMonthCode(monthCodeToString(m, false)));
			assertEquals(m, stringToMonthCode(monthCodeToString(m, true)));
		}

		assertEquals(1, stringToMonthCode("jan"));
		assertEquals(2, stringToMonthCode("feb"));
		assertEquals(3, stringToMonthCode("mar"));
		assertEquals(4, stringToMonthCode("apr"));
		assertEquals(5, stringToMonthCode("may"));
		assertEquals(6, stringToMonthCode("jun"));
		assertEquals(7, stringToMonthCode("jul"));
		assertEquals(8, stringToMonthCode("aug"));
		assertEquals(9, stringToMonthCode("sep"));
		assertEquals(10, stringToMonthCode("oct"));
		assertEquals(11, stringToMonthCode("nov"));
		assertEquals(12, stringToMonthCode("dec"));

		assertEquals(1, stringToMonthCode("JAN"));
		assertEquals(2, stringToMonthCode("FEB"));
		assertEquals(3, stringToMonthCode("MAR"));
		assertEquals(4, stringToMonthCode("APR"));
		assertEquals(5, stringToMonthCode("MAY"));
		assertEquals(6, stringToMonthCode("JUN"));
		assertEquals(7, stringToMonthCode("JUL"));
		assertEquals(8, stringToMonthCode("AUG"));
		assertEquals(9, stringToMonthCode("SEP"));
		assertEquals(10, stringToMonthCode("OCT"));
		assertEquals(11, stringToMonthCode("NOV"));
		assertEquals(12, stringToMonthCode("DEC"));

		assertEquals(1, stringToMonthCode("january"));
		assertEquals(2, stringToMonthCode("february"));
		assertEquals(3, stringToMonthCode("march"));
		assertEquals(4, stringToMonthCode("april"));
		assertEquals(5, stringToMonthCode("may"));
		assertEquals(6, stringToMonthCode("june"));
		assertEquals(7, stringToMonthCode("july"));
		assertEquals(8, stringToMonthCode("august"));
		assertEquals(9, stringToMonthCode("september"));
		assertEquals(10, stringToMonthCode("october"));
		assertEquals(11, stringToMonthCode("november"));
		assertEquals(12, stringToMonthCode("december"));

		assertEquals(1, stringToMonthCode("JANUARY"));
		assertEquals(2, stringToMonthCode("FEBRUARY"));
		assertEquals(3, stringToMonthCode("MAR"));
		assertEquals(4, stringToMonthCode("APRIL"));
		assertEquals(5, stringToMonthCode("MAY"));
		assertEquals(6, stringToMonthCode("JUNE"));
		assertEquals(7, stringToMonthCode("JULY"));
		assertEquals(8, stringToMonthCode("AUGUST"));
		assertEquals(9, stringToMonthCode("SEPTEMBER"));
		assertEquals(10, stringToMonthCode("OCTOBER"));
		assertEquals(11, stringToMonthCode("NOVEMBER"));
		assertEquals(12, stringToMonthCode("DECEMBER"));
	}

	public void testIsLeapYear() throws Exception {
		assertFalse(isLeapYear(1900));
		assertFalse(isLeapYear(1901));
		assertFalse(isLeapYear(1902));
		assertFalse(isLeapYear(1903));
		assertTrue(isLeapYear(1904));
		assertTrue(isLeapYear(1908));
		assertFalse(isLeapYear(1955));
		assertTrue(isLeapYear(1964));
		assertTrue(isLeapYear(1980));
		assertTrue(isLeapYear(2000));
		assertFalse(isLeapYear(2001));
		assertFalse(isLeapYear(2100));
	}

	public void testLeapYearCount() throws Exception {
		assertEquals(0, leapYearCount(1900));
		assertEquals(0, leapYearCount(1901));
		assertEquals(0, leapYearCount(1902));
		assertEquals(0, leapYearCount(1903));
		assertEquals(1, leapYearCount(1904));
		assertEquals(1, leapYearCount(1905));
		assertEquals(1, leapYearCount(1906));
		assertEquals(1, leapYearCount(1907));
		assertEquals(2, leapYearCount(1908));
		assertEquals(24, leapYearCount(1999));
		assertEquals(25, leapYearCount(2001));
		assertEquals(49, leapYearCount(2101));
		assertEquals(73, leapYearCount(2201));
		assertEquals(97, leapYearCount(2301));
		assertEquals(122, leapYearCount(2401));
	}

	public void testLastDayOfMonth() throws Exception {
		assertEquals(31, lastDayOfMonth(Month.JANUARY.index, 1901));
		assertEquals(28, lastDayOfMonth(Month.FEBRUARY.index, 1901));
		assertEquals(31, lastDayOfMonth(Month.MARCH.index, 1901));
		assertEquals(30, lastDayOfMonth(Month.APRIL.index, 1901));
		assertEquals(31, lastDayOfMonth(Month.MAY.index, 1901));
		assertEquals(30, lastDayOfMonth(Month.JUNE.index, 1901));
		assertEquals(31, lastDayOfMonth(Month.JULY.index, 1901));
		assertEquals(31, lastDayOfMonth(Month.AUGUST.index, 1901));
		assertEquals(30, lastDayOfMonth(Month.SEPTEMBER.index, 1901));
		assertEquals(31, lastDayOfMonth(Month.OCTOBER.index, 1901));
		assertEquals(30, lastDayOfMonth(Month.NOVEMBER.index, 1901));
		assertEquals(31, lastDayOfMonth(Month.DECEMBER.index, 1901));
		assertEquals(29, lastDayOfMonth(Month.FEBRUARY.index, 1904));
	}

	public void testAddDays() throws Exception {
		DayDate newYears = d(1, Month.JANUARY.index, 1900);
		assertEquals(d(2, Month.JANUARY.index, 1900), addDays(1, newYears));
		assertEquals(d(1, Month.FEBRUARY.index, 1900), addDays(31, newYears));
		assertEquals(d(1, Month.JANUARY.index, 1901), addDays(365, newYears));
		assertEquals(d(31, Month.DECEMBER.index, 1904), addDays(5 * 365, newYears));
	}

	private static SpreadsheetDate d(int day, int month, int year) {
		return new SpreadsheetDate(day, month, year);
	}

	public void testAddMonths() throws Exception {
		assertEquals(d(1, Month.FEBRUARY.index, 1900), addMonths(1, d(1, Month.JANUARY.index, 1900)));
		assertEquals(d(28, Month.FEBRUARY.index, 1900), addMonths(1, d(31, Month.JANUARY.index, 1900)));
		assertEquals(d(28, Month.FEBRUARY.index, 1900), addMonths(1, d(30, Month.JANUARY.index, 1900)));
		assertEquals(d(28, Month.FEBRUARY.index, 1900), addMonths(1, d(29, Month.JANUARY.index, 1900)));
		assertEquals(d(28, Month.FEBRUARY.index, 1900), addMonths(1, d(28, Month.JANUARY.index, 1900)));
		assertEquals(d(27, Month.FEBRUARY.index, 1900), addMonths(1, d(27, Month.JANUARY.index, 1900)));

		assertEquals(d(30, Month.JUNE.index, 1900), addMonths(5, d(31, Month.JANUARY.index, 1900)));
		assertEquals(d(30, Month.JUNE.index, 1901), addMonths(17, d(31, Month.JANUARY.index, 1900)));

		assertEquals(d(29, Month.FEBRUARY.index, 1904), addMonths(49, d(31, Month.JANUARY.index, 1900)));

	}

	public void testAddYears() throws Exception {
		assertEquals(d(1, Month.JANUARY.index, 1901), addYears(1, d(1, Month.JANUARY.index, 1900)));
		assertEquals(d(28, Month.FEBRUARY.index, 1905), addYears(1, d(29, Month.FEBRUARY.index, 1904)));
		assertEquals(d(28, Month.FEBRUARY.index, 1905), addYears(1, d(28, Month.FEBRUARY.index, 1904)));
		assertEquals(d(28, Month.FEBRUARY.index, 1904), addYears(1, d(28, Month.FEBRUARY.index, 1903)));
	}

	public void testGetPreviousDayOfWeek() throws Exception {
		assertEquals(d(24, Month.FEBRUARY.index, 2006),
				getPreviousDayOfWeek(Day.FRIDAY.index, d(1, Month.MARCH.index, 2006)));
		assertEquals(d(22, Month.FEBRUARY.index, 2006),
				getPreviousDayOfWeek(Day.WEDNESDAY.index, d(1, Month.MARCH.index, 2006)));
		assertEquals(d(29, Month.FEBRUARY.index, 2004),
				getPreviousDayOfWeek(Day.SUNDAY.index, d(3, Month.MARCH.index, 2004)));
		assertEquals(d(29, Month.DECEMBER.index, 2004),
				getPreviousDayOfWeek(Day.WEDNESDAY.index, d(5, Month.JANUARY.index, 2005)));

		try {
			getPreviousDayOfWeek(-1, d(1, Month.JANUARY.index, 2006));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testGetFollowingDayOfWeek() throws Exception {
		assertEquals(d(1, Month.JANUARY.index, 2005),
				getFollowingDayOfWeek(Day.SATURDAY.index, d(25, Month.DECEMBER.index, 2004)));
		assertEquals(d(1, Month.JANUARY.index, 2005),
				getFollowingDayOfWeek(Day.SATURDAY.index, d(26, Month.DECEMBER.index, 2004)));
		assertEquals(d(3, Month.MARCH.index, 2004),
				getFollowingDayOfWeek(Day.WEDNESDAY.index, d(28, Month.FEBRUARY.index, 2004)));

		try {
			getFollowingDayOfWeek(-1, d(1, Month.JANUARY.index, 2006));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testGetNearestDayOfWeek() throws Exception {
		assertEquals(d(16, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SUNDAY.index, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(16, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SUNDAY.index, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(16, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SUNDAY.index, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(16, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SUNDAY.index, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(23, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SUNDAY.index, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(23, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SUNDAY.index, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(23, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SUNDAY.index, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(17, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.MONDAY.index, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(17, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.MONDAY.index, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(17, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.MONDAY.index, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(17, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.MONDAY.index, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(17, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.MONDAY.index, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(24, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.MONDAY.index, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(24, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.MONDAY.index, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(18, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.TUESDAY.index, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.TUESDAY.index, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.TUESDAY.index, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.TUESDAY.index, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.TUESDAY.index, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.TUESDAY.index, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(25, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.TUESDAY.index, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(19, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.WEDNESDAY.index, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.WEDNESDAY.index, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.WEDNESDAY.index, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.WEDNESDAY.index, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.WEDNESDAY.index, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.WEDNESDAY.index, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.WEDNESDAY.index, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(13, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.THURSDAY.index, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.THURSDAY.index, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.THURSDAY.index, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.THURSDAY.index, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.THURSDAY.index, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.THURSDAY.index, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.THURSDAY.index, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(14, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.FRIDAY.index, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(14, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.FRIDAY.index, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.FRIDAY.index, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.FRIDAY.index, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.FRIDAY.index, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.FRIDAY.index, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.FRIDAY.index, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(15, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SATURDAY.index, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(15, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SATURDAY.index, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(15, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SATURDAY.index, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(22, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SATURDAY.index, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(22, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SATURDAY.index, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(22, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SATURDAY.index, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(22, Month.APRIL.index, 2006),
				getNearestDayOfWeek(Day.SATURDAY.index, d(22, Month.APRIL.index, 2006)));

		try {
			getNearestDayOfWeek(-1, d(1, Month.JANUARY.index, 2006));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testEndOfCurrentMonth() throws Exception {
		DayDate d = DayDateFactory.makeDate(2);
		assertEquals(d(31, Month.JANUARY.index, 2006), d.getEndOfCurrentMonth(d(1, Month.JANUARY.index, 2006)));
		assertEquals(d(28, Month.FEBRUARY.index, 2006), d.getEndOfCurrentMonth(d(1, Month.FEBRUARY.index, 2006)));
		assertEquals(d(31, Month.MARCH.index, 2006), d.getEndOfCurrentMonth(d(1, Month.MARCH.index, 2006)));
		assertEquals(d(30, Month.APRIL.index, 2006), d.getEndOfCurrentMonth(d(1, Month.APRIL.index, 2006)));
		assertEquals(d(31, Month.MAY.index, 2006), d.getEndOfCurrentMonth(d(1, Month.MAY.index, 2006)));
		assertEquals(d(30, Month.JUNE.index, 2006), d.getEndOfCurrentMonth(d(1, Month.JUNE.index, 2006)));
		assertEquals(d(31, Month.JULY.index, 2006), d.getEndOfCurrentMonth(d(1, Month.JULY.index, 2006)));
		assertEquals(d(31, Month.AUGUST.index, 2006), d.getEndOfCurrentMonth(d(1, Month.AUGUST.index, 2006)));
		assertEquals(d(30, Month.SEPTEMBER.index, 2006), d.getEndOfCurrentMonth(d(1, Month.SEPTEMBER.index, 2006)));
		assertEquals(d(31, Month.OCTOBER.index, 2006), d.getEndOfCurrentMonth(d(1, Month.OCTOBER.index, 2006)));
		assertEquals(d(30, Month.NOVEMBER.index, 2006), d.getEndOfCurrentMonth(d(1, Month.NOVEMBER.index, 2006)));
		assertEquals(d(31, Month.DECEMBER.index, 2006), d.getEndOfCurrentMonth(d(1, Month.DECEMBER.index, 2006)));
		assertEquals(d(29, Month.FEBRUARY.index, 2008), d.getEndOfCurrentMonth(d(1, Month.FEBRUARY.index, 2008)));
	}

	public void testWeekInMonthToString() throws Exception {
		assertEquals("First", weekInMonthToString(WeekInMonth.FIRST.index));
		assertEquals("Second", weekInMonthToString(WeekInMonth.SECOND.index));
		assertEquals("Third", weekInMonthToString(WeekInMonth.THIRD.index));
		assertEquals("Fourth", weekInMonthToString(WeekInMonth.FOURTH.index));
		assertEquals("Last", weekInMonthToString(WeekInMonth.LAST.index));

		try {
			weekInMonthToString(-1);
			fail("Invalid week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testRelativeToString() throws Exception {
		assertEquals("Last", relativeToString(WeekdayRange.LAST.index));
		assertEquals("Nearest", relativeToString(WeekdayRange.NEAREST.index));
		assertEquals("Next", relativeToString(WeekdayRange.NEXT.index));

		try {
			relativeToString(-1000);
			fail("Invalid relative code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testMakeDateFromDDMMYYY() throws Exception {
		DayDate date = DayDateFactory.makeDate(1, Month.JANUARY.index, 1900);
		assertEquals(1, date.getDayOfMonth());
		assertEquals(Month.JANUARY.index, date.getMonth());
		assertEquals(1900, date.getYYYY());
		assertEquals(2, date.toSerial());
	}

	public void testMakeDateFromOrdinal() throws Exception {
		assertEquals(d(1, Month.JANUARY.index, 1900), DayDateFactory.makeDate(2));
		assertEquals(d(1, Month.JANUARY.index, 1901), DayDateFactory.makeDate(367));
	}

	public void testMakeDateFromJavaDate() throws Exception {
		assertEquals(d(1, Month.JANUARY.index, 1900),
				DayDateFactory.makeDate(new GregorianCalendar(1900, 1, 1).getTime()));
		assertEquals(d(1, Month.JANUARY.index, 2006),
				DayDateFactory.makeDate(new GregorianCalendar(2006, 1, 1).getTime()));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(BobsSerialDateTest.class);
	}
}