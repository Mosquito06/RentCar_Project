package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JButton;
import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.PhoneTextFiedComponent;
import kr.or.dgit.RentCar_Project.component.EmailTextFiedComponent;

public class ClientManagerContent extends JPanel {

	public ClientManagerContent() {
		setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(110, 19, 325, 55);
		searchPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new EmptyBorder(5, 5, 5, 5)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(searchPanel);
		searchPanel.setLayout(new BorderLayout(0, 0));
		
		TextFieldComponent searchPanel2 = new TextFieldComponent("고객코드");
		searchPanel.add(searchPanel2, BorderLayout.CENTER);
		
		JButton btnOk = new JButton("확인");
		searchPanel.add(btnOk, BorderLayout.EAST);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(447, 26, 69, 22);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(447, 52, 69, 22);
		add(btnDelete);
		
		TextFieldComponent idPanel = new TextFieldComponent("아이디");
		idPanel.setBounds(12, 97, 278, 29);
		add(idPanel);
		
		ComboBoxComponent cbGradePanel = new ComboBoxComponent("고객등급");
		cbGradePanel.setBounds(272, 97, 305, 29);
		add(cbGradePanel);
		
		TextFieldComponent clientCodePanel = new TextFieldComponent("고객 코드");
		clientCodePanel.setBounds(12, 148, 278, 29);
		add(clientCodePanel);
		
		RadioComponent radioComponent = new RadioComponent("성별", "남자", "여자");
		radioComponent.setBounds(287, 148, 290, 29);
		add(radioComponent);
		
		TextFieldComponent clientNamePanel = new TextFieldComponent("고객명");
		clientNamePanel.setBounds(12, 198, 278, 29);
		add(clientNamePanel);
		
		PhoneTextFiedComponent phonePanel = new PhoneTextFiedComponent("연락처");
		phonePanel.setBounds(183, 198, 394, 29);
		add(phonePanel);
		
		EmailTextFiedComponent emailPanel = new EmailTextFiedComponent("이메일");
		emailPanel.setBounds(14, 244, 469, 29);
		add(emailPanel);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(480, 283, 97, 23);
		add(btnCancel);

	}
}
