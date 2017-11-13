package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ManufacturerManagerContent extends JPanel {
	
	private TextFieldComponent mfCode;
	private TextFieldComponent mfName;
	
	public ManufacturerManagerContent() {
		setLayout(null);
		
		mfCode = new TextFieldComponent("제조회사 코드");
		mfCode.setBounds(10, 30, 230, 30);
		add(mfCode);
		
		mfName = new TextFieldComponent("제조사 이름");
		mfName.setBounds(10, 70, 230, 30);
		add(mfName);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(260, 105, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setManufacturerTextValueClear();
				
			}
		});
		add(btnCancel);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(260, 65, 66, 23);
		add(btnDelete);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(260, 40, 66, 23);
		add(btnUpdate);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(260, 15, 66, 23);
		add(btnAdd);

	}
	public void setManufacturerTextValueClear() {
		mfCode.setTextValue("");
		mfName.setTextValue("");
	}
}
