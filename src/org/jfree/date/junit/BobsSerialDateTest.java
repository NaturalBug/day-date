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
		assertEquals(Day.MONDAY.toInt(), Day.parse("Monday").toInt());
		assertEquals(Day.MONDAY.toInt(), Day.parse("Mon").toInt());
		assertEquals(Day.MONDAY.toInt(), Day.parse("monday").toInt());
		assertEquals(Day.MONDAY.toInt(), Day.parse("MONDAY").toInt());
		assertEquals(Day.MONDAY.toInt(), Day.parse("mon").toInt());

		assertEquals(Day.TUESDAY.toInt(), Day.parse("Tuesday").toInt());
		assertEquals(Day.TUESDAY.toInt(), Day.parse("Tue").toInt());
		assertEquals(Day.TUESDAY.toInt(), Day.parse("tuesday").toInt());
		assertEquals(Day.TUESDAY.toInt(), Day.parse("TUESDAY").toInt());
		assertEquals(Day.TUESDAY.toInt(), Day.parse("tue").toInt());
		// assertEquals(TUESDAY, stringToWeekdayCode("tues"));

		assertEquals(Day.WEDNESDAY.toInt(), Day.parse("Wednesday").toInt());
		assertEquals(Day.WEDNESDAY.toInt(), Day.parse("Wed").toInt());
		assertEquals(Day.WEDNESDAY.toInt(), Day.parse("wednesday").toInt());
		assertEquals(Day.WEDNESDAY.toInt(), Day.parse("WEDNESDAY").toInt());
		assertEquals(Day.WEDNESDAY.toInt(), Day.parse("wed").toInt());

		assertEquals(Day.THURSDAY.toInt(), Day.parse("Thursday").toInt());
		assertEquals(Day.THURSDAY.toInt(), Day.parse("Thu").toInt());
		assertEquals(Day.THURSDAY.toInt(), Day.parse("thursday").toInt());
		assertEquals(Day.THURSDAY.toInt(), Day.parse("THURSDAY").toInt());
		assertEquals(Day.THURSDAY.toInt(), Day.parse("thu").toInt());
		// assertEquals(THURSDAY, stringToWeekdayCode("thurs"));

		assertEquals(Day.FRIDAY.toInt(), Day.parse("Friday").toInt());
		assertEquals(Day.FRIDAY.toInt(), Day.parse("Fri").toInt());
		assertEquals(Day.FRIDAY.toInt(), Day.parse("friday").toInt());
		assertEquals(Day.FRIDAY.toInt(), Day.parse("FRIDAY").toInt());
		assertEquals(Day.FRIDAY.toInt(), Day.parse("fri").toInt());

		assertEquals(Day.SATURDAY.toInt(), Day.parse("Saturday").toInt());
		assertEquals(Day.SATURDAY.toInt(), Day.parse("Sat").toInt());
		assertEquals(Day.SATURDAY.toInt(), Day.parse("saturday").toInt());
		assertEquals(Day.SATURDAY.toInt(), Day.parse("SATURDAY").toInt());
		assertEquals(Day.SATURDAY.toInt(), Day.parse("sat").toInt());

		assertEquals(Day.SUNDAY.toInt(), Day.parse("Sunday").toInt());
		assertEquals(Day.SUNDAY.toInt(), Day.parse("Sun").toInt());
		assertEquals(Day.SUNDAY.toInt(), Day.parse("sunday").toInt());
		assertEquals(Day.SUNDAY.toInt(), Day.parse("SUNDAY").toInt());
		assertEquals(Day.SUNDAY.toInt(), Day.parse("sun").toInt());
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
		assertEquals(Month.JANUARY.toInt(), Month.parse("1").toInt());
		assertEquals(Month.FEBRUARY.toInt(), Month.parse("2").toInt());
		assertEquals(Month.MARCH.toInt(), Month.parse("3").toInt());
		assertEquals(Month.APRIL.toInt(), Month.parse("4").toInt());
		assertEquals(Month.MAY.toInt(), Month.parse("5").toInt());
		assertEquals(Month.JUNE.toInt(), Month.parse("6").toInt());
		assertEquals(Month.JULY.toInt(), Month.parse("7").toInt());
		assertEquals(Month.AUGUST.toInt(), Month.parse("8").toInt());
		assertEquals(Month.SEPTEMBER.toInt(), Month.parse("9").toInt());
		assertEquals(Month.OCTOBER.toInt(), Month.parse("10").toInt());
		assertEquals(Month.NOVEMBER.toInt(), Month.parse("11").toInt());
		assertEquals(Month.DECEMBER.toInt(), Month.parse("12").toInt());

		try {
			Month.parse("0");
			Month.parse("13");
			Month.parse("Hello");
			fail("Invalid day of month string should throw exception");
		} catch (IllegalArgumentException e) {
		}

		for (int m = 1; m <= 12; m++) {
			assertEquals(m, Month.parse(Month.fromInt(m).toString()).toInt());
			assertEquals(m, Month.parse(Month.fromInt(m).toShortString()).toInt());
		}

		assertEquals(1, Month.parse("jan").toInt());
		assertEquals(2, Month.parse("feb").toInt());
		assertEquals(3, Month.parse("mar").toInt());
		assertEquals(4, Month.parse("apr").toInt());
		assertEquals(5, Month.parse("may").toInt());
		assertEquals(6, Month.parse("jun").toInt());
		assertEquals(7, Month.parse("jul").toInt());
		assertEquals(8, Month.parse("aug").toInt());
		assertEquals(9, Month.parse("sep").toInt());
		assertEquals(10, Month.parse("oct").toInt());
		assertEquals(11, Month.parse("nov").toInt());
		assertEquals(12, Month.parse("dec").toInt());

		assertEquals(1, Month.parse("JAN").toInt());
		assertEquals(2, Month.parse("FEB").toInt());
		assertEquals(3, Month.parse("MAR").toInt());
		assertEquals(4, Month.parse("APR").toInt());
		assertEquals(5, Month.parse("MAY").toInt());
		assertEquals(6, Month.parse("JUN").toInt());
		assertEquals(7, Month.parse("JUL").toInt());
		assertEquals(8, Month.parse("AUG").toInt());
		assertEquals(9, Month.parse("SEP").toInt());
		assertEquals(10, Month.parse("OCT").toInt());
		assertEquals(11, Month.parse("NOV").toInt());
		assertEquals(12, Month.parse("DEC").toInt());

		assertEquals(1, Month.parse("january").toInt());
		assertEquals(2, Month.parse("february").toInt());
		assertEquals(3, Month.parse("march").toInt());
		assertEquals(4, Month.parse("april").toInt());
		assertEquals(5, Month.parse("may").toInt());
		assertEquals(6, Month.parse("june").toInt());
		assertEquals(7, Month.parse("july").toInt());
		assertEquals(8, Month.parse("august").toInt());
		assertEquals(9, Month.parse("september").toInt());
		assertEquals(10, Month.parse("october").toInt());
		assertEquals(11, Month.parse("november").toInt());
		assertEquals(12, Month.parse("december").toInt());

		assertEquals(1, Month.parse("JANUARY").toInt());
		assertEquals(2, Month.parse("FEBRUARY").toInt());
		assertEquals(3, Month.parse("MAR").toInt());
		assertEquals(4, Month.parse("APRIL").toInt());
		assertEquals(5, Month.parse("MAY").toInt());
		assertEquals(6, Month.parse("JUNE").toInt());
		assertEquals(7, Month.parse("JULY").toInt());
		assertEquals(8, Month.parse("AUGUST").toInt());
		assertEquals(9, Month.parse("SEPTEMBER").toInt());
		assertEquals(10, Month.parse("OCTOBER").toInt());
		assertEquals(11, Month.parse("NOVEMBER").toInt());
		assertEquals(12, Month.parse("DECEMBER").toInt());
	}

	public void testIsLeapYear() throws Exception {
		assertFalse(DateUtil.isLeapYear(1900));
		assertFalse(DateUtil.isLeapYear(1901));
		assertFalse(DateUtil.isLeapYear(1902));
		assertFalse(DateUtil.isLeapYear(1903));
		assertTrue(DateUtil.isLeapYear(1904));
		assertTrue(DateUtil.isLeapYear(1908));
		assertFalse(DateUtil.isLeapYear(1955));
		assertTrue(DateUtil.isLeapYear(1964));
		assertTrue(DateUtil.isLeapYear(1980));
		assertTrue(DateUtil.isLeapYear(2000));
		assertFalse(DateUtil.isLeapYear(2001));
		assertFalse(DateUtil.isLeapYear(2100));
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
		assertEquals(31, DateUtil.lastDayOfMonth(Month.JANUARY, 1901));
		assertEquals(28, DateUtil.lastDayOfMonth(Month.FEBRUARY, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.MARCH, 1901));
		assertEquals(30, DateUtil.lastDayOfMonth(Month.APRIL, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.MAY, 1901));
		assertEquals(30, DateUtil.lastDayOfMonth(Month.JUNE, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.JULY, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.AUGUST, 1901));
		assertEquals(30, DateUtil.lastDayOfMonth(Month.SEPTEMBER, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.OCTOBER, 1901));
		assertEquals(30, DateUtil.lastDayOfMonth(Month.NOVEMBER, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.DECEMBER, 1901));
		assertEquals(29, DateUtil.lastDayOfMonth(Month.FEBRUARY, 1904));
	}

	public void testAddDays() throws Exception {
		DayDate newYears = d(1, Month.JANUARY.toInt(), 1900);
		assertEquals(d(2, Month.JANUARY.toInt(), 1900), newYears.plusDays(1));
		assertEquals(d(1, Month.FEBRUARY.toInt(), 1900), newYears.plusDays(31));
		assertEquals(d(1, Month.JANUARY.toInt(), 1901), newYears.plusDays(365));
		assertEquals(d(31, Month.DECEMBER.toInt(), 1904), newYears.plusDays(5 * 365));
	}

	private static SpreadsheetDate d(int day, int month, int year) {
		return new SpreadsheetDate(day, month, year);
	}

	public void testAddMonths() throws Exception {
		assertEquals(d(1, Month.FEBRUARY.toInt(), 1900), DayDateFactory.makeDate(1, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, Month.FEBRUARY.toInt(), 1900),
				DayDateFactory.makeDate(31, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, Month.FEBRUARY.toInt(), 1900),
				DayDateFactory.makeDate(30, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, Month.FEBRUARY.toInt(), 1900),
				DayDateFactory.makeDate(29, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, Month.FEBRUARY.toInt(), 1900),
				DayDateFactory.makeDate(28, Month.JANUARY, 1900).plusMonths(1));
		assertEquals(d(27, Month.FEBRUARY.toInt(), 1900),
				DayDateFactory.makeDate(27, Month.JANUARY, 1900).plusMonths(1));

		assertEquals(d(30, Month.JUNE.toInt(), 1900), DayDateFactory.makeDate(31, Month.JANUARY, 1900).plusMonths(5));
		assertEquals(d(30, Month.JUNE.toInt(), 1901), DayDateFactory.makeDate(31, Month.JANUARY, 1900).plusMonths(17));

		assertEquals(d(29, Month.FEBRUARY.toInt(), 1904),
				DayDateFactory.makeDate(31, Month.JANUARY, 1900).plusMonths(49));

	}

	public void testAddYears() throws Exception {
		assertEquals(d(1, Month.JANUARY.toInt(), 1901), DayDateFactory.makeDate(1, Month.JANUARY, 1900).plusYears(1));
		assertEquals(d(28, Month.FEBRUARY.toInt(), 1905),
				DayDateFactory.makeDate(29, Month.FEBRUARY, 1904).plusYears(1));
		assertEquals(d(28, Month.FEBRUARY.toInt(), 1905),
				DayDateFactory.makeDate(28, Month.FEBRUARY, 1904).plusYears(1));
		assertEquals(d(28, Month.FEBRUARY.toInt(), 1904),
				DayDateFactory.makeDate(28, Month.FEBRUARY, 1903).plusYears(1));
	}

	public void testGetPreviousDayOfWeek() throws Exception {
		assertEquals(d(24, Month.FEBRUARY.toInt(), 2006),
				DayDateFactory.makeDate(1, Month.MARCH, 2006).getPreviousDayOfWeek(Day.FRIDAY));
		assertEquals(d(22, Month.FEBRUARY.toInt(), 2006),
				DayDateFactory.makeDate(1, Month.MARCH, 2006).getPreviousDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(29, Month.FEBRUARY.toInt(), 2004),
				DayDateFactory.makeDate(3, Month.MARCH, 2004).getPreviousDayOfWeek(Day.SUNDAY));
		assertEquals(d(29, Month.DECEMBER.toInt(), 2004),
				DayDateFactory.makeDate(5, Month.JANUARY, 2005).getPreviousDayOfWeek(Day.WEDNESDAY));
	}

	public void testGetFollowingDayOfWeek() throws Exception {
		assertEquals(d(1, Month.JANUARY.toInt(), 2005),
				DayDateFactory.makeDate(25, Month.DECEMBER, 2004).getFollowingDayOfWeek(Day.SATURDAY));
		assertEquals(d(1, Month.JANUARY.toInt(), 2005),
				DayDateFactory.makeDate(26, Month.DECEMBER, 2004).getFollowingDayOfWeek(Day.SATURDAY));
		assertEquals(d(3, Month.MARCH.toInt(), 2004),
				DayDateFactory.makeDate(28, Month.FEBRUARY, 2004).getFollowingDayOfWeek(Day.WEDNESDAY));
	}

	public void testGetNearestDayOfWeek() throws Exception {
		assertEquals(d(16, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(16, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(16, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(16, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(23, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(23, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(23, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));

		assertEquals(d(17, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(17, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(17, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(17, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(17, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(24, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(24, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));

		assertEquals(d(18, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(18, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(18, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(18, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(18, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(18, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(25, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));

		assertEquals(d(19, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));

		assertEquals(d(13, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
		assertEquals(d(20, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
		assertEquals(d(20, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
		assertEquals(d(20, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
		assertEquals(d(20, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
		assertEquals(d(20, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
		assertEquals(d(20, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));

		assertEquals(d(14, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
		assertEquals(d(14, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
		assertEquals(d(21, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
		assertEquals(d(21, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
		assertEquals(d(21, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
		assertEquals(d(21, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
		assertEquals(d(21, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));

		assertEquals(d(15, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
		assertEquals(d(15, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
		assertEquals(d(15, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
		assertEquals(d(22, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
		assertEquals(d(22, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
		assertEquals(d(22, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
		assertEquals(d(22, Month.APRIL.toInt(), 2006),
				DayDateFactory.makeDate(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
	}

	public void testEndOfCurrentMonth() throws Exception {
		DayDate d = DayDateFactory.makeDate(2);
		assertEquals(d(31, Month.JANUARY.toInt(), 2006),
				DayDateFactory.makeDate(1, Month.JANUARY, 2006).getEndOfMonth());
		assertEquals(d(28, Month.FEBRUARY.toInt(), 2006),
				DayDateFactory.makeDate(1, Month.FEBRUARY, 2006).getEndOfMonth());
		assertEquals(d(31, Month.MARCH.toInt(), 2006), DayDateFactory.makeDate(1, Month.MARCH, 2006).getEndOfMonth());
		assertEquals(d(30, Month.APRIL.toInt(), 2006), DayDateFactory.makeDate(1, Month.APRIL, 2006).getEndOfMonth());
		assertEquals(d(31, Month.MAY.toInt(), 2006), DayDateFactory.makeDate(1, Month.MAY, 2006).getEndOfMonth());
		assertEquals(d(30, Month.JUNE.toInt(), 2006), DayDateFactory.makeDate(1, Month.JUNE, 2006).getEndOfMonth());
		assertEquals(d(31, Month.JULY.toInt(), 2006), DayDateFactory.makeDate(1, Month.JULY, 2006).getEndOfMonth());
		assertEquals(d(31, Month.AUGUST.toInt(), 2006), DayDateFactory.makeDate(1, Month.AUGUST, 2006).getEndOfMonth());
		assertEquals(d(30, Month.SEPTEMBER.toInt(), 2006),
				DayDateFactory.makeDate(1, Month.SEPTEMBER, 2006).getEndOfMonth());
		assertEquals(d(31, Month.OCTOBER.toInt(), 2006),
				DayDateFactory.makeDate(1, Month.OCTOBER, 2006).getEndOfMonth());
		assertEquals(d(30, Month.NOVEMBER.toInt(), 2006),
				DayDateFactory.makeDate(1, Month.NOVEMBER, 2006).getEndOfMonth());
		assertEquals(d(31, Month.DECEMBER.toInt(), 2006),
				DayDateFactory.makeDate(1, Month.DECEMBER, 2006).getEndOfMonth());
		assertEquals(d(29, Month.FEBRUARY.toInt(), 2008),
				DayDateFactory.makeDate(1, Month.FEBRUARY, 2008).getEndOfMonth());
	}

	public void testMakeDateFromDDMMYYY() throws Exception {
		DayDate date = DayDateFactory.makeDate(1, Month.JANUARY.toInt(), 1900);
		assertEquals(1, date.getDayOfMonth());
		assertEquals(Month.JANUARY.toInt(), date.getMonth());
		assertEquals(1900, date.getYear());
		assertEquals(2, date.getOrdinalDay());
	}

	public void testMakeDateFromOrdinal() throws Exception {
		assertEquals(d(1, Month.JANUARY.toInt(), 1900), DayDateFactory.makeDate(2));
		assertEquals(d(1, Month.JANUARY.toInt(), 1901), DayDateFactory.makeDate(367));
	}

	public void testMakeDateFromJavaDate() throws Exception {
		assertEquals(d(1, Month.JANUARY.toInt(), 1900),
				DayDateFactory.makeDate(new GregorianCalendar(1900, 1, 1).getTime()));
		assertEquals(d(1, Month.JANUARY.toInt(), 2006),
				DayDateFactory.makeDate(new GregorianCalendar(2006, 1, 1).getTime()));
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(BobsSerialDateTest.class);
	}
}