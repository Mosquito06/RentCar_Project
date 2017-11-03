package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.component.calendarComponent;

public class calendarFrame extends JFrame {

	private JPanel contentPane;
	private JTextField DateField;


	public calendarFrame(JTextField DateField) {
		this.DateField = DateField;
		setBounds(100, 100, 306, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		calendarComponent calendarPanel = new calendarComponent(this, DateField);
		contentPane.add(calendarPanel, BorderLayout.NORTH);
	
	
	}
}
