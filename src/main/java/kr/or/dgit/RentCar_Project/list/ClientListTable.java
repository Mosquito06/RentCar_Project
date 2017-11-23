package kr.or.dgit.RentCar_Project.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.UserService;

public class ClientListTable extends AbstractTable {
	private boolean isFull;
	private User userCode;
	
	public void setUserCode(User userCode) {
		this.userCode = userCode;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public ClientListTable() {}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6,7);
		setCellwidth(30,40,40,60,50,50,30,20);
	}

	@Override
	protected Object[][] getData() {
		
		List<User> lists;
		
		if(isFull) {
			lists = UserService.getInstance().selectUserByAll();
		}else {
			lists = UserService.getInstance().findUserCodeByUserCode(userCode);
		}
		
		Object[][] datas = new Object[lists.size()][];
		
		for(int i=0;i<lists.size();i++) {
			User u = lists.get(i);
			datas[i] = u.toArray();
		}
		return datas;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[]{"고객코드","아이디","고객이름","주소","연락처","이메일","성별","고객등급"};
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
