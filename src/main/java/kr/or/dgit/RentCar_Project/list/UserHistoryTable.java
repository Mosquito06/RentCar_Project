package kr.or.dgit.RentCar_Project.list;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.IsInsurance;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.dto.Situation;
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
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		setAlign(SwingConstants.RIGHT, 11);
		setCellwidth(55, 90, 115, 55, 55, 30, 50, 50, 70, 80, 80 ,80);
	}

	@Override
	protected Object[][] getData() {
		List<Rent> list = RentService.getInstance().selectRentJoinCarData(rent);
		Object[][] datas = new Object[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			Rent rentObject = list.get(i);
			datas[i] = rentObject.toArray(list.get(i).getDayStart());
		}

		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"상태", "차량코드", "차량명", "연식", "오토유무", "인승", "연료타입", "이용시간", "보험 가입 유무", "대여일", "반납일", "최종가격" };
	}

	@Override
	public Object getSelectedItem() {
		
		// 테이블에서 선택된 객체의 각 정보를 가져와서 Rent 객체로 반환
		int selectIndex = table.getSelectedRow();
		
		String sSituation = (String) table.getValueAt(selectIndex, 0);
		String carCode= (String) table.getValueAt(selectIndex, 1);
		String userTime = (String) table.getValueAt(selectIndex, 7);
		IsInsurance sIsInsurance = (IsInsurance) table.getValueAt(selectIndex, 8);
		String sDate = (String) table.getValueAt(selectIndex, 9);
		String eDate = (String) table.getValueAt(selectIndex, 10);
		int finalPrice = (int) table.getValueAt(selectIndex, 11);
		
		String[] selectSDate = sDate.split("/");
		String[] selectEate = eDate.split("/");
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(Integer.parseInt(selectSDate[0]), Integer.parseInt(selectSDate[1])-1, Integer.parseInt(selectSDate[2]));
		
		Calendar dayEnd = GregorianCalendar.getInstance();
		dayStart.set(Integer.parseInt(selectEate[0]), Integer.parseInt(selectEate[1])-1, Integer.parseInt(selectEate[2]));
		
		CarData carDate = new CarData();
		carDate.setCarCode(carCode);
		
		Rent selectRent = new Rent();
		selectRent.setSituation(getSituation(sSituation));
		selectRent.setCarCode(carDate);
		selectRent.setFinalPrice(finalPrice);
		selectRent.setIsInsurance(sIsInsurance);
		selectRent.setUserTime(userTime);
		selectRent.setDayStart(dayStart.getTime());
		selectRent.setDayEnd(dayEnd.getTime());
		
		return selectRent;
	}

	private Situation getSituation(String sSituation) {
		if(sSituation.equals(Situation.RESERVATION)) {
			return Situation.RESERVATION;
		}else if(sSituation.equals(Situation.COMPLETION)) {
			return Situation.COMPLETION;
		}else {
			return Situation.CANCELLATION;
		}
		
	}

	

}
