package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import kr.or.dgit.RentCar_Project.component.VTextFieldComponent;
import javax.swing.border.EmptyBorder;

public class ReserveListCarValue extends JPanel {


	public ReserveListCarValue(String name, String img,String old, String seater, String auto, String fuel) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel carImg = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\carS\\" + img));
		panel_2.add(carImg);
		
		JPanel carValue = new JPanel();
		carValue.setBorder(new EmptyBorder(20, 30, 30, 30));
		panel_2.add(carValue);
		carValue.setLayout(new GridLayout(0, 2, 20, 20));
		
		VTextFieldComponent carOldTf = new VTextFieldComponent("연식");
		carOldTf.getTextField().setText(old);
		carValue.add(carOldTf);
		
		VTextFieldComponent fuelTf = new VTextFieldComponent("연료종류");
		fuelTf.getTextField().setText(fuel);
		carValue.add(fuelTf);
		
		VTextFieldComponent seaterTf = new VTextFieldComponent("인승");
		seaterTf.getTextField().setText(seater);
		carValue.add(seaterTf);
		
		VTextFieldComponent autoTf = new VTextFieldComponent("오토/수동");
		autoTf.getTextField().setText(auto);
		carValue.add(autoTf);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		
		JLabel carNameLbl = new JLabel(name);
		carNameLbl.setFont(new Font("굴림", Font.BOLD, 17));
		panel_1.add(carNameLbl);

	}

}
