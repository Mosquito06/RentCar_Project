package kr.or.dgit.RentCar_Project.content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;

public class UpdateContent extends JPanel {

	
	private TextFieldComponent panelId;
	private TextFieldComponent panelPw;
	private TextFieldComponent panelName;
	private TextFieldComponent panelGrade;
	private TextFieldComponent panelPhone;
	private TextFieldComponent panelEmail;
	private RadioComponent panelRadio;

	public UpdateContent() {
		setLayout(new GridLayout(0, 1, 0, 5));
		
		panelName = new TextFieldComponent("이름");
		add(panelName);
		
		//panelRadio = new RadioComponent("성별");
		//add(panelRadio);
		
		panelEmail = new TextFieldComponent("이메일");
		add(panelEmail);
		
		panelId = new TextFieldComponent("아이디");
		add(panelId);
		
		panelPw = new TextFieldComponent("비밀번호");
		add(panelPw);
		
		panelGrade = new TextFieldComponent("고객등급");
		add(panelGrade);
		
		panelPhone = new TextFieldComponent("전화번호");
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
