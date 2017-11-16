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

@SuppressWarnings("serial")
public class AdminMainClientManager extends JPanel {
	private ClientListTable clientListTable;

	public AdminMainClientManager() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		ClientManagerContent inputPanel = new ClientManagerContent();
		inputPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uACE0\uAC1D \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputPanel.setBounds(27, 26, 924, 319);
		add(inputPanel);
		inputPanel.setLayout(null);
		
		JPanel clientListPanel = new JPanel();
		clientListPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uACE0\uAC1D \uB9AC\uC2A4\uD2B8  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		clientListPanel.setBounds(25, 358, 924, 349);
		add(clientListPanel);
		clientListPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel lblPanel = new JPanel();
		lblPanel.setBorder(new EmptyBorder(5, 0, 5, 10));
		clientListPanel.add(lblPanel, BorderLayout.SOUTH);
		lblPanel.setLayout(new BorderLayout(0, 0));
		
		
		JLabel lblListCount = new JLabel("/"+totalList());
		lblPanel.add(lblListCount, BorderLayout.EAST);
		
		JPanel emptyPanel4 = new JPanel();
		clientListPanel.add(emptyPanel4, BorderLayout.NORTH);
		emptyPanel4.setLayout(new BorderLayout(5, 5));
		
		JButton bntAll = new JButton("전체보기");
		bntAll.setHorizontalAlignment(SwingConstants.RIGHT);
		emptyPanel4.add(bntAll, BorderLayout.EAST);
		
		JPanel emptyPanel5 = new JPanel();
		clientListPanel.add(emptyPanel5, BorderLayout.WEST);
		
		JPanel emptyPanel6 = new JPanel();
		clientListPanel.add(emptyPanel6, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		clientListPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(5, 5));
		clientListTable = new ClientListTable();
		clientListTable.loadDate();
		panel.add(clientListTable,BorderLayout.CENTER);
		
		
		
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

	public int totalList() {
		List<User> lists =  UserService.getInstance().selectUserByAll();
		return lists.size();
	}
}
