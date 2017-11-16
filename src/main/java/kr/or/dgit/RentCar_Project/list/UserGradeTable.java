package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.UserGrade;

import kr.or.dgit.RentCar_Project.service.UserGradeService;

public class UserGradeTable extends AbstractTable {

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1);

	}

	@Override
	protected Object[][] getData() {
		List<UserGrade> lists = UserGradeService.getInstance().selectUserGradeByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0; i<lists.size();i++) {
			UserGrade ug = lists.get(i);
			datas[i] = ug.toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"고객등급","할인률(%)"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
