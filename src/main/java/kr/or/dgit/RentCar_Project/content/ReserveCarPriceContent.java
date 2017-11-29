package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import kr.or.dgit.RentCar_Project.component.VTextFieldComponent;
import kr.or.dgit.RentCar_Project.dao.CarDataDao;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.IsInsurance;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.dto.Situation;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.frame.UserMain;
import kr.or.dgit.RentCar_Project.frame.UserMainReserve;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.RentService;

@SuppressWarnings("serial")
public class ReserveCarPriceContent extends JPanel {
	private JPanel carReservePanel;
	private IsInsurance isInsurance;
	
	public ReserveCarPriceContent(String name, String cPrice, String iPrice, String dPrice, String fPrice, String img,
			String old, String seater, String auto, String fuel,String sDay,String fDay,int time,CarData carCode,User comfirmUser) {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		setLayout(new BorderLayout(0, 0));

		carReservePanel = new JPanel();
		carReservePanel.setBorder(new EmptyBorder(0, 15, 10, 15));
		add(carReservePanel, BorderLayout.SOUTH);
		carReservePanel.setLayout(new GridLayout(0, 5, 10, 0));

		VTextFieldComponent carPrice = new VTextFieldComponent("차량요금");
		carPrice.getTextField().setText(cPrice);
		carReservePanel.add(carPrice);

		VTextFieldComponent insurance = new VTextFieldComponent("보험료");
		insurance.getTextField().setText(iPrice);
		carReservePanel.add(insurance);

		VTextFieldComponent discountPrice = new VTextFieldComponent("할인금액");
		discountPrice.getTextField().setText(dPrice);
		carReservePanel.add(discountPrice);

		VTextFieldComponent finalPrice = new VTextFieldComponent("총 결제금액");
		finalPrice.getTextField().setText(fPrice);
		carReservePanel.add(finalPrice);

		JButton btnReserve = new JButton("예약");
		btnReserve.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				
				ReserveCheckFram checkFram = new ReserveCheckFram(name, img, old, seater, auto,fuel,sDay,fDay);
				if(insurance.getTextField().getText().equals("0원")) {
					checkFram.getTfInsurance().setTextValue("X");
					isInsurance = IsInsurance.FALSE;
				}else {
					isInsurance = IsInsurance.TRUE;
				}
				checkFram.getTfPrice().setTextValue(fPrice);
				checkFram.setVisible(true);
				checkFram.getBtnReserve().addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						RentService rentService=RentService.getInstance();
						SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
						Date dayStart = null;
						Date dayEnd=null;
						try {
							dayStart = simpleDate.parse(sDay);
							dayEnd= simpleDate.parse(fDay);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						String fp=fPrice.replace("원", "").replace(",", "");
						String dp=dPrice.replace("원", "").replace(",","");
						
						
						CarDataDao carDataDao = CarDataService.getInstance();
						CarData carData=carDataDao.selectCarDataByCarDataCode(carCode);
						if(carData.getCarNumber()==0) {
							return;
						}
						
						Rent rent = new Rent(Situation.RESERVATION,comfirmUser, String.valueOf(time),
								isInsurance, dayStart, dayEnd,Integer.parseInt(dp), Integer.parseInt(fp), carCode);
						rentService.insertRent(rent);
						int yes = JOptionPane.showOptionDialog(null, comfirmUser.getUserName()+" 님   "+sDay+"~"+fDay+" 예약완료", "예약완료",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
						if(yes==0) {
							checkFram.setVisible(false);
							JFrame frame = UserMain.getInstance();
							frame.getContentPane().removeAll();
							UserMainReserve userMainReserve = new UserMainReserve();
							userMainReserve.setComfirmUser(comfirmUser);
							frame.getContentPane().add(userMainReserve, BorderLayout.CENTER);
							frame.setVisible(true);
						}
					}
				});
			}
		});
		carReservePanel.add(btnReserve);

		ReserveListCarValue carValuePanel = new ReserveListCarValue(name, img, old, seater, auto, fuel);
		add(carValuePanel, BorderLayout.CENTER);
		


	}

}
