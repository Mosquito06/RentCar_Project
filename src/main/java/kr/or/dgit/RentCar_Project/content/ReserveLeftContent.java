package kr.or.dgit.RentCar_Project.content;

import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class ReserveLeftContent extends JPanel {

	private ComboBoxComponent<Manufacturer> comboBoxManufacturer;
	private ComboBoxComponent<Fuel> comboBoxFuel;
	private ComboBoxComponent<CarData> comboBoxOld;
	private ComboBoxComponent<CarData> comboBoxSeater;
	private JButton btnExit;
	private RadioComponent isInsurance;
	private RadioComponent isAuto;
	private JButton btnReset;

	public JButton getBtnReset() {
		return btnReset;
	}

	public ComboBoxComponent<Manufacturer> getComboBoxManufacturer() {
		return comboBoxManufacturer;
	}

	public ComboBoxComponent<Fuel> getComboBoxFuel() {
		return comboBoxFuel;
	}

	public ComboBoxComponent<CarData> getComboBoxOld() {
		return comboBoxOld;
	}

	public ComboBoxComponent<CarData> getComboBoxSeater() {
		return comboBoxSeater;
	}

	public RadioComponent getIsAuto() {
		return isAuto;
	}

	public RadioComponent getIsInsurance() {
		return isInsurance;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public ReserveLeftContent() {
		setBorder(null);
		setLayout(null);

		comboBoxManufacturer = new ComboBoxComponent<>("제조회사  ");
		comboBoxManufacturer.setBounds(26, 82, 191, 36);
		add(comboBoxManufacturer);

		comboBoxFuel = new ComboBoxComponent<>("연료종류  ");

		comboBoxFuel.setBounds(26, 179, 191, 36);
		add(comboBoxFuel);

		comboBoxOld = new ComboBoxComponent<>("연식  ");
		comboBoxOld.setBounds(26, 270, 191, 36);
		add(comboBoxOld);

		comboBoxSeater = new ComboBoxComponent<>("인승  ");
		comboBoxSeater.setBounds(26, 359, 191, 36);
		add(comboBoxSeater);

		isAuto = new RadioComponent("변속기", "오토", "수동");
		isAuto.setBounds(26, 427, 205, 70);
		add(isAuto);

		isInsurance = new RadioComponent("자차 보험", "포함", "비포함");
		isInsurance.setBounds(26, 501, 205, 70);
		add(isInsurance);

		btnExit = new JButton("나가기");
		btnExit.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\esc.png"));
		btnExit.setBounds(94, 598, 137, 53);
		add(btnExit);

		btnReset = new JButton("");
		btnReset.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\reset.png"));
		btnReset.setBounds(26, 598, 56, 53);
		add(btnReset);

		setManufacturerBoxModel();
		setFuelBoxModel();
		setCarDataOldBoxModel();
		setCarDataSeaterBoxModel();

	}

	public void setManufacturerBoxModel() {
		ManufacturerService manufacturerService = ManufacturerService.getInstance();
		List<Manufacturer> lists = manufacturerService.selectManufacturerByAll();
		Manufacturer m = new Manufacturer();
		m.setManufacturerName("선택");
		lists.add(0, m);
		Vector<Manufacturer> manufacturer = new Vector<>();

		for (Manufacturer mf : lists) {
			mf.setComboType(0);
			manufacturer.add(mf);
		}
		comboBoxManufacturer.setComboBoxModel(manufacturer);
	}

	public void setFuelBoxModel() {
		FuelService fuelService = FuelService.getInstance();
		List<Fuel> lists = fuelService.selectFuelByAll();
		Fuel fu = new Fuel();
		fu.setFuelType("선택");
		lists.add(0, fu);
		Vector<Fuel> fuel = new Vector<>();

		for (Fuel f : lists) {
			f.setComboType(0);
			fuel.add(f);
		}
		comboBoxFuel.setComboBoxModel(fuel);
	}

	public void setCarDataOldBoxModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByOld();
		CarData car = new CarData();
		car.setCarName("선택");
		car.setComboType(1);
		lists.add(0, car);
		Vector<CarData> carData = new Vector<>();

		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).getComboType() == 1) {
				carData.add(lists.get(i));

			} else {
				lists.get(i).setComboType(2);
				carData.add(lists.get(i));

			}

		}

		comboBoxOld.setComboBoxModel(carData);
	}

	public void setCarDataSeaterBoxModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataBySeater();
		Vector<CarData> carData = new Vector<>();
		CarData car = new CarData();
		car.setCarSeater("선택");
		lists.add(0, car);
		for (CarData c : lists) {
			c.setComboType(3);
			carData.add(c);
		}
		comboBoxSeater.setComboBoxModel(carData);
	}

}
