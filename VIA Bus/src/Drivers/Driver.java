package Drivers;

import java.io.Serializable;

import Buses.Bus.BusType;

/**
 * A class representing a driver.
 */ 

@SuppressWarnings("serial")
public class Driver implements Serializable {
	private String firstName;
	private String lastName;
	private String id;
	private String address;
	private String email;
	private String phoneNumber;
	private String preferences;

	private BusType prefferedbusType;

/**
    * Sets enum to spring, summer, fall, winter.
    */ 

	public enum PrefferedSeason {
		SPRING, SUMMER, FALL, WINTER
	}

    /**
    * Sets enum to full time, extra.
    */ 

	public enum EmploymentType {
		FULL_TIME, EXTRA
	};

	private PrefferedSeason prefferedSeason;
	private EmploymentType employmentType;
	private boolean available;

   /**
    * Constructor initializing Driver.
    * @param firstName driver's first name
    * @param lastName driver's last name
    * @param adress driver's adress
    * @param email driver's email
    * @param phoneNumber driver's phoneNumber
    * @param EmploymentType driver's EmploymentType
    * @param employmentType driver's employmentType
    */

	public Driver(String firstName, String lastName, String address,
			String email, String phoneNumber, EmploymentType employmentType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.employmentType = employmentType;
		this.available = true;
	}

   /**
    * Constructor initializing Driver.
    * @param firstName driver's first name
    * @param lastName driver's last name
    * @param adress driver's adress
    * @param email driver's email
    * @param phoneNumber driver's phoneNumber
    * @param EmploymentType driver's EmploymentType
    * @param employmentType driver's employmentType
    * @param id driver's id
    */
	
	public Driver(String firstName, String lastName, String address,
			String email, String phoneNumber, EmploymentType employmentType,
			String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.employmentType = employmentType;
		this.available = true;
		this.id = id;
	}

	/**
    * Sets the prefered season and bus
    * @param prefferedSeason the preffered season
    * @param prefferedTypeOfBus the preffered bus
    */

	public void setPrefferences(PrefferedSeason prefferedSeason,
			BusType prefferedTypeOfBus) {
		this.prefferedSeason = prefferedSeason;
		this.prefferedbusType = prefferedTypeOfBus;
	}

	/**
    * Gets the driver's first name.
    * @return the driver's first name
    */

	public String getFirstName() {
		return firstName;
	}

	/**
    * Sets the driver's first name.
    * @param firstName what the driver's first name will be set to
    */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
    * Gets the driver's last name.
    * @return the driver's last name
    */

	public String getLastName() {
		return lastName;
	}

	/**
    * Sets the driver's last name.
    * @param lastName what the driver's last name will be set to
    */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
    * Gets the driver's ID.
    * @return the driver's ID
    */

	public String getId() {
		return id;
	}

	/**
    * Sets the driver's ID.
    * @param id what the driver's id will be set to
    */

	public void setId(String id) {
		this.id = id;
	}


	/**
    * Gets the driver's address.
    * @return the driver's address
    */

	public String getAddress() {
		return address;
	}

/**
    * Sets the driver's address.
    * @param adress what the driver's address will be set to
    */

	public void setAddress(String address) {
		this.address = address;
	}

	/**
    * Gets the driver's email.
    * @return the driver's email
    */

	public String getEmail() {
		return email;
	}

/**
    * Sets the driver's email.
    * @param email what the driver's email will be set to
    */


	public void setEmail(String email) {
		this.email = email;
	}

	/**
    * Gets the driver's phone number.
    * @return the driver's phone number
    */

	public String getPhoneNumber() {
		return phoneNumber;
	}

/**
    * Sets the driver's phone number.
    * @param phoneNumber what the driver's phone number will be set to
    */

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
    * Gets the driver's preffered bus.
    * @return the driver's preffered bus
    */

	public BusType getPrefferedbusType() {
		return prefferedbusType;
	}


/**
    * Sets the driver's preffered bus.
    * @param prefferedbusType what the driver's preffered bus will be
    */

	public void setPrefferedbusType(BusType prefferedbusType) {
		this.prefferedbusType = prefferedbusType;
	}

	/**
    * Gets the driver's preffered season.
    * @return the driver's preffered season
    */

	public PrefferedSeason getPrefferedSeason() {
		return prefferedSeason;
	}


/**
    * Sets the driver's preffered season
    * @param prefferedSeason what the driver's preffered season will be
    */

	public void setPrefferedSeason(PrefferedSeason prefferedSeason) {
		this.prefferedSeason = prefferedSeason;
	}

	/**
    * Gets the driver's employment type.
    * @return the driver's employment type
    */

	public EmploymentType getEmploymentType() {
		return employmentType;
	}


/**
    * Sets the driver's employment type
    * @param employmentType what the driver's employment type
    */

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

/**
    * Sets the driver's availability
    * @param available what the driver's avability is
    */


	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
    * Compares the available variable with true
    * @return true if the given available is equal
      * @return false if the given available is not equal
    */

	public boolean isAvailable() {
		if (available == true)
			return true;
		else
			return false;
	}

	/**
    * Returns a string representation of the driver.
    * @return a string representation of the driver
    */
	
	public String toString() {
		return firstName + " " + lastName + " [" + id + "] " ;
	}

	/**
    * Compares the details of the driver.
    * @param obj the object to compare with
    * @return true if the given object is equal to this driver
    */
	
	public boolean equals(Object obj)
	{
	   if(!(obj instanceof Driver)) return false;
	   
	   Driver other = (Driver) obj;
	   
	   return firstName.equals(other.firstName) && lastName.equals(other.lastName) && id.equals(other.id) && address.equals(other.address)
	         && email.equals(other.email) && phoneNumber.equals(other.phoneNumber);
	   
	}

   public String getPreferences()
   {
      return preferences;
   }

   public void setPreferences(String preferences)
   {
      this.preferences = preferences;
   }
}
