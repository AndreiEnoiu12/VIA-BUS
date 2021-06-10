package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Passengers.Customer;
import Passengers.Passenger;
import Passengers.PassengerList;
import Reservations.Reservation;
import Reservations.ReservationFileAdapter;
import Reservations.ReservationList;
import Trips.Trip;
import Trips.TripFileAdapter;
import Trips.TripList;
import Utils.CustomDate;

/**
 * A GUI panel containing components for displaying reservations
 */

@SuppressWarnings("serial")
public class ReservationsGUI extends JPanel
{
   private ReservationFileAdapter reservationFileAdapter = new ReservationFileAdapter();
   private ReservationList reservationList = new ReservationList();

   private JLabel customerFirstName, customerLastName, customerBirthday,
         customerAddress, customerEmail, bookedTrip, numberOfPassengers,
         telephoneNumber, passengerFirstName, passengerLastName,
         passengerBirthday, passengerAddress;

   private JTextField firstNameField, lastNameField, addressField, emailField,
         numberOfPasengerField, telephoneField;

   private JComboBox<Object> dayBox;
   private JComboBox<Object> monthBox;
   private JComboBox<Object> yearBox;

   private JComboBox<Trip> tripComboBox;
   private JComboBox<Reservation> allReservationsBox;

   private JButton addReservationButton, removeReservationButton,
         editReservationButton, clearButton;

   private JPanel inputPanel;
   private JPanel buttonsJPanel;
   private JPanel allResevationsPanel;
   private JPanel datePanel;

   private MyButtonListener buttonListener;

   private JTextField passengerFirstNameField, passengerLastNameField,
         passengerAddressField;

   private JComboBox<Object> passengerDayBox;
   private JComboBox<Object> passengerMonthBox;
   private JComboBox<Object> passengerYearBox;

   private JComboBox<Passenger> allPassengersBox;

   private JButton addPassengerButton, removePassengerButton,
         editPassengerButton, clearPassengerButton;

   private JPanel passengerInputPanel;
   private JPanel passengerButtonsJPanel;
   private JPanel allPassengersPanel;
   private JPanel passengerDatePanel;

   /**
    * Constructor initializing the GUI components
    */

