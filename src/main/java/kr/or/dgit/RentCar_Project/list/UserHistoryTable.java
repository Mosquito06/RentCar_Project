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
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		setAlign(SwingConstants.RIGHT, 12, 13);
		setCellwidth(55, 55, 90, 115, 45, 55, 30, 50, 50, 80, 80, 80 ,80, 80);
	}

	@Override
	protected Object[][] getData() {
		List<Rent> list = RentService.getInstance().selectRentJoinCarData(rent);
		Object[][] datas = new Object[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			Rent rentObject = list.get(i);
			datas[i] = rentObject.toArray(list.get(i).getDayEnd());
		}

		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"예약번호", "상태", "차량코드", "차량명", "연식", "오토유무", "인승", "연료타입", "이용시간", "보험 가입 유무", "대여일", "반납일", "할인요금", "최종가격" };
	}

	@Override
	public Object getSelectedItem() {
		
		// 테이블에서 선택된 객체의 각 정보를 가져와서 Rent 객체로 반환
		int selectIndex = table.getSelectedRow();
		
		int code = (int) table.getValueAt(selectIndex, 0);
		String sSituation = (String) table.getValueAt(selectIndex, 1);
		String carCode= (String) table.getValueAt(selectIndex, 2);
		String userTime = (String) table.getValueAt(selectIndex, 8);
		String sIsInsurance = (String) table.getValueAt(selectIndex, 9);
		String sDate = (String) table.getValueAt(selectIndex, 10);
		String eDate = (String) table.getValueAt(selectIndex, 11);
		String discountPrice = (String) table.getValueAt(selectIndex, 12);
		String finalPrice = (String) table.getValueAt(selectIndex, 13);
				
		String[] selectSDate = sDate.split("/");
		String[] selectEDate = eDate.split("/");
		
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(Integer.parseInt(selectSDate[0]), Integer.parseInt(selectSDate[1])-1, Integer.parseInt(selectSDate[2]));
		
		Calendar dayEnd = GregorianCalendar.getInstance();
		dayEnd.set(Integer.parseInt(selectEDate[0]), Integer.parseInt(selectEDate[1])-1, Integer.parseInt(selectEDate[2]));
		
		CarData carDate = new CarData();
		carDate.setCarCode(carCode);
		
		Rent selectRent = new Rent();
		selectRent.setRentCode(code);
		selectRent.setSituation(getSituation(sSituation));
		selectRent.setCarCode(carDate);
		selectRent.setDiscountPrice(Integer.parseInt(discountPrice.replaceAll(",", "")));
		selectRent.setFinalPrice(Integer.parseInt(finalPrice.replaceAll(",", "")));
		selectRent.setIsInsurance(getIsInsurance(sIsInsurance));
		selectRent.setUserTime(userTime);
		selectRent.setDayStart(dayStart.getTime());
		selectRent.setDayEnd(dayEnd.getTime());
		
		return selectRent;
	}

	private IsInsurance getIsInsurance(String sIsInsurance) {
		if(sIsInsurance.equals("가입")) {
			return IsInsurance.TRUE;
		}else {
			return IsInsurance.FALSE;
		}
	}

	private Situation getSituation(String sSituation) {
		if(sSituation.equals("예약")) {
			return Situation.RESERVATION;
		}else if(sSituation.equals("완료")) {
			return Situation.COMPLETION;
		}else {
			return Situation.CANCELLATION;
		}
		
	}

	

}
