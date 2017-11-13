package kr.or.dgit.RentCar_Project.component;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class JPasswordFieldComponent extends JPanel {
	private JPasswordField textField;

	public JPasswordField getTextField() {
		return textField;
	}
	
	public JPasswordFieldComponent(String title) {
		setLayout(new GridLayout(0, 2, 5, 0));

		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);

		textField = new JPasswordField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		add(textField);
		textField.setColumns(10);

	}

	public String getTextValue() {
		return textField.getText();
	}

	public void setTextValue(String value) {
		textField.setText(value);
	}

	public void setEnable(boolean isEnable) {
		textField.setEditable(isEnable);
	}

	public boolean isEmptyCheck(){
		if (getTextValue().equals("")) {
			textField.requestFocus();
			return false;
		}return true;
	}
}
