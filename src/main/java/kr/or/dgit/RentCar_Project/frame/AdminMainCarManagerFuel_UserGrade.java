package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.FuelManagerContent;
import kr.or.dgit.RentCar_Project.content.UserGradeContent;
import kr.or.dgit.RentCar_Project.list.FuelTable;
import kr.or.dgit.RentCar_Project.list.UserGradeTable;

@SuppressWarnings("serial")
public class AdminMainCarManagerFuel_UserGrade extends JPanel {
	
	private FuelTable fuelTable;
	private UserGradeTable userGradeTable;
	private String[] details = {"선택하세요","대여단가 관리","차종&제조회사 관리","초기화면"};
	
	public AdminMainCarManagerFuel_UserGrade() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel fuelPanel = new JPanel();
		fuelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC5F0\uB8CC \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fuelPanel.setBounds(30, 43, 370, 669);
		add(fuelPanel);
		fuelPanel.setLayout(null);
		
		JPanel fuelList = new JPanel();
		fuelList.setBounds(12, 237, 345, 395);
		fuelPanel.add(fuelList);
		fuelList.setLayout(new BorderLayout(0, 0));
		fuelTable = new FuelTable();
		fuelTable.loadDate();
		fuelList.add(fuelTable);
		
		FuelManagerContent inputfuel = new FuelManagerContent();
		inputfuel.setBounds(12, 21, 345, 161);
		fuelPanel.add(inputfuel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(52, 189, 201, 38);
		fuelPanel.add(searchPanel);
		searchPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(256, 203, 65, 23);
		fuelPanel.add(btnSearch);
		
		JButton btnAll = new JButton("전체보기");
		btnAll.setBounds(270, 636, 87, 23);
		fuelPanel.add(btnAll);
		
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
		
		JPanel userGradePanel = new JPanel();
		userGradePanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), " \uACE0\uAC1D\uB4F1\uAE09 \uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		userGradePanel.setBounds(449, 43, 370, 669);
		add(userGradePanel);
		userGradePanel.setLayout(null);
		
		UserGradeContent inputUserGrade = new UserGradeContent();
		inputUserGrade.setBounds(12, 21, 345, 161);
		userGradePanel.add(inputUserGrade);
		
		JPanel userGradeList = new JPanel();
		userGradeList.setBounds(12, 192, 345, 467);
		userGradePanel.add(userGradeList);
		userGradeList.setLayout(new BorderLayout(0, 0));
		userGradeTable = new UserGradeTable();
		userGradeTable.loadDate();
		userGradeList.add(userGradeTable);
		
		JButton button = new JButton("세부사항 관리");
		button.setBounds(847, 53, 115, 23);
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
		if(selected==details[0]) {
			JOptionPane.showMessageDialog(null, "세부사항을 선택하세요");
		}
		if(selected==details[1]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManagerRentalPrice(), BorderLayout.CENTER);
			frame.setVisible(true);
		}else if(selected==details[2]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManagerCarModel_Manufacturer(), BorderLayout.CENTER);
			frame.setVisible(true);
		}else if(selected==details[3]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
			frame.setVisible(true);
		}else {
			return;
		}
		
	}
}
