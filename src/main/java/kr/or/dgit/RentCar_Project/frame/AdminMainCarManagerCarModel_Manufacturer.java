package kr.or.dgit.RentCar_Project.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EtchedBorder;
import kr.or.dgit.RentCar_Project.content.ManufacturerManagerContent;
import kr.or.dgit.RentCar_Project.content.CarModelContent;

public class AdminMainCarManagerCarModel_Manufacturer extends JPanel {
	public AdminMainCarManagerCarModel_Manufacturer() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel carModelPanel = new JPanel();
		carModelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uC885 \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		carModelPanel.setBounds(30, 43, 370, 669);
		add(carModelPanel);
		carModelPanel.setLayout(null);
		
		CarModelContent inputCarModel = new CarModelContent();
		inputCarModel.setBounds(12, 21, 345, 161);
		carModelPanel.add(inputCarModel);
		
		JPanel carModelList = new JPanel();
		carModelList.setBounds(12, 192, 345, 467);
		carModelPanel.add(carModelList);
		
		JPanel manufacturerPanel = new JPanel();
		manufacturerPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC81C\uC870\uD68C\uC0AC \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		manufacturerPanel.setBounds(449, 43, 370, 669);
		add(manufacturerPanel);
		manufacturerPanel.setLayout(null);
		
		ManufacturerManagerContent inputManufacturer = new ManufacturerManagerContent();
		inputManufacturer.setBounds(12, 21, 346, 161);
		manufacturerPanel.add(inputManufacturer);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 192, 345, 467);
		manufacturerPanel.add(panel);
		
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
		btnBack.setBounds(865, 686, 97, 23);
		add(btnBack);
		
		JButton button = new JButton("세부사항 관리");
		button.setBounds(847, 53, 115, 23);
		add(button);
		
	}

}
