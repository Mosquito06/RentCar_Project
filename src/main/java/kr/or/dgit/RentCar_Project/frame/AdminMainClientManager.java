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

@SuppressWarnings("serial")
public class AdminMainClientManager extends JPanel {
	private JTable table;
	private JTable table_1;

	public AdminMainClientManager() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		ClientManagerContent inputPanel = new ClientManagerContent();
		inputPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uACE0\uAC1D \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputPanel.setBounds(12, 26, 624, 319);
		add(inputPanel);
		inputPanel.setLayout(null);
		
		JPanel useListPanel = new JPanel();
		useListPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC774\uC6A9 \uB0B4\uC5ED  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		useListPanel.setBounds(648, 26, 314, 319);
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
