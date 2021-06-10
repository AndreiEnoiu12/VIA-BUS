package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Buses.Bus;
import Buses.BusFileAdapter;
import Buses.BusList;
import Drivers.Driver;
import Drivers.DriverFileAdapter;
import Drivers.DriverList;
import Trips.Trip;
import Trips.TripDate;
import Trips.TripDate.DurationType;
import Trips.TripFileAdapter;
import Trips.TripList;
import Utils.CustomDate;

/**
 * A GUI panel containing components for displaying trips.
 */  

@SuppressWarnings("serial")
public class TripsGUI extends JPanel {
	private MyButtonListener buttonListener;
	private TripFileAdapter tripFileAdapter = new TripFileAdapter();
	private TripList tripList = new TripList();

	private JLabel tripName, tripStartingLocation, tripDestination,
			tripDeparture, tripDepartureTime, tripDuration, tripReturnDate,
			tripDriver, tripBus, hoursJLabel, minutesJLabel;

	private JTextField tripNameField, tripStartingLocationField,
			tripDestinationField, durationField;

	private JComboBox<Object> hoursBox;
	private JComboBox<Object> minutesBox;
	private JComboBox<Object> yearBox;
	private JComboBox<Object> monthBox;
	private JComboBox<Object> dayBox;
	private JComboBox<Integer> dayBox1;
	private JComboBox<Object> yearBox1;
	private JComboBox<Object> monthBox1;
	private JComboBox<Object> durationBox;

	private JComboBox<Driver> driverBox;
	private JComboBox<Bus> busBox;
	private JComboBox<Object> alltripsBox;

	private JButton addButton, removeButton, editButton, clearButton;
	private JCheckBox busAndChaffeurCheckBox;
	private JTextArea customStopsArea;

	private JPanel inputPanel;
	private JPanel buttonsJPanel;
	private JPanel alltrips;
	private JPanel datePanel;
	private JPanel timePanel;
	private JPanel datePanel1;
	private JPanel durationPanel;
	private JPanel customStopsJPanel;
   /**
    * Constructor initializing the GUI components
    */

