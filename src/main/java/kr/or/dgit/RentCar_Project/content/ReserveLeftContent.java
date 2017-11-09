package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.frame.UserMain;
import kr.or.dgit.RentCar_Project.frame.UserMainHome;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class ReserveLeftContent extends JPanel {


	private ComboBoxComponent<Manufacturer> comboBoxManufacturer;

	public ReserveLeftContent() {
		setBorder(null);
		setLayout(null);
		
		comboBoxManufacturer = new ComboBoxComponent<>("제조회사  ");
		comboBoxManufacturer.setBounds(45, 59, 191, 36);
		add(comboBoxManufacturer);
		
		ComboBoxComponent comboBoxFuel = new ComboBoxComponent("연료종류  ");
		comboBoxFuel.setBounds(45, 131, 191, 36);
		add(comboBoxFuel);
		
		ComboBoxComponent comboBoxOld = new ComboBoxComponent("연식  ");
		comboBoxOld.setBounds(45, 210, 191, 36);
		add(comboBoxOld);
		
		ComboBoxComponent comboBoxSeater = new ComboBoxComponent("인승  ");
		comboBoxSeater.setBounds(45, 290, 191, 36);
		add(comboBoxSeater);
		
		ComboBoxComponent comboBoxCarName = new ComboBoxComponent("상세 차 검색  ");
		comboBoxCarName.setBounds(45, 369, 191, 36);
		add(comboBoxCarName);
		
		RadioComponent panel_2 = new RadioComponent("변속기", "오토", "수동");
		panel_2.setBounds(40, 435, 205, 70);
		add(panel_2);
		
		RadioComponent radioComponent = new RadioComponent("자차 보험", "포함", "비포함");
		radioComponent.setBounds(40, 506, 205, 70);
		add(radioComponent);
		
		JButton btnNewButton = new JButton("나가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new UserMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(62, 594, 167, 53);
		add(btnNewButton);
		setBoxModel(); 
	}
	
	public void setBoxModel() {
		ManufacturerService manufacturerService = ManufacturerService.getInstance();
		List<Manufacturer> lists = manufacturerService.selectManufacturerByAll();
		Vector<Manufacturer> manufacturer = new Vector<>(lists);

		comboBoxManufacturer.setComboBoxModel(manufacturer);
	}
	
	
	
}



























