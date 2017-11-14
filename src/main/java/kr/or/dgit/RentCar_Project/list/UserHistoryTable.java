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
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		setCellwidth(90, 115, 65, 65, 30);
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
		
		String startDay = (String) table.getValueAt(selectIndex, 8);
		String[] FirstDate = startDay.split("/");
		
		String endDay = (String) table.getValueAt(selectIndex, 9);
		String[] LastDate = endDay.split("/");
		
		CarData carDate = new CarData();
		carDate.setCarCode(carCode);
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(Integer.parseInt(FirstDate[0]), Integer.parseInt(FirstDate[1])-1, Integer.parseInt(FirstDate[2]));
		
		Calendar dayEnd = GregorianCalendar.getInstance();
		dayEnd.set(Integer.parseInt(LastDate[0]), Integer.parseInt(LastDate[1])-1, Integer.parseInt(LastDate[2]));
		
		Rent selectRent = new Rent();
		selectRent.setCarCode(carDate);
		selectRent.setDayStart(dayStart.getTime());
		selectRent.setDayEnd(dayEnd.getTime());
		
		return selectRent;
	}

}
