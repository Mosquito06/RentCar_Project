package kr.or.dgit.RentCar_Project.list;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.RentService;

public class UserHistoryTable extends AbstractTable {
	private Rent rent;

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public UserHistoryTable() {

	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		setAlign(SwingConstants.RIGHT, 10);
		setCellwidth(90, 115, 55, 55, 30, 50, 50, 70, 80, 80 ,80);
	}

	@Override
	protected Object[][] getData() {
		List<Rent> list = RentService.getInstance().selectRentJoinCarData(rent);
		Object[][] datas = new Object[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			Rent rentObject = list.get(i);
			datas[i] = rentObject.toArray();
		}

		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] { "차량코드", "차량명", "연식", "오토유무", "인승", "연료타입", "이용시간", "보험 가입 유무", "대여일", "반납일", "최종가격" };
	}

	@Override
	public Object getSelectedItem() {
		
		// 테이블에서 선택된 객체의 대여일, 반납일, 차량코드를 가져와서 Rent 객체로 반환
		
		int selectIndex = table.getSelectedRow();
		String carCode= (String) table.getValueAt(selectIndex, 0);
		String userTime = (String) table.getValueAt(selectIndex, 6);
		String date = (String) table.getValueAt(selectIndex, 8);
		String[] selectDate = date.split("/");
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(Integer.parseInt(selectDate[0]), Integer.parseInt(selectDate[1])-1, Integer.parseInt(selectDate[2]));
		
		
		int finalPrice = (int) table.getValueAt(selectIndex, 10);
		
		CarData carDate = new CarData();
		carDate.setCarCode(carCode);
				
		Rent selectRent = new Rent();
		selectRent.setCarCode(carDate);
		selectRent.setFinalPrice(finalPrice);
		selectRent.setUserTime(userTime);
		selectRent.setDayStart(dayStart.getTime());
		
		return selectRent;
	}

}
