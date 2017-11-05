package kr.or.dgit.RentCar_Setting;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DBSettingHome extends JFrame {

	private JPanel contentPane;

	public DBSettingHome() {
		setTitle("데이터베이스 설치");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnInit = new JButton(new BtnAction("초기화"));
		btnInit.setBounds(214, 176, 149, 40);
		panel.add(btnInit);
		
		JButton btnExport = new JButton(new BtnAction("백업"));
		btnExport.setBounds(214, 304, 149, 40);
		panel.add(btnExport);
		
		JButton btnImport = new JButton(new BtnAction("복원"));
		btnImport.setBounds(214, 242, 149, 40);
		panel.add(btnImport);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\DBBack.jpg"));
		lblNewLabel.setBounds(0, 0, 574, 416);
		panel.add(lblNewLabel);
	}

}
