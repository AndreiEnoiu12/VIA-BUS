package Passengers;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Passenger objects.
 */ 

@SuppressWarnings("serial")
public class PassengerList implements Serializable {
	private ArrayList<Passenger> passengers = new ArrayList<>();;
	private Customer customer;

  
	/**
    * Adds a Student to the list.
    * @param passenger the passenger to add to the list
    */ 

	public void addPassenger(Passenger passenger) {
			passengers.add(passenger);
	}
	public void setPassenger(Passenger passenger, int index)
	{
	   passengers.set(index, passenger);
	}

   /**
   * Gets a Passenger object from position index from the list. 
   * @param index the position in the list of the Passenger object  
   * @return the Passenger object at position index
   */

	public Passenger getPassengerByIndex(int index) {
		return passengers.get(index);
	}

   /**
    * Replaces the Customer object at index with customer.
    * @param customer the customer to replace with
    * @param index the position in the list that will be replaced
    */

	public void setCustomer(Customer customer) {
		this.customer = customer;
		passengers.add(customer);
	}

   /**
   * Removes a Passenger object from position index from the list. 
   * @param index the position in the list of the Passenger object  
   */

	public void removePassengerByIndex(int index) {
		passengers.remove(index);
	}


   /**
   * Gets a Customer object 
   * @return the Customer object
   */

	public Customer getCustomer() {
		return customer;
	}

   /**
    * Gets how many Passengers objects are in the list.
    * @return the number of Passengers objects in the list
    */

	public int getSize() {
		return passengers.size();
	}

	/**
    * Compares the details of the passenger.
    * @param obj the object to compare with
    * @return false if not instance of passenger list
    * @return true if the given object is equal to this passenger
    */
	

	public boolean equals(Object obj) {
		if (!(obj instanceof PassengerList))
			return false;

		PassengerList other = (PassengerList) obj;

		for (int i = 0; i < passengers.size(); i++) {
			if (!(passengers.get(i).equals(other.getPassengerByIndex(i))))
				return false;
		}
		return true;
	}
}