	public TripsGUI() {
		buttonListener = new MyButtonListener();

		tripName = new JLabel("Name of the Trip:");
		tripName.setBounds(6, 20, 169, 23);

		tripNameField = new JTextField(20);
		tripNameField.setBounds(175, 20, 169, 23);

		tripStartingLocation = new JLabel("Starting Location:");
		tripStartingLocation.setBounds(6, 53, 169, 23);

		tripStartingLocationField = new JTextField(20);
		tripStartingLocationField.setBounds(175, 53, 169, 23);

		tripDestination = new JLabel("Destination:");
		tripDestination.setBounds(6, 86, 169, 23);

		tripDestinationField = new JTextField(20);
		tripDestinationField.setBounds(175, 86, 169, 23);

		tripDeparture = new JLabel("Departure date:");
		tripDeparture.setBounds(6, 119, 169, 23);

		datePanel = new JPanel();
		datePanel.setBounds(175, 110, 169, 32);

		dayBox = new JComboBox<Object>(DatesAndTime.days());
		monthBox = new JComboBox<Object>(DatesAndTime.months());
		yearBox = new JComboBox<Object>(DatesAndTime.years());
		datePanel.add(dayBox);
		datePanel.add(monthBox);
		datePanel.add(yearBox);

		tripDepartureTime = new JLabel("Departure Time:");
		tripDepartureTime.setBounds(6, 152, 169, 23);

		hoursBox = new JComboBox<Object>(DatesAndTime.hours());
		minutesBox = new JComboBox<Object>(DatesAndTime.minutes());
		hoursJLabel = new JLabel("hh");
		minutesJLabel = new JLabel("min");

		timePanel = new JPanel();
		timePanel.setBounds(175, 143, 169, 32);

		timePanel.add(hoursJLabel);
		timePanel.add(hoursBox);
		timePanel.add(minutesJLabel);
		timePanel.add(minutesBox);

		tripDuration = new JLabel("Duration:");
		tripDuration.setBounds(5, 185, 85, 25);
		durationBox = new JComboBox<Object>(DurationType.values());
		durationBox.setBounds(135, 7, 81, 23);
		durationField = new JTextField(20);
		durationField.setBounds(45, 7, 80, 23);
		durationPanel = new JPanel();
		durationPanel.setBounds(129, 173, 216, 32);
		durationPanel.setLayout(null);
		durationPanel.add(durationBox);
		durationPanel.add(durationField);

		tripReturnDate = new JLabel("Trip Return Date:");
		tripReturnDate.setBounds(6, 218, 169, 23);

		dayBox1 = new JComboBox<Integer>(DatesAndTime.days());
		monthBox1 = new JComboBox<Object>(DatesAndTime.months());
		yearBox1 = new JComboBox<Object>(DatesAndTime.years());

		datePanel1 = new JPanel();
		datePanel1.setBounds(175, 209, 169, 32);
		datePanel1.add(dayBox1);
		datePanel1.add(monthBox1);
		datePanel1.add(yearBox1);

		tripDriver = new JLabel("Driver:");
		tripDriver.setBounds(6, 251, 169, 23);
		driverBox = new JComboBox<Driver>();
		driverBox.setBounds(175, 251, 169, 23);

		tripBus = new JLabel("Bus:");
		tripBus.setBounds(6, 284, 169, 23);
		busBox = new JComboBox<Bus>();
		busBox.setBounds(175, 284, 169, 23);

		inputPanel = new JPanel();
		inputPanel.setSize(350, 350);
		inputPanel.setLocation(10, 10);
		inputPanel.setBorder(new TitledBorder("Trip Information"));
		inputPanel.setLayout(null);

		inputPanel.add(tripName);
		inputPanel.add(tripNameField);

		inputPanel.add(tripStartingLocation);
		inputPanel.add(tripStartingLocationField);

		inputPanel.add(tripDestination);
		inputPanel.add(tripDestinationField);

		inputPanel.add(tripDeparture);
		inputPanel.add(datePanel);

		inputPanel.add(tripDepartureTime);
		inputPanel.add(timePanel);

		inputPanel.add(tripDuration);
		inputPanel.add(durationPanel);

		inputPanel.add(tripReturnDate);
		inputPanel.add(datePanel1);

		inputPanel.add(tripDriver);
		inputPanel.add(driverBox);

		inputPanel.add(tripBus);
		inputPanel.add(busBox);

		addButton = new JButton("Add a Trip");
		addButton.addActionListener(buttonListener);
		removeButton = new JButton("Remove");
		removeButton.addActionListener(buttonListener);
		editButton = new JButton("Edit");
		editButton.addActionListener(buttonListener);

		buttonsJPanel = new JPanel();
		buttonsJPanel.setBounds(10, 360, 300, 70);
		buttonsJPanel.add(addButton);
		buttonsJPanel.add(editButton);
		
		busAndChaffeurCheckBox = new JCheckBox("bus and chaffeur");
		busAndChaffeurCheckBox.addActionListener(buttonListener);
		customStopsJPanel = new JPanel();
		customStopsJPanel.setBounds(365, 120, 350, 230);
		customStopsJPanel.add(busAndChaffeurCheckBox);
		
		customStopsArea = new JTextArea(10,30);
      customStopsJPanel.setBorder(new TitledBorder("Custom stops"));
      customStopsJPanel.add(customStopsArea);
      
		clearButton = new JButton("Clear");
		clearButton.addActionListener(buttonListener);
		clearButton.setBounds(785, 345, 90, 30);

		alltrips = new JPanel();
		alltrips.setBorder(new TitledBorder("All Trips"));
		alltrips.setBounds(365, 10, 510, 85);
		alltrips.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		alltripsBox = new JComboBox<Object>();
		alltripsBox.addActionListener(buttonListener);

		alltripsBox.setPreferredSize(new Dimension(500, 26));
		alltripsBox.setMaximumRowCount(10);

		removeButton = new JButton("Remove");
		removeButton.addActionListener(buttonListener);
		alltrips.add(alltripsBox);
		alltrips.add(removeButton);

		setLayout(null);
		add(inputPanel);
		add(buttonsJPanel);
		add(alltrips);
		add(clearButton);
		add(customStopsJPanel);
	}

  /**
    * Updates and clears all trips.
    */

	public final void init() {
		updateAllTrips();
		updateCheckBox();
		clearAllFields();
      
	}

  /**
    * Updates all trips.
    */

