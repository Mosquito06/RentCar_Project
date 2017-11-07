package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RentalPriceManagerContent extends JPanel {


	public RentalPriceManagerContent() {
		setLayout(null);
		
		ComboBoxComponent carCodePanel = new ComboBoxComponent("차 코드");
		carCodePanel.setBounds(5, 23, 230, 30);
		add(carCodePanel);
		
		TextFieldComponent bPricePanel = new TextFieldComponent("기본가격");
		bPricePanel.setBounds(5, 63, 230, 30);
		add(bPricePanel);
		
		TextFieldComponent useTimePanel = new TextFieldComponent("사용시간");
		useTimePanel.setBounds(5, 103, 230, 30);
		add(useTimePanel);
		
		TextFieldComponent atPricePanel = new TextFieldComponent("초과시간단가");
		atPricePanel.setBounds(242, 103, 230, 30);
		add(atPricePanel);
		
		TextFieldComponent btPricePanel = new TextFieldComponent("기본시간단가");
		btPricePanel.setBounds(242, 63, 230, 30);
		add(btPricePanel);
		
		TextFieldComponent insurancePanel = new TextFieldComponent("보험료");
		insurancePanel.setBounds(242, 23, 230, 30);
		add(insurancePanel);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(498, 20, 66, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(498, 45, 66, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(498, 70, 66, 23);
		add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(498, 126, 66, 23);
		add(btnCancel);

	}
}
