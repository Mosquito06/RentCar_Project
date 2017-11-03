package kr.or.dgit.RentCar_Project.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PhoneTextFiedComponent extends JPanel {
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfNum3;

	public PhoneTextFiedComponent(String title) {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblPhoneNum = new JLabel(title);
		lblPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPhoneNum);
		
		JPanel numPanel = new JPanel();
		add(numPanel);
		numPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		tfNum1 = new JTextField();
		numPanel.add(tfNum1);
		tfNum1.setColumns(10);
		
		JLabel lblBar1 = new JLabel("-");
		numPanel.add(lblBar1);
		lblBar1.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfNum2 = new JTextField();
		numPanel.add(tfNum2);
		tfNum2.setColumns(10);
		
		JLabel lblBar2 = new JLabel("-");
		numPanel.add(lblBar2);
		lblBar2.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfNum3 = new JTextField();
		numPanel.add(tfNum3);
		tfNum3.setColumns(10);

	}
	
	public String getTextValueNum1() {
		return tfNum1.getText();
	}
	public String getTextValueNum2() {
		return tfNum2.getText();
	}
	public String getTextValueNum3() {
		return tfNum3.getText();
	}
	
	public void setTextValueNum1(String value) {
		tfNum1.setText(value);
	}
	
	public void setTextValueNum2(String value) {
		tfNum2.setText(value);
	}
	public void setTextValueNum3(String value) {
		tfNum3.setText(value);
	}
	
	public void isEmptyCheck() throws Exception{
		if(getTextValueNum1().equals("")||getTextValueNum2().equals("")||getTextValueNum3().equals("")) {
			tfNum1.requestFocus();
		}
	}
}
