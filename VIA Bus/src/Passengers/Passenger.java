package Passengers;

import java.io.Serializable;

import Utils.CustomDate;

/**
 * A class representing a passenger.
 */ 

@SuppressWarnings("serial")
public class Passenger implements Serializable {
	private String firstName;
	private String lastName;
	private String address;
	private CustomDate birthday;

 /**
    * Constructor initializing Passenger.
    * @param firstName passenger's first name
    * @param lastName passenger's last name
    * @param adress passenger's address
    * @param birthday passenger's birthday
    */

	public Passenger(String firstName, String lastName, String address,
			CustomDate birthday) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setBirthday(birthday);
	}


	/**
    * Gets the passenger's first name.
    * @return the passenger's first name
    */

	public String getFirstName() {
		return firstName;
	}

	/**
    * Sets the passenger's first name.
    * @param firstName what the passenger's first name will be set to
    */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
    * Gets the passenger's last name.
    * @return the passenger's last name
    */

	public String getLastName() {
		return lastName;
	}

/**
    * Sets the passenger's last name.
    * @param lastName what the passenger's last name will be set to
    */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
    * Gets the passenger's address.
    * @return the passenger's address
    */

	public String getAddress() {
		return address;
	}

/**
    * Sets the passenger's address.
    * @param address what the passenger's address will be set to
    */

	public void setAddress(String address) {
		this.address = address;
	}

/**
    * Gets the passenger's birthday.
    * @return the passenger's birthday
    */

	public CustomDate getBirthday() {
		return birthday;
	}

/**
    * Sets the passenger's birthday.
    * @param birthday what the passenger's birthday will be set to
    */

	public void setBirthday(CustomDate birthday) {
		this.birthday = birthday;
	}

/**
    * Gets the passenger's birthday string.
    * @return the passenger's birthday string
    */

	public String getStringBirthday() {
		return birthday.toString();
	}

	/**
    * Returns a string representation of the passenger.
    * @return a string representation of the passenger
    */
	
	public String toString() {
		return firstName + " " + lastName + " " + birthday;
	}

	/**
    * Compares the details of the passenger.
    * @param obj the object to compare with
    * @return true if the given object is equal to this passenger
    */
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Passenger))
			return false;

		Passenger other = (Passenger) obj;

		return firstName.equals(other.getFirstName()) && lastName.equals(other.getLastName())
				&& address.equals(other.getAddress())
				&& birthday.equals(other.getBirthday());
	}
}