   public ReservationsGUI()
   {
      buttonListener = new MyButtonListener();

      customerFirstName = new JLabel("First Name:");
      customerFirstName.setBounds(6, 16, 156, 22);
      firstNameField = new JTextField(20);
      firstNameField.setBounds(162, 16, 156, 22);

      customerLastName = new JLabel("Last Name:");
      customerLastName.setBounds(6, 56, 156, 22);
      lastNameField = new JTextField(20);
      lastNameField.setBounds(162, 56, 156, 22);

      customerBirthday = new JLabel("Birthday:");
      customerBirthday.setBounds(6, 96, 156, 22);
      dayBox = new JComboBox<Object>(DatesAndTime.days());
      monthBox = new JComboBox<Object>(DatesAndTime.months());
      yearBox = new JComboBox<Object>(DatesAndTime.birthdayYears());
      datePanel = new JPanel();
      datePanel.setBounds(162, 85, 156, 40);
      datePanel.add(dayBox);
      datePanel.add(monthBox);
      datePanel.add(yearBox);

      customerAddress = new JLabel("Address:");
      customerAddress.setBounds(6, 176, 156, 22);
      addressField = new JTextField(20);
      addressField.setBounds(162, 176, 156, 22);

      customerEmail = new JLabel("E-mail:");
      customerEmail.setBounds(6, 136, 156, 22);
      emailField = new JTextField(20);
      emailField.setBounds(162, 136, 156, 22);

      telephoneNumber = new JLabel("Telephone Number:");
      telephoneNumber.setBounds(6, 216, 156, 22);
      telephoneField = new JTextField(20);
      telephoneField.setBounds(162, 216, 156, 22);

      bookedTrip = new JLabel("Trip name:");
      bookedTrip.setBounds(6, 296, 156, 22);
      tripComboBox = new JComboBox<Trip>(new TripFileAdapter().getAllTrips()
            .toArray());
      tripComboBox.setBounds(162, 296, 156, 22);
      tripComboBox.setMaximumRowCount(5);

      numberOfPassengers = new JLabel("Number of passengers:");
      numberOfPassengers.setBounds(6, 256, 156, 22);
      numberOfPasengerField = new JTextField(20);
      numberOfPasengerField.setBounds(162, 256, 156, 22);
      numberOfPasengerField.setEditable(false);

      inputPanel = new JPanel();
      inputPanel.setSize(325, 325);
      inputPanel.setLocation(10, 10);
      inputPanel.setBorder(new TitledBorder("Reservation Information"));
      inputPanel.setLayout(null);

      inputPanel.add(customerFirstName);
      inputPanel.add(firstNameField);

      inputPanel.add(customerLastName);
      inputPanel.add(lastNameField);

      inputPanel.add(customerBirthday);
      inputPanel.add(datePanel);

      inputPanel.add(customerEmail);
      inputPanel.add(emailField);

      inputPanel.add(customerAddress);
      inputPanel.add(addressField);

      inputPanel.add(telephoneNumber);
      inputPanel.add(telephoneField);

      inputPanel.add(numberOfPassengers);
      inputPanel.add(numberOfPasengerField);

      inputPanel.add(bookedTrip);
      inputPanel.add(tripComboBox);

      addReservationButton = new JButton("Create a Reservation");
      addReservationButton.addActionListener(buttonListener);
      editReservationButton = new JButton("Edit");
      editReservationButton.addActionListener(buttonListener);

      buttonsJPanel = new JPanel();
      buttonsJPanel.setBounds(10, 335, 300, 70);

      buttonsJPanel.add(addReservationButton);
      buttonsJPanel.add(editReservationButton);

      clearButton = new JButton("Clear");
      clearButton.addActionListener(buttonListener);
      clearButton.setBounds(785, 345, 90, 30);

      allResevationsPanel = new JPanel();
      allResevationsPanel.setBorder(new TitledBorder("All Reservations"));
      allResevationsPanel.setBounds(365, 10, 510, 85);
      allResevationsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      allReservationsBox = new JComboBox<Reservation>();
      allReservationsBox.addActionListener(buttonListener);
      removeReservationButton = new JButton("Remove");
      removeReservationButton.addActionListener(buttonListener);
      allResevationsPanel.add(allReservationsBox);
      allResevationsPanel.add(removeReservationButton);
      allReservationsBox.setPreferredSize(new Dimension(500, 26));
      allReservationsBox.setMaximumRowCount(10);

      setLayout(null);
      add(inputPanel);
      add(allResevationsPanel);
      add(buttonsJPanel);
      add(clearButton);

      passengerFirstName = new JLabel("First name:");
      passengerFirstName.setBounds(6, 16, 156, 22);
      passengerFirstNameField = new JTextField(100);
      passengerFirstNameField.setBounds(162, 16, 100, 22);

      passengerLastName = new JLabel("Last Name:");
      passengerLastName.setBounds(6, 56, 156, 22);
      passengerLastNameField = new JTextField(20);
      passengerLastNameField.setBounds(162, 56, 100, 22);

      passengerBirthday = new JLabel("Birthday:");
      passengerBirthday.setBounds(6, 96, 156, 22);
      passengerDayBox = new JComboBox<Object>(DatesAndTime.days());
      passengerMonthBox = new JComboBox<Object>(DatesAndTime.months());
      passengerYearBox = new JComboBox<Object>(DatesAndTime.birthdayYears());
      passengerDatePanel = new JPanel();
      passengerDatePanel.setBounds(108, 85, 156, 40);
      passengerDatePanel.add(passengerDayBox);
      passengerDatePanel.add(passengerMonthBox);
      passengerDatePanel.add(passengerYearBox);

      passengerAddress = new JLabel("Address:");
      passengerAddress.setBounds(6, 136, 156, 22);
      passengerAddressField = new JTextField(20);
      passengerAddressField.setBounds(162, 136, 100, 22);

      passengerInputPanel = new JPanel();
      passengerInputPanel.setBounds(365, 110, 270, 170);
      passengerInputPanel.setBorder(new TitledBorder("Passenger Information"));
      passengerInputPanel.setLayout(null);

      passengerInputPanel.add(passengerFirstName);
      passengerInputPanel.add(passengerFirstNameField);

      passengerInputPanel.add(passengerLastName);
      passengerInputPanel.add(passengerLastNameField);

      passengerInputPanel.add(passengerBirthday);
      passengerInputPanel.add(passengerDatePanel);

      passengerInputPanel.add(passengerAddress);
      passengerInputPanel.add(passengerAddressField);

      addPassengerButton = new JButton("Add a passenger");
      addPassengerButton.addActionListener(buttonListener);
      editPassengerButton = new JButton("Edit");
      editPassengerButton.addActionListener(buttonListener);
      clearPassengerButton = new JButton("Clear");
      clearPassengerButton.addActionListener(buttonListener);

      passengerButtonsJPanel = new JPanel();
      passengerButtonsJPanel.setBounds(352, 282, 300, 35);

      passengerButtonsJPanel.add(addPassengerButton);
      passengerButtonsJPanel.add(editPassengerButton);
      passengerButtonsJPanel.add(clearPassengerButton);

      allPassengersPanel = new JPanel();
      allPassengersPanel.setBorder(new TitledBorder("All Passengers"));
      allPassengersPanel.setBounds(650, 110, 220, 85);
      allPassengersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      allPassengersBox = new JComboBox<Passenger>();
      allPassengersBox.addActionListener(buttonListener);
      removePassengerButton = new JButton("Remove");
      removePassengerButton.addActionListener(buttonListener);
      allPassengersPanel.add(allPassengersBox);
      allPassengersPanel.add(removePassengerButton);
      allPassengersBox.setPreferredSize(new Dimension(200, 26));
      allPassengersBox.setMaximumRowCount(10);

      setLayout(null);
      add(passengerInputPanel);
      add(allPassengersPanel);
      add(passengerButtonsJPanel);
   }

