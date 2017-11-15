package kr.or.dgit.RentCar_Project.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class PhoneTextFiedComponent extends JPanel {
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfNum3;

	public PhoneTextFiedComponent(String title) {
		setLayout(new GridLayout(0, 2, 50, 0));
		
		JLabel lblPhoneNum = new JLabel(title);
		lblPhoneNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPhoneNum);
		
		JPanel phonePanel1 = new JPanel();
		add(phonePanel1);
		phonePanel1.setLayout(new GridLayout(0, 5, 0, 0));
		
		tfNum1 = new JTextField();
		phonePanel1.add(tfNum1);
		tfNum1.setColumns(10);
		
		JLabel lblbar1 = new JLabel("-");
		lblbar1.setHorizontalAlignment(SwingConstants.CENTER);
		phonePanel1.add(lblbar1);
		
		tfNum2 = new JTextField();
		phonePanel1.add(tfNum2);
		tfNum2.setColumns(10);
		
		JLabel lblbar2 = new JLabel("-");
		lblbar2.setHorizontalAlignment(SwingConstants.CENTER);
		phonePanel1.add(lblbar2);
		
		tfNum3 = new JTextField();
		phonePanel1.add(tfNum3);
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
	
	public boolean isEmptyCheck(){
		if(getTextValueNum1().equals("")||getTextValueNum2().equals("")||getTextValueNum3().equals("")) {
			tfNum1.requestFocus();
			return false;
		}return true;
	}
	
	public void setTextValueClear() {
		tfNum1.setText("");
		tfNum2.setText("");
		tfNum3.setText("");
	}
	
	public void setActive(boolean active) {
		tfNum1.setEnabled(active);
		tfNum2.setEnabled(active);
		tfNum3.setEnabled(active);
	}
}
