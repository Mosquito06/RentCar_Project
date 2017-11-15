package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;

public class UserGradeContent extends JPanel {
	
	private TextFieldComponent userGrade;
	private TextFieldComponent discount;

	public UserGradeContent() {
		setBounds(100, 100, 333, 171);
		setLayout(null);
		
		userGrade = new TextFieldComponent("고객 등급");
		userGrade.setBounds(3, 25, 276, 30);
		add(userGrade);
		
		discount = new TextFieldComponent("할인률");
		discount.setBounds(3, 65, 276, 30);
		add(discount);
		
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
				if(clear==0)setUserGradeTextValueClear();
			}

		});
		add(btnCancel);
	}
	
	public void setUserGradeTextValueClear() {
		userGrade.setTextValue("");
		discount.setTextValue("");
		
	}

}
