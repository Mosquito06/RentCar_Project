package kr.or.dgit.RentCar_Project.content;

import javax.swing.JButton;
import javax.swing.JPanel;



public class performenceContent extends JPanel {

	public performenceContent() {
		setLayout(null);
		
		comboBoxComponent carModelBox = new comboBoxComponent("차종");
		carModelBox.setBounds(0, 35, 349, 35);
		add(carModelBox);
		
		comboBoxComponent carNameCBox = new comboBoxComponent("차종명");
		carNameCBox.setBounds(0, 202, 349, 35);
		add(carNameCBox);
				
		comboBoxComponent monthBox = new comboBoxComponent("월별");
		monthBox.setBounds(0, 91, 349, 35);
		add(monthBox);
		
		comboBoxComponent madeBox = new comboBoxComponent("제조사");
		madeBox.setBounds(0, 146, 349, 35);
		add(madeBox);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(32, 276, 140, 39);
		add(btnSearch);
		
		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(184, 276, 140, 39);
		add(btnReset);
		
	}
}
