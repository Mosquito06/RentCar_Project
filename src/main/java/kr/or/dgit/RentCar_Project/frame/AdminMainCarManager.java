package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.JspinnerComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.list.CarDataTable;
import kr.or.dgit.RentCar_Project.list.RentalPriceTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.CarModelService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;
import kr.or.dgit.RentCar_Project.content.CarDataListManagerContent;
import kr.or.dgit.RentCar_Project.content.CarDataManagerContent;

@SuppressWarnings("serial")
public class AdminMainCarManager extends JPanel {
	
	
	private CarDataManagerContent carPanel;
	private CarDataListManagerContent carListPanel;

	public AdminMainCarManager() {
		setBounds(0, 0, 974, 751);
		setLayout(null);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(862, 728, 97, 23);
		add(btnBack);
		
		carPanel = new CarDataManagerContent();
		carPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uB4F1\uB85D  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carPanel.setBounds(12, 10, 950, 382);
		add(carPanel);
		carPanel.setLayout(null);
		
		carListPanel = new CarDataListManagerContent();
		carListPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uB9AC\uC2A4\uD2B8 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carListPanel.setBounds(12, 402, 950, 322);
		add(carListPanel);
		carListPanel.setLayout(null);
		
		carListPanel.setCdManagerContent(carPanel);
		carPanel.setCdListManagercontent(carListPanel);
	}
}
