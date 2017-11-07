package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.frame.UserMain;
import kr.or.dgit.RentCar_Project.frame.UserMainHome;

@SuppressWarnings("serial")
public class ReserveLeftContent extends JPanel {


	public ReserveLeftContent() {
		setBorder(null);
		setLayout(null);
		
		ComboBoxComponent panel = new ComboBoxComponent("제조회사  ");
		panel.setBounds(45, 59, 191, 36);
		add(panel);
		
		ComboBoxComponent comboBoxComponent = new ComboBoxComponent("연료종류  ");
		comboBoxComponent.setBounds(45, 131, 191, 36);
		add(comboBoxComponent);
		
		ComboBoxComponent comboBoxComponent_1 = new ComboBoxComponent("연식  ");
		comboBoxComponent_1.setBounds(45, 210, 191, 36);
		add(comboBoxComponent_1);
		
		ComboBoxComponent comboBoxComponent_2 = new ComboBoxComponent("인승  ");
		comboBoxComponent_2.setBounds(45, 290, 191, 36);
		add(comboBoxComponent_2);
		
		ComboBoxComponent comboBoxComponent_3 = new ComboBoxComponent("상세 차 검색  ");
		comboBoxComponent_3.setBounds(45, 369, 191, 36);
		add(comboBoxComponent_3);
		
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

	}
}
