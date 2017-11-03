package kr.or.dgit.RentCar_Project.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PhoneTextFiedComponent extends JPanel {
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfNum3;

	public PhoneTextFiedComponent(String title) {
		setLayout(new BorderLayout(10, 0));
		
		JLabel lblPhoneNum = new JLabel(title);
		lblPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPhoneNum, BorderLayout.CENTER);
		
		JPanel phonePanel1 = new JPanel();
		add(phonePanel1, BorderLayout.EAST);
		phonePanel1.setLayout(new BorderLayout(0, 0));
		
		tfNum1 = new JTextField();
		phonePanel1.add(tfNum1, BorderLayout.WEST);
		tfNum1.setColumns(10);
		
		JPanel phonePanel2 = new JPanel();
		phonePanel1.add(phonePanel2, BorderLayout.EAST);
		phonePanel2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblP1 = new JLabel("-");
		phonePanel2.add(lblP1, BorderLayout.WEST);
		
		JPanel phonePanel3 = new JPanel();
		phonePanel2.add(phonePanel3, BorderLayout.EAST);
		phonePanel3.setLayout(new BorderLayout(0, 0));
		
		tfNum2 = new JTextField();
		phonePanel3.add(tfNum2, BorderLayout.WEST);
		tfNum2.setColumns(10);
		
		JPanel phonePanel4 = new JPanel();
		phonePanel3.add(phonePanel4, BorderLayout.EAST);
		phonePanel4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblP2 = new JLabel("-");
		phonePanel4.add(lblP2, BorderLayout.WEST);
		
		tfNum3 = new JTextField();
		phonePanel4.add(tfNum3, BorderLayout.CENTER);
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
