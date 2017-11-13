package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CarModelContent extends JPanel {
	private TextFieldComponent cmCode;
	private TextFieldComponent carModel;
	public CarModelContent() {
		setLayout(null);
		
		cmCode = new TextFieldComponent("차종 코드");
		cmCode.setBounds(5, 35, 230, 30);
		add(cmCode);
		
		carModel = new TextFieldComponent("차종");
		carModel.setBounds(5, 80, 230, 30);
		add(carModel);
		
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
		btnCancel.setBounds(250, 110, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setCarModelValueClear();
				
			}
		});
		add(btnCancel);

	}
	public void setCarModelValueClear(){
		cmCode.setTextValue("");
		carModel.setTextValue("");
	}
}
