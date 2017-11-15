package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ManufacturerManagerContent extends JPanel {
	
	private TextFieldComponent mfCode;
	private TextFieldComponent mfName;
	
	public ManufacturerManagerContent() {
		setBounds(100, 100, 333, 171);
		setLayout(null);
		
		mfCode = new TextFieldComponent("제조회사 코드");
		mfCode.setBounds(3, 25, 276, 30);
		add(mfCode);
		
		mfName = new TextFieldComponent("제조사 이름");
		mfName.setBounds(3, 65, 276, 30);
		add(mfName);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(253, 117, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if(clear==0)setManufacturerTextValueClear();
				
			}
		});
		add(btnCancel);

		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(33, 117, 66, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(98, 117, 66, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(163, 117, 66, 23);
		add(btnDelete);
		
		
		

	}
	public void setManufacturerTextValueClear() {
		mfCode.setTextValue("");
		mfName.setTextValue("");
	}
}
