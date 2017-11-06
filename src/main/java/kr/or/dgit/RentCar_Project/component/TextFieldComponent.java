package kr.or.dgit.RentCar_Project.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class TextFieldComponent extends JPanel {
	private JTextField textField;

	public TextFieldComponent(String title) {
		setLayout(new GridLayout(0, 2, 5, 0));

		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);

		textField = new JTextField();
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

	public void isEmptyCheck() throws Exception {
		if (getTextValue().equals("")) {
			textField.requestFocus();
		}
	}

	public JTextField getTextField() {
		return textField;
	}
	
	

}
