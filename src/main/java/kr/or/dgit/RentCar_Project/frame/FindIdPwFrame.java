package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dao.UserDao;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.email.SendEmail;
import kr.or.dgit.RentCar_Project.service.UserService;

@SuppressWarnings("serial")
public class FindIdPwFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail1;
	private JTextField tfEmail2;
	private TextFieldComponent tfId;
	private JButton btn;
	private TextFieldComponent tfName;
	private JComboBox<String> comboEmail;
	private JLabel lbl;
	private JLabel label_3;

	public FindIdPwFrame() {
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(System.getProperty("user.dir") + "\\images\\Instapaper icon.png");
		setIconImage(img);

		setTitle("내 정보 찾기");

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 414, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"\uC544\uC774\uB514, \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		label_3 = new JLabel("");
		label_3.setOpaque(true);
		label_3.setBackground(SystemColor.activeCaptionBorder);
		label_3.setBounds(83, 103, 4, 36);
		panel.add(label_3);

		lbl = new JLabel("");
		lbl.setOpaque(true);
		lbl.setBackground(SystemColor.activeCaptionBorder);
		lbl.setBounds(83, 87, 4, 36);
		lbl.setVisible(false);
		panel.add(lbl);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(98, 32, 212, 40);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JRadioButton rdbtnId = new JRadioButton("아이디 찾기");

		rdbtnId.setSelected(true);
		panel_1.add(rdbtnId);

		JRadioButton rdbtnPw = new JRadioButton("비밀번호 찾기");
		panel_1.add(rdbtnPw);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnId);
		group.add(rdbtnPw);

		String[] emailArr = { "직접입력", "naver.com", "gmail.com", "nate.com", "daum.net" };

		DefaultComboBoxModel<String> modelEmail = new DefaultComboBoxModel<>(emailArr);
		btn = new JButton("아이디 찾기");
		btn.setBounds(70, 251, 110, 42);
		panel.add(btn);

		JButton btnExit = new JButton("나가기");
		btnExit.setBounds(212, 251, 110, 42);
		panel.add(btnExit);

		tfId = new TextFieldComponent("아이디");
		tfId.getLblNewLabel().setText("아이디        ");
		tfId.getLblNewLabel().setHorizontalAlignment(SwingConstants.TRAILING);
		tfId.setBounds(-59, 87, 308, 36);
		panel.add(tfId);

		tfName = new TextFieldComponent("이름");
		tfName.getLblNewLabel().setText("이름          ");
		tfName.getLblNewLabel().setHorizontalAlignment(SwingConstants.RIGHT);
		tfName.setBounds(-62, 103, 311, 36);
		panel.add(tfName);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(83, 179, 4, 36);
		panel.add(label_4);
		label_4.setOpaque(true);
		label_4.setBackground(SystemColor.activeCaptionBorder);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 179, 386, 36);
		panel.add(panel_5);
		panel_5.setLayout(null);

		tfEmail1 = new JTextField();
		tfEmail1.setHorizontalAlignment(SwingConstants.CENTER);
		tfEmail1.setColumns(10);
		tfEmail1.setBounds(96, 1, 86, 35);
		panel_5.add(tfEmail1);

		comboEmail = new JComboBox<>(modelEmail);
		comboEmail.setBounds(287, 0, 95, 36);
		panel_5.add(comboEmail);

		JLabel label_1 = new JLabel("@");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(178, 4, 25, 28);
		panel_5.add(label_1);

		tfEmail2 = new JTextField();
		tfEmail2.setColumns(10);
		tfEmail2.setBounds(198, 1, 86, 36);
		panel_5.add(tfEmail2);

		JLabel label = new JLabel("이메일");
		label.setBounds(20, 0, 60, 36);
		panel_5.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);

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
		tfId.setVisible(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn.addActionListener(new ActionListener() {
			private String userName;
			private String email;
			private UserDao userDao = UserService.getInstance();
			private User userId;
			private User user = new User();

			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("아이디 찾기")) {

					userName = tfName.getTextValue();
					email = tfEmail1.getText() + "@" + tfEmail2.getText();
					user = new User(userName, email);
					try {
						userId = userDao.selectUserFindId(user);
						JOptionPane.showMessageDialog(null, "회원님의 아이디는 " + userId.toStringId() + " 입니다.");
						rdbtnPw.setSelected(true);
						tfId.setTextValue(userId.toStringId());
					} catch (NullPointerException e2) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.");
						clearTf();
						return;
					}

				} else {

					userName = tfName.getTextValue();
					email = tfEmail1.getText() + "@" + tfEmail2.getText();
					String id = tfId.getTextValue();
					user = new User(id, userName, email);

					try {
						userId = userDao.selectUserFindPw(user);
						String rPw = "";
						for (int i = 0; i < 8; i++) {
							Random random = new Random();
							rPw += random.nextInt(10);
						}
						userId.setPw(rPw);
						userDao.updateUser(userId);
						SendEmail sendEmail = new SendEmail(email, rPw);
						JOptionPane.showMessageDialog(null, "회원님의 메일로 임시비밀번호가 발송 되었습니다.");
						setVisible(false);
					} catch (NullPointerException e2) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.");
						clearTf();
						return;
					}
				}
			}
		});

		rdbtnId.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnId.isSelected()) {
					tfName.setBounds(-62, 103, 311, 36);
					label_3.setBounds(83, 103, 4, 36);
					tfId.setVisible(false);
					lbl.setVisible(false);
					btn.setText("아이디 찾기");
					clearTf();
				} else {
					tfName.setBounds(-62, 133, 311, 36);
					label_3.setBounds(83, 133, 4, 36);
					tfId.setVisible(true);
					lbl.setVisible(true);
					btn.setText("비밀번호 찾기");
					clearTf();
				}

			}
		});

	}

	private void clearTf() {
		tfId.setTextValue("");
		tfEmail1.setText("");
		tfEmail2.setText("");
		tfName.setTextValue("");
		comboEmail.setSelectedIndex(0);

	}
}
