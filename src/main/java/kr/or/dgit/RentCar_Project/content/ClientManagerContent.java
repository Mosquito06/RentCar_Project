package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.EmailTextFiedComponent;
import kr.or.dgit.RentCar_Project.component.PhoneTextFiedComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.Gender;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.frame.AdminMain;
import kr.or.dgit.RentCar_Project.frame.AdminMainClientManagerUseList;
import kr.or.dgit.RentCar_Project.service.UserGradeService;
import kr.or.dgit.RentCar_Project.service.UserService;

@SuppressWarnings("serial")
public class ClientManagerContent extends JPanel implements ActionListener{
	
	private TextFieldComponent clientId;
	private TextFieldComponent clientCode;
	private TextFieldComponent clientName;
	private PhoneTextFiedComponent phoneNum;
	private ComboBoxComponent<UserGrade> comboUserCodeGrade;
	private ComboBoxComponent<User> comboUserCode;
	private EmailTextFiedComponent email;
	private RadioComponent gender;
	private ClientlListManagerContent clientListManager;
	private JButton btnOk;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel imgPanel;
	
	
	public void setClientListManager(ClientlListManagerContent clientListManager) {
		this.clientListManager = clientListManager;
	}

	public ClientManagerContent() {
		setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(310, 26, 354, 55);
		searchPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new EmptyBorder(5, 5, 5, 5)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(searchPanel);
		searchPanel.setLayout(new BorderLayout(0, 0));
		
		comboUserCode = new ComboBoxComponent<>("고객 코드");
		searchPanel.add(comboUserCode, BorderLayout.CENTER);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		searchPanel.add(btnOk, BorderLayout.EAST);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(680, 29, 69, 22);
		btnUpdate.addActionListener(this);
		add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.setBounds(680, 57, 69, 22);
		btnDelete.addActionListener(this);
		add(btnDelete);
		
		imgPanel = new JLabel();
		imgPanel.setBounds(12, 13, 251, 302);
		imgPanel.setHorizontalAlignment(SwingConstants.CENTER);
		add(imgPanel);
		
		clientId = new TextFieldComponent("아이디");
		clientId.setBounds(234, 95, 278, 29);
		add(clientId);
		
		comboUserCodeGrade = new ComboBoxComponent<>("고객등급");
		comboUserCodeGrade.setBounds(505, 95, 305, 29);
		add(comboUserCodeGrade);
		
		clientCode = new TextFieldComponent("고객 코드");
		clientCode.setBounds(234, 145, 278, 29);
		add(clientCode);
		
		gender = new RadioComponent("성별", "남자", "여자");
		gender.setBounds(531, 145, 290, 29);
		add(gender);
		
		clientName = new TextFieldComponent("고객명");
		clientName.setBounds(234, 195, 278, 29);
		add(clientName);
		
		phoneNum = new PhoneTextFiedComponent("연락처");
		phoneNum.setBounds(390, 195, 462, 29);
		add(phoneNum);
		
		email = new EmailTextFiedComponent("이메일");
		email.setBounds(253, 248, 469, 29);
		add(email);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if(clear==0) {
					setClearAll();
					setActive(false);
				}
			}
		});
		btnCancel.setBounds(815, 275, 97, 23);
		add(btnCancel);
		
		JButton btnUseList = new JButton("이용내역 조회");
		btnUseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainClientManagerUseList(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnUseList.setBounds(775, 44, 124, 23);
		add(btnUseList);
		
		setUserGradeComboBoxModel();
		setUserComboBoxModel();
		setActive(false);
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
			u.setComboType(0);
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
	
	public void setActive(boolean active) {
		
		clientId.getTextField().setEnabled(active);
		clientCode.getTextField().setEnabled(active);
		clientName.getTextField().setEnabled(active);
		phoneNum.setActive(active);
		comboUserCode.setEnabled(active);
		email.setActive(active);
	}
	public void gradeComboBoxSelected(String grade) {
		if(grade.equals("A")) {
			comboUserCodeGrade.getComboBox().setSelectedIndex(0);
		}else if(grade.equals("B")) {
			comboUserCodeGrade.getComboBox().setSelectedIndex(1);
		}else {
			comboUserCodeGrade.getComboBox().setSelectedIndex(2);
		}
		
	}
	public void  genderRadioSelected(String selected) {
		if(selected.equals("MALE")) {
			gender.setSelect(true);
		}else {
			gender.setSelect(false);
		}
		
	}
	public Gender getSelectedGender(String selectText) {
		if(selectText.equals("남자")) {
			return Gender.MALE;
		}else {
			return Gender.FEMALE;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		UserService userService = UserService.getInstance();
		int userCode = comboUserCode.getComboboxValue().getUserCode();
		if(e.getSource()==btnOk) {
			
			JOptionPane.showMessageDialog(null, "고객을 검색합니다.");
			setActive(true);
			
			User user  = comboUserCode.getComboboxValue();
			
			clientId.setTextValue(user.getId());
			clientCode.setTextValue(String.valueOf(user.getUserCode()));
			clientName.setTextValue(user.getUserName());
			phoneNum.setTextValueNum1(user.getPhone().substring(0,3));
			phoneNum.setTextValueNum2(user.getPhone().substring(4,8));
			phoneNum.setTextValueNum3(user.getPhone().substring(9));
			email.setTextValueId(user.getEmail().substring(0,user.getEmail().indexOf('@')));
			email.setTextValueEmailAddr(user.getEmail().substring(user.getEmail().indexOf('@')+1));
			gradeComboBoxSelected(user.getGrade().getGrade());
			genderRadioSelected(user.getGender().name());
			imgPanel.setIcon(new ImageIcon(user.getUserImg()));
			clientListManager.listClient.setFull(false);
			clientListManager.listClient.setUserCode(user);
			clientListManager.listClient.loadDate();
		}
		
		if(e.getSource()==btnUpdate) {
			int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "확인창",
					JOptionPane.OK_CANCEL_OPTION);
			if (update == 0) {
				String id = clientId.getTextValue();
				String userName = clientName.getTextValue();
				String phone = phoneNum.getTextValueNum1()+"-"+phoneNum.getTextValueNum2()+"-"+phoneNum.getTextValueNum3();
				String userEmail = email.getTextVauleId()+"@"+email.getTextValueEmailAddr();
				Gender userGender = getSelectedGender(gender.getSelectText());
				UserGrade userGrade = comboUserCodeGrade.getComboboxValue();
				userService.updateUser(new User(userCode, id, userName, phone, userEmail, userGender, userGrade));
				clientListManager.listClient.loadDate();
				setClearAll();
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
			
		}
		if(e.getSource()==btnDelete) {
			int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
			if (delete == 0) {
				userService.deleteUser(new User(userCode));
				clientListManager.listClient.loadDate();
				setClearAll();
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}
	}


}
