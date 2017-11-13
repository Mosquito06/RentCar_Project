package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.EmailTextFiedComponent;
import kr.or.dgit.RentCar_Project.component.PhoneTextFiedComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.service.UserGradeService;
import kr.or.dgit.RentCar_Project.service.UserService;

@SuppressWarnings("serial")
public class ClientManagerContent extends JPanel {
	
	private TextFieldComponent clientId;
	private TextFieldComponent clientCode;
	private TextFieldComponent clientName;
	private PhoneTextFiedComponent phoneNum;
	private ComboBoxComponent<UserGrade> comboUserCodeGrade;
	private ComboBoxComponent<User> comboUserCode;
	private EmailTextFiedComponent email;
	private RadioComponent gender;
	
	public ClientManagerContent() {
		setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(110, 19, 325, 55);
		searchPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new EmptyBorder(5, 5, 5, 5)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(searchPanel);
		searchPanel.setLayout(new BorderLayout(0, 0));
		
		comboUserCode = new ComboBoxComponent<>("고객 코드");
		searchPanel.add(comboUserCode, BorderLayout.CENTER);
		
		JButton btnOk = new JButton("확인");
		searchPanel.add(btnOk, BorderLayout.EAST);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(447, 26, 69, 22);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(447, 52, 69, 22);
		add(btnDelete);
		
		clientId = new TextFieldComponent("아이디");
		clientId.setBounds(12, 97, 278, 29);
		add(clientId);
		
		comboUserCodeGrade = new ComboBoxComponent<>("고객등급");
		comboUserCodeGrade.setBounds(272, 97, 305, 29);
		add(comboUserCodeGrade);
		
		clientCode = new TextFieldComponent("고객 코드");
		clientCode.setBounds(12, 148, 278, 29);
		add(clientCode);
		
		gender = new RadioComponent("성별", "남자", "여자");
		gender.setBounds(287, 148, 290, 29);
		add(gender);
		
		clientName = new TextFieldComponent("고객명");
		clientName.setBounds(12, 198, 278, 29);
		add(clientName);
		
		phoneNum = new PhoneTextFiedComponent("연락처");
		phoneNum.setBounds(183, 198, 394, 29);
		add(phoneNum);
		
		email = new EmailTextFiedComponent("이메일");
		email.setBounds(14, 244, 469, 29);
		add(email);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClearAll();
			}
		});
		btnCancel.setBounds(480, 283, 97, 23);
		add(btnCancel);
		
		setUserGradeComboBoxModel();
		setUserComboBoxModel();
	}
	
	public void setUserGradeComboBoxModel() {
		UserGradeService userGradeService = UserGradeService.getInstance();
		List<UserGrade> lists = userGradeService.selectUserGradeByAll();
		Vector<UserGrade> userGrade = new Vector<>();
		for(UserGrade ug:lists) {
			ug.setComboType(1);
			userGrade.add(ug);
		}
		
		comboUserCodeGrade.setComboBoxModel(userGrade);
	}
	public void setUserComboBoxModel() {
		UserService userService = UserService.getInstance();
		List<User> lists = userService.selectUserByAll();
		Vector<User> userCode = new Vector<>();
		for(User u:lists) {
			u.setComboType(1);
			userCode.add(u);
		}
		comboUserCode.setComboBoxModel(userCode);
		
	}
	public void setClearAll() {
		clientId.setTextValue("");
		clientCode.setTextValue("");
		clientName.setTextValue("");
		phoneNum.setTextValueClear();
		email.setEmailValueClear();
		gender.setSelect(true);
		comboUserCode.setComboBoxModelClear();
		comboUserCodeGrade.setComboBoxModelClear();
	}
}
