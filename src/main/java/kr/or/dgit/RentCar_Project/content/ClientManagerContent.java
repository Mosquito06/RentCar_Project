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
		searchPanel.setBounds(314, 33, 354, 55);
		searchPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new EmptyBorder(5, 5, 5, 5)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(searchPanel);
		searchPanel.setLayout(new BorderLayout(0, 0));
		
		comboUserCode = new ComboBoxComponent<>("고객 코드");
		searchPanel.add(comboUserCode, BorderLayout.CENTER);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		searchPanel.add(btnOk, BorderLayout.EAST);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(680, 40, 69, 22);
		btnUpdate.addActionListener(this);
		add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.setBounds(680, 63, 69, 22);
		btnDelete.addActionListener(this);
		add(btnDelete);
		
		imgPanel = new JLabel();
		imgPanel.setBounds(5, 10, 264, 371);
		add(imgPanel);
		
		clientId = new TextFieldComponent("아이디");
		clientId.setBounds(234, 115, 278, 29);
		add(clientId);
		
		comboUserCodeGrade = new ComboBoxComponent<>("고객등급");
		comboUserCodeGrade.setBounds(517, 115, 305, 29);
		add(comboUserCodeGrade);
		
		clientCode = new TextFieldComponent("고객 코드");
		clientCode.setBounds(234, 175, 278, 29);
		add(clientCode);
		
		gender = new RadioComponent("성별", "남자", "여자");
		gender.setBounds(545, 175, 290, 29);
		add(gender);
		
		clientName = new TextFieldComponent("고객명");
		clientName.setBounds(234, 235, 278, 29);
		add(clientName);
		
		phoneNum = new PhoneTextFiedComponent("연락처");
		phoneNum.setBounds(406, 235, 462, 29);
		add(phoneNum);
		
		email = new EmailTextFiedComponent("이메일");
		email.setBounds(244, 295, 469, 29);
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
		btnCancel.setBounds(814, 337, 97, 23);
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

	public Gender getSelectedGender(String selectText) {
		if(selectText.equals("남자")) {
			return Gender.MALE;
		}else {
			return Gender.FEMALE;
		}
		
	}
	
	public int gradeComboSelected(User uc) {
		for(int i=0;i<comboUserCodeGrade.getComboBox().getItemCount();i++) {
			UserGrade u = comboUserCodeGrade.getComboBox().getItemAt(i);
			if(u.toString().equals(uc.getGrade().getGrade())) {
				return i;
			}
		}
		return 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		UserService userService = UserService.getInstance();
		User userCode = comboUserCode.getComboboxValue();
		User uc = userService.selectUserByUserCode(userCode);
		int code = comboUserCode.getComboboxValue().getUserCode();
		
		if(e.getSource()==btnOk) {
			
			JOptionPane.showMessageDialog(null, "고객을 검색합니다.");
			setActive(true);
			
			User user  = comboUserCode.getComboboxValue();
			
			clientId.setTextValue(uc.getId());
			clientCode.setTextValue(String.valueOf(uc.getUserCode()));
			clientName.setTextValue(uc.getUserName());
			phoneNum.setTextValueNum1(uc.getPhone().substring(0,3));
			phoneNum.setTextValueNum2(uc.getPhone().substring(4,8));
			phoneNum.setTextValueNum3(uc.getPhone().substring(9));
			email.setTextValueId(uc.getEmail().substring(0,uc.getEmail().indexOf('@')));
			email.setTextValueEmailAddr(uc.getEmail().substring(uc.getEmail().indexOf('@')+1));
			comboUserCodeGrade.getComboBox().setSelectedIndex(gradeComboSelected(uc));
			imgPanel.setIcon(new ImageIcon(uc.getUserImg()));
			gender.setSelect(genderSelected(uc.getGender()));
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
				userService.updateUser(new User(code, id, userName, phone, userEmail, userGender, userGrade));
				clientListManager.listClient.loadDate();
				setClearAll();
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
			
		}
		if(e.getSource()==btnDelete) {
			int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
			if (delete == 0) {
				userService.deleteUser(new User(code));
				clientListManager.listClient.loadDate();
				setClearAll();
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}
	}

	public boolean genderSelected(Gender gender) {
		if(gender.name().equals("MALE")) {
			return true;
		}else {
			return false;
		}
		
	}

	


}
