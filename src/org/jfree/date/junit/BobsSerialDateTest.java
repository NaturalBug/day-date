package org.jfree.date.junit;

import junit.framework.TestCase;
import org.jfree.date.*;
import static org.jfree.date.DayDate.*;

import java.util.*;

public class BobsSerialDateTest extends TestCase {

	public void testIsValidWeekdayCode() throws Exception {
		for (int day = 1; day <= 7; day++)
			assertTrue(isValidWeekdayCode(day));
		assertFalse(isValidWeekdayCode(0));
		assertFalse(isValidWeekdayCode(8));
	}

	public void testStringToWeekdayCode() throws Exception {

		assertEquals(-1, stringToWeekdayCode("Hello"));
		assertEquals(MONDAY, stringToWeekdayCode("Monday"));
		assertEquals(MONDAY, stringToWeekdayCode("Mon"));
		assertEquals(MONDAY,stringToWeekdayCode("monday"));
		assertEquals(MONDAY,stringToWeekdayCode("MONDAY"));
		assertEquals(MONDAY, stringToWeekdayCode("mon"));

		assertEquals(TUESDAY, stringToWeekdayCode("Tuesday"));
		assertEquals(TUESDAY, stringToWeekdayCode("Tue"));
		assertEquals(TUESDAY,stringToWeekdayCode("tuesday"));
		assertEquals(TUESDAY,stringToWeekdayCode("TUESDAY"));
		assertEquals(TUESDAY, stringToWeekdayCode("tue"));
		// assertEquals(TUESDAY, stringToWeekdayCode("tues"));

		assertEquals(WEDNESDAY, stringToWeekdayCode("Wednesday"));
		assertEquals(WEDNESDAY, stringToWeekdayCode("Wed"));
		assertEquals(WEDNESDAY,stringToWeekdayCode("wednesday"));
		assertEquals(WEDNESDAY,stringToWeekdayCode("WEDNESDAY"));
		assertEquals(WEDNESDAY, stringToWeekdayCode("wed"));

		assertEquals(THURSDAY, stringToWeekdayCode("Thursday"));
		assertEquals(THURSDAY, stringToWeekdayCode("Thu"));
		assertEquals(THURSDAY,stringToWeekdayCode("thursday"));
		assertEquals(THURSDAY,stringToWeekdayCode("THURSDAY"));
		assertEquals(THURSDAY, stringToWeekdayCode("thu"));
		// assertEquals(THURSDAY, stringToWeekdayCode("thurs"));

		assertEquals(FRIDAY, stringToWeekdayCode("Friday"));
		assertEquals(FRIDAY, stringToWeekdayCode("Fri"));
		assertEquals(FRIDAY,stringToWeekdayCode("friday"));
		assertEquals(FRIDAY,stringToWeekdayCode("FRIDAY"));
		assertEquals(FRIDAY, stringToWeekdayCode("fri"));

		assertEquals(SATURDAY, stringToWeekdayCode("Saturday"));
		assertEquals(SATURDAY, stringToWeekdayCode("Sat"));
		assertEquals(SATURDAY,stringToWeekdayCode("saturday"));
		assertEquals(SATURDAY,stringToWeekdayCode("SATURDAY"));
		assertEquals(SATURDAY, stringToWeekdayCode("sat"));

		assertEquals(SUNDAY, stringToWeekdayCode("Sunday"));
		assertEquals(SUNDAY, stringToWeekdayCode("Sun"));
		assertEquals(SUNDAY,stringToWeekdayCode("sunday"));
		assertEquals(SUNDAY,stringToWeekdayCode("SUNDAY"));
		assertEquals(SUNDAY, stringToWeekdayCode("sun"));
	}

