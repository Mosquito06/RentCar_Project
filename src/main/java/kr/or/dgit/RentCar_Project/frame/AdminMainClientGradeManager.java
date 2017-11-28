package kr.or.dgit.RentCar_Project.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.content.ClientManagerContent;
import kr.or.dgit.RentCar_Project.content.UserGradeContent;
import kr.or.dgit.RentCar_Project.content.UserGradeListContent;

@SuppressWarnings("serial")
public class AdminMainClientGradeManager extends JFrame {

	private JPanel contentPane;
	private UserGradeContent userGrade;
	private UserGradeListContent userGradeList;
	
	public AdminMainClientGradeManager() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 365, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(282, 342, 69, 23);
		contentPane.add(btnOk);
		
		userGrade = new UserGradeContent();
		userGrade.setBounds(0, 7, 344, 153);
		contentPane.add(userGrade);
		
		userGradeList = new UserGradeListContent();
		userGradeList.setBounds(0, 159, 356, 179);
		contentPane.add(userGradeList);
		
		userGradeList.setUserGradeContnet(userGrade);
		userGrade.setUserGradeList(userGradeList);
	}
}
