package kr.or.dgit.RentCar_Project.content;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UpdatePwContent extends JPanel {

	private TextFieldComponent confirmPwPanel;
	private TextFieldComponent nowPwPanel;
	private TextFieldComponent changePwPanel;
	private JPanel btnPanel;
	private JButton btnUpdate;
	private JButton btnExit;

	public JButton getBtnExit() {
		return btnExit;
	}
	
	public UpdatePwContent() {
		setLayout(new GridLayout(0, 1, 0, 5));

		nowPwPanel = new TextFieldComponent("현재 비밀번호");
		add(nowPwPanel);

		changePwPanel = new TextFieldComponent("변경할 비밀번호");
		add(changePwPanel);

		confirmPwPanel = new TextFieldComponent("비밀번호 확인");
		add(confirmPwPanel);

		btnPanel = new JPanel();
		add(btnPanel);
		btnPanel.setLayout(null);

		btnUpdate = new JButton("수정하기");
		btnUpdate.setBounds(93, 10, 129, 25);
		btnPanel.add(btnUpdate);

		btnExit = new JButton("나가기");
		btnExit.setBounds(240, 11, 129, 25);
		btnPanel.add(btnExit);

	}

	/*
	 * public Coffee getContent() {
	 * 
	 * return new Coffee(pCode, pName, pPrice, pTotal, pMargin); }
	 */

	public void setContent() {

	}

	public void isEmptyCheck() throws Exception {
		confirmPwPanel.isEmptyCheck();
		changePwPanel.isEmptyCheck();
		nowPwPanel.isEmptyCheck();

	}

	public void clear() {
		confirmPwPanel.setTextValue("");
		changePwPanel.setTextValue("");
		nowPwPanel.setTextValue("");

	}
}
