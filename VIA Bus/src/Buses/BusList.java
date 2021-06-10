package Buses;

import java.io.Serializable;
import java.util.ArrayList;

import GUI.MessageDialog;

/**
 * A class containing a list of Bus objects.
 */ 

@SuppressWarnings("serial")
public class BusList implements Serializable {
	private ArrayList<Bus> busList = new ArrayList<>();

	/** Adds a Bus to the list.
	    * @param bus the driver to add to the list
	    */ 
	
	public void addBus(Bus bus) {
		BusList buses = new BusFileAdapter().getAllBuses();

		if (isNameUsed(bus.getName(), buses)) {
			MessageDialog.CreateWarningDialog("Error", "Bus with this name already exists");


			return;
		}

		if (bus.getName().isEmpty() || bus.getNumberOfSeats().isEmpty()) {
			MessageDialog.CreateWarningDialog("Error", "All fields are required");


			return;
		}

		try {
			Integer.parseInt(bus.getNumberOfSeats());
		} catch (NumberFormatException e) {
			MessageDialog.CreateWarningDialog("Error", "Number of seats should be a numbr");


			return;
		}

		busList.add(bus);
	}

	 /**
	   * Gets a Bus object from position index from the list. 
	   * @param index the position in the list of the Driver object  
	   */
	
	public Bus getBusByIndex(int index) {
		return busList.get(index);
	}

	/**
	   * Sets a Bus in the list. 
	   * @param index the position in the list of the Driver object  
	   * @param bus the bus
	   */
	
	public void setBus(Bus bus, int index) {
		BusList busses = new BusFileAdapter().getAllBuses();

		if (isNameUsed(bus.getName(), busses) && isTheSame(index, bus, busses)) {
			MessageDialog.CreateWarningDialog("Error", "Bus with this name already exists");


			return;
		}

		if (bus.getName().isEmpty() || bus.getNumberOfSeats().isEmpty()) {
			MessageDialog.CreateWarningDialog("Error", "All fields are required");

			return;
		}

		try {
			Integer.parseInt(bus.getNumberOfSeats());
		} catch (NumberFormatException e) {
			MessageDialog.CreateWarningDialog("Error", "Number of seats should be a number");

			return;
		}

		busList.set(index, bus);
	}
	
	/**
	   * Removed a Bus object from the list.  
	   * @param bus the bus
	   */

	public void removeBus(Bus bus) {
		busList.remove(bus);
	}
	
	 /**
	   * Removes a Bus object from position index from the list. 
	   * @param index the position in the list of the Bus  object  
	   */

	public void removeBusByIndex(int index) {
		busList.remove(index);
	}

	/**
	   * Gets the size of the Bus list. 
	   * @return the size of the bus list 
	   */
	
	public int getSize() {
		return busList.size();
	}

	/**
	    * Checks if the name is used.
	    * @param name bus's name
	    * @return true if the given object is equal to this bus
	        * @return false if the given object is not equal to this driver
	    */
	
	private boolean isNameUsed(String name, BusList busses) {
		for (int i = 0; i < busses.getSize(); i++)
			if (busses.getBusByIndex(i).getName().equals(name))
				return true;

		return false;
	}

	/**
	    * Checks if Bus exists in a Bus list.
	    * @param index index in list
	    * @param bus the Bus object
	    * @param busses the Bus list
	    * @return true if the given object is equal to this bus
	        * @return false if the given object is not equal to this driver
	    */
	
	private boolean isTheSame(int index, Bus bus, BusList busses) {
		return bus.getName().equals(busses.getBusByIndex(index));
	}
	
	 /**
	   * Returns a Bus Array.
	   * @return busses using index
	   */
	
	public Bus[] toArray() {
		  Bus[] buses = new Bus[getSize()];

		  for (int i = 0; i < getSize(); i++) {
		   buses[i] = getBusByIndex(i);
		  }

		  return buses;
		 }
}
