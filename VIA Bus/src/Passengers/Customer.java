package Passengers;

import java.io.Serializable;

import Utils.CustomDate;

/**
 * A class representing a customer.
 */ 

@SuppressWarnings("serial")
public class Customer extends Passenger implements Serializable {
	private String email;
	private String phoneNumber;
	private int numberOfPassengers = 0;

   /**
    * Constructor initializing Customer.
    * @param firstName customer's first name
    * @param lastName customer's last name
    * @param adress customer's adress
    * @param birthday customer's birthday
    * @param email customer's email
    * @param numberOfPassnegers the number of passengers
    */

	public Customer(String firstName, String lastName, String address,
			CustomDate birthday, String email, String phoneNumber,
			int numberOfPassengers) {
		super(firstName, lastName, address, birthday);
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.numberOfPassengers = numberOfPassengers;
	}

	/**
    * Gets the customer's email.
    * @return the customer's email
    */

	public String getEmail() {
		return email;
	}

	/**
    * Sets the customer's email.
    * @param email what the customer's email will be set to
    */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
    * Gets the customer's phone number.
    * @return the customer's phone number
    */

	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
    * Sets the customer's phone number
    * @param phoneNumber what the customer's phone number will be set to
    */

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
    * Gets the customer's number of passengers
    * @return the customer's number of passengers
    */


	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	/**
    * Sets the customer's number of passengers
    * @param numberOfPassengers what the customer's number of passengers will be set to
    */

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

/**
    * Returns a string representation of the customer.
    * @return a string representation of the customer
    */

	public String toString() {
		return super.toString();
	}


	/**
    * Compares the details of the customer.
    * @param obj the object to compare with
    * @return true if the given object is equal to this customer
    */

	public boolean equals(Object obj) {
		if (!(obj instanceof Customer))
			return false;

		Customer other = (Customer) obj;
		
		return getFirstName().equals(other.getFirstName())
				&& getLastName().equals(other.getLastName())
				&& getAddress().equals(other.getAddress())
				&& getBirthday().equals(other.getBirthday())
				&& email.equals(other.email)
				&& phoneNumber.equals(other.phoneNumber)
				&& numberOfPassengers == other.numberOfPassengers;
	}
}
