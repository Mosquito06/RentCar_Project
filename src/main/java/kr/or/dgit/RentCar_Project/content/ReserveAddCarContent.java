package kr.or.dgit.RentCar_Project.content;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.IsAuto;
import kr.or.dgit.RentCar_Project.dto.RentalPrice;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.RentalPriceService;
import kr.or.dgit.RentCar_Project.service.UserGradeService;

@SuppressWarnings("serial")
public class ReserveAddCarContent extends JPanel {

	
	public ReserveAddCarContent(int time,User comfirmUser) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		CarDataService carDataService = CarDataService.getInstance();
		UserGradeService userGradeService = UserGradeService.getInstance();
		FuelService fuelService = FuelService.getInstance();
		RentalPriceService rentalPriceService = RentalPriceService.getInstance();
		List<RentalPrice> lists = rentalPriceService.selectRentalPriceByAll();
		
		for(int i=0;i<lists.size();i++) {
			CarData carCode=lists.get(i).getCarCode();
			RentalPrice rentalPrice=rentalPriceService.selectRentalPriceByCarCodeString(carCode.getCarCode());
			String carName = carDataService.selectCarDataByCarDataCode(carCode).getCarName();
			int price = rentalPrice.getBasicPrice();
			int iPrice = rentalPrice.getInsurance();
			int btPrice = rentalPrice.getBasicTimePrice();
			int otPrice = rentalPrice.getOverPrice();
			int bTime = rentalPrice.getBasicTime();
			UserGrade user = comfirmUser.getGrade();
			String img = carDataService.selectCarDataByCarDataCode(carCode).getCarImage();
			int old = carDataService.selectCarDataByCarDataCode(carCode).getCarOld();
			String seater = carDataService.selectCarDataByCarDataCode(carCode).getCarSeater();
			Fuel fuelCode=carDataService.selectCarDataByCarDataCode(carCode).getFuelCode();
			
			Fuel fuel = fuelService.selectFuelByFuelCodeString(fuelCode.getFuelCode());
			JOptionPane.showMessageDialog(null, fuel);
			String auto = carDataService.selectCarDataByCarDataCode(carCode).getIsAuto().toString();
			int dPrice= userGradeService.selectUserGradeByGrade(user).getDiscount();
			
			int dTotalPrice =((price+btPrice*bTime+otPrice*(time-bTime))*(dPrice))/100;
			int oTotalPrice = price+iPrice+btPrice*bTime+otPrice*(time-bTime);
			
			if(time<=bTime) {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName,
						String.valueOf(price)+"원",String.valueOf(iPrice)+"원",
						String.valueOf(0)+"원",String.valueOf(price+iPrice+btPrice*time)+"원",img,
						String.valueOf(old),"",seater,auto
						);
				add(panel);
			}else if(time>(bTime*1.2)) {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName,
						String.valueOf(price)+"원",String.valueOf(iPrice)+"원",
						String.valueOf(dTotalPrice)+"원",
						String.valueOf(oTotalPrice-dTotalPrice)+"원",img,
						String.valueOf(old),"",seater,auto);
				add(panel);	
			}else {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName,
						String.valueOf(price)+"원",String.valueOf(iPrice)+"원",
						String.valueOf(0)+"원",
						String.valueOf(oTotalPrice)+"원",img,
						String.valueOf(old),"",seater,auto);
				add(panel);
			}
			
		}
		
		
		

	}
}
