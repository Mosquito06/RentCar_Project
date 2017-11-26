package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.dto.User;

public class UserMain extends JFrame {
	private static final UserMain instance = new UserMain();

	private JPanel contentPane;
	
	public static UserMain getInstance() {
		return instance;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	private UserMain() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(System.getProperty("user.dir") + "\\images\\Instapaper icon.png");
		setIconImage(img);
		
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

	}
	
	public void UserFrameSetTitle(User ComfirmUser) {
		setTitle("아이티 렌트카" + " - " + ComfirmUser.getUserName() + "님 환영합니다!");
	}
}
