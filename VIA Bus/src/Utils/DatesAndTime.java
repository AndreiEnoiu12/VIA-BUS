package Utils;

import java.util.Calendar;
public class DatesAndTime {
	public static Integer[] days() {
		Integer[] days = new Integer[31];
		
		for (int i = 0; i < 31; i++) {
			days[i] = i + 1;
		}
		
		return days;
	}

	public static Integer[] months() {
		Integer[] months = new Integer[12];
		
		for (int i = 0; i < 12; i++) {
			months[i] = i + 1;
		}
		
		return months;
	}

	public static Integer[] years() {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		Integer[] years = new Integer[20];
		
		for (int i = 0; i < years.length; i++) {
			years[i] = currentYear + i;
		}

		return years;
	}

	public static Integer[] hours() {
		Integer[] hours = new Integer[24];
		
		for (int i = 0; i < hours.length; i++) {
			hours[i] = i + 1;
		}

		return hours;

	}

	public static Integer[] minutes() {
		Integer[] minutes = new Integer[12];

		for (int i = 0; i < minutes.length; i++) {
			minutes[i] = (i + 1) * 5;
		}

		return minutes;
	}
}