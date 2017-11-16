package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.service.FuelService;

@SuppressWarnings("serial")
public class FindFuelTable extends AbstractTable {
	private Fuel fuel;
	
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1);
	}

	@Override
	protected Object[][] getData() {
		
		List<Fuel> lists = FuelService.getInstance().FindFuelByFuelCode(fuel);
		Object[][] datas = new Object[lists.size()][];
		
		for(int i=0;i<lists.size();i++) {
			Fuel f = lists.get(i);
			datas[i] = f.toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"연료코드","연료타입"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