	public void updateCheckBox()
	{
      if(busAndChaffeurCheckBox.isSelected())
      {
         customStopsArea.setEditable(true);
      }
      if(!(busAndChaffeurCheckBox.isSelected()))
      {
         customStopsArea.setEditable(false);
         customStopsArea.setText(""); 
      }
	}
	private void updateAllTrips() {
	   int currentSelection = alltripsBox.getSelectedIndex();
	   int busCurrentSelection = busBox.getSelectedIndex();
		alltripsBox.removeAllItems();
		driverBox.removeAllItems();
		busBox.removeAllItems();

		tripList = tripFileAdapter.getAllTrips();
		DriverList driverList = new DriverFileAdapter().getAllDrivers();
		BusList busList = new BusFileAdapter().getAllBuses();

		for (int i = 0; i < tripList.getSize(); i++) {
			alltripsBox.addItem(tripList.getTripByIndex(i));
		}
		for (int i = 0; i < driverList.getSize(); i++) {
			driverBox.addItem(driverList.getDriverByIndex(i));
		}

		for (int i = 0; i < busList.getSize(); i++) {
			busBox.addItem(busList.getBusByIndex(i));
		}
      try{
      alltripsBox.setSelectedIndex(currentSelection);
      busBox.setSelectedIndex(busCurrentSelection);
      }
      catch(IllegalArgumentException e)
      {
      }
	}


  /**
    * Clears all trips.
    */

	public void clearAllFields() {
		tripNameField.setText("");
		tripStartingLocationField.setText("");
		tripDestinationField.setText("");
		durationField.setText("");
		dayBox.setSelectedIndex(0);
		monthBox.setSelectedIndex(0);
		yearBox.setSelectedIndex(0);
		hoursBox.setSelectedIndex(0);
		minutesBox.setSelectedIndex(0);
		dayBox1.setSelectedIndex(0);
		monthBox1.setSelectedIndex(0);
		yearBox1.setSelectedIndex(0);
		driverBox.setSelectedIndex(-1);
		busBox.setSelectedIndex(-1);
		alltripsBox.setSelectedIndex(-1);
		customStopsArea.setText("");
		busAndChaffeurCheckBox.setSelected(false);
		
	}

   /*
    * Inner action listener class 
    */

	private class MyButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		    if(busAndChaffeurCheckBox.isSelected())
		      {
		         customStopsArea.setEditable(true);
		      }
		      if(!(busAndChaffeurCheckBox.isSelected()))
		      {
		         customStopsArea.setEditable(false);
		         customStopsArea.setText(""); 
		      }
			if (e.getSource() == alltripsBox) {
				if (alltripsBox.getSelectedItem() instanceof Trip
						&& alltripsBox.getSelectedIndex() > -1) {
					Trip tempTrip = (Trip) alltripsBox.getSelectedItem();
					tripNameField.setText(tempTrip.getName());
					tripDestinationField.setText(tempTrip.getEndLocation());
					tripStartingLocationField.setText(tempTrip
							.getStartLocation());
					dayBox.setSelectedItem(tempTrip.getTripDate()
							.getDepartureDate().getDay());
					dayBox1.setSelectedItem(tempTrip.getTripDate()
							.getReturnDate().getDay());
					monthBox.setSelectedItem(tempTrip.getTripDate()
							.getDepartureDate().getMonth());
					monthBox1.setSelectedItem(tempTrip.getTripDate()
							.getReturnDate().getMonth());
					yearBox.setSelectedItem(tempTrip.getTripDate()
							.getDepartureDate().getYear());
					yearBox1.setSelectedItem(tempTrip.getTripDate()
							.getReturnDate().getYear());
					hoursBox.setSelectedItem(tempTrip.getTripDate()
							.getDepartureDate().getHour());
					minutesBox.setSelectedItem(tempTrip.getTripDate()
							.getDepartureDate().getMinutes());
					durationField.setText(tempTrip.getTripDate().getDuration());
					durationBox.setSelectedItem(tempTrip.getTripDate()
							.getDurationType());
					driverBox.setSelectedItem(tempTrip.getDriver());
					busBox.setSelectedItem(tempTrip.getBus());
					customStopsArea.setText(tempTrip.getCustomStops());
					if(tempTrip.isBusAndChaffeur()) busAndChaffeurCheckBox.setSelected(true);
					else busAndChaffeurCheckBox.setSelected(false);
				}
			}

