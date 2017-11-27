package kr.or.dgit.RentCar_Project.content;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.JPasswordFieldComponent;

public class UpdatePwContent extends JPanel {

	private JPasswordFieldComponent nowPwPanel;
	private JPasswordFieldComponent changePwPanel;
	private JPasswordFieldComponent confirmPwPanel;
	private JPanel btnPanel;
	private JButton btnUpdate;
	private JButton btnExit;

	public JPasswordFieldComponent getChangePwPanel() {
		return changePwPanel;
	}

	public JPasswordFieldComponent getNowPwPanel() {
		return nowPwPanel;
	}

	public JPasswordFieldComponent getConfirmPwPanel() {
		return confirmPwPanel;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public UpdatePwContent() {
		setLayout(new GridLayout(0, 1, 0, 5));

		nowPwPanel = new JPasswordFieldComponent("현재 비밀번호");
		add(nowPwPanel);

		changePwPanel = new JPasswordFieldComponent("변경할 비밀번호");
		add(changePwPanel);

		confirmPwPanel = new JPasswordFieldComponent("비밀번호 확인");
		add(confirmPwPanel);

		btnPanel = new JPanel();
		add(btnPanel);
		btnPanel.setLayout(null);

		btnUpdate = new JButton("수정하기");
		btnUpdate.setBounds(106, 10, 129, 25);
		btnPanel.add(btnUpdate);

		btnExit = new JButton("나가기");
		btnExit.setBounds(253, 11, 129, 25);
		btnPanel.add(btnExit);

	}

	public String getContent() {
		String changePw = changePwPanel.getTextValue();
		String confirmPw = confirmPwPanel.getTextValue();

		if (changePw.equals("") || confirmPw.equals("")) {
			return null;
		}

		if (changePw.equals(confirmPw)) {
			return changePw;
		}
		return null;
	}

	public boolean isEmptyCheck() {
		if (!nowPwPanel.isEmptyCheck() || !changePwPanel.isEmptyCheck() || !confirmPwPanel.isEmptyCheck()) {
			return false;
		}
		return true;

	}

	public void clear() {
		confirmPwPanel.setTextValue("");
		changePwPanel.setTextValue("");
		nowPwPanel.setTextValue("");

	}
}
