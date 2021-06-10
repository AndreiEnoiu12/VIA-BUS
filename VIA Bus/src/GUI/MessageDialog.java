package GUI;

import javax.swing.JOptionPane;

/**
 * A class containing message dialogs
 */  

public class MessageDialog {
	public static void CreateInformationDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void CreateWarningDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.WARNING_MESSAGE);
	}

	public static void CreateErrorDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	public static int CreateQuestionDialog(String title, String message,
			String yesOptionText, String noOptionText) {
		Object[] options = { yesOptionText, noOptionText };
		int n = JOptionPane.showOptionDialog(null, message, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, null);

		return n;
	}
}
