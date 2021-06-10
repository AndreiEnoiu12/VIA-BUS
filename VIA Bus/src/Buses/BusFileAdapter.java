package Buses;

import java.io.FileNotFoundException;
import java.io.IOException;
import Utils.FileIO;

public class BusFileAdapter {
	private FileIO fio = new FileIO();
	private final String FILE_NAME = "buses.bin";
	private final String FILE_LOCATION = "data/" + FILE_NAME;

	public BusList getAllBuses() {
		BusList buses = new BusList();

		try {
			buses = (BusList) fio.readObjectFromFile(FILE_LOCATION);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}

		return buses;
	}

	public void saveBuses(BusList buses) {
		try {
			fio.writeToFile(FILE_LOCATION, buses);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error writing to file");
		}
	}
}
