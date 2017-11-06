package kr.or.dgit.RentCar_Project.content;

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
import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;

public class CarManagerContent extends JPanel {

	public CarManagerContent() {
		setBounds(0, 0, 974, 751);
		setLayout(null);
		
		JButton btnBack = new JButton("뒤로");
		btnBack.setBounds(865, 726, 97, 23);
		add(btnBack);
		
		JButton btnAllReset = new JButton("전체 초기화");
		btnAllReset.setBounds(756, 726, 97, 23);
		add(btnAllReset);
		
		JPanel carModelPanel = new JPanel();
		carModelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \u25C0 \uCC28\uC885 \uAD00\uB9AC \u25B6 ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		carModelPanel.setBounds(12, 10, 597, 143);
		add(carModelPanel);
		carModelPanel.setLayout(null);
		
		kr.or.dgit.RentCar_Project.component.TextFieldComponent carModelCodePanel = new kr.or.dgit.RentCar_Project.component.TextFieldComponent("차종 코드");
		carModelCodePanel.setBounds(5, 30, 230, 30);
		carModelPanel.add(carModelCodePanel);
		
		kr.or.dgit.RentCar_Project.component.TextFieldComponent carModelNamePanel = new kr.or.dgit.RentCar_Project.component.TextFieldComponent("차종");
		carModelNamePanel.setBounds(5, 80, 230, 30);
		carModelPanel.add(carModelNamePanel);
		
		JButton btnAddcm = new JButton("추가");
		btnAddcm.setBounds(247, 30, 71, 23);
		carModelPanel.add(btnAddcm);
		
		JButton btnDeletecm = new JButton("삭제");
		btnDeletecm.setBounds(247, 87, 71, 23);
		carModelPanel.add(btnDeletecm);
		
		JButton btnUpdatecm = new JButton("수정");
		btnUpdatecm.setBounds(247, 59, 71, 23);
		carModelPanel.add(btnUpdatecm);
		
		JButton btnCanclecm = new JButton("취소");
		btnCanclecm.setBounds(519, 110, 66, 23);
		carModelPanel.add(btnCanclecm);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(325, 10, 193, 123);
		carModelPanel.add(imgPanel);
		
		JPanel manufacturerPanel = new JPanel();
		manufacturerPanel.setBounds(621, 10, 341, 143);
		add(manufacturerPanel);
		manufacturerPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \u25C0 \uC81C\uC870\uD68C\uC0AC \u25B6 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		manufacturerPanel.setLayout(null);
		
		kr.or.dgit.RentCar_Project.component.TextFieldComponent companyCodePanel = new kr.or.dgit.RentCar_Project.component.TextFieldComponent("제조회사 코드");
		companyCodePanel.setBounds(5, 30, 230, 30);
		manufacturerPanel.add(companyCodePanel);
		
		kr.or.dgit.RentCar_Project.component.TextFieldComponent companyNamePanel = new kr.or.dgit.RentCar_Project.component.TextFieldComponent("제조사 이름");
		companyNamePanel.setBounds(5, 70, 230, 30);
		manufacturerPanel.add(companyNamePanel);
		
		JButton btnAddcp = new JButton("등록");
		btnAddcp.setBounds(247, 13, 66, 23);
		manufacturerPanel.add(btnAddcp);
		
		JButton btnUpdatecp = new JButton("수정");
		btnUpdatecp.setBounds(247, 44, 66, 23);
		manufacturerPanel.add(btnUpdatecp);
		
		JButton btnDeletecp = new JButton("삭제");
		btnDeletecp.setBounds(247, 77, 66, 23);
		manufacturerPanel.add(btnDeletecp);
		
		JButton btnCanclecp = new JButton("취소");
		btnCanclecp.setBounds(247, 110, 66, 23);
		manufacturerPanel.add(btnCanclecp);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(12, 163, 597, 167);
		add(pricePanel);
		pricePanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \u25C0 \uB300\uC5EC \uB2E8\uAC00 \uAD00\uB9AC \u25B6 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pricePanel.setLayout(null);
		
		ComboBoxComponent priceCodePanel = new ComboBoxComponent("차 코드");
		priceCodePanel.setBounds(5, 28, 230, 30);
		pricePanel.add(priceCodePanel);
		
		TextFieldComponent textFieldComponent_9 = new TextFieldComponent("기본가격");
		textFieldComponent_9.setBounds(5, 68, 230, 30);
		pricePanel.add(textFieldComponent_9);
		
		TextFieldComponent textFieldComponent_10 = new TextFieldComponent("사용시간");
		textFieldComponent_10.setBounds(5, 108, 230, 30);
		pricePanel.add(textFieldComponent_10);
		
		TextFieldComponent textFieldComponent_11 = new TextFieldComponent("기본시간단가");
		textFieldComponent_11.setBounds(247, 68, 230, 30);
		pricePanel.add(textFieldComponent_11);
		
		TextFieldComponent textFieldComponent_12 = new TextFieldComponent("초과시간단가");
		textFieldComponent_12.setBounds(247, 108, 230, 30);
		pricePanel.add(textFieldComponent_12);
		
		TextFieldComponent textFieldComponent_13 = new TextFieldComponent("보험료");
		textFieldComponent_13.setBounds(247, 28, 230, 30);
		pricePanel.add(textFieldComponent_13);
		
		JButton button_11 = new JButton("추가");
		button_11.setBounds(503, 28, 66, 23);
		pricePanel.add(button_11);
		
		JButton button_12 = new JButton("수정");
		button_12.setBounds(503, 61, 66, 23);
		pricePanel.add(button_12);
		
		JButton button_13 = new JButton("삭제");
		button_13.setBounds(503, 91, 66, 23);
		pricePanel.add(button_13);
		
		JButton button_14 = new JButton("취소");
		button_14.setBounds(503, 134, 66, 23);
		pricePanel.add(button_14);
		
		JPanel oliPanel = new JPanel();
		oliPanel.setBounds(621, 163, 341, 164);
		add(oliPanel);
		oliPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \u25C0 \uC5F0\uB8CC\uAD00\uB9AC \u25B6 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		oliPanel.setLayout(null);
		
		TextFieldComponent textFieldComponent_7 = new TextFieldComponent("연료 코드");
		textFieldComponent_7.setBounds(5, 30, 230, 30);
		oliPanel.add(textFieldComponent_7);
		
		TextFieldComponent textFieldComponent_8 = new TextFieldComponent("연료 타입");
		textFieldComponent_8.setBounds(5, 80, 230, 30);
		oliPanel.add(textFieldComponent_8);
		
		JButton button_3 = new JButton("등록");
		button_3.setBounds(247, 26, 66, 23);
		oliPanel.add(button_3);
		
		JButton button_4 = new JButton("수정");
		button_4.setBounds(247, 59, 66, 23);
		oliPanel.add(button_4);
		
		JButton button_5 = new JButton("삭제");
		button_5.setBounds(247, 87, 66, 23);
		oliPanel.add(button_5);
		
		JButton button_6 = new JButton("취소");
		button_6.setBounds(247, 131, 66, 23);
		oliPanel.add(button_6);
		
		JPanel carPanel = new JPanel();
		carPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \u25C0 \uCC28\uB7C9 \uAD00\uB9AC \u25B6 ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		carPanel.setBounds(12, 337, 950, 379);
		add(carPanel);
		carPanel.setLayout(null);
		
		TextFieldComponent panel_1 = new TextFieldComponent("차 코드");
		panel_1.setBounds(5, 20, 230, 30);
		carPanel.add(panel_1);
		
		TextFieldComponent textFieldComponent = new TextFieldComponent("차 이름");
		textFieldComponent.setBounds(5, 60, 230, 30);
		carPanel.add(textFieldComponent);
		
		TextFieldComponent textFieldComponent_1 = new TextFieldComponent("연식");
		textFieldComponent_1.setBounds(5, 100, 230, 30);
		carPanel.add(textFieldComponent_1);
		
		TextFieldComponent textFieldComponent_2 = new TextFieldComponent("인승");
		textFieldComponent_2.setBounds(5, 220, 230, 30);
		carPanel.add(textFieldComponent_2);
		
		RadioComponent panel = new RadioComponent("오토유무","yes", "no");
		panel.setBounds(15, 180, 255, 30);
		carPanel.add(panel);
		
		JspinnerComponent panel_2 = new JspinnerComponent("차량대수");
		panel_2.setBounds(5, 140, 230, 30);
		carPanel.add(panel_2);
		
		ComboBoxComponent panel_3 = new ComboBoxComponent("차종코드");
		panel_3.setBounds(5, 260, 230, 30);
		carPanel.add(panel_3);
		
		ComboBoxComponent comboBoxComponent = new ComboBoxComponent("제조회사코드");
		comboBoxComponent.setBounds(5, 300, 230, 30);
		carPanel.add(comboBoxComponent);
		
		ComboBoxComponent comboBoxComponent_1 = new ComboBoxComponent("연료코드");
		comboBoxComponent_1.setBounds(5, 339, 230, 30);
		carPanel.add(comboBoxComponent_1);
		
		JButton button_16 = new JButton("검색");
		button_16.setBounds(636, 20, 66, 23);
		carPanel.add(button_16);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(275, 53, 415, 278);
		carPanel.add(panel_10);
		
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
	}
}
