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

public class AdminMainCarManager extends JPanel {
	private JTable table;
	private JTextField tfPath;

	public AdminMainCarManager() {
		setBounds(0, 0, 974, 751);
		setLayout(null);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?");
				if(confirm == 0){
					AdminMain.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					AdminMain.getInstance().setVisible(false);
				}
			}
		});
		btnBack.setBounds(865, 726, 97, 23);
		add(btnBack);
		
		JButton btnAllReset = new JButton("전체 초기화");
		btnAllReset.setBounds(756, 726, 97, 23);
		add(btnAllReset);
		
		JPanel carModelPanel = new JPanel();
		carModelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uCC28\uC885 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		carModelPanel.setBounds(12, 10, 597, 143);
		add(carModelPanel);
		carModelPanel.setLayout(null);
		
		kr.or.dgit.RentCar_Project.component.TextFieldComponent carModelCodePanel = new kr.or.dgit.RentCar_Project.component.TextFieldComponent("차종 코드");
		carModelCodePanel.setBounds(5, 30, 230, 30);
		carModelPanel.add(carModelCodePanel);
		
		kr.or.dgit.RentCar_Project.component.TextFieldComponent carModelNamePanel = new kr.or.dgit.RentCar_Project.component.TextFieldComponent("차종");
		carModelNamePanel.setBounds(5, 80, 230, 30);
		carModelPanel.add(carModelNamePanel);
		
		JButton btnCancelcm = new JButton("취소");
		btnCancelcm.setBounds(501, 110, 66, 23);
		carModelPanel.add(btnCancelcm);
		
		JButton btnAddcm = new JButton("추가");
		btnAddcm.setBounds(501, 15, 66, 23);
		carModelPanel.add(btnAddcm);
		
		JButton btnUpdatecm = new JButton("수정");
		btnUpdatecm.setBounds(501, 40, 66, 23);
		carModelPanel.add(btnUpdatecm);
		
		JButton btnDeletecm = new JButton("삭제");
		btnDeletecm.setBounds(501, 65, 66, 23);
		carModelPanel.add(btnDeletecm);
		
		JPanel panel = new JPanel();
		panel.setBounds(248, 30, 224, 82);
		carModelPanel.add(panel);
		panel.setLayout(null);
		
		tfPath = new JTextField();
		tfPath.setBounds(55, 10, 169, 29);
		panel.add(tfPath);
		tfPath.setColumns(10);
		
		JButton btnImgDelete = new JButton("이미지 삭제");
		btnImgDelete.setBounds(112, 49, 112, 29);
		panel.add(btnImgDelete);
		
		JButton btnImaAdd = new JButton("이미지 추가");
		btnImaAdd.setBounds(0, 49, 112, 29);
		panel.add(btnImaAdd);
		
		JLabel lblNewLabel = new JLabel("경로");
		lblNewLabel.setBounds(0, 10, 47, 29);
		panel.add(lblNewLabel);
		
		JPanel manufacturerPanel = new JPanel();
		manufacturerPanel.setBounds(621, 10, 341, 143);
		add(manufacturerPanel);
		manufacturerPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC81C\uC870\uD68C\uC0AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		manufacturerPanel.setLayout(null);
		
		kr.or.dgit.RentCar_Project.component.TextFieldComponent companyCodePanel = new kr.or.dgit.RentCar_Project.component.TextFieldComponent("제조회사 코드");
		companyCodePanel.setBounds(5, 30, 230, 30);
		manufacturerPanel.add(companyCodePanel);
		
		kr.or.dgit.RentCar_Project.component.TextFieldComponent companyNamePanel = new kr.or.dgit.RentCar_Project.component.TextFieldComponent("제조사 이름");
		companyNamePanel.setBounds(5, 70, 230, 30);
		manufacturerPanel.add(companyNamePanel);
		
		JButton btnAddcp = new JButton("추가");
		btnAddcp.setBounds(247, 15, 66, 23);
		manufacturerPanel.add(btnAddcp);
		
		JButton btnUpdatecp = new JButton("수정");
		btnUpdatecp.setBounds(247, 40, 66, 23);
		manufacturerPanel.add(btnUpdatecp);
		
		JButton btnDeletecp = new JButton("삭제");
		btnDeletecp.setBounds(247, 65, 66, 23);
		manufacturerPanel.add(btnDeletecp);
		
		JButton btnCancelcp = new JButton("취소");
		btnCancelcp.setBounds(247, 110, 66, 23);
		manufacturerPanel.add(btnCancelcp);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(12, 163, 597, 167);
		add(pricePanel);
		pricePanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uB300\uC5EC \uB2E8\uAC00 \uAD00\uB9AC  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pricePanel.setLayout(null);
		
		ComboBoxComponent priceCodePanel = new ComboBoxComponent("차 코드");
		priceCodePanel.setBounds(5, 28, 230, 30);
		pricePanel.add(priceCodePanel);
		
		TextFieldComponent basicPricePanel = new TextFieldComponent("기본가격");
		basicPricePanel.setBounds(5, 68, 230, 30);
		pricePanel.add(basicPricePanel);
		
		TextFieldComponent useTimePanel = new TextFieldComponent("사용시간");
		useTimePanel.setBounds(5, 108, 230, 30);
		pricePanel.add(useTimePanel);
		
		TextFieldComponent basicTimePricePanel = new TextFieldComponent("기본시간단가");
		basicTimePricePanel.setBounds(247, 68, 230, 30);
		pricePanel.add(basicTimePricePanel);
		
		TextFieldComponent exceedTimePricePanel = new TextFieldComponent("초과시간단가");
		exceedTimePricePanel.setBounds(247, 108, 230, 30);
		pricePanel.add(exceedTimePricePanel);
		
		TextFieldComponent insurancePanel = new TextFieldComponent("보험료");
		insurancePanel.setBounds(247, 28, 230, 30);
		pricePanel.add(insurancePanel);
		
		JButton btnAddp = new JButton("추가");
		btnAddp.setBounds(503, 15, 66, 23);
		pricePanel.add(btnAddp);
		
		JButton btnUpdatep = new JButton("수정");
		btnUpdatep.setBounds(503, 40, 66, 23);
		pricePanel.add(btnUpdatep);
		
		JButton btnDeletep = new JButton("삭제");
		btnDeletep.setBounds(503, 65, 66, 23);
		pricePanel.add(btnDeletep);
		
		JButton btnCancelp = new JButton("취소");
		btnCancelp.setBounds(503, 131, 66, 23);
		pricePanel.add(btnCancelp);
		
		JPanel oliPanel = new JPanel();
		oliPanel.setBounds(621, 163, 341, 164);
		add(oliPanel);
		oliPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC5F0\uB8CC\uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		oliPanel.setLayout(null);
		
		TextFieldComponent oliCodePanel = new TextFieldComponent("연료 코드");
		oliCodePanel.setBounds(5, 30, 230, 30);
		oliPanel.add(oliCodePanel);
		
		TextFieldComponent oliTypePanel = new TextFieldComponent("연료 타입");
		oliTypePanel.setBounds(5, 80, 230, 30);
		oliPanel.add(oliTypePanel);
		
		JButton btnAddo = new JButton("추가");
		btnAddo.setBounds(247, 15, 66, 23);
		oliPanel.add(btnAddo);
		
		JButton btnUpdateo = new JButton("수정");
		btnUpdateo.setBounds(247, 40, 66, 23);
		oliPanel.add(btnUpdateo);
		
		JButton btnDeleteo = new JButton("삭제");
		btnDeleteo.setBounds(247, 65, 66, 23);
		oliPanel.add(btnDeleteo);
		
		JButton btnCancelo = new JButton("취소");
		btnCancelo.setBounds(247, 131, 66, 23);
		oliPanel.add(btnCancelo);
		
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
