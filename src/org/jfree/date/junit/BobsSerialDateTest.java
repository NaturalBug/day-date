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
		assertEquals("January", Month.JANUARY.toString());
		assertEquals("February", Month.FEBRUARY.toString());
		assertEquals("March", Month.MARCH.toString());
		assertEquals("April", Month.APRIL.toString());
		assertEquals("May", Month.MAY.toString());
		assertEquals("June", Month.JUNE.toString());
		assertEquals("July", Month.JULY.toString());
		assertEquals("August", Month.AUGUST.toString());
		assertEquals("September", Month.SEPTEMBER.toString());
		assertEquals("October", Month.OCTOBER.toString());
		assertEquals("November", Month.NOVEMBER.toString());
		assertEquals("December", Month.DECEMBER.toString());

		assertEquals("Jan", Month.JANUARY.toShortString());
		assertEquals("Feb", Month.FEBRUARY.toShortString());
		assertEquals("Mar", Month.MARCH.toShortString());
		assertEquals("Apr", Month.APRIL.toShortString());
		assertEquals("May", Month.MAY.toShortString());
		assertEquals("Jun", Month.JUNE.toShortString());
		assertEquals("Jul", Month.JULY.toShortString());
		assertEquals("Aug", Month.AUGUST.toShortString());
		assertEquals("Sep", Month.SEPTEMBER.toShortString());
		assertEquals("Oct", Month.OCTOBER.toShortString());
		assertEquals("Nov", Month.NOVEMBER.toShortString());
		assertEquals("Dec", Month.DECEMBER.toShortString());
	}

	public void testStringToMonthCode() throws Exception {
		assertEquals(Month.JANUARY.index, Month.parse("1").index);
		assertEquals(Month.FEBRUARY.index, Month.parse("2").index);
		assertEquals(Month.MARCH.index, Month.parse("3").index);
		assertEquals(Month.APRIL.index, Month.parse("4").index);
		assertEquals(Month.MAY.index, Month.parse("5").index);
		assertEquals(Month.JUNE.index, Month.parse("6").index);
		assertEquals(Month.JULY.index, Month.parse("7").index);
		assertEquals(Month.AUGUST.index, Month.parse("8").index);
		assertEquals(Month.SEPTEMBER.index, Month.parse("9").index);
		assertEquals(Month.OCTOBER.index, Month.parse("10").index);
		assertEquals(Month.NOVEMBER.index, Month.parse("11").index);
		assertEquals(Month.DECEMBER.index, Month.parse("12").index);

		try {
			Month.parse("0");
			Month.parse("13");
			Month.parse("Hello");
			fail("Invalid day of month string should throw exception");
		} catch (IllegalArgumentException e) {
		}

		for (int m = 1; m <= 12; m++) {
			assertEquals(m, Month.parse(Month.fromInt(m).toString()).index);
			assertEquals(m, Month.parse(Month.fromInt(m).toShortString()).index);
		}

		assertEquals(1, Month.parse("jan").index);
		assertEquals(2, Month.parse("feb").index);
		assertEquals(3, Month.parse("mar").index);
		assertEquals(4, Month.parse("apr").index);
		assertEquals(5, Month.parse("may").index);
		assertEquals(6, Month.parse("jun").index);
		assertEquals(7, Month.parse("jul").index);
		assertEquals(8, Month.parse("aug").index);
		assertEquals(9, Month.parse("sep").index);
		assertEquals(10, Month.parse("oct").index);
		assertEquals(11, Month.parse("nov").index);
		assertEquals(12, Month.parse("dec").index);

		assertEquals(1, Month.parse("JAN").index);
		assertEquals(2, Month.parse("FEB").index);
		assertEquals(3, Month.parse("MAR").index);
		assertEquals(4, Month.parse("APR").index);
		assertEquals(5, Month.parse("MAY").index);
		assertEquals(6, Month.parse("JUN").index);
		assertEquals(7, Month.parse("JUL").index);
		assertEquals(8, Month.parse("AUG").index);
		assertEquals(9, Month.parse("SEP").index);
		assertEquals(10, Month.parse("OCT").index);
		assertEquals(11, Month.parse("NOV").index);
		assertEquals(12, Month.parse("DEC").index);

		assertEquals(1, Month.parse("january").index);
		assertEquals(2, Month.parse("february").index);
		assertEquals(3, Month.parse("march").index);
		assertEquals(4, Month.parse("april").index);
		assertEquals(5, Month.parse("may").index);
		assertEquals(6, Month.parse("june").index);
		assertEquals(7, Month.parse("july").index);
		assertEquals(8, Month.parse("august").index);
		assertEquals(9, Month.parse("september").index);
		assertEquals(10, Month.parse("october").index);
		assertEquals(11, Month.parse("november").index);
		assertEquals(12, Month.parse("december").index);

		assertEquals(1, Month.parse("JANUARY").index);
		assertEquals(2, Month.parse("FEBRUARY").index);
		assertEquals(3, Month.parse("MAR").index);
		assertEquals(4, Month.parse("APRIL").index);
		assertEquals(5, Month.parse("MAY").index);
		assertEquals(6, Month.parse("JUNE").index);
		assertEquals(7, Month.parse("JULY").index);
		assertEquals(8, Month.parse("AUGUST").index);
		assertEquals(9, Month.parse("SEPTEMBER").index);
		assertEquals(10, Month.parse("OCTOBER").index);
		assertEquals(11, Month.parse("NOVEMBER").index);
		assertEquals(12, Month.parse("DECEMBER").index);
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
		assertEquals(31, lastDayOfMonth(Month.JANUARY, 1901));
		assertEquals(28, lastDayOfMonth(Month.FEBRUARY, 1901));
		assertEquals(31, lastDayOfMonth(Month.MARCH, 1901));
		assertEquals(30, lastDayOfMonth(Month.APRIL, 1901));
		assertEquals(31, lastDayOfMonth(Month.MAY, 1901));
		assertEquals(30, lastDayOfMonth(Month.JUNE, 1901));
		assertEquals(31, lastDayOfMonth(Month.JULY, 1901));
		assertEquals(31, lastDayOfMonth(Month.AUGUST, 1901));
		assertEquals(30, lastDayOfMonth(Month.SEPTEMBER, 1901));
		assertEquals(31, lastDayOfMonth(Month.OCTOBER, 1901));
		assertEquals(30, lastDayOfMonth(Month.NOVEMBER, 1901));
		assertEquals(31, lastDayOfMonth(Month.DECEMBER, 1901));
		assertEquals(29, lastDayOfMonth(Month.FEBRUARY, 1904));
	}

	public void testAddDays() throws Exception {
		DayDate newYears = d(1, Month.JANUARY.index, 1900);
		assertEquals(d(2, Month.JANUARY.index, 1900), newYears.plusDays(1));
		assertEquals(d(1, Month.FEBRUARY.index, 1900), newYears.plusDays(31));
		assertEquals(d(1, Month.JANUARY.index, 1901), newYears.plusDays(365));
		assertEquals(d(31, Month.DECEMBER.index, 1904), newYears.plusDays(5 * 365));
	}

	private static SpreadsheetDate d(int day, int month, int year) {
		return new SpreadsheetDate(day, month, year);
	}

	public void testAddMonths() throws Exception {
		assertEquals(d(1, Month.FEBRUARY.index, 1900), DayDateFactory.makeDate(1, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, Month.FEBRUARY.index, 1900), DayDateFactory.makeDate(31, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, Month.FEBRUARY.index, 1900), DayDateFactory.makeDate(30, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, Month.FEBRUARY.index, 1900), DayDateFactory.makeDate(29, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, Month.FEBRUARY.index, 1900), DayDateFactory.makeDate(28, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(27, Month.FEBRUARY.index, 1900), DayDateFactory.makeDate(27, Month.JANUARY, 1900).plusMonths(1));

		assertEquals(d(30, Month.JUNE.index, 1900), DayDateFactory.makeDate(31, Month.JANUARY, 1900).plusMonths(5));
		assertEquals(d(30, Month.JUNE.index, 1901), DayDateFactory.makeDate(31, Month.JANUARY, 1900).plusMonths(17));

		assertEquals(d(29, Month.FEBRUARY.index, 1904),
				DayDateFactory.makeDate(31, Month.JANUARY, 1900).plusMonths(49));

	}

	public void testAddYears() throws Exception {
		assertEquals(d(1, Month.JANUARY.index, 1901), DayDateFactory.makeDate(1, Month.JANUARY, 1900).plusYears(1));
		assertEquals(d(28, Month.FEBRUARY.index, 1905), DayDateFactory.makeDate(29, Month.FEBRUARY, 1904).plusYears(1));
		assertEquals(d(28, Month.FEBRUARY.index, 1905), DayDateFactory.makeDate(28, Month.FEBRUARY, 1904).plusYears(1));
		assertEquals(d(28, Month.FEBRUARY.index, 1904), DayDateFactory.makeDate(28, Month.FEBRUARY, 1903).plusYears(1));
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
		assertEquals(1900, date.getYear());
		assertEquals(2, date.toOrdinal());
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