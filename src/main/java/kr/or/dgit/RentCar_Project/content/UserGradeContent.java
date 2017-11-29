package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
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

	private ClientManagerContent clientManager;
	
	public void setClientManager(ClientManagerContent clientManager) {
		this.clientManager = clientManager;
	}


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
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "Message",
						JOptionPane.YES_NO_OPTION);
				if (clear == 0) {
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

	public boolean isEmptyCheck() {
		if (userGrade.isEmptyCheck()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isOk(String code) {
		Pattern p = Pattern.compile("(^[A-Z]{1}$)");
		Matcher m = p.matcher(code);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String grade = userGrade.getTextValue();
		int gradeDiscount = 0;

		if (e.getSource() == btnAdd) {

			if (!isEmptyCheck()) {
				if (isOk(grade)) {
					try {
						gradeDiscount = Integer.parseInt(discount.getTextValue());
						if (gradeDiscount <= 0) {
							JOptionPane.showMessageDialog(null, "할인률 0%이하는 적용할 수 없습니다");
							discount.getTextField().requestFocus();
							return;
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "할인률을 다시입력하세요");
						discount.setTextValue("");
						discount.getTextField().requestFocus();
						return;
					}
					int insert = JOptionPane.showConfirmDialog(null, "입력 데이터를 추가하시겠습니까?", "Message",
							JOptionPane.YES_NO_OPTION);
					if (insert == 0) {
						UserGradeService.getInstance().insertUserGrade(new UserGrade(grade, gradeDiscount));
						userGradeList.userGradeTable.loadDate();
						userGradeList.setGradeComboModel();
						setUserGradeTextValueClear();
						setActive(false);
						clientManager.setUserGradeComboBoxModel();
					

					} else {
						JOptionPane.showMessageDialog(null, "취소되었습니다");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "등급은 영문(대문자)만 가능합니다");
					userGrade.setTextValue("");
					userGrade.getTextField().requestFocus();
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "등급을 입력하세요");
				userGrade.getTextField().requestFocus();
				return;
			}

		}

		if (e.getSource() == btnUpdate) {
			if (!isEmptyCheck()) {
				if (isOk(grade)) {
					try {
						gradeDiscount = Integer.parseInt(discount.getTextValue());
						if (gradeDiscount <= 0) {
							JOptionPane.showMessageDialog(null, "할인률이 0%입니다");
							discount.getTextField().requestFocus();
							return;
						}
					}catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "할인률을 다시입력하세요");
						discount.setTextValue("");
						discount.getTextField().requestFocus();
						return;
					}
					int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "Message",
							JOptionPane.YES_NO_OPTION);
					if (update == 0) {
						UserGradeService.getInstance().updateUserGrade(new UserGrade(grade, gradeDiscount));
						userGradeList.userGradeTable.loadDate();
						userGradeList.setGradeComboModel();
						setUserGradeTextValueClear();
						setActive(false);
						clientManager.setUserGradeComboBoxModel();

					} else {
						JOptionPane.showMessageDialog(null, "취소되었습니다");
					}
				} else {
					JOptionPane.showMessageDialog(null, "등급은 영문(대문자)만 가능합니다");
					userGrade.setTextValue("");
					userGrade.getTextField().requestFocus();
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "등급을 입력하세요");
				userGrade.getTextField().requestFocus();
				return;
			}
		}
		if (e.getSource() == btnDelete) {
			if (!isEmptyCheck()) {
				int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "Message",
						JOptionPane.YES_NO_OPTION);
				if (delete == 0) {
					UserGradeService.getInstance().deleteUserGrade(new UserGrade(grade));
					userGradeList.userGradeTable.loadDate();
					userGradeList.setGradeComboModel();
					setUserGradeTextValueClear();
					setActive(false);
					clientManager.setUserGradeComboBoxModel();

				} else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "등급을 입력하세요");
				userGrade.getTextField().requestFocus();
				return;
			}
		}

	}

}
