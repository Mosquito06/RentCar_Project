package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.service.RentService;

public class RentTable extends AbstractTable {
	private Rent rent;
	
	
	public void setRent(Rent rent) {
		this.rent = rent;
	}

	@Override
	protected void setAlignWidth() {
		// TODO Auto-generated method stub

	}

	@Override
	protected Object[][] getData() {
		List<Rent> lists = RentService.getInstance().selectRentByCarCode(rent);
		Object[][] datas = new Object[lists.size()][];
		for(int i=0; i<lists.size();i++) {
			Rent r = lists.get(i);
			datas[i] = r.toRentTable();
		}
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"고객코드","고객명","연락처","대여일","반납일","사용시간","할인가격","최종가격","보험유무","상태"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
