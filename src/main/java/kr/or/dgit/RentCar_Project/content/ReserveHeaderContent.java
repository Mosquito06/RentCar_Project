package kr.or.dgit.RentCar_Project.content;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.frame.CalendarFrame;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ReserveHeaderContent extends JPanel {

	private String startDay;
	private String lastDay;
	private String startTime;
	private String lastTime;
	private JComboBox<String> startTimeCom;
	private JComboBox<String> finalTimeCom;
	private TextFieldComponent totalTimePanel;
	private CalendarFrame cf;
	private SimpleDateFormat simpleDate;
	private SimpleDateFormat simpleTime;
	private Date date;
	private String toDay;
	private String presentTime;
	private TextFieldComponent startPanel;
	private TextFieldComponent finalPanel;
	private JButton btnSearch;
	private Date date1;
	private Date date2;
	private Date date3;

	public TextFieldComponent getStartPanel() {
		return startPanel;
	}

	public TextFieldComponent getFinalPanel() {
		return finalPanel;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public TextFieldComponent getTotalTimePanel() {
		return totalTimePanel;
	}

	public ReserveHeaderContent() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		startPanel = new TextFieldComponent("대여일");
		startPanel.setBounds(22, 19, 203, 35);
		add(startPanel);
		startPanel.setFocusable(false);

		totalTimePanel = new TextFieldComponent("총  ");
		totalTimePanel.setBounds(642, 19, 122, 35);
		add(totalTimePanel);
		totalTimePanel.getTextField().setFocusable(false);
		totalTimePanel.getTextField().setText("0");

		JLabel lblNewLabel = new JLabel("시간");
		lblNewLabel.setBounds(765, 19, 68, 35);
		add(lblNewLabel);

		btnSearch = new JButton("전체검색");
		btnSearch.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\s.png"));

		btnSearch.setBounds(832, 15, 117, 41);
		add(btnSearch);

		finalPanel = new TextFieldComponent("반납일");
		finalPanel.setBounds(325, 19, 202, 35);
		add(finalPanel);
		finalPanel.setFocusable(false);

		String[] timeArr = { "시간선택", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00",
				"13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30",
				"19:00", "19:30", "20:00", "20:30", "21:00" };

		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(timeArr);
		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(timeArr);
		startTimeCom = new JComboBox<String>(model1);
		startTimeCom.setBounds(231, 19, 88, 35);
		add(startTimeCom);

		finalTimeCom = new JComboBox<String>(model2);
		finalTimeCom.setBounds(533, 19, 88, 35);
		add(finalTimeCom);

		simpleDate = new SimpleDateFormat("yyyy/MM/dd");
		simpleTime = new SimpleDateFormat("HH:mm");
		date = new Date();
		toDay = simpleDate.format(date);
		presentTime = simpleTime.format(date);

		tfSetting(startPanel, finalPanel);

		startPanel.getTextField().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewCalender(startPanel);

			}
		});

		startPanel.getTextField().getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				comparestartPanel(startPanel);

			}

			public void changedUpdate(DocumentEvent e) {

			}
		});

		finalPanel.getTextField().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewCalender(finalPanel);

			}
		});

		finalPanel.getTextField().getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				compareFinalPanel(finalPanel);

			}

			public void changedUpdate(DocumentEvent e) {
			}
		});

		startTimeCom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (startTimeCom.getSelectedIndex() == 0) {
					totalTimePanel.getTextField().setText("0");
					return;
				}
				compareToDayTime(startTimeCom);

			}
		});

		finalTimeCom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (finalTimeCom.getSelectedIndex() == 0) {
					totalTimePanel.getTextField().setText("0");
					return;
				}
				setTotalTime();
			}
		});

	}

	private void viewCalender(TextFieldComponent TfPanel) {
		cf = new CalendarFrame(TfPanel.getTextField());
		cf.setVisible(true);
	}

	private void tfSetting(TextFieldComponent startPanel, TextFieldComponent finalPanel) {
		startPanel.getTextField().setFocusable(false);
		finalPanel.getTextField().setFocusable(false);

		startPanel.getTextField().setText(toDay);
		finalPanel.getTextField().setText("날짜선택");

		startDay = toDay;
		startTime = presentTime;
		lastDay = toDay;
		lastTime = presentTime;

		date1 = simpleDate.parse(toDay, new ParsePosition(0));
		date2 = simpleDate.parse(startPanel.getTextField().getText(), new ParsePosition(0));

	}

	private void comparestartPanel(TextFieldComponent startPanel) {
		date1 = simpleDate.parse(toDay, new ParsePosition(0));
		date2 = simpleDate.parse(startPanel.getTextField().getText(), new ParsePosition(0));

		if (date1.getTime() > date2.getTime()) {
			JOptionPane.showMessageDialog(null, toDay + " 이후로 선택하세요");
			viewCalender(startPanel);
			return;
		}
		startTimeCom.setSelectedIndex(0);
		finalPanel.getTextField().setText("날짜선택");
		finalTimeCom.setSelectedIndex(0);
		startDay = startPanel.getTextField().getText();

	}

	private void compareFinalPanel(TextFieldComponent finalPanel) {
		date3 = simpleDate.parse(finalPanel.getTextField().getText(), new ParsePosition(0));
		date2 = simpleDate.parse(startPanel.getTextField().getText(), new ParsePosition(0));

		if (finalPanel.getTextField().getText().equals("날짜선택")) {
			return;
		}
		if (date2.getTime() > date3.getTime()) {
			JOptionPane.showMessageDialog(null, "반납일이 대여일보다 뒤여야 합니다");
			viewCalender(finalPanel);
			return;
		}

		lastDay = finalPanel.getTextField().getText();
		finalTimeCom.setSelectedIndex(0);

	}

	private void compareToDayTime(JComboBox<String> startTimeCom) {
		Date time1 = simpleTime.parse(presentTime, new ParsePosition(0));
		Date time2 = simpleTime.parse((String) startTimeCom.getSelectedItem(), new ParsePosition(0));

		if (startTimeCom.getSelectedItem().equals("시간선택")) {
			return;
		}
		if (date1.getTime() == date2.getTime()) {
			if (time1.getTime() > time2.getTime()) {
				JOptionPane.showMessageDialog(null, presentTime + " 이후로 선택하세요");
				startTimeCom.setSelectedIndex(0);
				return;
			}
		}
		startTime = startTimeCom.getSelectedItem().toString();
		finalPanel.getTextField().setText("날짜선택");
		finalTimeCom.setSelectedIndex(0);
	}

	private void setTotalTime() {
		startTime = startTimeCom.getSelectedItem().toString();
		lastTime = finalTimeCom.getSelectedItem().toString();

		if (startTime.equals("시간선택")) {
			totalTimePanel.getTextField().setText("0");
			return;
		}

		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date sDay = sf.parse(startDay + " " + startTime, new ParsePosition(0));
		long sTime = sDay.getTime();

		Date fDate = sf.parse(lastDay + " " + lastTime, new ParsePosition(0));
		long fTime = fDate.getTime();
		long mills = fTime - sTime;
		long hour = mills / 3600000;

		if (fTime <= sTime) {
			JOptionPane.showMessageDialog(null, "반납일이 대여일보다 뒤여야 합니다");
			totalTimePanel.getTextField().setText("0");
			finalPanel.getTextField().setText("날짜선택");
			finalTimeCom.setSelectedIndex(0);
			viewCalender(finalPanel);
			return;
		}

		totalTimePanel.getTextField().setText(String.valueOf(hour));

	}
}