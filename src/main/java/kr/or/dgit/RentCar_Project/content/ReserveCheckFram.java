package kr.or.dgit.RentCar_Project.content;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;

@SuppressWarnings("serial")
public class ReserveCheckFram extends JFrame {

	private JPanel contentPane;
	private TextFieldComponent tfInsurance;
	private JButton btnReserve;
	private TextFieldComponent tfPrice;

	public TextFieldComponent getTfPrice() {
		return tfPrice;
	}

	public JButton getBtnReserve() {
		return btnReserve;
	}

	public TextFieldComponent getTfInsurance() {
		return tfInsurance;
	}

	public ReserveCheckFram(String name, String img,String old, String seater, String auto, String fuel,String sDay,String fDay) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 636, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnReserve = new JButton("예약");
		btnReserve.setBounds(125, 450, 127, 37);
		contentPane.add(btnReserve);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(368, 450, 127, 37);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 0, 5, 0));
		panel.setBounds(0, 0, 603, 37);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		TextFieldComponent tfSDay = new TextFieldComponent("대여일");
		panel.add(tfSDay);
		tfSDay.setTextValue(sDay);
		tfSDay.getTextField().setFocusable(false);
		TextFieldComponent tfEDay = new TextFieldComponent("반납일");
		panel.add(tfEDay);
		tfEDay.setTextValue(fDay);
		tfEDay.getTextField().setFocusable(false);
		tfPrice = new TextFieldComponent("결제금액");
		panel.add(tfPrice);
		tfPrice.getTextField().setFocusable(false);
		tfInsurance = new TextFieldComponent("자차보험");
		tfInsurance.setTextValue("O");
		tfInsurance.setBounds(463, 36, 140, 23);
		contentPane.add(tfInsurance);
		tfInsurance.getTextField().setFocusable(false);
		ReserveCarValue carValue = new ReserveCarValue(name, img, old, seater, auto, fuel);
		carValue.setBounds(0, 36, 620, 404);
		contentPane.add(carValue);
	}
}
