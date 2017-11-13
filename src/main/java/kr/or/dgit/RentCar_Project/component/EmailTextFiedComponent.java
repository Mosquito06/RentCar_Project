package kr.or.dgit.RentCar_Project.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EmailTextFiedComponent extends JPanel {
	private JTextField tfEmailId;
	private JTextField tfEmailAddr;
	private JComboBox<String> cbEmailAddr;


	public EmailTextFiedComponent(String title) {
		setLayout(new BorderLayout(5, 0));
		
		JLabel lblEmail = new JLabel(title);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblEmail, BorderLayout.CENTER);
		
		JPanel emailPanel = new JPanel();
		add(emailPanel, BorderLayout.EAST);
		emailPanel.setLayout(new BorderLayout(0, 0));
		
		tfEmailId = new JTextField();
		emailPanel.add(tfEmailId, BorderLayout.WEST);
		tfEmailId.setColumns(10);
		
		JPanel emailPanel2 = new JPanel();
		emailPanel.add(emailPanel2, BorderLayout.EAST);
		emailPanel2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblE = new JLabel("@");
		emailPanel2.add(lblE, BorderLayout.WEST);
		
		JPanel emailPanel3 = new JPanel();
		emailPanel2.add(emailPanel3, BorderLayout.EAST);
		emailPanel3.setLayout(new BorderLayout(0, 0));
		
		tfEmailAddr = new JTextField();
		emailPanel3.add(tfEmailAddr, BorderLayout.WEST);
		tfEmailAddr.setColumns(10);
		
		cbEmailAddr = new JComboBox<>();
		
		cbEmailAddr.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(cbEmailAddr.getSelectedIndex()==0) {
					tfEmailAddr.setText("");
				}else {
					tfEmailAddr.setText((String) cbEmailAddr.getSelectedItem());
				}
			}
		});
		
		cbEmailAddr.addItem("직접입력");
		cbEmailAddr.addItem("naver.com");
		cbEmailAddr.addItem("gmail.com");
		cbEmailAddr.addItem("nate.com");
		cbEmailAddr.addItem("daum.net");
		
		emailPanel3.add(cbEmailAddr, BorderLayout.EAST);

	}
	
	public String getTextVauleId() {
		return tfEmailId.getText();
	}
	
	public String getTextValueEmailAddr() {
		return tfEmailAddr.getText();
	}
	
	public void setTextValueId(String value){
		tfEmailId.setText(value);
	}
	
	public void setTextValueEmailAddr(String value) {
		tfEmailAddr.setText(value);
	}
	
	public boolean isEmptyChech(){
		if(getTextVauleId().equals("")||getTextValueEmailAddr().equals("")) {
			tfEmailId.requestFocus();
			return false;
		}return true;
	}
	
	public void setEmailValueClear() {
		tfEmailId.setText("");
		tfEmailAddr.setText("");
		cbEmailAddr.setSelectedIndex(0);
	}
}
