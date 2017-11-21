package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.service.CarDataService;

public class CarDataTable extends AbstractTable {
	private boolean isFull;
	private CarData carDataCode;
	
	
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public void setCarDataCode(CarData carDataCode) {
		this.carDataCode = carDataCode;
	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6,7,8);
		setCellwidth(50,50,40,30,30,30,50,50,50);
	}

	@Override
	protected Object[][] getData() {
		List<CarData> lists;
		if(isFull) {
			lists = CarDataService.getInstance().selectCarDataByAll();
		}else {
			lists = CarDataService.getInstance().selectCarDataByCarDataCodeList(carDataCode);
		}
		
		Object[][] datas = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++) {
			CarData cd = lists.get(i);
			datas[i] = cd.toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"차 코드","차 이름","연식","차량대수","오토유무","인승","차종 코드","제조회사 코드","연료 코드"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
