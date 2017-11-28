package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.service.UserService;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.GridLayout;

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
	private JLabel label_3;
	private JLabel lblPw;
	private JLabel lblTestPw;

	public AddressFrame getAddr() {
		return addr;
	}

	public JTextField getTfAddr() {
		return tfAddr;
	}

	public MembershipFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(System.getProperty("user.dir") + "\\images\\Instapaper icon.png");
		setIconImage(img);

		setTitle("회원가입");

		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 443, 630);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel IdImg = new JLabel("");
		IdImg.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\Id.png"));
		IdImg.setBackground(SystemColor.window);
		IdImg.setBounds(17, 20, 52, 34);
		panel.add(IdImg);

		JLabel IdBar = new JLabel("");
		IdBar.setBackground(SystemColor.activeCaptionBorder);
		IdBar.setOpaque(true);
		IdBar.setBounds(86, 20, 5, 34);
		panel.add(IdBar);

		JLabel PwImg = new JLabel("");
		PwImg.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\Pw.png"));
		PwImg.setBackground(Color.WHITE);
		PwImg.setBounds(17, 69, 53, 43);
		panel.add(PwImg);

		JLabel PwBar = new JLabel("");
		PwBar.setOpaque(true);
		PwBar.setBackground(SystemColor.activeCaptionBorder);
		PwBar.setBounds(86, 73, 5, 34);
		panel.add(PwBar);

		JLabel PwConfirmBar = new JLabel("");
		PwConfirmBar.setBounds(86, 125, 5, 34);
		panel.add(PwConfirmBar);
		PwConfirmBar.setOpaque(true);
		PwConfirmBar.setBackground(SystemColor.activeCaptionBorder);

		JLabel PwConfirmImg = new JLabel("");
		PwConfirmImg.setBounds(17, 120, 53, 43);
		panel.add(PwConfirmImg);
		PwConfirmImg.setIcon(
				new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\PwConfirm.png"));
		PwConfirmImg.setBackground(Color.WHITE);

		JLabel BirthImg = new JLabel("");
		BirthImg.setIcon(
				new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\Birth.png"));
		BirthImg.setBackground(Color.WHITE);
		BirthImg.setBounds(17, 172, 53, 43);
		panel.add(BirthImg);

		JLabel BirthBar = new JLabel("");
		BirthBar.setOpaque(true);
		BirthBar.setBackground(SystemColor.activeCaptionBorder);
		BirthBar.setBounds(86, 177, 5, 34);
		panel.add(BirthBar);

		JLabel NameImg = new JLabel("");
		NameImg.setIcon(
				new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\Name.png"));
		NameImg.setBackground(Color.WHITE);
		NameImg.setBounds(17, 227, 53, 43);
		panel.add(NameImg);

		JLabel NameBar = new JLabel("");
		NameBar.setOpaque(true);
		NameBar.setBackground(SystemColor.activeCaptionBorder);
		NameBar.setBounds(86, 229, 5, 34);
		panel.add(NameBar);
		
		JLabel GenderImg = new JLabel("");
		GenderImg.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\Gender.png"));
		GenderImg.setBackground(Color.WHITE);
		GenderImg.setBounds(17, 276, 53, 43);
		panel.add(GenderImg);
		
		JLabel GenderBar = new JLabel("");
		GenderBar.setOpaque(true);
		GenderBar.setBackground(SystemColor.activeCaptionBorder);
		GenderBar.setBounds(86, 281, 5, 34);
		panel.add(GenderBar);
		
		JLabel PhoneImg = new JLabel("");
		PhoneImg.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\Phone.png"));
		PhoneImg.setBackground(Color.WHITE);
		PhoneImg.setBounds(17, 330, 53, 43);
		panel.add(PhoneImg);
		
		JLabel PhoneBar = new JLabel("");
		PhoneBar.setOpaque(true);
		PhoneBar.setBackground(SystemColor.activeCaptionBorder);
		PhoneBar.setBounds(86, 333, 5, 34);
		panel.add(PhoneBar);
		
		JLabel EmailImg = new JLabel("");
		EmailImg.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\Email.png"));
		EmailImg.setBackground(Color.WHITE);
		EmailImg.setBounds(17, 380, 53, 43);
		panel.add(EmailImg);
		
		JLabel EmailBar = new JLabel("");
		EmailBar.setOpaque(true);
		EmailBar.setBackground(SystemColor.activeCaptionBorder);
		EmailBar.setBounds(86, 385, 5, 34);
		panel.add(EmailBar);
		
		JLabel AddrImg = new JLabel("");
		AddrImg.setBounds(20, 447, 53, 43);
		panel.add(AddrImg);
		AddrImg.setIcon(new ImageIcon("D:\\workspace\\workspace_mybatis\\RentCar_Project\\Images\\RegisterImg\\Addr.png"));
		AddrImg.setBackground(Color.WHITE);
		
		JLabel AddrBar = new JLabel("");
		AddrBar.setOpaque(true);
		AddrBar.setBackground(SystemColor.activeCaptionBorder);
		AddrBar.setBounds(86, 437, 5, 70);
		panel.add(AddrBar);

		TextFieldComponent IdPanel = new TextFieldComponent("아이디");
		IdPanel.getLblNewLabel().setText("");
		PromptSupport.setPrompt("아이디를 입력하세요.", IdPanel.getTextField());
		IdPanel.setBounds(-64, 21, 347, 34);
		panel.add(IdPanel);

		JPanel PwPanel = new JPanel();
		PwPanel.setBounds(-55, 73, 337, 34);
		panel.add(PwPanel);
		PwPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PwPanel.add(lblNewLabel);

		tfPw = new JPasswordField();
		PwPanel.add(tfPw);
		PromptSupport.setPrompt("영문,숫자8자리이상", tfPw);

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

		JPanel PwConfirmPanel = new JPanel();
		PwConfirmPanel.setBounds(-57, 125, 337, 34);
		panel.add(PwConfirmPanel);
		PwConfirmPanel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 115, 28);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		PwConfirmPanel.add(lblNewLabel_5);

		tfTestPw = new JPasswordField();
		tfTestPw.setBounds(172, 0, 165, 34);
		PwConfirmPanel.add(tfTestPw);
		PromptSupport.setPrompt("영문,숫자8자리이상", tfTestPw);

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

		TextFieldComponent NamePanel = new TextFieldComponent("성명");
		NamePanel.getLblNewLabel().setText("");
		NamePanel.setBounds(-57, 229, 337, 34);
		PromptSupport.setPrompt("이름을 입력하세요.", NamePanel.getTextField());
		panel.add(NamePanel);

		RadioComponent genderPanel = new RadioComponent("", "남", "여");
		genderPanel.setBounds(-23, 281, 337, 34);
		panel.add(genderPanel);

		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(24, 333, 340, 34);
		panel.add(phonePanel);
		phonePanel.setLayout(null);

		tfNum1 = new JTextField();
		tfNum1.setBounds(180, 1, 55, 33);
		phonePanel.add(tfNum1);
		tfNum1.setHorizontalAlignment(SwingConstants.CENTER);
		tfNum1.setColumns(10);

		tfNum2 = new JTextField();
		tfNum2.setBounds(262, 1, 55, 33);
		phonePanel.add(tfNum2);
		tfNum2.setHorizontalAlignment(SwingConstants.CENTER);
		tfNum2.setColumns(10);

		String[] phoneArr = { "010", "011", "016", "017", "018", "019" };

		DefaultComboBoxModel<String> modelPhone = new DefaultComboBoxModel<>(phoneArr);
		JComboBox<String> comboPhone = new JComboBox<>(modelPhone);

		comboPhone.setBounds(94, 0, 60, 34);
		phonePanel.add(comboPhone);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setBounds(155, 3, 24, 28);
		phonePanel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label = new JLabel("-");
		label.setBounds(236, 3, 24, 28);
		phonePanel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel emailPanel = new JPanel();
		emailPanel.setBounds(25, 385, 380, 34);
		panel.add(emailPanel);
		emailPanel.setLayout(null);

		tfEmail1 = new JTextField();
		tfEmail1.setBounds(90, 1, 86, 33);
		emailPanel.add(tfEmail1);
		tfEmail1.setColumns(10);

		String[] emailArr = { "직접입력", "naver.com", "gmail.com", "nate.com", "daum.net" };

		DefaultComboBoxModel<String> modelEmail = new DefaultComboBoxModel<>(emailArr);

		JComboBox<String> comboEmail = new JComboBox<>(modelEmail);

		comboEmail.setBounds(285, 0, 95, 34);
		emailPanel.add(comboEmail);

		JLabel lblNewLabel_3 = new JLabel("@");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(174, 3, 25, 28);
		emailPanel.add(lblNewLabel_3);

		tfEmail2 = new JTextField();
		tfEmail2.setColumns(10);
		tfEmail2.setBounds(197, 0, 86, 34);
		emailPanel.add(tfEmail2);

		JPanel AddrPanel = new JPanel();
		AddrPanel.setBounds(25, 437, 362, 70);
		panel.add(AddrPanel);
		AddrPanel.setLayout(null);

		tfAddr = new JTextField();
		tfAddr.setBounds(91, 0, 171, 33);
		tfAddr.setFocusable(false);
		AddrPanel.add(tfAddr);
		tfAddr.setColumns(10);

		tfAddr2 = new JTextField();
		tfAddr2.setColumns(10);
		tfAddr2.setBounds(91, 37, 259, 33);
		AddrPanel.add(tfAddr2);

		JButton btnAddr = new JButton("주소검색");
		btnAddr.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addr = new AddressFrame(tfAddr);
				addr.setVisible(true);
			}
		});
		btnAddr.setFont(new Font("굴림", Font.PLAIN, 11));
		btnAddr.setBounds(274, 0, 76, 33);
		AddrPanel.add(btnAddr);

		JButton btnAdd = new JButton("가입");

		btnAdd.setBounds(74, 529, 130, 44);
		panel.add(btnAdd);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(234, 529, 130, 44);
		panel.add(btnCancel);

		btnTest = new JButton("중복확인");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pattern p = Pattern.compile("(^[a-zA-Z0-9]{6,15}$)");
				Matcher m = p.matcher(IdPanel.getTextValue());

				if (!m.find()) {
					JOptionPane.showMessageDialog(null, "영문,숫자 6자리 이상 만 가능합니다.");
					IdPanel.getTextField().requestFocus();
					return;
				}
				idCheck = 2;
				String Id = IdPanel.getTextValue();
				List<User> list = userDao.selectUserByAll();
				for (User u : list) {
					if (Id.equals(u.getId())) {
						idCheck = 1;
					}
				}

				if (idCheck == 2) {
					idCheck = JOptionPane.showConfirmDialog(null, "사용가능한 아이디 입니다. 사용하시겠습니까?", null,
							JOptionPane.YES_NO_OPTION);
					if (idCheck == 0) {
						IdPanel.getTextField().setEnabled(false);
					} else {
						IdPanel.getTextField().requestFocus();
						IdPanel.getTextField().setEnabled(true);
						idCheck = 2;
					}
				} else {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다.");
					IdPanel.getTextField().requestFocus();
				}
			}
		});

		IdPanel.getTextField().addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				IdPanel.getTextField().setText("");
			}
		});

		btnTest.setFont(new Font("굴림", Font.PLAIN, 11));
		btnTest.setBounds(294, 20, 102, 34);
		panel.add(btnTest);

		lblPw = new JLabel("불가능한 비밀번호입니다");
		lblPw.setForeground(Color.RED);
		lblPw.setFont(new Font("굴림", Font.PLAIN, 11));
		lblPw.setBounds(286, 76, 141, 28);
		panel.add(lblPw);

		lblTestPw = new JLabel("불일치합니다");
		lblTestPw.setForeground(Color.RED);
		lblTestPw.setFont(new Font("굴림", Font.PLAIN, 11));
		lblTestPw.setBounds(286, 127, 151, 28);
		panel.add(lblTestPw);

		JPanel birthPanel = new JPanel();
		birthPanel.setBounds(33, 177, 333, 34);
		panel.add(birthPanel);
		birthPanel.setLayout(null);

		Vector<String> yearArr = new Vector<>();
		for (int i = 1997; i > 1900; i--) {
			yearArr.addElement(i + "");
		}

		DefaultComboBoxModel<String> modelYear = new DefaultComboBoxModel<>(yearArr);

		JComboBox<String> comboYear = new JComboBox<>(modelYear);

		comboYear.setBounds(87, 0, 65, 34);
		birthPanel.add(comboYear);

		JLabel lblNewLabel_7 = new JLabel("년");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(155, 3, 17, 28);
		birthPanel.add(lblNewLabel_7);

		Vector<String> monthArr = new Vector<>();
		for (int i = 1; i < 13; i++) {
			monthArr.addElement(i + "");
		}

		DefaultComboBoxModel<String> modelMonth = new DefaultComboBoxModel<>(monthArr);

		JComboBox<String> comboMonth = new JComboBox<>(modelMonth);
		comboMonth.setBounds(180, 0, 50, 34);
		birthPanel.add(comboMonth);

		Vector<String> dayArr = new Vector<>();
		for (int i = 1; i < 32; i++) {
			dayArr.addElement(i + "");
		}

		DefaultComboBoxModel<String> modelDay = new DefaultComboBoxModel<>(dayArr);

		JComboBox<String> comboDay = new JComboBox<>(modelDay);
		comboDay.setBounds(253, 0, 50, 34);
		birthPanel.add(comboDay);

		JLabel label_1 = new JLabel("월");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(234, 3, 17, 28);
		birthPanel.add(label_1);

		JLabel label_2 = new JLabel("일");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(304, 3, 17, 28);
		birthPanel.add(label_2);
		PromptSupport.setPrompt("ex)exam.com", tfEmail2);
		PromptSupport.setPrompt("주소검색 클릭", tfAddr);
		PromptSupport.setPrompt("상세주소 입력", tfAddr2);

		comboPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum1.requestFocus();
			}
		});

		NamePanel.getTextField().addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				NamePanel.getTextField().setText("");
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
				}
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UserDao userDao = UserService.getInstance();
				if (idCheck != 0) {
					JOptionPane.showMessageDialog(null, "아이디를 정확하게 입력하세요");
					IdPanel.getTextField().requestFocus();
					return;
				}
				if (!(pw1Check && pw2Check)) {
					JOptionPane.showMessageDialog(null, "비밀번호를 정확하게 입력하세요");
					tfPw.requestFocus();
					tfTestPw.setText("");
					return;
				}

				Pattern p = Pattern.compile("(^[a-zA-Z가-힣]{1,15}$)");
				Matcher m = p.matcher(NamePanel.getTextValue());
				if (!m.find()) {
					JOptionPane.showMessageDialog(null, "성명을 정확하게 입력하세요");
					NamePanel.getTextField().requestFocus();
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
				if (!m.find()) {
					JOptionPane.showMessageDialog(null, "이메일를 정확하게 입력하세요");
					tfEmail2.requestFocus();
					return;
				}
				if (tfAddr.getText().equals("") || tfAddr2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "주소를 정확하게 입력하세요");
					tfAddr2.requestFocus();
					return;
				}

				String id = IdPanel.getTextValue();
				String pw = tfPw.getText();
				String userName = NamePanel.getTextValue();
				String phone = comboPhone.getSelectedItem() + "-" + tfNum1.getText() + "-" + tfNum2.getText();
				String email = tfEmail1.getText() + "@" + tfEmail2.getText();
				byte[] userImg;
				Gender gender;
				if (genderPanel.getSelectText().equals("남")) {
					gender = Gender.MALE;
					userImg = getImg("user1");
				} else {
					gender = Gender.FEMALE;
					userImg = getImg("user5");
				}
				UserGrade uGrade = new UserGrade();
				uGrade.setGrade("C");
				String addr = tfAddr.getText() + " / " + tfAddr2.getText();

				User user = new User(id, pw, userName, userImg, phone, email, gender, addr);
				user.setGrade(uGrade);
				userDao.insertUser(user);

				JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
				setVisible(false);
			}
		});

	}

	private byte[] getImg(String imgName) {
		byte[] img = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\userBig\\" + imgName + ".png");
		try {
			InputStream is = new FileInputStream(file);
			img = new byte[is.available()];
			is.read(img);
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return img;
	}
}
