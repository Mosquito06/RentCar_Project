package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.JspinnerComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.list.CarDataTable;
import kr.or.dgit.RentCar_Project.list.RentalPriceTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.CarModelService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;
import kr.or.dgit.RentCar_Project.content.CarDataListManagerContent;
import kr.or.dgit.RentCar_Project.content.CarDataManagerContent;

@SuppressWarnings("serial")
public class AdminMainCarManager extends JPanel {
	private String[] details = {"선택하세요","대여단가 관리","차종&제조회사&연료 관리"};
	
	public AdminMainCarManager() {
		setBounds(0, 0, 974, 751);
		setLayout(null);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(862, 728, 97, 23);
		add(btnBack);
		
		CarDataManagerContent carPanel = new CarDataManagerContent();
		carPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carPanel.setBounds(12, 10, 950, 382);
		add(carPanel);
		carPanel.setLayout(null);
		
		CarDataListManagerContent carListPanel = new CarDataListManagerContent();
		carListPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uB9AC\uC2A4\uD2B8 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carListPanel.setBounds(12, 402, 950, 322);
		add(carListPanel);
		carListPanel.setLayout(null);
		setCarModelComboModel();
		setManufacturerComboModel();
		setFuelComboModel();
		
	}
	
	public  void setCarModelComboModel() {
		CarModelService carModelService = CarModelService.getInstance();
		List<CarModel> lists = carModelService.selectCarModelByAll();
		Vector<CarModel> carModel = new Vector<>();
		for(CarModel cm:lists) {
			cm.setComboType(0);
			carModel.add(cm);
		}
	}
	public void setManufacturerComboModel() {
		ManufacturerService manufacturerService = ManufacturerService.getInstance();
		List<Manufacturer> lists = manufacturerService.selectManufacturerByAll();
		Vector<Manufacturer> manufacturer = new Vector<>();
		for(Manufacturer mf:lists) {
			mf.setComboType(1);
			manufacturer.add(mf);
		}
		
	}
	
	public void setFuelComboModel() {
		FuelService fuelService = FuelService.getInstance();
		List<Fuel> lists = fuelService.selectFuelByAll();
		Vector<Fuel> fuelCode = new Vector<>();
		for(Fuel f:lists) {
			f.setComboType(1);
			fuelCode.add(f);
		}
		
	}
/*	public void setRentalPriceValueClear() {
		carCode.setTextValue("");
		carName.setTextValue("");
		carOld.setTextValue("");
		seater.setTextValue("");
		isAuto.setSelect(true);
		carNumber.setSpinValue(1);
		cmCode.setComboBoxModelClear();
		mfCode.setComboBoxModelClear();
		fCode.setComboBoxModelClear();
	}*/
	private void openDetailFrame(Object selected) {
		JFrame frame = AdminMain.getInstance();
		frame.getContentPane().removeAll();
		if(selected==details[0]||selected==null){
			JOptionPane.showMessageDialog(null, "세부사향을 선택하세요");
		}else if(selected==details[1]) {
			frame.getContentPane().add(new AdminMainCarManagerRentalPrice(), BorderLayout.CENTER);
			frame.setVisible(true);
		}else if(selected==details[2]) {
			frame.getContentPane().add(new AdminMainCarManagerCarDetail(), BorderLayout.CENTER);
			frame.setVisible(true);
		}
		
	}
}
