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

	public ReserveAddCarContent(int time, User comfirmUser, List<CarData> lists) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		UserGradeService userGradeService = UserGradeService.getInstance();
		FuelService fuelService = FuelService.getInstance();
		RentalPriceService rentalPriceService = RentalPriceService.getInstance();

		for (int i = 0; i < lists.size(); i++) {
			CarData carCode = lists.get(i);
			RentalPrice rentalPrice = rentalPriceService.selectRentalPriceByCarCodeString(carCode.getCarCode());
			String carName = carCode.getCarName();
			int price = rentalPrice.getBasicPrice();
			int iPrice = rentalPrice.getInsurance();
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
			int dPrice = userGradeService.selectUserGradeByGrade(user).getDiscount();

			int dTotalPrice = ((price + btPrice * bTime + otPrice * (time - bTime)) * (dPrice)) / 100;
			int oTotalPrice = price + iPrice + btPrice * bTime + otPrice * (time - bTime);

			if (time <= bTime) {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName, String.valueOf(price) + "원",
						String.valueOf(iPrice) + "원", String.valueOf(0) + "원",
						String.valueOf(price + iPrice + btPrice * time) + "원", img, String.valueOf(old), seater, auto,
						fuelType);
				add(panel);
			} else if (time > (bTime * 1.2)) {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName, String.valueOf(price) + "원",
						String.valueOf(iPrice) + "원", String.valueOf(dTotalPrice) + "원",
						String.valueOf(oTotalPrice - dTotalPrice) + "원", img, String.valueOf(old), seater, auto,
						fuelType);
				add(panel);
			} else {
				ReserveCarPriceContent panel = new ReserveCarPriceContent(carName, String.valueOf(price) + "원",
						String.valueOf(iPrice) + "원", String.valueOf(0) + "원", String.valueOf(oTotalPrice) + "원", img,
						String.valueOf(old), seater, auto, fuelType);
				add(panel);
			}

		}

	}
}
