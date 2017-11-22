package kr.or.dgit.RentCar_Project.content;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.RentalPrice;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.RentalPriceService;
import kr.or.dgit.RentCar_Project.service.UserGradeService;

@SuppressWarnings("serial")
public class ReserveAddCarContent extends JPanel {

	private int iPrice;

	public ReserveAddCarContent(int time, User comfirmUser, List<CarData> lists,String sDay,String fDay,Boolean isInsurance) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		UserGradeService userGradeService = UserGradeService.getInstance();
		FuelService fuelService = FuelService.getInstance();
		RentalPriceService rentalPriceService = RentalPriceService.getInstance();

		for (int i = 0; i < lists.size(); i++) {
			CarData carCode = lists.get(i);
			RentalPrice rentalPrice = rentalPriceService.selectRentalPriceByCarCodeString(carCode.getCarCode());
			String carName = carCode.getCarName();
			int price = rentalPrice.getBasicPrice();
			if(isInsurance) {
				iPrice = rentalPrice.getInsurance();
			}else {
				iPrice =0;
			}
			
			int btPrice = rentalPrice.getBasicTimePrice();
			int otPrice = rentalPrice.getOverPrice();
			int bTime = rentalPrice.getBasicTime();
			UserGrade user = comfirmUser.getGrade();
			String img = carCode.getCarImage();
			int old = carCode.getCarOld();
			String seater = carCode.getCarSeater();
			Fuel fuelCode = carCode.getFuelCode();
			String fuelType = fuelService.selectFuelByFuelCode(fuelCode).getFuelType();

			String auto = carCode.getIsAuto().toString();
			if(auto.equals("MANUAL")) {
				auto="수동";
			}
			int dPrice = userGradeService.selectUserGradeByGrade(user).getDiscount();

			int dTotalPrice = ((price + btPrice * bTime + otPrice * (time - bTime)) * (dPrice)) / 100;
			int oTotalPrice = price + iPrice + btPrice * bTime + otPrice * (time - bTime);

			if (time <= bTime) {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName, String.format("%,d",price) + "원",
						String.format("%,d",iPrice) + "원", String.valueOf(0) + "원",
						String.format("%,d",price + iPrice + btPrice * time) + "원", img, String.valueOf(old), seater, auto,
						fuelType,sDay,fDay,time,carCode,comfirmUser);
				add(panel);
			} else if (time > (bTime * 1.2)) {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName, String.format("%,d",price) + "원",
						String.format("%,d",iPrice)  + "원", String.format("%,d",dTotalPrice) + "원",
						String.format("%,d",oTotalPrice - dTotalPrice) + "원", img, String.valueOf(old), seater, auto,
						fuelType,sDay,fDay,time,carCode,comfirmUser);
				add(panel);
			} else {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName, String.format("%,d",price) + "원",
						String.format("%,d",iPrice)  + "원", String.valueOf(0) + "원", String.format("%,d",oTotalPrice) + "원", img,
						String.valueOf(old), seater, auto, fuelType,sDay,fDay,time,carCode,comfirmUser);
				add(panel);
			}

		}
		
		if(lists.size()==1) {
			JPanel jp = new JPanel();
			add(jp);
		}

	}
}
