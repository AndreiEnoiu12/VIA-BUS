package Drivers;

import java.io.Serializable;
import java.util.ArrayList;

import Drivers.Driver.EmploymentType;
import GUI.MessageDialog;

/**
 * A class containing a list of Driver objects.
 */ 

@SuppressWarnings("serial")
public class DriverList implements Serializable {
	private ArrayList<Driver> driverList = new ArrayList<Driver>();;

   /* Adds a Driver to the list.
    * @param driver the driver to add to the list
    */ 

	public void addDriver(Driver driver) {
		DriverList drivers = new DriverFileAdapter().getAllDrivers();

		if (isNameUsed(driver.getFirstName(), driver.getLastName(), drivers)) {
			
			
			
			MessageDialog.CreateWarningDialog("Error",
					"Driver with this name already exists");

			return;
		}

		if (isIdUsed(driver.getId(), driver, drivers)
				&& driver.getEmploymentType().equals(EmploymentType.FULL_TIME)) {
			MessageDialog.CreateWarningDialog("Error",
					"Driver with this ID already exists");
			
			return;
		}

		if (driver.getFirstName().isEmpty()
				|| driver.getLastName().isEmpty()
				|| driver.getAddress().isEmpty()
				|| driver.getEmail().isEmpty()
				|| driver.getPhoneNumber().isEmpty()
				|| (driver.getEmploymentType().equals(EmploymentType.FULL_TIME) && driver
						.getId().isEmpty())) {
			MessageDialog.CreateWarningDialog("Error", "All fields required");

			return;
		}

		try {
			Integer.parseInt(driver.getPhoneNumber());
		} catch (NumberFormatException e) {
			MessageDialog.CreateWarningDialog("Error",
					"Phone should be a number");

			return;
		}

		driverList.add(driver);
	}

   /**
   * Gets a Driver object from position index from the list. 
   * @param index the position in the list of the Driver object  
   */

	public Driver getDriverByIndex(int index) {
		return driverList.get(index);
	}

   /**
   * Sets a Driver in the list. 
   * @param index the position in the list of the Driver object  
   * @param driver the driver
   */

	public void setDriver(Driver driver, int index) {
		driverList.set(index, driver);
	}

   /**
   * Removed a Driver object from the list.  
   * @param driver the driver
   */

	public void removeDriver(Driver driver) {
		driverList.remove(driver);
	}

   /**
   * Removes a Driver object from position index from the list. 
   * @param index the position in the list of the Driver object  
   */

	public void removeDriverByIndex(int index) {
		driverList.remove(index);
	}

   /**
   * Gets the size of the Driver list. 
   * @return the size of the driver list 
   */

	public int getSize() {
		return driverList.size();
	}

   /**
   * Gets a Driver from Array
   * @return the list of drivers 
   */

	public Driver[] toArray() {
		Driver[] drivers = new Driver[getSize()];

		for (int i = 0; i < getSize(); i++) {
			drivers[i] = getDriverByIndex(i);
		}

		return drivers;
	}


	/**
    * Checks if the name is used.
    * @param firstName driver's first name
   * @param lastName driver's last name
    * @return true if the given object is equal to this driver
        * @return false if the given object is not equal to this driver
    */

	private boolean isNameUsed(String firtName, String lastName,
			DriverList drivers) {

		for (int i = 0; i < drivers.getSize(); i++)
			if (drivers.getDriverByIndex(i).getFirstName().equals(firtName)
					&& drivers.getDriverByIndex(i).getLastName()
							.equals(lastName))
				return true;

		return false;
	}


	/**
    * Checks if the id is used.
    * @param id driver's id
   * @param driver the driver
       * @param drivers the drivers list
    * @return true if the given object is equal to this driver
        * @return false if the given object is not equal to this driver
    */

	private boolean isIdUsed(String ID, Driver driver, DriverList drivers) {
		for (int i = 0; i < drivers.getSize(); i++)
			if (drivers.getDriverByIndex(i).getId().equals(ID))
				return true;

		return false;
	}


	/**
    * Compares the details of the driver list.
    * @param obj the object to compare with
    * @return true if the given object is equal to this driver list
    */

	public boolean equals(Object obj) {
		if (!(obj instanceof DriverList))
			return false;

		DriverList other = (DriverList) obj;

		for (int i = 0; i < driverList.size(); i++) {
			if (!(driverList.get(i).equals(other.getDriverByIndex(i))))
				return false;
		}
		
		return true;
	}
}
