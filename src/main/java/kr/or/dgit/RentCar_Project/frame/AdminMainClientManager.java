package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.ClientManagerContent;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.list.ClientListTable;
import kr.or.dgit.RentCar_Project.service.UserService;
import javax.swing.SwingConstants;
import kr.or.dgit.RentCar_Project.content.ClientlListManagerContent;

@SuppressWarnings("serial")
public class AdminMainClientManager extends JPanel {

	private ClientManagerContent inputPanel;
	private ClientlListManagerContent clientListPanel;

	public AdminMainClientManager() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		inputPanel = new ClientManagerContent();
		inputPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uACE0\uAC1D \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputPanel.setBounds(12, 5, 950, 375);
		add(inputPanel);
		inputPanel.setLayout(null);
		
		clientListPanel = new ClientlListManagerContent();
		clientListPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uACE0\uAC1D \uB9AC\uC2A4\uD2B8  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		clientListPanel.setBounds(12, 385, 950, 331);
		add(clientListPanel);
		clientListPanel.setLayout(null);
		
		inputPanel.setClientListManager(clientListPanel);
		
		
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
		btnBack.setBounds(865, 726, 97, 23);
		add(btnBack);
	}

	public int totalList() {
		List<User> lists =  UserService.getInstance().selectUserByAll();
		return lists.size();
	}
}
