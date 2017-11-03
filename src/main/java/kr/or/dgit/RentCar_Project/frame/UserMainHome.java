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

public class UserMainHome extends JPanel {

	public UserMainHome() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(91, 341, 217, 305);
		add(panel);
		panel.setLayout(null);
		
		JButton btnRent = new JButton("대여하기");
		btnRent.setBounds(12, 20, 193, 44);
		panel.add(btnRent);
		
		JButton btnSearch = new JButton("검색하기");
		btnSearch.setBounds(12, 94, 193, 44);
		panel.add(btnSearch);
		
		JButton btnUpdate = new JButton("정보수정 및 이용내역");
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new UserMainUpdate(), BorderLayout.CENTER);
				frame.setVisible(true);
				
				
			}
		});
		btnUpdate.setBounds(12, 171, 193, 44);
		panel.add(btnUpdate);
		
		JButton btnOut = new JButton("나가기");
		btnOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?");
				if(confirm == 0){
					UserMain.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					UserMain.getInstance().setVisible(false);
				}
			}
		});
		btnOut.setBounds(12, 244, 193, 44);
		panel.add(btnOut);
		
		JLabel backImg = new JLabel("");
		backImg.setBounds(0, 0, 974, 751);
		backImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\jeepBack2.jpg"));
		add(backImg);

	}
}
