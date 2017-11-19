package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;

public class MembershipFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;



	public MembershipFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 332, 520);
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
		panel_2.setBounds(23, 187, 196, 28);
		panel.add(panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(9, 263, 263, 28);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("핸드폰");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 67, 28);
		panel_4.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(141, 1, 55, 28);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(208, 1, 55, 28);
		panel_4.add(textField_2);
		
		String[] phoneArr = {"010","011","016","017","018","019"}; 
		
		DefaultComboBoxModel<String> modelPhone=new DefaultComboBoxModel<>(phoneArr);
		
		JComboBox<String> comboPhone = new JComboBox<>(modelPhone);
		comboPhone.setBounds(69, 0, 60, 28);
		panel_4.add(comboPhone);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(130, 0, 11, 28);
		panel_4.add(lblNewLabel_1);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(197, 0, 11, 28);
		panel_4.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(9, 301, 285, 28);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("이메일");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 67, 28);
		panel_5.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(68, 1, 95, 28);
		panel_5.add(textField);
		textField.setColumns(10);
		
		String[] emailArr = {"직접입력","naver.com","gmail.com","nate.com","daum.net"};
		
		DefaultComboBoxModel<String> modelEmail=new DefaultComboBoxModel<>(emailArr);
		
		JComboBox<String> comboEmail = new JComboBox<>(modelEmail);
		comboEmail.setBounds(182, 0, 95, 28);
		panel_5.add(comboEmail);
		
		JLabel lblNewLabel_3 = new JLabel("@");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(163, 0, 19, 28);
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(9, 339, 263, 59);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("주소");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 68, 59);
		panel_6.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(69, 0, 116, 28);
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(69, 31, 194, 28);
		panel_6.add(textField_4);
		
		JButton btnAddr = new JButton("주소검색");
		btnAddr.setFont(new Font("굴림", Font.PLAIN, 11));
		btnAddr.setBounds(186, 0, 76, 28);
		panel_6.add(btnAddr);
		
		JButton btnAdd = new JButton("가입");
		btnAdd.setBounds(31, 414, 97, 38);
		panel.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(175, 414, 97, 38);
		panel.add(btnCancel);
		
		JButton btnTest = new JButton("중복검사");
		btnTest.setFont(new Font("굴림", Font.PLAIN, 11));
		btnTest.setBounds(222, 35, 76, 28);
		panel.add(btnTest);
		
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(3, 225, 291, 28);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("생년월일");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 75, 28);
		panel_3.add(lblNewLabel_6);
		
		Vector<String> yearArr = new Vector<>();
		for(int i=1997;i>1900;i--) {
			yearArr.addElement(i+"");
		}
		
		DefaultComboBoxModel<String> modelYear=new DefaultComboBoxModel<>(yearArr);
		
		JComboBox<String> comboYear = new JComboBox<>(modelYear);
		
		comboYear.setBounds(74, 0, 65, 28);
		panel_3.add(comboYear);
		
		JLabel lblNewLabel_7 = new JLabel("년");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(140, 0, 17, 28);
		panel_3.add(lblNewLabel_7);
		
		Vector<String> monthArr = new Vector<>();
		for(int i=1;i<13;i++) {
			monthArr.addElement(i+"");
		}
		
		DefaultComboBoxModel<String> modelMonth=new DefaultComboBoxModel<>(monthArr);
		
		JComboBox<String> comboMonth = new JComboBox<>(modelMonth);
		comboMonth.setBounds(157, 0, 50, 28);
		panel_3.add(comboMonth);
		
		Vector<String> dayArr = new Vector<>();
		for(int i=1;i<32;i++) {
			dayArr.addElement(i+"");
		}
		
		DefaultComboBoxModel<String> modelDay=new DefaultComboBoxModel<>(dayArr);
		
		JComboBox<String> comboDay = new JComboBox<>(modelDay);
		comboDay.setBounds(224, 0, 50, 28);
		panel_3.add(comboDay);
		
		JLabel label_1 = new JLabel("월");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(208, 0, 17, 28);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("일");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(274, 0, 17, 28);
		panel_3.add(label_2);
	}
}
