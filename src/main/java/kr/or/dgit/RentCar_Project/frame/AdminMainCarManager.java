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
		btnBack.setBounds(862, 728, 97, 23);
		add(btnBack);
		
		JButton btnAllReset = new JButton("전체 초기화");
		btnAllReset.setBounds(750, 728, 97, 23);
		add(btnAllReset);
		
		CarModelContent carModelPanel = new CarModelContent();
		carModelPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uCC28\uC885 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carModelPanel.setBounds(278, 422, 327, 143);
		add(carModelPanel);
		carModelPanel.setLayout(null);
		
		ManufacturerManagerContent manufacturerPanel = new ManufacturerManagerContent();
		manufacturerPanel.setBounds(630, 575, 332, 143);
		add(manufacturerPanel);
		manufacturerPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uC81C\uC870\uD68C\uC0AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		manufacturerPanel.setLayout(null);
		
		RentalPriceManagerContent pricePanel = new RentalPriceManagerContent();
		pricePanel.setBounds(12, 422, 246, 297);
		add(pricePanel);
		pricePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uB300\uC5EC \uB2E8\uAC00 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pricePanel.setLayout(null);
		
		FuelManagerContent oliPanel = new FuelManagerContent();
		oliPanel.setBounds(278, 575, 327, 143);
		add(oliPanel);
		oliPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uC5F0\uB8CC\uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		oliPanel.setLayout(null);
		
		JPanel carPanel = new JPanel();
		carPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uB7C9 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carPanel.setBounds(12, 10, 598, 382);
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
		
		JButton button_8 = new JButton("삭제");
		button_8.setBounds(412, 346, 66, 23);
		carPanel.add(button_8);
		
		JButton button_7 = new JButton("수정");
		button_7.setBounds(346, 346, 66, 23);
		carPanel.add(button_7);
		
		JButton button_10 = new JButton("추가");
		button_10.setBounds(279, 346, 66, 23);
		carPanel.add(button_10);
		
		JButton button_9 = new JButton("취소");
		button_9.setBounds(520, 346, 66, 23);
		carPanel.add(button_9);
		
		JPanel panel = new JPanel();
		panel.setBounds(279, 20, 307, 310);
		carPanel.add(panel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		searchPanel.setBounds(617, 15, 345, 550);
		add(searchPanel);
		searchPanel.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("차트보기");
		btnNewButton_5.setBounds(252, 517, 81, 23);
		searchPanel.add(btnNewButton_5);
		
		ComboBoxComponent searchCombo = new ComboBoxComponent("차 코드");
		searchCombo.setBounds(12, 10, 246, 30);
		searchPanel.add(searchCombo);
		
		JPanel listPanel = new JPanel();
		listPanel.setBounds(12, 50, 321, 457);
		searchPanel.add(listPanel);
		listPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(267, 17, 66, 23);
		searchPanel.add(btnSearch);
	}
}
