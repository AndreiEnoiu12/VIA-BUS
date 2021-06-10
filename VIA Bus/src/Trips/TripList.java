package Trips;

import java.io.Serializable;
import java.util.ArrayList;
import GUI.MessageDialog;

/**
 * A class containing a list of Trip objects.
 */ 

@SuppressWarnings("serial")
public class TripList implements Serializable {
	private ArrayList<Trip> tripList = new ArrayList<>();;

	/**
    * Adds a trip to the list.
    * @param trip the trip to add to the list
    */ 


	public void addTrips(Trip trip) {
		TripList trips = new TripFileAdapter().getAllTrips();

		if (isNameUsed(trip.getName(), trips)) {
			MessageDialog.CreateWarningDialog("Error",
					"Trip or Travel with this name already exist!");

			return;
		}

		if (trip.getName().isEmpty() || trip.getStartLocation().isEmpty()
				|| trip.getEndLocation().isEmpty()
				|| trip.getTripDate().getDuration().isEmpty()) {
			MessageDialog.CreateWarningDialog("Error",
					"All fields are required!");

			return;
		}

		try {
			Integer.parseInt(trip.getTripDate().getDuration());
		} catch (NumberFormatException e) {
			MessageDialog.CreateWarningDialog("Warning",
					"Trip duration should be a number");

			return;
		}

		tripList.add(trip);
	}

   /**
   * Gets a Trip object from position index from the list. 
   * @param index the position in the list of the Trip object  
   * @return the Trip object at position index 
  */

	public Trip getTripByIndex(int index) {
		return tripList.get(index);
	}

  /**
    * Replaces the Trip object at index with trip.
    * @param trip the trip to replace with
    * @param index the position in the list that will be replaced
    */

	public void setTrip(Trip trip, int index) {
		TripList trips = new TripFileAdapter().getAllTrips();

		if (isNameUsed(trip.getName(), trips) && isTheSame(index, trip, trips)) {
			MessageDialog.CreateWarningDialog("Error",
					"Trip with this name already exists");

			return;
		}

		if (trip.getName().isEmpty() || trip.getStartLocation().isEmpty()
				|| trip.getEndLocation().isEmpty()
				|| trip.getTripDate().getDuration().isEmpty()) {
			MessageDialog.CreateWarningDialog("Error",
					"All fields are required");

			return;
		}

		try {
			Integer.parseInt(trip.getTripDate().getDuration());
		} catch (NumberFormatException e) {
			MessageDialog.CreateWarningDialog("Warning",
					"Trip duration should be a number");

			return;
		}

		tripList.set(index, trip);
	}

	/**
    * Removes a Trip from the list.
    * @param trip the trip to add to the list
    */ 

	public void removeTrip(Trip trip) {
		tripList.remove(trip);
	}

	/**
    * Removes a Trip from the list using an index.
    * @param index the position in the list that will be replaced
    */


	public void removeTripByIndex(int index) {
		tripList.remove(index);
	}

 /**
    * Gets how many Trip objects are in the list.
    * @return the number of Trip objects in the list
    */

	public int getSize() {
		return tripList.size();
	}

/**
   * Returns a Trip Array.
   * @return trips using index
   */

	public Trip[] toArray() {
		Trip[] trips = new Trip[getSize()];

		for (int i = 0; i < getSize(); i++) {
			trips[i] = getTripByIndex(i);
		}

		return trips;
	}

/**
    * Checks if the trip name is used.
    * @param name trip's name
    * @param trips trip's trips
    * @return true if the given object is equal to this trip
    * @return false if the given object is not equal to this trip
    */


	private boolean isNameUsed(String name, TripList trips) {
		for (int i = 0; i < trips.getSize(); i++)
			if (trips.getTripByIndex(i).getName().equals(name))
				return true;

		return false;
	}

/**
    * Checks if the trip is the same.
    * @param trip trip's trip
    * @param trips trip's trips
    * @param index the position in the list that will be replaced
    * @return trip equal to the object from the list
    */

	private boolean isTheSame(int index, Trip trip, TripList trips) {
		return trip.getName().equals(trips.getTripByIndex(index));
	}
}
