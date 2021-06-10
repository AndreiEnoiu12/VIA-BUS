package Reservations;

import java.io.Serializable;

import GUI.MessageDialog;
import Passengers.Passenger;
import Passengers.PassengerList;
import Trips.Trip;

/**
 * A class representing a reservation.
 */ 

@SuppressWarnings("serial")
public class Reservation implements Serializable {
	private PassengerList passengers;
	private Trip trip;


   /**
    * Constructor initializing Reservation.
    * @param trip is the trip
    * @param passengers are the passengers
    */

	public Reservation(Trip trip, PassengerList passengers) {
		setTrip(trip);
		setPassengers(passengers);
	}

	/**
    * Gets the reservation trip.
    * @return the reservation trip
    */

	public Trip getTrip() {
		return trip;
	}

	/**
    * Sets the reservation trip.
    * @param trip what the reservation trip will be set to
    */

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	/**
    * Gets the passengers.
    * @return the passengers
    */

	public PassengerList getPassengers() {
		return passengers;
	}

	/**
    * Sets the passengers.
    * @param passengers what the passengers will be set to
    */

	public void setPassengers(PassengerList passengers) {
		this.passengers = passengers;
	}
	
	public void addPassenger(Passenger passenger)
	{
	     if(passenger.getFirstName().isEmpty() || passenger.getLastName().isEmpty() || passenger.getAddress().isEmpty())
	      {
	         MessageDialog.CreateWarningDialog("Error", "All fields required");
	      }
	     else if(isOnTheList(passenger))
	     {
	        MessageDialog.CreateWarningDialog("Error", "This passenger is already on the list");
	     }
	   passengers.addPassenger(passenger);
	}
	public void setPassenger(Passenger passenger, int index)
	{
	   if(passenger.getFirstName().isEmpty() || passenger.getLastName().isEmpty() || passenger.getAddress().isEmpty())
	   {
	      MessageDialog.CreateWarningDialog("Error", "All fields required");
	   }
	   passengers.setPassenger(passenger, index);
	}
	public void removePassengerByIndex(int index)
	{
	   passengers.removePassengerByIndex(index);
	}
	public int getPassengersSize()
	{
	   return passengers.getSize();
	}

/**
    * Returns a string representation of the reservation.
    * @return a string representation of the reservation
    * @return null if the trip and name are null
    */

	public String toString() {
		if (getTrip().getName() == null
				|| getPassengers().getCustomer().getFirstName() == null
				|| getPassengers().getCustomer().getLastName() == null)
			return null;
		else
			return getPassengers().getCustomer().getFirstName() + " "
					+ getPassengers().getCustomer().getLastName() + " ("
					+ getTrip().getName() + ") ";
	}

	/**
    * Compares the details of the reservation.
    * @param obj the object to compare with
    * @return true if the given object is equal to this reservation
    */

	public boolean equals(Object obj) {
		if (!(obj instanceof Reservation))
			return false;

		Reservation other = (Reservation) obj;

		return trip.equals(other.trip) && passengers.equals(other.passengers) && passengers.getCustomer().getFirstName().equals(other.passengers.getCustomer().getFirstName())
		      && passengers.getCustomer().getLastName().equals(other.passengers.getCustomer().getLastName())
		      && passengers.getCustomer().getBirthday().equals(other.passengers.getCustomer().getBirthday());
	}
	  private boolean isOnTheList(Passenger passenger) {

	      for (int i = 0; i < passengers.getSize(); i++)
	         if (passengers.getPassengerByIndex(i).equals(passenger)) return true;

	      return false;
	   }
}