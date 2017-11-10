package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.UpdateContent;
import kr.or.dgit.RentCar_Project.content.UpdateProfileContent;
import kr.or.dgit.RentCar_Project.content.UpdatePwContent;
import kr.or.dgit.RentCar_Project.dao.UserDao;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.UserService;

@SuppressWarnings("serial")
public class UserMainUpdate extends JPanel {
	private JLabel userImg;
	private JPanel labelPanel;
	private User ComfirmUser;
	
	public void setComfirmUser(User comfirmUser) {
		ComfirmUser = comfirmUser;
	}
	
	public UserMainUpdate(User ComfirmUser) {
		setLayout(null);
		JPanel upPanel = new JPanel();
		upPanel.setBounds(0, 0, 974, 363);
		add(upPanel);
		upPanel.setLayout(null);
		
		labelPanel = new JPanel();
		labelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uD504\uB85C\uD544", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		labelPanel.setBounds(0, 10, 428, 350);
		upPanel.add(labelPanel);
		labelPanel.setLayout(null);
		
		
		// 해당 유저의 프로필 이미지 가져오기
		userImg = new JLabel("");
		userImg.setBounds(72, 10, 327, 337);
		labelPanel.add(userImg);
		userImg.setIcon(new ImageIcon(ComfirmUser.getUserImg()));
		
		UpdateProfileContent imgPanel = new UpdateProfileContent();
		imgPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uC774\uBBF8\uC9C0 \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		imgPanel.setBounds(431, 10, 540, 350);
		upPanel.add(imgPanel);
		imgPanel.setLayout(null);
		
		// 이미지 수정하기 버튼 리스너
		imgPanel.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectString = imgPanel.getSelectRadioText();
				if(selectString != null) {
					labelPanel.removeAll();
					userImg = new JLabel("");
					userImg.setBounds(72, 10, 327, 337);
					labelPanel.add(userImg);
					userImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\userBig\\" + selectString + ".png"));
					ComfirmUser.setUserImg(getImage(selectString));
					UserService.getInstance().updateUser(ComfirmUser);
					JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
				}
			}

			private byte[] getImage(String imgName) {
				byte[] img = null;
				File file = new File(System.getProperty("user.dir") + "\\images\\userBig\\" + imgName + ".png");
				try {
					InputStream is = new FileInputStream(file);
					img = new byte[is.available()];
					is.read(img);
					is.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return img;
			}
		});
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(1, 373, 971, 377);
		add(bottomPanel);
		bottomPanel.setLayout(null);
		
		UpdateContent updatecontent = new UpdateContent();
		updatecontent.setBounds(0, 0, 477, 377);
		bottomPanel.add(updatecontent);
		updatecontent.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uAE30\uBCF8\uC815\uBCF4 \uC218\uC815", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		UpdatePwContent updatepwcontent = new UpdatePwContent();
		updatepwcontent.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uBE44\uBC00\uBC88\uD638 \uC218\uC815", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		updatepwcontent.setBounds(483, 0, 488, 232);
		bottomPanel.add(updatepwcontent);
		
		updatepwcontent.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String changePw = updatepwcontent.getContent();
				
				if(changePw == null) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하도록 입력해주세요");
					return;
				}else {
					ComfirmUser.setPw(changePw);
					UserService.getInstance().updateUser(ComfirmUser);
					JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
					updatepwcontent.clear();
				}
			}
		});
				
		// 나가기 버튼 리스너
		updatepwcontent.getBtnExit().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				UserMainHome userMainHome = new UserMainHome();
				userMainHome.setComfirmUser(ComfirmUser);
				frame.getContentPane().add(userMainHome, BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		
	}

}
