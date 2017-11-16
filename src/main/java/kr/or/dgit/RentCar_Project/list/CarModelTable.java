package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.CarModelService;

public class CarModelTable extends AbstractTable {
	public CarModelTable() {
	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1);
	}

	@Override
	protected Object[][] getData() {
		List<CarModel> lists = CarModelService.getInstance().selectCarModelByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++) {
			CarModel cm = lists.get(i);
			datas[i] = cm.toArray();
		}	
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"차종 코드","차종"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
