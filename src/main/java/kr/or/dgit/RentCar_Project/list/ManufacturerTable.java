package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

public class ManufacturerTable extends AbstractTable {

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1);

	}

	@Override
	protected Object[][] getData() {
		List<Manufacturer> lists = ManufacturerService.getInstance().selectManufacturerByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++) {
			Manufacturer mf = lists.get(i);
			datas[i] = mf.toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"제조회사 코드","제조사 이름"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
