package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.EmailTextFiedComponent;
import kr.or.dgit.RentCar_Project.component.PhoneTextFiedComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainClientManager extends JPanel {
	private JTable table;
	private JTable table_1;

	public AdminMainClientManager() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uACE0\uAC1D \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputPanel.setBounds(12, 26, 655, 319);
		add(inputPanel);
		inputPanel.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new EmptyBorder(5, 5, 5, 5)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainPanel.setBounds(126, 37, 333, 49);
		inputPanel.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnOk = new JButton("확인");
		mainPanel.add(btnOk, BorderLayout.EAST);
		
		TextFieldComponent panel = new TextFieldComponent("고객코드");
		mainPanel.add(panel, BorderLayout.CENTER);
		
		TextFieldComponent idPanel = new TextFieldComponent("아이디");
		idPanel.setBounds(12, 96, 278, 29);
		inputPanel.add(idPanel);
		
		TextFieldComponent clientCodePanel = new TextFieldComponent("고객 코드");
		clientCodePanel.setBounds(12, 146, 278, 29);
		inputPanel.add(clientCodePanel);
		
		TextFieldComponent clientNamePanel = new TextFieldComponent("고객 명");
		clientNamePanel.setBounds(12, 196, 278, 29);
		inputPanel.add(clientNamePanel);
		
		PhoneTextFiedComponent PhonePanel = new PhoneTextFiedComponent("연락처");
		PhonePanel.setBounds(212, 196, 394, 29);
		inputPanel.add(PhonePanel);
		
		RadioComponent genderPanel = new RadioComponent("성별", "남자", "여자");
		genderPanel.setBounds(316, 146, 290, 29);
		inputPanel.add(genderPanel);
		
		ComboBoxComponent gradePanel = new ComboBoxComponent("고객등급");
		gradePanel.setBounds(288, 96, 305, 29);
		inputPanel.add(gradePanel);
		
		EmailTextFiedComponent emailPanel = new EmailTextFiedComponent("이메일");
		emailPanel.setBounds(12, 245, 469, 29);
		inputPanel.add(emailPanel);
		
		JButton btnCancle = new JButton("취소");
		btnCancle.setBounds(509, 286, 97, 23);
		inputPanel.add(btnCancle);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(463, 64, 69, 22);
		inputPanel.add(btnDelete);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(463, 38, 69, 22);
		inputPanel.add(btnUpdate);
		
		JPanel useListPanel = new JPanel();
		useListPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC774\uC6A9 \uB0B4\uC5ED  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		useListPanel.setBounds(671, 26, 291, 319);
		add(useListPanel);
		useListPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		useListPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBorder(new EmptyBorder(4, 0, 0, 9));
		useListPanel.add(btnPanel, BorderLayout.SOUTH);
		btnPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("차트 보기");
		btnPanel.add(btnNewButton, BorderLayout.EAST);
		
		JPanel emptyPanel1 = new JPanel();
		useListPanel.add(emptyPanel1, BorderLayout.NORTH);
		
		JPanel emptyPanel2 = new JPanel();
		useListPanel.add(emptyPanel2, BorderLayout.WEST);
		
		JPanel emptyPanel3 = new JPanel();
		useListPanel.add(emptyPanel3, BorderLayout.EAST);
		
		JPanel clientListPanel = new JPanel();
		clientListPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uACE0\uAC1D \uB9AC\uC2A4\uD2B8  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		clientListPanel.setBounds(12, 358, 950, 349);
		add(clientListPanel);
		clientListPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		clientListPanel.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel lblPanel = new JPanel();
		lblPanel.setBorder(new EmptyBorder(5, 0, 5, 10));
		clientListPanel.add(lblPanel, BorderLayout.SOUTH);
		lblPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblListCount = new JLabel("1/10");
		lblPanel.add(lblListCount, BorderLayout.EAST);
		
		JPanel emptyPanel4 = new JPanel();
		clientListPanel.add(emptyPanel4, BorderLayout.NORTH);
		
		JPanel emptyPanel5 = new JPanel();
		clientListPanel.add(emptyPanel5, BorderLayout.WEST);
		
		JPanel emptyPanel6 = new JPanel();
		clientListPanel.add(emptyPanel6, BorderLayout.EAST);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(865, 717, 97, 23);
		add(btnBack);
	}
}