   /**
    * Updates and clears all Reservation
    */

   public final void init()
   {
      updateAllReservations();
      clearAllFields();
   }

   /**
    * Updates all Reservation
    */

   private void updateAllReservations()
   {
      int currentSelection = allReservationsBox.getSelectedIndex();
      allReservationsBox.removeAllItems();
      ReservationList reservations = reservationFileAdapter
            .getAllReservations();

      for (int i = 0; i < reservations.getSize(); i++)
      {
         allReservationsBox.addItem(reservations.getReservationByIndex(i));
      }

      tripComboBox.removeAllItems();
      TripList tripList = new TripFileAdapter().getAllTrips();
      for (int i = 0; i < tripList.getSize(); i++)
      {
         tripComboBox.addItem(tripList.getTripByIndex(i));
      }

      allPassengersBox.removeAllItems();

      try
      {
         allReservationsBox.setSelectedIndex(currentSelection);
      }
      catch (IllegalArgumentException e)
      {
      }
   }

   /**
    * Clears all fields
    */

   private void clearAllFields()
   {
      firstNameField.setText("");
      lastNameField.setText("");
      emailField.setText("");
      addressField.setText("");
      telephoneField.setText("");
      numberOfPasengerField.setText("");
      dayBox.setSelectedIndex(0);
      monthBox.setSelectedIndex(0);
      yearBox.setSelectedIndex(0);
      passengerAddressField.setText("");
      passengerFirstNameField.setText("");
      passengerLastNameField.setText("");
      passengerDayBox.setSelectedIndex(0);
      passengerMonthBox.setSelectedIndex(0);
      passengerYearBox.setSelectedIndex(0);
   }

   public void clearPassengerFields()
   {
      passengerFirstNameField.setText("");
      passengerLastNameField.setText("");
      passengerAddressField.setText("");
   }

   /*
    * Inner action listener class
    */

