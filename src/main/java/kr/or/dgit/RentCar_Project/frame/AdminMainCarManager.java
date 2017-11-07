package kr.or.dgit.RentCar_Project.frame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.JspinnerComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JButton;
import javax.swing.JFrame;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import kr.or.dgit.RentCar_Project.content.CarModelContent;
import kr.or.dgit.RentCar_Project.content.FuelManagerContent;
import kr.or.dgit.RentCar_Project.content.ManufacturerManagerContent;
import kr.or.dgit.RentCar_Project.content.RentalPriceManagerContent;

public class AdminMainCarManager extends JPanel {
	private JTable table;

	public AdminMainCarManager() {
		setBounds(0, 0, 974, 751);
		setLayout(null);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(865, 726, 97, 23);
		add(btnBack);
		
		JButton btnAllReset = new JButton("전체 초기화");
		btnAllReset.setBounds(756, 726, 97, 23);
		add(btnAllReset);
		
		CarModelContent carModelPanel = new CarModelContent();
		carModelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uC885 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carModelPanel.setBounds(12, 10, 574, 143);
		add(carModelPanel);
		carModelPanel.setLayout(null);
		
		ManufacturerManagerContent manufacturerPanel = new ManufacturerManagerContent();
		manufacturerPanel.setBounds(608, 10, 354, 143);
		add(manufacturerPanel);
		manufacturerPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC81C\uC870\uD68C\uC0AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		manufacturerPanel.setLayout(null);
		
		RentalPriceManagerContent pricePanel = new RentalPriceManagerContent();
		pricePanel.setBounds(12, 163, 574, 167);
		add(pricePanel);
		pricePanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uB300\uC5EC \uB2E8\uAC00 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pricePanel.setLayout(null);
		
		FuelManagerContent oliPanel = new FuelManagerContent();
		oliPanel.setBounds(608, 163, 354, 167);
		add(oliPanel);
		oliPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC5F0\uB8CC\uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		oliPanel.setLayout(null);
		
		JPanel carPanel = new JPanel();
		carPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carPanel.setBounds(12, 337, 950, 379);
		add(carPanel);
		carPanel.setLayout(null);
		
		TextFieldComponent carCodPanelc = new TextFieldComponent("차 코드");
		carCodPanelc.setBounds(5, 20, 230, 30);
		carPanel.add(carCodPanelc);
		
		TextFieldComponent carNamePanel = new TextFieldComponent("차 이름");
		carNamePanel.setBounds(5, 60, 230, 30);
		carPanel.add(carNamePanel);
		
		TextFieldComponent modelYearPanel = new TextFieldComponent("연식");
		modelYearPanel.setBounds(5, 100, 230, 30);
		carPanel.add(modelYearPanel);
		
		TextFieldComponent seaterPanel = new TextFieldComponent("인승");
		seaterPanel.setBounds(5, 220, 230, 30);
		carPanel.add(seaterPanel);
		
		RadioComponent autoPanel = new RadioComponent("오토유무","yes", "no");
		autoPanel.setBounds(15, 180, 255, 30);
		carPanel.add(autoPanel);
		
		JspinnerComponent carCountPanel = new JspinnerComponent("차량대수");
		carCountPanel.setBounds(5, 140, 230, 30);
		carPanel.add(carCountPanel);
		
		ComboBoxComponent carModelCodePanelc = new ComboBoxComponent("차종코드");
		carModelCodePanelc.setBounds(5, 260, 230, 30);
		carPanel.add(carModelCodePanelc);
		
		ComboBoxComponent cpCodePanel = new ComboBoxComponent("제조회사코드");
		cpCodePanel.setBounds(5, 300, 230, 30);
		carPanel.add(cpCodePanel);
		
		ComboBoxComponent oCodePanel = new ComboBoxComponent("연료코드");
		oCodePanel.setBounds(5, 339, 230, 30);
		carPanel.add(oCodePanel);
		
		JButton button_16 = new JButton("검색");
		button_16.setBounds(624, 20, 66, 23);
		carPanel.add(button_16);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(275, 53, 415, 278);
		carPanel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_10.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBorder(new EmptyBorder(0, 0, 0, 10));
		panel_10.add(labelPanel, BorderLayout.SOUTH);
		labelPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lbllabel = new JLabel("New label");
		labelPanel.add(lbllabel, BorderLayout.EAST);
		
		JButton btnNewButton_5 = new JButton("차트보기");
		btnNewButton_5.setBounds(841, 20, 97, 23);
		carPanel.add(btnNewButton_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(702, 53, 236, 278);
		carPanel.add(panel_11);
		
		JButton button_8 = new JButton("삭제");
		button_8.setBounds(444, 346, 66, 23);
		carPanel.add(button_8);
		
		JButton button_7 = new JButton("수정");
		button_7.setBounds(370, 346, 66, 23);
		carPanel.add(button_7);
		
		JButton button_10 = new JButton("추가");
		button_10.setBounds(292, 346, 66, 23);
		carPanel.add(button_10);
		
		JButton button_9 = new JButton("취소");
		button_9.setBounds(872, 346, 66, 23);
		carPanel.add(button_9);
		
		ComboBoxComponent searchCombo = new ComboBoxComponent("차 코드");
		searchCombo.setBounds(275, 20, 337, 30);
		carPanel.add(searchCombo);
	}
}
