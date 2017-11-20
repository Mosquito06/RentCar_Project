package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.RentalPrice;
import kr.or.dgit.RentCar_Project.list.RentalPriceTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.RentalPriceService;

@SuppressWarnings("serial")
public class RentalPriceManagerContent extends JPanel implements ActionListener{
	
	private ComboBoxComponent<CarData> carCode;
	private TextFieldComponent bPrice;
	private TextFieldComponent useTime;
	private TextFieldComponent oPrice;
	private TextFieldComponent btPrice;
	private TextFieldComponent insurance;
	private JButton btnUpdate;
	private RentalPriceTable rentalPriceTable;
	private JButton btnDelete;
	
	public void setRentalPriceTable(RentalPriceTable rentalPriceTable) {
		this.rentalPriceTable = rentalPriceTable;
	}
	public RentalPriceManagerContent() {
		setBounds(100, 100, 267, 489);
		setLayout(null);
		
		carCode = new ComboBoxComponent<>("차 코드");
		carCode.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentalPriceService rentalPriceService = RentalPriceService.getInstance();
				
				String code = carCode.getComboBox().getSelectedItem().toString();
				RentalPrice rentalPrice = rentalPriceService.selectRentalPriceByCarCodeString(code);
				
				bPrice.setTextValue(String.format("%,d", rentalPrice.getBasicPrice()));
				useTime.setTextValue(String.valueOf(rentalPrice.getBasicTime()));
				btPrice.setTextValue(String.format("%,d", rentalPrice.getBasicTimePrice()));
				oPrice.setTextValue(String.format("%,d",rentalPrice.getOverPrice()));
				insurance.setTextValue(String.format("%,d",rentalPrice.getInsurance()));
				
			}
		});
		carCode.setBounds(5, 35, 230, 30);
		add(carCode);
		
		bPrice = new TextFieldComponent("기본가격");
		bPrice.setBounds(5, 100, 230, 30);
		add(bPrice);
		
		useTime = new TextFieldComponent("사용시간");
		useTime.setBounds(5, 165, 230, 30);
		add(useTime);
		
		oPrice = new TextFieldComponent("초과시간단가");
		oPrice.setBounds(5, 360, 230, 30);
		add(oPrice);
		
		btPrice = new TextFieldComponent("기본시간단가");
		btPrice.setBounds(5, 295, 230, 30);
		add(btPrice);
		
		insurance = new TextFieldComponent("보험료");
		insurance.setBounds(5, 230, 230, 30);
		add(insurance);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(21, 456, 66, 23);
		add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.setBounds(99, 456, 66, 23);
		btnDelete.addActionListener(this);
		add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(177, 456, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
				if(clear==0)setRentalPriceValueClear();
				
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
	@Override
	public void actionPerformed(ActionEvent e) {
		RentalPriceService rentalPriceService = RentalPriceService.getInstance();
		CarData  cCode = carCode.getComboboxValue();
		int basicPrice = Integer.parseInt(bPrice.getTextValue().replaceAll(",", "").trim());
		int basicTime  = Integer.parseInt(useTime.getTextValue());
		int basicTimePrice = Integer.parseInt(btPrice.getTextValue().replaceAll(",", "").trim());
		int overPrice = Integer.parseInt(oPrice.getTextValue().replaceAll(",", "").trim());
		int is = Integer.parseInt(insurance.getTextValue().replaceAll(",", "").trim());
		
 		if(e.getSource()==btnUpdate) {
			int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "확인창",
					JOptionPane.OK_CANCEL_OPTION);
			if(update==0) {
				rentalPriceService.updateRentalPrice(new RentalPrice(cCode, basicPrice, basicTime, basicTimePrice, overPrice, is));
				rentalPriceTable.loadDate();
		
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}

 		if(e.getSource()==btnDelete) {
 			int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION);
 			if(delete==0) {
 				rentalPriceService.deleteRentalPrice(new RentalPrice(cCode));
 				rentalPriceTable.loadDate();
 			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
				
			}
 		}
		setRentalPriceValueClear();
	}
}
