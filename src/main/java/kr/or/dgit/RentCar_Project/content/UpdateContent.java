package kr.or.dgit.RentCar_Project.content;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UpdateContent extends JPanel {

	private TextFieldComponent panelId;
	private TextFieldComponent panelName;
	private TextFieldComponent panelGrade;
	private TextFieldComponent panelPhone;
	private TextFieldComponent panelEmail;
	private RadioComponent panelRadio;
	private JPanel btnPanel;
	private JButton btnUpdate;

	public UpdateContent() {
		setLayout(new GridLayout(0, 1, 0, 5));

		panelName = new TextFieldComponent("이름");
		add(panelName);
		
		panelRadio = new RadioComponent("성별", "남", "여");
		panelRadio.getRdbtnRight().setBounds(345, -1, 74, 38);
		panelRadio.getRdbtnLeft().setBounds(254, 0, 83, 38);
		add(panelRadio);
		panelRadio.setLayout(null);
				
		JLabel lblNewLabel = new JLabel("성별");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 230, 38);
		panelRadio.add(lblNewLabel);

		panelEmail = new TextFieldComponent("이메일");
		add(panelEmail);

		panelId = new TextFieldComponent("아이디");
		add(panelId);

		panelGrade = new TextFieldComponent("고객등급");
		add(panelGrade);

		panelPhone = new TextFieldComponent("전화번호");
		add(panelPhone);
		
		btnPanel = new JPanel();
		add(btnPanel);
		btnPanel.setLayout(null);

		btnUpdate = new JButton("수정하기");
		btnUpdate.setBounds(162, 10, 129, 25);
		btnPanel.add(btnUpdate);

	}

	/*
	 * public Coffee getContent() {
	 * 
	 * return new Coffee(pCode, pName, pPrice, pTotal, pMargin); }
	 */

	public void setContent() {

	}

	public void isEmptyCheck() throws Exception {
		panelId.isEmptyCheck();
		panelName.isEmptyCheck();
		panelGrade.isEmptyCheck();
		panelPhone.isEmptyCheck();
	}

	public void clear() {
		panelId.setTextValue("");
		panelName.setTextValue("");
		panelGrade.setTextValue("");
		panelPhone.setTextValue("");
	}
}
