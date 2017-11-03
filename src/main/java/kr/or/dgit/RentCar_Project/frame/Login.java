package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField IdField;
	private JPasswordField PwField;
	private ImageIcon idimg;
	private ImageIcon pwimg;
	private JCheckBox adminLoginBox;

	public static void main(String[] args) {
		
		
		// 룩앤필 변경
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {

			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			private Login frame;

			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		
		// 아이디 확인 배경
		JLabel IdCheck = new JLabel("");
		IdCheck.setBounds(549, 274, 46, 47);
		contentPane.add(IdCheck);

		// 비밀번호 확인 배경
		JLabel PwCheck = new JLabel("");
		PwCheck.setBounds(549, 331, 46, 45);
		contentPane.add(PwCheck);

		// 아이디 필드
		IdField = new JTextField();
		IdField.setText("아이디를 입력해주세요.");
		
		// 아이디 필드 포거스 시 글자 선택
		IdField.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				IdField.select(0, IdField.getText().length());

			}
		});

		// 아이디 키 리스너
		IdField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// 아이디 정규표현식
				Pattern p = Pattern.compile("(^[a-zA-Z0-9]{10,15}$)");
				Matcher m = p.matcher(IdField.getText());

				if (m.find()) {
					idimg = new ImageIcon(System.getProperty("user.dir") + "\\Images\\check(true).png");
					IdCheck.setIcon(idimg);
				} else {
					idimg = new ImageIcon(System.getProperty("user.dir") + "\\Images\\check(false).png");
					IdCheck.setIcon(idimg);
				}
			}

		});
		IdField.setBounds(323, 274, 226, 47);
		contentPane.add(IdField);
		IdField.setColumns(10);
		
		
		// 비밀번호 필드
		PwField = new JPasswordField();
		PwField.setText("비밀번호를 입력해주세요.");
		contentPane.add(PwField);

		// 비밀번호 필드 포거스 시 글자 선택
		PwField.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				PwField.select(0, PwField.getText().length());

			}
		});

		// 비밀번호 리스너
		PwField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// 비밀번호 정규표현식
				Pattern p = Pattern.compile("(^[a-zA-Z0-9!@#$%^&*()]{10,15}$)");
				Matcher m = p.matcher(PwField.getText());

				if (m.find()) {
					pwimg = new ImageIcon(System.getProperty("user.dir") + "\\Images\\check(true).png");
					PwCheck.setIcon(pwimg);
				} else if (!m.find()) {
					pwimg = new ImageIcon(System.getProperty("user.dir") + "\\Images\\check(false).png");
					PwCheck.setIcon(pwimg);
				} else {
					PwField.requestFocus();
					PwField.select(0, IdField.getText().length());
				}
			}

		});

		PwField.setBounds(323, 331, 226, 45);
		contentPane.add(PwField);

		// 로그인 버튼
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setBounds(392, 400, 97, 23);
		
		// 로그인 버튼 리스너
		btnLogin.addActionListener(new ActionListener() {

			private int idCheck;
			private int pwCheck;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					idCheck = idimg.getDescription().indexOf("false");
					pwCheck = pwimg.getDescription().indexOf("false");
				} catch (NullPointerException err) {
					JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 확인해주세요.");
					IdField.requestFocus();
					return;
				}

				
				if (adminLoginBox.isSelected()) {
					JOptionPane.showMessageDialog(null, "관리자모드를 시작합니다.");
					AdminMain frame = AdminMain.getInstance();
					frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
					frame.setVisible(true);
					setVisible(false);
					return;
				}
				
				
				if (idCheck > 0 || pwCheck > 0) {
					JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 확인해주세요.");
				} else {
					String Id = IdField.getText();
					JOptionPane.showMessageDialog(null, Id + "님 환영합니다.");
					UserMain frame = UserMain.getInstance();
					frame.getContentPane().add(new UserMainHome(), BorderLayout.CENTER);
					frame.setVisible(true);
					setVisible(false);
				}

			}
		});

		contentPane.add(btnLogin);
		
		// 관리자 모드 확인 체크박스
		adminLoginBox = new JCheckBox("관리자모드로 로그인하기");
		adminLoginBox.setBounds(354, 452, 178, 23);
		contentPane.add(adminLoginBox);
		
		// 배경화면 
		JLabel backImg = new JLabel("");
		backImg.setBounds(5, 5, 640, 471);
		backImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\\uBC30\uACBD2.jpg"));
		contentPane.add(backImg);

	}
}