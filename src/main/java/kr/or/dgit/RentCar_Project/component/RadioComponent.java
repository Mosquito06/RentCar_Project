package kr.or.dgit.RentCar_Project.component;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RadioComponent extends JPanel {
	private JRadioButton rdbtnLeft;
	private JRadioButton rdbtnRight;

	public RadioComponent(String srt,String srt1,String srt2) {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lbl = new JLabel(srt);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		rdbtnLeft = new JRadioButton(srt1);
		rdbtnLeft.setSelected(true);
		rdbtnLeft.setHorizontalAlignment(SwingConstants.CENTER);
		add(rdbtnLeft);
		
		rdbtnRight = new JRadioButton(srt2);
		rdbtnRight.setHorizontalAlignment(SwingConstants.CENTER);
		add(rdbtnRight);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnLeft);
		group.add(rdbtnRight);
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

	
	
	
	
	

}
