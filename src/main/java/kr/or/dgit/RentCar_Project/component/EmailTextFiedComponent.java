package kr.or.dgit.RentCar_Project.component;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class EmailTextFiedComponent extends JPanel {
	private JTextField tfId;
	private JTextField tfEmailAddr;


	public EmailTextFiedComponent(String title) {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblEmail = new JLabel(title);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblEmail);
		
		JPanel emailPanel = new JPanel();
		add(emailPanel);
		emailPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		tfId = new JTextField();
		emailPanel.add(tfId);
		tfId.setColumns(10);
		
		JLabel lble = new JLabel("@");
		lble.setHorizontalAlignment(SwingConstants.CENTER);
		emailPanel.add(lble);
		
		tfEmailAddr = new JTextField();
		emailPanel.add(tfEmailAddr);
		tfEmailAddr.setColumns(10);
		
		JComboBox<String> cbEmailAddr = new JComboBox<>();
		emailPanel.add(cbEmailAddr);

	}
	public String getTextValueId() {
		return tfId.getText();
	}
	public String getTextValueEmailAddr() {
		return tfEmailAddr.getText();
	}
	public void setTextValueId(String value) {
		tfId.setText(value);
	}
	public void setTextValueEmailAddr(String value) {
		tfEmailAddr.setText(value);
	}
	
	public void isEmptyCheck() throws Exception{
		if(getTextValueId().equals("")||getTextValueEmailAddr().equals("")) {
			tfId.requestFocus();
		}
	}
}
