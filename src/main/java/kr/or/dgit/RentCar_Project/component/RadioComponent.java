package kr.or.dgit.RentCar_Project.component;

import java.awt.GridLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RadioComponent extends JPanel {
	private JRadioButton rdbtnLeft;
	private JRadioButton rdbtnRight;
	private ButtonGroup group;

	public RadioComponent(String Title, String FirstRadioName, String LastRadioName) {
		setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lbl = new JLabel(Title);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);

		rdbtnLeft = new JRadioButton(FirstRadioName);
		rdbtnLeft.setSelected(true);
		rdbtnLeft.setHorizontalAlignment(SwingConstants.CENTER);
		add(rdbtnLeft);

		rdbtnRight = new JRadioButton(LastRadioName);
		rdbtnRight.setHorizontalAlignment(SwingConstants.CENTER);
		add(rdbtnRight);

		group = new ButtonGroup();
		group.add(rdbtnLeft);
		group.add(rdbtnRight);
		
	}
	
	
	
	public ButtonGroup getGroup() {
		return group;
	}



	public JRadioButton getRdbtnLeft() {
		return rdbtnLeft;
	}

	public void setRdbtnLeft(JRadioButton rdbtnLeft) {
		this.rdbtnLeft = rdbtnLeft;
	}

	public JRadioButton getRdbtnRight() {
		return rdbtnRight;
	}

	public void setRdbtnRight(JRadioButton rdbtnRight) {
		this.rdbtnRight = rdbtnRight;
	}

	public String getSelectText() {
		Enumeration<AbstractButton> button = group.getElements();
		while (button.hasMoreElements()) {
			JRadioButton jb = (JRadioButton) button.nextElement();
			if (jb.isSelected()) {
				return jb.getText();
			}
		}
		return null;
	}
	
	public void setSelect(boolean selected) {
		if(selected) {
			rdbtnLeft.setSelected(true);
			rdbtnRight.setSelected(false);
		}else {
			rdbtnRight.setSelected(true);
			rdbtnLeft.setSelected(false);
		}
	}
	
	public void setAllEnable(boolean selected) {
			rdbtnLeft.setEnabled(selected);
			rdbtnRight.setEnabled(selected);
	
	}

}
