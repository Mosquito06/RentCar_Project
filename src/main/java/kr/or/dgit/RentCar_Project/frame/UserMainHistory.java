package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.HistorySearchContent;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.list.UserHistoryTable;
import kr.or.dgit.RentCar_Project.service.RentService;

public class UserMainHistory extends JPanel {
	private Rent rent;
	private User ComfirmUser;
	private UserHistoryTable historyTable;
		
	public void setComfirmUser(User comfirmUser) {
		this.ComfirmUser = comfirmUser;
	}
	
	
	public UserMainHistory() {
		setLayout(null);
		
		HistorySearchContent searchContent = new HistorySearchContent();
		
		// 검색하기 버튼 리스너
		searchContent.getBtnSearch().addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] FirstDate = searchContent.getFirstDateField().getText().split("/");
				String[] LastDate = searchContent.getLastDateField().getText().split("/");
				
				rent = new Rent();
				rent.setUserCode(ComfirmUser);
				
				List<Rent> findRent = RentService.getInstance().selectRentByUserCode(rent);
				
				Calendar dayStart = GregorianCalendar.getInstance();
				dayStart.set(Integer.parseInt(FirstDate[0]), Integer.parseInt(FirstDate[1])-1, Integer.parseInt(FirstDate[2]));
				
				Calendar dayEnd = GregorianCalendar.getInstance();
				dayEnd.set(Integer.parseInt(LastDate[0]), Integer.parseInt(LastDate[1])-1, Integer.parseInt(LastDate[2]));
				
				findRent.get(0).setDayStart(dayStart.getTime());
				findRent.get(0).setDayEnd(dayEnd.getTime());
				
				historyTable.setRent(findRent.get(0));
				historyTable.loadDate();
				JOptionPane.showMessageDialog(null, "불러오기가 완료되었습니다.");
				
			}
		});
		searchContent.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uAC80\uC0C9\uC870\uAC74", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchContent.setBounds(0, 5, 974, 97);
		add(searchContent);
		
		// 취소하기 버튼 리스너
		searchContent.getBtnCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Rent selectItem = (Rent) historyTable.getSelectedItem();
				if(selectItem.getCarCode() == null || selectItem.getFinalPrice() == 0 || selectItem.getUserTime() == null) {
					JOptionPane.showMessageDialog(null, "취소할 데이터를 찾지 못했습니다.");
					return;
				}
				
				RentService.getInstance().UserHistoryDelete(selectItem);
				historyTable.loadDate();
				JOptionPane.showMessageDialog(null, "예약을 취소하였습니다.");
				
			}
		});
		
		// 나가기 버튼 리스너
		searchContent.getBtnExit().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				UserMainHome userMainHome = new UserMainHome();
				userMainHome.setComfirmUser(ComfirmUser);
				frame.getContentPane() .add(userMainHome, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		
		historyTable = new UserHistoryTable();
		historyTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		historyTable.setBounds(0, 116, 974, 635);
		historyTable.loadDate();
		add(historyTable);
	}
}