	public void testWeekdayCodeToString() throws Exception {
		assertEquals("Sunday", weekdayCodeToString(SUNDAY));
		assertEquals("Monday", weekdayCodeToString(MONDAY));
		assertEquals("Tuesday", weekdayCodeToString(TUESDAY));
		assertEquals("Wednesday", weekdayCodeToString(WEDNESDAY));
		assertEquals("Thursday", weekdayCodeToString(THURSDAY));
		assertEquals("Friday", weekdayCodeToString(FRIDAY));
		assertEquals("Saturday", weekdayCodeToString(SATURDAY));
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

		assertEquals(1,stringToMonthCode("jan"));
		assertEquals(2,stringToMonthCode("feb"));
		assertEquals(3,stringToMonthCode("mar"));
		assertEquals(4,stringToMonthCode("apr"));
		assertEquals(5,stringToMonthCode("may"));
		assertEquals(6,stringToMonthCode("jun"));
		assertEquals(7,stringToMonthCode("jul"));
		assertEquals(8,stringToMonthCode("aug"));
		assertEquals(9,stringToMonthCode("sep"));
		assertEquals(10,stringToMonthCode("oct"));
		assertEquals(11,stringToMonthCode("nov"));
		assertEquals(12,stringToMonthCode("dec"));

		assertEquals(1,stringToMonthCode("JAN"));
		assertEquals(2,stringToMonthCode("FEB"));
		assertEquals(3,stringToMonthCode("MAR"));
		assertEquals(4,stringToMonthCode("APR"));
		assertEquals(5,stringToMonthCode("MAY"));
		assertEquals(6,stringToMonthCode("JUN"));
		assertEquals(7,stringToMonthCode("JUL"));
		assertEquals(8,stringToMonthCode("AUG"));
		assertEquals(9,stringToMonthCode("SEP"));
		assertEquals(10,stringToMonthCode("OCT"));
		assertEquals(11,stringToMonthCode("NOV"));
		assertEquals(12,stringToMonthCode("DEC"));

		assertEquals(1,stringToMonthCode("january"));
		assertEquals(2,stringToMonthCode("february"));
		assertEquals(3,stringToMonthCode("march"));
		assertEquals(4,stringToMonthCode("april"));
		assertEquals(5,stringToMonthCode("may"));
		assertEquals(6,stringToMonthCode("june"));
		assertEquals(7,stringToMonthCode("july"));
		assertEquals(8,stringToMonthCode("august"));
		assertEquals(9,stringToMonthCode("september"));
		assertEquals(10,stringToMonthCode("october"));
		assertEquals(11,stringToMonthCode("november"));
		assertEquals(12,stringToMonthCode("december"));

		assertEquals(1,stringToMonthCode("JANUARY"));
		assertEquals(2,stringToMonthCode("FEBRUARY"));
		assertEquals(3,stringToMonthCode("MAR"));
		assertEquals(4,stringToMonthCode("APRIL"));
		assertEquals(5,stringToMonthCode("MAY"));
		assertEquals(6,stringToMonthCode("JUNE"));
		assertEquals(7,stringToMonthCode("JULY"));
		assertEquals(8,stringToMonthCode("AUGUST"));
		assertEquals(9,stringToMonthCode("SEPTEMBER"));
		assertEquals(10,stringToMonthCode("OCTOBER"));
		assertEquals(11,stringToMonthCode("NOVEMBER"));
		assertEquals(12,stringToMonthCode("DECEMBER"));
	}

