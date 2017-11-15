package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.content.RentalPriceManagerContent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.service.CarDataService;

@SuppressWarnings("serial")
public class AdminMainCarManagerRentalPrice extends JPanel {
	private ComboBoxComponent<CarData> searchCode;
	
	public AdminMainCarManagerRentalPrice() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel totalPanel = new JPanel();
		totalPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uB300\uC5EC\uB2E8\uAC00 \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		totalPanel.setBounds(12, 10, 957, 698);
		add(totalPanel);
		totalPanel.setLayout(null);
		
		RentalPriceManagerContent inputPanel = new RentalPriceManagerContent();
		inputPanel.setBounds(12, 27, 286, 646);
		totalPanel.add(inputPanel);
		
		JPanel listPanel = new JPanel();
		listPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uC804\uCCB4 \uBCF4\uAE30 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listPanel.setBounds(310, 27, 624, 650);
		totalPanel.add(listPanel);
		listPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 75, 600, 561);
		listPanel.add(panel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setBounds(95, 10, 440, 55);
		listPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
		searchCode = new ComboBoxComponent<>("차 코드");
		searchCode.setBounds(74, 15, 244, 28);
		searchPanel.add(searchCode);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(331, 15, 97, 28);
		searchPanel.add(btnSearch);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(872, 718, 97, 23);
		add(btnBack);
		setSearchCarCodeComboModel();
	}
	
	public void setSearchCarCodeComboModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carData = new Vector<>();
		for(CarData cd : lists) {
			cd.setComboType(0);
			carData.add(cd);
		}
		searchCode.setComboBoxModel(carData);
	}
}
