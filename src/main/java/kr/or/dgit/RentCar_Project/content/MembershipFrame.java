package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import kr.or.dgit.RentCar_Project.component.RadioComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.PhoneTextFiedComponent;
import java.awt.GridLayout;
import kr.or.dgit.RentCar_Project.component.EmailTextFiedComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class MembershipFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;


	public MembershipFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 330, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uD68C\uC6D0\uAC00\uC785", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		TextFieldComponent panel_1 = new TextFieldComponent("아이디");
		panel_1.setBounds(3, 35, 216, 28);
		panel.add(panel_1);
		
		TextFieldComponent textFieldComponent = new TextFieldComponent("비밀번호");
		textFieldComponent.getTextField().setFont(new Font("굴림", Font.PLAIN, 11));
		textFieldComponent.getTextField().setText("영문,숫자8자리이상");
		textFieldComponent.setBounds(3, 73, 216, 28);
		panel.add(textFieldComponent);
		
		TextFieldComponent textFieldComponent_1 = new TextFieldComponent("비밀번호확인");
		textFieldComponent_1.setBounds(3, 111, 216, 28);
		panel.add(textFieldComponent_1);
		
		TextFieldComponent textFieldComponent_2 = new TextFieldComponent("성명");
		textFieldComponent_2.setBounds(3, 149, 216, 28);
		panel.add(textFieldComponent_2);
		
		RadioComponent panel_2 = new RadioComponent("성별", "남", "여");
		panel_2.setBounds(18, 187, 195, 28);
		panel.add(panel_2);
		
		TextFieldComponent panel_3 = new TextFieldComponent("생년월일");
		panel_3.setBounds(3, 225, 216, 28);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(9, 263, 238, 28);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("핸드폰");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 57, 28);
		panel_4.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(127, 1, 50, 28);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(187, 1, 51, 28);
		panel_4.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(58, 0, 57, 28);
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(115, 0, 11, 28);
		panel_4.add(lblNewLabel_1);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(177, 0, 11, 28);
		panel_4.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(9, 301, 238, 28);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("이메일");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 57, 28);
		panel_5.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(56, 0, 98, 28);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(166, 0, 72, 28);
		panel_5.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("@");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(154, 0, 12, 28);
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(9, 339, 263, 59);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("주소");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 57, 59);
		panel_6.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(56, 0, 129, 28);
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(56, 31, 207, 28);
		panel_6.add(textField_4);
		
		JButton btnNewButton_4 = new JButton("주소검색");
		btnNewButton_4.setFont(new Font("굴림", Font.PLAIN, 11));
		btnNewButton_4.setBounds(186, 0, 76, 28);
		panel_6.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("가입");
		btnNewButton.setBounds(31, 414, 97, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(175, 414, 97, 38);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("중복검사");
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 11));
		btnNewButton_2.setBounds(222, 35, 76, 28);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setBounds(222, 225, 35, 28);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("불가능합니다");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(222, 73, 76, 28);
		panel.add(lblNewLabel_5);
		
		JLabel lblDlfclgkqslek = new JLabel("불일치합니다");
		lblDlfclgkqslek.setForeground(Color.RED);
		lblDlfclgkqslek.setFont(new Font("굴림", Font.PLAIN, 11));
		lblDlfclgkqslek.setBounds(222, 111, 76, 28);
		panel.add(lblDlfclgkqslek);
	}
}
