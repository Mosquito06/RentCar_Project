package kr.or.dgit.RentCar_Project.frame;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.UpdateContent;
import java.awt.Color;
import javax.swing.JButton;

public class UserMainUpdate extends JPanel {

	public UserMainUpdate() {
		setLayout(null);

		JPanel upPanel = new JPanel();
		upPanel.setBounds(0, 0, 974, 363);
		add(upPanel);
		upPanel.setLayout(null);

		JPanel labelPanel = new JPanel();
		labelPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD504\uB85C\uD544", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		labelPanel.setBounds(0, 10, 428, 350);
		upPanel.add(labelPanel);
		labelPanel.setLayout(null);

		JLabel userImg = new JLabel("");
		userImg.setBounds(63, 10, 327, 337);
		labelPanel.add(userImg);
		userImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\user1.png"));
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(1, 373, 971, 377);
		add(bottomPanel);
				bottomPanel.setLayout(null);
		
				UpdateContent updatecontent = new UpdateContent();
				updatecontent.setBounds(0, 0, 428, 377);
				bottomPanel.add(updatecontent);
				updatecontent.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC815\uBCF4\uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaptionText));

	}
}
