package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.content.HistorySearchContent;
import kr.or.dgit.RentCar_Project.list.UserHistoryTable;

public class UserMainHistory extends JPanel {

	public UserMainHistory() {
		setLayout(null);
		
		HistorySearchContent searchContent = new HistorySearchContent();
		searchContent.setBounds(0, 21, 974, 65);
		add(searchContent);
		
		// 나가기 버튼 리스너
		searchContent.getBtnExit().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new UserMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		
		UserHistoryTable historyTable = new UserHistoryTable();
		historyTable.setBounds(0, 96, 974, 655);
		historyTable.loadDate();
		add(historyTable);
	}
}
