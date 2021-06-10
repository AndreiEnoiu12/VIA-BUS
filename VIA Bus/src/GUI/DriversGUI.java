package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Drivers.Driver;
import Drivers.Driver.EmploymentType;
import Drivers.DriverFileAdapter;
import Drivers.DriverList;


/**
 * A GUI panel containing components for displaying a list of drivers.
 */ 

@SuppressWarnings("serial")
public class DriversGUI extends JPanel {
	private DriverFileAdapter driverFileAdapter = new DriverFileAdapter();
	private DriverList driverList = new DriverList();

	private JLabel firstNameLabel, lastNameLabel, addressLabel, emailLabel,
			telephoneNumberLabel, idNumberlabelJLabel, employmentTypeLabel;

	private JTextField firstNameField, lastNameField, addressField, emailField,
			telephoneNumberField, idField;

	private JTextArea preferencesArea;
	
	private JComboBox<Object> allDriversBox;
	private JComboBox<Object> employmentTypeBox;

	private JButton removeButton, editButton, addButton, clearButton;

	private JPanel driverInformationPanel;
	private JPanel allDriversPanel;
	private JPanel buttonPanel;
	private JPanel preferencesAreaPanel;
	
	private CustomButtonListener buttonListener;
	

  /**
    * Constructor initializing the GUI components
    */

	public DriversGUI() {
		buttonListener = new CustomButtonListener();
		firstNameLabel = new JLabel("First Name:");
		firstNameField = new JTextField(20);

		lastNameLabel = new JLabel("Last Name:");
		lastNameField = new JTextField(20);

		addressLabel = new JLabel("Address");
		addressField = new JTextField(20);

		emailLabel = new JLabel("E-mail:");
		emailField = new JTextField(20);

		preferencesArea = new JTextArea(10,30);
		preferencesAreaPanel = new JPanel();
		
		preferencesAreaPanel.add(preferencesArea);
		preferencesAreaPanel.setBounds(365, 120, 350, 200);
		preferencesAreaPanel.setBorder(new TitledBorder("Driver preferences"));


		
		telephoneNumberLabel = new JLabel("Telephone Number:");
		telephoneNumberField = new JTextField(20);

		idNumberlabelJLabel = new JLabel("Driver ID:");
		idField = new JTextField(20);

		employmentTypeLabel = new JLabel("Type Of Employment:");
		employmentTypeBox = new JComboBox<Object>(EmploymentType.values());
		employmentTypeBox.addActionListener(buttonListener);

		driverInformationPanel = new JPanel();
		driverInformationPanel.setSize(300, 300);
		driverInformationPanel.setLayout(new GridLayout(7, 2, 0, 20));
		driverInformationPanel.setLocation(10, 10);
		driverInformationPanel
				.setBorder(new TitledBorder("Driver Information"));

		driverInformationPanel.add(firstNameLabel);
		driverInformationPanel.add(firstNameField);

		driverInformationPanel.add(lastNameLabel);
		driverInformationPanel.add(lastNameField);

		driverInformationPanel.add(addressLabel);
		driverInformationPanel.add(addressField);

		driverInformationPanel.add(emailLabel);
		driverInformationPanel.add(emailField);

		driverInformationPanel.add(telephoneNumberLabel);
		driverInformationPanel.add(telephoneNumberField);

		driverInformationPanel.add(employmentTypeLabel);
		driverInformationPanel.add(employmentTypeBox);

		driverInformationPanel.add(idNumberlabelJLabel);
		driverInformationPanel.add(idField);

		addButton = new JButton("Add a Driver");
		addButton.addActionListener(buttonListener);
		editButton = new JButton("Edit");
		editButton.addActionListener(buttonListener);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 335, 300, 70);
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(buttonListener);
		clearButton.setBounds(785, 345, 90, 30);

		allDriversPanel = new JPanel();
		allDriversPanel.setBorder(new TitledBorder("All Drivers"));
		allDriversPanel.setBounds(365, 10, 510, 85);
		allDriversPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		allDriversBox = new JComboBox<Object>();
		allDriversBox.addActionListener(buttonListener);
		removeButton = new JButton("Remove");
		removeButton.addActionListener(buttonListener);
		allDriversPanel.add(allDriversBox);
		allDriversPanel.add(removeButton);
		allDriversBox.setPreferredSize(new Dimension(500, 26));
		allDriversBox.setMaximumRowCount(10);