	public void testIsValidWeekInMonthCode() throws Exception {
		for (int w = 0; w <= 4; w++) {
			assertTrue(isValidWeekInMonthCode(w));
		}
		assertFalse(isValidWeekInMonthCode(5));
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
		assertEquals(d(24, Month.FEBRUARY.index, 2006), getPreviousDayOfWeek(FRIDAY, d(1, Month.MARCH.index, 2006)));
		assertEquals(d(22, Month.FEBRUARY.index, 2006), getPreviousDayOfWeek(WEDNESDAY, d(1, Month.MARCH.index, 2006)));
		assertEquals(d(29, Month.FEBRUARY.index, 2004), getPreviousDayOfWeek(SUNDAY, d(3, Month.MARCH.index, 2004)));
		assertEquals(d(29, Month.DECEMBER.index, 2004), getPreviousDayOfWeek(WEDNESDAY, d(5, Month.JANUARY.index, 2005)));

		try {
			getPreviousDayOfWeek(-1, d(1, Month.JANUARY.index, 2006));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testGetFollowingDayOfWeek() throws Exception {
		assertEquals(d(1, Month.JANUARY.index, 2005),getFollowingDayOfWeek(SATURDAY, d(25, Month.DECEMBER.index, 2004)));
		assertEquals(d(1, Month.JANUARY.index, 2005), getFollowingDayOfWeek(SATURDAY, d(26, Month.DECEMBER.index, 2004)));
		assertEquals(d(3, Month.MARCH.index, 2004), getFollowingDayOfWeek(WEDNESDAY, d(28, Month.FEBRUARY.index, 2004)));

		try {
			getFollowingDayOfWeek(-1, d(1, Month.JANUARY.index, 2006));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testGetNearestDayOfWeek() throws Exception {
		assertEquals(d(16, Month.APRIL.index, 2006), getNearestDayOfWeek(SUNDAY, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(16, Month.APRIL.index, 2006), getNearestDayOfWeek(SUNDAY, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(16, Month.APRIL.index, 2006), getNearestDayOfWeek(SUNDAY, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(16, Month.APRIL.index, 2006), getNearestDayOfWeek(SUNDAY, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(23, Month.APRIL.index, 2006), getNearestDayOfWeek(SUNDAY, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(23, Month.APRIL.index, 2006), getNearestDayOfWeek(SUNDAY, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(23, Month.APRIL.index, 2006), getNearestDayOfWeek(SUNDAY, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(17, Month.APRIL.index, 2006), getNearestDayOfWeek(MONDAY, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(17, Month.APRIL.index, 2006), getNearestDayOfWeek(MONDAY, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(17, Month.APRIL.index, 2006), getNearestDayOfWeek(MONDAY, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(17, Month.APRIL.index, 2006), getNearestDayOfWeek(MONDAY, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(17, Month.APRIL.index, 2006), getNearestDayOfWeek(MONDAY, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(24, Month.APRIL.index, 2006), getNearestDayOfWeek(MONDAY, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(24, Month.APRIL.index, 2006), getNearestDayOfWeek(MONDAY, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(18, Month.APRIL.index, 2006), getNearestDayOfWeek(TUESDAY, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006), getNearestDayOfWeek(TUESDAY, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006), getNearestDayOfWeek(TUESDAY, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006), getNearestDayOfWeek(TUESDAY, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006), getNearestDayOfWeek(TUESDAY, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(18, Month.APRIL.index, 2006), getNearestDayOfWeek(TUESDAY, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(25, Month.APRIL.index, 2006), getNearestDayOfWeek(TUESDAY, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(19, Month.APRIL.index, 2006), getNearestDayOfWeek(WEDNESDAY, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006), getNearestDayOfWeek(WEDNESDAY, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006), getNearestDayOfWeek(WEDNESDAY, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006), getNearestDayOfWeek(WEDNESDAY, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006), getNearestDayOfWeek(WEDNESDAY, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006), getNearestDayOfWeek(WEDNESDAY, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(19, Month.APRIL.index, 2006), getNearestDayOfWeek(WEDNESDAY, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(13, Month.APRIL.index, 2006), getNearestDayOfWeek(THURSDAY, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006), getNearestDayOfWeek(THURSDAY, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006), getNearestDayOfWeek(THURSDAY, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006), getNearestDayOfWeek(THURSDAY, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006), getNearestDayOfWeek(THURSDAY, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006), getNearestDayOfWeek(THURSDAY, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(20, Month.APRIL.index, 2006), getNearestDayOfWeek(THURSDAY, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(14, Month.APRIL.index, 2006), getNearestDayOfWeek(FRIDAY, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(14, Month.APRIL.index, 2006), getNearestDayOfWeek(FRIDAY, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006), getNearestDayOfWeek(FRIDAY, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006), getNearestDayOfWeek(FRIDAY, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006), getNearestDayOfWeek(FRIDAY, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006), getNearestDayOfWeek(FRIDAY, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(21, Month.APRIL.index, 2006), getNearestDayOfWeek(FRIDAY, d(22, Month.APRIL.index, 2006)));

		assertEquals(d(15, Month.APRIL.index, 2006), getNearestDayOfWeek(SATURDAY, d(16, Month.APRIL.index, 2006)));
		assertEquals(d(15, Month.APRIL.index, 2006), getNearestDayOfWeek(SATURDAY, d(17, Month.APRIL.index, 2006)));
		assertEquals(d(15, Month.APRIL.index, 2006), getNearestDayOfWeek(SATURDAY, d(18, Month.APRIL.index, 2006)));
		assertEquals(d(22, Month.APRIL.index, 2006), getNearestDayOfWeek(SATURDAY, d(19, Month.APRIL.index, 2006)));
		assertEquals(d(22, Month.APRIL.index, 2006), getNearestDayOfWeek(SATURDAY, d(20, Month.APRIL.index, 2006)));
		assertEquals(d(22, Month.APRIL.index, 2006), getNearestDayOfWeek(SATURDAY, d(21, Month.APRIL.index, 2006)));
		assertEquals(d(22, Month.APRIL.index, 2006), getNearestDayOfWeek(SATURDAY, d(22, Month.APRIL.index, 2006)));

		try {
			getNearestDayOfWeek(-1, d(1, Month.JANUARY.index, 2006));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testEndOfCurrentMonth() throws Exception {
		DayDate d = DayDate.createInstance(2);
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
		assertEquals("First", weekInMonthToString(FIRST_WEEK_IN_MONTH));
		assertEquals("Second", weekInMonthToString(SECOND_WEEK_IN_MONTH));
		assertEquals("Third", weekInMonthToString(THIRD_WEEK_IN_MONTH));
		assertEquals("Fourth", weekInMonthToString(FOURTH_WEEK_IN_MONTH));
		assertEquals("Last", weekInMonthToString(LAST_WEEK_IN_MONTH));

		try {
			weekInMonthToString(-1);
			fail("Invalid week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testRelativeToString() throws Exception {
		assertEquals("Preceding", relativeToString(PRECEDING));
		assertEquals("Nearest", relativeToString(NEAREST));
		assertEquals("Following", relativeToString(FOLLOWING));

		try {
			relativeToString(-1000);
			fail("Invalid relative code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testCreateInstanceFromDDMMYYY() throws Exception {
		DayDate date = createInstance(1, Month.JANUARY.index, 1900);
		assertEquals(1, date.getDayOfMonth());
		assertEquals(Month.JANUARY.index, date.getMonth());
		assertEquals(1900, date.getYYYY());
		assertEquals(2, date.toSerial());
	}

	public void testCreateInstanceFromSerial() throws Exception {
		assertEquals(d(1, Month.JANUARY.index, 1900), createInstance(2));
		assertEquals(d(1, Month.JANUARY.index, 1901), createInstance(367));
	}

	public void testCreateInstanceFromJavaDate() throws Exception {
		assertEquals(d(1, Month.JANUARY.index, 1900), createInstance(new GregorianCalendar(1900, 0, 1).getTime()));
		assertEquals(d(1, Month.JANUARY.index, 2006), createInstance(new GregorianCalendar(2006, 0, 1).getTime()));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(BobsSerialDateTest.class);
	}
}