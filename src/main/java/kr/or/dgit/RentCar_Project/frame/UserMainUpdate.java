package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.UpdateContent;
import kr.or.dgit.RentCar_Project.content.UpdateProfileContent;
import kr.or.dgit.RentCar_Project.content.UpdatePwContent;

@SuppressWarnings("serial")
public class UserMainUpdate extends JPanel {

	private JLabel userImg;
	private JPanel labelPanel;

	public UserMainUpdate() {
		setLayout(null);

		JPanel upPanel = new JPanel();
		upPanel.setBounds(0, 0, 974, 363);
		add(upPanel);
		upPanel.setLayout(null);
		
		labelPanel = new JPanel();
		labelPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD504\uB85C\uD544", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		labelPanel.setBounds(0, 10, 428, 350);
		upPanel.add(labelPanel);
		labelPanel.setLayout(null);
		
		userImg = new JLabel("");
		userImg.setBounds(72, 10, 327, 337);
		labelPanel.add(userImg);
		userImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\userBig\\user6.png"));
		
		UpdateProfileContent imgPanel = new UpdateProfileContent();
		imgPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC774\uBBF8\uC9C0 \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		imgPanel.setBounds(431, 10, 540, 350);
		upPanel.add(imgPanel);
		imgPanel.setLayout(null);
		
		// 이미지 수정하기 버튼 리스너
		imgPanel.getBtnUpdate().addActionListener(new ActionListener() {
			
			private String selectString;

			@Override
			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> selectObject = imgPanel.getGroup().getElements();
				while(selectObject.hasMoreElements()) {
					JRadioButton jb = (JRadioButton) selectObject.nextElement();
					if(jb.isSelected()) {
						selectString = jb.getText();
					}
				}
				JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
				
				labelPanel.removeAll();
				userImg = new JLabel("");
				userImg.setBounds(72, 10, 327, 337);
				labelPanel.add(userImg);
				userImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\userBig\\" + selectString + ".png"));
			}
		});
		
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
		
		// 나가기 버튼 리스너
		updatepwcontent.getBtnExit().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new UserMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		
	}
}
