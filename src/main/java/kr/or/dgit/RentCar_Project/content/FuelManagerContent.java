package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.frame.AdminMainCarManagerCarDetail;
import kr.or.dgit.RentCar_Project.service.FuelService;

@SuppressWarnings("serial")
public class FuelManagerContent extends JPanel implements ActionListener {

	private TextFieldComponent fuelCode;
	private TextFieldComponent fuelType;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;

	public FuelManagerContent() {
		setBounds(100, 100, 333, 171);
		setLayout(null);
		fuelCode = new TextFieldComponent("연료 코드");
		fuelCode.setBounds(3, 25, 276, 30);
		add(fuelCode);
		fuelType = new TextFieldComponent("연료 타입");
		fuelType.setBounds(3, 65, 276, 30);
		add(fuelType);

		btnAdd = new JButton("추가");
		btnAdd.setBounds(33, 117, 66, 23);
		btnAdd.addActionListener(this);
		add(btnAdd);

		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(98, 117, 66, 23);
		btnUpdate.addActionListener(this);
		add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.setBounds(163, 117, 66, 23);
		btnDelete.addActionListener(this);
		add(btnDelete);

		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(253, 117, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "확인창",
						JOptionPane.OK_CANCEL_OPTION);
				if (clear == 0)
					setFuelTextValueClear();
					isEnabledBtn(false);
			}
		});
		add(btnCancel);
		isEnabledBtn(false);
	}

	public TextFieldComponent getFuelCode() {
		return fuelCode;
	}

	public TextFieldComponent getFuelType() {
		return fuelType;
	}

	public void setFuelTextValueClear() {
		fuelCode.setTextValue("");
		fuelType.setTextValue("");
	}
	
	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public boolean isEmptyCheck() {
		if (fuelCode.isEmptyCheck() && fuelType.isEmptyCheck()) {
			return false;
		} else {
			fuelCode.requestFocus();
			return true;
		}
	}
	public boolean codeEmptyCheck() {
		if(fuelCode.isEmptyCheck()) {
			return false;
		}else {
			return true;
		}
	}
	public void isEnabledBtn(boolean enable) {
		btnUpdate.setEnabled(enable);
		btnDelete.setEnabled(enable);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String fCode = fuelCode.getTextValue();
		String fType = fuelType.getTextValue();
		FuelService fuelService = FuelService.getInstance();

		if (e.getSource() == btnAdd) {
			if (!isEmptyCheck()) {
				int insert = JOptionPane.showConfirmDialog(null, "입력 데이터를 추가하시겠습니까?", "확인창",
						JOptionPane.OK_CANCEL_OPTION);
				if (insert == 0) {
					fuelService.insertFuel(new Fuel(fCode, fType));
				} else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
				}
			} else {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다");
			}

		}
		if (e.getSource() == btnUpdate) {
			if (!isEmptyCheck()) {
				int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "확인창",
						JOptionPane.OK_CANCEL_OPTION);
				if (update == 0) {
					fuelService.updateFuel(new Fuel(fCode, fType));
				} else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
				}
			} else {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다");
			}

		}
		if (e.getSource() == btnDelete) {
			if(!codeEmptyCheck()) {
				int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if (delete == 0) {
					fuelService.deleteFule(new Fuel(fCode, fType));
				} else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
				}
			}else {
				JOptionPane.showMessageDialog(null, "코드를 입력하세요");
			}
			

		}
		isEnabledBtn(false);
		setFuelTextValueClear();
	}

}
