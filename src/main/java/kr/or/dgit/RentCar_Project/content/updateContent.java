package kr.or.dgit.RentCar_Project.content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import common.radioComponent;
import kr.or.dgit.RentCar_Project.component.textFieldComponent;

public class updateContent extends JPanel {

	
	private textFieldComponent panelId;
	private textFieldComponent panelPw;
	private textFieldComponent panelName;
	private textFieldComponent panelGrade;
	private textFieldComponent panelPhone;
	private textFieldComponent panelEmail;
	private radioComponent panelRadio;

	public updateContent() {
		setLayout(new GridLayout(0, 1, 0, 5));
		
		panelName = new textFieldComponent("이름");
		add(panelName);
		
		panelRadio = new radioComponent("성별");
		add(panelRadio);
		
		panelEmail = new textFieldComponent("이메일");
		add(panelEmail);
		
		panelId = new textFieldComponent("아이디");
		add(panelId);
		
		panelPw = new textFieldComponent("비밀번호");
		add(panelPw);
		
		panelGrade = new textFieldComponent("고객등급");
		add(panelGrade);
		
		panelPhone = new textFieldComponent("전화번호");
		add(panelPhone);
		
		
		
		
	}
	
	/*public Coffee getContent() {
		
		return new Coffee(pCode, pName, pPrice, pTotal, pMargin);
	}*/

	public void setContent() {
		

	}

	public void isEmptyCheck() throws Exception {
		panelId.isEmptyCheck();
		panelPw.isEmptyCheck();
		panelName.isEmptyCheck();
		panelGrade.isEmptyCheck();
		panelPhone.isEmptyCheck();
	}

	public void clear() {
		panelId.setTextValue("");
		panelPw.setTextValue("");
		panelName.setTextValue("");
		panelGrade.setTextValue("");
		panelPhone.setTextValue("");
	}

}
