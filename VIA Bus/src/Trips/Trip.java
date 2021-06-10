package Trips;

import java.io.Serializable;

import Buses.Bus;
import Drivers.Driver;

/**
 * A class representing a trip.
 */ 

@SuppressWarnings("serial")
public class Trip implements Serializable {
	private String name, startLocation, endLocation;
	private Driver driver;
	private Bus bus;
	private TripDate tripDate;
	private boolean busAndChaffeur = false;
	private String customStops;

   /**
    * Constructor initializing Trip.
    * @param startLocation trip start location
    * @param endLocation trip end location
    * @param tripDate trip date
    * @param driver trip driver
    * @param bus trip bus
    */

	public Trip(String name, String startLocation, String endLocation,
			TripDate tripDate, Driver driver, Bus bus) {
		setName(name);
		setStartLocation(startLocation);
		setEndLocation(endLocation);
		setDriver(driver);
		setBus(bus);
		setTripDate(tripDate);
	}

	/**
    * Gets the trip name.
    * @return the trip name
    */

	public String getName() {
		return name;
	}

	/**
    * Sets the trip name.
    * @param name what the trip name will be set to
    */

	public void setName(String name) {
		this.name = name;
	}

/**
    * Gets the trip start location.
    * @return the trip start location
    */

	public String getStartLocation() {
		return startLocation;
	}

/**
    * Sets the trip start location.
    * @param startLocation what the trip start location will be set to
    */

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

/**
    * Gets the trip end location.
    * @return the trip end location
    */

	public String getEndLocation() {
		return endLocation;
	}

/**
    * Sets the trip end location.
    * @param endLocation what the trip end location will be set to
    */

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	/**
    * Gets the trip's driver.
    * @return the trip's driver
    */

	public Driver getDriver() {
		return driver;
	}

/**
    * Sets the trip driver.
    * @param driver what the trip driver will be set to
    */

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	/**
    * Gets the trip's bus.
    * @return the trip's bus
    */

	public Bus getBus() {
		return bus;
	}

/**
    * Sets the trip bus.
    * @param bus what the trip bus will be set to
    */

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	/**
    * Gets the trip's date.
    * @return the trip's date
    */


	public TripDate getTripDate() {
		return tripDate;
	}


/**
    * Sets the trip date.
    * @param tripDate what the trip date will be set to
    */

	public void setTripDate(TripDate tripDate) {
		this.tripDate = tripDate;
	}

/**
    * Returns a string representation of the trip.
    * @return a string representation of the trip
    */

	public String toString() {
		return name;
	}

	/**
    * Compares the details of the trip.
    * @param obj the object to compare with
    * @return true if the given object is equal to this trip
    */

	public boolean equals(Object obj) {
		if (!(obj instanceof Trip))
			return false;

		Trip other = (Trip) obj;

		return name.equals(other.name)
				&& startLocation.equals(other.startLocation)
				&& endLocation.equals(other.endLocation)
				&& driver.equals(other.driver) && bus.equals(bus)
				&& tripDate.equals(tripDate);
	}

   public boolean isBusAndChaffeur()
   {
      return busAndChaffeur;
   }

   public void setBusAndChaffeur(boolean busAndChaffeur)
   {
      this.busAndChaffeur = busAndChaffeur;
   }

   public String getCustomStops()
   {
      return customStops;
   }

   public void setCustomStops(String customStops)
   {
      this.customStops = customStops;
   }

}
