package kr.or.dgit.RentCar_Project.list;

import javax.swing.JPanel;

public class UserHistoryTable extends AbstractTable {

	public UserHistoryTable() {

	}

	@Override
	protected void setAlignWidth() {
	
		
	}

	@Override
	protected Object[][] getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getcolumnNames() {
		return new String[] {"차량코드", "차량명", "연식", "오토유무", "인승", "연료타입", "이용시간", "보험 가입 유무", "대여일", "반납일", "최종가격"};
	}

}
