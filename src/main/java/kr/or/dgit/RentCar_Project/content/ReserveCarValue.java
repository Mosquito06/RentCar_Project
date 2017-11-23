package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.component.VTextFieldComponent;

@SuppressWarnings("serial")
public class ReserveCarValue extends JPanel {

	
	public ReserveCarValue(String name, String img,String old, String seater, String auto, String fuel) {
		setLayout(new BorderLayout(0, 0));
		JLabel carImg = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\car\\" + img));
		carImg.setHorizontalAlignment(SwingConstants.CENTER);
		add(carImg);

		JPanel carValue = new JPanel();
		add(carValue, BorderLayout.SOUTH);

		VTextFieldComponent carOldTf = new VTextFieldComponent("연식");
		carOldTf.getTextField().setText(old);
		carValue.add(carOldTf);

		VTextFieldComponent fuelTf = new VTextFieldComponent("연료종류");
		fuelTf.getTextField().setText(fuel);
		carValue.add(fuelTf);

		VTextFieldComponent seaterTf = new VTextFieldComponent("인승");
		seaterTf.getTextField().setText(seater);
		carValue.add(seaterTf);

		VTextFieldComponent autoTf = new VTextFieldComponent("오토유무");
		autoTf.getTextField().setText(auto);
		carValue.add(autoTf);
		
		JPanel carNamePanel = new JPanel();
		add(carNamePanel, BorderLayout.NORTH);
		carNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel carNameLbl = new JLabel(name);
		carNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		carNameLbl.setFont(new Font("굴림", Font.BOLD, 17));
		carNamePanel.add(carNameLbl);
	}

}
