package kr.or.dgit.RentCar_Project.content;

import java.awt.FlowLayout;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import kr.or.dgit.RentCar_Project.frame.CalendarFrame;

@SuppressWarnings("serial")
public class HistorySearchContent extends JPanel {
	private JTextField FirstDateField;
	private JTextField LastDateField;
	private JButton btnSearch;
	private JButton btnCancel;
	private JButton btnExit;
	private SimpleDateFormat simpleDate;
	private Date startDate;
	private Date lastDate;

	public JTextField getFirstDateField() {
		return FirstDateField;
	}

	public JTextField getLastDateField() {
		return LastDateField;
	}

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
		FirstDateField = new JTextField("0000/00/00");
		FirstDateField.setFocusable(false);
		FirstDateField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				viewCalendar(FirstDateField);
			}
		});

		FirstDateField.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				setDayTime(FirstDateField, LastDateField, FirstDateField);
			}

			public void changedUpdate(DocumentEvent e) {
			}
		});

		add(FirstDateField);
		FirstDateField.setColumns(10);

		JLabel lblText = new JLabel("~");
		add(lblText);

		// 두 번째 날짜 텍스트 필드 리스너
		LastDateField = new JTextField("9999/99/99");
		LastDateField.setFocusable(false);
		LastDateField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				viewCalendar(LastDateField);
			}

		});

		LastDateField.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				setDayTime(FirstDateField, LastDateField, LastDateField);

			}

			public void changedUpdate(DocumentEvent e) {
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

	private void setDayTime(JTextField firstTf, JTextField lastTf, JTextField tf) {
		simpleDate = new SimpleDateFormat("yyyy/MM/dd");
		startDate = simpleDate.parse(firstTf.getText(), new ParsePosition(0));
		lastDate = simpleDate.parse(lastTf.getText(), new ParsePosition(0));

		if (startDate.getTime() > lastDate.getTime()) {
			JOptionPane.showMessageDialog(null, "반납일이 대여일보다 뒤여야 합니다");
			viewCalendar(tf);
			return;
		}
	}

	private void viewCalendar(JTextField tf) {
		CalendarFrame cf = new CalendarFrame(tf);
		cf.setVisible(true);
	}

}
