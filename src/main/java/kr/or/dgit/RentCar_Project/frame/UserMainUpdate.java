package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import kr.or.dgit.RentCar_Project.content.UpdateContent;
import kr.or.dgit.RentCar_Project.list.AbstractTable;
import kr.or.dgit.RentCar_Project.list.UserUpdateTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class UserMainUpdate extends JPanel {
	private JTextField firstDateField;
	private JTextField lastDateField;

	public UserMainUpdate() {
		setLayout(null);

		JPanel upPanel = new JPanel();
		upPanel.setBounds(0, 0, 974, 360);
		add(upPanel);
		upPanel.setLayout(null);

		JPanel labelPanel = new JPanel();
		labelPanel.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		labelPanel.setBounds(0, 10, 399, 350);
		upPanel.add(labelPanel);
		labelPanel.setLayout(null);

		JLabel userImg = new JLabel("");
		userImg.setBounds(64, 1, 298, 348);
		labelPanel.add(userImg);
		userImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\user1.png"));

		UpdateContent updatecontent = new UpdateContent();
		updatecontent.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC815\uBCF4\uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.activeCaptionText));
		updatecontent.setBounds(405, 10, 569, 350);
		upPanel.add(updatecontent);

		JPanel bottonPanel = new JPanel();
		bottonPanel.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		bottonPanel.setBounds(0, 367, 974, 384);
		add(bottonPanel);
		bottonPanel.setLayout(new BorderLayout(0, 0));

		JPanel btnPanel = new JPanel();
		bottonPanel.add(btnPanel, BorderLayout.NORTH);

		AbstractTable userUpdateTable = new UserUpdateTable();
		userUpdateTable.loadDate();
		bottonPanel.add(userUpdateTable, BorderLayout.CENTER);
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel searchImg = new JLabel("");
		searchImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\search.png"));
		btnPanel.add(searchImg);

		firstDateField = new JTextField();
		firstDateField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CalendarFrame frame = new CalendarFrame(firstDateField);
				frame.setVisible(true);
			}
		
		
		});
		
		btnPanel.add(firstDateField);
		firstDateField.setColumns(10);

		JLabel lblMiddle = new JLabel("~");
		btnPanel.add(lblMiddle);

		lastDateField = new JTextField();
		btnPanel.add(lastDateField);
		lastDateField.setColumns(10);

		JButton btnSerch = new JButton("검색하기");
		btnPanel.add(btnSerch);

		JButton btnUpdate = new JButton("수정하기");
		btnPanel.add(btnUpdate);

		JButton btnExit = new JButton("나가기");
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new UserMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);

			}
		});
		btnPanel.add(btnExit);

	}
}
