package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import kr.or.dgit.RentCar_Project.frame.AdminMainClientGradeManager;
import kr.or.dgit.RentCar_Project.frame.AdminMainClientManagerUserList;
import kr.or.dgit.RentCar_Project.service.UserGradeService;
import kr.or.dgit.RentCar_Project.service.UserService;

@SuppressWarnings("serial")
public class ClientManagerContent extends JPanel implements ActionListener {

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
	private JButton btnUseList;
	private JPanel addrPanel;
	private JTextField tfAddr;

	public void setClientListManager(ClientlListManagerContent clientListManager) {
		this.clientListManager = clientListManager;
	}

	public ClientManagerContent() {

		setBounds(100, 100, 954, 362);
		setLayout(null);

		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(314, 33, 354, 55);
		searchPanel.setBorder(new TitledBorder(
				new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new EmptyBorder(5, 5, 5, 5)),
				" \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		imgPanel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\readyImg.png"));

		clientId = new TextFieldComponent("아이디");
		clientId.setBounds(234, 115, 278, 29);
		clientId.setEnable(false);
		add(clientId);

		comboUserCodeGrade = new ComboBoxComponent<>("고객등급");
		comboUserCodeGrade.setBounds(517, 115, 305, 29);
		add(comboUserCodeGrade);

		clientCode = new TextFieldComponent("고객 코드");
		clientCode.setBounds(234, 165, 278, 29);
		add(clientCode);
		clientCode.setEnable(false);

		gender = new RadioComponent("성별", "남자", "여자");
		gender.setBounds(547, 165, 290, 29);
		add(gender);

		clientName = new TextFieldComponent("고객명");
		clientName.setBounds(234, 210, 278, 29);
		add(clientName);

		phoneNum = new PhoneTextFiedComponent("연락처");
		phoneNum.setBounds(408, 210, 462, 29);
		add(phoneNum);

