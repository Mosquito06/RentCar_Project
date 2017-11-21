package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import javax.swing.JButton;
import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.JspinnerComponent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class CarDataManagerContent extends JPanel {

	private TextFieldComponent carDataCode;

	public CarDataManagerContent() {
		setBounds(100, 100, 950, 380);
		setLayout(null);
		
		ComboBoxComponent carModelCombo = new ComboBoxComponent("차종 코드");
		carModelCombo.setBounds(10, 15, 163, 32);
		add(carModelCombo);
		
		ComboBoxComponent mfCombo = new ComboBoxComponent("제조회사코드");
		mfCombo.setBounds(194, 15, 163, 32);
		add(mfCombo);
		
		ComboBoxComponent fuelCombo = new ComboBoxComponent("연료코드");
		fuelCombo.setBounds(379, 15, 163, 32);
		add(fuelCombo);
		
		carDataCode = new TextFieldComponent("차 코드");
		carDataCode.setBounds(571, 15, 173, 32);
		add(carDataCode);
		
		TextFieldComponent panel_2 = new TextFieldComponent((String) null);
		panel_2.setBounds(10, 58, 163, 32);
		add(panel_2);
		
		RadioComponent panel_4 = new RadioComponent("변속기","오토","수동");
		panel_4.setBounds(12, 218, 163, 32);
		add(panel_4);
		
		TextFieldComponent panel_5 = new TextFieldComponent("인승");
		panel_5.setBounds(12, 176, 163, 32);
		add(panel_5);
		
		ComboBoxComponent panel_6 = new ComboBoxComponent("차종코드");
		panel_6.setBounds(12, 340, 163, 32);
		add(panel_6);
		
		ComboBoxComponent panel_7 = new ComboBoxComponent("제조회사코드");
		panel_7.setBounds(12, 256, 163, 32);
		add(panel_7);
		
		ComboBoxComponent panel_8 = new ComboBoxComponent("연료코드");
		panel_8.setBounds(12, 298, 163, 32);
		add(panel_8);
		
		JButton btnDetail = new JButton("세부사항");
		btnDetail.setBounds(841, 15, 97, 30);
		add(btnDetail);
		
		TextFieldComponent panel_10 = new TextFieldComponent((String) null);
		panel_10.setBounds(10, 93, 163, 32);
		add(panel_10);
		
		JspinnerComponent panel_11 = new JspinnerComponent((String) null);
		panel_11.setBounds(12, 136, 163, 32);
		add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.setBounds(194, 64, 513, 308);
		add(panel_12);
		
		JButton btnAddPhoto = new JButton("New button");
		btnAddPhoto.setBounds(711, 67, 97, 23);
		add(btnAddPhoto);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(841, 349, 97, 23);
		add(btnNewButton_2);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(711, 102, 97, 23);
		add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(841, 65, 97, 23);
		add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(841, 95, 97, 23);
		add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(841, 126, 97, 23);
		add(button_4);
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 15, 27, 32);
		add(lblNewLabel);
		
		JLabel label = new JLabel("+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		label.setBounds(354, 15, 27, 32);
		add(label);
		
		JLabel label_1 = new JLabel("=");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		label_1.setBounds(542, 15, 27, 32);
		add(label_1);
	}
}
