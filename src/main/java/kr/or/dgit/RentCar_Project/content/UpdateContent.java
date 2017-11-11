package kr.or.dgit.RentCar_Project.content;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.component.PhoneTextFiedComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.Gender;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.dto.UserGrade;

public class UpdateContent extends JPanel {

	private TextFieldComponent panelId;
	private TextFieldComponent panelName;
	private TextFieldComponent panelGrade;
	private PhoneTextFiedComponent panelInPhone;
	private TextFieldComponent panelEmail;
	private RadioComponent panelRadio;
	private JPanel btnPanel;
	private JButton btnUpdate;
	private JPanel panelOutPhone;

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

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
		lblNewLabel.setBounds(0, 0, 228, 38);
		panelRadio.add(lblNewLabel);

		panelEmail = new TextFieldComponent("이메일");
		add(panelEmail);

		panelId = new TextFieldComponent("아이디");
		panelId.setEnable(false);
		add(panelId);

		panelGrade = new TextFieldComponent("고객등급");
		panelGrade.setEnable(false);
		add(panelGrade);

		panelOutPhone = new JPanel();
		add(panelOutPhone);
		panelOutPhone.setLayout(null);

		panelInPhone = new PhoneTextFiedComponent("전화번호");
		GridLayout gl_panelInPhone = (GridLayout) panelInPhone.getLayout();
		gl_panelInPhone.setHgap(113);
		panelInPhone.setBounds(-48, 0, 486, 42);
		panelOutPhone.add(panelInPhone);

		btnPanel = new JPanel();
		add(btnPanel);
		btnPanel.setLayout(null);

		btnUpdate = new JButton("수정하기");
		btnUpdate.setBounds(162, 10, 129, 25);
		btnPanel.add(btnUpdate);

	}

	public User getContent() {
		
		// 성별 값 가져오기
		Gender genderValue = null;
		String selectGender = panelRadio.getSelectText();
		if(selectGender.equals("남")) {
			genderValue = Gender.MALE;
		}else {
			genderValue = Gender.FEMALE;
		}
			
		// 유저 등급 가져오기
		UserGrade userGrade = new UserGrade();
		userGrade.setGrade(panelGrade.getTextValue());
		
		// 전화번호 가져오기
		String num1 = panelInPhone.getTextValueNum1();
		String num2 = panelInPhone.getTextValueNum2();
		String num3 = panelInPhone.getTextValueNum3();
		String Phone = num1 + "- " + num2 + "- " + num3;
		
		return new User(1, panelId.getTextValue(), null, panelName.getTextValue(), null, Phone,
				panelEmail.getTextValue(), genderValue, userGrade);
	}

	public void setContent(User user) {
		panelId.setTextValue(user.getId());
		panelName.setTextValue(user.getUserName());
		panelEmail.setTextValue(user.getEmail());
		panelGrade.setTextValue(user.getGrade().getGrade());
		
		// 성별 세팅
		if(user.getGender().equals(Gender.MALE)) {
			panelRadio.setSelect(true);
		}else {
			panelRadio.setSelect(false);
		}
					
		// 전화번호 세팅
		String[] StringNum = user.getPhone().split("-");
		panelInPhone.setTextValueNum1(StringNum[0]);
		panelInPhone.setTextValueNum2(StringNum[1]);
		panelInPhone.setTextValueNum3(StringNum[2]);
		
		
	}

	public void isEmptyCheck() throws Exception {
		panelId.isEmptyCheck();
		panelName.isEmptyCheck();
		panelEmail.isEmptyCheck();
		panelGrade.isEmptyCheck();
		panelInPhone.isEmptyCheck();
	}

	public void clear() {
		panelId.setTextValue("");
		panelName.setTextValue("");
		panelGrade.setTextValue("");
		panelEmail.setTextValue("");
		panelInPhone.setTextValueNum1("");
		panelInPhone.setTextValueNum1("");
		panelInPhone.setTextValueNum1("");
	}
}
