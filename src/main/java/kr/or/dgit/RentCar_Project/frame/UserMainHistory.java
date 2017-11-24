package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
import kr.or.dgit.RentCar_Project.dto.Situation;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.list.UserHistoryTable;
import kr.or.dgit.RentCar_Project.service.RentService;

public class UserMainHistory extends JPanel {
	private Rent rent;
	private User ComfirmUser;
	private List<Rent> findRent;
	private String[] firstDate;
	private String[] lastDate;
	private UserHistoryTable historyTable;
		
	public void setComfirmUser(User comfirmUser) {
		this.ComfirmUser = comfirmUser;
	}
	
	
	public UserMainHistory(User comfirmUser) {
		this.ComfirmUser = comfirmUser;
		setLayout(null);
		
		HistorySearchContent searchContent = new HistorySearchContent();
		
		// 검색하기 버튼 리스너
		searchContent.getBtnSearch().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(findRent.isEmpty()) {
					JOptionPane.showMessageDialog(null, "이용내역이 존재하지 않습니다.");
					return;
				}
				
				firstDate = searchContent.getFirstDateField().getText().split("/");
				lastDate = searchContent.getLastDateField().getText().split("/");
				
				historyTable.setRent(setDate(firstDate, lastDate));
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
				try {
					Rent selectItem = (Rent) historyTable.getSelectedItem();
					
					Date CurrentDate = new Date();
					int CompareDate = CurrentDate.compareTo(selectItem.getDayStart());
					
					if(CompareDate < 0 && selectItem.getSituation().equals(Situation.RESERVATION)) {
						int Confirm = JOptionPane.showConfirmDialog(null, "정말로 예약을 취소하시겠습니까?");
						if(Confirm == JOptionPane.YES_OPTION) {
							selectItem.setSituation(Situation.CANCELLATION);
							selectItem.setUserCode(ComfirmUser);
							RentService.getInstance().UserHistoryUpdate(selectItem);
							historyTable.loadDate();
							JOptionPane.showMessageDialog(null, "예약을 취소하였습니다.");  
						}
					}else {
						JOptionPane.showMessageDialog(null, "취소할 수 없는 내역입니다");
					}
				}catch(ArrayIndexOutOfBoundsException a) {
					JOptionPane.showMessageDialog(null, "취소할 내역을 선택해주세요.");
				}
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
				frame.getContentPane().add(userMainHome, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		
		
		rent = new Rent();
		rent.setUserCode(ComfirmUser);
		
		findRent = RentService.getInstance().selectRentByUserCode(rent);
		
		SimpleDateFormat dateFirstFormat = new SimpleDateFormat("yyyy/MM/01");
		SimpleDateFormat dateLastFormat = new SimpleDateFormat("yyyy/MM/31");
		Date Fdate = new Date();
		Date Ldate = new Date();
						
		firstDate = dateFirstFormat.format(Fdate).split("/");
		lastDate = dateLastFormat.format(Ldate).split("/");
				
		historyTable = new UserHistoryTable();
		historyTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		historyTable.setBounds(0, 116, 974, 635);
		historyTable.setRent(setDate(firstDate, lastDate));
		historyTable.loadDate();
		add(historyTable);
	}
	
	// 날짜 설정 함수
	private Rent setDate(String[] FirstDate, String[] LastDate) {
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(Integer.parseInt(FirstDate[0]), Integer.parseInt(FirstDate[1])-1, Integer.parseInt(FirstDate[2]));
		
		Calendar dayEnd = GregorianCalendar.getInstance();
		dayEnd.set(Integer.parseInt(LastDate[0]), Integer.parseInt(LastDate[1])-1, Integer.parseInt(LastDate[2]));
		
		findRent.get(0).setDayStart(dayStart.getTime());
		findRent.get(0).setDayEnd(dayEnd.getTime());
		return findRent.get(0);
	}
}
