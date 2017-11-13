package kr.or.dgit.RentCar_Project.content;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.RentalPrice;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.RentalPriceService;
import kr.or.dgit.RentCar_Project.service.UserGradeService;

@SuppressWarnings("serial")
public class ReserveAddCarContent extends JPanel {

	
	public ReserveAddCarContent(int time,User comfirmUser) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		
		RentalPriceService rentalPriceService = RentalPriceService.getInstance();
		
		
		for(int i=0;i<lists.size();i++) {
			String carCode=lists.get(i).getCarCode();
			RentalPrice rentalPrice=rentalPriceService.selectRentalPriceByCarCodeString(carCode);
			String carName = lists.get(i).getCarName();
			int price = rentalPrice.getBasicPrice();
			int iPrice = rentalPrice.getInsurance();
			int btPrice = rentalPrice.getBasicTimePrice();
			int otPrice = rentalPrice.getOverPrice();
			int bTime = rentalPrice.getBasicTime();
			UserGrade user = comfirmUser.getGrade();
			UserGradeService userGradeService = UserGradeService.getInstance();
			int dPrice= userGradeService.selectUserGradeByGrade(user).getDiscount();
			
			int dTotalPrice =((price+btPrice*bTime+otPrice*(time-bTime))*(dPrice))/100;
			int oTotalPrice = price+iPrice+btPrice*bTime+otPrice*(time-bTime);
			
			if(time<=bTime) {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName,
						String.valueOf(price)+"원",String.valueOf(iPrice)+"원",
						String.valueOf(0)+"원",String.valueOf(price+iPrice+btPrice*time)+"원");
				add(panel);
			}else if(time>(bTime*1.2)) {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName,
						String.valueOf(price)+"원",String.valueOf(iPrice)+"원",
						String.valueOf(dTotalPrice)+"원",
						String.valueOf(oTotalPrice-dTotalPrice)+"원");
				add(panel);	
			}else {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName,
						String.valueOf(price)+"원",String.valueOf(iPrice)+"원",
						String.valueOf(0)+"원",
						String.valueOf(oTotalPrice)+"원");
				add(panel);
			}
			
		}
		
		
		

	}
}
