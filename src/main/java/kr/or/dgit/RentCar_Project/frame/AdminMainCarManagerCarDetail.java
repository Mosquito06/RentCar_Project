package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.content.CarModelContent;
import kr.or.dgit.RentCar_Project.content.FuelManagerContent;
import kr.or.dgit.RentCar_Project.content.ManufacturerManagerContent;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.list.CarModelTable;
import kr.or.dgit.RentCar_Project.list.FuelTable;
import kr.or.dgit.RentCar_Project.list.ManufacturerTable;
import kr.or.dgit.RentCar_Project.service.CarModelService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class AdminMainCarManagerCarDetail extends JPanel implements ActionListener {
	
	private ManufacturerTable mfTable;
	private CarModelTable carModelTable;
	private FuelTable fuelTable;
	private String[] details = {"선택하세요","대여단가 관리","연료&고객등급 관리","초기화면"};
	private ComboBoxComponent<Fuel> searchFuel;
	private ComboBoxComponent<Manufacturer> searchMF;
	private ComboBoxComponent<CarModel> searchCarModel;
	private JButton btnSearchFuel;
	
	public AdminMainCarManagerCarDetail() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel manufacturerPanel = new JPanel();
		manufacturerPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC81C\uC870\uD68C\uC0AC \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		manufacturerPanel.setBounds(27, 10, 795, 243);
		add(manufacturerPanel);
		manufacturerPanel.setLayout(null);
		
		ManufacturerManagerContent inputManufacturer = new ManufacturerManagerContent();
		inputManufacturer.setBounds(12, 47, 345, 170);
		manufacturerPanel.add(inputManufacturer);
		
		mfTable = new ManufacturerTable();
		mfTable.setBounds(369, 63, 416, 170);
		manufacturerPanel.add(mfTable);
		mfTable.loadDate();
		
		
		searchMF = new ComboBoxComponent<>("제조회사 코드");
		searchMF.setBounds(369, 18, 231, 37);
		manufacturerPanel.add(searchMF);
		
		JButton btnSearchMF = new JButton("검색");
		btnSearchMF.setBounds(601, 18, 65, 37);
		manufacturerPanel.add(btnSearchMF);
		
		JButton btnAllMF = new JButton("전체보기");
		btnAllMF.setBounds(686, 18, 97, 37);
		manufacturerPanel.add(btnAllMF);
		
		JPanel carModelPanel = new JPanel();
		carModelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uC885 \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		carModelPanel.setBounds(27, 255, 795, 243);
		add(carModelPanel);
		carModelPanel.setLayout(null);
		
		CarModelContent inputCarModel = new CarModelContent();
		inputCarModel.setBounds(12, 47, 345, 170);
		carModelPanel.add(inputCarModel);
		carModelTable = new CarModelTable();
		carModelTable.setBounds(369, 63, 416, 170);
		carModelPanel.add(carModelTable);
		
		searchCarModel = new ComboBoxComponent<>("차종 코드");
		searchCarModel.setBounds(369, 18, 231, 37);
		carModelPanel.add(searchCarModel);
		
		JButton btnSearchCarModel = new JButton("검색");
		btnSearchCarModel.setBounds(601, 18, 65, 37);
		carModelPanel.add(btnSearchCarModel);
		
		JButton btnAllCarModel = new JButton("전체보기");
		btnAllCarModel.setBounds(686, 18, 97, 37);
		carModelPanel.add(btnAllCarModel);
		carModelTable.loadDate();
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		
		JPanel fuelPanel = new JPanel();
		fuelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC5F0\uB8CC\uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fuelPanel.setBounds(27, 503, 795, 243);
		add(fuelPanel);
		fuelPanel.setLayout(null);
		
		FuelManagerContent inputFuelPanel = new FuelManagerContent();
		inputFuelPanel.setBounds(12, 47, 345, 170);
		fuelPanel.add(inputFuelPanel);
		
		fuelTable = new FuelTable();
		fuelTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		fuelTable.setBounds(369, 63, 416, 170);
		fuelTable.setFull(true);
		fuelTable.loadDate();
		fuelPanel.add(fuelTable);
		
		searchFuel = new ComboBoxComponent<>("연료코드");
		searchFuel.setBounds(369, 18, 231, 37);
		fuelPanel.add(searchFuel);
		
		btnSearchFuel = new JButton("검색");
		btnSearchFuel.setBounds(602, 18, 65, 37);
		btnSearchFuel.addActionListener(this);
		fuelPanel.add(btnSearchFuel);
		
		JButton btnAllFuel = new JButton("전체보기");
		btnAllFuel.setBounds(686, 18, 97, 37);
		fuelPanel.add(btnAllFuel);
		btnBack.setBounds(865, 718, 97, 23);
		add(btnBack);
		
		JButton button = new JButton("세부사항 관리");
		button.setBounds(847, 20, 115, 23);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selected = JOptionPane.showInputDialog(null, "세부관리 사항을 선택하세요", "세부관리", JOptionPane.QUESTION_MESSAGE, null, details, details[0]);
				openDetailFrame(selected);
				
			}

		});
		add(button);
		setManufacturerComboBoxModel();
		setFuelComboBoxModel();
		setCarModelComboBoxModel();
	}
	private void openDetailFrame(Object selected) {
		JFrame frame = AdminMain.getInstance();
		frame.getContentPane().removeAll();
			if(selected==details[0]){
			JOptionPane.showMessageDialog(null, "세부사향을 선택하세요");
			return;
		}else if(selected==details[1]) {
			frame.getContentPane().add(new AdminMainCarManagerRentalPrice(), BorderLayout.CENTER);
		}else if(selected==details[2]) {
			frame.getContentPane().add(new AdminMainCarManagerFuel_UserGrade(), BorderLayout.CENTER);
		}else if(selected==details[3]) {
			frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
		}else {
			return;
		}
			frame.setVisible(true);
		
	}
	public void setManufacturerComboBoxModel(){
		List<Manufacturer> lists = ManufacturerService.getInstance().selectManufacturerByAll();
		Vector<Manufacturer> mfCode = new Vector<>();
		for(Manufacturer mf : lists) {
			mf.setComboType(1);
			mfCode.add(mf);
		}
		searchMF.setComboBoxModel(mfCode);
	}
	public void setCarModelComboBoxModel() {
		List<CarModel> lists = CarModelService.getInstance().selectCarModelByAll();
		Vector<CarModel> cmCode = new Vector<>();
		for(CarModel cm:lists) {
			cm.setComboType(0);
			cmCode.add(cm);
		}
		searchCarModel.setComboBoxModel(cmCode);
		
	}
	public void setFuelComboBoxModel() {
		List<Fuel> lists = FuelService.getInstance().selectFuelByAll();
		Vector<Fuel> fuelCode = new Vector<>();
		for(Fuel f : lists) {
			f.setComboType(1);
			fuelCode.add(f);
		}
		searchFuel.setComboBoxModel(fuelCode);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSearchFuel) {
			fuelTable.revalidate();
			Fuel fuelCode  = searchFuel.getComboboxValue();
			fuelTable.setFull(false);
			fuelTable.setFuel(fuelCode);
			fuelTable.loadDate();
		}
	}
}
