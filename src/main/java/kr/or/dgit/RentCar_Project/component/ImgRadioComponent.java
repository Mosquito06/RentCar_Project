package kr.or.dgit.RentCar_Project.component;

import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ImgRadioComponent extends JPanel {
	private AbstractButton ridioButton;

	public ImgRadioComponent(String imgName) {
		setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\userSmall\\" + imgName + ".png"));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);

		ridioButton = new JRadioButton(imgName);
		ridioButton.setSelected(true);
		ridioButton.setHorizontalAlignment(SwingConstants.CENTER);
		add(ridioButton);

	}

	public AbstractButton getRidioButton() {
		return ridioButton;
	}

}
