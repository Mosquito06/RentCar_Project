package kr.or.dgit.RentCar_Project.list;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.RentService;

public class UserHistoryTable extends AbstractTable {
	private Rent rent;
		
	public UserHistoryTable(Rent getRent) {
		this.rent = getRent;
	}

	@Override
	protected void setAlignWidth() {
	
		
	}

	@Override
	protected Object[][] getData() {
		List<Rent> list = RentService.getInstance().selectRentJoinCarData(rent);
		Object[][] datas = new Object[list.size()][];
		
		for(int i = 0; i < list.size(); i++){
			Rent rentObject = list.get(i);
			datas[i] = rentObject.toArray();
		}
		
		return datas;
		
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"차량코드", "차량명", "연식", "오토유무", "인승", "연료타입", "이용시간", "보험 가입 유무", "대여일", "반납일", "최종가격"};
	}

	@Override
	protected Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
