package Reservations;

import java.io.Serializable;
import java.util.ArrayList;

import GUI.MessageDialog;

/**
 * A class containing a list of Reservations objects.
 */ 

@SuppressWarnings("serial")
public class ReservationList implements Serializable {
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();;

	/**
    * Adds a Reservation to the list.
    * @param reservation the reservation to add to the list
    */ 

	public void addReservation(Reservation reservation) {
		ReservationList reservations = new ReservationFileAdapter()
				.getAllReservations();
		if (reservation.getPassengers().getCustomer().getFirstName().isEmpty()
				|| reservation.getPassengers().getCustomer().getLastName()
						.isEmpty()
				|| reservation.getPassengers().getCustomer()
						.getStringBirthday().isEmpty()
				|| reservation.getPassengers().getCustomer().getEmail()
						.isEmpty()
				|| reservation.getPassengers().getCustomer().getAddress()
						.isEmpty()
				|| reservation.getPassengers().getCustomer().getPhoneNumber()
						.isEmpty()) {
			MessageDialog.CreateWarningDialog("Error", "All fields required");

			return;
		}

		if (isNameUsed(
				reservation.getPassengers().getCustomer().getFirstName(),
				reservation.getPassengers().getCustomer().getLastName(),
				reservation.getTrip().getName(), reservations)) {
			MessageDialog.CreateWarningDialog("Error",
					"Reservation with this name already exists");

			return;
		}

		try {
			Integer.parseInt(reservation.getPassengers().getCustomer()
					.getPhoneNumber());
		} catch (NumberFormatException e) {
			MessageDialog.CreateWarningDialog("Error",
					"Phone should be a number");

			return;
		}

		reservationList.add(reservation);
	}

   /**
   * Gets a Reservation object from position index from the list. 
   * @param index the position in the list of the Reservation object  
   * @return the Reservation object at position index 
  */
	public Reservation getReservationByIndex(int index) {
		return reservationList.get(index);
	}

  /**
    * Replaces the Reservation object at index with reservation.
    * @param reservation the reservation to replace with
    * @param index the position in the list that will be replaced
    */

	public void setDriver(Reservation reservation, int index) {
		reservationList.set(index, reservation);
	}

	/**
    * Removes a Reservation from the list.
    * @param reservation the reservation to add to the list
    */ 

	public void removeReservation(Reservation reservation) {
		reservationList.remove(reservation);
	}


	/**
    * Removes a Reservation from the list using an index.
    * @param index the position in the list that will be replaced
    */

	public void removeReservationByIndex(int index) {
		reservationList.remove(index);
	}

 /**
    * Gets how many Reservation objects are in the list.
    * @return the number of Reservation objects in the list
    */

	public int getSize() {
		return reservationList.size();
	}

  /**
    * Replaces the Reservation object at index with reservation.
    * @param reservation the reservation to replace with
    * @param index the position in the list that will be replaced
    */

	public void setReservation(Reservation reservation, int index) {
		reservationList.set(index, reservation);
	}

  /**
    * Checks if the reservation name is used.
    * @param firstName reservation's first name
    * @param lastName reservation's last name
    * @return true if the given object is equal to this reservation
    * @return false if the given object is not equal to this reservation
    */

	private boolean isNameUsed(String firstName, String lastName,
			String tripName, ReservationList reservationList) {

		for (int i = 0; i < reservationList.getSize(); i++)
			if (reservationList.getReservationByIndex(i).getPassengers()
					.getCustomer().getFirstName().equals(firstName)
					&& reservationList.getReservationByIndex(i).getPassengers()
							.getCustomer().getLastName().equals(lastName)
					&& reservationList.getReservationByIndex(i).getTrip()
							.getName().equals(tripName))
				return true;

		return false;
	}
	
	 /**
	   * Returns a Reservation Array.
	   * @return reservations using index
	   */

		public Reservation[] toArray() {
			Reservation[] reservations = new Reservation[getSize()];

			for (int i = 0; i < getSize(); i++) {
				reservations[i] = getReservationByIndex(i);
			}

			return reservations;
		}

}
