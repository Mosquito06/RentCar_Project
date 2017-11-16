package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.RentalPrice;
import kr.or.dgit.RentCar_Project.service.RentalPriceService;

public class RentalPriceTable extends AbstractTable {

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,2);
		setAlign(SwingConstants.RIGHT,1,3,4,5);

	}

	@Override
	protected Object[][] getData() {
		List<RentalPrice> lists = RentalPriceService.getInstance().selectRentalPriceByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++) {
			RentalPrice rp = lists.get(i);
			datas[i] = rp.toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"차코드","기본가격","사용시간","기본시간단가","초과시간단가","보험료"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
