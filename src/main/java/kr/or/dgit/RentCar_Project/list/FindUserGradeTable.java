package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.service.UserGradeService;

@SuppressWarnings("serial")
public class FindUserGradeTable extends AbstractTable {
	private UserGrade userGrade;
	
	
	public void setUserGrade(UserGrade userGrade) {
		this.userGrade = userGrade;
	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1);
	}

	@Override
	protected Object[][] getData() {
		List<UserGrade> lists = UserGradeService.getInstance().findUserGradeByGrade(userGrade);
		Object[][] data = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++) {
			UserGrade ug = lists.get(i);
			data[i] = ug.toArray();
		}
		return data;
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
