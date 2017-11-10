package kr.or.dgit.RentCar_Project.content;

import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ReserveLeftContent extends JPanel {

	private ComboBoxComponent<Manufacturer> comboBoxManufacturer;
	private ComboBoxComponent<Fuel> comboBoxFuel;
	private ComboBoxComponent<CarData> comboBoxOld;
	private ComboBoxComponent<CarData> comboBoxSeater;
	private ComboBoxComponent<CarData> comboBoxCarName;
	private JButton btnExit;
	
	public JButton getBtnExit() {
		return btnExit;
	}

	public ReserveLeftContent() {
		setBorder(null);
		setLayout(null);
		
		comboBoxManufacturer = new ComboBoxComponent<>("제조회사  ");
		comboBoxManufacturer.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, comboBoxManufacturer.getComboboxValue().getManufacturerCode());
			}
		});
		comboBoxManufacturer.setBounds(45, 59, 191, 36);
		add(comboBoxManufacturer);
		
		comboBoxFuel = new ComboBoxComponent<>("연료종류  ");
		comboBoxFuel.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, comboBoxFuel.getComboboxValue().getFuelCode());
				
			}
		});
		comboBoxFuel.setBounds(45, 131, 191, 36);
		add(comboBoxFuel);
		
		comboBoxOld = new ComboBoxComponent<>("연식  ");
		comboBoxOld.setBounds(45, 210, 191, 36);
		add(comboBoxOld);
		
		comboBoxSeater = new ComboBoxComponent<>("인승  ");
		comboBoxSeater.setBounds(45, 290, 191, 36);
		add(comboBoxSeater);
		
		comboBoxCarName = new ComboBoxComponent<>("상세 차 검색  ");
		comboBoxCarName.setBounds(45, 369, 191, 36);
		add(comboBoxCarName);
		
		RadioComponent panel_2 = new RadioComponent("변속기", "오토", "수동");
		panel_2.setBounds(40, 435, 205, 70);
		add(panel_2);
		
		RadioComponent radioComponent = new RadioComponent("자차 보험", "포함", "비포함");
		radioComponent.setBounds(40, 506, 205, 70);
		add(radioComponent);
		
		btnExit = new JButton("나가기");
		btnExit.setBounds(62, 594, 167, 53);
		add(btnExit);
		setManufacturerBoxModel(); 
		setCarDataNameBoxModel();
		setFuelBoxModel();
		setCarDataOldBoxModel();
		setCarDataSeaterBoxModel();
		
		
	}
	
	public void setManufacturerBoxModel() {
		ManufacturerService manufacturerService = ManufacturerService.getInstance();
		List<Manufacturer> lists = manufacturerService.selectManufacturerByAll();
		Vector<Manufacturer> manufacturer = new Vector<>(lists);
		comboBoxManufacturer.setComboBoxModel(manufacturer);
	}
	
	
	
	
	public void setFuelBoxModel() {
	/*	FuelService fuelService = FuelService.getInstance();
		List<Fuel> lists = fuelService.selectFuelByAll();
		Vector<String> carData = new Vector<>();
		String test = null;
		for(Fuel f : lists) {
			test = f.toWrite();
			test.replace(",", "testing now");
			carData.add(test);
		}
//		Vector<Fuel> carData = new Vector<>(lists);
		
		comboBoxFuel.setComboBoxModel(carData);*/
	}
	
	
	
	
	
	
	
	public void setCarDataOldBoxModel() {
	/*	CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carData = new Vector<>(lists);
		comboBoxOld.setComboBoxModel(carData);*/
	}
	
	public void setCarDataSeaterBoxModel() {
		/*CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carData = new Vector<>(lists);
		comboBoxSeater.setComboBoxModel(carData);*/
	}
	
	
	public void setCarDataNameBoxModel() {
	/*	CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carData = new Vector<>(lists);
		comboBoxCarName.setComboBoxModel(carData);*/
	}
}



























