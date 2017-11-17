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

@SuppressWarnings("serial")
public class AdminMainCarManager extends JPanel {
	
	private TextFieldComponent carCode;
	private TextFieldComponent carName;
	private TextFieldComponent carOld;
	private TextFieldComponent seater;
	private RadioComponent isAuto;
	private JspinnerComponent carNumber;
	private ComboBoxComponent<CarModel> cmCode;
	private ComboBoxComponent<Manufacturer> mfCode;
	private ComboBoxComponent<Fuel> fCode;
	private JPanel listTablePanel;
	private JLabel lblNum;
	private JButton btnNewButton;
	private ComboBoxComponent<CarData> searchPanel;
	private JButton btnChart;
	private String[] details = {"선택하세요","대여단가 관리","차종&제조회사&연료 관리"};
	private JButton btnAll;
	private CarDataTable carDataTable;
	
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
		
		JPanel carPanel = new JPanel();
		carPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carPanel.setBounds(12, 10, 950, 382);
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
		btnDelete.setBounds(701, 86, 66, 23);
		carPanel.add(btnDelete);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(701, 53, 66, 23);
		carPanel.add(btnUpdate);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(701, 20, 66, 23);
		carPanel.add(btnAdd);
		
		JButton btnClear = new JButton("취소");
		btnClear.setBounds(701, 346, 66, 23);
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if(clear==0)setRentalPriceValueClear();
			}
		});
		carPanel.add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBounds(282, 20, 400, 349);
		carPanel.add(panel);
		
		JButton btnDetail = new JButton("세부사항관리");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = JOptionPane.showInputDialog(null, "세부관리 사항을 선택하세요", "세부관리", JOptionPane.QUESTION_MESSAGE, null, details, details[0]);
				openDetailFrame(selected);
				
			}
		});
		btnDetail.setBounds(783, 20, 144, 23);
		carPanel.add(btnDetail);
		
		JPanel carListPanel = new JPanel();
		carListPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uB9AC\uC2A4\uD2B8 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carListPanel.setBounds(12, 402, 950, 322);
		add(carListPanel);
		carListPanel.setLayout(null);
		
		lblNum = new JLabel("New label");
		lblNum.setBounds(867, 300, 76, 15);
		carListPanel.add(lblNum);
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		
		listTablePanel = new JPanel();
		listTablePanel.setBounds(12, 54, 931, 245);
		carListPanel.add(listTablePanel);
		listTablePanel.setLayout(new BorderLayout(0, 0));
		carDataTable = new CarDataTable();
		carDataTable.loadDate();
		listTablePanel.add(carDataTable,BorderLayout.CENTER);
		
		btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarData carCode = searchPanel.getComboboxValue();
				CarData lists = CarDataService.getInstance().selectCarDataByCarDataCode(carCode);
				
			}
		});
		btnNewButton.setBounds(600, 21, 97, 23);
		carListPanel.add(btnNewButton);
		
		searchPanel = new ComboBoxComponent<>("차 코드");
		searchPanel.setBounds(272, 16, 316, 28);
		carListPanel.add(searchPanel);
		
		btnChart = new JButton("차트보기");
		btnChart.setBounds(841, 21, 97, 23);
		carListPanel.add(btnChart);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(744, 21, 97, 23);
		carListPanel.add(btnAll);
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
		searchPanel.setComboBoxModel(carData);
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
	private void openDetailFrame(Object selected) {
		JFrame frame = AdminMain.getInstance();
		frame.getContentPane().removeAll();
		if(selected==details[0]){
			JOptionPane.showMessageDialog(null, "세부사향을 선택하세요");
			return;
		}else if(selected==details[1]) {
			frame.getContentPane().add(new AdminMainCarManagerRentalPrice(), BorderLayout.CENTER);
		}else if(selected==details[2]) {
			frame.getContentPane().add(new AdminMainCarManagerCarDetail(), BorderLayout.CENTER);
		}else {
			return;
		}
		frame.setVisible(true);
		
	}
}
