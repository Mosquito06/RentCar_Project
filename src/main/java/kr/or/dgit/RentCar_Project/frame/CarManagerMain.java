package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.GridLayout;
import kr.or.dgit.RentCar_Project.content.CarManagerContent;
import javax.swing.JLabel;
import kr.or.dgit.RentCar_Project.content.ClientManagerContent;

public class CarManagerMain extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarManagerMain frame = new CarManagerMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CarManagerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		CarManagerContent panel = new CarManagerContent();
		tabbedPane.addTab("차량 관리", null, panel, null);
		
		ClientManagerContent panel_1 = new ClientManagerContent();
		tabbedPane.addTab("고객 관리", null, panel_1, null);
	}
}
