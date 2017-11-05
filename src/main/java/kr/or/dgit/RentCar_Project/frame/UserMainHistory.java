package kr.or.dgit.RentCar_Project.frame;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kr.or.dgit.RentCar_Project.list.UserHistoryTable;

public class UserMainHistory extends JPanel {

	public UserMainHistory() {
		setLayout(null);
		
		UserHistoryTable historyTable = new UserHistoryTable();
		historyTable.setBounds(0, 80, 974, 671);
		historyTable.loadDate();
		add(historyTable);
	}
}
