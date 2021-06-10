package Buses;

import java.io.Serializable;

/**
 * A class containing Buses.
 */ 

@SuppressWarnings("serial")
public class Bus implements Serializable {
	private String name;
	private String numberOfSeats;

/**
    * Sets enum for bus.
    */ 

	public enum BusType {
		NORMAL, LUXURY, PARTY, MINI
	};

	private BusType busType;

   /**
    * Constructor initializing Bus.
    * @param name bus's first name
    * @param numberOfSeats bus's number of seats
    * @param busType bus's type
    */

	public Bus(String name, String numberOfSeats, BusType busType) {
		setName(name);
		setNumberOfSeats(numberOfSeats);
		setBusType(busType);
	}

	/**
    * Gets the bus's name.
    * @return the bus's name
    */

	public String getName() {
		return name;
	}

	/**
    * Sets the bus's name.
    * @param name what the bus's first name will be set to
    */

	public void setName(String name) {
		this.name = name;
	}

	/**
    * Gets the bus's seats number.
    * @return the bus's number of seats
    */

	public String getNumberOfSeats() {
		return numberOfSeats;
	}


	/**
    * Sets the bus's number of seats.
    * @param numberOfSeats bus's number of seats
    */

	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

/**
    * Gets the bus's type.
    * @return the bus's type
    */

	public BusType getBusType() {
		return busType;
	}


	/**
    * Sets the bus's type.
    * @param busType bus's type
    */

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	/**
    * Returns a string representation of the bus.
    * @return a string representation of the bus
    */

	public String toString() {
		return name;
	}

	/**
    * Compares the details of the bus.
    * @param obj the object to compare with
    * @return true if the given object is equal to this bus
    */

	public boolean equals(Object obj) {
		if (!(obj instanceof Bus))
			return false;

		Bus other = (Bus) obj;

		return name.equals(other.name)
				&& numberOfSeats.equals(other.numberOfSeats)
				&& busType.equals(other.busType);
	}

}
