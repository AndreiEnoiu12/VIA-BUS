package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Buses.Bus;
import Buses.Bus.BusType;
import Buses.BusFileAdapter;
import Buses.BusList;

/**
 * GUI panel for buses.
 */ 

@SuppressWarnings("serial")
public class BusesGUI extends JPanel {
	private BusFileAdapter busFileAdapter = new BusFileAdapter();
	private BusList busList = new BusList();
	private JLabel busType, busName, busNumberOfSeats;

	private JTextField busNameField, busNumberOfSeatsField;

	private JComboBox<Object> busTypeBox;
	private JComboBox<Object> allBussesBox;

	private JPanel busInformationPanel;
	private JPanel allBuses;
	private JPanel buttonPanel;

	private JButton editButton, addButton, removeButton;

	private CustomButtonListener buttonListener;

   /**
    * Constructor initializing the GUI components
    */

	public BusesGUI() {
		buttonListener = new CustomButtonListener();

		busType = new JLabel("Type of Bus:");
		busTypeBox = new JComboBox<Object>(BusType.values());
		busTypeBox.setMaximumRowCount(5);
		busTypeBox.setSelectedIndex(0);

		busName = new JLabel("Name of the Bus:");
		busNameField = new JTextField(20);

		busNumberOfSeats = new JLabel("Number of seats:");
		busNumberOfSeatsField = new JTextField(20);

		busInformationPanel = new JPanel();
		busInformationPanel.setBounds(210, 130, 450, 115);
		busInformationPanel.setBorder(new TitledBorder("Bus information"));
		busInformationPanel.setLayout(new GridLayout(3, 2, -20, 10));

		busInformationPanel.add(busType);
		busInformationPanel.add(busTypeBox);

		busInformationPanel.add(busName);
		busInformationPanel.add(busNameField);

		busInformationPanel.add(busNumberOfSeats);
		busInformationPanel.add(busNumberOfSeatsField);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(340, 255, 190, 35);
		addButton = new JButton("Add a Bus");
		addButton.addActionListener(buttonListener);

		editButton = new JButton("Edit");
		editButton.addActionListener(buttonListener);
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);

		allBuses = new JPanel();
		allBuses.setBounds(210, 35, 450, 84);
		allBuses.setBorder(new TitledBorder("All Buses"));

		allBussesBox = new JComboBox<Object>();
		allBussesBox.addActionListener(buttonListener);
		allBussesBox.setBounds(365, 10, 510, 85);

		allBussesBox.setMaximumRowCount(10);
		allBussesBox.setPreferredSize(new Dimension(430, 26));

		removeButton = new JButton("Remove");
		removeButton.addActionListener(buttonListener);

		allBuses.add(allBussesBox);
		allBuses.add(removeButton);

		setLayout(null);
		add(busInformationPanel);
		add(buttonPanel);
		add(allBuses);
	}

   /**
    * Updates and clears fields for buses.
    */

	public final void init() {
		updateAllBuses();
		ClearAllFields();
	}

   /**
    * Clears fields for buses.
    */

	public void ClearAllFields() {
		busNameField.setText("");
		busNumberOfSeatsField.setText("");
	}

   /**
    * Updates all the buses
    */

	private void updateAllBuses() {
		allBussesBox.removeAllItems();
		busList = busFileAdapter.getAllBuses();

		for (int i = 0; i < busList.getSize(); i++) {
			allBussesBox.addItem(busList.getBusByIndex(i));
		}

		allBussesBox.setSelectedIndex(-1);
	}

   /*
    * Inner action listener class 
    */

	private class CustomButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == allBussesBox) {
				if (allBussesBox.getSelectedItem() instanceof Bus) {
					Bus tempBus = (Bus) allBussesBox.getSelectedItem();
					busNameField.setText(tempBus.getName());
					busNumberOfSeatsField.setText(tempBus.getNumberOfSeats());
					busTypeBox.setSelectedItem(tempBus.getBusType());
				}
			}

			if (e.getSource() == addButton) {
				Bus bus = new Bus(busNameField.getText().trim(),
						(busNumberOfSeatsField.getText().trim()),
						(BusType) busTypeBox.getSelectedItem());

				busList = busFileAdapter.getAllBuses();
				busList.addBus(bus);
				busFileAdapter.saveBuses(busList);
				updateAllBuses();
				ClearAllFields();
			}

			if (e.getSource() == editButton) {
				int currentSelection = allBussesBox.getSelectedIndex();
				
				if (currentSelection == -1)
					currentSelection = 0;

				Bus bus = new Bus(busNameField.getText().trim(),
						busNumberOfSeatsField.getText().trim(),
						(BusType) busTypeBox.getSelectedItem());
				
				busList = busFileAdapter.getAllBuses();
				busList.setBus(bus, currentSelection);

				busFileAdapter.saveBuses(busList);
				
				init();
			}

			if (e.getSource() == removeButton) {
				if (busFileAdapter.getAllBuses() != null) {
					int currentSelection = allBussesBox.getSelectedIndex();
					busList = busFileAdapter.getAllBuses();

					if (!(currentSelection == -1))
						busList.removeBusByIndex(currentSelection);

					busFileAdapter.saveBuses(busList);
					busNameField.setText("");
					busNumberOfSeatsField.setText("");

					busFileAdapter.saveBuses(busList);
					
					init();
				}
			}
		}
	}
}
