package Utils;

import java.io.Serializable;

/**
 * A class containing a list of CustomDate objects.
 */ 

@SuppressWarnings("serial")
public class CustomDate implements Serializable {
	private int day, month, year;
	private int hour = -1;
	private int minutes = -1;

   /**
    * Constructor initializing CustomDate.
    * @param day CustomDate's day
    * @param month CustomDate's month
    * @param year CustomDate's year
    */

	public CustomDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

  /**
    * Constructor initializing CustomDate.
    * @param day CustomDate's day
    * @param month CustomDate's month
    * @param year CustomDate's year
     * @param hour CustomDate's hour
  * @param minutes CustomDate's minutes
    */

	public CustomDate(int day, int month, int year, int hour, int minutes) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minutes = minutes;
	}

/**
    * Sets the CustomDate's date.
    * @param day CustomDate's day
    * @param month CustomDate's month
    * @param year CustomDate's year
    */

	public void setDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}


	/**
    * Gets the CustomDate's date.
    * @return the CustomDate's date
    */

	public String getDate() {
		return day + "/" + month + "/" + year;
	}

	/**
    * Gets the CustomDate's day.
    * @return the CustomDate's day
    */

	public int getDay() {
		return day;
	}


	/**
    * Sets the CustomDate's day
    * @param day what the CustomDate's date will be set to
    */

	public void setDay(int day) {
		this.day = day;
	}

	/**
    * Gets the CustomDate's month.
    * @return the CustomDate's month
    */

	public int getMonth() {
		return month;
	}

/**
    * Sets the CustomDate's month
    * @param month what the CustomDate's month will be set to
    */

	public void setMonth(int month) {
		this.month = month;
	}


	/**
    * Gets the CustomDate's year.
    * @return the CustomDate's year
    */

	public int getYear() {
		return year;
	}


/**
    * Sets the CustomDate's year
    * @param year what the CustomDate's year will be set to
    */

	public void setYear(int year) {
		this.year = year;
	}

/**
    * Returns a string representation of the CustomDate.
    * @return a string representation of the CustomDate
    */

	public String toString() {
		String str = "";
		
		if (day < 10)
			str += "0";
		
		str += day + "/";
		
		if (month < 10)
			str += "0";
		
		str += month + "/" + year + " ";
		
		if (hour >= 0) {
			if (hour < 10)
				str += "0";
			
			str += hour + ":";
			
			if (minutes < 10)
				str += "0";
			
			str += minutes;
		}

		return str;
	}

/**
    * Gets the CustomDate's hour.
    * @return the CustomDate's hour
    */

	public int getHour() {
		return hour;
	}

/**
    * Sets the CustomDate's hour.
    * @param hour what the CustomDate's hour will be set to
    */

	public void setHour(int hour) {
		this.hour = hour;
	}

/**
    * Gets the CustomDate's minutes.
    * @return the CustomDate's minutes
    */

	public int getMinutes() {
		return minutes;
	}


/**
    * Sets the CustomDate's minutes.
    * @param minutes what the CustomDate's minutes will be set to
    */

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
    * Compares the details of the CustomDate.
    * @param obj the object to compare with
    * @return true if the given object is equal to this CustomDate
    */

	public boolean equals(Object obj) {
		if (!(obj instanceof CustomDate))
			return false;

		CustomDate other = (CustomDate) obj;

		return day == other.day && month == other.month && year == other.year
				&& minutes == other.minutes && hour == other.hour;
	}

}
