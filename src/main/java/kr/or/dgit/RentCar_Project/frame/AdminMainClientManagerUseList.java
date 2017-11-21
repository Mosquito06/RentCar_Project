package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.UserService;

@SuppressWarnings("serial")
public class AdminMainClientManagerUseList extends JPanel {
	
	public AdminMainClientManagerUseList() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC774\uC6A9 \uB0B4\uC5ED ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(28, 26, 923, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel useListPanel = new JPanel();
		useListPanel.setBounds(22, 112, 878, 528);
		panel.add(useListPanel);
		useListPanel.setLayout(new BorderLayout(5, 5));
		
		JPanel listPanel = new JPanel();
		useListPanel.add(listPanel, BorderLayout.CENTER);
		
		JPanel numPanel = new JPanel();
		useListPanel.add(numPanel, BorderLayout.SOUTH);
		numPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNum = new JLabel("total:");
		numPanel.add(lblNum, BorderLayout.CENTER);
		lblNum.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel emptyPanel = new JPanel();
		numPanel.add(emptyPanel, BorderLayout.EAST);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainClientManager(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(803, 656, 97, 33);
		panel.add(btnBack);
		setSearchComboBoxModel();
	}
	
	public void setSearchComboBoxModel() {
		UserService userService = UserService.getInstance();
		List<User> lists = userService.selectUserByAll();
		Vector<User> userCode = new Vector<>();
		for(User u:lists) {
			u.setComboType(0);
			userCode.add(u);
		}
	}
}
