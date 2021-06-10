package Drivers;

import java.io.FileNotFoundException;
import java.io.IOException;

import Utils.FileIO;

/**
 * An adapter to the drivers file, making it easy to retrieve and store information.
 */ 

public class DriverFileAdapter {
	private FileIO fio = new FileIO();
	private final String FILE_NAME = "drivers.bin";
	private final String FILE_LOCATION = "data/" + FILE_NAME;


   /**
    * Gets all the drivers.
    * @return a DriverList object with all the stored drivers
    */

	public DriverList getAllDrivers() {
		DriverList drivers = new DriverList();

		try {
			drivers = (DriverList) fio.readObjectFromFile(FILE_LOCATION);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}

		return drivers;
	}

   /**
    * Use the FileIO class to save some drivers.
    * @param drivers the list of drivers that will be saved
    */

	public void saveDrivers(DriverList drivers) {
		try {
			fio.writeToFile(FILE_LOCATION, drivers);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error writing to file");
		}
	}
}