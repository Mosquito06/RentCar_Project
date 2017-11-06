package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminMainHome extends JPanel {

	public AdminMainHome() {
		setLayout(null);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(91, 341, 217, 305);
		add(btnPanel);
		btnPanel.setLayout(null);
		
		JButton btnRent = new JButton("고객관리");
		btnRent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainClientManager(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnRent.setBounds(12, 20, 193, 44);
		btnPanel.add(btnRent);
		
		JButton btnSearch = new JButton("차량관리");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnSearch.setBounds(12, 94, 193, 44);
		btnPanel.add(btnSearch);
		
		JButton btnUpdate = new JButton("성과현황관리");
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainPerformence(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnUpdate.setBounds(12, 171, 193, 44);
		btnPanel.add(btnUpdate);
		
		JButton btnOut = new JButton("나가기");
		btnOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?");
				if(confirm == 0){
					AdminMain.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					AdminMain.getInstance().setVisible(false);
				}
			}
		});
		btnOut.setBounds(12, 244, 193, 44);
		btnPanel.add(btnOut);
		 
		JLabel backImg = new JLabel();
		backImg.setBounds(0, 0, 974, 751);
		backImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\adminBack.jpg"));
		add(backImg);

	}
}
