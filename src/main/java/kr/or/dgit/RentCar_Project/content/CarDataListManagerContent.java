package kr.or.dgit.RentCar_Project.content;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.IsAuto;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.list.CarDataTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;

@SuppressWarnings("serial")
public class CarDataListManagerContent extends JPanel implements ActionListener {
	
	private ComboBoxComponent<CarData> search;
	protected CarDataTable listCarData;
	private JButton btnAll;
	private JButton btnSearch;
	private CarDataManagerContent cdManagerContent;
	
	public void setCdManagerContent(CarDataManagerContent cdManagerContent) {
		this.cdManagerContent = cdManagerContent;
	}

	public CarDataListManagerContent() {
		setBounds(100, 100, 950, 322);
		setLayout(null);
		
		JButton btnChart = new JButton("대여고객");
		btnChart.setBounds(841, 23, 97, 35);
		add(btnChart);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(744, 23, 97, 35);
		btnAll.addActionListener(this);
		add(btnAll);
		
		search = new ComboBoxComponent<>("차 코드");
		search.setBounds(258, 23, 296, 35);
		add(search);
		
		listCarData = new CarDataTable();
		listCarData.setBorder(new LineBorder(new Color(0, 0, 0)));
		listCarData.setBounds(12, 68, 926, 244);
		listCarData.setFull(true);
		listCarData.loadDate();
		add(listCarData);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(554, 23, 66, 35);
		btnSearch.addActionListener(this);
		add(btnSearch);
		
		setSearchCarCodeComboModel();
	}
	
		public void setSearchCarCodeComboModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carData = new Vector<>();
		for(CarData cd : lists) {
			cd.setComboType(0);
			carData.add(cd);
		}
		
		search.setComboBoxModel(carData);
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==btnAll) {
				listCarData.setFull(true);
				listCarData.loadDate();
				
			}
			if(e.getSource()==btnSearch) {
				CarData carDataCode = search.getComboboxValue();
				
				CarDataService cdService = CarDataService.getInstance();
				CarData cdCode = cdService.selectCarDataByCarDataCode(carDataCode);
				
				listCarData.setFull(false);
				listCarData.setCarDataCode(cdCode);
				listCarData.loadDate();
				
				cdManagerContent.carDataCode.setTextValue(cdCode.getCarCode());
				cdManagerContent.carName.setTextValue(cdCode.getCarName());
				cdManagerContent.carOld.setTextValue(String.valueOf(cdCode.getCarOld()));
				cdManagerContent.carSeater.setTextValue(cdCode.getCarSeater());
				cdManagerContent.carModelCombo.getComboBox().setSelectedIndex(setSelectedCarModel(cdCode));
				cdManagerContent.mfCombo.getComboBox().setSelectedIndex(setSelectedMf(cdCode));
				cdManagerContent.fuelCombo.getComboBox().setSelectedIndex(setSelectedFuel(cdCode));
				cdManagerContent.carCount.setSpinValue(cdCode.getCarNumber());
				cdManagerContent.img.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\car\\" + cdCode.getCarImage()));
				cdManagerContent.numCombo.getComboBox().setSelectedIndex(setSelectedNum(cdCode));
				cdManagerContent.isAuto.setSelect(isAutoSelected(cdCode.getIsAuto()));
				
			}
			
		}
		
	public boolean isAutoSelected(IsAuto isAuto) {
			if(isAuto.name().equals("AUTO")) {
				return true;
			}else {
				return false;
			}
			
		}

	public int setSelectedNum(CarData cdCode) {
		
		String find = cdCode.toString().substring(cdCode.toString().lastIndexOf("-")+1);
		
		for(int i=0;i<cdManagerContent.numCombo.getComboBox().getItemCount();i++) {
			String num = cdManagerContent.numCombo.getComboBox().getItemAt(i);
			if(num.equals(find)) {
				return i;
			}
		}
			return 0;
		}

	public int setSelectedCarModel(CarData cdCode) {
		for(int i=0;i<cdManagerContent.carModelCombo.getComboBox().getItemCount();i++) {
			CarModel cm=cdManagerContent.carModelCombo.getComboBox().getItemAt(i);
			if(cm.toString().equals(cdCode.getCarModelCode().getCarModelCode())) {
				return i;
			}
		}
		return 0; 
	}
	
	public int setSelectedMf(CarData cdCode) {
		for(int i= 0;i<cdManagerContent.mfCombo.getComboBox().getItemCount();i++) {
				Manufacturer mf = cdManagerContent.mfCombo.getComboBox().getItemAt(i);
				if(mf.toString().equals(cdCode.getManufacturerCode().getManufacturerCode())) {
					return i;
				}
			}
			return 0;
	}
	
	public int setSelectedFuel(CarData cdCode) {
		
		for(int i=0;i<cdManagerContent.fuelCombo.getComboBox().getItemCount();i++) {
			Fuel f = cdManagerContent.fuelCombo.getComboBox().getItemAt(i);
			if(f.toString().equals(cdCode.getFuelCode().getFuelCode())) {
				return i;
			}
		}
			return 0;
	}
}