		email = new EmailTextFiedComponent("이메일");
		email.setBounds(249, 310, 469, 29);
		add(email);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "Message",
						JOptionPane.YES_NO_OPTION);
				if (clear == 0) {
					setClearAll();
					setActive(false);
				}
			}
		});
		btnCancel.setBounds(841, 337, 97, 23);
		add(btnCancel);

		btnUseList = new JButton("이용내역 조회");
		btnUseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AdminMainClientManagerUserList frame = new AdminMainClientManagerUserList(
									comboUserCode.getComboboxValue());
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnUseList.setBounds(814, 40, 124, 23);
		add(btnUseList);

		addrPanel = new JPanel();
		addrPanel.setBounds(284, 260, 553, 29);
		add(addrPanel);
		addrPanel.setLayout(new BorderLayout(68, 0));

		JLabel lblAddr = new JLabel("주소");
		addrPanel.add(lblAddr, BorderLayout.WEST);

		tfAddr = new JTextField();
		addrPanel.add(tfAddr, BorderLayout.CENTER);
		tfAddr.setColumns(10);
		tfAddr.setEnabled(false);

		JButton btnGrade = new JButton("등급관리");
		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AdminMainClientGradeManager frame = new AdminMainClientGradeManager(comboUserCodeGrade);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnGrade.setBounds(850, 63, 88, 22);
		add(btnGrade);

		setUserGradeComboBoxModel();
		setUserComboBoxModel();
		setActive(false);

		phoneNum.getTfNum1().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (phoneNum.getTfNum1().getText().length() >= 3) {
					phoneNum.getTfNum2().requestFocus();
				}
			}

		});

		phoneNum.getTfNum2().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (phoneNum.getTfNum2().getText().length() >= 4) {
					phoneNum.getTfNum3().requestFocus();
				}
			}

		});
	}

	public ComboBoxComponent<User> getComboUserCode() {
		return comboUserCode;
	}

	public ComboBoxComponent<UserGrade> getComboUserCodeGrade() {
		return comboUserCodeGrade;
	}

	public void setUserGradeComboBoxModel() {
		UserGradeService userGradeService = UserGradeService.getInstance();
		List<UserGrade> lists = userGradeService.selectUserGradeByAll();
		Vector<UserGrade> userGrade = new Vector<>();
		for (UserGrade ug : lists) {
			ug.setComboType(1);
			userGrade.add(ug);
		}

		comboUserCodeGrade.setComboBoxModel(userGrade);
	}

	public void setUserComboBoxModel() {
		List<User> lists = UserService.getInstance().selectUserByAll();

		User user = new User();
		user.setUserCode(0);
		user.setUserName("선택하세요");
		lists.add(0, user);

		Vector<User> userCode = new Vector<>();
		for (User u : lists) {
			u.setComboType(2);
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
		tfAddr.setText("");
		imgPanel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\readyImg.png"));

	}

	public void setActive(boolean active) {
		clientName.getTextField().setEnabled(active);
		phoneNum.setActive(active);
		comboUserCode.setEnabled(active);
		email.setActive(active);
		btnUpdate.setEnabled(active);
		btnDelete.setEnabled(active);
		btnUseList.setEnabled(active);
	}

	public Gender getSelectedGender(String selectText) {
		if (selectText.equals("남자")) {
			return Gender.MALE;
		} else {
			return Gender.FEMALE;
		}

	}

	public int gradeComboSelected(User uc) {
		for (int i = 0; i < comboUserCodeGrade.getComboBox().getItemCount(); i++) {
			UserGrade u = comboUserCodeGrade.getComboBox().getItemAt(i);
			if (u.toString().equals(uc.getGrade().getGrade())) {
				return i;
			}
		}
		return 0;
	}

	public boolean isEmptyCheck() {
		if (clientName.isEmptyCheck() && phoneNum.isEmptyCheck() && email.isEmptyCheck()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean genderSelected(Gender gender) {
		if (gender.name().equals("MALE")) {
			return true;
		} else {
			return false;
		}

	}

	private boolean isNameOk() {
		Pattern p = Pattern.compile("(^[a-zA-Z가-힣]{1,15}$)");
		Matcher m = p.matcher(clientName.getTextValue());
		
		if (m.find()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "이름은 영문,한글만 가능합니다");
			clientName.setTextValue("");
			clientName.getTextField().requestFocus();
			return false;
		}
	}

	private boolean isPhoneNum1Ok() {
		Pattern p = Pattern.compile("(^[0-9]{3}$)");
		Matcher m = p.matcher(phoneNum.getTextValueNum1());
		if (m.find()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "숫자만 가능합니다");
			phoneNum.getTfNum1().setText("");
			phoneNum.getTfNum1().requestFocus();
			return false;
		}
	}

	private boolean isPhoneNum2Ok() {
		Pattern p = Pattern.compile("(^[0-9]{3,4}$)");
		Matcher m = p.matcher(phoneNum.getTextValueNum2());
		if (m.find()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "숫자만 가능합니다");
			phoneNum.getTfNum2().setText("");
			phoneNum.getTfNum2().requestFocus();
			return false;
		}
	}

	private boolean isEmail1Ok() {
		Pattern p = Pattern.compile("(^[a-zA-Z0-9]{1,15}$)");
		Matcher m = p.matcher(email.getTfEmailId().getText());
		if (m.find()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "이메일를 정확하게 입력하세요");
			email.getTfEmailId().requestFocus();
			return false;
		}
	}

	private boolean isPhoneNum3Ok() {
		Pattern p = Pattern.compile("(^[0-9]{4}$)");
		Matcher m = p.matcher(phoneNum.getTextValueNum3());
		if (m.find()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "숫자만 가능합니다");
			phoneNum.getTfNum3().setText("");
			phoneNum.getTfNum3().requestFocus();
			return false;
		}
	}

	private boolean isEmail2Ok() {
		Pattern p = Pattern.compile("(^[a-zA-Z0-9.]{1,15}$)");
		Matcher m = p.matcher(email.getTfEmailAddr().getText());
		if (m.find()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "이메일를 정확하게 입력하세요");
			email.getTfEmailAddr().requestFocus();
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		UserService userService = UserService.getInstance();
		User userCode = comboUserCode.getComboboxValue();
		User uc = userService.selectUserByUserCode(userCode);
		int code = comboUserCode.getComboboxValue().getUserCode();

		if (e.getSource() == btnOk) {

			if (comboUserCode.getComboBox().getSelectedIndex() != 0) {
				JOptionPane.showMessageDialog(null, "고객을 검색합니다.");
				setActive(true);
				searchUser(userCode, uc);
			} else {
				JOptionPane.showMessageDialog(null, "검색창을 선택하세요");
				clientListManager.listClient.setFull(true);
				clientListManager.listClient.loadDate();
				setClearAll();
				setActive(false);
				return;
			}

		}

		if (e.getSource() == btnUpdate) {
			if (!isEmptyCheck()) {
				if (isNameOk()) {
					if (isPhoneNum1Ok()) {
						if (isPhoneNum2Ok()) {
							if (isPhoneNum3Ok()) {
								if (isEmail1Ok()) {
									if (isEmail2Ok()) {
										int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "Message",
												JOptionPane.YES_NO_OPTION);
										if (update == 0) {
											updateUser(userService, code);
											JOptionPane.showMessageDialog(null, "수정되었습니다.");
											setClearAll();
											setActive(false);
										} else {
											JOptionPane.showMessageDialog(null, "취소되었습니다");
										}
									} else {return;}
								} else {return;}
							} else {return;}
						} else {return;}
					} else {return;}
				} else {return;}
			} else {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다");
				requestFoucsTF();
				return;
			}

		}
		if (e.getSource() == btnDelete) {
			if (!isEmptyCheck()) {
				if (isNameOk()) {
					if (isPhoneNum1Ok()) {
						if (isPhoneNum2Ok()) {
							if (isPhoneNum3Ok()) {
								if (isEmail1Ok()) {
									if (isEmail2Ok()) {
										int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "Message",
												JOptionPane.YES_NO_OPTION);
										if (delete == 0) {
											userService.deleteUser(new User(code));
											clientListManager.listClient.loadDate();
											setClearAll();
											setActive(false);
										} else {
											JOptionPane.showMessageDialog(null, "취소되었습니다");
										}
									}else {return;}
								}else {return;}
							}else {return;}
						}else {return;}
					}else {return;}
				}else {return;}
			} else {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다");
				requestFoucsTF();
				return;
			}

		}
	}

	private void requestFoucsTF() {
		if (clientName.getTextValue().equals("")) {
			clientName.getTextField().requestFocus();
		} else if (phoneNum.getTextValueNum1().equals("")) {
			phoneNum.getTfNum1().requestFocus();
		} else if (phoneNum.getTextValueNum2().equals("")) {
			phoneNum.getTfNum2().requestFocus();
		} else if (phoneNum.getTextValueNum3().equals("")) {
			phoneNum.getTfNum3().requestFocus();
		} else if (email.getTextVauleId().equals("")) {
			email.getTfEmailId().requestFocus();
		} else if (email.getTextValueEmailAddr().equals("")) {
			email.getTfEmailAddr().requestFocus();
		}
	}

	private void updateUser(UserService userService, int code) {
		String id = clientId.getTextValue();
		String userName = clientName.getTextValue();
		String phone = phoneNum.getTextValueNum1() + "-" + phoneNum.getTextValueNum2() + "-"
				+ phoneNum.getTextValueNum3();
		String userEmail = email.getTextVauleId() + "@" + email.getTextValueEmailAddr();
		Gender userGender = getSelectedGender(gender.getSelectText());
		UserGrade userGrade = comboUserCodeGrade.getComboboxValue();
		userService.updateUser(new User(code, id, userName, phone, userEmail, userGender, userGrade));
		clientListManager.listClient.loadDate();
	}

	private void searchUser(User userCode, User uc) {
		clientId.setTextValue(uc.getId());
		clientCode.setTextValue(String.valueOf(uc.getUserCode()));
		clientName.setTextValue(uc.getUserName());
		phoneNum.setTextValueNum1(uc.getPhone().substring(0, 3));
		phoneNum.setTextValueNum2(uc.getPhone().substring(4, 8));
		phoneNum.setTextValueNum3(uc.getPhone().substring(9));
		email.setTextValueId(uc.getEmail().substring(0, uc.getEmail().indexOf('@')));
		email.setTextValueEmailAddr(uc.getEmail().substring(uc.getEmail().indexOf('@') + 1));
		comboUserCodeGrade.getComboBox().setSelectedIndex(gradeComboSelected(uc));
		imgPanel.setIcon(new ImageIcon(uc.getUserImg()));
		gender.setSelect(genderSelected(uc.getGender()));
		tfAddr.setText(uc.getAddr());
		clientListManager.listClient.setFull(false);
		clientListManager.listClient.setUserCode(userCode);
		clientListManager.listClient.loadDate();
	}

}
