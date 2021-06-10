package Reservations;

import java.io.FileNotFoundException;
import java.io.IOException;
import Utils.FileIO;


/**
 * An adapter to the reservations file, making it easy to retrieve and store information.
 */ 

public class ReservationFileAdapter {
	private FileIO fio = new FileIO();
	private final String FILE_NAME = "reservations.bin";
	private final String FILE_LOCATION = "data/" + FILE_NAME;

   /**
    * Uses the FileIO class to retrieve a ReservationList object with all Students.
    * @return a ReservationList object with all stored reservations
    */

	public ReservationList getAllReservations() {
		ReservationList reservations = new ReservationList();

		try {
			reservations = (ReservationList) fio
					.readObjectFromFile(FILE_LOCATION);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}

		return reservations;
	}

   /**
    * Use the FileIO class to save some reservations.
    * @param reservations the list of reservations that will be saved
    */

	public void saveReservations(ReservationList reservations) {
		try {
			fio.writeToFile(FILE_LOCATION, reservations);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error writing to file");
		}
	}
}
