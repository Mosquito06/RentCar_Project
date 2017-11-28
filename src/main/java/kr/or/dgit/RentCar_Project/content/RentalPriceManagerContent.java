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
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.RentalPriceService;

@SuppressWarnings("serial")
public class RentalPriceManagerContent extends JPanel implements ActionListener{
	private TextFieldComponent bPrice;
	private TextFieldComponent useTime;
	private TextFieldComponent oPrice;
	private TextFieldComponent btPrice;
	private TextFieldComponent insurance;
	private JButton btnUpdate;
	private JButton btnDelete;
	private RentalPriceListManagerContent rpListManagerContent;
	private JButton btnCancel;
	private TextFieldComponent carCode;
	
	
	public void setRpListManagerContent(RentalPriceListManagerContent rpListManagerContent) {
		this.rpListManagerContent = rpListManagerContent;
	}
	public RentalPriceManagerContent() {
		setBounds(100, 100, 267, 489);
		setLayout(null);
		
		carCode = new TextFieldComponent("차 코드");
		carCode.setBounds(5, 38, 230, 30);
		carCode.setEnable(false);
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
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(177, 456, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
				if(clear==0) {
					setRentalPriceValueClear();
					setActive(false);
				}
			}
		});
		add(btnCancel);
		setActive(false);
	}
	
	public TextFieldComponent getCarCode() {
		return carCode;
	}
	public TextFieldComponent getbPrice() {
		return bPrice;
	}
	public TextFieldComponent getUseTime() {
		return useTime;
	}
	public TextFieldComponent getoPrice() {
		return oPrice;
	}
	public TextFieldComponent getBtPrice() {
		return btPrice;
	}
	public TextFieldComponent getInsurance() {
		return insurance;
	}

	public void setRentalPriceValueClear() {
		carCode.setTextValue("");
		bPrice.setTextValue("");
		useTime.setTextValue("");
		oPrice.setTextValue("");
		btPrice.setTextValue("");
		insurance.setTextValue("");
	}
	public void setActive(boolean active) {
		bPrice.setEnable(active);
		useTime.setEnable(active);
		oPrice.setEnable(active);
		btPrice.setEnable(active);
		insurance.setEnable(active);
		btnUpdate.setEnabled(active);
		btnDelete.setEnabled(active);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		RentalPriceService rentalPriceService = RentalPriceService.getInstance();
		String carCode = rpListManagerContent.search.getComboboxValue().getCarCode();
		RentalPrice rentalPrice = rentalPriceService.selectRentalPriceByCarCodeString(carCode);
		CarData cCode = rentalPrice.getCarCode();
		int basicPrice = Integer.parseInt(bPrice.getTextValue().replaceAll(",", "").trim());
		int basicTime  = Integer.parseInt(useTime.getTextValue());
		int basicTimePrice = Integer.parseInt(btPrice.getTextValue().replaceAll(",", "").trim());
		int overPrice = Integer.parseInt(oPrice.getTextValue().replaceAll(",", "").trim());
		int is = Integer.parseInt(insurance.getTextValue().replaceAll(",", "").trim());
		
 		if(e.getSource()==btnUpdate) {
			int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
			if(update==0) {
				rentalPriceService.updateRentalPrice(new RentalPrice(cCode, basicPrice, basicTime, basicTimePrice, overPrice, is));
				rpListManagerContent.rpTable.loadDate();
				//rpListManagerContent.setSearchCarCodeComboModel();
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}

 		if(e.getSource()==btnDelete) {
 			int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
 			if(delete==0) {
 				rentalPriceService.deleteRentalPrice(new RentalPrice(cCode));
 				rpListManagerContent.rpTable.loadDate();
				rpListManagerContent.setSearchCarCodeComboModel();
 			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");	
			}
 		}
 		
		setRentalPriceValueClear();
		setActive(false);
		/*rpListManagerContent.rpTable.setFull(true);
		rpListManagerContent.rpTable.loadDate();*/
	}
}
