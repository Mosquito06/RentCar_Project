package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.bitagentur.renderer.JChartLibPanel;

import kr.or.dgit.RentCar_Project.chart.AbstractBarChart;
import kr.or.dgit.RentCar_Project.chart.AbstractPieChart;
import kr.or.dgit.RentCar_Project.chart.PerformenceCarModelBarChart;
import kr.or.dgit.RentCar_Project.chart.PerformenceCarModelPieChart;
import kr.or.dgit.RentCar_Project.chart.PerformenceTotalBarChart;
import kr.or.dgit.RentCar_Project.chart.PerformenceTotalPieChart;
import kr.or.dgit.RentCar_Project.content.PerformenceContent;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.list.AdminPerformenceTable;
import kr.or.dgit.RentCar_Project.service.RentService;

@SuppressWarnings("serial")
public class AdminMainPerformence extends JPanel {
	private AdminMainPerformenceChart chartFrame;
	private AdminPerformenceTable adminTable;
	private JPanel chartPanel;
	private List<Rent> list;
	private AbstractPieChart<Rent> abstractPieChart;
	private AbstractBarChart<Rent> abstractBarChart;

	public AdminMainPerformence() {
		setLayout(null);

		list = RentService.getInstance().selectPerformenceTotalAndMonth(setThisYear(true), setThisYear(false), "RESERVATION");

		adminTable = new AdminPerformenceTable(list, 0);
		adminTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
				new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		adminTable.setBounds(8, 80, 587, 664);
		adminTable.loadDate();
		add(adminTable);

		JLabel personImg = new JLabel("");
		personImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\chart1.png"));
		personImg.setBounds(209, 6, 158, 71);
		add(personImg);

		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(
				new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
						new EtchedBorder(EtchedBorder.LOWERED, null, null)),
				"\uAC80\uC0C9\uC870\uAC74 \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		searchPanel.setBounds(601, 0, 373, 375);
		searchPanel.setLayout(null);
		add(searchPanel);

		// 검색조건 선택 패널 리스너
		PerformenceContent performenceContent = new PerformenceContent();
		performenceContent.getBtnSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// chartFrame null로 초기화
				chartFrame = null;

				try {
					Object[] item = performenceContent.selectGetObject();

					if (item[1].toString().indexOf("월별") > 0) {
						if (item[2] instanceof JComboBox) {
							Object selectItem = ((JComboBox) item[2]).getSelectedItem();
							if (selectItem.toString().length() == 2) {
								setMonthTableAndChart(selectItem, true, "RESERVATION");
							} else {
								setMonthTableAndChart(selectItem, false, "RESERVATION");
							}
						}
					} else if (item[1].toString().indexOf("성별") > 0) {
						if (item[2] instanceof JComboBox) {
							Object selectItem = ((JComboBox) item[2]).getSelectedItem();
							if (selectItem.equals("남자")) {
								setGenderTableAndChart("MALE");
							} else {
								setGenderTableAndChart("FEMALE");
							}
						}
					} else if (item[1].toString().indexOf("차종") > 0) {
						if (item[2] instanceof JComboBox) {
							Object selectItem = ((JComboBox) item[2]).getSelectedItem();
							setCarModelTableAndChart(selectItem.toString());
						}
					} else if (item[1].toString().indexOf("제조사") > 0) {
						if (item[2] instanceof JComboBox) {
							Object selectItem = ((JComboBox) item[2]).getSelectedItem();
							setManufacturerTableAndChart(selectItem.toString());
						}
					} else if (item[1].toString().indexOf("연료별") > 0) {
						if (item[2] instanceof JComboBox) {
							Object selectItem = ((JComboBox) item[2]).getSelectedItem();
							setFuelTableAndChart(selectItem.toString());
						}
					} else {
						if (item[2] instanceof JComboBox) {
							Object selectItem = ((JComboBox) item[2]).getSelectedItem();
							if (selectItem.toString().length() == 2) {
								setMonthTableAndChart(selectItem, true, "CANCELLATION");
							} else {
								setMonthTableAndChart(selectItem, false, "CANCELLATION");
							}
						}
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "검색 조건을 선택하세요.");
					return;
				}

				JOptionPane.showMessageDialog(null, "검색을 완료하였습니다.");
			}
		});
		performenceContent.setBounds(12, 22, 349, 354);
		searchPanel.add(performenceContent);

		// 프레임 생성 시 기본 파이 차트 출력
		abstractPieChart = new PerformenceTotalPieChart("성과분석", "", "", list, false);
		// 자세히 보기 출력을 위한 기본 바 차트 생성
		abstractBarChart = new PerformenceTotalBarChart("성과분석", "차종별", "최종요금", list);
		JChartLibPanel jChart = abstractPieChart.getPieChart();

		chartPanel = new JPanel();
		chartPanel.setLayout(new BorderLayout(0, 0));
		chartPanel.setBorder(new TitledBorder(
				new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
						new EtchedBorder(EtchedBorder.LOWERED, null, null)),
				"\uACB0\uACFC\uC694\uC57D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		chartPanel.setBounds(601, 374, 373, 333);
		chartPanel.add(jChart, BorderLayout.CENTER);
		add(chartPanel);

		JPanel chartBtnPanel = new JPanel();
		chartBtnPanel.setBounds(607, 705, 357, 48);
		add(chartBtnPanel);
		chartBtnPanel.setLayout(null);

		JButton btnSpecific = new JButton("자세히 보기");
		btnSpecific.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chartFrame == null) {
					chartFrame = new AdminMainPerformenceChart(list, abstractBarChart, "기본");
					chartFrame.setVisible(true);
				} else {
					chartFrame.setVisible(true);
				}
			}
		});
		btnSpecific.setBounds(9, 7, 163, 37);
		chartBtnPanel.add(btnSpecific);

		JButton btnExit = new JButton("나가기");
		btnExit.setBounds(185, 7, 163, 37);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);

			}
		});
		chartBtnPanel.add(btnExit);

	}

	// 1년 범위 날짜 설정
	private String setThisYear(boolean Choice) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date year = new Date();
		String setFirstMonth = dateFormat.format(year) + "01" + "01";
		String setLastMonth = dateFormat.format(year) + "12" + "31";

		if (Choice) {
			return setFirstMonth;
		} else {
			return setLastMonth;
		}
	}

	// 월별 검색 조건 메소드
	private void setMonthTableAndChart(Object selectItem, boolean setMonth, String setCancel) {
		// 현재 년도 가져오기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String CurrentYear = sdf.format(date);
		String Month = selectItem.toString().replaceAll("월", "");

		String setStart = null;
		String setEnd = null;

		if (setMonth) {
			setStart = CurrentYear + "0" + Month + "01";
			setEnd = CurrentYear + "0" + Month + "31";
		} else {
			setStart = CurrentYear + Month + "01";
			setEnd = CurrentYear + Month + "31";
		}

		// 테이블 변경
		list = RentService.getInstance().selectPerformenceTotalAndMonth(setStart, setEnd, setCancel);
		remove(adminTable);

		adminTable = new AdminPerformenceTable(list, 0);
		adminTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
				new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		adminTable.setBounds(8, 80, 587, 664);
		adminTable.loadDate();
		add(adminTable);

		// 그래프 변경
		abstractPieChart = new PerformenceTotalPieChart("성과분석", "", "", list, false);
		// 자세히 보기 차트 출력을 위한 바 차트 생성
		abstractBarChart = new PerformenceTotalBarChart("성과분석", "차종별", "최종요금", list);

		chartPanel.removeAll();
		JChartLibPanel jChart = abstractPieChart.getPieChart();
		chartPanel.add(jChart, BorderLayout.CENTER);

		revalidate();
		repaint();
	}

	// 성별 검색 조건 메소드
	private void setGenderTableAndChart(String gender) {
		// 테이블 변경
		list = RentService.getInstance().selectPerformenceGender(gender, setThisYear(true), setThisYear(false));
		remove(adminTable);

		adminTable = new AdminPerformenceTable(list, 0);
		adminTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
				new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		adminTable.setBounds(8, 80, 587, 664);
		adminTable.loadDate();
		add(adminTable);

		// 그래프 변경
		abstractPieChart = new PerformenceTotalPieChart("성과분석", "", "", list, false);
		// 자세히 보기 차트 출력을 위한 바 차트 생성
		abstractBarChart = new PerformenceTotalBarChart("성과분석", "성별", "최종요금", list);

		chartPanel.removeAll();
		JChartLibPanel jChart = abstractPieChart.getPieChart();
		chartPanel.add(jChart, BorderLayout.CENTER);

		revalidate();
		repaint();
	}

	// 차종별 검색 조건 메소드
	private void setCarModelTableAndChart(String carModel) {
		list = RentService.getInstance().selectPerformenceCarModel(carModel, setThisYear(true), setThisYear(false));
		remove(adminTable);

		adminTable = new AdminPerformenceTable(list, 1);
		adminTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
				new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		adminTable.setBounds(8, 80, 587, 664);
		adminTable.loadDate();
		add(adminTable);

		// 그래프 변경
		abstractPieChart = new PerformenceCarModelPieChart("성과분석", "", "", list, false);

		// 자세히 보기 차트 출력을 위한 바 차트 생성
		abstractBarChart = new PerformenceCarModelBarChart("성과분석", "차종별", "최종요금", list);

		chartPanel.removeAll();
		JChartLibPanel jChart = abstractPieChart.getPieChart();
		chartPanel.add(jChart, BorderLayout.CENTER);

		revalidate();
		repaint();

		// 자세히 보기 차트 프레임 미리 생성
		chartFrame = new AdminMainPerformenceChart(list, abstractBarChart, "차종");
	}

	// 제조사별 검색 조건 메소드
	private void setManufacturerTableAndChart(String manufacturer) {
		list = RentService.getInstance().selectPerformenceManufacturer(manufacturer, setThisYear(true),
				setThisYear(false));
		remove(adminTable);

		adminTable = new AdminPerformenceTable(list, 1);
		adminTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
				new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		adminTable.setBounds(8, 80, 587, 664);
		adminTable.loadDate();
		add(adminTable);

		// 그래프 변경
		abstractPieChart = new PerformenceCarModelPieChart("성과분석", "", "", list, false);

		// 자세히 보기 차트 출력을 위한 바 차트 생성
		abstractBarChart = new PerformenceCarModelBarChart("성과분석", "차종별", "최종요금", list);

		chartPanel.removeAll();
		JChartLibPanel jChart = abstractPieChart.getPieChart();
		chartPanel.add(jChart, BorderLayout.CENTER);

		revalidate();
		repaint();

		// 자세히 보기 차트 프레임 미리 생성
		chartFrame = new AdminMainPerformenceChart(list, abstractBarChart, "차종");
	}

	// 연료별 검색 조건 메소드
	private void setFuelTableAndChart(String fuel) {
		list = RentService.getInstance().selectPerformenceFuel(fuel, setThisYear(true), setThisYear(false));
		remove(adminTable);

		adminTable = new AdminPerformenceTable(list, 1);
		adminTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
				new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		adminTable.setBounds(8, 80, 587, 664);
		adminTable.loadDate();
		add(adminTable);

		// 그래프 변경
		abstractPieChart = new PerformenceCarModelPieChart("성과분석", "", "", list, false);

		// 자세히 보기 차트 출력을 위한 바 차트 생성
		abstractBarChart = new PerformenceCarModelBarChart("성과분석", "차종별", "최종요금", list);

		chartPanel.removeAll();
		JChartLibPanel jChart = abstractPieChart.getPieChart();
		chartPanel.add(jChart, BorderLayout.CENTER);

		revalidate();
		repaint();

		// 자세히 보기 차트 프레임 미리 생성
		chartFrame = new AdminMainPerformenceChart(list, abstractBarChart, "차종");
	}
}
