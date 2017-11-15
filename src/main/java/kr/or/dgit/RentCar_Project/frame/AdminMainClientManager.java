package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.ClientManagerContent;
import kr.or.dgit.RentCar_Project.list.ClientListTable;

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
		
		JLabel lblListCount = new JLabel("1/10");
		lblPanel.add(lblListCount, BorderLayout.EAST);
		
		JPanel emptyPanel4 = new JPanel();
		clientListPanel.add(emptyPanel4, BorderLayout.NORTH);
		
		JPanel emptyPanel5 = new JPanel();
		clientListPanel.add(emptyPanel5, BorderLayout.WEST);
		
		JPanel emptyPanel6 = new JPanel();
		clientListPanel.add(emptyPanel6, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		clientListPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
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
}
