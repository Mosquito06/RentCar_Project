package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dao.UserDao;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.UserService;

@SuppressWarnings("serial")
public class FindIdPwFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail1;
	private JTextField tfEmail2;
	private TextFieldComponent tfId;

	public FindIdPwFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 424, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC544\uC774\uB514, \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 33, 212, 40);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JRadioButton rdbtnId = new JRadioButton("아이디 찾기");
		
		rdbtnId.setSelected(true);
		panel_1.add(rdbtnId);
		
		JRadioButton rdbtnPw = new JRadioButton("비밀번호 찾기");
		panel_1.add(rdbtnPw);
		
		ButtonGroup group= new ButtonGroup();
		group.add(rdbtnId);
		group.add(rdbtnPw);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC815\uBCF4\uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 83, 374, 238);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		tfId = new TextFieldComponent("아이디");
		tfId.setBounds(161, 37, 180, 36);
		
		panel_2.add(tfId);
		
		TextFieldComponent tfName = new TextFieldComponent("이름");
		tfName.setBounds(-11, 37, 180, 36);
		panel_2.add(tfName);
		tfId.setVisible(false);
		JButton btnNewButton = new JButton("찾기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName=tfName.getTextValue();
				String email = tfEmail1.getText()+"@"+tfEmail2.getText();
				
				UserDao userDao = UserService.getInstance();
				User user = new User(userName, email);
				User userId=new User();
				try {
					userId=userDao.selectUserFindId(user);
					JOptionPane.showMessageDialog(null, "회원님의 아이디는 "+userId.toStringId()+" 입니다.");
					rdbtnPw.setSelected(true);
					tfId.setTextValue(userId.toStringId());
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.");
					return;
				}	
			}
		});
		btnNewButton.setBounds(59, 178, 97, 42);
		panel_2.add(btnNewButton);
		
		JButton button = new JButton("나가기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setBounds(207, 178, 97, 42);
		panel_2.add(button);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(-11, 98, 380, 36);
		panel_2.add(panel_5);
		
		JLabel label = new JLabel("이메일");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(1, 0, 86, 36);
		panel_5.add(label);
		
		tfEmail1 = new JTextField();
		tfEmail1.setHorizontalAlignment(SwingConstants.CENTER);
		tfEmail1.setColumns(10);
		tfEmail1.setBounds(92, 1, 86, 35);
		panel_5.add(tfEmail1);
		
		String[] emailArr = { "직접입력", "naver.com", "gmail.com", "nate.com", "daum.net" };

		DefaultComboBoxModel<String> modelEmail = new DefaultComboBoxModel<>(emailArr);

		JComboBox<String> comboEmail = new JComboBox<>(modelEmail);
		comboEmail.setBounds(285, 0, 95, 36);
		panel_5.add(comboEmail);
		
		JLabel label_1 = new JLabel("@");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(175, 4, 25, 28);
		panel_5.add(label_1);
		
		tfEmail2 = new JTextField();
		tfEmail2.setColumns(10);
		tfEmail2.setBounds(196, 1, 86, 36);
		panel_5.add(tfEmail2);
		
		rdbtnId.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnId.isSelected()) {
					tfId.setVisible(false);
				}else {
					tfId.setVisible(true);
				}
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
		
	}
}
