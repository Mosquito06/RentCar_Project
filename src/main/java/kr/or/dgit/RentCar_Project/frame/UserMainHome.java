package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import kr.or.dgit.RentCar_Project.dao.UserDao;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.UserService;

public class UserMainHome extends JPanel {
	private User ComfirmUser;
	
	public void setComfirmUser(User comfirmUser) {
		this.ComfirmUser = comfirmUser;
	}
	
	

	public UserMainHome() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(91, 341, 217, 305);
		add(panel);
		panel.setLayout(null);

		JButton btnRent = new JButton("대여하기");
		btnRent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				UserMainReserve userMainReserve = new UserMainReserve();
				userMainReserve.setComfirmUser(ComfirmUser);
				frame.getContentPane().add(userMainReserve, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});

		btnRent.setBounds(12, 20, 193, 44);
		panel.add(btnRent);

		JButton btnHistroy = new JButton("이용내역");
		btnHistroy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				UserMainHistory userMainHistory = new UserMainHistory(ComfirmUser);
				frame.getContentPane().add(userMainHistory, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		btnHistroy.setBounds(12, 94, 193, 44);
		panel.add(btnHistroy);

		// 내 정보 수정 리스너
		JButton btnUpdate = new JButton("내 정보 수정");
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 비밀번호 재확인
				JPasswordField pwdField;
				String ComfirmPw = null;
				UserDao userDao = UserService.getInstance();
				List<User> list = userDao.selectUserByAll();
						
				for(User u : list) {
					if(u.getId().equals(ComfirmUser.getId())) {
						ComfirmPw = u.getPw();
						ComfirmUser = u;
						break;
					}
				}
				
				do {
					pwdField = new JPasswordField();
					if(JOptionPane.showConfirmDialog(null, pwdField, "비밀번호를 입력해주세요.", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
						if(pwdField.getText().equals(ComfirmPw)) {
							JFrame frame = UserMain.getInstance();
							frame.getContentPane().removeAll();
							UserMainUpdate userMainUpdate = new UserMainUpdate(ComfirmUser);
							frame.getContentPane().add(userMainUpdate, BorderLayout.CENTER);
							frame.setVisible(true);
							break;
						}else {
							JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
						}
					}else{
						break;
					}
				} while (pwdField == null || !pwdField.equals(ComfirmPw));
			}
		});
		btnUpdate.setBounds(12, 171, 193, 44);
		panel.add(btnUpdate);

		// 나가기 버튼 리스너
		JButton btnOut = new JButton("나가기");
		btnOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?");
				if (confirm == 0) {
					UserMain.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					UserMain.getInstance().setVisible(false);
				}
			}
		});
		btnOut.setBounds(12, 244, 193, 44);
		panel.add(btnOut);

		JLabel backImg = new JLabel("");
		backImg.setBounds(0, 0, 974, 751);
		backImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\jeepBack2.jpg"));
		add(backImg);

	}
}
