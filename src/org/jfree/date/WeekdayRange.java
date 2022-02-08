package org.jfree.date;

public enum WeekdayRange {
	LAST(-1), NEXT(0), NEAREST(1);

	public int index;

	WeekdayRange(int index) {
		this.index = index;
	}
}
