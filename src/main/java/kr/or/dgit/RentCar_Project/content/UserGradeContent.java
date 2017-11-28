package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.service.UserGradeService;

@SuppressWarnings("serial")
public class UserGradeContent extends JPanel implements ActionListener {
	
	private TextFieldComponent userGrade;
	private TextFieldComponent discount;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private UserGradeListContent userGradeList;

	public void setUserGradeList(UserGradeListContent userGradeList) {
		this.userGradeList = userGradeList;
	}
	
	public UserGradeContent() {
		setBounds(100, 100, 333, 171);
		setLayout(null);
		
		userGrade = new TextFieldComponent("고객 등급");
		userGrade.setBounds(3, 25, 276, 30);
		add(userGrade);
		
		discount = new TextFieldComponent("할인률");
		discount.setBounds(3, 65, 276, 30);
		add(discount);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(33, 117, 66, 23);
		add(btnAdd);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(98, 117, 66, 23);
		add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(163, 117, 66, 23);
		add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(253, 117, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if(clear==0) {
					setUserGradeTextValueClear();
					setActive(false);
				}
			}

		});
		add(btnCancel);
		setActive(false);
	}
	
	public TextFieldComponent getUserGrade() {
		return userGrade;
	}

	public TextFieldComponent getDiscount() {
		return discount;
	}

	public void setUserGradeTextValueClear() {
		userGrade.setTextValue("");
		discount.setTextValue("");
		
	}
	public void setActive(boolean active) {
		btnUpdate.setEnabled(active);
		btnDelete.setEnabled(active);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String grade = userGrade.getTextValue();
		int gradeDiscount = Integer.parseInt(discount.getTextValue());
		
		if(e.getSource() == btnAdd) {
			
			int insert = JOptionPane.showConfirmDialog(null, "입력 데이터를 추가하시겠습니까?", "확인창",
					JOptionPane.OK_CANCEL_OPTION);
			if(insert==0) {
				UserGradeService.getInstance().insertUserGrade(new UserGrade(grade, gradeDiscount));
				userGradeList.userGradeTable.loadDate();
				userGradeList.setGradeComboModel();
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}
		if(e.getSource() == btnUpdate) {
			int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "확인창",
					JOptionPane.OK_CANCEL_OPTION);
			if(update==0) {
				UserGradeService.getInstance().updateUserGrade(new UserGrade(grade, gradeDiscount));
				userGradeList.userGradeTable.loadDate();
				userGradeList.setGradeComboModel();
				setActive(false);
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}
		if(e.getSource()==btnDelete) {
			int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
			if(delete==0) {
				UserGradeService.getInstance().deleteUserGrade(new UserGrade(grade));
				userGradeList.userGradeTable.loadDate();
				userGradeList.setGradeComboModel();
				setActive(false);
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}
	}
	
}
