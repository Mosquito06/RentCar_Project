package kr.or.dgit.RentCar_Project.frame;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.list.RentTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;

@SuppressWarnings("serial")
public class AdminMainRentListManager extends JFrame{

	private JPanel contentPane;
	private RentTable rentTable;
	private JButton btnOk;
	private JRadioButton radioCancellation;
	private JRadioButton radioReservation;

	public AdminMainRentListManager(Rent rent) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(System.getProperty("user.dir") + "\\images\\Instapaper icon.png");
		setIconImage(img);
		
		setResizable(false);
		CarData carCode = CarDataService.getInstance().selectCarDataByCarDataCode(rent.getCarCode());

		setTitle(rent.getCarCode() + " ("+carCode.getCarName()+") "+"대여 기록");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 936, 580);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextFieldComponent carCodePanel = new TextFieldComponent("차코드");
		carCodePanel.setTextValue(carCode.getCarCode());
		carCodePanel.setBounds(93, 10, 226, 46);
		carCodePanel.setEnable(false);
		contentPane.add(carCodePanel);
		
		TextFieldComponent carNamePanel = new TextFieldComponent("차종명");
		carNamePanel.setTextValue(carCode.getCarName());
		carNamePanel.setEnable(false);
		carNamePanel.setBounds(331, 10, 308, 46);
		contentPane.add(carNamePanel);
		
		rentTable = new RentTable();
		rentTable.setBounds(12, 66, 906, 442);
		rentTable.setKey("carCode");
		rentTable.setValue(carCode);
		rentTable.loadDate();
		contentPane.add(rentTable);
	
		btnOk = new JButton("확인");
		btnOk.setBounds(833, 518, 85, 23);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnOk);

		radioReservation = new JRadioButton("예약(완료)내역");
		radioReservation.setFont(new Font("굴림", Font.PLAIN, 15));
		radioReservation.addItemListener(new ItemListener() {
	
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(radioReservation.isSelected()) {
					radioCancellation.setEnabled(false);
					rentTable.setKey("situation");
					rentTable.setValue(rent.getSituation().RESERVATION);
					rentTable.loadDate();
				}else {
					radioCancellation.setEnabled(true);
					rentTable.setKey("situation");
					rentTable.setValue(null);
					rentTable.loadDate();
				}
				
			}
		});
		
		
		radioReservation.setBounds(690, 37, 136, 23);
		contentPane.add(radioReservation);
		
		radioCancellation = new JRadioButton("취소내역");
		radioCancellation.setFont(new Font("굴림", Font.PLAIN, 15));
		radioCancellation.setBounds(830, 37, 85, 23);
		radioCancellation.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(radioCancellation.isSelected()) {
					radioReservation.setEnabled(false);
					rentTable.setKey("situation");
					rentTable.setValue(rent.getSituation().CANCELLATION);
					rentTable.loadDate();
				}else {
					radioReservation.setEnabled(true);
					rentTable.setKey("situation");
					rentTable.setValue(null);
					rentTable.loadDate();
				}
			}
		});
		contentPane.add(radioCancellation);
		
		
	}
}
