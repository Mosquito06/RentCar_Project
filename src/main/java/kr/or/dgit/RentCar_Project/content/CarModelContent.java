package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;

@SuppressWarnings("serial")
public class CarModelContent extends JPanel {
	private TextFieldComponent cmCode;
	private TextFieldComponent carModel;
	
	public CarModelContent() {
		setBounds(100, 100, 333, 171);
		setLayout(null);
		
		
		cmCode = new TextFieldComponent("차종 코드");
		cmCode.setBounds(3, 25, 276, 30);
		add(cmCode);
		
		carModel = new TextFieldComponent("차종");
		carModel.setBounds(3, 65, 276, 30);
		add(carModel);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(33, 117, 66, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(98, 117, 66, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(163, 117, 66, 23);
		add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(253, 117, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if(clear==0)setCarModelValueClear();
			}
		});
		add(btnCancel);

	}
	
	
	public TextFieldComponent getCmCode() {
		return cmCode;
	}


	public TextFieldComponent getCarModel() {
		return carModel;
	}


	public void setCarModelValueClear(){
		cmCode.setTextValue("");
		carModel.setTextValue("");
	}
}
