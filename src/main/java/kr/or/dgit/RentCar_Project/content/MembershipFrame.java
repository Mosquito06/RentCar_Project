package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.xswingx.PromptSupport;

import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dao.UserDao;
import kr.or.dgit.RentCar_Project.dto.Gender;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.UserService;

@SuppressWarnings("serial")
public class MembershipFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfEmail1;
	private JTextField tfAddr;
	private JTextField tfAddr2;
	private JTextField tfEmail2;
	private JButton btnTest;
	private UserDao userDao = UserService.getInstance();
	private int idCheck = 1;
	private JPasswordField tfPw;
	private JPasswordField tfTestPw;
	private Boolean pw1Check = false;
	private Boolean pw2Check = false;
	private Boolean phone1Check = false;
	private Boolean phone2Check = false;
	private AddressFrame addr;
	
	
	public AddressFrame getAddr() {
		return addr;
	}

	public JTextField getTfAddr() {
		return tfAddr;
	}
	
	public MembershipFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 443, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uD68C\uC6D0\uAC00\uC785", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.BLACK));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		TextFieldComponent tfId = new TextFieldComponent("아이디");
		PromptSupport.setPrompt("아이디입력", tfId.getTextField());
		tfId.setBounds(3, 35, 231, 28);
		panel.add(tfId);

		TextFieldComponent tfName = new TextFieldComponent("성명");
		tfName.setBounds(3, 149, 231, 28);
		panel.add(tfName);

		RadioComponent genderRadio = new RadioComponent("성별", "남", "여");
		genderRadio.setBounds(17, 187, 248, 28);
		panel.add(genderRadio);

		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(9, 268, 340, 28);
		panel.add(phonePanel);
		phonePanel.setLayout(null);

		JLabel lblPhone = new JLabel("핸드폰");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(7, 0, 81, 28);
		phonePanel.add(lblPhone);

		tfNum1 = new JTextField();
		tfNum1.setBounds(180, 1, 55, 28);
		phonePanel.add(tfNum1);
		tfNum1.setHorizontalAlignment(SwingConstants.CENTER);
		tfNum1.setColumns(10);

		tfNum2 = new JTextField();
		tfNum2.setBounds(262, 1, 55, 28);
		phonePanel.add(tfNum2);
		tfNum2.setHorizontalAlignment(SwingConstants.CENTER);
		tfNum2.setColumns(10);

		String[] phoneArr = { "010", "011", "016", "017", "018", "019" };

		DefaultComboBoxModel<String> modelPhone = new DefaultComboBoxModel<>(phoneArr);
		JComboBox<String> comboPhone = new JComboBox<>(modelPhone);

		comboPhone.setBounds(94, 0, 60, 28);
		phonePanel.add(comboPhone);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setBounds(155, 0, 24, 28);
		phonePanel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label = new JLabel("-");
		label.setBounds(236, 0, 24, 28);
		phonePanel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(9, 310, 380, 28);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("이메일");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 0, 74, 28);
		panel_5.add(lblNewLabel_2);

		tfEmail1 = new JTextField();
		tfEmail1.setBounds(90, 1, 86, 28);
		panel_5.add(tfEmail1);
		tfEmail1.setColumns(10);

		String[] emailArr = { "직접입력", "naver.com", "gmail.com", "nate.com", "daum.net" };

		DefaultComboBoxModel<String> modelEmail = new DefaultComboBoxModel<>(emailArr);

		JComboBox<String> comboEmail = new JComboBox<>(modelEmail);

		comboEmail.setBounds(285, 0, 95, 28);
		panel_5.add(comboEmail);

		JLabel lblNewLabel_3 = new JLabel("@");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(174, 0, 25, 28);
		panel_5.add(lblNewLabel_3);

		tfEmail2 = new JTextField();
		tfEmail2.setColumns(10);
		tfEmail2.setBounds(197, 0, 86, 28);
		panel_5.add(tfEmail2);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(9, 354, 362, 59);
		panel.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("주소");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 89, 59);
		panel_6.add(lblNewLabel_4);

		tfAddr = new JTextField();
		tfAddr.setBounds(91, 0, 171, 28);
		tfAddr.setFocusable(false);
		panel_6.add(tfAddr);
		tfAddr.setColumns(10);

		tfAddr2 = new JTextField();
		tfAddr2.setColumns(10);
		tfAddr2.setBounds(91, 31, 259, 28);
		panel_6.add(tfAddr2);

		JButton btnAddr = new JButton("주소검색");
		btnAddr.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addr = new AddressFrame(MembershipFrame.this);
				addr.setVisible(true);
			}
		});
		btnAddr.setFont(new Font("굴림", Font.PLAIN, 11));
		btnAddr.setBounds(274, 0, 76, 28);
		panel_6.add(btnAddr);

		JButton btnAdd = new JButton("가입");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(66, 430, 108, 44);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(251, 430, 108, 44);
		panel.add(btnCancel);


		btnTest = new JButton("중복확인");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pattern p = Pattern.compile("(^[a-zA-Z0-9]{6,15}$)");
				Matcher m = p.matcher(tfId.getTextValue());

				if (!m.find()) {
					JOptionPane.showMessageDialog(null, "영문,숫자 6자리 이상 만 가능합니다.");
					tfId.getTextField().requestFocus();
					return;
				} 
				idCheck = 2;
				String Id = tfId.getTextValue();
				List<User> list = userDao.selectUserByAll();
				for (User u : list) {
					if (Id.equals(u.getId())) {
						idCheck = 1;
					}
				}

				if (idCheck == 2) {
					idCheck = JOptionPane.showConfirmDialog(null, "사용가능한 아이디 입니다. 사용하시겠습니까?", null,
							JOptionPane.YES_NO_OPTION);
					if (idCheck != 0) {
						tfId.getTextField().requestFocus();
						tfId.getTextField().setEnabled(true);
						idCheck = 2;
					} else {
						tfId.getTextField().setEnabled(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다.");
					tfId.getTextField().requestFocus();
				}
			}
		});

		tfId.getTextField().addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tfId.getTextField().setText("");
			}
		});

		btnTest.setFont(new Font("굴림", Font.PLAIN, 11));
		btnTest.setBounds(242, 35, 76, 28);
		panel.add(btnTest);

		JLabel lblPw = new JLabel("불가능한 비밀번호입니다");
		lblPw.setForeground(Color.RED);
		lblPw.setFont(new Font("굴림", Font.PLAIN, 11));
		lblPw.setBounds(238, 73, 151, 28);
		panel.add(lblPw);

		JLabel lblTestPw = new JLabel("불일치합니다");
		lblTestPw.setForeground(Color.RED);
		lblTestPw.setFont(new Font("굴림", Font.PLAIN, 11));
		lblTestPw.setBounds(238, 111, 151, 28);
		panel.add(lblTestPw);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(16, 225, 333, 28);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("생년월일");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 85, 28);
		panel_3.add(lblNewLabel_6);

		Vector<String> yearArr = new Vector<>();
		for (int i = 1997; i > 1900; i--) {
			yearArr.addElement(i + "");
		}

		DefaultComboBoxModel<String> modelYear = new DefaultComboBoxModel<>(yearArr);

		JComboBox<String> comboYear = new JComboBox<>(modelYear);

		comboYear.setBounds(87, 0, 65, 28);
		panel_3.add(comboYear);

		JLabel lblNewLabel_7 = new JLabel("년");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(155, 0, 17, 28);
		panel_3.add(lblNewLabel_7);

		Vector<String> monthArr = new Vector<>();
		for (int i = 1; i < 13; i++) {
			monthArr.addElement(i + "");
		}

		DefaultComboBoxModel<String> modelMonth = new DefaultComboBoxModel<>(monthArr);

		JComboBox<String> comboMonth = new JComboBox<>(modelMonth);
		comboMonth.setBounds(180, 0, 50, 28);
		panel_3.add(comboMonth);

		Vector<String> dayArr = new Vector<>();
		for (int i = 1; i < 32; i++) {
			dayArr.addElement(i + "");
		}

		DefaultComboBoxModel<String> modelDay = new DefaultComboBoxModel<>(dayArr);

		JComboBox<String> comboDay = new JComboBox<>(modelDay);
		comboDay.setBounds(253, 0, 50, 28);
		panel_3.add(comboDay);

		JLabel label_1 = new JLabel("월");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(234, 0, 17, 28);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("일");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(304, 0, 17, 28);
		panel_3.add(label_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(3, 73, 231, 28);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setBounds(0, 0, 115, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);

		tfPw = new JPasswordField();
		tfPw.setBounds(118, 0, 113, 28);
		panel_1.add(tfPw);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(3, 111, 231, 28);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("비밀번호확인");
		lblNewLabel_5.setBounds(0, 0, 115, 28);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_5);

		tfTestPw = new JPasswordField();
		tfTestPw.setBounds(118, 0, 113, 28);
		panel_2.add(tfTestPw);
		PromptSupport.setPrompt("영문,숫자8자리이상", tfPw);
		PromptSupport.setPrompt("영문,숫자8자리이상", tfTestPw);
		PromptSupport.setPrompt("ex)exam.com", tfEmail2);
		PromptSupport.setPrompt("주소검색 클릭", tfAddr);
		PromptSupport.setPrompt("상세주소 입력", tfAddr2);
		

		tfPw.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tfPw.setText("");
				lblPw.setForeground(new Color(250, 0, 0));
				lblPw.setText("불가능한 비밀번호입니다");
				pw1Check = false;
			}
		});

		tfTestPw.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tfTestPw.setText("");
				lblTestPw.setForeground(new Color(250, 0, 0));
				lblTestPw.setText("불일치합니다");
				pw2Check = false;
			}
		});

		tfPw.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// 비밀번호 정규표현식
				Pattern p = Pattern.compile("(^[a-zA-Z0-9!@#$%^&*()]{8,15}$)");
				Matcher m = p.matcher(tfPw.getText());

				if (m.find()) {
					lblPw.setForeground(new Color(0, 0, 0));
					lblPw.setText("사용 가능한 비밀번호입니다");
					pw1Check = true;
				} else {
					lblPw.setForeground(new Color(250, 0, 0));
					lblPw.setText("불가능한 비밀번호입니다");
					pw1Check = false;
				}
			}

		});

		tfTestPw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (tfPw.getText().equals(tfTestPw.getText())) {
					lblTestPw.setForeground(new Color(0, 0, 0));
					lblTestPw.setText("일치합니다");
					pw2Check = true;
				} else {
					lblTestPw.setForeground(new Color(250, 0, 0));
					lblTestPw.setText("불일치합니다");
					pw2Check = false;
				}
			}
		});

		comboPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum1.requestFocus();
			}
		});

		tfName.getTextField().addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tfName.getTextField().setText("");
			}
		});

		tfNum1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Pattern p = Pattern.compile("(^[0-9]{3,4}$)");
				Matcher m = p.matcher(tfNum1.getText());

				if (m.find()) {
					phone1Check = true;
				} else {
					phone1Check = false;
				}

				if (tfNum1.getText().length() >= 4) {
					tfNum2.requestFocus();

				}
			}
		});

		tfNum1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tfNum1.setText("");
				phone1Check = false;
			}
		});

		tfNum2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Pattern p = Pattern.compile("(^[0-9]{4}$)");
				Matcher m = p.matcher(tfNum2.getText());

				if (m.find()) {
					phone2Check = true;
				} else {
					phone2Check = false;
				}

				if (tfNum2.getText().length() == 4) {
					tfEmail1.requestFocus();

				}
			}
		});

		tfNum2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tfNum2.setText("");
				phone2Check = false;
			}
		});

		tfEmail1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tfEmail1.setText("");
				comboEmail.setSelectedIndex(0);
			}
		});

		tfEmail2.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				tfEmail2.setText("");
				comboEmail.setSelectedIndex(0);
			}
		});

		comboEmail.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object obj = comboEmail.getSelectedItem();
				if (!obj.equals("직접입력")) {
					tfEmail2.setText(String.valueOf(obj));
					tfEmail2.setEnabled(false);
				} else {
					tfEmail2.setText("");
					tfEmail2.setEnabled(true);
					tfEmail2.requestFocus();
				}
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UserDao userDao = UserService.getInstance();
				if (idCheck != 0) {
					JOptionPane.showMessageDialog(null, "아이디를 정확하게 입력하세요");
					tfId.getTextField().requestFocus();
					return;
				}
				if (!(pw1Check && pw2Check)) {
					JOptionPane.showMessageDialog(null, "비밀번호를 정확하게 입력하세요");
					tfPw.requestFocus();
					tfTestPw.setText("");
					return;
				}

				Pattern p = Pattern.compile("(^[a-zA-Z가-힣]{1,15}$)");
				Matcher m = p.matcher(tfName.getTextValue());
				if (!m.find()) {
					JOptionPane.showMessageDialog(null, "성명을 정확하게 입력하세요");
					tfName.getTextField().requestFocus();
					return;
				}

				if (!(phone1Check && phone2Check)) {
					JOptionPane.showMessageDialog(null, "연락처를 정확하게 입력하세요");
					tfNum1.requestFocus();
					tfNum2.setText("");
					return;
				}
				p = Pattern.compile("(^[a-zA-Z0-9]{1,15}$)");
				m = p.matcher(tfEmail1.getText());
				if (!m.find()) {
					JOptionPane.showMessageDialog(null, "이메일를 정확하게 입력하세요");
					tfEmail1.requestFocus();
					return;
				}
				
				p = Pattern.compile("(^[a-zA-Z0-9.]{1,15}$)");
				m = p.matcher(tfEmail2.getText());
				if(tfEmail1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "이메일를 정확하게 입력하세요");
					tfEmail1.setText("");
					return;
				}
				if (!m.find()) {
					JOptionPane.showMessageDialog(null, "이메일를 정확하게 입력하세요");
					tfEmail2.requestFocus();
					return;
				}
				if(tfAddr.getText().equals("")||tfAddr2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "주소를 정확하게 입력하세요");
					
					return;
				}
				
				
				String id = tfId.getTextValue();
				String pw = tfPw.getText();
				String userName = tfName.getTextValue();
				String phone = comboPhone.getSelectedItem() + "-" + tfNum1.getText() + "-" + tfNum2.getText();
				String email = tfEmail1.getText() + "@" + tfEmail2.getText();
				Gender gender;
				if (genderRadio.getSelectText().equals("남")) {
					gender = Gender.MALE;
				} else {
					gender = Gender.FEMALE;
				}

				User user = new User(id, pw, userName, phone, email, gender);
				userDao.insertUser(user);

				JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
				setVisible(false);
			}
		});

	}

}
