package kr.or.dgit.RentCar_Project.component;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TextFieldComponent extends JPanel {
	private JTextField textField;
	private JLabel lblNewLabel;

	public JTextField getTextField() {
		return textField;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public TextFieldComponent(String title) {
		setLayout(new GridLayout(0, 2, 5, 0));

		lblNewLabel = new JLabel(title);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);

		textField = new JTextField();
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

	public boolean isEmptyCheck() {
		if (getTextValue().equals("")) {
			textField.requestFocus();
			return false;
		}
		return true;
	}

}
