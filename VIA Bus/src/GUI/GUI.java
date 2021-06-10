package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * GUI for menu pages
 */ 

@SuppressWarnings("serial")
public class GUI extends CustomJFrame {
	private CustomChangeListener changeListener = new CustomChangeListener();
	private ReservationsGUI reservationsGUI = new ReservationsGUI();
	private TripsGUI tripsGUI = new TripsGUI();
	private BusesGUI busesGUI = new BusesGUI();
	private DriversGUI driversGUI = new DriversGUI();

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem exit;
	private JMenu aboutMenu;

	private JTabbedPane tabPane;

	JButton buttonReservationTab;

	public GUI() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		aboutMenu = new JMenu("About");
		exit = new JMenuItem("Exit");
		fileMenu.add(exit);
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		setJMenuBar(menuBar);

		tabPane = new JTabbedPane();
		tabPane.addTab("Reservations", reservationsGUI);
		tabPane.addTab("Travels", tripsGUI);
		tabPane.addTab("Driver Management", driversGUI);
		tabPane.addTab("Company Vehicles", busesGUI);

		tabPane.addChangeListener(changeListener);
		add(tabPane);

		setSize(900, 480);
		setVisible(true);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

   /*
    * GUI and reservations GUI class
    */

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.reservationsGUI.init();
	}

  /*
    * Inner action listener class 
    */

	private class CustomChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() instanceof JTabbedPane) {
				if (tabPane.getTitleAt(tabPane.getSelectedIndex()) == "Reservations") {
					reservationsGUI.init();
				}
				
				if (tabPane.getTitleAt(tabPane.getSelectedIndex()) == "Travels") {
					tripsGUI.init();
				}
				
				if (tabPane.getTitleAt(tabPane.getSelectedIndex()) == "Driver Management") {
					driversGUI.init();
				}
				
				if (tabPane.getTitleAt(tabPane.getSelectedIndex()) == "Company Vehicles") {
					busesGUI.init();
				}
			}
		}
	}
}