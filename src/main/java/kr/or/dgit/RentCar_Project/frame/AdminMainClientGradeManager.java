package kr.or.dgit.RentCar_Project.frame;

import java.awt.Image;
import java.awt.Toolkit;
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
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(System.getProperty("user.dir") + "\\images\\Instapaper icon.png");
		setIconImage(img);
		setTitle("등급&할인률관리");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 368, 410);
		setLocationRelativeTo(null);
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
		btnOk.setBounds(291, 355, 69, 23);
		contentPane.add(btnOk);
		
		userGrade = new UserGradeContent();
		userGrade.setBounds(0, 7, 344, 153);
		contentPane.add(userGrade);
		
		userGradeList = new UserGradeListContent();
		userGradeList.setBounds(0, 159, 360, 189);
		contentPane.add(userGradeList);
		
		userGradeList.setUserGradeContnet(userGrade);
		userGrade.setUserGradeList(userGradeList);
	}
}
