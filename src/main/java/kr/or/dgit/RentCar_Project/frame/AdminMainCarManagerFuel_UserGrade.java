package kr.or.dgit.RentCar_Project.frame;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import kr.or.dgit.RentCar_Project.content.FuelManagerContent;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EtchedBorder;
import kr.or.dgit.RentCar_Project.content.UserGradeContent;

@SuppressWarnings("serial")
public class AdminMainCarManagerFuel_UserGrade extends JPanel {

	public AdminMainCarManagerFuel_UserGrade() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel fuelPanel = new JPanel();
		fuelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC5F0\uB8CC \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fuelPanel.setBounds(30, 43, 370, 669);
		add(fuelPanel);
		fuelPanel.setLayout(null);
		
		JPanel fuelList = new JPanel();
		fuelList.setBounds(12, 192, 345, 467);
		fuelPanel.add(fuelList);
		
		FuelManagerContent inputfuel = new FuelManagerContent();
		inputfuel.setBounds(12, 21, 345, 161);
		fuelPanel.add(inputfuel);
		
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
		
		JButton button = new JButton("세부사항 관리");
		button.setBounds(847, 53, 115, 23);
		add(button);
		
	}

}
