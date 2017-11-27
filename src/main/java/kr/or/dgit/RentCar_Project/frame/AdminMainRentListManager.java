package kr.or.dgit.RentCar_Project.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.list.RentTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;

public class AdminMainRentListManager extends JFrame implements ActionListener{

	private JPanel contentPane;
	private RentTable rentTable;
	private JButton btnOk;
	private JButton btnAll;
	private ComboBoxComponent<String> yearCombo;
	private ComboBoxComponent<String> monthCombo;
	
	public AdminMainRentListManager(Rent rent) {
		
		setResizable(false);
		CarData carCode = CarDataService.getInstance().selectCarDataByCarDataCode(rent.getCarCode());

		setTitle(rent.getCarCode() + " ("+carCode.getCarName()+") "+"대여 기록");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 876, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rentTable = new RentTable();
		rentTable.setBounds(12, 91, 846, 417);
		rentTable.setRent(rent);
		rentTable.loadDate();
		contentPane.add(rentTable);
		
		btnOk = new JButton("확인");
		btnOk.setBounds(773, 518, 85, 23);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnOk);
		
		btnAll = new JButton("전체기록");
		btnAll.setBounds(773, 58, 85, 23);
		btnAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rentTable.setRent(rent);
				rentTable.loadDate();
			}
		});
		contentPane.add(btnAll);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(661, 48, 85, 23);
		contentPane.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uC120\uD0DD \uC0AC\uD56D ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(349, 16, 310, 55);
		contentPane.add(panel);
		
		JCheckBox checkReserve = new JCheckBox("예약기록");
		panel.add(checkReserve);
		
		JCheckBox checkCancel = new JCheckBox("취소기록");
		panel.add(checkCancel);
		
		JCheckBox checkComplete = new JCheckBox("완료기록");
		panel.add(checkComplete);
		
		JButton button = new JButton("검색");
		button.setBounds(688, 518, 85, 23);
		contentPane.add(button);
		
		yearCombo = new ComboBoxComponent<>("년도");
		yearCombo.setBounds(45, 28, 123, 43);
		contentPane.add(yearCombo);
		
		monthCombo = new ComboBoxComponent<>("월");
		monthCombo.setBounds(180, 28, 123, 43);
		contentPane.add(monthCombo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
