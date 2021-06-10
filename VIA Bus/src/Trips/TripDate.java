package Trips;

import java.io.Serializable;
import Utils.CustomDate;

/**
 * A class representing trip dates.
 */ 


@SuppressWarnings("serial")
public class TripDate implements Serializable {
	private CustomDate departureDate;
	private CustomDate returnDate;
	private String duration;

/**
    * Sets enum to hours, days.
    */ 

	public enum DurationType {
		HOURS, DAYS
	}

	private DurationType durationType;


   /**
    * Constructor initializing TripDate.
    * @param departureDate tripDate departure date
    * @param returnDate tripDate return date
    * @param duration tripDate duration
    * @param durationType tripDate durationType
    */


	public TripDate(CustomDate departureDate, CustomDate returnDate,
			String duration, DurationType durationType) {
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.duration = duration;
		this.durationType = durationType;
	}

	/**
    * Gets the tripDate departure date.
    * @return the tripDate departure date
    */

	public CustomDate getDepartureDate() {
		return departureDate;
	}

/**
    * Sets the tripDate departure date.
    * @param departureDate what the tripDate departure date will be set to
    */

	public void setDepartureDate(CustomDate departureDate) {
		this.departureDate = departureDate;
	}

	/**
    * Gets the tripDate return date.
    * @return the tripDate return date
    */

	public CustomDate getReturnDate() {
		return returnDate;
	}

/**
    * Sets the tripDate return date.
    * @param returnDate what the tripDate return date will be set to
    */

	public void setReturnDate(CustomDate returnDate) {
		this.returnDate = returnDate;
	}

/**
    * Gets the tripDate duration type.
    * @return the tripDate duration type
    */

	public DurationType getDurationType() {
		return durationType;
	}

/**
    * Sets the tripDate duration type.
    * @param durationType what the tripDate duration type will be set to
    */

	public void setDurationType(DurationType durationType) {
		this.durationType = durationType;
	}


/**
    * Gets the tripDate duration.
    * @return the tripDate duration 
    */

	public String getDuration() {
		return duration;
	}

/**
    * Sets the tripDate duration.
    * @param duration what the tripDate duration will be set to
    */

	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
    * Returns a string representation of the tripDate.
    * @return a string representation of the tripDate
    */

	public String toString() {
		String str = "";
		str += "Departure date: " + departureDate + "\n" + "Return date: "
				+ returnDate + "\n" + "Duration: " + duration + " "
				+ durationType;

		return str;
	}
}
