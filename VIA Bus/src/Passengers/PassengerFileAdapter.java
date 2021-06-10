package Passengers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import Utils.FileIO;

/**
 * An adapter to the passengers file, making it easy to retrieve and store information.
 */ 

@SuppressWarnings("serial")
public class PassengerFileAdapter implements Serializable {
	private FileIO fio = new FileIO();
	private final String FILE_NAME = "passengers.bin";
	private final String FILE_LOCATION = "data/" + FILE_NAME;

   /**
    * Uses the FileIO class to retrieve a PassengerList object with all passengers.
    * @return a PassengerList object with all stored passengers
    */

	public PassengerList getAllPassengers() {
		PassengerList passengers = new PassengerList();

		try {
			passengers = (PassengerList) fio.readObjectFromFile(FILE_LOCATION);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}

		return passengers;
	}

/**
    * Use the FileIO class to save some passengers.
    * @param passengers the list of passengers that will be saved
    */

	public void savePassengers(PassengerList passengers) {
		try {
			fio.writeToFile(FILE_LOCATION, passengers);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error writing to file");
		}
	}
}