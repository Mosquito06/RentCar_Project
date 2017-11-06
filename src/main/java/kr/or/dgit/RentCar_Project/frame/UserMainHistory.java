package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.content.HistorySearchContent;
import kr.or.dgit.RentCar_Project.list.UserHistoryTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class UserMainHistory extends JPanel {

	public UserMainHistory() {
		setLayout(null);
		
		HistorySearchContent searchContent = new HistorySearchContent();
		searchContent.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uAC80\uC0C9\uC870\uAC74", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchContent.setBounds(0, 5, 974, 97);
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
		historyTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		historyTable.setBounds(0, 116, 974, 635);
		historyTable.loadDate();
		add(historyTable);
	}
}
