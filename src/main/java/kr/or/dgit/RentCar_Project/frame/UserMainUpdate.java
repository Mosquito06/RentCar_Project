package kr.or.dgit.RentCar_Project.frame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.UpdateContent;
import kr.or.dgit.RentCar_Project.content.UpdateProfileContent;
import kr.or.dgit.RentCar_Project.content.UpdatePwContent;

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
		
		UpdateProfileContent imgPanel = new UpdateProfileContent();
		imgPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC774\uBBF8\uC9C0 \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		imgPanel.setBounds(431, 10, 540, 350);
		upPanel.add(imgPanel);
		imgPanel.setLayout(null);
		

		JLabel userImg = new JLabel("");
		userImg.setBounds(63, 10, 327, 337);
		labelPanel.add(userImg);
		userImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\userBig\\user6.png"));
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(1, 373, 971, 377);
		add(bottomPanel);
		bottomPanel.setLayout(null);
		
		UpdateContent updatecontent = new UpdateContent();
		updatecontent.setBounds(0, 0, 477, 377);
		bottomPanel.add(updatecontent);
		updatecontent.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAE30\uBCF8\uC815\uBCF4 \uC218\uC815", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		UpdatePwContent updatepwcontent = new UpdatePwContent();
		updatepwcontent.setBorder(new TitledBorder(null, "\uBE44\uBC00\uBC88\uD638 \uC218\uC815", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		updatepwcontent.setBounds(483, 0, 488, 232);
		bottomPanel.add(updatepwcontent);
	}
}
