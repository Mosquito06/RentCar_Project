package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class FuelManagerContent extends JPanel {
	
	private TextFieldComponent fuelCode;
	private TextFieldComponent fuelType;
	
	public FuelManagerContent() {
		setLayout(null);
		
		fuelCode = new TextFieldComponent("연료 코드");
		fuelCode.setBounds(5, 35, 230, 30);
		add(fuelCode);
		
		fuelType = new TextFieldComponent("연료 타입");
		fuelType.setBounds(5, 80, 230, 30);
		add(fuelType);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(250, 20, 66, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(250, 45, 66, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(250, 70, 66, 23);
		add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(250, 105, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setFuelTextValueClear();
			}
		});
		add(btnCancel);
	}
	
	public void setFuelTextValueClear() {
		fuelCode.setTextValue("");
		fuelType.setTextValue("");
	}
}