   private class MyButtonListener implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == allReservationsBox)
         {
            if (allReservationsBox.getSelectedItem() instanceof Reservation)
            {
               Reservation tempReservation = (Reservation) allReservationsBox
                     .getSelectedItem();
               firstNameField.setText(tempReservation.getPassengers()
                     .getCustomer().getFirstName());
               lastNameField.setText(tempReservation.getPassengers()
                     .getCustomer().getLastName());
               dayBox.setSelectedItem(tempReservation.getPassengers()
                     .getCustomer().getBirthday().getDay());
               monthBox.setSelectedItem(tempReservation.getPassengers()
                     .getCustomer().getBirthday().getMonth());
               yearBox.setSelectedItem(tempReservation.getPassengers()
                     .getCustomer().getBirthday().getYear());
               emailField.setText(tempReservation.getPassengers().getCustomer()
                     .getEmail());
               addressField.setText(tempReservation.getPassengers()
                     .getCustomer().getAddress());
               telephoneField.setText(tempReservation.getPassengers()
                     .getCustomer().getPhoneNumber());
               numberOfPasengerField.setText(Integer.toString(tempReservation
                     .getPassengers().getSize()));
               tripComboBox.setSelectedItem((Trip) tempReservation.getTrip());

               allPassengersBox.removeAllItems();
               if (allReservationsBox.getSelectedIndex() > -1)
               {
                  Reservation reservation = (Reservation) allReservationsBox
                        .getSelectedItem();

                  for (int i = 0; i < reservation.getPassengersSize(); i++)
                  {
                     allPassengersBox.addItem(reservation.getPassengers()
                           .getPassengerByIndex(i));
                  }
               }
            }

         }

         if (e.getSource() == addReservationButton)
         {
            int numberOfPassengers = 0;

            if (!(numberOfPasengerField.getText().isEmpty()))
               numberOfPassengers = Integer.parseInt(numberOfPasengerField
                     .getText().trim());

            CustomDate birthday = new CustomDate(
                  Integer.parseInt(dayBox.getSelectedItem().toString().trim()),
                  Integer
                        .parseInt(monthBox.getSelectedItem().toString().trim()),
                  Integer.parseInt(yearBox.getSelectedItem().toString().trim()));
            Customer customer = new Customer(firstNameField.getText(),
                  lastNameField.getText(), addressField.getText(), birthday,
                  emailField.getText(), telephoneField.getText(),
                  numberOfPassengers);

            Trip trip = (Trip) tripComboBox.getSelectedItem();
            PassengerList passengers = new PassengerList();
            passengers.setCustomer(customer);
            Reservation reservation = new Reservation(trip, passengers);
            reservationList = reservationFileAdapter.getAllReservations();
            reservationList.addReservation(reservation);
            reservationFileAdapter.saveReservations(reservationList);

            updateAllReservations();
            clearAllFields();
         }

         if (e.getSource() == editReservationButton)
         {
            int currentSelection = allReservationsBox.getSelectedIndex();

            if (currentSelection == -1)
               currentSelection = 0;

            int numberOfPassengers = 0;

            if (!(numberOfPasengerField.getText().isEmpty()))
               numberOfPassengers = Integer.parseInt(numberOfPasengerField
                     .getText().trim());

            CustomDate birthday = new CustomDate(
                  Integer.parseInt(dayBox.getSelectedItem().toString().trim()),
                  Integer
                        .parseInt(monthBox.getSelectedItem().toString().trim()),
                  Integer.parseInt(yearBox.getSelectedItem().toString().trim()));
            Customer customer = new Customer(firstNameField.getText(),
                  lastNameField.getText(), addressField.getText(), birthday,
                  emailField.getText(), telephoneField.getText(),
                  numberOfPassengers);

            Trip trip = (Trip) tripComboBox.getSelectedItem();
            reservationList = reservationFileAdapter.getAllReservations();
            PassengerList passengers = new PassengerList();
            passengers.setCustomer(customer);
            Reservation reservation = new Reservation(trip, passengers);

            reservationList.setReservation(reservation, currentSelection);

            reservationFileAdapter.saveReservations(reservationList);

            updateAllReservations();
         }

         if (e.getSource() == removeReservationButton)
         {
            if (reservationFileAdapter.getAllReservations() != null)
            {
               int currentSelection = allReservationsBox.getSelectedIndex();
               reservationList = reservationFileAdapter.getAllReservations();

               if (!(currentSelection == -1))
               {
                  reservationList.removeReservationByIndex(currentSelection);
               }

               reservationFileAdapter.saveReservations(reservationList);

               updateAllReservations();
            }

         }
         if (e.getSource() == clearButton)
         {
            init();
         }

         // //////////////////////PASSENGER
         // BUTTONS//////////////////////////////////

         if (e.getSource() == allPassengersBox)
         {
            if (allPassengersBox.getSelectedItem() instanceof Passenger)
            {
               Passenger tempPassenger = (Passenger) allPassengersBox
                     .getSelectedItem();
               
               String firstName = tempPassenger.getFirstName();
               passengerFirstNameField.setText(firstName);
               passengerLastNameField.setText(tempPassenger.getLastName());
               passengerDayBox.setSelectedItem(tempPassenger.getBirthday()
                     .getDay());
               passengerMonthBox.setSelectedItem(tempPassenger.getBirthday()
                     .getMonth());
               passengerYearBox.setSelectedItem(tempPassenger.getBirthday()
                     .getYear());
               passengerAddressField.setText(tempPassenger.getAddress());
            }

         }

         if (e.getSource() == addPassengerButton)
         {

            if (allReservationsBox.getSelectedIndex() > -1)
            {
               CustomDate birthday = new CustomDate(Integer.parseInt(dayBox
                     .getSelectedItem().toString().trim()),
                     Integer.parseInt(monthBox.getSelectedItem().toString()
                           .trim()), Integer.parseInt(yearBox.getSelectedItem()
                           .toString().trim()));
               String firstName = passengerFirstNameField.getText();
               Passenger passenger = new Passenger(firstName,
                     passengerLastNameField.getText(),
                     passengerAddressField.getText(), birthday);

               Reservation reservation = (Reservation) allReservationsBox
                     .getSelectedItem();
               reservation.addPassenger(passenger);

               reservationList = reservationFileAdapter.getAllReservations();
               reservationList.setReservation(reservation,
                     allReservationsBox.getSelectedIndex());
               reservationFileAdapter.saveReservations(reservationList);
               updateAllReservations();
               clearPassengerFields();
            }
            else
            {
               MessageDialog.CreateWarningDialog("Error",
                     "To add passenger, choose reservation first");
            }
            clearPassengerFields();
         }

         if (e.getSource() == editPassengerButton)
         {
            int currentSelection = allPassengersBox.getSelectedIndex();

            CustomDate birthday = new CustomDate(
                  Integer.parseInt(dayBox.getSelectedItem().toString().trim()),
                  Integer
                        .parseInt(monthBox.getSelectedItem().toString().trim()),
                  Integer.parseInt(yearBox.getSelectedItem().toString().trim()));
            Passenger passenger = new Passenger(
                  passengerFirstNameField.getText(),
                  passengerLastNameField.getText(),
                  passengerAddressField.getText(), birthday);

            Reservation reservation = (Reservation) allReservationsBox
                  .getSelectedItem();
            reservation.setPassenger(passenger, currentSelection);

            reservationList = reservationFileAdapter.getAllReservations();
            reservationList.setReservation(reservation,
                  allReservationsBox.getSelectedIndex());
            reservationFileAdapter.saveReservations(reservationList);

            updateAllReservations();
         }

         if (e.getSource() == removePassengerButton)
         {
            Reservation reservation = (Reservation) allReservationsBox
                  .getSelectedItem();

            if (allReservationsBox.getSelectedIndex() > -1
                  && allPassengersBox.getSelectedIndex() > -1)
            {
               int currentSelection = allPassengersBox.getSelectedIndex();

               reservation.removePassengerByIndex(currentSelection);

               reservationList = reservationFileAdapter.getAllReservations();
               reservationList.setReservation(reservation,
                     allReservationsBox.getSelectedIndex());
               reservationFileAdapter.saveReservations(reservationList);

               updateAllReservations();
            }
         }
         if (e.getSource() == clearPassengerButton)
         {
            clearPassengerFields();

         }

      }

   }
}