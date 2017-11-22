package kr.or.dgit.RentCar_Project.content;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import kr.or.dgit.RentCar_Project.component.RadioComboBoxComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.CarModelService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;
import kr.or.dgit.RentCar_Project.service.UserService;

public class PerformenceContent extends JPanel {

	private JButton btnSearch;
	private JButton btnReset;
	private ButtonGroup group;
	private RadioComboBoxComponent<CarModel> carModelBox;
	private RadioComboBoxComponent<Manufacturer> madeBox;
	private RadioComboBoxComponent<String> genderBox;
	private RadioComboBoxComponent<Fuel> fuelBox;
	private RadioComboBoxComponent<String> monthBox;
	private RadioComboBoxComponent<String> cancelBox;
	
	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public PerformenceContent() {
		setLayout(null);

		carModelBox = new RadioComboBoxComponent<CarModel>("차종");
		setCarModelComboBox();
		carModelBox.setBounds(1, 100, 349, 35);
		add(carModelBox);

		monthBox = new RadioComboBoxComponent<String>("월별");
		setMonthBoxComboBox();
		monthBox.setBounds(1, 10, 349, 35);
		add(monthBox);

		madeBox = new RadioComboBoxComponent<Manufacturer>("제조사");
		setMadeBoxComboBox();
		madeBox.setBounds(1, 145, 349, 35);
		add(madeBox);

		genderBox = new RadioComboBoxComponent<String>("성별");
		setGenderBoxComboBox();
		genderBox.setBounds(1, 55, 349, 35);
		add(genderBox);

		fuelBox = new RadioComboBoxComponent<Fuel>("연료별");
		setFuelBoxComboBox();
		fuelBox.setBounds(1, 190, 349, 35);
		add(fuelBox);
		
		cancelBox = new RadioComboBoxComponent<String>("취소내역");
		setCancelBoxComboBox();
		cancelBox.setBounds(1, 235, 349, 35);
		add(cancelBox);

		btnSearch = new JButton("검색");
		btnSearch.setBounds(33, 290, 140, 39);
		add(btnSearch);

		btnReset = new JButton("초기화");
		btnReset.setBounds(185, 290, 140, 39);
		add(btnReset);

		group = new ButtonGroup();
		group.add(carModelBox.getRadioButton());
		group.add(monthBox.getRadioButton());
		group.add(madeBox.getRadioButton());
		group.add(genderBox.getRadioButton());
		group.add(fuelBox.getRadioButton());
		group.add(cancelBox.getRadioButton());
	}

	public Object[] selectGetObject() {
		Enumeration<AbstractButton> selectObject = group.getElements();
		while (selectObject.hasMoreElements()) {
			JRadioButton jb = (JRadioButton) selectObject.nextElement();
			if (jb.isSelected()) {
				Object[] content = jb.getParent().getComponents();
				return content;
				
				/*for (int i = 0; i < content.length; i++) {
					if (content[i] instanceof JComboBox) {
						return (JComboBox) content[i];
					}
				}*/
			}
		}
		return null;
	}
	
	public void setCarModelComboBox() {
		CarModelService carModelService = CarModelService.getInstance();
		List<CarModel> lists = carModelService.selectCarModelByAll();
		Vector<CarModel> carModel = new Vector<>();
		for (CarModel cm : lists) {
			cm.setComboType(1);
			carModel.add(cm);
		}
		carModelBox.setComboBoxModel(carModel);
	}
	
	public void setMonthBoxComboBox() {
		Vector<String> user = new Vector<>();
		for(int i = 1; i <= 12; i++) {
			user.add(new String(i + "월"));
		}
		monthBox.setComboBoxModel(user);
	}
	
	public void setMadeBoxComboBox() {
		ManufacturerService manufacturerService = ManufacturerService.getInstance();
		List<Manufacturer> lists = manufacturerService.selectManufacturerByAll();
		Vector<Manufacturer> manufacturer = new Vector<>();
		for (Manufacturer cm : lists) {
			cm.setComboType(0);
			manufacturer.add(cm);
		}
		madeBox.setComboBoxModel(manufacturer);
	}

	public void setGenderBoxComboBox() {
		Vector<String> user = new Vector<>();
		user.add(new String("남자"));
		user.add(new String("여자"));
		genderBox.setComboBoxModel(user);
		
	}
	
	public void setFuelBoxComboBox() {
		FuelService fuelService = FuelService.getInstance();
		List<Fuel> lists = fuelService.selectFuelByAll();
		Vector<Fuel> fuel = new Vector<>();
		for (Fuel cm : lists) {
			cm.setComboType(0);
			fuel.add(cm);
		}
		fuelBox.setComboBoxModel(fuel);
		
	}
	
	public void setCancelBoxComboBox() {
		Vector<String> user = new Vector<>();
		for(int i = 1; i <= 12; i++) {
			user.add(new String(i + "월"));
		}
		cancelBox.setComboBoxModel(user);
		
	}
	
	
}