			if (e.getSource() == addButton) {
				CustomDate departureDate = new CustomDate(
						Integer.parseInt(dayBox.getSelectedItem().toString().trim()),
						Integer.parseInt(monthBox.getSelectedItem().toString().trim()),
						Integer.parseInt(yearBox.getSelectedItem().toString().trim()),
						Integer.parseInt(hoursBox.getSelectedItem().toString().trim()),
						Integer.parseInt(minutesBox.getSelectedItem()
								.toString()));
				CustomDate returnDate = new CustomDate(
						Integer.parseInt(dayBox1.getSelectedItem().toString().trim()),
						Integer.parseInt(monthBox1.getSelectedItem().toString().trim()),
						Integer.parseInt(yearBox1.getSelectedItem().toString().trim()));
				TripDate tripDate = new TripDate(departureDate, returnDate,
						durationField.getText().trim(),
						(DurationType) durationBox.getSelectedItem());
				Driver driver = (Driver) driverBox.getSelectedItem();
				Bus bus = (Bus) busBox.getSelectedItem();
				Trip trip = new Trip(tripNameField.getText().trim(),
						tripStartingLocationField.getText().trim(),
						tripDestinationField.getText().trim(), tripDate, driver, bus);
				if(busAndChaffeurCheckBox.isSelected())
				{
				   trip.setBusAndChaffeur(true);
				   trip.setCustomStops(customStopsArea.getText());
				}
				if(!(busAndChaffeurCheckBox.isSelected()))
				{
				   trip.setBusAndChaffeur(false);
               trip.setCustomStops("");
				}
				tripList = tripFileAdapter.getAllTrips();
				tripList.addTrips(trip);
				
				tripFileAdapter.saveTrips(tripList);

			     updateAllTrips();
			     updateCheckBox();
			}

			if (e.getSource() == editButton) {
				int currentSelection = alltripsBox.getSelectedIndex();
				if (currentSelection == -1)
					currentSelection = 0;

				CustomDate departureDate = new CustomDate(
						Integer.parseInt(dayBox.getSelectedItem().toString().trim()),
						Integer.parseInt(monthBox.getSelectedItem().toString().trim()),
						Integer.parseInt(yearBox.getSelectedItem().toString().trim()),
						Integer.parseInt(hoursBox.getSelectedItem().toString().trim()),
						Integer.parseInt(minutesBox.getSelectedItem()
								.toString()));
				CustomDate returnDate = new CustomDate(
						Integer.parseInt(dayBox1.getSelectedItem().toString().trim()),
						Integer.parseInt(monthBox1.getSelectedItem().toString().trim()),
						Integer.parseInt(yearBox1.getSelectedItem().toString().trim()));
				TripDate tripDate = new TripDate(departureDate, returnDate,
						durationField.getText().trim(),
						(DurationType) durationBox.getSelectedItem());
				
				Driver driver = (Driver) driverBox.getSelectedItem();
				Bus bus = (Bus) busBox.getSelectedItem();

				tripList = tripFileAdapter.getAllTrips();
				Trip trip = new Trip(tripNameField.getText().trim(),
						tripStartingLocationField.getText().trim(),
						tripDestinationField.getText().trim(), tripDate, driver, bus);
				if(busAndChaffeurCheckBox.isSelected())
            {
               trip.setBusAndChaffeur(true);
               trip.setCustomStops(customStopsArea.getText());
            }
            if(!(busAndChaffeurCheckBox.isSelected()))
            {
               trip.setBusAndChaffeur(false);
               trip.setCustomStops("");
            }
				tripList.setTrip(trip, currentSelection);

				tripFileAdapter.saveTrips(tripList);
				
			     updateAllTrips();
			     updateCheckBox();
			}

			if (e.getSource() == removeButton) {
				if (tripFileAdapter.getAllTrips() != null) {
					int currentSelection = alltripsBox.getSelectedIndex();
					tripList = tripFileAdapter.getAllTrips();

					if (!(currentSelection == -1)) {
						tripList.removeTripByIndex(currentSelection);
					}

					tripFileAdapter.saveTrips(tripList);
					
					updateAllTrips();
	            updateCheckBox();
				}
			}
			
			if (e.getSource() == clearButton) {
			   updateAllTrips();
			    clearAllFields();
			    
			}
		}
	}
}