		setLayout(null);
		add(driverInformationPanel);
		add(buttonPanel);
		add(allDriversPanel);
		add(clearButton);
		add(preferencesAreaPanel);
	}

   /**
    * Clears all the fields.
    */

	public void clearAllFields() {
		firstNameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		emailField.setText("");
		telephoneNumberField.setText("");
		employmentTypeBox.setSelectedIndex(0);
		idField.setText("");
		preferencesArea.setText("");
	}

	public final void init() {
		updateAllDrivers();
		clearAllFields();
	}

   /**
    * Updates the all drivers with information from drivers file
    */

	private void updateAllDrivers() {
	   int currentSelection = allDriversBox.getSelectedIndex();
		allDriversBox.removeAllItems();
		driverList = driverFileAdapter.getAllDrivers();

		for (int i = 0; i < driverList.getSize(); i++) {
			allDriversBox.addItem(driverList.getDriverByIndex(i));
		}
		try{
		    allDriversBox.setSelectedIndex(currentSelection);
		}
		catch(IllegalArgumentException e)
		{
		}
	}

   /*
    * Inner action listener class 
    */

	private class CustomButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == employmentTypeBox) {
				if (employmentTypeBox.getSelectedItem() == EmploymentType.EXTRA) {
					idField.setText("");
					idField.setEditable(false);
				} else {
					idField.setEditable(true);
				}
			}

			if (e.getSource() == allDriversBox) {
				if (allDriversBox.getSelectedItem() instanceof Driver) {
					Driver tempDriver = (Driver) allDriversBox
							.getSelectedItem();

					firstNameField.setText(tempDriver.getFirstName());
					lastNameField.setText(tempDriver.getLastName());
					addressField.setText(tempDriver.getAddress());
					emailField.setText(tempDriver.getEmail());
					telephoneNumberField.setText(tempDriver.getPhoneNumber());
					employmentTypeBox.setSelectedItem(tempDriver
							.getEmploymentType());
					idField.setText(tempDriver.getId());
					preferencesArea.setText(tempDriver.getPreferences());
				}
			}

			if (e.getSource() == addButton) {
				Driver driver = new Driver(firstNameField.getText().trim(),
						lastNameField.getText().trim(), addressField.getText()
								.trim(), emailField.getText().trim(),
						telephoneNumberField.getText().trim(),
						(EmploymentType) employmentTypeBox.getSelectedItem(),
						idField.getText().trim());
				driver.setPreferences(preferencesArea.getText());

				driverList = driverFileAdapter.getAllDrivers();
				driverList.addDriver(driver);
				driverFileAdapter.saveDrivers(driverList);

				updateAllDrivers();
			}

			if (e.getSource() == editButton) {
				int currentSelection = allDriversBox.getSelectedIndex();
				if (currentSelection == -1)
					currentSelection = 0;

				driverList = driverFileAdapter.getAllDrivers();
				Driver driver = new Driver(firstNameField.getText().trim(),
						lastNameField.getText().trim(), addressField.getText()
								.trim(), emailField.getText().trim(),
						telephoneNumberField.getText().trim(),
						(EmploymentType) employmentTypeBox.getSelectedItem(),
						idField.getText().trim());
				driver.setPreferences(preferencesArea.getText());
				driverList.setDriver(driver, currentSelection);

				driverFileAdapter.saveDrivers(driverList);

				updateAllDrivers();
			}

			if (e.getSource() == removeButton) {
				if (driverFileAdapter.getAllDrivers() != null) {
					int currentSelection = allDriversBox.getSelectedIndex();
					driverList = driverFileAdapter.getAllDrivers();

					if (!(currentSelection == -1))
						driverList.removeDriverByIndex(currentSelection);

					driverFileAdapter.saveDrivers(driverList);
					updateAllDrivers();
				}
			}

			if (e.getSource() == clearButton) {
				clearAllFields();
				updateAllDrivers();
			}
		}

	}
}
