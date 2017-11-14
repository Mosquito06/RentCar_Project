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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.JspinnerComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.content.CarModelContent;
import kr.or.dgit.RentCar_Project.content.FuelManagerContent;
import kr.or.dgit.RentCar_Project.content.ManufacturerManagerContent;
import kr.or.dgit.RentCar_Project.content.RentalPriceManagerContent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.CarModelService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class AdminMainCarManager extends JPanel {
	private JTable table;
	
	private TextFieldComponent carCode;
	private TextFieldComponent carName;
	private TextFieldComponent carOld;
	private TextFieldComponent seater;
	private RadioComponent isAuto;
	private JspinnerComponent carNumber;
	private ComboBoxComponent<CarModel> cmCode;
	private ComboBoxComponent<Manufacturer> mfCode;
	private ComboBoxComponent<Fuel> fCode;
	private ComboBoxComponent<CarData> searchCarCode;
	
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
		
		JButton btnAllReset = new JButton("전체 초기화");
		btnAllReset.setBounds(750, 728, 97, 23);
		add(btnAllReset);
		
		CarModelContent carModelPanel = new CarModelContent();
		carModelPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uCC28\uC885 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carModelPanel.setBounds(278, 422, 327, 143);
		add(carModelPanel);
		carModelPanel.setLayout(null);
		
		ManufacturerManagerContent manufacturerPanel = new ManufacturerManagerContent();
		manufacturerPanel.setBounds(630, 575, 332, 143);
		add(manufacturerPanel);
		manufacturerPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uC81C\uC870\uD68C\uC0AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		manufacturerPanel.setLayout(null);
		
		RentalPriceManagerContent pricePanel = new RentalPriceManagerContent();
		pricePanel.setBounds(12, 422, 246, 297);
		add(pricePanel);
		pricePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uB300\uC5EC \uB2E8\uAC00 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pricePanel.setLayout(null);
		
		FuelManagerContent oliPanel = new FuelManagerContent();
		oliPanel.setBounds(278, 575, 327, 143);
		add(oliPanel);
		oliPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uC5F0\uB8CC\uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		oliPanel.setLayout(null);
		
		JPanel carPanel = new JPanel();
		carPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carPanel.setBounds(12, 10, 598, 382);
		add(carPanel);
		carPanel.setLayout(null);
		
		carCode = new TextFieldComponent("차 코드");
		carCode.setBounds(5, 20, 230, 30);
		carPanel.add(carCode);
		
		carName = new TextFieldComponent("차 이름");
		carName.setBounds(5, 60, 230, 30);
		carPanel.add(carName);
		
		carOld = new TextFieldComponent("연식");
		carOld.setBounds(5, 100, 230, 30);
		carPanel.add(carOld);
		
		seater = new TextFieldComponent("인승");
		seater.setBounds(5, 220, 230, 30);
		carPanel.add(seater);
		
		isAuto = new RadioComponent("오토유무","yes", "no");
		isAuto.setBounds(15, 180, 255, 30);
		carPanel.add(isAuto);
		
		carNumber = new JspinnerComponent("차량대수");
		carNumber.setBounds(5, 140, 230, 30);
		carPanel.add(carNumber);
		
		cmCode = new ComboBoxComponent<>("차종코드");
		cmCode.setBounds(5, 260, 230, 30);
		carPanel.add(cmCode);
		
		mfCode = new ComboBoxComponent<>("제조회사코드");
		mfCode.setBounds(5, 300, 230, 30);
		carPanel.add(mfCode);
		
		fCode = new ComboBoxComponent<>("연료코드");
		fCode.setBounds(5, 339, 230, 30);
		carPanel.add(fCode);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(412, 346, 66, 23);
		carPanel.add(btnDelete);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(346, 346, 66, 23);
		carPanel.add(btnUpdate);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(279, 346, 66, 23);
		carPanel.add(btnAdd);
		
		JButton btnClear = new JButton("취소");
		btnClear.setBounds(520, 346, 66, 23);
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if(clear==0)setRentalPriceValueClear();
			}
		});
		carPanel.add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBounds(279, 20, 307, 310);
		carPanel.add(panel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		searchPanel.setBounds(617, 15, 345, 550);
		add(searchPanel);
		searchPanel.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("차트보기");
		btnNewButton_5.setBounds(252, 517, 81, 23);
		searchPanel.add(btnNewButton_5);
		
		searchCarCode = new ComboBoxComponent<>("차 코드");
		searchCarCode.setBounds(12, 10, 246, 30);
		searchPanel.add(searchCarCode);
		
		JPanel listPanel = new JPanel();
		listPanel.setBounds(12, 50, 321, 457);
		searchPanel.add(listPanel);
		listPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(267, 17, 66, 23);
		searchPanel.add(btnSearch);
		setSearchCarCodeComboModel();
		setCarModelComboModel();
		setManufacturerComboModel();
		setFuelComboModel();
		
	}
	public void setSearchCarCodeComboModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carData = new Vector<>();
		for(CarData cd : lists) {
			cd.setComboType(0);
			carData.add(cd);
		}
		searchCarCode.setComboBoxModel(carData);
	}
	
	public  void setCarModelComboModel() {
		CarModelService carModelService = CarModelService.getInstance();
		List<CarModel> lists = carModelService.selectCarModelByAll();
		Vector<CarModel> carModel = new Vector<>();
		for(CarModel cm:lists) {
			cm.setComboType(0);
			carModel.add(cm);
		}
		cmCode.setComboBoxModel(carModel);
	}
	public void setManufacturerComboModel() {
		ManufacturerService manufacturerService = ManufacturerService.getInstance();
		List<Manufacturer> lists = manufacturerService.selectManufacturerByAll();
		Vector<Manufacturer> manufacturer = new Vector<>();
		for(Manufacturer mf:lists) {
			mf.setComboType(1);
			manufacturer.add(mf);
		}
		mfCode.setComboBoxModel(manufacturer);
		
	}
	
	public void setFuelComboModel() {
		FuelService fuelService = FuelService.getInstance();
		List<Fuel> lists = fuelService.selectFuelByAll();
		Vector<Fuel> fuelCode = new Vector<>();
		for(Fuel f:lists) {
			f.setComboType(1);
			fuelCode.add(f);
		}
		fCode.setComboBoxModel(fuelCode);
		
	}
	public void setRentalPriceValueClear() {
		carCode.setTextValue("");
		carName.setTextValue("");
		carOld.setTextValue("");
		seater.setTextValue("");
		isAuto.setSelect(true);
		carNumber.setSpinValue(1);
		cmCode.setComboBoxModelClear();
		mfCode.setComboBoxModelClear();
		fCode.setComboBoxModelClear();
	}
}
