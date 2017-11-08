package kr.or.dgit.RentCar_Project.content;

import java.awt.FlowLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ReserveAddCarContent extends JPanel {

	
	public ReserveAddCarContent() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		for(int i=0;i<4;i++) {
			ReserveCarPriceContent panel = new ReserveCarPriceContent("차차차");
			add(panel);
		}
		
		
		

	}
}
