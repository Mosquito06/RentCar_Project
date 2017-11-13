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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private UpdateContent updatecontent;
	
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
					updatecontent.setContent(ComfirmUser);
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
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
		
		// 기본정보 수정하기 리스너
		updatecontent = new UpdateContent();
		updatecontent.setContent(ComfirmUser);
		updatecontent.setBounds(0, 0, 477, 377);
		bottomPanel.add(updatecontent);
		updatecontent.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uAE30\uBCF8\uC815\uBCF4 \uC218\uC815", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		updatecontent.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!updatecontent.isEmptyCheck()) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요");
					return;
				}
								
				User UpdateUser = updatecontent.getContent();
				ComfirmUser.setUserName(UpdateUser.getUserName());
				ComfirmUser.setGender(UpdateUser.getGender());
				ComfirmUser.setEmail(UpdateUser.getEmail());
				ComfirmUser.setPhone(UpdateUser.getPhone());
				UserService.getInstance().updateUser(ComfirmUser);
				JOptionPane.showMessageDialog(null, "수정되었습니다");
			}
		});
		
		
		// 비밀번호 컨텐트 및 수정하기 버튼 리스너
		UpdatePwContent updatepwcontent = new UpdatePwContent();
		updatepwcontent.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uBE44\uBC00\uBC88\uD638 \uC218\uC815", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		updatepwcontent.setBounds(483, 0, 488, 232);
		bottomPanel.add(updatepwcontent);
		updatepwcontent.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!updatepwcontent.isEmptyCheck()) {
					JOptionPane.showMessageDialog(null, "자료를 모두 입력해주세요");
					return;
				}
								
				String changePw = updatepwcontent.getContent();
				String nowPw = updatepwcontent.getNowPwPanel().getTextValue();
				
				if(!nowPw.equals(ComfirmUser.getPw())){
					JOptionPane.showMessageDialog(null, "현재 비밀번호를 확인해주세요.");
					updatepwcontent.getNowPwPanel().requestFocus();
					return;
				}
				
				if(changePw == null) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하도록 입력해주세요.");
					updatepwcontent.getChangePwPanel().requestFocus();
					return;
				}
								
				Pattern p = Pattern.compile("(^[a-zA-Z0-9!@#$%^&*()]{9,15}$)");
				Matcher m = p.matcher(changePw);

				if (m.find()) {
					ComfirmUser.setPw(changePw);
					UserService.getInstance().updateUser(ComfirmUser);
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
					updatepwcontent.clear();
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호 양식에 맞게 입력해주세요");
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
