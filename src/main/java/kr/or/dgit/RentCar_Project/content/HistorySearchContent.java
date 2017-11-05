package kr.or.dgit.RentCar_Project.content;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.RentCar_Project.frame.CalendarFrame;

public class HistorySearchContent extends JPanel {
	private JTextField FirstDateField;
	private JTextField LastDateField;
	private JButton btnSearch;
	private JButton btnCancel;
	private JButton btnExit;

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public HistorySearchContent() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\search.png"));
		add(lblImg);

		// 첫 번째 날짜 텍스트 필드 리스너
		FirstDateField = new JTextField();
		FirstDateField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CalendarFrame cf = new CalendarFrame(FirstDateField);
				cf.setVisible(true);
			}
			
		});
		add(FirstDateField);
		FirstDateField.setColumns(10);

		JLabel lblText = new JLabel("~");
		add(lblText);

		// 두 번째 날짜 텍스트 필드 리스너
		LastDateField = new JTextField();
		LastDateField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CalendarFrame cf = new CalendarFrame(LastDateField);
				cf.setVisible(true);
			}
			
		});
		add(LastDateField);
		LastDateField.setColumns(10);

		btnSearch = new JButton("검색하기");
		add(btnSearch);

		btnCancel = new JButton("취소하기");
		add(btnCancel);

		btnExit = new JButton("나가기");
		add(btnExit);

	}
		
}
