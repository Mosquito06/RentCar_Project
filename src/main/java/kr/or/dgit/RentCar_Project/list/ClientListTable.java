package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.UserService;

public class ClientListTable extends AbstractTable {

	public ClientListTable() {}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6);
	}

	@Override
	protected Object[][] getData() {
		List<User> lists = UserService.getInstance().selectUserByAll();
		Object[][] datas = new Object[lists.size()][];
		
		for(int i=0;i<lists.size();i++) {
			User u = lists.get(i);
			datas[i] = u.toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[]{"고객코드","아이디","고객이름","연락처","이메일","성별","고객등급"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
