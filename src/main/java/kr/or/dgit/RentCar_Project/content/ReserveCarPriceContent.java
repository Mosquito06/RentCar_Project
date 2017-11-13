package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import kr.or.dgit.RentCar_Project.component.VTextFieldComponent;
import kr.or.dgit.RentCar_Project.service.CarDataService;


@SuppressWarnings("serial")
public class ReserveCarPriceContent extends JPanel {
	private JPanel carReservePanel;
	private JPanel carValuePanel;

	/**
	 * Create the panel.
	 */
	public ReserveCarPriceContent(String name,String cPrice,String iPrice,String dPrice,String fPrice,String img,
			String old,String seater,String auto,String fuel) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		carReservePanel = new JPanel();
		carReservePanel.setBorder(new EmptyBorder(0, 5, 0, 5));
		add(carReservePanel, BorderLayout.SOUTH);
		carReservePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

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
		carReservePanel.add(btnReserve);

		carValuePanel = new JPanel();
		add(carValuePanel, BorderLayout.NORTH);
		carValuePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblCarName = new JLabel(name);
		lblCarName.setFont(new Font("굴림", Font.BOLD, 17));
		lblCarName.setHorizontalAlignment(SwingConstants.CENTER);
		carValuePanel.add(lblCarName);

		JLabel lblCarValue = new JLabel();
		carValuePanel.add(lblCarValue);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel carImg = new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\images\\car\\"+img));
		carImg.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(carImg, BorderLayout.CENTER);
		
		JPanel carValue = new JPanel();
		panel.add(carValue, BorderLayout.SOUTH);
		
		VTextFieldComponent carOldTf = new VTextFieldComponent("연식");
		carOldTf.getTextField().setText(old);
		carValue.add(carOldTf);
		
		VTextFieldComponent fuelTf = new VTextFieldComponent("연료종류");
		fuelTf.getTextField().setText(fuel);
		carValue.add(fuelTf);
		
		VTextFieldComponent seaterTf = new VTextFieldComponent("인승");
		seaterTf.getTextField().setText(seater);
		carValue.add(seaterTf);
		
		VTextFieldComponent autoTf = new VTextFieldComponent("오토유무");
		autoTf.getTextField().setText(auto);
		carValue.add(autoTf);
		
		
		
	}


	
	
	
	
	

}
