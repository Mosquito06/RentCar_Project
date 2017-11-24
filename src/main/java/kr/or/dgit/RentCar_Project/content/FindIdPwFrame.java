package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FindIdPwFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindIdPwFrame frame = new FindIdPwFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FindIdPwFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC544\uC774\uB514, \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 33, 212, 40);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("아이디 찾기");
		rdbtnNewRadioButton.setSelected(true);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("비밀번호 찾기");
		panel_1.add(rdbtnNewRadioButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 83, 374, 334);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		TextFieldComponent panel_3 = new TextFieldComponent("아이디");
		panel_3.setBounds(0, 20, 187, 36);
		panel_2.add(panel_3);
		
		TextFieldComponent textFieldComponent = new TextFieldComponent("이름");
		textFieldComponent.setBounds(0, 68, 187, 36);
		panel_2.add(textFieldComponent);
		
		JButton btnNewButton = new JButton("찾기");
		btnNewButton.setBounds(57, 261, 97, 42);
		panel_2.add(btnNewButton);
		
		JButton button = new JButton("나가기");
		button.setBounds(212, 261, 97, 42);
		panel_2.add(button);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 114, 374, 36);
		panel_2.add(panel_5);
		
		JLabel label = new JLabel("이메일");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 86, 36);
		panel_5.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(84, 1, 86, 35);
		panel_5.add(textField);
		
		JComboBox<String> comboBox = new JComboBox<String>((ComboBoxModel) null);
		comboBox.setBounds(279, 0, 95, 36);
		panel_5.add(comboBox);
		
		JLabel label_1 = new JLabel("@");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(167, 4, 25, 28);
		panel_5.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(187, 1, 86, 36);
		panel_5.add(textField_1);
	}
}
