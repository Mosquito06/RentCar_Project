package kr.or.dgit.RentCar_Project.content;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.RentCar_Project.frame.CalendarFrame;

public class HistorySearchContent extends JPanel {
	private JTextField FirstDateField;
	private JTextField LastDateField;
	private JButton btnSearch;
	private JButton btnCancel;
	private JButton btnExit;
	private SimpleDateFormat simpleDate;
	private Date date;
	private String toDay;
	private String startDay;
	private String finalDay;
	
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
		FirstDateField.setFocusable(false);
		FirstDateField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				viewCalendar(FirstDateField);
			}
		});
		
		FirstDateField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				FirstDateField.setFocusable(false);
				setDayTime(FirstDateField, LastDateField);
				
				
			}
		});
		
		add(FirstDateField);
		FirstDateField.setColumns(10);

		JLabel lblText = new JLabel("~");
		add(lblText);

		// 두 번째 날짜 텍스트 필드 리스너
		LastDateField = new JTextField();
		LastDateField.setFocusable(false);
		LastDateField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				viewCalendar(LastDateField);
			}
			
		});
		
		LastDateField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("Sdf");
				LastDateField.setFocusable(false);
				setDayTime(FirstDateField, LastDateField);
				
				
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
		
		
		
		simpleDate = new SimpleDateFormat("yyyy/MM/dd");
		
		date = new Date();
		toDay = simpleDate.format(date);
		

		tfSetting(FirstDateField,LastDateField);

	}

	protected void setDayTime(JTextField firstDate, JTextField lastDate) {
		Date Fdate = simpleDate.parse(firstDate.getText(), new ParsePosition(0));
		Date Ldate = simpleDate.parse(lastDate.getText(), new ParsePosition(0));

	
		if (Fdate.getTime() > Ldate.getTime()) {
			JOptionPane.showMessageDialog(null,"반납일이 대여일보다 뒤여야 합니다");
			lastDate.setText("");
			return;
		} 
		
		
		
	}

	private void tfSetting(JTextField startTf, JTextField finalTf) {
		startTf.setText(toDay);
		finalTf.setText(toDay);

		startDay = toDay;
		finalDay = toDay;

	}

	private void viewCalendar(JTextField tf) {
		CalendarFrame cf = new CalendarFrame(tf);
		cf.setVisible(true);
		tf.setFocusable(true);
		tf.requestFocus();
	}
		
}
