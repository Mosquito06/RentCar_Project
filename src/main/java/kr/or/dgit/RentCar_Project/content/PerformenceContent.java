package kr.or.dgit.RentCar_Project.content;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import kr.or.dgit.RentCar_Project.component.RadioComboBoxComponent;

public class PerformenceContent extends JPanel {

	private JButton btnSearch;
	private JButton btnReset;
	private ButtonGroup group;

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public PerformenceContent() {
		setLayout(null);

		RadioComboBoxComponent carModelBox = new RadioComboBoxComponent("차종");
		Vector<String> list = new Vector<>();
		list.add("소형");
		list.add("중형");

		carModelBox.setComboBoxModel(list);
		carModelBox.setBounds(1, 100, 349, 35);
		add(carModelBox);

		RadioComboBoxComponent carNameCBox = new RadioComboBoxComponent("차종명");
		carNameCBox.setBounds(1, 145, 349, 35);
		add(carNameCBox);

		RadioComboBoxComponent monthBox = new RadioComboBoxComponent("월별");
		monthBox.setBounds(1, 10, 349, 35);
		add(monthBox);

		RadioComboBoxComponent madeBox = new RadioComboBoxComponent("제조사");
		madeBox.setBounds(1, 190, 349, 35);
		add(madeBox);

		RadioComboBoxComponent genderBox = new RadioComboBoxComponent("성별");
		genderBox.setBounds(1, 55, 349, 35);
		add(genderBox);

		RadioComboBoxComponent fuelBox = new RadioComboBoxComponent("연료별");
		fuelBox.setBounds(1, 235, 349, 35);
		add(fuelBox);

		btnSearch = new JButton("검색");
		btnSearch.setBounds(33, 290, 140, 39);
		add(btnSearch);

		btnReset = new JButton("초기화");
		btnReset.setBounds(185, 290, 140, 39);
		add(btnReset);

		group = new ButtonGroup();
		group.add(carModelBox.getRadioButton());
		group.add(carNameCBox.getRadioButton());
		group.add(monthBox.getRadioButton());
		group.add(madeBox.getRadioButton());
		group.add(genderBox.getRadioButton());
		group.add(fuelBox.getRadioButton());
	}

	public JComboBox selectGetComboBox() {
		Enumeration<AbstractButton> selectObject = group.getElements();
		while (selectObject.hasMoreElements()) {
			JRadioButton jb = (JRadioButton) selectObject.nextElement();
			if (jb.isSelected()) {
				Object[] content = jb.getParent().getComponents();
				for (int i = 0; i < content.length; i++) {
					if (content[i] instanceof JComboBox) {
						return (JComboBox) content[i];
					}
				}
			}
		}
		return null;
	}

}
