package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.CarModelContent;
import kr.or.dgit.RentCar_Project.content.CarModellListManagerContent;
import kr.or.dgit.RentCar_Project.content.FuelListManagerContent;
import kr.or.dgit.RentCar_Project.content.FuelManagerContent;
import kr.or.dgit.RentCar_Project.content.ManufacturerListContent;
import kr.or.dgit.RentCar_Project.content.ManufacturerManagerContent;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class AdminMainCarManagerCarDetail extends JPanel{
	private String[] details = {"선택하세요","대여단가 관리","초기화면"};
	private FuelManagerContent inputFuelPanel;
	private ManufacturerManagerContent inputManufacturer;
	private CarModelContent inputCarModel;
	private CarModellListManagerContent listCarModel;
	private FuelListManagerContent listFuel;
	private ManufacturerListContent listManufacturer;
	
	public AdminMainCarManagerCarDetail() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel manufacturerPanel = new JPanel();
		manufacturerPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC81C\uC870\uD68C\uC0AC \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		manufacturerPanel.setBounds(27, 10, 795, 243);
		add(manufacturerPanel);
		manufacturerPanel.setLayout(null);
		
		inputManufacturer = new ManufacturerManagerContent();
		inputManufacturer.setBounds(12, 47, 345, 170);
		manufacturerPanel.add(inputManufacturer);
		
		listManufacturer = new ManufacturerListContent();
		listManufacturer.setBounds(359, 10, 427, 225);
		manufacturerPanel.add(listManufacturer);
		inputManufacturer.setMfList(listManufacturer);
		listManufacturer.setMfManagerContent(inputManufacturer);
		
		JPanel carModelPanel = new JPanel();
		carModelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uC885 \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		carModelPanel.setBounds(27, 255, 795, 243);
		add(carModelPanel);
		carModelPanel.setLayout(null);
		
		inputCarModel = new CarModelContent();
		inputCarModel.setBounds(12, 47, 345, 170);
		carModelPanel.add(inputCarModel);
		
		listCarModel = new CarModellListManagerContent();
		listCarModel.setBounds(359, 10, 427, 225);
		carModelPanel.add(listCarModel);
		inputCarModel.setCm(listCarModel);
		listCarModel.setCmContent(inputCarModel);
		
		JPanel fuelPanel = new JPanel();
		fuelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC5F0\uB8CC\uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fuelPanel.setBounds(27, 503, 795, 243);
		add(fuelPanel);
		fuelPanel.setLayout(null);
		
		inputFuelPanel = new FuelManagerContent();
		inputFuelPanel.setBounds(12, 47, 345, 170);
		fuelPanel.add(inputFuelPanel);
		
		listFuel = new FuelListManagerContent();
		listFuel.setBounds(359, 10, 427, 225);
		fuelPanel.add(listFuel);
		
		inputFuelPanel.setFuelList(listFuel);
		listFuel.setFMContent(inputFuelPanel);
		
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
		btnBack.setBounds(865, 718, 97, 23);
		add(btnBack);
		
		JButton button = new JButton("세부사항 관리");
		button.setBounds(847, 20, 115, 23);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selected = JOptionPane.showInputDialog(null, "세부관리 사항을 선택하세요", "세부관리", JOptionPane.QUESTION_MESSAGE, null, details, details[0]);
				openDetailFrame(selected);
				
			}

		});
		add(button);
	}
	private void openDetailFrame(Object selected) {
		JFrame frame = AdminMain.getInstance();
		frame.getContentPane().removeAll();
			if(selected==details[0]){
			JOptionPane.showMessageDialog(null, "세부사향을 선택하세요");
			return;
		}else if(selected==details[1]) {
			frame.getContentPane().add(new AdminMainCarManagerRentalPrice(), BorderLayout.CENTER);
		}else if(selected==details[2]) {
			frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
		}else {
			return;
		}
			frame.setVisible(true);
		
	}
	
}
