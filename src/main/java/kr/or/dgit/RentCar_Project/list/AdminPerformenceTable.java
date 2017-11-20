package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.service.RentService;

public class AdminPerformenceTable extends AbstractTable {
	
	private List<Rent> list;
	private int toStringType;
	
	public AdminPerformenceTable(List<Rent> list, int toStringType) {
		super();
		this.list = list;
		this.toStringType = toStringType;
	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3);
		setAlign(SwingConstants.RIGHT, 4, 5);
		setCellwidth(40, 60, 100, 60, 60, 60);

	}

	@Override
	protected Object[][] getData() {
		Object[][] datas = new Object[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			Rent rentObject = list.get(i);
			datas[i] = rentObject.PerformenceToTaltoArray(toStringType);
		}

		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"차종", "제조사", "차종명", "이용시간", "할인요금", "최종요금"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
