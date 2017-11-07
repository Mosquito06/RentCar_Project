package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JButton;

public class ManufacturerManagerContent extends JPanel {

	public ManufacturerManagerContent() {
		setLayout(null);
		
		TextFieldComponent codePanel = new TextFieldComponent("제조회사 코드");
		codePanel.setBounds(10, 30, 230, 30);
		add(codePanel);
		
		TextFieldComponent namePanel = new TextFieldComponent("제조사 이름");
		namePanel.setBounds(10, 70, 230, 30);
		add(namePanel);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(280, 105, 66, 23);
		add(btnCancel);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(280, 65, 66, 23);
		add(btnDelete);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(280, 40, 66, 23);
		add(btnUpdate);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(280, 15, 66, 23);
		add(btnAdd);

	}
}
