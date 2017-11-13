package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.service.CarDataService;

@SuppressWarnings("serial")
public class RentalPriceManagerContent extends JPanel {
	
	private ComboBoxComponent<CarData> carCode;
	private TextFieldComponent bPrice;
	private TextFieldComponent useTime;
	private TextFieldComponent oPrice;
	private TextFieldComponent btPrice;
	private TextFieldComponent insurance;
	
	public RentalPriceManagerContent() {
		setLayout(null);
		
		carCode = new ComboBoxComponent<>("차 코드");
		carCode.setBounds(5, 23, 230, 30);
		add(carCode);
		
		bPrice = new TextFieldComponent("기본가격");
		bPrice.setBounds(5, 63, 230, 30);
		add(bPrice);
		
		useTime = new TextFieldComponent("사용시간");
		useTime.setBounds(5, 103, 230, 30);
		add(useTime);
		
		oPrice = new TextFieldComponent("초과시간단가");
		oPrice.setBounds(5, 223, 230, 30);
		add(oPrice);
		
		btPrice = new TextFieldComponent("기본시간단가");
		btPrice.setBounds(5, 183, 230, 30);
		add(btPrice);
		
		insurance = new TextFieldComponent("보험료");
		insurance.setBounds(5, 143, 230, 30);
		add(insurance);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(25, 267, 66, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(91, 267, 66, 23);
		add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(169, 267, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setRentalPriceValueClear();
				
			}
		});
		add(btnCancel);
		setCarCodeComboModel();
	}
	public void setCarCodeComboModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carDataCode = new Vector<>();
		for(CarData cd:lists) {
			cd.setComboType(0);
			carDataCode.add(cd);
		}
		carCode.setComboBoxModel(carDataCode);
	}
	public void setRentalPriceValueClear() {
		carCode.setComboBoxModelClear();
		bPrice.setTextValue("");
		useTime.setTextValue("");
		oPrice.setTextValue("");
		btPrice.setTextValue("");
		insurance.setTextValue("");
	}
}
