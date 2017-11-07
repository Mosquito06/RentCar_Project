package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JButton;

public class FuelManagerContent extends JPanel {

	public FuelManagerContent() {
		setLayout(null);
		
		TextFieldComponent fuelCodePanel = new TextFieldComponent("연료 코드");
		fuelCodePanel.setBounds(8, 35, 230, 30);
		add(fuelCodePanel);
		
		TextFieldComponent fuelTypePanel = new TextFieldComponent("연료 타입");
		fuelTypePanel.setBounds(8, 80, 230, 30);
		add(fuelTypePanel);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(280, 20, 66, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(280, 45, 66, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(280, 70, 66, 23);
		add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(280, 126, 66, 23);
		add(btnCancel);

	}
}
