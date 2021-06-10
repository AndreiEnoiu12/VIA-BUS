package Trips;

import java.io.FileNotFoundException;
import java.io.IOException;

import Utils.FileIO;

/**
 * An adapter to the trips file, making it easy to retrieve and store information.
 */ 

public class TripFileAdapter {
	private FileIO fio = new FileIO();
	private final String FILE_NAME = "trips.bin";
	private final String FILE_LOCATION = "data/" + FILE_NAME;

	   /**
	    * Gets all the trips.
	    * @return a TripList object with all the stored trips
	    */
	
	public TripList getAllTrips() {
		TripList trips = new TripList();

		try {
			trips = (TripList) fio.readObjectFromFile(FILE_LOCATION);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}

		return trips;
	}

	/**
	    * Use the FileIO class to save some trips.
	    * @param trips the list of trips that will be saved
	    */
	
	public void saveTrips(TripList trips) {
		try {
			fio.writeToFile(FILE_LOCATION, trips);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error writing to file");
		}
	}
}
