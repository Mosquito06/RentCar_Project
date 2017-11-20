package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.frame.AdminMainCarManagerCarDetail;
import kr.or.dgit.RentCar_Project.list.CarModelTable;
import kr.or.dgit.RentCar_Project.service.CarModelService;

@SuppressWarnings("serial")
public class CarModelContent extends JPanel implements ActionListener {
	private TextFieldComponent cmCode;
	private TextFieldComponent carModel;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private CarModellListManagerContent carModelListContent;
	
	public void setCm(CarModellListManagerContent carModelListContent) {
		this.carModelListContent = carModelListContent;
	}

	public CarModelContent() {
		setBounds(100, 100, 333, 171);
		setLayout(null);
	
		cmCode = new TextFieldComponent("차종 코드");
		cmCode.setBounds(3, 25, 276, 30);
		add(cmCode);

		carModel = new TextFieldComponent("차종");
		carModel.setBounds(3, 65, 276, 30);
		add(carModel);

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
					setCarModelValueClear();
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

	public void setCarModelValueClear() {
		cmCode.setTextValue("");
		carModel.setTextValue("");
	}

	public boolean isEmptyCheck() {
		if (cmCode.isEmptyCheck() && carModel.isEmptyCheck()) {
			return false;
		} else {
			cmCode.requestFocus();
			return true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String carModelCode = cmCode.getTextValue();
		String cModel = carModel.getTextValue();
		CarModelService carModelService = CarModelService.getInstance();

		if (e.getSource() == btnAdd) {
			if (!isEmptyCheck()) {
				int insert = JOptionPane.showConfirmDialog(null, "입력 데이터를 추가하시겠습니까?", "확인창",
						JOptionPane.OK_CANCEL_OPTION);
				if (insert == 0) {
					carModelService.insertCarModel(new CarModel(carModelCode, cModel));
					carModelListContent.cmTable.loadDate();
					carModelListContent.setCarModelComboBoxModel();
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
				if(update==0) {
					carModelService.updateCarModel(new CarModel(carModelCode, cModel));
					carModelListContent.cmTable.loadDate();
					carModelListContent.setCarModelComboBoxModel();
				} else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
				}
			}else {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다");
			}
		}
		if (e.getSource() == btnDelete) {
			if (!isEmptyCheck()) {
				int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if (delete == 0) {
					carModelService.deleteCarModel(new CarModel(carModelCode, cModel));
					carModelListContent.cmTable.loadDate();
					carModelListContent.setCarModelComboBoxModel();
				} else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
				}
			}else {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다");
			}
			
		}
		setCarModelValueClear();
	}
}
