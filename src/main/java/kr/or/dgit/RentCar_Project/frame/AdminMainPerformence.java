package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kr.or.dgit.RentCar_Project.content.PerformenceContent;
import kr.or.dgit.RentCar_Project.list.AdminPerformenceTable;
import javax.swing.border.TitledBorder;

public class AdminMainPerformence extends JPanel {

	public AdminMainPerformence() {
		setLayout(null);
		
		AdminPerformenceTable adminTable = new AdminPerformenceTable();
		adminTable.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		adminTable.setBounds(0, 80, 595, 671);
		adminTable.loadDate();
		add(adminTable);
		
		JLabel personImg = new JLabel("");
		personImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\chart1.png"));
		personImg.setBounds(209, 6, 158, 71);
		add(personImg);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(null, "\uAC80\uC0C9\uC870\uAC74", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setBounds(601, 0, 373, 375);
		searchPanel.setLayout(null);
		add(searchPanel);
		
		PerformenceContent perform = new PerformenceContent();
		perform.setBounds(12, 22, 349, 354);
		searchPanel.add(perform);
				
		JPanel chartPanel = new JPanel();
		chartPanel.setBorder(new TitledBorder(null, "\uACB0\uACFC\uC694\uC57D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		chartPanel.setBounds(601, 380, 372, 371);
		add(chartPanel);
		chartPanel.setLayout(null);
		
		JPanel chartBtnPanel = new JPanel();
		chartBtnPanel.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		chartBtnPanel.setBounds(0, 334, 372, 37);
		chartPanel.add(chartBtnPanel);
		chartBtnPanel.setLayout(null);
		
		JButton btnSpecific = new JButton("자세히 보기");
		btnSpecific.setBounds(41, 7, 139, 23);
		chartBtnPanel.add(btnSpecific);
		
		JButton btnExit = new JButton("나가기");
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		btnExit.setBounds(204, 7, 139, 23);
		chartBtnPanel.add(btnExit);
		
		JLabel chartImg = new JLabel("");
		chartImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\chart2.png"));
		chartImg.setBounds(12, 0, 348, 334);
		chartPanel.add(chartImg);
		
	}
}
